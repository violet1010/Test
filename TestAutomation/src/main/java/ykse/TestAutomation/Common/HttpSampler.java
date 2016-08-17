package ykse.TestAutomation.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.json.*;
import ykse.TestAutomation.Common.*;

public class HttpSampler {
	
	static Logger logger = new Log("interface_Finixx").logger;

	public static String sendGet(String url, JSONObject param) {

		String result = "";
		String paramStr = "";
		BufferedReader in = null;
		try {
			Iterator<String> it = param.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				String value = param.get(key).toString();
				key = URLEncoder.encode(key, "utf-8");
				value = URLEncoder.encode(value, "utf-8");
				paramStr = paramStr + key + "=" + value + "&";
			}
			if (paramStr != null) {
				paramStr = paramStr.substring(0, paramStr.length() - 1);
			}

			String urlNameString = url + "?" + paramStr;
			URL realUrl = new URL(urlNameString);
			
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "testDemo");
			Map<String, List<String>> reqHeardMap = connection.getRequestProperties();
			logger.debug("请求包头:");
			result = "\r\n";
			for (String key : reqHeardMap.keySet()) {

				List<String> heardValue = reqHeardMap.get(key);
				String Value = heardValue.get(0);
				if (key == null)
					key = "";
				result = result + key + ":" + Value + "\r\n";
			}
			logger.debug(result);
			result = "";
			// 建立实际的连接
			connection.connect();
			logger.debug("请求包体:");
			urlNameString = URLDecoder.decode(urlNameString, "utf-8");
			logger.debug(urlNameString);
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			logger.debug("返回包头:");
			for (String key : map.keySet()) {

				List<String> heardValue = map.get(key);
				String Value = heardValue.get(0);
				if (key == null)
					key = "";
				result = result + key + ":" + Value + "\r\n";
			}
			logger.debug(result);
			result = "";

			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.debug("返回包体:");
			logger.debug(result);
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}

	public static String sendPost(String url, JSONObject param) throws UnsupportedEncodingException {
		 String result = "";
		 String paramStr = "";
		  PrintWriter out = null;
	        BufferedReader in = null;
	     
	        	Iterator<String> it = param.keys();  
	            while (it.hasNext()) { 
	            	 String key = (String) it.next();  
	                 String value = param.getString(key);
	                 key = URLEncoder.encode(key, "utf-8");
	 				value = URLEncoder.encode(value, "utf-8");
	 				if(!key.toString().equals(""))
	                 paramStr = paramStr+key+"="+value+"&";
	 				else
	 					paramStr = paramStr+key+value+"&";
	            }
	            if(paramStr!= null){
	            	paramStr=paramStr.substring(0,paramStr.length()-1);
	            	}
	            paramStr = URLDecoder.decode(paramStr, "utf-8");
	           
	        return sendPost(url, paramStr);
	    }
	
	
	public static String sendPost(String url, String param) {
		String charSet = "GB2312";
		
		return sendPost(url, param,charSet);
	    }
	
	public static String sendPost(String url, String param,String charSet) {
		 String result = "";
		 String paramStr = "";
		  PrintWriter out = null;
	        BufferedReader in = null;
	        
	   try{
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setConnectTimeout(30000);
	            conn.setReadTimeout(30000);
	            conn.setRequestProperty("accept", "*/*");
	           // conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8;");
	            conn.setRequestProperty("Content-Type", "application/json;charset="+charSet);
	            
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "testDemoPost");
	            Map<String, List<String>> reqHeardMap = conn.getRequestProperties();
	            
	            logger.debug("请求包头:");
	            result = "\r\n";
				for (String key : reqHeardMap.keySet()) {

					List<String> heardValue = reqHeardMap.get(key);
					String Value = heardValue.get(0);
					if (key == null)
						key = "";
					result = result + key + ":" + Value + "\r\n";
				}
				logger.debug(result);
				result = "";
				
				logger.debug("请求包体:");
				//paramStr = URLEncoder.encode(param, "utf-8");
				paramStr = param;
				logger.debug(url+"\r\n"+paramStr);
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);

	           
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),charSet));
	            
	           
	            // 发送请求参数
	            out.print(paramStr);
	            // flush输出流的缓冲
	            out.flush();
	            Map<String, List<String>> map = conn.getHeaderFields();
	            logger.debug("返回包头:");
	            String charset = "utf-8";
				for (String key : map.keySet()) {

					List<String> heardValue = map.get(key);
					String Value = heardValue.get(0);
					if (key == null)
						key = "";
					result = result + key + ":" + Value + "\r\n";
					if(Value.contains("charset"))
					{
						charset = Value.split("charset=")[1].split(";")[0];
					}
				}
				
				logger.debug(result);
				result = "";
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream(),charset));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        logger.debug("返回包体:");
	        
					logger.debug(result);
					
			
		
	        return result;
	    }
	
	
	 
	
}
