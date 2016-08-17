package ykse.TestAutomation.Interface.Finixx.Common;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import org.json.JSONObject;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

public class CommonUntil {
	public static String getToday()
	{
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today=dateFormat.format(now);
		return today;
	}
	public static String getPassNum()
	{
		String s = UUID.randomUUID().toString();
		String passnum = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
		return passnum;
	}	
	 

	public static JSONObject JoinJsonObject(JSONObject defaultjsonobj,JSONObject addjsonObj)
	{
		Iterator<String> iter = addjsonObj.keys();
		while(iter.hasNext()){
            String key = (String)iter.next();
            Object value = addjsonObj.get(key);			
			defaultjsonobj.put(key,value);
        }
		return defaultjsonobj;
	}
	
	public static String getResult(String res)
	{
		JSONObject jsonRes = new JSONObject(res);
		String result = "";
		if(jsonRes.has("result"))
		{
			result = jsonRes.get("result").toString();
		}
		return result;
	}
	
	public static String getSessionCodeByRespose(String res)
	{
		String result = "";
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		if(jsonRes.asObject().get("sessions").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
			{
				resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
			System.out.println(resList.get(index));
		}
		return result;
	}
	
	public static String getSessionFilm(String res)
	{
		String result = "";
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		if(jsonRes.asObject().get("sessions").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
			{
				resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("filmCd").asString());
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}

	public static JSONObject getFilmInformation(String res)
	{
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("sessions").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
			{
				JSONObject films = new JSONObject();
				films.put("showDate", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("showDate").asString());
				films.put("showTime", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("showTimeInt"));
				films.put("filmCd", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("filmCd").asString());
				films.put("cinemaCd", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("cinemaCd").asString());
				films.put("sectionId", "");
				resList.add(films);
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	public static JSONObject getFilmDateAndCinemaCD(String res)
	{
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("sessions").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
			{
				JSONObject films = new JSONObject();
				films.put("showRefSeqNo", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("refSeqNo").asString());
				films.put("SeqNo", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("seqNo").asString());
				films.put("showTime", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("showTimeInt"));
				films.put("throughFlg", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("throughFlg"));
				films.put("showDate", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("showDate").asString());
				films.put("cinemaCd", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("cinemaCd").asString());
				films.put("filmCd", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("filmCd").asString());
				films.put("locationCd", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("locationCd").asString());
				films.put("sessionCode", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
				resList.add(films);
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	public static JSONObject GetSessionId(String res)
	{
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("sections").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("sections").asArray().size();i++)
			{
				JSONObject films = new JSONObject();
				films.put("sectionID", jsonRes.asObject().get("sections").asArray().get(i).asObject().get("sectionID").asString());
				resList.add(films);
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	public static JSONObject GetRepositionSeats(String res) {
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("seatPlans").asArray().size() > 0)
		{
			if(jsonRes.asObject().get("seatPlans").asArray().size()>0){
				for(int i = 0;i < jsonRes.asObject().get("seatPlans").asArray().size();i++)
				{
					for(int j = 0;j < jsonRes.asObject().get("seatPlans").asArray().get(i).asObject().get("seats").asArray().size();j++)
					{
						JSONObject films = new JSONObject();
						films.put("sectionId", jsonRes.asObject().get("seatPlans").asArray().get(i).asObject().get("sectionId").asString());
						films.put("rowId", jsonRes.asObject().get("seatPlans").asArray().get(i).asObject().get("seats").asArray().get(j).asObject().get("rowId").asString());
						films.put("colId", jsonRes.asObject().get("seatPlans").asArray().get(i).asObject().get("seats").asArray().get(j).asObject().get("colId").asString());
						films.put("seatCode", jsonRes.asObject().get("seatPlans").asArray().get(i).asObject().get("seats").asArray().get(j).asObject().get("seatCode").asString());
						resList.add(films);
					}
				}
				Random rand = new Random();
			    int index = rand.nextInt(resList.size());
			    result = resList.get(index);
			}
		}
		return result;
	}

	public static JSONObject GetReleaseSeats(String res) {
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("seats").asArray().size() > 0)
		{
			if(jsonRes.asObject().get("seats").asArray().size()>0){
				for(int i = 0;i < jsonRes.asObject().get("seats").asArray().size();i++)
				{
					JSONObject Seats = new JSONObject();
					Seats.put("rowId", jsonRes.asObject().get("seats").asArray().get(i).asObject().get("rowId").asString());
					Seats.put("colId", jsonRes.asObject().get("seats").asArray().get(i).asObject().get("colId").asString());
					Seats.put("requestUserId", jsonRes.asObject().get("seats").asArray().get(i).asObject().get("createUserId").asString());
					Seats.put("tempBookingId", jsonRes.asObject().get("tempBookingId").asString());
					Seats.put("boBlock", jsonRes.asObject().get("seats").asArray().get(i).asObject().get("boLockSeat").toString());
					Seats.put("requestWorkStationId", jsonRes.asObject().get("seats").asArray().get(i).asObject().get("workSationId").asString());
					resList.add(Seats);
				}
				Random rand = new Random();
			    int index = rand.nextInt(resList.size());
			    result = resList.get(index);
			}
		}
		return result;
	}
	
	public static String getCardOrder(String res)
	{
		String result = "";
		JsonValue jsonRes= Json.parse(res);
		int size =jsonRes.asObject().get("cardOrdersList").asArray().size();
		if(size > 0)
		{
			result = jsonRes.asObject().get("cardOrdersList").asArray().get(size-1).asString();

		}
		return result;
	}
	
	public static String getfacadeCD(String res)
	{
		String result = "" ;
		JsonValue jsonRes= Json.parse(res);
		int size =jsonRes.asObject().get("CardOrdersByOrderCD").asArray().size();
		if(size > 0)
		{
			result = jsonRes.asObject().get("CardOrdersByOrderCD").asArray().get(0).asString();
		}
		return result;
	}
	
	public static String getPrefabicatefacadeCD(String res)
	{
		String result = "" ;
		JsonValue jsonRes= Json.parse(res);
		result =jsonRes.asObject().get("facadeCD").asString();
		return result;
	}
	
	public static String getEventsno(String res)
	{
		String result = "" ;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		if(jsonRes.asObject().get("cardEvents").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("cardEvents").asArray().size();i++)
			{
				resList.add(jsonRes.asObject().get("cardEvents").asArray().get(i).asObject().get("ercNo").asString());
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	public static String getWalletseqID(String res)
	{
		String result = "" ;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		if(jsonRes.asObject().get("queryWalletInfoList").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("queryWalletInfoList").asArray().size();i++)
			{
				resList.add(jsonRes.asObject().get("queryWalletInfoList").asArray().get(i).asObject().get("seqID").asString());
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	public static JSONObject GetCardInfo(String res) {
		JsonValue jsonRes= Json.parse(res);
		JSONObject CardInfo = new JSONObject();
		CardInfo.put("facadeCD", jsonRes.asObject().get("memberCard").asObject().get("facadeCD").asString());
		CardInfo.put("balance", jsonRes.asObject().get("memberCard").asObject().get("balance").asDouble());
		CardInfo.put("tradeMarking", jsonRes.asObject().get("memberCard").asObject().get("tradeMarking").asDouble());
		CardInfo.put("upgradeMarking", jsonRes.asObject().get("memberCard").asObject().get("upgradeMarking").asDouble());
		CardInfo.put("cumulationMarking", jsonRes.asObject().get("memberCard").asObject().get("cumulationMarking").asDouble());
		return CardInfo;
	}
	//
	public static JSONObject GetGoodsBigKindclass_id(String res)
	{
		JSONObject result = null;
		JsonValue jsonRes= Json.parse(res);
		ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
		if(jsonRes.asObject().get("PosBigClassResponseNods").asArray().size() > 0)
		{
			for(int i = 0;i < jsonRes.asObject().get("PosBigClassResponseNods").asArray().size();i++)
			{
				JSONObject films = new JSONObject();
				films.put("class_id", jsonRes.asObject().get("PosBigClassResponseNods").asArray().get(i).asObject().get("class_id").asString());
				resList.add(films);
			}
			Random rand = new Random();
			int index = rand.nextInt(resList.size());
			result = resList.get(index);
		}
		return result;
	}
	
	
	
	public static String GetResellFacadeCD(String res) {
		JsonValue jsonRes= Json.parse(res);
		String facadecd = null;
		facadecd = jsonRes.asObject().get("facadeCD").asString();
		return facadecd;
	}
	
	public static String GetsellFacadeCD(String res) {
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> facadecds = new ArrayList<String>();
		String facadecd = null;
		for(int i=0 ; i<jsonRes.asObject().get("cardSellResult").asArray().size();i++){
			facadecds.add(jsonRes.asObject().get("cardSellResult").asArray().get(i).asObject().get("facadeCD").asString());
		}
		facadecd = facadecds.get(0);
		return facadecd;
	}
	
}
