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
//import ykse.TestAutomation.Interface.Finixx.Common.CommonUntil;
import ykse.TestAutomation.Interface.V2.Common.CommonUntil;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Assertion;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Data;

public class InterfaceV2Test {
	
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
	
	/**
	*查询影院列表 cinema_getCinemas
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_cinema_getCinemas() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res = InterFaceV2Data.cinema_getCinemas();
		result = InterFaceV2Assertion.TA_cinema_getCinemas(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询排期列表  schedule_getSchedules
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_schedule_getSchedules() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表  schedule_getSchedules");
		Boolean starDate=false;
		Boolean endDate=false;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		result = InterFaceV2Assertion.TA_schedule_getSchedules(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询排期列表_开始时间  schedule_getSchedules_starDate
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_schedule_getSchedules_starDate() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_开始时间  schedule_getSchedules_starDate");
		Boolean starDate=true;
		Boolean endDate=false;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		result = InterFaceV2Assertion.TA_schedule_getSchedules(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询排期列表_结束时间  schedule_getSchedules_endDate
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_schedule_getSchedules_endDate() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_结束时间  schedule_getSchedules_endDate");
		Boolean starDate=false;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);; 
		String res = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		result = InterFaceV2Assertion.TA_schedule_getSchedules(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询排期列表_所有参数  schedule_getSchedules_All
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_schedule_getSchedules_All() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);; 
		String res = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		result = InterFaceV2Assertion.TA_schedule_getSchedules(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询影厅座位  seat_getSeats
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_seat_getSeats() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res = InterFaceV2Data.seat_getSeats(object);
		result = InterFaceV2Assertion.TA_seat_getSeats(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询场次已售座位 seat_getScheduleSoldSeats
	* @author hyc
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_seat_getScheduleSoldSeats() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		//获取cinemaLinkId
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		//获取scheduleId、scheduleKey与cinemaLinkId
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		logger.info("[步骤_4]. 查询场次已售座位 seat_getScheduleSoldSeats");
		//获取sectionId
		String sectionId = CommonUntil.getsectionId(res_seat_getSeats);
		object.put("sectionId", sectionId);
		String res = InterFaceV2Data.seat_getScheduleSoldSeats(object);
		result = InterFaceV2Assertion.TA_seat_getScheduleSoldSeats(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*锁定座位  seat_lockSeats
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_seat_lockSeats() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String res = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		result = InterFaceV2Assertion.TA_seat_lockSeats(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*释放座位  seat_releaseSeats
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_seat_releaseSeats() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 释放座位  seat_releaseSeats");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res = InterFaceV2Data.seat_releaseSeats(object,lockOrderId);
		result = InterFaceV2Assertion.TA_seat_lockSeats(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*确认订单  order_confirmOrder
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_confirmOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		result = InterFaceV2Assertion.TA_order_confirmOrder(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*混合订单  order_confirmOrder
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_confirmMixOrder_noGoods() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 混合订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		boolean goodsflag = false;
		String res = InterFaceV2Data.order_confirmMixOrder(object,lockOrderId,seatIdList,goodsflag);
		result = InterFaceV2Assertion.TA_order_confirmMixOrder(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*混合订单  order_confirmOrder
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_confirmMixOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 混合订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		boolean goodsflag = true;
		String res = InterFaceV2Data.order_confirmMixOrder(object,lockOrderId,seatIdList,goodsflag);
		result = InterFaceV2Assertion.TA_order_confirmMixOrder(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询订单  order_getOrderInfo
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_getOrderInfo() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = true;
		String res = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		result = InterFaceV2Assertion.TA_order_getOrderInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询订单  order_getOrderInfo
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_getOrderInfo_lockOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = false;
		String res = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		result = InterFaceV2Assertion.TA_order_getOrderInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询订单  order_getOrderInfo
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_getOrderInfo_oder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = false;
		boolean orderIdflag = true;
		String res = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		result = InterFaceV2Assertion.TA_order_getOrderInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询订单  order_getOrderInfo
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_getOrderInfo_none() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = false;
		boolean orderIdflag = false;
		String res = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		result = InterFaceV2Assertion.TA_order_getOrderInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询取票信息 order_getTicketInfo
	* @author hyc
	* @Time2016-05-09
	*/
	@Test(groups={"P0"})
	public void TC_order_getTicketInfo() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = true;
		String res_order_getOrderInfo = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		logger.info("[步骤_7]. 查询取票信息 order_getTicketInfo");
		String confirmationId = CommonUntil.getconfirmationId(res_order_getOrderInfo);
		String res = InterFaceV2Data.order_getTicketInfo(object,confirmationId);
		result = InterFaceV2Assertion.TA_order_getTicketInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*确认取票 ticket_printTicket
	* @author lgh
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_ticket_printTicket() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = true;
		String res_order_getOrderInfo = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		logger.info("[步骤_7]. 查询取票信息 order_getTicketInfo");
		String confirmationId = CommonUntil.getconfirmationId(res_order_getOrderInfo);
		String res_order_getTicketInfo = InterFaceV2Data.order_getTicketInfo(object,confirmationId);
		logger.info("[步骤_8]. 确认取票 ticket_printTicket");
		String printId =  CommonUntil.getprintId(res_order_getTicketInfo);
		String res = InterFaceV2Data.ticket_printTicket(object,printId);
		result = InterFaceV2Assertion.TA_ticket_printTicket(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*确认取票ticket_getOrderPrintStatus
	* @author lgh
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_ticket_getOrderPrintStatus() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = true;
		String res_order_getOrderInfo = InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		logger.info("[步骤_7]. 查询取票信息 order_getTicketInfo");
		String confirmationId = CommonUntil.getconfirmationId(res_order_getOrderInfo);
		String res_order_getTicketInfo = InterFaceV2Data.order_getTicketInfo(object,confirmationId);
		logger.info("[步骤_8]. 查询取票状态 ticket_getOrderPrintStatus");
		String printId =  CommonUntil.getprintId(res_order_getTicketInfo);
		String res = InterFaceV2Data.ticket_getOrderPrintStatus(object,printId);
		result = InterFaceV2Assertion.TA_ticket_getOrderPrintStatus(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*退单接口order_refundOrder
	* @author lgh
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_order_refundOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
		Boolean starDate=true;
		Boolean endDate=true;
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
		String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);
		logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");
		JSONObject object = CommonUntil.getschedule(res_schedule_getSchedules);
		String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
		ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);	
		logger.info("[步骤_4]. 锁定座位  seat_lockSeats");	
		String seat_lockSeats = InterFaceV2Data.seat_lockSeats(object,seatIdList);
		logger.info("[步骤_5]. 确认订单  order_confirmOrder");	
		String lockOrderId = CommonUntil.getlockOrderId(seat_lockSeats);
		String res_order_confirmOrder = InterFaceV2Data.order_confirmOrder(object,lockOrderId,seatIdList);
		logger.info("[步骤_6]. 查询订单  order_getOrderInfo");
		String orderId = CommonUntil.getorderId(res_order_confirmOrder);
		boolean lockOrderIdflag = true;
		boolean orderIdflag = true;
		 InterFaceV2Data.order_getOrderInfo(object,lockOrderId,orderId,lockOrderIdflag,orderIdflag);
		logger.info("[步骤_7]. 退单接口order_refundOrder");	
		String res = InterFaceV2Data.order_refundOrder(object,orderId);
		result = InterFaceV2Assertion.TA_order_refundOrder(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*5.1查询卖品列表 goods_getGoods
	* @author lgh
	* @Time2016-05-06
	*/
	@Test(groups={"P0"})
	public void TC_goods_getGoods() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询卖品列表 goods_getGoods");	
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas); 
		String res = InterFaceV2Data.goods_getGoods(cinemaLinkId);
		result = InterFaceV2Assertion.TA_goods_getGoods(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*5.2卖品确认订单 order_confirmGoodsOrder
	* @author hyc
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_order_confirmGoodsOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询卖品列表 goods_getGoods");	
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas); 
		String res_goods_getGoods = InterFaceV2Data.goods_getGoods(cinemaLinkId);
		logger.info("[步骤_3]. 卖品确认订单 order_confirmGoodsOrder");	
		JSONObject object = CommonUntil.getgoods(res_goods_getGoods);
		String res = InterFaceV2Data.order_confirmGoodsOrder(object,cinemaLinkId);
		result = InterFaceV2Assertion.TA_order_confirmGoodsOrder(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*5.3查询卖品订单 order_getGoodsOrderInfo
	* @author hyc
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_order_getGoodsOrderInfo() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询卖品列表 goods_getGoods");	
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas); 
		String res_goods_getGoods = InterFaceV2Data.goods_getGoods(cinemaLinkId);
		logger.info("[步骤_3]. 卖品确认订单 order_confirmGoodsOrder");	
		JSONObject object = CommonUntil.getgoods(res_goods_getGoods);
		String res_order_confirmGoodsOrder = InterFaceV2Data.order_confirmGoodsOrder(object,cinemaLinkId);
		logger.info("[步骤_4]. 查询卖品订单 order_getGoodsOrderInfo");	
		String goodsOrderId = "";
		String res = InterFaceV2Data.order_getGoodsOrderInfo(goodsOrderId,cinemaLinkId);
		result = InterFaceV2Assertion.TA_order_getGoodsOrderInfo(res);
		Assert.assertEquals(result, true);
	}
	
	/**
	*5.4退卖品接口order_refundGoodsOrder
	* @author hyc
	* @Time2016-05-10
	*/
	@Test(groups={"P0"})
	public void TC_order_refundGoodsOrder() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 查询影院列表 cinema_getCinemas");
		String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
		logger.info("[步骤_2]. 查询卖品列表 goods_getGoods");	
		String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas); 
		String res_goods_getGoods = InterFaceV2Data.goods_getGoods(cinemaLinkId);
		logger.info("[步骤_3]. 卖品确认订单 order_confirmGoodsOrder");	
		JSONObject object = CommonUntil.getgoods(res_goods_getGoods);
		String res_order_confirmGoodsOrder = InterFaceV2Data.order_confirmGoodsOrder(object,cinemaLinkId);
		logger.info("[步骤_4]. 查询卖品订单 order_getGoodsOrderInfo");	
		String goodsOrderId = "";
		String res = InterFaceV2Data.order_refundGoodsOrder(goodsOrderId,cinemaLinkId);
		result = InterFaceV2Assertion.TA_order_refundGoodsOrder(res);
		Assert.assertEquals(result, true);
	}
	
	
}
