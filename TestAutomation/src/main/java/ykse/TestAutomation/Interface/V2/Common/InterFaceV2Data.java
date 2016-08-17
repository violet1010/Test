package ykse.TestAutomation.Interface.V2.Common;

import java.sql.Date;
import java.util.ArrayList;

import org.json.JSONObject;

import ykse.TestAutomation.Interface.V2.Common.CommonRequestData;
import ykse.TestAutomation.Interface.V2.Common.CommonUntil;
import ykse.TestAutomation.Common.HttpSampler;

public class InterFaceV2Data {

	public static JSONObject card_getCardGradeList()
	{
		JSONObject data =null;
		data = new JSONObject();
		
		data.put("cinemaLinkId", "68111");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.card.getCardGradeList",data);
		return crd.getRequestData();
	}
	
	public static String cinema_getCinemas()
	{
		
		JSONObject data  = new JSONObject();
		CommonRequestData  crd = new CommonRequestData("ykse.partner.cinema.getCinemas",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String schedule_getSchedules(String cinemaLinkId,Boolean starDate,Boolean endDate) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId", cinemaLinkId);
		if(starDate)
		{
			data.put("startDate", CommonUntil.getToday());
		}
		
		if(endDate)
		{
			data.put("endDate", CommonUntil.getToday());
		}
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.schedule.getSchedules",data);
        System.out.println(crd.getData());
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

		return responseStr;
	}

	public static String seat_getSeats(JSONObject object) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId", object.get("cinemaLinkId"));
		data.put("hallId", object.get("hallId"));
		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.getSeats",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String seat_getScheduleSoldSeats(JSONObject object) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId", object.get("cinemaLinkId"));
		data.put("sectionId", object.get("sectionId"));
		data.put("scheduleId", object.get("scheduleId"));
	//  data.put("scheduleKey", object.get("scheduleKey"));
		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.getScheduleSoldSeats",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String seat_lockSeats(JSONObject object , ArrayList seatIdList) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId", object.get("cinemaLinkId"));
		data.put("scheduleId", object.get("scheduleId"));
	    data.put("scheduleKey", object.get("scheduleKey"));
		String str = CommonUntil.getTime().toString().replace("-", "");
		data.put("outLockId", "000000"+str);
		data.put("seatCount", "2");
		data.put("seatIdList", seatIdList);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.lockSeats",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String seat_releaseSeats(JSONObject object, String lockOrderId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("lockOrderId",lockOrderId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.releaseSeats",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_confirmOrder(JSONObject object,String lockOrderId,ArrayList seatIdList) {
		JSONObject data  = new JSONObject();
		ArrayList ticketList = new ArrayList();
		JSONObject tickets  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("lockOrderId",lockOrderId);
		data.put("scheduleId",object.get("scheduleId"));
		data.put("scheduleKey",object.get("scheduleKey"));
		tickets.put("seatId",seatIdList.get(0));
		tickets.put("ticketPrice",object.get("settlePrice"));
		tickets.put("ticketFee",object.get("ticketFee"));
		ticketList.add(tickets);
		data.put("ticketList",ticketList);
		data.put("mobile","13800000000");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmOrder",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_confirmMixOrder(JSONObject object,String lockOrderId, ArrayList seatIdList, boolean goodsflag) {
		JSONObject data  = new JSONObject();
		ArrayList ticketList = new ArrayList();
		JSONObject tickets  = new JSONObject();
		ArrayList goodsList = new ArrayList();
		JSONObject goods  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("lockOrderId",lockOrderId);
		data.put("scheduleId",object.get("scheduleId"));
		data.put("scheduleKey",object.get("scheduleKey"));
		tickets.put("seatId",seatIdList.get(0));
		tickets.put("ticketPrice",object.get("settlePrice"));
		tickets.put("ticketFee",object.get("ticketFee"));
		ticketList.add(tickets);
		data.put("ticketList",ticketList);
		data.put("mobile","13800000000");
		if(goodsflag){
			goods.put("goodsId","");
			goods.put("salePrice","");
			goods.put("count","");
			goods.put("isPackage","");
			goodsList.add(goods);
		}
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmMixOrder",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_getOrderInfo(JSONObject object,String lockOrderId, String orderId, boolean lockOrderIdflag, boolean orderIdflag) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		if(lockOrderIdflag){
			data.put("lockOrderId",lockOrderId);
		}
		if(orderIdflag){
			data.put("orderId",orderId);
		}
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getOrderInfo",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_getTicketInfo(JSONObject object,String confirmationId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("confirmationId",confirmationId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getTicketInfo",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String ticket_printTicket(JSONObject object,String printId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("printId",printId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.ticket.printTicket",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}
	
	public static String ticket_getOrderPrintStatus(JSONObject object,String printId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("printId",printId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.ticket.getOrderPrintStatus",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}
	
	public static String order_refundOrder(JSONObject object,String orderId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",object.get("cinemaLinkId"));
		data.put("orderId",orderId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.refundOrder",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}
	
	public static String goods_getGoods(String cinemaLinkId) {
		JSONObject data  = new JSONObject();
		data.put("cinemaLinkId",cinemaLinkId);
		CommonRequestData  crd = new CommonRequestData("ykse.partner.goods.getGoods",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_confirmGoodsOrder(JSONObject object, String cinemaLinkId) {
		JSONObject data  = new JSONObject();
		ArrayList goodsList = new ArrayList();
		JSONObject goods  = new JSONObject();
		data.put("cinemaLinkId",cinemaLinkId);
		data.put("thirdOrderId","1453269983299123456");
		goods.put("goodsId",object.get("goodsId"));
		goods.put("count","1");
		goods.put("salePrice",object.get("settlePrice"));
		goods.put("isPackage",object.get("isPackage"));
		goodsList.add(goods);
		data.put("goodsList",goodsList);
		data.put("mobile","138000000");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmGoodsOrder",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_getGoodsOrderInfo(String goodsOrderId,String cinemaLinkId) {
		JSONObject data  = new JSONObject();
		ArrayList goodsList = new ArrayList();
		JSONObject goods  = new JSONObject();
		data.put("cinemaLinkId",cinemaLinkId);
		data.put("goodsOrderId","160112aaaa920000001");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getGoodsOrderInfo",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}

	public static String order_refundGoodsOrder(String goodsOrderId,String cinemaLinkId) {
		JSONObject data  = new JSONObject();
		ArrayList goodsList = new ArrayList();
		JSONObject goods  = new JSONObject();
		data.put("cinemaLinkId",cinemaLinkId);
		data.put("orderType","GOODS");
		data.put("goodsOrderId","160112aaaa920000001");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.refundGoodsOrder",data);
		String responseStr = HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());
		return responseStr;
	}
}
