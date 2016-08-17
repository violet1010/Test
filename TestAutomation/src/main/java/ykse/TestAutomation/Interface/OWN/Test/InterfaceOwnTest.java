
package ykse.TestAutomation.Interface.OWN.Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Interface.OWN.Common.InterFaceOwnData;
import ykse.TestAutomation.Interface.OWN.Common.InterFaceOwnAssertion;
import ykse.TestAutomation.Interface.OWN.Common.InterFaceOwnGetValueForOther;

public class InterfaceOwnTest {
	
	Logger logger = new Log("interface_own").logger;
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeCase() throws Exception {
		
		logger.warn("****开始执行用例****");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterCase() throws Exception {
		logger.warn("****用例执行结束****");
		
	}
	
	@Test(groups={"P0"})
	public void TC_signin_apiIsNotExist() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninApiIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_apiIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninApiIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_accountIsNotExist() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninAccountIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_signin_accountIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninAccountIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_passwordIsNotExist() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninPasswordIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_passwordIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninPasswordIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_typeIsNotExist() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninTypeIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_typeIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninTypeIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_devicePrintIsNotExist() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninDevicePrintIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_devicePrintIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninDevicePrintIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_mobileCountryCodeIsNotExisty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninMobileCountryCodeIsNotExist");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_signin_mobileCountryCodeIsEmpty() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySignin("securitySigninMobileCountryCodeIsEmpty");
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_signin_WRONGPW() throws InterruptedException {
		
		logger.info("[步骤_1]. 执行登录接口（新）");
		String interfaceResponse = InterFaceOwnData.securitySigninWrongPW();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("signinWrongPWBizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_login_NORMAL() throws InterruptedException {

		logger.info("[步骤_1]. 执行登录接口（旧）");
		String interfaceResponse = InterFaceOwnData.securityLogin();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_login_WRONGPW() throws InterruptedException {
		logger.info("[步骤_1]. 执行登录接口（旧）");
		String interfaceResponse = InterFaceOwnData.securityLoginWrongPW();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("loginWrongPWBizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_getHotFilms_posterSize_LARGE() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取热映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getHotFilmsPosterSizeLarge();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getHotFilms_posterSize_MIDDLE() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取热映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getHotFilmsPosterSizeMiddle();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getHotFilms_posterSize_SMALL() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取热映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getHotFilmsPosterSizeSmall();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_getSoonFilms_posterSize_LARGE() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取即将上映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getSoonFilmsPosterSizeLarge();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSoonFilms_posterSize_MIDDLE() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取即将上映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getSoonFilmsPosterSizeMiddle();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSoonFilms_posterSize_SMALL() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取即将上映影片列表接口");
		String interfaceResponse = InterFaceOwnData.getSoonFilmsPosterSizeSmall();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getFilmDetail_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取影片详情接口");
		String interfaceResponse = InterFaceOwnData.getFilmDetail();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getFilmComments_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 执行获取影片列评论列表接口");
		String interfaceResponse = InterFaceOwnData.getFilmComments();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_createFilmComment_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 执行创建影片评论接口");
		String interfaceResponse = InterFaceOwnData.createFilmComment();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCinemas_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 使用正确数据登录");
		String interfaceResponse = InterFaceOwnData.getCinemas();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCinemasByFilmId_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 使用正确数据登录");
		String interfaceResponse = InterFaceOwnData.getCinemasByFilmId();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCinemaDetail_Normal() throws InterruptedException {
		logger.info("[步骤_1]. 使用正确数据登录");
		String interfaceResponse = InterFaceOwnData.getCinemaDetail();
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSchedules_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_2]. 使用正确入参请求获取场次接口");
		String interfaceResponse = InterFaceOwnData.getSchedules(cinemaLinkId);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getActivityDetail_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0, "cinemaLinkId");
		
		logger.info("[步骤_2]. 运行获取场次列表接口，获取activityId");
		String activityId = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId, 0, "activities", "activityId");
		
		logger.info("[步骤_3]. 运行获取获取活动详情接口");
		String interfaceResponse = InterFaceOwnData.getActivityDetail(cinemaLinkId, activityId);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSeatMap_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_2]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_3]. 执行获取座位图接口");
		String interfaceResponse = InterFaceOwnData.getSeatMap(cinemaLinkId,valueHss);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSoldSeats_Normal() throws InterruptedException {
	
		logger.info("[步骤_1]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_2]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_3]. 执行获取已售座位图接口");
		String interfaceResponse = InterFaceOwnData.getSoldSeats(cinemaLinkId,valueHss);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_lockSeats_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_4]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_5]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_7]. 请求锁座接口");
		String interfaceResponse = InterFaceOwnData.lockSeats(sid,cinemaLinkId,valueHss,seatIds);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_unlockSeats_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_4]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_5]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_6]. 执行锁座接口，获取锁座lockOrderId");
		String lockOrderId = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_7]. 执行释放座位接口");
		String interfaceResponse = InterFaceOwnData.unlockSeats(sid,cinemaLinkId,lockOrderId);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getGoodses_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 执行获取卖品列表接口");
		String interfaceResponse = InterFaceOwnData.getGoodses(sid,cinemaLinkId);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getPayInfoGoods_Normal() throws InterruptedException {
		//获取卖品优惠信息
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取卖品列表接口，根据setGoodsParamsInfo组装创建卖品订单入参");
		JSONObject valuesGetGoods = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
	
		logger.info("[步骤_5]. 执行获取优惠、支付信息接口（GOODS）");
		String interfaceResponse = InterFaceOwnData.getPayInfoGOODS(sid,cinemaLinkId,valuesGetGoods);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
		
	}
	
	@Test(groups={"P0"})
	public void TC_getPayInfoTicket_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_4]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_5]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_7]. 执行获取订单优惠、支付信息接口（TICKET）");
		String interfaceResponse = InterFaceOwnData.getPayInfoTicket(sid,cinemaLinkId,valueHss,seatIds);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getPayInfoTicketGoods_Normal() throws InterruptedException {
		
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_5]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_8]. 运行获取卖品列表接口，获取goodsParams");
		JSONObject goodsParams  = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
		
		logger.info("[步骤_9]. 执行获取订单优惠、支付信息接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.getPayInfoTicketGoods(sid,cinemaLinkId,valueHss,seatIds,goodsParams);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_createGoodsOrder_Normal() throws InterruptedException {
		//创建卖品订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取卖品列表接口，根据setGoodsParamsInfo组装创建卖品订单入参");
		JSONObject valuesGetGoods = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
	
		logger.info("[步骤_5]. 运行获取优惠、支付信息接口（GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoGoods(sid, cinemaLinkId, valuesGetGoods, 1, 1);
		
		logger.info("[步骤_6]. 执行创建卖品订单接口");
		String interfaceResponse = InterFaceOwnData.createGoodsOrder(sid,cinemaLinkId,valuesGetGoods,valueGetPayInfo);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
		
	}
	
	@Test(groups={"P0"})
	public void TC_createTicketOrder_Normal() throws InterruptedException {
		//创建影票订单
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_4]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_5]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_7]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_8]. 运行获取订单优惠、支付信息接口（TICKET）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicket(sid, cinemaLinkId, valueHss, seatIds, 0, 1);
		
		logger.info("[步骤_9]. 执行创建影票订单接口(TICKET)");
		String interfaceResponse = InterFaceOwnData.createTicketOrder(sid, cinemaLinkId, valueHss, seatIds, lockOrderId, valueGetPayInfo);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_createTicketGoodsOrder_Normal() throws InterruptedException {
		//创建混合订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_5]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_8]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_9]. 运行获取卖品列表接口，获取goodsParams");
		JSONObject valuesGetGoods  = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
		
		logger.info("[步骤_10]. 运行获取订单优惠、支付信息接口（TICKET_GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicketGoods(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, 0, 0);
		
		logger.info("[步骤_11]. 执行创建混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.createTicketGoodsOrder(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, lockOrderId, valueGetPayInfo);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_cancelOrderGoods_Normal() throws InterruptedException {
		//取消卖品订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		logger.info("[步骤_2]. 设置订单类型");
		//设置订单类型
		String orderType = "GOODS";
		
		logger.info("[步骤_3]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_4]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_5]. 运行获取卖品列表接口，根据setGoodsParamsInfo组装创建卖品订单入参");
		JSONObject valuesGetGoods = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
	
		logger.info("[步骤_6]. 运行获取优惠、支付信息接口（GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoGoods(sid, cinemaLinkId, valuesGetGoods, 1, 1);
	
		logger.info("[步骤_7]. 运行创建卖品订单接口、获取orderId");
		JSONObject createGoodsOrderValue = InterFaceOwnGetValueForOther.getCreateGoodsOrder(sid, cinemaLinkId, valuesGetGoods, valueGetPayInfo, "orderId");
		
		logger.info("[步骤_8]. 执行取消卖品订单接口");
		String interfaceResponse = InterFaceOwnData.cancelOrder(sid, cinemaLinkId, orderType, createGoodsOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
		
	}
	
	@Test(groups={"P0"})
	public void TC_cancelOrderTicket_Normal() throws InterruptedException {
		//取消影票订单	
		logger.info("[步骤_1]. 设置订单类型");
		//设置订单类型
		String orderType = "TICKET";
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_5]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_8]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_9]. 运行获取订单优惠、支付信息接口（TICKET）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicket(sid, cinemaLinkId, valueHss, seatIds, 0, 1);
		
		logger.info("[步骤_10]. 运行创建影票订单接口(TICKET)，获取orderId");
		JSONObject createTicketOrderValue = InterFaceOwnGetValueForOther.getCreateTicketOrder(sid, cinemaLinkId, valueHss, seatIds, lockOrderId, valueGetPayInfo, "orderId");
		
		logger.info("[步骤_10]. 执行取消影票订单接口(TICKET)");
		String interfaceResponse = InterFaceOwnData.cancelOrder(sid, cinemaLinkId, orderType, createTicketOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_cancelOrderTicketGoods_Normal() throws InterruptedException {
		
		//取消混合订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		logger.info("[步骤_2]. 设置订单类型");
		//设置订单类型
		String orderType = "TICKET_GOODS";
		
		logger.info("[步骤_3]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_4]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_5]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",0,"schedules",0);
		
		logger.info("[步骤_6]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_8]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_9]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_10]. 运行获取卖品列表接口，获取goodsParams");
		JSONObject valuesGetGoods  = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
		
		logger.info("[步骤_11]. 运行获取订单优惠、支付信息接口（TICKET_GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicketGoods(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, 0, 0);
		
		logger.info("[步骤_12]. 允许创建混合订单接口（TICKET_GOODS），获取orderId");
		JSONObject createTicketGoodsOrderValue = InterFaceOwnGetValueForOther.getCreateTicketGoodsOrder(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, lockOrderId, valueGetPayInfo, "orderId");
		
		logger.info("[步骤_13]. 执行取消混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.cancelOrder(sid, cinemaLinkId, orderType, createTicketGoodsOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getPaidOrders_Normal() throws InterruptedException {
		//获取已支付的订单列表
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 执行取消混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.getPaidOrders(sid);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getUnpaidOrders_Normal() throws InterruptedException {
		//获取未支付的订单列表
		logger.info("[步骤_1]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 执行取消混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.getUnpaidOrders(sid);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCities_Normal() throws InterruptedException {
		//获取城市列表
		logger.info("[步骤_1]. 执行取消混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.getCities();
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getSid_Normal() throws InterruptedException {
		//登出
		
		logger.info("[步骤_1]. 运行登录接口，获取tid");
		String tid = InterFaceOwnGetValueForOther.getLoginValue("tid");
		
		logger.info("[步骤_2]. 执行登出接口");
		String interfaceResponse = InterFaceOwnData.logout(tid);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_sendMsgCode_Normal() throws InterruptedException {
		//发送短信验证码（旧版）
		String phoneNo = "18665778762";
		
		logger.info("[步骤_1]. 执行获取验证码接口（旧版）");
		String interfaceResponse = InterFaceOwnData.sendMsgCode(phoneNo);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_sendSMSCode_Normal() throws InterruptedException {
		//发送短信验证码（旧版）
		String mobileCountryCode = "0086";
		String mobile = "18665778762";
		String type = "ACCOUNT_REGISTER";
		
		logger.info("[步骤_1]. 执行获取验证码接口（新版）");
		String interfaceResponse = InterFaceOwnData.sendSMSCode(mobileCountryCode,mobile,type);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getAccountBySid() throws InterruptedException {
		//获取会员基本信息
	
		logger.info("[步骤_1]. 运行登录接口，获取tid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_1]. 执行获取会员基本信息接口");
		String interfaceResponse = InterFaceOwnData.getAccountBySid(sid);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_modifyPassword() throws InterruptedException {
		//修改密码
	
		logger.info("[步骤_1]. 运行登录接口，获取tid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_1]. 执行修改密码接口");
		String interfaceResponse = InterFaceOwnData.modifyPassword(sid);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCardGrades() throws InterruptedException {
		//获取影院的开卡等级列表
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_3]. 执行修改密码接口");
		String interfaceResponse = InterFaceOwnData.getCardGrades(sid, cinemaLinkId);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_getPreCardDetail() throws InterruptedException {
		//获取预制卡详细信息
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取影院的开卡等级列表接口，获取gradeId");
		JSONObject values = InterFaceOwnGetValueForOther.getCardGradesValue(sid, cinemaLinkId, 0);
		
		logger.info("[步骤_4]. 执行获取预制卡详细信息接口");
		String interfaceResponse = InterFaceOwnData.getPreCardDetail(sid,cinemaLinkId,values);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_applyCard() throws InterruptedException {
		//申请会员卡
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_3]. 运行获取影院的开卡等级列表接口，获取gradeId");
		JSONObject cardGradesValues = InterFaceOwnGetValueForOther.getCardGradesValue(sid, cinemaLinkId, 0);
		
		logger.info("[步骤_4]. 运行获取预制卡详细信息接口，获取cardNumber");
		JSONObject preCardDetailValues = InterFaceOwnGetValueForOther.getPreCardDetailValue(sid,cinemaLinkId,cardGradesValues);
		
		logger.info("[步骤_5]. 执行申请会员卡接口");
		String interfaceResponse = InterFaceOwnData.applyCard(sid, cinemaLinkId, preCardDetailValues);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_bindCard() throws InterruptedException {
		//绑定会员卡
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_3]. 执行绑定会员卡接口");
		String interfaceResponse = InterFaceOwnData.bindCard(sid, cinemaLinkId);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_unbindCard() throws InterruptedException {
		//解除绑定会员卡
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取影院列表接口，获取cinemaLinkId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3, "cinemaLinkId");
		
		logger.info("[步骤_3]. 执行解除绑定会员卡接口");
		String interfaceResponse = InterFaceOwnData.unbindCard(sid, cinemaLinkId);

		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCards() throws InterruptedException {
		//获取会员卡列表
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 执行获取会员卡列表接口");
		String interfaceResponse = InterFaceOwnData.getCards(sid);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCardDetail() throws InterruptedException {
		//获取会员卡详细信息
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取会员卡列表接口，获取cinemaLinkId、cardNumber");
		JSONObject cardsValue = InterFaceOwnGetValueForOther.getCardsValue(sid, 0);
		
		logger.info("[步骤_3]. 执行获取会员卡详细信息接口");
		String interfaceResponse = InterFaceOwnData.getCardDetail(sid,cardsValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getCardRecords() throws InterruptedException {
		//提交会员卡充值订单
		String recordType = "RECHARGE";
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取会员卡列表接口，获取cinemaLinkId、cardNumber");
		JSONObject cardsValue = InterFaceOwnGetValueForOther.getCardsValue(sid, 0);
		
		logger.info("[步骤_3]. 执行获取会员充值历史记录列表接口");
		String interfaceResponse = InterFaceOwnData.getCardRecords(sid, cardsValue, recordType);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_getAllCardGrades() throws InterruptedException {
		//获取会员充值历史记录列表
	
		logger.info("[步骤_1]. 运行登录接口，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_2]. 运行获取会员卡列表接口，获取cinemaLinkId、cardNumber");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(3,"cinemaLinkId");
		
		logger.info("[步骤_3]. 执行获取会员充值历史记录列表接口");
		String interfaceResponse = InterFaceOwnData.getAllCardGrades(sid, cinemaLinkId);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_payOrderWithCardForTicketGoods_Normal() throws InterruptedException {
		
		//会员卡支付混合订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		logger.info("[步骤_2]. 设置订单类型");
		//设置订单类型
		String orderType = "TICKET_GOODS";
		
		logger.info("[步骤_3]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_4]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0,"cinemaLinkId");
		
		logger.info("[步骤_5]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",1,"schedules",0);
		
		logger.info("[步骤_6]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_8]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_9]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_10]. 运行获取卖品列表接口，获取goodsParams");
		JSONObject valuesGetGoods  = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
		
		logger.info("[步骤_11]. 运行获取订单优惠、支付信息接口（TICKET_GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicketGoods(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, 0, 0);
		
		logger.info("[步骤_12]. 允许创建混合订单接口（TICKET_GOODS），获取orderId");
		JSONObject createTicketGoodsOrderValue = InterFaceOwnGetValueForOther.getCreateTicketGoodsOrder(sid, cinemaLinkId, valueHss, seatIds, valuesGetGoods, lockOrderId, valueGetPayInfo, "orderId");
		
		//String cardNumber = "00000";
		//String cardPassword = "888888";
		
		logger.info("[步骤_13]. 执行取消混合订单接口（TICKET_GOODS）");
		String interfaceResponse = InterFaceOwnData.payOrderWithCard(sid, cinemaLinkId, orderType, createTicketGoodsOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	
	@Test(groups={"P0"})
	public void TC_payOrderWithCardForTicket_Normal() throws InterruptedException {
		//会员卡支付影票订单
		logger.info("[步骤_1]. 设置订单类型");
		//设置订单类型
		String orderType = "TICKET";
		logger.info("[步骤_2]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_3]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0,"cinemaLinkId");
		
		logger.info("[步骤_4]. 运行获取场次列表接口，获取hallId scheduleId scheduleKey");
		JSONObject valueHss = InterFaceOwnGetValueForOther.getSchedulesValue(cinemaLinkId,"films",0,"dates",1,"schedules",0);
		
		logger.info("[步骤_5]. 运行获取场次座位图接口，获取所有座位数据");
		JSONArray seatMap = InterFaceOwnGetValueForOther.getSeatMapValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_6]. 运行获取已售座位图接口，获取所有座位数据");
		JSONArray soldMap = InterFaceOwnGetValueForOther.getSeatSoldValue(cinemaLinkId, valueHss);
		
		logger.info("[步骤_7]. 组织锁座seatIds");
		String seatIds  = InterFaceOwnGetValueForOther.getSeatIds(seatMap,soldMap,1);
		
		logger.info("[步骤_8]. 运行锁座接口，获取锁座lockOrderId");
		String lockOrderId  = InterFaceOwnGetValueForOther.getLockSeatsValue(sid, cinemaLinkId, valueHss, seatIds, "lockOrderId");
		
		logger.info("[步骤_9]. 运行获取订单优惠、支付信息接口（TICKET）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoTicket(sid, cinemaLinkId, valueHss, seatIds, 0, 1);
		
		logger.info("[步骤_10]. 运行创建影票订单接口(TICKET)，获取orderId");
		JSONObject createTicketOrderValue = InterFaceOwnGetValueForOther.getCreateTicketOrder(sid, cinemaLinkId, valueHss, seatIds, lockOrderId, valueGetPayInfo, "orderId");
		
		logger.info("[步骤_11]. 执行取消影票订单接口(TICKET)");
		String interfaceResponse = InterFaceOwnData.payOrderWithCard(sid, cinemaLinkId, orderType, createTicketOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
	}
	
	@Test(groups={"P0"})
	public void TC_payOrderWithCardForGoods_Normal() throws InterruptedException {
		//会员卡支付卖品订单
		logger.info("[步骤_1]. 设置购买卖品数据");
		//key表示列表索引，value表示购买数量
		Map<Integer, Integer> setGoodsParamsInfo =new HashMap<Integer,Integer>();
		setGoodsParamsInfo.put(0, 1);
		setGoodsParamsInfo.put(1, 2);
		logger.info("[步骤_2]. 设置订单类型");
		//设置订单类型
		String orderType = "GOODS";
		
		logger.info("[步骤_3]. 使用正确数据登录，获取sid");
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		
		logger.info("[步骤_4]. 运行获取影院列表接口，获取cinemaLinkeId");
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0,"cinemaLinkId");
		
		logger.info("[步骤_5]. 运行获取卖品列表接口，根据setGoodsParamsInfo组装创建卖品订单入参");
		JSONObject valuesGetGoods = InterFaceOwnGetValueForOther.getGoodsParams(sid, cinemaLinkId, setGoodsParamsInfo);
	
		logger.info("[步骤_6]. 运行获取优惠、支付信息接口（GOODS）");
		JSONObject valueGetPayInfo = InterFaceOwnGetValueForOther.getPayInfoGoods(sid, cinemaLinkId, valuesGetGoods, 1, 1);
	
		logger.info("[步骤_7]. 运行创建卖品订单接口、获取orderId");
		JSONObject createGoodsOrderValue = InterFaceOwnGetValueForOther.getCreateGoodsOrder(sid, cinemaLinkId, valuesGetGoods, valueGetPayInfo, "orderId");
		
		logger.info("[步骤_8]. 执行取消卖品订单接口");
		String interfaceResponse = InterFaceOwnData.payOrderWithCard(sid, cinemaLinkId, orderType, createGoodsOrderValue);
		
		logger.info("[检查点_1]. 校验返回bizCode是否包含预期结果");
		Boolean bl = InterFaceOwnAssertion.assertBizCode("bizCode", interfaceResponse);
		Assert.assertEquals(bl.booleanValue(), true);
		
	}
	
	
}

