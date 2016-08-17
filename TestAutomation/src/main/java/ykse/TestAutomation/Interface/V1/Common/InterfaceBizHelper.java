package ykse.TestAutomation.Interface.V1.Common;

import org.apache.log4j.Logger;

import org.json.JSONObject;

import ykse.TestAutomation.Common.HttpSampler;
import ykse.TestAutomation.Common.Log;

public  class InterfaceBizHelper {
	static Logger logger = new Log("interface_v1").logger;
	 static String api = "ykse.festival.common.cinema.queryCinemas";
	 
	 public static String queryCinemas( JSONObject data ) {
		  
		  RequestData request= new RequestData();
		  request.setApi(api);
		  request.setData(data); 
		  JSONObject jsonRequst = new JSONObject();
		  jsonRequst.put("api",request.getApi());
		  jsonRequst.put("channelCode",request.getChannelCode());
		  jsonRequst.put("data",request.getData().toString());
		  jsonRequst.put("sign",request.getSign());
		  jsonRequst.put("timestamp",request.getTimestamp());
		  jsonRequst.put("v",request.getV());
		 String responseStr =  HttpSampler.sendGet("http://172.33.0.242:8080/route", jsonRequst);
		  
		  
		  
		  return responseStr;
		  
		 //boolean judge = judge(rep,object);
	  }
	
	
}
