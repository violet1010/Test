package ykse.TestAutomation.Interface.V1.Common;
import org.json.JSONObject;
public class RequestData {
	

	private String api = "";
	private String channelCode = "BO";
	private JSONObject data = new JSONObject();
	public String sid ="";
	private String sign = "";
	private String timestamp = System.currentTimeMillis()+"";
	private String v = "1.0";
	private String appVersion = "2.9.102";
	private String channelPassword ="D41D8CD98F00B204E9800998ECF8427E";

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
	
	public String getSign(){
		String signapi="api"+api;
		String signchannelCode="channelCode"+channelCode;
		String signdata="data"+data.toString();
		String signtime="timestamp"+timestamp;
		String signv="v"+v;
		String signstr=signapi+signchannelCode+signdata+signtime+signv+channelPassword;
		sign= Sign.getMd5Code(signstr);	  
		return this.sign;
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
