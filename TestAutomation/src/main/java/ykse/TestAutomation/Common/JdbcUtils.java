package ykse.TestAutomation.Common;

import java.io.IOException; 
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.Map;  

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.*;

public class JdbcUtils {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://172.33.0.190:3306/ec";
	private Connection connection;  
    private PreparedStatement pstmt;  
    private ResultSet resultSet;
    
    public JdbcUtils() {  
        // TODO Auto-generated constructor stub  
        try{  
            Class.forName(DRIVER);  
            System.out.println("数据库连接成功！");  
        }catch(Exception e){  
  
        }
    }
    
    /** 
     * 获得数据库的连接 
     * @return 
     */ 
    public Connection getConnection(){  
        try {  
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);  
        } catch (SQLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
        return connection;  
    }
    
    /** 
     * 增加、删除、改 
     * @param sql 
     * @param params 
     * @return 
     * @throws SQLException 
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */ 
    
    public boolean updateByPreparedStatement(String sql, String setData)throws SQLException, JsonParseException, JsonMappingException, IOException{  
        boolean flag = false;  
        int result = -1;
        
        ObjectMapper mapper = new ObjectMapper();
        //SecurityUtil user = mapper.readValue(setData, SecurityUtil.class);
        @SuppressWarnings("unchecked")
        //将json字符串转换称Map
        Map<String,Object> setDataMap = mapper.readValue(setData, Map.class);
        
        pstmt = connection.prepareStatement(sql); 
        int index = 1;  
        if(setDataMap != null && !setDataMap.isEmpty()){  
        	for (Object value : setDataMap.values()){  
                pstmt.setObject(index++, value);  
            }  
        }
        
        result = pstmt.executeUpdate();  
        flag = result > 0 ? true : false;  
        return flag;  
    }
    
    public static void main(String[] args) throws SQLException, JsonParseException, JsonMappingException, IOException {  
    	
    	JdbcUtils jdbcUtils = new JdbcUtils();  
        jdbcUtils.getConnection();
        
        /*******************增*********************/  
        String sql = "insert into cif.cif_third_account (third_type, third_account_id, account_id, status, is_old, gmt_create, gmt_modified, extension) values (?, ?, ?, ?, ?, ?, ?, ?)"; 
        String  json = "{\"thirdType\":\"mobile\", \"thirdAccountId\":\"18665778714\", \"accountId\":\"0000008000000014\", \"status\":\"0\", \"isOld\":\"N\", \"gmtCreate\":\"2016-04-06 15:47:32\",\"gmtModified\":\"2016-04-06 15:47:32\",\"extension\":null}";
        
        /*
        //将json字符串转换称java对象
        ObjectMapper mapper = new ObjectMapper();
        SecurityUtil user = mapper.readValue(json, SecurityUtil.class);
        @SuppressWarnings("unchecked")
        //将json字符串转换称Map
        Map<String,Object> userData = mapper.readValue(json, Map.class);
        */
        
        try { 
            boolean flag = jdbcUtils.updateByPreparedStatement(sql, json); 
            System.out.println(flag); 
        } catch (SQLException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }
       
        
    }
}

