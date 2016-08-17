package ykse.TestAutomation.Interface.V2.Test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Data;
import ykse.TestAutomation.Interface.V2.Common.CommonRequestData;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Assertion;

public class InterfaceV2Debug {
	
	Logger logger = new Log("interface_v2").logger;
	
	@BeforeClass
	public static void setUp() throws Exception {

	}

	@AfterClass
	public static void tearDown() throws Exception {
		// driver.close();
	}
	@BeforeMethod(alwaysRun = true)
	public void BeforeCase() throws Exception {
		
		logger.warn("****开始执行用例****");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterCase() throws Exception {
		logger.warn("****用例执行结束****");
	}
	
	@Test
	public void TC_card_getCardGradeList_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 查询会员卡等级列表");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		
		//可选
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.card.getCardGradeList",data);
	 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	}
	
	@Test
	public void TC_cinema_getCinemas_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 3.1查询影院列表");
		JSONObject data =null;
		data = new JSONObject();
		//必须
	//	data.put("cinemaLinkId", "681");
		
		//可选
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.cinema.getCinemas",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_schedule_getSchedules_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 3.2查询排期列表");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		
		//可选
		data.put("startDate", "2016-05-09");
		data.put("endDate", "2016-07-13");
		
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.schedule.getSchedules",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_seat_getSeats_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 3.3查询影厅座位");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("hallId", "6");
		//可选
		
		
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.getSeats",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_seat_getScheduleSoldSeats_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 3.4查询场次已售座位");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("sectionId", "0000000000000001");
		data.put("scheduleId", "6528871");
		data.put("scheduleKey", "F8065BDEFE263FC412EA96422F186D45");
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.getScheduleSoldSeats",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_seat_lockSeats_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.1锁定座位");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("scheduleId", "6528871");
		data.put("scheduleKey", "F8065BDEFE263FC412EA96422F186D45");
		data.put("outLockId", "14526106201668732939");
		data.put("seatCount", "1");
		ArrayList<String> list = new ArrayList<String>();
		list.add("0000000000000001-1-07");
		data.put("seatIdList",list);
		
		
		
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.lockSeats",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_seat_releaseSeats_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.2释放座位");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("lockOrderId", "20160509XXX68100000145");
		
		
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.seat.releaseSeats",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_confirmOrder_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.3确认订单");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("lockOrderId", "20160509XXX68100000145");
		data.put("scheduleId", "6528871");
		data.put("scheduleKey", "F8065BDEFE263FC412EA96422F186D45");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject  ticketList = new JSONObject();
		ticketList.put("seatId","0000000000000001-1-07");
		ticketList.put("ticketPrice","130.00");
		ticketList.put("ticketFee","2.00");
		list.add(ticketList);
		data.put("ticketList",list);
		data.put("mobile", "13800000000");
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmOrder",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_confirmMixOrder_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.4混合订单");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("lockOrderId", "20160509XXX68100000133");
		data.put("scheduleId", "6528872");
		data.put("scheduleKey", "974DD6CC0C8DAC3B9E1082CC5537E727");
		ArrayList<JSONObject> lists = new ArrayList<JSONObject>();
		JSONObject  ticketList = new JSONObject();
		ticketList.put("seatId","0000000000000001-B-03");
		ticketList.put("ticketPrice","130.00");
		ticketList.put("ticketFee","2.00");
		lists.add(ticketList);
		data.put("ticketList",lists);						
		data.put("mobile", "13800000000");
		//可选	
		
		ArrayList<JSONObject> goodsList = new ArrayList<JSONObject>();
		JSONObject  goods = new JSONObject();
		goods.put("goodsId","8130916112200");
		goods.put("salePrice","50.00");
		goods.put("count","1");
		goods.put("isPackage","false");
		goodsList.add(goods);
		data.put("goodsList",goodsList);
        
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmMixOrder",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_getOrderInfo_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.5查询订单");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		

		//可选
        data.put("lockOrderId", "20160509XXX68100000133");
		data.put("orderId", "20160509XXX68100000133");
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getOrderInfo",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	
	@Test
	public void TC_order_getTicketInfo_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.6查询取票信息");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
	    data.put("confirmationId", "2016060886411458");

		//可选
     
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getTicketInfo",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_ticket_printTicket_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.7确认取票");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
	    data.put("printId", "6810160509078902");

		//可选
     
		CommonRequestData  crd = new CommonRequestData("ykse.partner.ticket.printTicket",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_ticket_getOrderPrintStatus_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 4.8查询取票状态");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
	    data.put("printId", "6810160509078902");

		//可选
     
		CommonRequestData  crd = new CommonRequestData("ykse.partner.ticket.getOrderPrintStatus",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_refundOrder_DEBUG() throws InterruptedException {
		logger.info("[步骤_1].4.9退单接口");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("orderId", "20160509XXX68100000145");

		//可选
		
		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.refundOrder",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	
	//卖品
	@Test
	public void TC_goods_getGoods_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 5.1查询卖品列表");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		
		
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.goods.getGoods",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_confirmGoodsOrder_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 5.2卖品确认订单");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("thirdOrderId", "1453269983299123456");
		ArrayList<JSONObject> goodsList = new ArrayList<JSONObject>();
		JSONObject  goods = new JSONObject();
		goods.put("goodsId","8130916112200");
		goods.put("salePrice","50.00");
		goods.put("count","1");
		goods.put("isPackage","false");
		goodsList.add(goods);
		data.put("goodsList",goodsList);
		data.put("mobile", "13800000000");
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.confirmGoodsOrder",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_getGoodsOrderInfo_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 5.3查询卖品订单");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("goodsOrderId", "16050906815583000020");
		
		//可选

		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.getGoodsOrderInfo",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
	@Test
	public void TC_order_refundGoodsOrder_DEBUG() throws InterruptedException {
		logger.info("[步骤_1]. 5.4退卖品接口");
		JSONObject data =null;
		data = new JSONObject();
		//必须
		data.put("cinemaLinkId", "681");
		data.put("orderType", "GOODS");
		
		//可选
		data.put("orderId", "16050906815583000020");
		data.put("goodsOrderId", "16050906815583000020");

		CommonRequestData  crd = new CommonRequestData("ykse.partner.order.refundGoodsOrder",data);
		 HttpSampler.sendGet("http://172.33.0.188:8080/route", crd.getRequestData());

	
	}
	
}
