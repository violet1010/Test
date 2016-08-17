package ykse.TestAutomation.Interface.Finixx.Common;

import java.util.UUID;

import org.json.JSONObject;
import ykse.TestAutomation.Interface.Finixx.Common.TestData;
import ykse.TestAutomation.Interface.Finixx.Common.finixxSigner;
public class CommonRequestData {
	private static String code = "";
	private static String version = "1.0.0.0";
	public static String serialNumber =""+(((System.currentTimeMillis() + 8*3600*1000)*10000)+621355968000000000L);
	private static String userName = TestData.FindValueInVariables("userName");
	private static String password = TestData.FindValueInVariables("password");
	private static String locationcd = TestData.FindValueInVariables("locationcd");
	private static String passnum ="";

	public CommonRequestData(String code,String version){
		CommonRequestData.code = code;
		CommonRequestData.version = version;
		 
	}
	
	public CommonRequestData(){

	}
	public String getcode(){
		return CommonRequestData.code;
	}

	public void setCode(String code){
		CommonRequestData.code = code;
	}
	public String getVersion(){
		return CommonRequestData.version;
	}
	public void setVersion(String version){
		CommonRequestData.version = version;
	}
	public String getSerialNumber(){
		return CommonRequestData.serialNumber;
	}
	public String getUserName(){
		return CommonRequestData.userName;
	}
	public String getPassword(){
		return CommonRequestData.password;
	}
	
	public JSONObject getRequestData(){
		JSONObject data = new JSONObject();
		data.put("code", CommonRequestData.code);
		data.put("version", CommonRequestData.version);
		data.put("serialNumber",CommonRequestData.serialNumber);
		data.put("userName",CommonRequestData.userName);
		data.put("password",CommonRequestData.password);
		data.put("locationcd",CommonRequestData.locationcd);
		return data;
	}
	
	public static JSONObject signRequestData(JSONObject data){
		String Signature = finixxSigner.sign(data);
		data.put("Signature", Signature);
		return data;
	}
}
