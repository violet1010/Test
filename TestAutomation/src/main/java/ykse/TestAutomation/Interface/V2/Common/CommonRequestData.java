package ykse.TestAutomation.Interface.V2.Common;
import org.json.JSONObject;
public class CommonRequestData {
	

	private static String api = "";
	private static String channelCode = "TAOBAO";
	private static JSONObject data = new JSONObject();
	public  static String sid ="";
	private static String sign = "";
	private static String timestamp = System.currentTimeMillis()+"";
	private static String v = "1.0";
	private static String appVersion = "2.9.102";
	private static String channelPassword ="21218CCA77804D2BA1922C33E0151105";

 	public CommonRequestData(String api,JSONObject data){
		CommonRequestData.api = api;
		CommonRequestData.data = data;
	}
	
	public CommonRequestData(){
		
	}

	public void setApi(String api){
		CommonRequestData.api=api;
	}
	
	public String getApi(){
		return CommonRequestData.api;
	}
	
	public void setChannelCode(String channelCode){
		CommonRequestData.channelCode=channelCode;
	}
	
	public String getChannelCode(){
		return CommonRequestData.channelCode;
	}
	
	public void setData(JSONObject data){
		CommonRequestData.data=data;
	}
	
	public JSONObject getData(){
		return CommonRequestData.data;
	}
	
	public void setSid(String sid){
		CommonRequestData.sid=sid;
	}
	
	public String getSid(){
		return CommonRequestData.sid;
	}
	

	public void setTimestamp(String timestamp){
		CommonRequestData.timestamp=timestamp;
	}
	
	public String getTimestamp(){
		return CommonRequestData.timestamp;
	}
	
	public void setV(String v){
		CommonRequestData.v=v;
	}
	
	public String getV(){
		return CommonRequestData.v;
	}
	
	public void setAppVersion(String appVersion){
		CommonRequestData.appVersion=appVersion;
	}
	
	public String getAppVersion(){
		return CommonRequestData.appVersion;
	}

	public void setChannelPassword(String channelPassword){
		CommonRequestData.channelPassword=channelPassword;
	}
	
	public String getChannelPassword(){
		return CommonRequestData.channelPassword;
	}
	
	public String getSign(){
		String signapi="api"+CommonRequestData.api;
		String signchannelCode="channelCode"+CommonRequestData.channelCode;
		String signdata="data"+CommonRequestData.data.toString();
		String signtime="timestamp"+CommonRequestData.timestamp;
		String signv="v"+CommonRequestData.v;
		String singappVersion = "appVersion" + CommonRequestData.appVersion;
		String signstr=signapi + singappVersion + signchannelCode + signdata + signtime + signv + CommonRequestData.channelPassword;
		return Sign.getMd5Code(signstr);
	}
	
	public JSONObject getRequestData()
	{
		JSONObject requestData = new JSONObject();
		requestData.put("api",CommonRequestData.api);
		requestData.put("v",CommonRequestData.v);
		requestData.put("appVersion",CommonRequestData.appVersion);
		requestData.put("channelCode",CommonRequestData.channelCode);
		requestData.put("timestamp",CommonRequestData.timestamp);
		requestData.put("sign",getSign());
		requestData.put("data",CommonRequestData.data);
		return requestData;
	}
}
