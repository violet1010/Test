package ykse.TestAutomation.Interface.Finixx.Test;
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
import ykse.TestAutomation.Interface.Finixx.Common.InterfaceBizHelper;
import ykse.TestAutomation.Interface.Finixx.Common.CommonRequestData;
import ykse.TestAutomation.Interface.Finixx.Common.CommonUntil;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxTicketAssertion;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxTicketData;

public class InterFaceFinixxTicketTest {
	Logger logger = new Log("interface_Finixx").logger;
	
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
	
    public JSONObject posGoods(){
		
		JSONObject data = new JSONObject();
		data.put("version", "1.0.0.1");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","59");
		return data;
		
	}
	
	/**
	*获取当天排期
	* @author lkg
	* @Time2016-04-18 11:44
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSession_getTodaySession() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		//调用接口
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSession_getTodaySession(res_Ticket_GetSession);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取全天排期信息(简易版)
	* @author zjh
	* @Time2016-04-20 10:00
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSessionNoExtraInfo_getTodaySession() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息(简易版)（Ticket_GetSessionNoExtraInfo）");
		String res_Ticket_GetSessionNoExtraInfo = InterfaceBizHelper.Ticket_GetSessionNoExtraInfo(InterFaceFinixxTicketData.Ticket_GetSessionExtraInfo());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSessionNoExtraInfo_getTodaySession(res_Ticket_GetSessionNoExtraInfo);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取某个的排期明细
	* @author lkg
	* @Time2016-04-18 11:44
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetSessionDetails_getDetailsBySessionCode() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		//调用Ticket_GetSession接口
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取某个的排期明细（Ticket_GetSessionDetails）");
		//获取sessionCode
		String SessionCode = CommonUntil.getSessionCodeByRespose(res_Ticket_GetSession);
		String res_Ticket_GetSessionDetails = "";
		if (!SessionCode.equals(""))
		{
			res_Ticket_GetSessionDetails = InterfaceBizHelper.Ticket_GetSessionDetails(InterFaceFinixxTicketData.Ticket_GetSessionDetails(SessionCode));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSessionDetails_getDetailsBySessionCode(res_Ticket_GetSessionDetails);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取排期影片信息
	* @author zjh
	* @Time2016-04-20 10:22
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetSessionFilms_GetOneFilm() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取排期影片信息（Ticket_GetSessionFilms）");
		String SessionFilm = CommonUntil.getSessionFilm(res_Ticket_GetSession);
		String res_Ticket_GetSessionFilms = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_GetSessionFilms = InterfaceBizHelper.Ticket_GetSessionFilms(InterFaceFinixxTicketData.Ticket_GetSessionFilms_GetOneFilm(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSessionFilms_GetOneFilm(res_Ticket_GetSessionFilms);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取排期影片信息
	* @author zjh
	* @Time2016-04-20 10:50
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetSessionFilms_GetOneFilmWithoutPicture() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取排期影片信息（Ticket_GetSessionFilms）");
		String SessionFilm = CommonUntil.getSessionFilm(res_Ticket_GetSession);
		String res_Ticket_GetSessionFilms = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_GetSessionFilms = InterfaceBizHelper.Ticket_GetSessionFilms(InterFaceFinixxTicketData.Ticket_GetSessionFilms_GetOneFilmWithoutPicture(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSessionFilms_GetOneFilmWithoutPicture(res_Ticket_GetSessionFilms);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取排期影片中的图片信息
	* @author zjh
	* @Time2016-04-20 11:10
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetFilmImage() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取排期影片中的图片信息（Ticket_GetFilmImage）");
		String SessionFilm = CommonUntil.getSessionFilm(res_Ticket_GetSession);
		String res_Ticket_GetSessionFilms = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_GetSessionFilms = InterfaceBizHelper.Ticket_GetFilmImage(InterFaceFinixxTicketData.Ticket_GetFilmImage(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetFilmImage(res_Ticket_GetSessionFilms);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取某一场次座位数量信息
	* @author zjh
	* @Time2016-04-20 14:00
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatCounts_AllSectionSeatCounts() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
        logger.info("[步骤_2]. 获取某一场次座位数量信息（Ticket_GetSeatCounts）");
        JSONObject SessionFilm = CommonUntil.getFilmInformation(res_Ticket_GetSession);
        String res_Ticket_GetSessionFilms = "";
        if (!SessionFilm.equals(""))
		{
			res_Ticket_GetSessionFilms = InterfaceBizHelper.Ticket_GetSeatCounts(InterFaceFinixxTicketData.Ticket_GetSeatCounts_AllSectionSeatCounts(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatCounts_AllSectionSeatCounts(res_Ticket_GetSessionFilms);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取某一场次座位数量信息
	* @author zjh
	* @Time2016-04-20 14:13
	*/	
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatCounts_ErrorSessionId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
        logger.info("[步骤_2]. 获取某一场次座位数量信息（Ticket_GetSeatCounts）");
        JSONObject SessionFilm = CommonUntil.getFilmInformation(res_Ticket_GetSession);
        String res_Ticket_GetSessionFilms = "";
        if (!SessionFilm.equals(""))
		{
			res_Ticket_GetSessionFilms = InterfaceBizHelper.Ticket_GetSeatCounts(InterFaceFinixxTicketData.Ticket_GetSeatCounts_ErrorSessionId(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatCounts_ErrorSessionId(res_Ticket_GetSessionFilms);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取全天排期座位数量信息
	* @author zjh
	* @Time2016-04-20 14:22
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetOneDateSeatCounts_GetTodaySeats() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1].获取全天排期座位数量信息（Ticket_GetOneDateSeatCounts）");
		String res_Ticket_GetOneDateSeatCounts = InterfaceBizHelper.Ticket_GetOneDateSeatCounts(InterFaceFinixxTicketData.Ticket_GetOneDateSeatCounts_GetTodaySeats());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetOneDateSeatCounts_GetTodaySeats(res_Ticket_GetOneDateSeatCounts);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取全天排期座位数量信息
	* @author zjh
	* @Time2016-04-20 14:50
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetOneDateSeatCounts_NorefSeqNo() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1].获取全天排期座位数量信息（Ticket_GetOneDateSeatCounts）");
		String res_Ticket_GetOneDateSeatCounts = InterfaceBizHelper.Ticket_GetOneDateSeatCounts(InterFaceFinixxTicketData.Ticket_GetOneDateSeatCounts_NorefSeqNo());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetOneDateSeatCounts_NorefSeqNo(res_Ticket_GetOneDateSeatCounts);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取影片视觉效果
	* @author zjh
	* @Time2016-04-20 15:05
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetFilmDimensional() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取影片视觉效果（Ticket_GetFilmDimensional）");
		String res_Ticket_GetFilmDimensional = InterfaceBizHelper.Ticket_GetFilmDimensional(InterFaceFinixxTicketData.Ticket_GetFilmDimensional());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetFilmDimensional(res_Ticket_GetFilmDimensional);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取影片载体信息
	* @author zjh
	* @Time2016-04-20 15:15
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetFilmCarriers() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取影片载体信息（Ticket_GetFilmCarriers）");
		String res_Ticket_GetFilmCarriers = InterfaceBizHelper.Ticket_GetFilmCarriers(InterFaceFinixxTicketData.Ticket_GetFilmCarriers());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetFilmCarriers(res_Ticket_GetFilmCarriers);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取场区信息
	* @author zjh
	* @Time2016-04-20 15:15
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSections_Code1008() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		//调用Ticket_GetSession接口
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		//获取sessionCode
		JSONObject SessionCode = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSessionDetails = "";
		if (!SessionCode.equals(""))
		{
			res_Ticket_GetSessionDetails = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionCode));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSections_Code1008(res_Ticket_GetSessionDetails);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取场区信息
	* @author zjh
	* @Time2016-04-20 15:45
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSections_Code1016() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取场区信息（Ticket_GetSections）");
		String res_Ticket_GetSections = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1016());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSections_Code1016(res_Ticket_GetSections);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取排期价格政策
	* @author zjh
	* @Time2016-04-20 16:00
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSessionPricePolicy() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_SessionId = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_SessionId = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionFilm));
			
		}
        logger.info("[步骤_3]. 获取排期价格政策（Ticket_GetSessionPricePolicy）");
        JSONObject SessionPricePolicy = CommonUntil.GetSessionId(res_Ticket_SessionId);
        String res_GetSessionPricePolicy = "";
        if (!SessionPricePolicy.equals(""))
		{
			res_GetSessionPricePolicy = InterfaceBizHelper.Ticket_GetSessionPricePolicy(InterFaceFinixxTicketData.Ticket_GetSessionPricePolicy(SessionFilm,SessionPricePolicy));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSessionPricePolicy(res_GetSessionPricePolicy);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取一段日期内的放映电影的影片信息
	* @author zjh
	* @Time2016-04-20 16:00
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetShowDateFilmInfo() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1].  获取一段日期内的放映电影的影片信息（Ticket_GetShowDateFilmInfo）");
		//调用接口
		String res_Ticket_GetFilmSession = InterfaceBizHelper.Ticket_GetShowDateFilmInfo(InterFaceFinixxTicketData.Ticket_GetShowDateFilmInfo());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetShowDateFilmInfo(res_Ticket_GetFilmSession);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取一段日期内的放映电影的影片信息
	* @author zjh
	* @Time2016-04-20 16:00
	*/
	@Test(groups={"P1"})
	public void TC_Ticket_GetShowDateFilmInfoNoChannelCd() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1].  获取一段日期内的放映电影的影片信息（Ticket_GetShowDateFilmInfo）");
		//调用接口
		String res_Ticket_GetFilmSession = InterfaceBizHelper.Ticket_GetShowDateFilmInfo(InterFaceFinixxTicketData.Ticket_GetShowDateFilmInfoNoChannelCd());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetShowDateFilmInfoNoChannelCd(res_Ticket_GetFilmSession);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取场次所有渠道价格及市场价信息
	* @author zjh
	* @Time2016-04-21 9:15
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllChannelPrice() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		//调用Ticket_GetSession接口
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_SessionId = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_SessionId = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionFilm));
			
		}
		logger.info("[步骤_3]. 获取场次所有渠道价格及市场价信息（Ticket_GetAllChannelPrice）");
		JSONObject GetSessionId = CommonUntil.GetSessionId(res_Ticket_SessionId);
		String res_Ticket_GetAllChannelPrice = "";
		if (!GetSessionId.equals(""))
		{
			res_Ticket_GetAllChannelPrice = InterfaceBizHelper.Ticket_GetAllChannelPrice(InterFaceFinixxTicketData.Ticket_GetAllChannelPrice(SessionFilm,GetSessionId));
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetAllChannelPrice(res_Ticket_GetAllChannelPrice);
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取影厅信息
	* @author zjh
	* @Time2016-04-21 9:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetHalls() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取影厅信息（Ticket_GetHalls）");
		String res_Ticket_GetHalls = InterfaceBizHelper.Ticket_GetHalls(InterFaceFinixxTicketData.Ticket_GetHalls());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetHalls(res_Ticket_GetHalls);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取座位图座位信息
	* @author zjh
	* @Time2016-04-21 9:35
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatPlan_GetFilmSessions() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		//调用Ticket_GetSession接口
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		//获取sessionCode
		JSONObject GetSeatPlan = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatPlan_GetFilmSessions = "";
		if (!GetSeatPlan.equals(""))
		{
			res_Ticket_GetSeatPlan_GetFilmSessions = InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSeatPlan));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatPlan_GetFilmSessions(res_Ticket_GetSeatPlan_GetFilmSessions);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*锁定某几个座位
	* @author zjh
	* @Time2016-04-21 9:50
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_RepositionSeats_CurrentMessage() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatPlan_GetFilmSessions = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatPlan_GetFilmSessions = InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSessionFilm));
			
		}
        logger.info("[步骤_3]. 锁定某几个座位（Ticket_RepositionSeats）");
        JSONObject Seats = CommonUntil.GetRepositionSeats(res_Ticket_GetSeatPlan_GetFilmSessions);
        String res_Ticket_RepositionSeats = "";
        if (!Seats.equals(""))
		{
			res_Ticket_RepositionSeats = InterfaceBizHelper.Ticket_RepositionSeats(InterFaceFinixxTicketData.Ticket_RepositionSeats_CurrentMessage(GetSessionFilm,Seats));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_RepositionSeats_CurrentMessage(res_Ticket_RepositionSeats);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*锁定某几个座位
	* @author zjh
	* @Time2016-04-22 8:50
	*/
	@Test(groups={"P1"})
	public void TC_Ticket_RepositionSeats_ErrorSeatMessage() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
        logger.info("[步骤_2]. 锁定某几个座位（Ticket_RepositionSeats）");
        JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
        String res_Ticket_RepositionSeats_ErrorSeatMessage = "";
        if (!GetSessionFilm.equals(""))
		{
		    res_Ticket_RepositionSeats_ErrorSeatMessage = InterfaceBizHelper.Ticket_RepositionSeats(InterFaceFinixxTicketData.Ticket_RepositionSeats_ErrorSeatMessage(GetSessionFilm));
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_RepositionSeats_ErrorSeatMessage(res_Ticket_RepositionSeats_ErrorSeatMessage);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*释放座位
	* @author zjh
	* @Time2016-04-26 9:50
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_ReleaseSeats_CorrentSeats() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatPlan_GetFilmSessions = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatPlan_GetFilmSessions = InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSessionFilm));
			
		}
        logger.info("[步骤_3]. 锁定某几个座位（Ticket_RepositionSeats）");
        JSONObject Seats = CommonUntil.GetRepositionSeats(res_Ticket_GetSeatPlan_GetFilmSessions);
        String res_Ticket_RepositionSeats = "";
        if (!Seats.equals(""))
		{
			res_Ticket_RepositionSeats = InterfaceBizHelper.Ticket_RepositionSeats(InterFaceFinixxTicketData.Ticket_RepositionSeats_CurrentMessage(GetSessionFilm,Seats));
			
		}
		logger.info("[步骤_4]. 释放座位（Ticket_ReleaseSeats）");
		JSONObject ReleaseSeats = CommonUntil.GetReleaseSeats(res_Ticket_RepositionSeats);
		String res_Ticket_ReleaseSeats_CorrentSeats = "";
        if (!ReleaseSeats.equals(""))
		{
        	res_Ticket_ReleaseSeats_CorrentSeats = InterfaceBizHelper.Ticket_ReleaseSeats(InterFaceFinixxTicketData.Ticket_ReleaseSeats_CorrentSeats(GetSessionFilm,Seats,ReleaseSeats));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_ReleaseSeats_CorrentSeats(res_Ticket_ReleaseSeats_CorrentSeats);
		Assert.assertEquals(result,true);
	}
	
	/**
	*释放座位
	* @author zjh
	* @Time2016-04-26 10:20
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_ReleaseSeats_ErrorSeats() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 释放座位（Ticket_ReleaseSeats）");
		String res_Ticket_ReleaseSeats_ErrorSeats = InterfaceBizHelper.Ticket_ReleaseSeats(InterFaceFinixxTicketData.Ticket_ReleaseSeats_ErrorSeats());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_ReleaseSeats_ErrorSeats(res_Ticket_ReleaseSeats_ErrorSeats);
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取场次已售出或锁定的座位信息
	* @author zjh
	* @Time2016-04-21 13:50
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllocateSeats() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_SessionId = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_SessionId = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionFilm));
			
		}
        logger.info("[步骤_3]. 获取场次已售出或锁定的座位信息（Ticket_GetAllocateSeats）");
        JSONObject GetSessionId = CommonUntil.GetSessionId(res_Ticket_SessionId);
        String res_Ticket_GetAllocateSeats = "";
        if (!GetSessionId.equals(""))
		{
			res_Ticket_GetAllocateSeats = InterfaceBizHelper.Ticket_GetAllocateSeats(InterFaceFinixxTicketData.Ticket_GetAllocateSeats(SessionFilm,GetSessionId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetAllocateSeats(res_Ticket_GetAllocateSeats);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*通过订单号获取场次已售出或锁定的座位信息
	* @author zjh
	* @Time2016-04-21 14:04
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllocateSeatBookingId_CurrentBookingId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 通过订单号获取场次已售出或锁定的座位信息（Ticket_GetAllocateSeatBookingId）");
		//调用接口
		String res_Ticket_GetAllocateSeatBookingId = InterfaceBizHelper.Ticket_GetAllocateSeatBookingId(InterFaceFinixxTicketData.Ticket_GetAllocateSeatBookingId_CurrentBookingId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetAllocateSeatBookingId_CurrentBookingId(res_Ticket_GetAllocateSeatBookingId);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*通过订单号获取场次已售出或锁定的座位信息
	* @author zjh
	* @Time2016-04-21 14:15
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllocateSeatBookingId_ErrorBookingId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 通过订单号获取场次已售出或锁定的座位信息（Ticket_GetAllocateSeatBookingId）");
		//调用接口
		String res_Ticket_GetAllocateSeatBookingId_ErrorBookingId = InterfaceBizHelper.Ticket_GetAllocateSeatBookingId(InterFaceFinixxTicketData.Ticket_GetAllocateSeatBookingId_ErrorBookingId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetAllocateSeatBookingId_CurrentBookingId(res_Ticket_GetAllocateSeatBookingId_ErrorBookingId);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取单个座位状态
	* @author zjh
	* @Time2016-04-21 14:23
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatStatus_CurrentSeatId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatPlan_GetFilmSessions = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatPlan_GetFilmSessions = InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSessionFilm));
			
		}
		logger.info("[步骤_3]. 获取单个座位状态（Ticket_GetSeatStatus）");
		JSONObject GetSeatId = CommonUntil.GetRepositionSeats(res_Ticket_GetSeatPlan_GetFilmSessions);
		String res_Ticket_GetSeatStatus_CurrentSeatId = "";
		if (!GetSeatId.equals(""))
		{
			res_Ticket_GetSeatStatus_CurrentSeatId = InterfaceBizHelper.Ticket_GetSeatStatus(InterFaceFinixxTicketData.Ticket_GetSeatStatus_CurrentSeatId(GetSessionFilm,GetSeatId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatStatus_CurrentSeatId(res_Ticket_GetSeatStatus_CurrentSeatId);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取单个座位状态
	* @author zjh
	* @Time2016-04-22 9:40
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatStatus_ErrorSeatId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取单个座位状态（Ticket_GetSeatStatus）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatStatus_ErrorSeatId = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatStatus_ErrorSeatId = InterfaceBizHelper.Ticket_GetSeatStatus(InterFaceFinixxTicketData.Ticket_GetSeatStatus_ErrorSeatId(GetSessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatStatus_ErrorSeatId(res_Ticket_GetSeatStatus_ErrorSeatId);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取座位编码
	* @author zjh
	* @Time2016-04-22 10:20
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatCode_CurrentSeats() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeat = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeat= InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSessionFilm));
			
		}
		logger.info("[步骤_3]. 获取座位编码（Ticket_GetSeatRowColId）");
		JSONObject GetSeatId = CommonUntil.GetRepositionSeats(res_Ticket_GetSeat);
		String res_Ticket_GetSeatCode_CurrentSeats = "";
		if (!GetSeatId.equals(""))
		{
			res_Ticket_GetSeatCode_CurrentSeats = InterfaceBizHelper.Ticket_GetSeatCode(InterFaceFinixxTicketData.TC_Ticket_GetSeatCode_CurrentSeats(GetSessionFilm,GetSeatId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatCode_CurrentSeats(res_Ticket_GetSeatCode_CurrentSeats);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取座位编码
	* @author zjh
	* @Time2016-04-22 10:40
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatCode_ErrorSeats() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位编码（Ticket_GetSeatRowColId）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatCode_ErrorSeats = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatCode_ErrorSeats = InterfaceBizHelper.Ticket_GetSeatCode(InterFaceFinixxTicketData.TC_Ticket_GetSeatCode_ErrorSeats(GetSessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatCode_ErrorSeats(res_Ticket_GetSeatCode_ErrorSeats);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取座位编码
	* @author zjh
	* @Time2016-04-21 14:45
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetSeatRowColId_CurrentseatCodes() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_GetSeatPlan_GetFilmSessions = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_GetSeatPlan_GetFilmSessions = InterfaceBizHelper.Ticket_GetSeatPlan(InterFaceFinixxTicketData.Ticket_GetSeatPlan_GetFilmSessions(GetSessionFilm));
			
		}
		logger.info("[步骤_3].  获取座位编码（Ticket_GetSeatRowColId）");
		JSONObject GetSeatId = CommonUntil.GetRepositionSeats(res_Ticket_GetSeatPlan_GetFilmSessions);
		String res_Ticket_GetSeatRowColId_CurrentseatCodes = "";
		if (!GetSeatId.equals(""))
		{
			res_Ticket_GetSeatRowColId_CurrentseatCodes = InterfaceBizHelper.Ticket_GetSeatRowColId(InterFaceFinixxTicketData.TC_Ticket_GetSeatRowColId_CurrentseatCodes(GetSeatId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetSeatRowColId_CurrentseatCodes(res_Ticket_GetSeatRowColId_CurrentseatCodes);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取座位编码
	* @author zjh
	* @Time2016-04-22 10:55
	*/
	@Test(groups={"P1"})
	public void TC_Ticket_GetSeatRowColId_ErrorseatCodes() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取座位编码（Ticket_GetSeatRowColId）");
		String res_Ticket_GetSeatRowColId_ErrorseatCodes = InterfaceBizHelper.Ticket_GetSeatRowColId(InterFaceFinixxTicketData.Ticket_GetSeatRowColId_ErrorseatCodes());
		result = InterFaceFinixxTicketAssertion.TA_TC_Ticket_GetSeatRowColId_ErrorseatCodes(res_Ticket_GetSeatRowColId_ErrorseatCodes);
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取渠道限制政策
	* @author zjh
	* @Time2016-04-21 15:05
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetChannelSeatPolicy() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取渠道限制政策（Ticket_GetChannelSeatPolicy）");
		//调用接口
		String res_Ticket_GetChannelSeatPolicy = InterfaceBizHelper.Ticket_GetChannelSeatPolicy(InterFaceFinixxTicketData.Ticket_GetChannelSeatPolicy());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatPolicy(res_Ticket_GetChannelSeatPolicy);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取渠道限制座位信息
	* @author zjh
	* @Time2016-04-22 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetChannelSeatDetails_CurrentPolicyId() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 获取渠道限制座位信息（Ticket_GetChannelSeatDetails）");
		//调用接口
		String res_Ticket_GetChannelSeatDetails_CurrentPolicyId = InterfaceBizHelper.Ticket_GetChannelSeatDetails(InterFaceFinixxTicketData.TC_Ticket_GetChannelSeatDetails_CurrentPolicyId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatDetails_CurrentPolicyId(res_Ticket_GetChannelSeatDetails_CurrentPolicyId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取渠道限制座位信息
	* @author zjh
	* @Time2016-04-22 11:45
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetChannelSeatDetails_ErrorPolicyId() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 获取渠道限制座位信息（Ticket_GetChannelSeatDetails）");
		//调用接口
		String res_Ticket_GetChannelSeatDetails_ErrorPolicyId = InterfaceBizHelper.Ticket_GetChannelSeatDetails(InterFaceFinixxTicketData.TC_Ticket_GetChannelSeatDetails_ErrorPolicyId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatDetails_ErrorPolicyId(res_Ticket_GetChannelSeatDetails_ErrorPolicyId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取渠道限制座位信息
	* @author zjh
	* @Time2016-04-22 13:05
	*/
	@Test(groups={"P1"})
	public void TC_Ticket_GetChannelSeatDetails_NoPolicyId() throws InterruptedException {
        boolean result = false;
		logger.info("[步骤_1]. 获取渠道限制座位信息（Ticket_GetChannelSeatDetails）");
		//调用接口
		String res_Ticket_GetChannelSeatDetails_NoPolicyId = InterfaceBizHelper.Ticket_GetChannelSeatDetails(InterFaceFinixxTicketData.TC_Ticket_GetChannelSeatDetails_NoPolicyId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatDetails_NoPolicyId(res_Ticket_GetChannelSeatDetails_NoPolicyId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*通过场次获取渠道限制座位信息
	* @author zjh
	* @Time2016-04-21 15:05
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject GetSessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_showdata = "";
		if (!GetSessionFilm.equals(""))
		{
			res_Ticket_showdata = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(GetSessionFilm));
			
		}
		logger.info("[步骤_3]. 通过场次获取渠道限制座位信息（Ticket_GetChannelSeatDetailsByShow）");
		JSONObject GetSectionId = CommonUntil.GetSessionId(res_Ticket_showdata);
		String res_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId = "";
		if (!GetSectionId.equals(""))
		{
			res_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId = InterfaceBizHelper.Ticket_GetChannelSeatDetailsByShow(InterFaceFinixxTicketData.Ticket_GetChannelSeatDetailsByShow_CurrentSessionId(GetSessionFilm,GetSectionId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId(res_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*通过场次获取渠道限制座位信息
	* @author zjh
	* @Time2016-04-22 13:25
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetChannelSeatDetailsByShow_WithoutSessionId() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 通过场次获取渠道限制座位信息（Ticket_GetChannelSeatDetailsByShow）");
		//调用接口
		String res_Ticket_GetChannelSeatDetailsByShow_WithoutSessionId = InterfaceBizHelper.Ticket_GetChannelSeatDetailsByShow(InterFaceFinixxTicketData.Ticket_GetChannelSeatDetailsByShow_WithoutSessionId());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetChannelSeatDetailsByShow_WithoutSessionId(res_Ticket_GetChannelSeatDetailsByShow_WithoutSessionId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取最大的连续座位数量
	* @author zjh
	* @Time2016-04-21 15:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetMaxThroughSeatCount() {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_SessionId = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_SessionId = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionFilm));
			
		}
        logger.info("[步骤_3]. 获取最大的连续座位数量（Ticket_GetMaxThroughSeatCount）");
        JSONObject GetsectionId = CommonUntil.GetSessionId(res_Ticket_SessionId);
        String res_Ticket_GetMaxThroughSeatCount = "";
        if (!GetsectionId.equals(""))
		{
			res_Ticket_GetMaxThroughSeatCount = InterfaceBizHelper.Ticket_GetMaxThroughSeatCount(InterFaceFinixxTicketData.Ticket_GetMaxThroughSeatCount(SessionFilm,GetsectionId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetMaxThroughSeatCount(res_Ticket_GetMaxThroughSeatCount);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取最大的连续座位数量
	* @author zjh
	* @Time2016-04-21 15:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetMaxThroughSeatCount_ErrorSectionId() {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
        logger.info("[步骤_2]. 获取最大的连续座位数量（Ticket_GetMaxThroughSeatCount）");
        JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
        String res_Ticket_GetMaxThroughSeatCount_ErrorSectionId = "";
        if (!SessionFilm.equals(""))
		{
			res_Ticket_GetMaxThroughSeatCount_ErrorSectionId = InterfaceBizHelper.Ticket_GetMaxThroughSeatCount(InterFaceFinixxTicketData.Ticket_GetMaxThroughSeatCount_ErrorSectionId(SessionFilm));
			
		}
		result = InterFaceFinixxTicketAssertion.TATicket_GetMaxThroughSeatCount_ErrorSectionId(res_Ticket_GetMaxThroughSeatCount_ErrorSectionId);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取付款信息
	* @author zjh
	* @Time2016-04-21 15:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetPaymentTypes() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取付款信息（Ticket_GetPaymentTypes）");
		//调用接口
		String res_Ticket_GetPaymentTypes = InterfaceBizHelper.Ticket_GetPaymentTypes(InterFaceFinixxTicketData.Ticket_GetPaymentTypes());
		//返回断言
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetPaymentTypes(res_Ticket_GetPaymentTypes);
	
		Assert.assertEquals(result, true);
	}
	
	/**
	*获取全场未退票订单号
	* @author zjh
	* @Time2016-04-21 16:00
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllSessionBookingId_CurrentSessionCode() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
		logger.info("[步骤_2]. 获取场区信息（Ticket_GetSections）");
		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
		String res_Ticket_SessionId = "";
		if (!SessionFilm.equals(""))
		{
			res_Ticket_SessionId = InterfaceBizHelper.Ticket_GetSections(InterFaceFinixxTicketData.Ticket_GetSections_Code1008(SessionFilm));
			
		}
        logger.info("[步骤_3]. 获取全场未退票订单号（Ticket_GetAllSessionBookingId）");
        JSONObject SessionId = CommonUntil.GetSessionId(res_Ticket_SessionId);
        String res_Ticket_GetAllSessionBookingId = "";
        if (!SessionId.equals(""))
		{
        	res_Ticket_GetAllSessionBookingId = InterfaceBizHelper.Ticket_GetAllSessionBookingId(InterFaceFinixxTicketData.Ticket_GetAllSessionBookingId(SessionFilm,SessionId));
			
		}
		result = InterFaceFinixxTicketAssertion.TA_Ticket_GetAllSessionBookingId(res_Ticket_GetAllSessionBookingId);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取全场未退票订单号
	* @author zjh
	* @Time2016-04-21 16:20
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_GetAllSessionBookingId_ErrorSessionCode() throws InterruptedException {
		boolean result = false;
        logger.info("[步骤_1]. 获取全场未退票订单号（Ticket_GetAllSessionBookingId）");
        String res_Ticket_GetAllSessionBookingId_ErrorSessionCode = InterfaceBizHelper.Ticket_GetAllSessionBookingId(InterFaceFinixxTicketData.Ticket_GetAllSessionBookingId_ErrorSessionCode());
		result = InterFaceFinixxTicketAssertion.TA_res_Ticket_GetAllSessionBookingId_ErrorSessionCode(res_Ticket_GetAllSessionBookingId_ErrorSessionCode);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取影票信息码
	* @author zjh
	* @Time2016-04-25 14:20
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_CreateInfoCode_Current() throws InterruptedException {
		boolean result = false;
        logger.info("[步骤_1]. 获取影票信息码（Ticket_CreateInfoCode）");
        String res_Ticket_CreateInfoCode_Current = InterfaceBizHelper.Ticket_CreateInfoCode(InterFaceFinixxTicketData.Ticket_CreateInfoCode_Current());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_CreateInfoCode_Current(res_Ticket_CreateInfoCode_Current);
		Assert.assertEquals(result,true);
	}
	
	/**
	*获取影票信息码
	* @author zjh
	* @Time2016-04-25 15:00
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_CreateInfoCode_ErrorBookingId() throws InterruptedException {
		boolean result = false;
        logger.info("[步骤_1]. 获取影票信息码（Ticket_CreateInfoCode）");
        String res_Ticket_CreateInfoCode_ErrorBookingId = InterfaceBizHelper.Ticket_CreateInfoCode(InterFaceFinixxTicketData.Ticket_CreateInfoCode_ErrorBookingId());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_CreateInfoCode_Current(res_Ticket_CreateInfoCode_ErrorBookingId);
		Assert.assertEquals(result,true);
	}
	
//	/**
//	*根据卡号获取全部场次会员价
//	* @author zjh
//	* @Time2016-04-21 16:40
//	*/
//	@Test(groups={"P0"})
//	public void TC_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD() throws InterruptedException {
//		boolean result = false;
//		
//		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
//		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
//		logger.info("[步骤_2]. 根据卡号获取全部场次会员价（Card_GetAllSessionPricePolicy）");
//		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
//		String res_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD = "";
//        if (!SessionFilm.equals(""))
//		{
//        	res_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD = InterfaceBizHelper.Card_GetAllSessionPricePolicy(InterFaceFinixxTicketData.Card_GetAllSessionPricePolicy_CurrentCardFacadeCD(SessionFilm));
//			
//		}
//		result = InterFaceFinixxTicketAssertion.TA_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD(res_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD);
//	
//		Assert.assertEquals(result,true);
//	}
//	
//	/**
//	*根据卡号获取全部场次会员价
//	* @author zjh
//	* @Time2016-04-22 14:00
//	*/
//	@Test(groups={"P0"})
//	public void TC_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD() throws InterruptedException {
//		boolean result = false;
//		logger.info("[步骤_1]. 获取全天排期信息（Ticket_GetSession）");
//		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
//		logger.info("[步骤_2]. 根据卡号获取全部场次会员价（Card_GetAllSessionPricePolicy）");
//		JSONObject SessionFilm = CommonUntil.getFilmDateAndCinemaCD(res_Ticket_GetSession);
//		String res_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD = "";
//        if (!SessionFilm.equals(""))
//		{
//        	res_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD = InterfaceBizHelper.Card_GetAllSessionPricePolicy(InterFaceFinixxTicketData.Card_GetAllSessionPricePolicy_ErrorCardFacadeCD(SessionFilm));
//			
//		}
//		result = InterFaceFinixxTicketAssertion.TA_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD(res_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD);
//	
//		Assert.assertEquals(result,true);
//	}
	
	/**
	*混合退单接口
	* @author zjh
	* @Time2016-04-28 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_Refund_BoPos_Order() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 3.1混合退单接口(Ticket_Refund_BoPos_Order)");
		String res_Ticket_Refund_BoPos_Order = InterfaceBizHelper.Ticket_Refund_BoPos_Order(InterFaceFinixxTicketData.Ticket_Refund_BoPos_Order());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_Refund_BoPos_Order(res_Ticket_Refund_BoPos_Order);
		Assert.assertEquals(result,true);
	}
		
	/**
	*混合退单接口
	* @author zjh
	* @Time2016-04-28 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_Refund_BoPos_Order_Object() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 3.1混合退单接口(Ticket_Refund_BoPos_Order)");
		String res_Ticket_Refund_BoPos_Order = InterfaceBizHelper.Ticket_Refund_BoPos_Order(InterFaceFinixxTicketData.Ticket_Refund_BoPos_Order_Object());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_Refund_BoPos_Order(res_Ticket_Refund_BoPos_Order);
		Assert.assertEquals(result,true);
	}
	
	/**
	*会员混合退卡接口
	* @author lkg
	* @Time2016-04-28 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_Card_Refund_BoPos_Object() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 3.2会员混合退卡接口(Card_Refund_BoPos)");
		String res_Ticket_Card_Refund_BoPos = InterfaceBizHelper.Ticket_Card_Refund_BoPos(InterFaceFinixxTicketData.Ticket_Card_Refund_BoPos_Order_Object());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_Card_Refund_BoPos(res_Ticket_Card_Refund_BoPos);
		Assert.assertEquals(result,true);
	}
	
	/**
	*会员混合退卡接口
	* @author zjh
	* @Time2016-04-28 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_Card_Refund_BoPos() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 3.2会员混合退卡接口(Card_Refund_BoPos)");
		String res_Ticket_Card_Refund_BoPos = InterfaceBizHelper.Ticket_Card_Refund_BoPos(InterFaceFinixxTicketData.Ticket_Card_Refund_BoPos());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_Card_Refund_BoPos(res_Ticket_Card_Refund_BoPos);
		Assert.assertEquals(result,true);
	}
	
	/**
	*会员混合退卡接口
	* @author zjh
	* @Time2016-04-28 11:30
	*/
	@Test(groups={"P0"})
	public void TC_Ticket_Card_Refund_BoPos_RollBack() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 3.3会员混合退卡回滚接口(Card_Refund_BoPos_RollBack)");
		String res_Ticket_Card_Refund_BoPos_RollBack = InterfaceBizHelper.Ticket_Card_Refund_BoPos_RollBack(InterFaceFinixxTicketData.Ticket_Card_Refund_BoPos_RollBack());
		result = InterFaceFinixxTicketAssertion.TA_Ticket_Card_Refund_BoPos_RollBack(res_Ticket_Card_Refund_BoPos_RollBack);
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSessionFilms_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取排期影片信息（Ticket_GetSessionFilms）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1005");
		
		//文档要求
		//必须
		data.put("imageFlg","true");
		//可选
		ArrayList<String> list = new ArrayList<String>();
		list.add("05110039201601");
		data.put("listFilmCd",list);
		
		String res = InterfaceBizHelper.Ticket_GetSessionFilms(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetFilmImage_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取排期影片中的图片信息（Ticket_GetFilmImage）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1058");
		
		//文档要求
		//必须
		ArrayList<String> list = new ArrayList<String>();
		list.add("05110039201601");
		data.put("listFilmCd",list);
		//可选
		
		String res = InterfaceBizHelper.Ticket_GetFilmImage(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSeatCounts_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取某一场次座位数量信息（Ticket_GetSeatCounts）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1007");

		//文档要求
		//必须  
		data.put("showDate","2016-04-14");
		data.put("showTime",1005);
		data.put("filmCd","05110039201601");
		data.put("cinemaCd","5");
		data.put("sectionId","0000000000000001");
		//可选
		
		String res = InterfaceBizHelper.Ticket_GetSeatCounts(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetOneDateSeatCounts_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取全天排期座位数量信息（Ticket_GetOneDateSeatCounts）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1057");
		
		//文档要求
		//必须  
		data.put("showDate","2016-04-14");
		
		//可选
		
		String res = InterfaceBizHelper.Ticket_GetOneDateSeatCounts(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetFilmCarriers_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取影片载体信息（Ticket_GetFilmCarriers）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1011");
		
		String res = InterfaceBizHelper.Ticket_GetFilmCarriers(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetFilmDimensional_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取影片视觉效果（Ticket_GetFilmDimensional）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1012");
		
		String res = InterfaceBizHelper.Ticket_GetFilmDimensional(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSessionPricePolicy_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取排期价格政策（Ticket_GetSessionPricePolicy）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1014");
		
		//文档要求
		data.put("showRefSeqNo","6811604142206D0N6X");
		data.put("sectionId","0000000000000001");
		data.put("systemCd","BO");
//		data.put("throughId","");
		data.put("throughFlg","false");
//		data.put("throughSeqNo","");
//		data.put("cardLocationCd","");
//		data.put("cardFacadeCd","");
		
		String res = InterfaceBizHelper.Ticket_GetSessionPricePolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetShowDateFilmInfo_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取一段日期内的放映电影的影片信息（Ticket_GetShowDateFilmInfo）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1045");
		
		//文档要求
		//必须  
		data.put("startDate","2016-04-13");
		data.put("endDate","2016-04-14");
		data.put("channelCd","BO");
		//可选
		
		String res = InterfaceBizHelper.Ticket_GetShowDateFilmInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetAllChannelPrice_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取场次所有渠道价格及市场价信息（Ticket_GetAllChannelPrice）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1049");
		
		//文档要求
		//必须  
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject ShowRefSeqNoOrThroughIdNode = new JSONObject();
		ShowRefSeqNoOrThroughIdNode.put("showRefSeqNoOrThroughId","6811604142206D0N6X");
		ShowRefSeqNoOrThroughIdNode.put("throughFlg",false);
		list.add(ShowRefSeqNoOrThroughIdNode);
		data.put("showRefSeqNoOrThroughIds",list);

		String res = InterfaceBizHelper.Ticket_GetAllChannelPrice(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}

	@Test
	public void TC_Ticket_GetHalls_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取影厅信息（Ticket_GetHalls）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1006");
		
		String res = InterfaceBizHelper.Ticket_GetHalls(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSections_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取场区信息（Ticket_GetSections）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1008");//1016查询所有影厅场区
		
		//文档要求
		//可选
		data.put("showDate","2016-04-14");
		data.put("cinemaCd","5");
		
		String res = InterfaceBizHelper.Ticket_GetSections(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSeatPlan_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取座位图座位信息（Ticket_GetSeatPlan）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1009");
		
		//文档要求
		//可选
		data.put("showDate","2016-04-14");
		data.put("cinemaCd","5");
		
		String res = InterfaceBizHelper.Ticket_GetSeatPlan(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_RepositionSeats_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 锁定某几个座位（Ticket_RepositionSeats）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1001");
		
		//文档要求
		//必须
		data.put("showDate","2016-04-14");
		data.put("showTime",1005);
		data.put("filmCd","05110039201601");
		data.put("cinemaCd","5");
		data.put("sectionId","0000000000000001");
		ArrayList<String> list = new ArrayList<String>();
		list.add("0:01");
		data.put("seats",list);
		data.put("requestUserId","admin");
		data.put("requestWorkStationId","SP");//可选
		data.put("tempBookingId","111111");
		data.put("boBlock","false");
		data.put("throughFlg","false");
		data.put("releaseTime","60");
		
		String res = InterfaceBizHelper.Ticket_RepositionSeats(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_ReleaseSeats_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 释放座位（Ticket_ReleaseSeats）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1003");
		
		//文档要求
		//必须
		data.put("showDate","2016-04-13");
		data.put("showTime",1005);
		data.put("filmCd","0510039201601");
		data.put("cinemaCd","5");
		data.put("sectionId","0000000000000001");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1:01");
		data.put("seats",list);
		data.put("requestUserId","admin");
		//data.put("requestWorkStationId","SP");//可选
		data.put("tempBookingId","111111");
		data.put("boBlock","false");
		data.put("throughFlg","false");
		data.put("releaseTime","60");
		
		String res = InterfaceBizHelper.Ticket_ReleaseSeats(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetAllocateSeats_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取场次已售出或锁定的座位信息（Ticket_GetAllocateSeats）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1013");

		//文档要求
		//必须
		data.put("showDate","2016-04-13");
		data.put("showTime",1005);
		data.put("filmCd","0510039201601");
		data.put("cinemaCd","5");
		data.put("sectionId","0000000000000001");
		data.put("cacheFlg","false");
		
		String res = InterfaceBizHelper.Ticket_GetAllocateSeats(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetAllocateSeatBookingId_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 通过订单号获取场次已售出或锁定的座位信息（Ticket_GetAllocateSeatBookingId）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1059");

		//文档要求
		//必须
		data.put("bookingId"," ");
		
		String res = InterfaceBizHelper.Ticket_GetAllocateSeatBookingId(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSeatStatus_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取单个座位状态（Ticket_GetSeatStatus）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1015");
		
		//文档要求
		//必须
		data.put("showDate","2016-04-13");
		data.put("showTime",1005);
		data.put("filmCd","0510039201601");
		data.put("cinemaCd","5");
		data.put("sectionId","0000000000000001");
		data.put("rowId","1");
		data.put("colId","01");
		
		String res = InterfaceBizHelper.Ticket_GetSeatStatus(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSeatCode_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取座位编码（Ticket_GetSeatCode）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1046");
		
		//文档要求
		//必须
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject GetSeatCodeNode = new JSONObject();
		GetSeatCodeNode.put("seqNo","1");
		GetSeatCodeNode.put("rowId","1");
		GetSeatCodeNode.put("colId","01");
		GetSeatCodeNode.put("sectionId","0000000000000001");
		GetSeatCodeNode.put("cinemaCd","5");
		GetSeatCodeNode.put("showDate","2016-04-13");
		list.add(GetSeatCodeNode);
		data.put("seatCodes",list);
		
		String res = InterfaceBizHelper.Ticket_GetSeatCode(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetSeatRowColId_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取座位编码（Ticket_GetSeatRowColId）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1047");
		
		//文档要求
		//必须
		ArrayList<String> list = new ArrayList<String>();
		list.add("0000000000008409");
		data.put("seatCodes",list);
		
		String res = InterfaceBizHelper.Ticket_GetSeatRowColId(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetChannelSeatPolicy_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取渠道限制政策（Ticket_GetChannelSeatPolicy）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1061");
		
		String res = InterfaceBizHelper.Ticket_GetChannelSeatPolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetChannelSeatDetails_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取渠道限制座位信息（Ticket_GetChannelSeatDetails）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1062");
		
		//文档要求
		//必须
		data.put("policyId","001");
		//可选
//		data.put("LocationCd","");
//		data.put("SectionId","");
//		data.put("CinemaCd","");
		
		String res = InterfaceBizHelper.Ticket_GetChannelSeatDetails(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetChannelSeatDetailsByShow_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 通过场次获取渠道限制座位信息（Ticket_GetChannelSeatDetailsByShow）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1063");
		
		//文档要求
		//必须
		data.put("ChannelCd","BO");
		data.put("LocationCd","681");
		data.put("CinemaCd","5");
		data.put("ShowDate","2016-04-13");
		data.put("ShowTime","1005");
		//可选
		data.put("SectionId","0000000000000001");
		
		String res = InterfaceBizHelper.Ticket_GetChannelSeatDetailsByShow(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetMaxThroughSeatCount_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取最大的连续座位数量（Ticket_GetMaxThroughSeatCount）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1064");
		
		//文档要求
		//必须
		data.put("ChannelCd","BO");
		data.put("FilmCd", "0510039201601");
		data.put("LocationCd","681");
		data.put("CinemaCd","5");
		data.put("ShowDate","2016-04-13");
		data.put("ShowTime","1005");
		data.put("SectionId","0000000000000001");
		//可选
		data.put("SeatType","");
		
		String res = InterfaceBizHelper.Ticket_GetMaxThroughSeatCount(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_GetAllSessionBookingId_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取全场未退票订单号（Ticket_GetAllSessionBookingId）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1065");
		
		//文档要求
		//必须
		data.put("sessionCode","0000000000008409");
		data.put("sectionId","0000000000000001");
		
		String res = InterfaceBizHelper.Ticket_GetAllSessionBookingId(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Ticket_CreateInfoCode_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取影票信息码（Ticket_CreateInfoCode）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1066");
		
		//文档要求
		//必须
		data.put("refSeqNoOrThroughId","");
		data.put("throughFlg","");
		ArrayList<String> list = new ArrayList<String>();
		list.add("ticketNo");
		list.add("bookingId");
		list.add("rowId");
		list.add("colId");
		list.add("priceAmt");
		list.add("bookingFeeAmt");
		list.add("serviceFee");
		list.add("sectionId");
		data.put("tickets", list);
		
		String res = InterfaceBizHelper.Ticket_CreateInfoCode(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
//	@Test
//	public void TC_Ticket_CreateInfoCode_DUBUG() throws InterruptedException {
//		logger.warn("****开始执行用例****");
//		logger.info("步骤_1. 获取影票信息码（Ticket_CreateInfoCode）");
//		JSONObject data = new JSONObject();
//		//固定
//		data.put("code", "1066");
//		data.put("version", "1.0.0.0");
//		data.put("serialNumber","635954467784333968");
//		data.put("userName","BO");
//		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
//		data.put("locationcd","681");
//		//文档要求
//		//必须
//		data.put("refSeqNoOrThroughId","");
//		data.put("throughFlg","");
//		ArrayList list = new ArrayList();
//		list.add("ticketNo");
//		list.add("bookingId");
//		list.add("rowId");
//		list.add("colId");
//		list.add("priceAmt");
//		list.add("bookingFeeAmt");
//		list.add("serviceFee");
//		list.add("sectionId");
//		data.put("tickets", list);
//		
//		String res = InterfaceBizHelper.Ticket_CreateInfoCode(data);
//		// 检查返回是否如预期
//		logger.info("检查点_1. 检查返回内容是否为空");
//		boolean result = false;
//		if(!res.isEmpty())
//		{
//			result = true;
//		}
//		logger.warn("****用例执行结束****");
//		Assert.assertEquals(result,true);
//	}
	
	@Test
	public void TC_Ticket_GetPaymentTypes_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取付款信息（Ticket_GetPaymentTypes）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1068");
		
		String res = InterfaceBizHelper.Ticket_GetPaymentTypes(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetAllSessionPricePolicy_DUBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 根据卡号获取全部场次会员价（Card_GetAllSessionPricePolicy）");
		JSONObject data = posGoods();
		//固定
		data.put("code", "1075");

		//文档要求
		//必须
		data.put("ChannelCd", "BO");
		data.put("LocationCd", "681");
		data.put("CardLocationCd", "681");//可选
		data.put("ShowDate", "2016-04-14");
		data.put("CardFacadeCD", "");
		data.put("LeastPriceFlg", "");//可选
		
		String res = InterfaceBizHelper.Card_GetAllSessionPricePolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
}


