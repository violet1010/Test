package ykse.TestAutomation.Interface.OWN.Common;

import org.json.JSONObject;
import org.apache.log4j.Logger;

import ykse.TestAutomation.Common.Log;

public class CommonRequestData {
	
	Logger logger = new Log("interface_own").logger;
	
	private String api = "";
	private String channelCode = "API_APP_ANDROID_TEST";
	private JSONObject data = new JSONObject();
	public String sid ="";
	private String sign = "";
	private String timestamp = System.currentTimeMillis()+"";
	private String v = "1.0";
	private String appVersion = "2.9.102";
	private String channelPassword ="21218CCA77804D2BA1922C33E0151105";

	public void setApi(String api){
		this.api=api;
	}
	
	public String getApi(){
		return this.api;
	}
	
	public void setChannelCode(String channelCode){
		this.channelCode=channelCode;
	}
	
	public String getChannelCode(){
		return this.channelCode;
	}
	
	public void setData(JSONObject data){
		this.data=data;
	}
	
	public JSONObject getData(){
		return this.data;
	}
	
	public void setSid(String sid){
		this.sid=sid;
	}
	
	public String getSid(){
		return this.sid;
	}
	
	public String getSign(JSONObject parameterRequest,String sid){
		String signstr=null;
		String signapi="api"+api;
		String signchannelCode="channelCode"+channelCode;
		String signappVersion="appVersion"+appVersion;
		String signdata="data"+parameterRequest.toString();
		String signtime="timestamp"+timestamp;
		String signv="v"+v;
		if (sid != null){
			signstr=signapi+signappVersion+signchannelCode+signdata+"sid"+sid+signtime+signv+channelPassword;
			logger.info("signstr：" + signstr);
		}else{
			signstr=signapi+signappVersion+signchannelCode+signdata+signtime+signv+channelPassword;
			logger.info("signstr：" + signstr);
		}
		sign= Sign.getMd5Code(signstr);
		return this.sign;
	}
	
	public JSONObject gatewayRequest(){
		//网关默认入参
		JSONObject gatewayRequest = new JSONObject();
		gatewayRequest.put("channelCode",channelCode);
		gatewayRequest.put("appVersion",appVersion);
		gatewayRequest.put("timestamp",timestamp);
		gatewayRequest.put("v",v);
		gatewayRequest.put("api",api);
		return gatewayRequest;
		
	}
	
	public void setTimestamp(String timestamp){
		this.timestamp=timestamp;
	}
	
	public String getTimestamp(){
		return this.timestamp;
	}
	
	public void setV(String v){
		this.v=v;
	}
	
	public String getV(){
		return this.v;
	}
	
	public void setAppVersion(String appVersion){
		this.appVersion=appVersion;
	}
	
	public String getAppVersion(){
		return this.appVersion;
	}

	public void setChannelPassword(String channelPassword){
		this.channelPassword=channelPassword;
	}
	
	public String getChannelPassword(){
		return this.channelPassword;
	}
}
