package ykse.TestAutomation.Interface.Finixx.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import ykse.TestAutomation.Common.Log;

public class InterFaceFinixxTicketData {
	Logger logger = new Log("interface_Finixx").logger;
	
	public static JSONObject Ticket_GetSession()
	{
		CommonRequestData crd = new CommonRequestData("1004", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("showDate",CommonUntil.getToday());
		defaultData.put("systemCD","BO");
		return defaultData;
	}
	
	public static JSONObject Ticket_GetSession(JSONObject obj)
	{
		CommonRequestData crd = new CommonRequestData("1004", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject requestData = CommonUntil.JoinJsonObject(defaultData, obj);
		return requestData;
	}
	
	public static JSONObject Ticket_GetSessionExtraInfo()
	{
		CommonRequestData crd = new CommonRequestData("1056", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("showDate",CommonUntil.getToday());
		defaultData.put("systemCD","BO");
		return defaultData;
	}
	
	public static JSONObject Ticket_GetSessionExtraInfo(JSONObject obj)
	{
		CommonRequestData crd = new CommonRequestData("1056", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject requestData = CommonUntil.JoinJsonObject(defaultData, obj);
		return requestData;
	}
	
	public static JSONObject Ticket_GetSessionDetails(String SessionCode)
	{
		CommonRequestData crd = new CommonRequestData("1033", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("requestType","2");
		data.put("refSeqNoOrThroughIdOrSessionCode",SessionCode);
		return data;
	}
	
	public static JSONObject Ticket_GetSessionDetails(JSONObject obj)
	{
		CommonRequestData crd = new CommonRequestData("1033", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject requestData = CommonUntil.JoinJsonObject(defaultData, obj);
		return requestData;
	}

	public static JSONObject Ticket_GetSessionFilms_GetOneFilm(String SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1005", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("imageFlg","true");
		ArrayList<String> list = new ArrayList<String>();
		list.add(SessionFilm);
		data.put("listFilmCd",list);
		return data;
	}
	
	public static JSONObject Ticket_GetSessionFilms_GetOneFilmWithoutPicture(String SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1005", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("imageFlg","false");
		ArrayList<String> list = new ArrayList<String>();
		list.add(SessionFilm);
		data.put("listFilmCd",list);
		return data;
	}
	
	public static JSONObject Ticket_GetFilmImage(String SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1058", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		ArrayList<String> list = new ArrayList<String>();
		list.add(SessionFilm);
		data.put("listFilmCd",list);
		return data;
	}
	
	public static JSONObject Ticket_GetSeatCounts_AllSectionSeatCounts(JSONObject SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1007", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",SessionFilm.get("showDate"));
		data.put("showTime",SessionFilm.get("showTime"));
		data.put("filmCd",SessionFilm.get("filmCd"));
		data.put("cinemaCd",SessionFilm.get("cinemaCd"));
		data.put("sectionId",SessionFilm.get("sectionId"));
		return data;
	}
	
	public static JSONObject Ticket_GetSeatCounts_ErrorSessionId(JSONObject SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1007", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",SessionFilm.get("showDate"));
		data.put("showTime",SessionFilm.get("showTime"));
		data.put("filmCd",SessionFilm.get("filmCd"));
		data.put("cinemaCd",SessionFilm.get("cinemaCd"));
		data.put("sectionId","sdsadadsad");
		return data;
	}
	
	public static JSONObject Ticket_GetOneDateSeatCounts_GetTodaySeats()
	{
		CommonRequestData crd = new CommonRequestData("1057", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("showDate",CommonUntil.getToday());
		return defaultData;
	}

	public static JSONObject Ticket_GetOneDateSeatCounts_NorefSeqNo() {
		CommonRequestData crd = new CommonRequestData("1057", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("showDate","2032-02-03");
		return defaultData;
	}

	public static JSONObject Ticket_GetFilmDimensional() {
		CommonRequestData crd = new CommonRequestData("1012", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Ticket_GetFilmCarriers() {
		CommonRequestData crd = new CommonRequestData("1011", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Ticket_GetSections_Code1008(JSONObject SessionFilm) {
		CommonRequestData crd = new CommonRequestData("1008", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",SessionFilm.get("showDate"));
		data.put("cinemaCd",SessionFilm.get("cinemaCd"));
		return data;
	}
	
	public static JSONObject Ticket_GetSections_Code1016() {
		CommonRequestData crd = new CommonRequestData("1016", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("showDate","");
		defaultData.put("cinemaCd","");
		return defaultData;
	}
	
	public static JSONObject Ticket_GetSessionPricePolicy(JSONObject SessionFilm,JSONObject SessionPricePolicy) {
		CommonRequestData crd = new CommonRequestData("1014", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showRefSeqNo",SessionFilm.get("showRefSeqNo"));
		data.put("sectionId",SessionPricePolicy.get("sectionID"));
		data.put("systemCd","BO");
		data.put("throughFlg",SessionFilm.get("throughFlg"));
		return data;
	}
	
	public static JSONObject Ticket_GetShowDateFilmInfo()
	{
		CommonRequestData crd = new CommonRequestData("1045", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("startDate",CommonUntil.getToday());
		defaultData.put("endDate",CommonUntil.getToday());
		defaultData.put("channelCd","BO");
		return defaultData;
	}

	public static JSONObject Ticket_GetShowDateFilmInfoNoChannelCd() {
		CommonRequestData crd = new CommonRequestData("1045", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("startDate",CommonUntil.getToday());
		defaultData.put("endDate",CommonUntil.getToday());
		defaultData.put("channelCd","");
		return defaultData;
	}
	
	public static JSONObject Ticket_GetAllChannelPrice(JSONObject RefSeqNo,JSONObject SectionId) {
		CommonRequestData crd = new CommonRequestData("1049", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject ShowRefSeqNoOrThroughIdNode = new JSONObject();
		ShowRefSeqNoOrThroughIdNode.put("showRefSeqNoOrThroughId",RefSeqNo.get("showRefSeqNo"));
		ShowRefSeqNoOrThroughIdNode.put("throughFlg",RefSeqNo.get("throughFlg"));
		//ShowRefSeqNoOrThroughIdNode.put("ChannelCd","BO");
		list.add(ShowRefSeqNoOrThroughIdNode);
		//data.put("ChannelCd","BO");
		data.put("showRefSeqNoOrThroughIds", list);
		//data.put("SectionId", SectionId.get("sectionID"));
		return data;
	}
	
	public static JSONObject Ticket_GetHalls() {
		CommonRequestData crd = new CommonRequestData("1006", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}

	public static JSONObject Ticket_GetSeatPlan_GetFilmSessions(JSONObject getSeatPlan) {
		CommonRequestData crd = new CommonRequestData("1009", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",getSeatPlan.get("showDate"));
		data.put("cinemaCd",getSeatPlan.get("cinemaCd"));
		return data;
	}
	
	public static JSONObject Ticket_RepositionSeats_CurrentMessage(JSONObject GetSessionFilm,JSONObject Seats) {
		CommonRequestData crd = new CommonRequestData("1001", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",CommonUntil.getToday());
		data.put("showTime",GetSessionFilm.get("showTime"));
		data.put("filmCd",GetSessionFilm.get("filmCd"));
		data.put("cinemaCd",GetSessionFilm.get("cinemaCd"));
		data.put("sectionId",Seats.get("sectionId"));
		ArrayList<String> list = new ArrayList<String>();
		list.add(Seats.get("rowId")+":"+Seats.get("colId"));
		data.put("seats",list);
		data.put("requestUserId","admin");
		data.put("requestWorkStationId","SP");//可选
		Random rand = new Random();
	    int index = rand.nextInt(999999);
	    String s = String.valueOf(index);
		data.put("tempBookingId",s);
		data.put("boBlock",true);
		data.put("throughFlg",GetSessionFilm.get("throughFlg"));
		data.put("releaseTime","1");
		return data;
	}

	public static JSONObject Ticket_RepositionSeats_ErrorSeatMessage(JSONObject GetSessionFilm) {
		CommonRequestData crd = new CommonRequestData("1001", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",CommonUntil.getToday());
		data.put("showTime",GetSessionFilm.get("showTime"));
		data.put("filmCd",GetSessionFilm.get("filmCd"));
		data.put("cinemaCd",GetSessionFilm.get("cinemaCd"));
		data.put("sectionId","123456765432");
		ArrayList<String> list = new ArrayList<String>();
		list.add("A:23");
		data.put("seats",list);
		data.put("requestUserId","admin");
		data.put("requestWorkStationId","QH-20160328CYWN");//可选
		data.put("tempBookingId","11111111");
		data.put("boBlock","false");
		data.put("throughFlg",GetSessionFilm.get("throughFlg"));
		data.put("releaseTime","60");
		return data;
	}
	
	public static JSONObject Ticket_GetAllocateSeats(JSONObject sessionFilm,JSONObject getSessionId) {
		CommonRequestData crd = new CommonRequestData("1013", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",CommonUntil.getToday());
		data.put("showTime",sessionFilm.get("showTime"));
		data.put("filmCd",sessionFilm.get("filmCd"));
		data.put("cinemaCd",sessionFilm.get("cinemaCd"));
		data.put("sectionId",getSessionId.get("sectionID"));
		data.put("cacheFlg",false);
		return data;
	}

	public static JSONObject Ticket_GetAllocateSeatBookingId_CurrentBookingId() {
		CommonRequestData crd = new CommonRequestData("1059", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("bookingId","5901604220045889");
		return defaultData;
	}

	public static JSONObject Ticket_GetAllocateSeatBookingId_ErrorBookingId() {
		CommonRequestData crd = new CommonRequestData("1059", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("bookingId","23123131231");
		return defaultData;
	}

	public static JSONObject Ticket_GetSeatStatus_CurrentSeatId(JSONObject getSessionFilm, JSONObject getSeatId) {
		CommonRequestData crd = new CommonRequestData("1015", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate", getSessionFilm.get("showDate"));
		data.put("showTime", getSessionFilm.get("showTime"));
		data.put("filmCd", getSessionFilm.get("filmCd"));
		data.put("cinemaCd", getSessionFilm.get("cinemaCd"));
		data.put("sectionId", getSeatId.get("sectionId"));
		data.put("rowId", getSeatId.get("rowId"));
		data.put("colId", getSeatId.get("colId"));
		return data;
	}
	
	public static JSONObject Ticket_GetSeatStatus_ErrorSeatId(JSONObject getSessionFilm) {
		CommonRequestData crd = new CommonRequestData("1015", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate", getSessionFilm.get("showDate"));
		data.put("showTime", getSessionFilm.get("showTime"));
		data.put("filmCd", getSessionFilm.get("filmCd"));
		data.put("cinemaCd", getSessionFilm.get("cinemaCd"));
		data.put("sectionId","sadjashdhsak");
		data.put("rowId", "A");
		data.put("colId", "01");
		return data;
	}

	public static JSONObject TC_Ticket_GetSeatRowColId_CurrentseatCodes(JSONObject getSeatId) {
		CommonRequestData crd = new CommonRequestData("1047", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		ArrayList<String> list = new ArrayList<String>();
		list.add(getSeatId.get("seatCode").toString());
		data.put("seatCodes", list);
		return data;
	}

	public static JSONObject Ticket_GetChannelSeatPolicy() {
		CommonRequestData crd = new CommonRequestData("1061", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		return data;
	}

	public static JSONObject Ticket_GetChannelSeatDetailsByShow_CurrentSessionId(JSONObject getSessionFilm,JSONObject getSectionId) {
		CommonRequestData crd = new CommonRequestData("1063", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("ChannelCd","BO");
		data.put("ShowDate",getSessionFilm.get("showDate"));
		data.put("ShowTime",getSessionFilm.get("showTime"));
		data.put("CinemaCd",getSessionFilm.get("cinemaCd"));
		data.put("LocationCd",getSessionFilm.get("locationCd"));
		data.put("SectionId", getSectionId.get("sectionID"));
		return data;
	}

	public static JSONObject Ticket_GetMaxThroughSeatCount(JSONObject getSessionFilm, JSONObject getsectionId) {
		CommonRequestData crd = new CommonRequestData("1064", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("ChannelCd", "BO");
		data.put("LocationCd", getSessionFilm.get("locationCd"));
		data.put("CinemaCd", getSessionFilm.get("cinemaCd"));
		data.put("ShowDate", getSessionFilm.get("showDate"));
		data.put("ShowTime", getSessionFilm.get("showTime"));
		data.put("SectionId", getsectionId.get("sectionID"));
		data.put("FilmCd", getSessionFilm.get("filmCd"));
		data.put("SeatType", "");
		return data;
	}

	public static JSONObject Ticket_GetPaymentTypes() {
		CommonRequestData crd = new CommonRequestData("1068", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		return data;
	}

	public static JSONObject Ticket_GetAllSessionBookingId(JSONObject sessionFilm, JSONObject sessionId) {
		CommonRequestData crd = new CommonRequestData("1065", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("sessionCode",sessionFilm.get("sessionCode"));
		data.put("sectionId", sessionId.get("sectionID"));
		return data;
	}

	public static JSONObject Ticket_GetAllSessionBookingId_ErrorSessionCode() {
		CommonRequestData crd = new CommonRequestData("1065", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("sessionCode","2312433453434X");
		data.put("sectionId","0000000000000004");
		return data;
	}

	public static JSONObject Card_GetAllSessionPricePolicy_CurrentCardFacadeCD(JSONObject sessionFilm) {
		CommonRequestData crd = new CommonRequestData("1075", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("ChannelCd","BO");
		data.put("LocationCd",sessionFilm.get("locationCd"));
		data.put("CardLocationCd","59");
		data.put("ShowDate",sessionFilm.get("showDate"));
		data.put("CardFacadeCD","000000020016");
		//data.put("LeastPriceFlg","");
		return data;
	}

	public static JSONObject TC_Ticket_GetSeatCode_CurrentSeats(JSONObject GetSessionFilm,JSONObject getSeatId) {
		CommonRequestData crd = new CommonRequestData("1046", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject GetSeatCodeNode = new JSONObject();
		GetSeatCodeNode.put("seqNo",GetSessionFilm.get("SeqNo"));
		GetSeatCodeNode.put("rowId",getSeatId.get("rowId"));
		GetSeatCodeNode.put("colId",getSeatId.get("colId"));
		GetSeatCodeNode.put("sectionId",getSeatId.get("sectionId"));
		GetSeatCodeNode.put("cinemaCd",GetSessionFilm.get("cinemaCd"));
		GetSeatCodeNode.put("showDate",GetSessionFilm.get("showDate"));
		list.add(GetSeatCodeNode);
		data.put("seatCodes",list);
		return data;
	}

	public static JSONObject TC_Ticket_GetSeatCode_ErrorSeats(JSONObject GetSessionFilm) {
		CommonRequestData crd = new CommonRequestData("1046", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject GetSeatCodeNode = new JSONObject();
		GetSeatCodeNode.put("seqNo",GetSessionFilm.get("SeqNo"));
		GetSeatCodeNode.put("rowId","dsad");
		GetSeatCodeNode.put("colId","232");
		GetSeatCodeNode.put("sectionId","3456787654321");
		GetSeatCodeNode.put("cinemaCd",GetSessionFilm.get("cinemaCd"));
		GetSeatCodeNode.put("showDate",GetSessionFilm.get("showDate"));
		list.add(GetSeatCodeNode);
		data.put("seatCodes",list);
		return data;
	}

	public static JSONObject Ticket_GetSeatRowColId_ErrorseatCodes() {
		CommonRequestData crd = new CommonRequestData("1047", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList<String> list = new ArrayList<String>();
		list.add("00000000003000139");
		defaultData.put("seatCodes",list);
		return defaultData;
	}

	public static JSONObject TC_Ticket_GetChannelSeatDetails_CurrentPolicyId() {
		CommonRequestData crd = new CommonRequestData("1062", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("policyId","TEST");
//		defaultData.put("LocationCd","");
//		defaultData.put("SectionId","");
//		defaultData.put("CinemaCd","");
		return defaultData;
	}

	public static JSONObject TC_Ticket_GetChannelSeatDetails_ErrorPolicyId() {
		CommonRequestData crd = new CommonRequestData("1062", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("policyId","2342");
//		defaultData.put("LocationCd","");
//		defaultData.put("SectionId","");
//		defaultData.put("CinemaCd","");
		return defaultData;
	}

	public static JSONObject TC_Ticket_GetChannelSeatDetails_NoPolicyId() {
		CommonRequestData crd = new CommonRequestData("1062", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		//defaultData.put("policyId","");
		defaultData.put("LocationCd","59");
		defaultData.put("SectionId","0000000000000001");
		defaultData.put("CinemaCd","4");
		return defaultData;
	}

	public static JSONObject Ticket_GetChannelSeatDetailsByShow_WithoutSessionId() {
		CommonRequestData crd = new CommonRequestData("1063", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("ChannelCd","BO");
		defaultData.put("LocationCd","59");
		defaultData.put("CinemaCd","5");
		defaultData.put("ShowDate",CommonUntil.getToday());
		defaultData.put("ShowTime",1005);
		return defaultData;
	}

	public static JSONObject Ticket_GetMaxThroughSeatCount_ErrorSectionId(JSONObject sessionFilm) {
		CommonRequestData crd = new CommonRequestData("1064", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("ChannelCd", "BO");
		data.put("LocationCd", sessionFilm.get("locationCd"));
		data.put("CinemaCd", sessionFilm.get("cinemaCd"));
		data.put("ShowDate", sessionFilm.get("showDate"));
		data.put("ShowTime", sessionFilm.get("showTime"));
		data.put("FilmCd", sessionFilm.get("filmCd"));
		data.put("SectionId", "893298498534");
		data.put("SeatType", "");
		return data;
	}

	public static JSONObject Card_GetAllSessionPricePolicy_ErrorCardFacadeCD(JSONObject sessionFilm) {
		CommonRequestData crd = new CommonRequestData("1075", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("ChannelCd","BO");
		data.put("LocationCd",sessionFilm.get("locationCd"));
		data.put("CardLocationCd","69");
		data.put("ShowDate",sessionFilm.get("showDate"));
		data.put("CardFacadeCD","000000020016");
		//data.put("LeastPriceFlg","");
		return data;
	}

	public static JSONObject Ticket_CreateInfoCode_Current() {
		CommonRequestData crd = new CommonRequestData("1066", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("refSeqNoOrThroughId","591604258E2G7IX2WR");
		data.put("throughFlg",false);
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject ticket = new JSONObject();
		ticket.put("ticketNo","5916042500357441");
		ticket.put("bookingId","5901604250045890");
		ticket.put("rowId","2");
		ticket.put("colId","05");
		ticket.put("priceAmt",25);
		ticket.put("bookingFeeAmt",0);
		ticket.put("serviceFee",0);
		ticket.put("sectionId","0000000000000001");
		list.add(ticket);
		data.put("tickets",list);
		return data;
	}

	public static JSONObject Ticket_CreateInfoCode_ErrorBookingId() {
		CommonRequestData crd = new CommonRequestData("1066", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("refSeqNoOrThroughId","591604258E2G7IX2WR");
		data.put("throughFlg",false);
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject ticket = new JSONObject();
		ticket.put("ticketNo","5916042500357441");
		ticket.put("bookingId","5901604250334354355353045890");
		ticket.put("rowId","2");
		ticket.put("colId","05");
		ticket.put("priceAmt",25);
		ticket.put("bookingFeeAmt",0);
		ticket.put("serviceFee",0);
		ticket.put("sectionId","0000000000000001");
		list.add(ticket);
		data.put("tickets",list);
		return data;
	}

	public static JSONObject Ticket_ReleaseSeats_CorrentSeats(JSONObject GetSessionFilm,JSONObject Seats,JSONObject ReleaseSeats) {
		CommonRequestData crd = new CommonRequestData("1003", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate",GetSessionFilm.get("showDate"));
		data.put("showTime",GetSessionFilm.get("showTime"));
		data.put("filmCd",GetSessionFilm.get("filmCd"));
		data.put("cinemaCd",GetSessionFilm.get("cinemaCd"));
		data.put("sectionId",Seats.get("sectionId"));
		ArrayList<String> list = new ArrayList<String>();
		list.add(ReleaseSeats.get("rowId")+":"+ReleaseSeats.get("colId"));
		data.put("seats",list);
		data.put("requestUserId",ReleaseSeats.get("requestUserId"));
		data.put("requestWorkStationId",ReleaseSeats.get("requestWorkStationId"));//可选
		data.put("tempBookingId",ReleaseSeats.get("tempBookingId"));
		data.put("boBlock",ReleaseSeats.get("boBlock"));
		data.put("throughFlg",GetSessionFilm.get("throughFlg"));
		data.put("releaseTime","1");
		return data;
	}

	public static JSONObject Ticket_ReleaseSeats_ErrorSeats() {
		CommonRequestData crd = new CommonRequestData("1003", "1.0.0.0");
		JSONObject data = crd.getRequestData();
		data.put("showDate","2016-04-26");
		data.put("showTime","1005");
		data.put("filmCd","05190094201501");
		data.put("cinemaCd","1");
		data.put("sectionId","0000000000000001");
		ArrayList<String> list = new ArrayList<String>();
		list.add("A:XX");
		data.put("seats",list);
		data.put("requestUserId","YKSE");
		//data.put("requestWorkStationId","SP");//可选
		data.put("tempBookingId","5901604260045891");
		data.put("boBlock","true");
		data.put("throughFlg","false");
		data.put("releaseTime","1");
		return data;
	}

	public static JSONObject Ticket_Refund_BoPos_Order() {
		CommonRequestData crd = new CommonRequestData("1077", "1.0.11.23");
		JSONObject data = crd.getRequestData();
		data.put("tokenNum", CommonUntil.getPassNum());
		data.put("UserId", "YKSE");
		data.put("OprnDate", "2016-01-11");
		data.put("ShiftNo", "2");
		data.put("WriteShiftFlg", "Y");
		//data.put("UUid", "1e9d5ca14f3d4bf59ec2b43cb6baf343");
		data.put("WorkStationId", "WEBSITE");
		
		//EPAY
		/*
		//必须
		JSONObject Epay = new JSONObject();

		Epay.put("Platform", "alipay");
		Epay.put("EChannel", "alipay");
		Epay.put("Total", "1");
		Epay.put("TranType", "1");
		Epay.put("CounterFee", "1");
		JSONObject ListBusinessType =  new JSONObject();
		ListBusinessType.put("BookingId", "");
		ListBusinessType.put("BusinessType", "");
		Epay.append("ListBusinessType", ListBusinessType);
		//非必须
		/*
		Epay.put("Type", "1");
		Epay.put("TranId", "1234578574");
		Epay.put("ThirdTranId", "1");
		Epay.put("ChannelCode", "1");
		Epay.put("SalesId", "1");
		*/
		//RefundBo
		
		JSONObject RefundBo = new JSONObject();
		RefundBo.put("BookingId", "1470160506005651");
		RefundBo.put("ChannelCd", "BO");
		//非必须
		
//		RefundBo.put("ReasonCd", "");
//		RefundBo.put("ApprovalUserId", "");
//		RefundBo.put("VoucherActiveFlg", "");
//		RefundBo.put("YtBatchNo", "");
//		RefundBo.put("YtTraceNo", "");
		
		//RefundBookFee
		//必须的
//		JSONObject RefundBookFee = new JSONObject();
//		RefundBookFee.put("BookingId", "BookingId");
//		RefundBookFee.put("SeqNo", "SeqNo");
//		RefundBookFee.put("TotalSeatsRefunded", "TotalSeatsRefunded");
//		RefundBookFee.put("TotalRefundFeeAmt", "TotalRefundFeeAmt");
		//非必须
//		RefundBookFee.put("RefundType", "RefundType");
//		RefundBookFee.put("CardGradeId", "CardGradeId");
		
		//Tickets
		ArrayList<String> ListticketNo = new ArrayList<String>();
		ListticketNo.add("1471605060018351");
		//ListticketNo.add("1471605060018344");
		
		for (int i = 0; i<ListticketNo.size();i++)
		{
			// TicketNo
			JSONObject Tickets = new JSONObject();
			Tickets.put("TicketNo",ListticketNo.get(i));
			
			// RefundPayments
			JSONObject RefundPayments = new JSONObject();	
			RefundPayments.put("SeqNo", "1");
			RefundPayments.put("RefundType", "Cash");
			RefundPayments.put("CashVoucherType", "007");
//			RefundPayments.put("CardFacadeCd", "2016050400000001");
//			RefundPayments.put("CardLocationCd", "147");
//			RefundPayments.put("CardGradeId", "48");
			Tickets.put("TicketNo",ListticketNo.get(i));
			Tickets.append("RefundPayments",RefundPayments);
			RefundBo.append("Tickets", Tickets);
		}
		
		//ArrayList<String> TicketNo = new ArrayList<String>();
		//TicketNo.add("1471605050018221");
		//TicketNo.add("1471605050018220");
		//Ticket.put("TicketNo", "1471605050018221");
		//RefundBo.put("Tickets", TicketNo);
		//Tickets.add(Ticket);
//		ArrayList<JSONObject> RefundPayments = new ArrayList<JSONObject>();
//		JSONObject rePayments = new JSONObject();
//		rePayments.put("SeqNo", 1);
//		rePayments.put("RefundType", "Cash");
//		rePayments.put("VoucherBarcode", "");
//		rePayments.put("CashVoucherType", "007");
//		rePayments.put("VoucherTypeCd", "");
//		rePayments.put("SalesCd", "");
//		rePayments.put("CardFacadeCd", "");
//		rePayments.put("CardLocationCd", "");
//		rePayments.put("CardGradeId", "");
//		rePayments.put("YtBatchNo", "");
//		rePayments.put("YtTraceNo", "");
//		rePayments.put("PaymentTransationId", "");
//		RefundPayments.add(rePayments);
//		Ticket.put("RefundPayments", RefundPayments);

        data.put("RefundBo", RefundBo);
        
		/*
        JSONObject RefundPos = new JSONObject();
        RefundPos.put("posSaleOp", "Return");
        RefundPos.put("posSource", "BO");
        RefundPos.put("posSaleId", "147120160506002457");
//        RefundPos.put("posIndexId", "1470160505005571");
//        RefundPos.put("posAmount", "5");
//        RefundPos.put("posTempId", "147120160505002451");
        
        ArrayList<JSONObject> posSaleGoodsNods = new ArrayList<JSONObject>();
		JSONObject posGood = new JSONObject();
		posGood.put("posGoodId", "8160104155654");
		posGood.put("posSaleCount", "1");
		posGood.put("posSalePrice", "5");
		posGood.put("posExchangeIntegral", "0");
		posGood.put("posDiscountGroup", "");
		posGood.put("posGoodVoucherCd", "");
		posGood.put("posGoodSeq", "1");
		posGood.put("originalPrice", "5");
		posSaleGoodsNods.add(posGood);
		RefundPos.put("posSaleGoodsNods", posSaleGoodsNods);
//		ArrayList<JSONObject> posSalePayNods = new ArrayList<JSONObject>();
//		JSONObject posPayment = new JSONObject();
//		posPayment.put("posPaymentTypeCd", "Cash");
//		posPayment.put("posAmount", "5");
//		posPayment.put("posPaymentCode", "");
//		posPayment.put("posPointCardRate", "1");
//		posPayment.put("posCardIssueCinemaCd", "");
//		posPayment.put("posSpecialId", "");
//		posPayment.put("posCardGradeId", "");
//		posPayment.put("posCashVoucherCount", "");
//		posPayment.put("posActuallyReceivedAmount", "");
//		posPayment.put("posGoodPayChange", "");
//		posPayment.put("posElectronicCard", "");
//		posPayment.put("posElectronicSeq", "");
//		posPayment.put("posOtherPartyId", "");
//		posPayment.put("posTraceNumber", "");
//		posPayment.put("posBatchNumber", "");
//		posPayment.put("unionConfirmCode", "");
//		posPayment.put("unionReferanceCode", "");
//		posPayment.put("yongTaiTrack", "");
//		posPayment.put("thirdTransationId", "");
//		posPayment.put("posSalemanId", "");
//		posSalePayNods.add(posPayment);
//		RefundPos.put("posSalePayNods", posSalePayNods);
//		ArrayList<JSONObject> posSaleStockDetailNods = new ArrayList<JSONObject>();
//		JSONObject posDetail = new JSONObject();
//		posDetail.put("posSetId", "");
//		posDetail.put("posGoodId", "");
//		posDetail.put("posGoodPrice", "");
//		posDetail.put("posGoodSeq", "");
//		posDetail.put("posGoodCount", "");
//		posDetail.put("posGoodName", "");
//		posSaleStockDetailNods.add(posDetail);
//		RefundPos.put("posSaleStockDetailNods", posSaleStockDetailNods);
//		ArrayList<JSONObject> posSalePermissionNods = new ArrayList<JSONObject>();
//		JSONObject posPermission = new JSONObject();
//		posPermission.put("posPermissionRoleName", "");
//		posPermission.put("posPermissionUserId", "");
//		posSalePermissionNods.add(posPermission);
//		RefundPos.put("posSalePermissionNods", posSalePermissionNods);
//		ArrayList<JSONObject> posOrderRemark = new ArrayList<JSONObject>();
//		JSONObject posRemark = new JSONObject();
//		posRemark.put("saleFormId", "");
//		posRemark.put("saleFormType", "");
//		posRemark.put("memberCardId", "");
//		posRemark.put("creditCardId", "");
//		posRemark.put("remark", "");
//		posRemark.put("posTraceNumber", "");
//		posRemark.put("posBatchNumber", "");
//		posOrderRemark.add(posRemark);
//		RefundPos.put("posOrderRemark", posOrderRemark);
		data.put("RefundPos", RefundPos);
		*/
		return data;
	}
	
	public static JSONObject Ticket_Refund_BoPos_Order_Object(){
		CommonRequestData crd = new CommonRequestData("1077", "1.0.11.23");
		JSONObject data = crd.getRequestData();
		data.put("tokenNum", CommonUntil.getPassNum());
		String testrString = "{\"UserId\":\"ADMIN\",\"OprnDate\":\"2016-05-07\",\"ShiftNo\":\"2\",\"WriteShiftFlg\":\"Y\",\"UUid\":\"qwertyuiopasdfghjklzxcvbnm122456\",\"WorkStationId\":\"LKG\",\"RefundPos\":{\"posSaleOp\":\"Return\",\"posSource\":\"BO\",\"posSaleId\":\"681120160507232230\",\"posAmount\":\"10\",\"posTempId\":\"681120160507232230\",\"posSaleGoodsNods\":[{\"posGoodId\":\"8160507131823\",\"posSaleCount\":\"1\",\"posSalePrice\":\"10\",\"posExchangeIntegral\":\"0\",\"posGoodSeq\":\"1\",\"originalPrice\":\"10\"}],\"posSalePayNods\":[{\"posPaymentTypeCd\":\"Cash\",\"posAmount\":\"10\"}],\"posSalePermissionNods\":[{\"posPermissionRoleName\":\"RETURNGOODS\",\"posPermissionUserId\":\"ADMIN\"}],\"posOrderRemark\":{\"saleFormId\":\"681120160507232230\",\"saleFormType\":\"SALE\",\"memberCardId\":\"1010\",\"creditCardId\":\"1010\",\"remark\":\"1010\"}}}";
		JSONObject reqjson = new JSONObject(testrString);
		return CommonUntil.JoinJsonObject(data,reqjson);
	}
	
	public static JSONObject Ticket_Card_Refund_BoPos_Order_Object(){
		CommonRequestData crd = new CommonRequestData("2125", "1.0.11.23");
		JSONObject data = crd.getRequestData();
		data.put("tokenNum", CommonUntil.getPassNum());
		String testrString = "{\"UserId\":\"ADMIN\",\"ChannelCd\":\"BO\",\"ShiftNo\":\"1\",\"locationcd\":\"681\",\"UUid\":\"qwertyuiopasdfghjklzxcvbnm124458\",\"RefundCardWallets\":[{\"WalletSeqNo\":\"6812016050736894\",\"VoucherBarcode\":\"681535126629\",\"CardFacadeCd\":\"99999\",\"GiftType\":\"G\",\"Count\":\"1\"}],\"CardRefundBo\":{\"RefundCard\":[{\"CardFacadeCd\":\"99999\",\"CardLocationCd\":\"681\",\"RefundAmt\":\"0\",\"RefundMarking\":\"0\"}],\"MoneyRefToCardFlg\":\"Y\",\"BookingId\":\"6810160507078772\",\"RefundBookFeeFlg\":\"Y\",\"RefundBookFeePaymentType\":\"MemberCard\"}}";
		JSONObject reqjson = new JSONObject(testrString);
		return CommonUntil.JoinJsonObject(data,reqjson);
	}

	public static JSONObject Ticket_Card_Refund_BoPos() {
		CommonRequestData crd = new CommonRequestData("2125", "1.0.11.23");
		JSONObject data = crd.getRequestData();
		data.put("UserId", "ADMIN");
//		data.put("WriteCardFlg", "");
//		data.put("FingerFlg", "");
		data.put("ChannelCd", "BO");
//		data.put("WriteShiftFlg", "");
		data.put("ShiftNo", "1");
//		data.put("OprnDate", "");
//		data.put("SystemCd", "");
		data.put("UUid", CommonUntil.getPassNum());
		data.put("tokenNum", CommonUntil.getPassNum());
		
//		ArrayList<JSONObject> RefundCardWallets = new ArrayList<JSONObject>();
//		JSONObject CardWallets = new JSONObject();
//		CardWallets.put("WalletSeqNo", "");
//		CardWallets.put("VoucherBarcode", "");
//		CardWallets.put("CardFacadeCd", "");
//		CardWallets.put("GiftType", "");
//		CardWallets.put("Count", "");
//		CardWallets.put("TicketNo", "");
//		RefundCardWallets.add(CardWallets);
//		data.put("RefundCardWallets", RefundCardWallets);
		
//		ArrayList<JSONObject> ThirdCharged = new ArrayList<JSONObject>();
//		JSONObject reThirdCharged = new JSONObject();
//		reThirdCharged.put("BookingId", "");
//		reThirdCharged.put("TotalRefundAmount", "");
//		reThirdCharged.put("TotalRefundMarking", "");
//		reThirdCharged.put("TotalRefundTimes", "");
//		reThirdCharged.put("TotalRefundConsumeMarking", "");
//		reThirdCharged.put("Remarks", "");
//		ThirdCharged.add(reThirdCharged);
//		data.put("ThirdCharged", ThirdCharged);
		
		JSONObject CardRefundBo = new JSONObject();
		CardRefundBo.put("BookingId", "6810160507078678");
		CardRefundBo.put("MoneyRefToCardFlg", "Y");
		ArrayList<String> TicketList = new ArrayList<String>();
		TicketList.add("6811605070459105");
		//TicketList.add("1471605060018344");
		//CardRefundBo.put("TicketList", TicketList);
//		CardRefundBo.put("RefundBookFeeFlg", "");
//		CardRefundBo.put("RefundBookFeePaymentType", "");
//		CardRefundBo.put("TicketCount", "1");		
		ArrayList<JSONObject> RefundCard = new ArrayList<JSONObject>();
		JSONObject ReCardCd = new JSONObject();
		ReCardCd.put("CardFacadeCd", "99999");
		ReCardCd.put("CardLocationCd", "681");
		ReCardCd.put("RefundAmt", "10");
		ReCardCd.put("RefundMarking", "0");
		RefundCard.add(ReCardCd);
		CardRefundBo.put("RefundCard", RefundCard);
		data.put("CardRefundBo", CardRefundBo);
		
		/*
		JSONObject CardRefundPos = new JSONObject();
		CardRefundPos.put("CardFacadeCd", "99999");
		CardRefundPos.put("CardLocationCd", "681");
		CardRefundPos.put("MoneyRefToCardFlg", "Y");
		JSONObject PosInfo = new JSONObject();
		PosInfo.put("RefundBookingId", "681120160507232194");
		PosInfo.put("BookingId", "681120160507232194");
		PosInfo.put("TotalAmount", "10");
//		PosInfo.put("TotalConsumeMarking", "");
//		PosInfo.put("Remarks", "");
		CardRefundPos.put("PosInfo", PosInfo);
		data.put("CardRefundPos", CardRefundPos);
	   */
		return data;
	}

	public static JSONObject Ticket_Card_Refund_BoPos_RollBack() {
		CommonRequestData crd = new CommonRequestData("2127", "1.0.11.23");
		JSONObject data = crd.getRequestData();
		data.put("tokenNum", CommonUntil.getPassNum());
		data.put("UUid", "qwertyuiopasdfghjklzxcvbnm124458");
		data.put("CardFacadeCd", "99999");
		data.put("BookingId", "6810160507078772");
		data.put("UserId", "YKSE");
		return data;
	}

}
