package ykse.TestAutomation.Interface.OWN.Common;

/*
import java.util.HashMap;
import org.apache.log4j.Logger;
import ykse.TestAutomation.Common.Log;
*/

import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import ykse.TestAutomation.Interface.OWN.Common.InterFaceOwnData;

public class InterFaceOwnGetValueForOther {
	
	public static String getLoginValue(String key){
		//暂只支持返回tid和sid
		JSONObject rp =  new JSONObject(InterFaceOwnData.securityLogin());
		String value = rp.getJSONObject("data").getJSONObject("bizValue").getString(key);
		return value;
	}
	
	public static String getSoonFilmsValue(int index,String key){
		//根据索引获取影片id
		JSONObject rp =  new JSONObject(InterFaceOwnData.getSoonFilmsPosterSizeLarge());
		String value = rp.getJSONObject("data").getJSONArray("bizValue").getJSONObject(index).getString(key);
		return value;
	}
	
	public static String getHotFilmsValue(int index,String key){
		//根据索引获取影片id
		JSONObject rp =  new JSONObject(InterFaceOwnData.getHotFilmsPosterSizeSmall());
		String value = rp.getJSONObject("data").getJSONArray("bizValue").getJSONObject(index).getString(key);
		return value;
	}
	
	public static String getCinemasValue(int index,String key){
		//根据索引获取影院cinemaLinkId
		JSONObject rp =  new JSONObject(InterFaceOwnData.getCinemas());
		String value = rp.getJSONObject("data").getJSONArray("bizValue").getJSONObject(index).getString(key);
		return value;
	}
	
	public static String getSchedulesValue(String cinemaLinkId,int index,String keys,String key){
		//根据索引获取影片id
		JSONObject rp =  new JSONObject(InterFaceOwnData.getSchedules(cinemaLinkId));
		String value = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray(keys).getJSONObject(index).getString(key);
		return value;
	}
	
	public static JSONObject getSchedulesValue(String cinemaLinkId,String films,int filmsIndex,String dates,int datesIndex,String schedules,int schedulesIndex){
		//根据索引获取场次信息
		
		JSONObject rp =  new JSONObject(InterFaceOwnData.getSchedules(cinemaLinkId));
		JSONObject schedule = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray(films).getJSONObject(filmsIndex).getJSONArray(dates)
				.getJSONObject(datesIndex).getJSONArray(schedules).getJSONObject(schedulesIndex);
		JSONObject values = new JSONObject();
		String hallId = schedule.getString("hallId");
		String scheduleId = schedule.getString("scheduleId");
		String scheduleKey = schedule.getString("scheduleKey");
		values.put("hallId", hallId);
		values.put("scheduleId", scheduleId);
		values.put("scheduleKey", scheduleKey);
		
		return values;
	}
	
	public static JSONArray getSeatMapValue(String cinemaLinkId,JSONObject valueHss){
		//获取场次所有座位
		JSONObject seatMap =  new JSONObject(InterFaceOwnData.getSeatMap(cinemaLinkId,valueHss));
		JSONArray seatArray = seatMap.getJSONObject("data").getJSONObject("bizValue").getJSONArray("sections").getJSONObject(0).getJSONArray("seats");
		return seatArray;
		
	}
	
	public static JSONArray getSeatSoldValue(String cinemaLinkId,JSONObject valueHss){
		//获取场次所有座位
		JSONObject soldMap =  new JSONObject(InterFaceOwnData.getSoldSeats(cinemaLinkId,valueHss));
		JSONArray seatArray = soldMap.getJSONObject("data").getJSONObject("bizValue").getJSONArray("seatIds");
		return seatArray;
		
	}
	
	public static String getSeatIds(JSONArray seatMap, JSONArray seatSold, int totalSeat) {
		//组装seatIds
		String seatIds="";
		for (int i=0;i<seatSold.length();i++) {
			for (int j=0;j<seatMap.length();j++){
				if (seatSold.getString(i).equals(seatMap.getJSONObject(j).get("seatId")))
					seatMap.remove(j);
			}
		}
		for (int m=0; m<totalSeat; m++ ){	
			seatIds = seatIds + seatMap.getJSONObject(m).get("seatId") + "|";
		}
		return seatIds.substring(0,seatIds.length()-1);
	}
	
	public static String getLockSeatsValue(String sid,String cinemaLinkId, JSONObject valueHss, String seatIds,String key){
		//获取lockSeatIds
		JSONObject rp = new JSONObject(InterFaceOwnData.lockSeats(sid,cinemaLinkId,valueHss,seatIds));
		String lockOrderId = rp.getJSONObject("data").getJSONObject("bizValue").getString(key);
		return lockOrderId;
		
	}
	
	public static JSONObject getGoodsParams(String sid, String cinemaLinkId,Map<Integer,Integer> setGoodsParamsMap){
		//获取卖品数据goodsParams、tatolPrice
		String goodsParams="";
		Integer totalPrice = 0;
		JSONObject values = new JSONObject();
		JSONObject rp = new JSONObject(InterFaceOwnData.getGoodses(sid,cinemaLinkId));
		Set<Integer> keys = setGoodsParamsMap.keySet();
		ArrayList<Integer> getGoodsParamsMapKey = new ArrayList<Integer>(keys);
		for (int i=0;i<setGoodsParamsMap.size();i++){
			goodsParams = goodsParams + rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("goodsInfo")
					.getJSONObject(getGoodsParamsMapKey.get(i)).getString("goodsId") + "-" + setGoodsParamsMap.get(getGoodsParamsMapKey.get(i))+ "|";
			totalPrice = totalPrice + rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("goodsInfo")
					.getJSONObject(getGoodsParamsMapKey.get(i)).getInt("displayPrice") * setGoodsParamsMap.get(getGoodsParamsMapKey.get(i));
		}
		values.put("goodsParams", goodsParams.substring(0,goodsParams.length()-1));
		values.put("totalPrice", totalPrice.toString());
		return values;
		
	}
	
	public static JSONObject getPayInfoGoods(String sid,String cinemaLinkId,JSONObject valuesGetGoods,int privilegeId,int payToolId){
		
		JSONObject values = new JSONObject();
		JSONObject rp = new JSONObject(InterFaceOwnData.getPayInfoGOODS(sid, cinemaLinkId, valuesGetGoods));
		String plId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeId");
		String plTp = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeTotalPrice");
		String ptId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("payTools").getJSONObject(privilegeId).getString("payToolId");
		
		if (plId.contains("CARD")){
			String cardNumber =plId.split("_")[plId.split("_").length-1];
			values.put("cardNumber", cardNumber);
			
		}else{
			
			values.put("payToolId", ptId);
		}
		values.put("privilegeId", plId);
		values.put("privilegeTotalPrice", plTp);
		
		return values;
		
	}
	
	public static JSONObject getPayInfoTicket(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds,int privilegeId,int payToolId){
		
		JSONObject values = new JSONObject();
		JSONObject rp = new JSONObject(InterFaceOwnData.getPayInfoTicket(sid, cinemaLinkId, valueHss, seatIds));
		String plId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeId");
		String plTp = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeTotalPrice");
		String ptId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("payTools").getJSONObject(privilegeId).getString("payToolId");
		if (plId.contains("CARD")){
			String cardNumber =plId.split("_")[plId.split("_").length-1];
			values.put("cardNumber", cardNumber);
			
		}else{
			
			values.put("payToolId", ptId);
		}
		values.put("privilegeId", plId);
		values.put("privilegeTotalPrice", plTp);
		
		return values;
		
	}
	
	public static JSONObject getPayInfoTicketGoods(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds, JSONObject valuesGetGoods,int privilegeId,int payToolId){
		
		JSONObject values = new JSONObject();
		JSONObject rp = new JSONObject(InterFaceOwnData.getPayInfoTicketGoods(sid, cinemaLinkId, valueHss,seatIds,valuesGetGoods));
		String plId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeId");
		String plTp = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("privileges").getJSONObject(privilegeId).getString("privilegeTotalPrice");
		String ptId = rp.getJSONObject("data").getJSONObject("bizValue").getJSONArray("payTools").getJSONObject(privilegeId).getString("payToolId");
		System.out.print("plId:" + plId);
		if (plId.contains("CARD")){
			String cardNumber =plId.split("_")[plId.split("_").length-1];
			values.put("cardNumber", cardNumber);
			
		}else{
			
			values.put("payToolId", ptId);
		}
		values.put("privilegeId", plId);
		values.put("privilegeTotalPrice", plTp);
		//values.put("payToolId", ptId);
		
		return values;
		
	}
	
	public static JSONObject getCreateGoodsOrder(String sid,String cinemaLinkId,JSONObject valuesGetGoods, JSONObject valueGetPayInfo, String key){
		
		JSONObject values = new JSONObject();
		if (valueGetPayInfo.has("cardNumber")){
			
			values.put("cardNumber", valueGetPayInfo.get("cardNumber"));
			values.put("cardPassword", "888888");
		}
		JSONObject rp = new JSONObject(InterFaceOwnData.createGoodsOrder(sid,cinemaLinkId,valuesGetGoods,valueGetPayInfo));
		String orderId = rp.getJSONObject("data").getJSONObject("bizValue").getString(key);
		values.put("orderId", orderId);
		return values;
		
	}
	
	public static JSONObject getCreateTicketOrder(String sid,String cinemaLinkId,JSONObject valueHss, String seatIds, String lockOrderId,JSONObject valueGetPayInfo, String key){
		
		JSONObject values = new JSONObject();
		if (valueGetPayInfo.has("cardNumber")){
			
			values.put("cardNumber", valueGetPayInfo.get("cardNumber"));
			values.put("cardPassword", "888888");
		}
		JSONObject rp = new JSONObject(InterFaceOwnData.createTicketOrder(sid, cinemaLinkId, valueHss, seatIds, lockOrderId, valueGetPayInfo));
		String orderId = rp.getJSONObject("data").getJSONObject("bizValue").getString(key);
		values.put("orderId", orderId);
		return values;

	}
	
	public static JSONObject getCreateTicketGoodsOrder(String sid,String cinemaLinkId,JSONObject valueHss, String seatIds, JSONObject valuesGetGoods,String lockOrderId,JSONObject valueGetPayInfo, String key){
		
		JSONObject values = new JSONObject();
		
		if (valueGetPayInfo.has("cardNumber")){
			
			values.put("cardNumber", valueGetPayInfo.get("cardNumber"));
			values.put("cardPassword", "888888");
		}
		System.out.print("valueGetPayInfo" + valueGetPayInfo.toString());
		JSONObject rp = new JSONObject(InterFaceOwnData.createTicketGoodsOrder(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, lockOrderId, valueGetPayInfo));
		String orderId = rp.getJSONObject("data").getJSONObject("bizValue").getString(key);
		values.put("orderId", orderId);
		return values;

	}

	public static JSONObject getCardGradesValue(String sid, String cinemaLinkId, int gradesIndex){
		
		JSONObject values = new JSONObject();
		JSONObject rp = new JSONObject(InterFaceOwnData.getCardGrades(sid, cinemaLinkId));
		values = rp.getJSONObject("data").getJSONArray("bizValue").getJSONObject(gradesIndex);
		return values;
		
	}
	
	public static JSONObject getPreCardDetailValue(String sid, String cinemaLinkId, JSONObject values){
		
		JSONObject rp = new JSONObject(InterFaceOwnData.getPreCardDetail(sid, cinemaLinkId, values));
		JSONObject value = rp.getJSONObject("data").getJSONObject("bizValue");
		return value;
		
	}
	
	public static JSONObject getCardsValue(String sid,int bizValueIndex){
		
		JSONObject rp = new JSONObject(InterFaceOwnData.getCards(sid));
		JSONObject value = rp.getJSONObject("data").getJSONArray("bizValue").getJSONObject(bizValueIndex);
		return value;
		
	}
	
	
	/*
	public static void main(String[] args) {
		
		Logger logger = new Log("interface_own").logger;
		
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		JSONObject valuesGetGoods = InterFaceOwnGetValueForOther.getGoodsParams(sid,cinemaLinkId,setGoodsParamsInfo);
		System.out.println(valuesGetGoods);
	
	}
	*/
	
	
	
	
	

}
