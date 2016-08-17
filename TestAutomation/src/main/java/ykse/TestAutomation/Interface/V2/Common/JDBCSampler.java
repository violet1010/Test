package ykse.TestAutomation.Interface.V2.Common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.ResultSetMetaData;

import ykse.TestAutomation.Common.Log;

public class JDBCSampler {
	static Logger logger = new Log("interface_Finixx").logger;
    String driver = "com.mysql.jdbc.Driver";  
    static String url = TestData.FindValueInVariables("mysqlUrl"); 
    static String user = TestData.FindValueInVariables("mysqluser"); 
    static String password = TestData.FindValueInVariables("mysqlpassword"); 
    static ResultSet rs;
    static Connection conn;
    static PreparedStatement pstmt;  
	public JDBCSampler() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			logger.warn("连接数据库失败");
			e.printStackTrace();
		}
	}
	
	public static ResultSet JdbcSelect(String sql)
	{
		logger.warn(sql);
		try {
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
			{
				Statement statement = conn.createStatement(); 
				rs = statement.executeQuery(sql);
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();   
				String result = "\n";
				int columnCount = rsmd.getColumnCount();
				for (int i=1; i<=columnCount; i++){ 
					result = result + rsmd.getColumnName(i) + "	";
				}
				result = result  + "\n";
				while(rs.next())
				{
					for (int i=1; i<=columnCount; i++){  
						result = result + rs.getString(i) + "	";
			         }  
					result = result  + "\n";
				}
				logger.warn("查询结果：");
				logger.warn(result);
				return rs;
			}
			else
			{
				logger.warn("连接数据库失败");
			}
			rs.close();  
	        conn.close(); 
		} 
		catch (SQLException e) {
			logger.warn("执行查询语句出现异常");
			e.printStackTrace();
		}
		return null; 
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Map> JdbcSelectForList(String sql)
	{
		logger.warn(sql);
		ArrayList<Map> list = new ArrayList<Map>();  
		Map<String, Object> rsTree;
		try {
			conn = DriverManager.getConnection(url, user, password);
			if(!conn.isClosed())
			{
				Statement statement = conn.createStatement(); 
				rs = statement.executeQuery(sql);
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();   
				int columnCount = rsmd.getColumnCount();
				while(rs.next())
				{
					rsTree = new HashMap<String, Object>(columnCount);
					for (int i=1; i<=columnCount; i++){  
						rsTree.put(rsmd.getColumnName(i),rs.getObject(i)); 
			         }  
					list.add(rsTree);
				}
				logger.warn("查询结果：");
				logger.warn(list.toString());
				return list;
			}
			else
			{
				logger.warn("连接数据库失败");
			}
			rs.close();  
	        conn.close(); 
		} 
		catch (SQLException e) {
			logger.warn("执行查询语句出现异常");
			e.printStackTrace();
		}
		return list; 
	}
	
	@SuppressWarnings("unchecked")
	public static Boolean JdbcInsertByJson(String sql,JSONObject data)
	{
		logger.warn(sql);
		logger.warn(data.toString());
        boolean state = false;  
        int result = -1;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> setDataMap;
			setDataMap = mapper.readValue(data.toString(), Map.class);
	        pstmt = conn.prepareStatement(sql); 
	        int index = 1;  
	        if(setDataMap != null && !setDataMap.isEmpty()){  
	        	for (Object value : setDataMap.values()){  
	                pstmt.setObject(index++, value);  
	            }  
	        }
	        result = pstmt.executeUpdate();  
	        if(result > 0)
	        {
	        	logger.warn("影响行数为:"+result);
	        	state = true;
	        	return state;	
	        }
		} catch (JsonParseException e) {
			logger.warn("连接数据库异常");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			logger.warn("连接数据库异常");
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("连接数据库异常");
			e.printStackTrace();
		} catch (SQLException e) {
			logger.warn("数据插入失败：SQL异常");
			e.printStackTrace();
		}
        return state;  
	}
	
	public static Boolean JdbcUpdate(String sql)
	{
		logger.warn(sql);
		boolean State = false;
		try {
			conn = DriverManager.getConnection(url, user, password);
			int result = 0;
			if(!conn.isClosed())
			{
				Statement statement = conn.createStatement(); 
				result = statement.executeUpdate(sql);
			}
			else
			{
				logger.warn("连接数据库失败");
			}
			rs.close();  
	        conn.close(); 
	        if (result >= 1)
	        {
	        	logger.warn("影响行数为:"+result);
	        	State = true;
	        	return State;
	        }
	        
		} 
		catch (SQLException e) {
			logger.warn("执行查询语句出现异常");
			e.printStackTrace();
		}
		return State; 
	}
	
	public static Boolean JdbcInsert(String sql)
	{
		logger.warn(sql);
		boolean State = false;
		try {
			conn = DriverManager.getConnection(url, user, password);
			int result = 0;
			if(!conn.isClosed())
			{
				Statement statement = conn.createStatement(); 
				result = statement.executeUpdate(sql);
			}
			else
			{
				logger.warn("连接数据库失败");
			}
			rs.close();  
	        conn.close(); 
	        if (result > 0)
	        {
	        	logger.warn("影响行数为:"+result);
	        	State = true;
	        	return State;
	        }
		} 
		catch (SQLException e) {
			logger.warn("执行查询语句出现异常");
			e.printStackTrace();
		}
		return State; 
	}
	
	
 
	public static void main(String[] args) throws SQLException, JsonParseException, JsonMappingException, IOException{  
		//select
        String sql = "select * from test";
        ResultSet rs = JDBCSampler.JdbcSelect(sql);  
        while(rs.next()) {  
        	System.out.println(rs.getString("f1"));  
        } 
        //select for list
        String JdbcSelectForList = "select * from test";
        ArrayList<?> list = JDBCSampler.JdbcSelectForList(JdbcSelectForList);  
        System.out.println(list.toString());     
        //insert
        String sqlinert = "insert into test(f1,f2)values('dd','ddd')";
        boolean insetstate = JDBCSampler.JdbcInsert(sqlinert);
        System.out.println(""+insetstate);  
        
        //update
        String sqlupdate = "update test set f2 = 'update' where f1 = 'dd'";
        boolean updatestate = JDBCSampler.JdbcUpdate(sqlupdate);
        System.out.println(""+updatestate);  
        
        //insert by json
        String insertbyjsonsql = "insert into test(f1,f2)values(?,?)";
        JSONObject data = new JSONObject();
        data.put("f1", "json");
        data.put("f2", "json2");
        boolean insertjson = JDBCSampler.JdbcInsertByJson(insertbyjsonsql,data);
        System.out.println(""+insertjson);  
	}
}

