package ykse.TestAutomation.Interface.V2.Common;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import org.testng.Assert;
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
	public static String getTime()
	{
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
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
            String value = addjsonObj.getString(key);			
			defaultjsonobj.put(key,value);
        }
		return defaultjsonobj;
	}
	
	public static String getResult(String res)
	{
		JSONObject jsonRes = new JSONObject(res);
		String result = "";
		if(jsonRes.has("retCode"))
		{
			result = jsonRes.get("retCode").toString();
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
				films.put("showTime", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("showTimeInt").toString());
				films.put("throughFlg", jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("throughFlg").toString());
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
		ArrayList<String> resList = new ArrayList<String>();
		int size =jsonRes.asObject().get("cardOrdersList").asArray().size();
		if(size > 0)
		{
			result = jsonRes.asObject().get("cardOrdersList").asArray().get(size-1).asString();

		}
		return result;
	}
	
	public static String getcinemaLinkId(String res)
	{
		String result = "";
		JsonValue jsonRes= Json.parse(res);
        JsonArray jsonArray = jsonRes.asObject().get("data").asObject().get("dataList").asArray();
		int size = jsonArray.size();
		if(size > 0)
		{
			result = jsonArray.get(0).asObject().get("cinemaLinkId").asString();
		}
		System.out.println(result);
		return result;
	}
	//排期信息
	public static JSONObject getschedule(String res)
	{
		JSONObject result = new JSONObject();
		JsonValue jsonRes= Json.parse(res);
		int size =jsonRes.asObject().get("data").asObject().get("dataList").asArray().size();
		if(size > 0)
		{
            JsonObject jsonObject = jsonRes.asObject().get("data").asObject().get("dataList").asArray().get(size-1).asObject();
			result.put("cinemaLinkId", jsonObject.get("cinemaLinkId").asString());
			result.put("hallId",jsonObject.get("hallId").asString());
			result.put("scheduleId",jsonObject.get("scheduleId").asString());
			result.put("scheduleKey",jsonObject.get("scheduleKey").asString());
			result.put("settlePrice",jsonObject.get("settlePrice").asString());
			result.put("ticketFee",jsonObject.get("ticketFee").asString());
		}
		return result;
	}

    //排期信息
    public static ArrayList<JSONObject> getschedule(String res, int count)
    {
        Assert.assertNotNull(res);
        ArrayList<JSONObject>  scheduleTwo =new ArrayList<JSONObject>();
        JsonValue jsonRes= Json.parse(res);

        JsonArray scheduleArray = jsonRes.asObject().get("data").asObject().get("dataList").asArray();
        //Assert.assertTrue(scheduleArray.size() > count, "服务端没有返回排期信息");

        for(int i=0;i<count;i++){
            JsonObject jsonObject = scheduleArray.get(i).asObject();

            JSONObject result = new JSONObject();
            result.put("cinemaLinkId", jsonObject.get("cinemaLinkId").asString());
            result.put("hallId",jsonObject.get("hallId").asString());
            result.put("scheduleId",jsonObject.get("scheduleId").asString());
                try {
                    result.put("scheduleKey",jsonObject.get("scheduleKey").asString());
                    result.put("settlePrice",jsonObject.getString("settlePrice", ""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            result.put("ticketFee",jsonObject.get("ticketFee").asString());
            scheduleTwo.add(result);
        }
        return scheduleTwo;
    }
	
	public static String getsectionId(String res)
	{
		String result ="";
		JsonValue jsonRes= Json.parse(res);
		int size1 = jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().size();
		int size2 =jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(0).asObject().get("sections").asArray().size();
		if(size1 > 0 && size2>0)
		{
			result = jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(size1-1).asObject().get("sections").asArray().get(size2-1).asObject().get("sectionId").asString();
		}
		return result;
	}
	
	public static ArrayList getseatIdList(String res)
	{
		ArrayList<String> result =new ArrayList<String>();
		ArrayList<String> seatIdList =new ArrayList<String>();
		JsonValue jsonRes= Json.parse(res);
		int seatPlanListsize = jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().size();
		int sectionssize =jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().size();
		int seatssize =jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().get(sectionssize-1).asObject().get("seats").asArray().size();
		for(int i=0; i<seatssize; i++)
			{
				result.add(jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().get(sectionssize-1).asObject().get("seats").asArray().get(i).asObject().get("seatId").asString());
			}
		Random rand = new Random();
	    int index = rand.nextInt(result.size());
	    seatIdList.add(result.get(index));
		return seatIdList;
	}

    public static ArrayList getseatIdList(String res, int count)
    {
        ArrayList<String> result =new ArrayList<String>();
        ArrayList<String> seatIdList =new ArrayList<String>();
        JsonValue jsonRes= Json.parse(res);
        int seatPlanListsize = jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().size();
        int sectionssize =jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().size();
        int seatssize =jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().get(sectionssize-1).asObject().get("seats").asArray().size();
        for(int i=0; i<seatssize; i++)
        {
            result.add(jsonRes.asObject().get("data").asObject().get("data").asObject().get("seatPlanList").asArray().get(seatPlanListsize-1).asObject().get("sections").asArray().get(sectionssize-1).asObject().get("seats").asArray().get(i).asObject().get("seatId").asString());
        }

        for(int j=0;j<count;j++){
          seatIdList.add(result.get(j));
        }

        return seatIdList;

    }
	
	public static String getlockOrderId(String res)
	{
		String result ="";
		JsonValue jsonRes= Json.parse(res);
		result = jsonRes.asObject().get("data").asObject().get("data").asObject().get("lockOrderId").asString();
		return result;
	}
	
	public static String getorderId(String res)
	{
		String result ="";
		JsonValue jsonRes= Json.parse(res);
		result = jsonRes.asObject().get("data").asObject().get("data").asObject().get("orderId").asString();
		return result;
	}
	
	public static String getconfirmationId(String res)
	{
		String result ="";
		JsonValue jsonRes= Json.parse(res);
		result = jsonRes.asObject().get("data").asObject().get("data").asObject().get("confirmationId").asString();
		return result;
	}
	
	public static String getprintId(String res)
	{
		String result ="";
		JsonValue jsonRes= Json.parse(res);
		result = jsonRes.asObject().get("data").asObject().get("data").asObject().get("printId").asString();
		return result;
	}
	
	public static JSONObject getgoods(String res)
	{
		JSONObject result = new JSONObject();
		JsonValue jsonRes= Json.parse(res);
		int size = jsonRes.asObject().get("data").asObject().get("data").asObject().get("goodsList").asArray().size();
		for(int i=0;i<size;i++)
		result.put("goodsId", jsonRes.asObject().get("data").asObject().get("data").asObject().get("goodsList").asArray().get(size-1).asObject().get("goodsId").asString());
		result.put("settlePrice", jsonRes.asObject().get("data").asObject().get("data").asObject().get("goodsList").asArray().get(size-1).asObject().get("settlePrice").asString());
		result.put("isPackage", jsonRes.asObject().get("data").asObject().get("data").asObject().get("goodsList").asArray().get(size-1).asObject().get("isPackage").asBoolean());
		return result;
	}
}
