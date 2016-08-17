package ykse.TestAutomation.Interface.OWN.Common;

import org.json.JSONObject;

public class InterfaceOwnReadResponse {

	public static String bizCode(String response){
		
		JSONObject rp = new JSONObject(response);
		String bizCode = rp.getJSONObject("data").getString("bizCode");
		return bizCode;
	}
	
	public static String sid(String response){
		
		JSONObject rp = new JSONObject(response);
		String sid = rp.getJSONObject("data").getJSONObject("bizValue").getString("sid");
		return sid;
	}
	
	

}
