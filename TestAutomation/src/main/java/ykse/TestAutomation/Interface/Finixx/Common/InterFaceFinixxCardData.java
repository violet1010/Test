package ykse.TestAutomation.Interface.Finixx.Common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;





import ykse.TestAutomation.Interface.Finixx.Common.TestData;
public class InterFaceFinixxCardData {
	
	public static JSONObject Basic_GetAllSystemSetting()
	{
		CommonRequestData crd = new CommonRequestData("0426", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("boxOfficeSettingFlg",false);
		defaultData.put("posSettingFlg",false);
		defaultData.put("cardSettingFlg",true);
		defaultData.put("posBigClassReturnPic",false);
		return defaultData;
	}
	
	public static JSONObject Card_GetCardInfo()
	{
		CommonRequestData crd = new CommonRequestData("2001", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardFacadeCd",TestData.FindValueInVariablesByFile("facadeCD","ExchangeCCBData.xml"));
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","ExchangeCCBData.xml"));
		defaultData.put("cardSerialNo",TestData.FindValueInVariablesByFile("facadeCD","ExchangeCCBData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetUsePolicy()
	{
		CommonRequestData crd = new CommonRequestData("2002", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("usePolicyId",TestData.FindValueInVariablesByFile("usePolicyId","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetGradePolicy()
	{
		CommonRequestData crd = new CommonRequestData("2003", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("gradeId",TestData.FindValueInVariablesByFile("gradeId","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetLimitTickets()
	{
		CommonRequestData crd = new CommonRequestData("2004", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd", TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("cardFacadeCd", TestData.FindValueInVariablesByFile("cardFacadeCd","CardTestData.xml"));
		defaultData.put("cardGradeId", TestData.FindValueInVariablesByFile("cardGradeId","CardTestData.xml"));
		defaultData.put("cardUsePolicyId", TestData.FindValueInVariablesByFile("cardUsePolicyId","CardTestData.xml"));
		defaultData.put("showDate",TestData.FindValueInVariablesByFile("showDate","CardTestData.xml"));
		defaultData.put("showTime",TestData.FindValueInVariablesByFile("showTime","CardTestData.xml"));
		defaultData.put("filmCd", TestData.FindValueInVariablesByFile("filmCd","CardTestData.xml"));
		defaultData.put("cinemaCd",TestData.FindValueInVariablesByFile("cinemaCd","CardTestData.xml"));
		defaultData.put("channelCd",TestData.FindValueInVariablesByFile("channelCd","CardTestData.xml"));
		return defaultData;
	}
	//需要与影票结合
	public static JSONObject Card_Consume()
	{
		CommonRequestData crd = new CommonRequestData("2005", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject FilmInfoNode = new JSONObject();
		JSONObject posBooking = new JSONObject();
		JSONObject MemberCardWallet = new JSONObject();
		ArrayList<JSONObject> filmsInfo = new ArrayList<JSONObject>();
		ArrayList<JSONObject> wallet = new ArrayList<JSONObject>();
		 
		defaultData.put("tokenNum",CommonUntil.getPassNum());	
		defaultData.put("userId","ADMIN");
		defaultData.put("writeCardFlg", true);
		defaultData.put("fingerFlg", false);
		defaultData.put("channelCd", TestData.FindValueInVariablesByFile("channelCd","CardTestData.xml"));
		FilmInfoNode.put("bookingId","20160425");
		FilmInfoNode.put("session_RefSeqNo", "RefSeqNo");
		FilmInfoNode.put("throughFlg",false);
		FilmInfoNode.put("sectionId", "0000000000000001");
		FilmInfoNode.put("totalAmount", 60);
		FilmInfoNode.put("calculateMarkingMoney", 1);
		FilmInfoNode.put("calculatePerTicketTimes","2");
		FilmInfoNode.put("totalDisSeats", "2");
		FilmInfoNode.put("totalSeats", "4");
		FilmInfoNode.put("totalConsumeMarking",0);
		FilmInfoNode.put("remarks", "Card_Consume1");		
		filmsInfo.add(FilmInfoNode);
		defaultData.put("filmsInfo", filmsInfo);
//		posBooking.put("bookingId", "20160425");
//		posBooking.put("totalAmount",3);
//		posBooking.put("totalConsumeMarking", 3);
//		posBooking.put("remarks", "Card_Consume2");	
//		defaultData.put("posBooking", posBooking);
		MemberCardWallet.put("walletItemSeqNo", "null");
		MemberCardWallet.put("useCount", "0");
		MemberCardWallet.put("bookingId", "20160425");
		MemberCardWallet.put("systemCd", "BO");
		wallet.add(MemberCardWallet);
//		defaultData.put("wallet", wallet);
		defaultData.put("cardLocationCd", TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("cardFacadeCd", "000101");
//		defaultData.put("cardSerialNo", "000101");
		
		defaultData.put("cardPassEn", "E10ADC3949BA59ABBE56E057F20F883E");
		return defaultData;
	}
	
	public static JSONObject Card_ConsumeRollback()
	{
		CommonRequestData crd = new CommonRequestData("2006", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList<String> bookingIds = new ArrayList<String>();
		bookingIds.add("20160425");
		defaultData.put("tokenNum",CommonUntil.getPassNum());	
		defaultData.put("cardLocationCd", "59");
		defaultData.put("cardFacadeCd", "000101");
		defaultData.put("bookingIds", bookingIds);
		defaultData.put("userId", "ADMIN");
		return defaultData;
	}
	
	public static JSONObject Card_GetStateInfo()
	{
		CommonRequestData crd = new CommonRequestData("2007", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetCardBuying()
	{
		CommonRequestData crd = new CommonRequestData("2008", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardFacadeCd", TestData.FindValueInVariablesByFile("cardFacadeCd","CardTestData.xml"));
		defaultData.put("cardLocationCd", TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetPaymentType()
	{
		CommonRequestData crd = new CommonRequestData("2009", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetCompany()
	{
		CommonRequestData crd = new CommonRequestData("2010", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetSales()
	{
		CommonRequestData crd = new CommonRequestData("2011", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetSellInit()
	{
		CommonRequestData crd = new CommonRequestData("2012", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetSoftDog()
	{
		CommonRequestData crd = new CommonRequestData("2013", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardId", TestData.FindValueInVariablesByFile("cardId","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetReading()
	{
		CommonRequestData crd = new CommonRequestData("2014", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetSellInfo()
	{
		CommonRequestData crd = new CommonRequestData("2015", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000106");
		defaultData.put("serialCD","000106");
		defaultData.put("icbcFlag",TestData.FindValueInVariablesByFile("icbcFlag","CardTestData.xml"));
		defaultData.put("ccbFlag",TestData.FindValueInVariablesByFile("ccbFlag","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetSellGroupID()
	{
		CommonRequestData crd = new CommonRequestData("2016", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_Sell()
	{
		CommonRequestData crd = new CommonRequestData("2017", "1.0.0.1");
		JSONObject defaultData = crd.getRequestData();
//		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));
//		defaultData.put("beginFacadeCD","000105");
//		defaultData.put("noCardBatchFlag",TestData.FindValueInVariablesByFile("noCardBatchFlag","CardTestData.xml"));
//		defaultData.put("icbcflag",TestData.FindValueInVariablesByFile("icbcflag","CardTestData.xml"));
//		defaultData.put("ccbflag",TestData.FindValueInVariablesByFile("ccbflag","CardTestData.xml"));
//		defaultData.put("groupFlag",TestData.FindValueInVariablesByFile("groupFlag","CardTestData.xml"));
//		defaultData.put("paymentTypeFee",TestData.FindValueInVariablesByFile("paymentType","CardTestData.xml"));
//		defaultData.put("paymentNameFee",TestData.FindValueInVariablesByFile("paymentName","CardTestData.xml"));
//		defaultData.put("paymentTypeAdd",TestData.FindValueInVariablesByFile("paymentType","CardTestData.xml"));
//		defaultData.put("paymentNameAdd",TestData.FindValueInVariablesByFile("paymentName","CardTestData.xml"));
//		defaultData.put("addMoney",TestData.FindValueInVariablesByFile("addMoney","CardTestData.xml"));
//		defaultData.put("fee",TestData.FindValueInVariablesByFile("fee","CardTestData.xml"));
//		defaultData.put("membershipFee",TestData.FindValueInVariablesByFile("membershipFee","CardTestData.xml"));
//		defaultData.put("parValue",TestData.FindValueInVariablesByFile("parValue","CardTestData.xml"));
//		defaultData.put("workstation",TestData.FindValueInVariablesByFile("workstation","CardTestData.xml"));
//		defaultData.put("saleSpeed", 10.40);
//		defaultData.put("module", TestData.FindValueInVariablesByFile("module","CardTestData.xml"));
//		defaultData.put("valid","2016-4-25 10:41:33");
//		defaultData.put("photoFlag",TestData.FindValueInVariablesByFile("photoFlag","CardTestData.xml"));
//		defaultData.put("writeShiftFlag",TestData.FindValueInVariablesByFile("writeShiftFlag","CardTestData.xml"));
//		defaultData.put("channelCD",TestData.FindValueInVariablesByFile("channelCD","CardTestData.xml"));
		defaultData.put("userID","ADMIN");
		defaultData.put("beginFacadeCD","000106");
		defaultData.put("endFacadeCD","000106");
		defaultData.put("noCardBatchFlag",false);
		defaultData.put("noCardBatchType","0");
		defaultData.put("serialCD","000105");
		defaultData.put("icbcflag","N");
		defaultData.put("ccbflag","N");
		defaultData.put("ccbreplace","01");
		defaultData.put("groupFlag","N");
		defaultData.put("paymentTypeFee","Cash");
		defaultData.put("paymentNameFee","Cash");
		defaultData.put("paymentTypeAdd","Cash");
		defaultData.put("paymentNameAdd","Cash");
		defaultData.put("addMoney",100);
		defaultData.put("fee",0);
		defaultData.put("membershipFee",0);
		defaultData.put("parValue",0);
		defaultData.put("workstation",TestData.FindValueInVariablesByFile("workstation","CardTestData.xml").toString());
		defaultData.put("saleSpeed", 1.5);
		defaultData.put("module", TestData.FindValueInVariablesByFile("module","CardTestData.xml").toString());
		defaultData.put("memberName", "superman");
		defaultData.put("valid","2016-4-25 10:41:33");
		defaultData.put("documentType","11111111");
		defaultData.put("documentNO","11111111111111");
		defaultData.put("userPassword","111111");
		defaultData.put("mobile","111111111111111");
		defaultData.put("birthday","2016-4-28 11:27:17");
		defaultData.put("sex","f");
		defaultData.put("photoFlag",false);
		defaultData.put("writeShiftFlag",true);
		defaultData.put("invoiceReceive","N");
		defaultData.put("channelCD",TestData.FindValueInVariablesByFile("channelCD","CardTestData.xml"));
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		return defaultData;
	}
	
	public static JSONObject Card_AddMoney()
	{
		CommonRequestData crd = new CommonRequestData("2018", "1.0.0.1");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID","ADMIN");
		defaultData.put("beginFacadeCD","000101");
		defaultData.put("endFacadeCD","000101");
		defaultData.put("addMoney",100);
		defaultData.put("sellLocationCD","59");
		defaultData.put("addLocationCD","59");
		defaultData.put("paymentType","Cash");
		
		defaultData.put("paymentName","现金");
		
		defaultData.put("addModule","BO");
		defaultData.put("discount",0);
		defaultData.put("fingerFlag",TestData.FindValueInVariablesByFile("fingerFlag","CardTestData.xml"));
		defaultData.put("batchAdd",false);
		defaultData.put("batchMode","0");
		defaultData.put("workstation",TestData.FindValueInVariablesByFile("workstation","CardTestData.xml"));
		defaultData.put("saleSpeed",1.5);
		defaultData.put("writeShiftFlag",true);	
		defaultData.put("invoiceReceive","N");
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		return defaultData;
	}
	
	public static JSONObject Card_GetSummaryInfo()
	{
		CommonRequestData crd = new CommonRequestData("2019", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("queryByFacadeCD",TestData.FindValueInVariablesByFile("queryByFacadeCD","CardTestData.xml"));
		defaultData.put("noPreInfo",TestData.FindValueInVariablesByFile("noPreInfo","CardTestData.xml"));
		defaultData.put("queryCenterPolicy",TestData.FindValueInVariablesByFile("queryCenterPolicy","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_GetPrefabricateUsePolicy()
	{
		CommonRequestData crd = new CommonRequestData("2020", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetPrefabricateGrade()
	{
		CommonRequestData crd = new CommonRequestData("2021", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetPrefabricateTradePolicyHdrs()
	{
		CommonRequestData crd = new CommonRequestData("2022", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GetPrefabricateOrdersList()
	{
		CommonRequestData crd = new CommonRequestData("2023", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("preFlag",TestData.FindValueInVariablesByFile("preFlag","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_OrdersByOrderCD(String CardOrder)
	{
		CommonRequestData crd = new CommonRequestData("2024", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("preFlag",TestData.FindValueInVariablesByFile("preFlag","CardTestData.xml"));
		defaultData.put("cardOrdersByOrderCd",CardOrder);
		return defaultData;
	}
	
	public static JSONObject Card_Prefabricate(String str)
	{
		CommonRequestData crd = new CommonRequestData("2025", "1.0.0.1");
		JSONObject defaultData = crd.getRequestData();
		JSONObject CardPrefabricateNode = new JSONObject();
		ArrayList<JSONObject> cardPrefabricateList = new ArrayList<JSONObject>();
		CardPrefabricateNode.put("facadeCD",str);
		CardPrefabricateNode.put("serialCD",str);
		cardPrefabricateList.add(CardPrefabricateNode);
		defaultData.put("cardPrefabricateList",cardPrefabricateList);
		defaultData.put("type",TestData.FindValueInVariablesByFile("type","CardTestData.xml"));
		defaultData.put("cardFaceFee",0);
		defaultData.put("usePloicyID","1");
		defaultData.put("flow",TestData.FindValueInVariablesByFile("flow","CardTestData.xml"));
		defaultData.put("flowDescription","aa");
		defaultData.put("gradePolicyID","1");
		defaultData.put("specialID","01");
		defaultData.put("levelForeverFlag",false);
		defaultData.put("defaultMarking",0);
		defaultData.put("meDium",TestData.FindValueInVariablesByFile("meDium","CardTestData.xml"));
		defaultData.put("userId","ADMIN");
		defaultData.put("rePrefabricateFlag",false);
		defaultData.put("upGradeType","03");
		
		return defaultData;
	}
	
	public static JSONObject Card_QueryTicketBuy()
	{
		CommonRequestData crd = new CommonRequestData("2026", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryTicketBuyDiscount()
	{
		CommonRequestData crd = new CommonRequestData("2027", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryPosBuy()
	{
		CommonRequestData crd = new CommonRequestData("2028", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryAddMoney()
	{
		CommonRequestData crd = new CommonRequestData("2029", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryTransfer()
	{
		CommonRequestData crd = new CommonRequestData("2030", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryMarking()
	{
		CommonRequestData crd = new CommonRequestData("2031", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryExchange()
	{
		CommonRequestData crd = new CommonRequestData("2032", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryOtherSystemsConsume()
	{
		CommonRequestData crd = new CommonRequestData("2033", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryEditMemberInfo()
	{
		CommonRequestData crd = new CommonRequestData("2034", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));
		return defaultData;
	}
	
	public static JSONObject Card_QueryWallet()
	{
		CommonRequestData crd = new CommonRequestData("2035", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("facadeCD","000101");
		return defaultData;
	}
	
	public static JSONObject Card_ConsumeIntegral()
	{
		CommonRequestData crd = new CommonRequestData("2036", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList<JSONObject> filmsInfo = new ArrayList<JSONObject>();
		JSONObject FilmInfoNode = new JSONObject();
		JSONObject posInfo = new JSONObject();
		defaultData.put("op","BO");
		defaultData.put("systemCd","BO");
		defaultData.put("userId","ADMIN");
		defaultData.put("remarks","0");
		FilmInfoNode.put("totalAmount",0);
		FilmInfoNode.put("totalMarking",0);
		FilmInfoNode.put("bookingId","20160425");
		filmsInfo.add(FilmInfoNode);
//		posInfo.put("bookingId","20160425");
//		posInfo.put("totalAmount",0);
//		posInfo.put("totalMarking",0);
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("cardFacadeCd",TestData.FindValueInVariablesByFile("cardFacadeCd","CardTestData.xml"));
		defaultData.put("cardSerialNo",TestData.FindValueInVariablesByFile("cardSerialNo","CardTestData.xml"));
//		defaultData.put("posInfo",posInfo);
//		filmsInfo.add(posInfo);bookingidlist=20160425
		defaultData.put("bookingidlist","20160425");
		defaultData.put("totalAmount",0);
		defaultData.put("totalMarking",0);
		defaultData.put("filmsInfo",filmsInfo);
		return defaultData;
	}
	
	public static JSONObject Card_ConsumeIntegralRollback()
	{
		CommonRequestData crd = new CommonRequestData("2037", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("op","BO");
		defaultData.put("userId",TestData.FindValueInVariablesByFile("userId","CardTestData.xml"));
		defaultData.put("bookingIds","");
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("cardFacadeCd","000101");
		return defaultData;
	}
	
	public static JSONObject Card_ChenkIDCardSameSerial()
	{
		CommonRequestData crd = new CommonRequestData("2038", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_Order()
	{
		CommonRequestData crd = new CommonRequestData("2039", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList cardOrderList = new ArrayList();
		JSONObject CardOrderNode = new JSONObject();
//		CardOrderNode.put("formCD",TestData.FindValueInVariablesByFile("formCD","CardTestData.xml"));	
//		CardOrderNode.put("beginFacadeCD",TestData.FindValueInVariablesByFile("beginFacadeCD","CardTestData.xml"));	
//		CardOrderNode.put("endFacadeCD",TestData.FindValueInVariablesByFile("endFacadeCD","CardTestData.xml"));	
//		CardOrderNode.put("locationCD",TestData.FindValueInVariablesByFile("locationCD","CardTestData.xml"));	
//		CardOrderNode.put("remark",TestData.FindValueInVariablesByFile("remark","CardTestData.xml"));	
//		CardOrderNode.put("totalCount",TestData.FindValueInVariablesByFile("totalCount","CardTestData.xml"));	
//		CardOrderNode.put("description",TestData.FindValueInVariablesByFile("description","CardTestData.xml"));	
//		CardOrderNode.put("jumpNumberFlag",TestData.FindValueInVariablesByFile("jumpNumberFlag","CardTestData.xml"));	
//		CardOrderNode.put("jumpFinalNumberFlag",TestData.FindValueInVariablesByFile("jumpFinalNumberFlag","CardTestData.xml"));	
//		CardOrderNode.put("jumpNumber","");	
//		cardOrderList.add(CardOrderNode);
//		defaultData.put("creatUserId",TestData.FindValueInVariablesByFile("creatUserId","CardTestData.xml"));
//		defaultData.put("cardOrderList",cardOrderList);	
		
		ArrayList<String> jumpNumber = new ArrayList<String> ();
		CardOrderNode.put("beginFacadeCD","201230098003");	
		CardOrderNode.put("endFacadeCD","201230098003");	
		CardOrderNode.put("locationCD",TestData.FindValueInVariablesByFile("locationCD","CardTestData.xml").toString());	
		CardOrderNode.put("totalCount","1");	
		CardOrderNode.put("jumpNumberFlag",false);	
		CardOrderNode.put("jumpFinalNumberFlag",false);		
		jumpNumber.add("0");
		CardOrderNode.put("jumpNumber",jumpNumber);
		cardOrderList.add(CardOrderNode);
		defaultData.put("creatUserId","ADMIN");
		defaultData.put("cardOrderList",cardOrderList);	
		return defaultData;
	}
	
	public static JSONObject Card_CheckOrderFacadeCdIsUse()
	{
		CommonRequestData crd = new CommonRequestData("2041", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("beginFacadeCD",TestData.FindValueInVariablesByFile("beginFacadeCD","CardTestData.xml"));	
		defaultData.put("endFacadeCD",TestData.FindValueInVariablesByFile("endFacadeCD","CardTestData.xml"));	
		return defaultData;
	}
	
	public static JSONObject Card_CardReportloss()
	{
		CommonRequestData crd = new CommonRequestData("2042", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
//		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
//		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));	
//		defaultData.put("type",TestData.FindValueInVariablesByFile("type","CardTestData.xml"));	
//		defaultData.put("menberUserName",TestData.FindValueInVariablesByFile("menberUserName","CardTestData.xml"));	
//		defaultData.put("telphone",TestData.FindValueInVariablesByFile("telphone","CardTestData.xml"));	
//		defaultData.put("documentNO",TestData.FindValueInVariablesByFile("documentNO","CardTestData.xml"));	
//		defaultData.put("reportLossLocationCD",TestData.FindValueInVariablesByFile("reportLossLocationCD","CardTestData.xml"));	
//		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml"));	
		defaultData.put("userID","ADMIN");	
		defaultData.put("facadeCD","000101");	
		defaultData.put("type","C");	
		defaultData.put("menberUserName"," ");	
		defaultData.put("telphone","15999930390");	
		defaultData.put("documentNO","201230098131");	
		defaultData.put("reportLossLocationCD","59");	
		defaultData.put("sellLocationCD","59");	
		return defaultData;
	}
	
	public static JSONObject Card_CardCancelloss()
	{
		CommonRequestData crd = new CommonRequestData("2043", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
//		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
		defaultData.put("userID","ADMIN");	
		defaultData.put("facadeCD","000101");	
//		defaultData.put("sellLocationCD"," ");	
//		defaultData.put("cancelLossLocationCD",TestData.FindValueInVariablesByFile("cancelLossLocationCD","CardTestData.xml"));	
//		defaultData.put("cancelLossLocationCD"," ");	
		return defaultData;
	}
	
	public static JSONObject Card_CardActivation()
	{
		CommonRequestData crd = new CommonRequestData("2044", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID","ADMIN");	
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));	
		defaultData.put("facadeCD","000000010020");	
		defaultData.put("cardType","C");	
		defaultData.put("reason","outtime");	
		defaultData.put("balance",90);	
		defaultData.put("memberFee",0);	
		defaultData.put("paymentType",TestData.FindValueInVariablesByFile("paymentType","CardTestData.xml"));	
		defaultData.put("paymentName","Cash");	
//		defaultData.put("salesCD","ADMIN");	
//		defaultData.put("billNO","000123123");&balancefeeflag=false	
		defaultData.put("invalidationDate","2014-03-12 19:52:50");	
		defaultData.put("discount",0);	
		defaultData.put("activationType","0");	
		defaultData.put("cardLocationCD","59");	
		defaultData.put("writeShiftFlag",false);
		defaultData.put("balancefeeflag",false);
		return defaultData;
	}
	
	public static JSONObject Card_OrderGetSerialNumber()
	{
		CommonRequestData crd = new CommonRequestData("2045", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_CardExchange()
	{
		CommonRequestData crd = new CommonRequestData("2046", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject CardReplacingNode = new JSONObject();
		JSONObject CardSell = new JSONObject();
		JSONObject cardReplacing = new JSONObject();
		defaultData.put("newGradeID","1");	
		defaultData.put("newUsePolicyID","1");	
		defaultData.put("newCardType","C");	
		defaultData.put("newConsumePolicyID","1");	
		defaultData.put("writeShiftFlag",false);	
		CardReplacingNode.put("oldFacadeCD","201230098001");
		CardReplacingNode.put("oldCardType","C");	
		CardReplacingNode.put("balance",0);	
		CardReplacingNode.put("cumulationMarking",0);	
		CardReplacingNode.put("tradeMarking",0);	
		CardReplacingNode.put("upgradeMarking",0);	
		CardReplacingNode.put("newFacadeCD","201230098002");	
		CardReplacingNode.put("newCardType","C");	
		CardReplacingNode.put("upgradeFlag",true);	
		CardReplacingNode.put("feeMarkingFlag",true);	
		CardReplacingNode.put("feeMarking",0);	
		CardReplacingNode.put("locationCD","59");	
		CardReplacingNode.put("oldSellLocationCD","59");	
		CardReplacingNode.put("reason","1");	
		CardSell.put("userID","ADMIN");	
		CardSell.put("beginFacadeCD","000105");	
		CardSell.put("noCardBatchFlag",false);	
		CardSell.put("noCardBatchType","0");
		CardSell.put("icbcflag","N");	
		CardSell.put("ccbflag","N");	
		CardSell.put("groupFlag","N");	
		CardSell.put("paymentTypeFee","Cash");	
		CardSell.put("paymentNameFee","Cash");	
		CardSell.put("paymentTypeAdd","Cash");	
		CardSell.put("paymentNameAdd","Cash");	
		CardSell.put("addMoney",1000);	
		CardSell.put("fee",0);	
		CardSell.put("membershipFee",0);	
		CardSell.put("parValue",0);	
		CardSell.put("workstation",TestData.FindValueInVariablesByFile("workstation","CardTestData.xml"));	
		CardSell.put("saleSpeed",1.5);	
		CardSell.put("module","BO");	
		CardSell.put("valid","2016-4-25 11:47:13");	
		CardSell.put("photoFlag",false);	
		CardSell.put("writeShiftFlag",false);
		defaultData.put("CardReplacing",CardReplacingNode);	
		defaultData.put("CardSell",CardSell);	
		return defaultData;
	}
	
	public static JSONObject Card_EditMemberInfo()
	{
		CommonRequestData crd = new CommonRequestData("2047", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml").toString());	
//		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml").toString());	
		defaultData.put("facadeCD","10000");
		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml").toString());	
		defaultData.put("memberID","10000");	
		defaultData.put("memberName","sanji");	
		defaultData.put("documentType","111");	
		defaultData.put("documentNO","441303030194919");	
//		defaultData.put("address","1");	
		defaultData.put("postCode","1");	
		defaultData.put("mobilePhone","11111111111111");	
		defaultData.put("birthDate",TestData.FindValueInVariablesByFile("birthDate","CardTestData.xml"));	
//		defaultData.put("mailAddress","1");	
//		defaultData.put("phone","159159930390");	
		defaultData.put("sex","F");	
//		defaultData.put("nation","1");	
//		defaultData.put("nativePlace","1");	
		defaultData.put("needNews","0");	
		defaultData.put("editPhotoFlag","false");	
//		defaultData.put("photo","1");	
		return defaultData;
	}
	
	public static JSONObject Card_ResetPassword()
	{
		CommonRequestData crd = new CommonRequestData("2048", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
		defaultData.put("facadeCD","000101");	
		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml"));	
		defaultData.put("oldPassword","123456");	
		defaultData.put("newPassWord","123456");	
		defaultData.put("operate","C");	
		defaultData.put("documentNO","201230098131");	
		return defaultData;
	}
	
	public static JSONObject Card_UMEImportPre()
	{
		CommonRequestData crd = new CommonRequestData("2049", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
//		defaultData.put("beginFacadeCD",TestData.FindValueInVariablesByFile("beginFacadeCD","CardTestData.xml"));	
//		defaultData.put("endFacadeCD",TestData.FindValueInVariablesByFile("endFacadeCD","CardTestData.xml"));
		defaultData.put("beginFacadeCD","0000000000000001");	
		defaultData.put("endFacadeCD","0000000000000001");
		defaultData.put("tradePolicyID","TPH00001");	
		defaultData.put("flow",TestData.FindValueInVariablesByFile("flow","CardTestData.xml"));	
//		defaultData.put("flowDescription",TestData.FindValueInVariablesByFile("flowDescription","CardTestData.xml"));	
		return defaultData;
	}
	
	public static JSONObject Card_GetMemberInfo()
	{
		CommonRequestData crd = new CommonRequestData("2050", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml"));	
		defaultData.put("facadeCD",TestData.FindValueInVariablesByFile("facadeCD","CardTestData.xml"));	
		defaultData.put("memberID",TestData.FindValueInVariablesByFile("memberID","CardTestData.xml"));	
		return defaultData;
	}
	
	public static JSONObject Card_GetPrefabricateInfo()
	{
		CommonRequestData crd = new CommonRequestData("2051", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("queryMode","0");	
		defaultData.put("facadeCD","000105");	
		defaultData.put("memberID","000105");	
		return defaultData;
	}
	
	public static JSONObject Card_PrefabricateEdit(String str)
	{
		CommonRequestData crd = new CommonRequestData("2052", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000105");	
		defaultData.put("serialCD","000105");	
		defaultData.put("cardType",TestData.FindValueInVariablesByFile("cardType","CardTestData.xml"));	
		defaultData.put("cardFaceFee","0.000000");	
		defaultData.put("usePloicyID","2");	
		defaultData.put("consumePolicyID",TestData.FindValueInVariablesByFile("consumePolicyID","CardTestData.xml"));	
		defaultData.put("flow",TestData.FindValueInVariablesByFile("flow","CardTestData.xml"));	
		defaultData.put("flowDescription",TestData.FindValueInVariablesByFile("flowDescription","CardTestData.xml"));	
		defaultData.put("gradePolicyID",TestData.FindValueInVariablesByFile("gradePolicyID","CardTestData.xml"));	
		defaultData.put("specialID",TestData.FindValueInVariablesByFile("specialID","CardTestData.xml"));	
		defaultData.put("levelForeverFlag",TestData.FindValueInVariablesByFile("levelForeverFlag","CardTestData.xml"));	
		defaultData.put("defaultMarking",TestData.FindValueInVariablesByFile("defaultMarking","CardTestData.xml"));	
		defaultData.put("meDium","ID");	
		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
		defaultData.put("oldFacadeCD",str);	
		return defaultData;
	}
	
	public static JSONObject Card_QueryOrder()
	{
		CommonRequestData crd = new CommonRequestData("2053", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("queryMode","1");	
		defaultData.put("facadeCD","000104");	
		defaultData.put("formCD","");	
		return defaultData;
	}
	
	public static JSONObject Card_QueryPrefabricate()
	{
		CommonRequestData crd = new CommonRequestData("2054", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("queryMode","1");	
		defaultData.put("facadeCD","000103");	
		defaultData.put("formCD","");	
		return defaultData;
	}
	
	public static JSONObject Card_Cancel()
	{
		CommonRequestData crd = new CommonRequestData("2055", "1.0.0.1");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000000003");	
		defaultData.put("userID","YKSE");	
		defaultData.put("cardType",TestData.FindValueInVariablesByFile("cardType","CardTestData.xml"));	
		defaultData.put("balance",0);	
		defaultData.put("refundBalance",0);	
		defaultData.put("refundFee",0);	
		defaultData.put("paymentType",TestData.FindValueInVariablesByFile("paymentType","CardTestData.xml"));	
		defaultData.put("paymentName","Cash");	
//		defaultData.put("salesCD","1");	
//		defaultData.put("billNO","000103");	
		defaultData.put("reason","0");	
//		defaultData.put("roleID","1");	
		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml"));	
		defaultData.put("writeShiftFlag",true);	
		return defaultData;
	}
	
	public static JSONObject Card_Annul(String str)
	{
		CommonRequestData crd = new CommonRequestData("2056", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD",str);	
		defaultData.put("userID","ADMIN");	
		defaultData.put("memberID",str);	
		defaultData.put("refund",0);	
		defaultData.put("paymentType",TestData.FindValueInVariablesByFile("paymentType","CardTestData.xml"));	
		defaultData.put("paymentName","Cash");	
//		defaultData.put("salesCD","1");	
//		defaultData.put("billNO","000103");	
		defaultData.put("reason","0");	
		defaultData.put("memcCreateUserID","ADMIN");	
		defaultData.put("memcCreateUserDate","2016-4-22");	
		defaultData.put("sellLocationCD",TestData.FindValueInVariablesByFile("sellLocationCD","CardTestData.xml"));	
		defaultData.put("writeShiftFlag",true);	
		return defaultData;
	}
	
	public static JSONObject Card_EditPolicy()
	{
		CommonRequestData crd = new CommonRequestData("2057", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");	
		defaultData.put("userID",TestData.FindValueInVariablesByFile("userID","CardTestData.xml"));	
		defaultData.put("oldCumulationMarking",0);	
		defaultData.put("oldTradeMarking",0);	
		defaultData.put("oldUpgradeMarking",0);	
		defaultData.put("oldConsumeUpgradeTM", "10");	
		defaultData.put("oldFirstDate","2016-4-25 11:51:55");	
		defaultData.put("oldLastDate","2016-4-25 11:51:55");	
		defaultData.put("oldInvalidationDate","2016-4-25 11:51:55");	
		defaultData.put("oldGradeID","1");	
		defaultData.put("oldLevelForeverFlag",false);	
		defaultData.put("sellLocationCD","59");	
		defaultData.put("oldUsePolicyID","1");	
		defaultData.put("oldConsumePolicyID","1");
		defaultData.put("newCumulationMarking",100);
		defaultData.put("newTradeMarking",100);
		defaultData.put("newUpgradeMarking",100);
		defaultData.put("newConsumeUpgradeTM","100");
		defaultData.put("newFirstDate","2016-4-25 11:51:55");
		defaultData.put("newLastDate","2017-4-25 11:51:55");
		defaultData.put("newInvalidationDate","2019-4-25 11:51:55");
		defaultData.put("newGradeID","1");
		defaultData.put("newLevelForeverFlag",false);
		defaultData.put("newUsePolicyID","1");
		defaultData.put("newConsumePolicyID","1");	
		return defaultData;
	}
	
	public static JSONObject Card_GLOBALSYS()
	{
		CommonRequestData crd = new CommonRequestData("2058", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_Get_TransferList()
	{
		CommonRequestData crd = new CommonRequestData("2059", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("outFacadeCD","000101");
		defaultData.put("gradeID","1");
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		return defaultData;
	}
	
	public static JSONObject Card_Transfer()
	{
		CommonRequestData crd = new CommonRequestData("2060", "1.0.0.1");
		JSONObject defaultData = crd.getRequestData();

		defaultData.put("outFacadeCD","000101");
		defaultData.put("userID","ADMIN");
		defaultData.put("outSellLocationCD","59");
		defaultData.put("transferMoney",0);
		defaultData.put("transferTradeMarking",0);
		defaultData.put("transferUpgradeMarking",0);
		defaultData.put("transferType","F");
		defaultData.put("inFacadeCD","000102");
		defaultData.put("inSellLocationCD","59");
		defaultData.put("fillZero","false");
		defaultData.put("outHandInput","false");
		defaultData.put("inHandInput","false");
		defaultData.put("tokenNum","beccdc3ca276411bab785b3be2ff6e25");

		return defaultData;
	}
	
	public static JSONObject Card_Get_RePrintSell()
	{
		CommonRequestData crd = new CommonRequestData("2061", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();

		defaultData.put("facadeCD","000101");
		defaultData.put("queryMode","0");
		defaultData.put("sellLocationCD","59");
		defaultData.put("beginDate","2016-4-21");
		defaultData.put("endDate","2016-4-23");
		
		return defaultData;
	}
	
	public static JSONObject Card_Get_RePRintAdd()
	{
		CommonRequestData crd = new CommonRequestData("2062", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("queryMode","0");
		defaultData.put("sellLocationCD","59");
		defaultData.put("beginDate","2016-4-21");
		defaultData.put("endDate","2016-4-23");
		return defaultData;
	}
	
	public static JSONObject Card_Update_Add_PrintTimes()
	{
		CommonRequestData crd = new CommonRequestData("2063", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("addSeqID","592016042203878");
		defaultData.put("sellLocationCD","59");
		defaultData.put("printTimes","1");
		defaultData.put("userID","ADMIN");	
		return defaultData;
	}
	
	public static JSONObject Card_Get_RePrintConsume()
	{
		CommonRequestData crd = new CommonRequestData("2064", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("queryMode","0");
		defaultData.put("sellLocationCD","59");
		defaultData.put("beginDate","2016-4-21");
		defaultData.put("endDate","2016-4-23");
		return defaultData;
	}
	
	public static JSONObject Card_Get_RePrintGift()
	{
		CommonRequestData crd = new CommonRequestData("2065", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("queryMode","0");
		defaultData.put("sellLocationCD","59");
		defaultData.put("beginDate","2016-4-21");
		defaultData.put("endDate","2016-4-23");
		return defaultData;
	}
	
	public static JSONObject Card_AddMoney_WriteCard()
	{
		CommonRequestData crd = new CommonRequestData("2066", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID","ADMIN");
		defaultData.put("addID","592016042203878");
		defaultData.put("addLocationCD","59");
		return defaultData;
	}
	
	public static JSONObject Card_Get_OldCardInfo()
	{
		CommonRequestData crd = new CommonRequestData("2067", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("cardLocationCd","59");
		return defaultData;
	}
	
	public static JSONObject Card_Get_NewCardInfo()
	{
		CommonRequestData crd = new CommonRequestData("2068", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("cardLocationCd","59");
		return defaultData;
	}
	
	public static JSONObject Card_Refund()
	{
		CommonRequestData crd = new CommonRequestData("2069", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject posBooking = new JSONObject();
		JSONObject MemberCardWallet = new JSONObject();
		ArrayList wallet = new ArrayList();
		defaultData.put("userId","ADMIN");
		defaultData.put("writeCardFlg",false);
		defaultData.put("fingerFlg",false);
		defaultData.put("channelCd","BO");
		posBooking.put("bookingId","20160466");
		posBooking.put("totalAmount",1);
		posBooking.put("totalConsumeMarking",1);
		posBooking.put("remarks","returning");
		MemberCardWallet.put("walletItemSeqNo","592016050400199");
		MemberCardWallet.put("useCount","1");
		MemberCardWallet.put("bookingId","5901605040045919");
		MemberCardWallet.put("systemCd","BO");
		defaultData.put("cardLocationCd","59");
		defaultData.put("cardFacadeCd","000101");
		defaultData.put("cardSerialNo","000101");
		wallet.add(MemberCardWallet);
		defaultData.put("wallet",wallet);
		defaultData.put("posBooking",posBooking);
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		return defaultData;
	}
	
	public static JSONObject Card_RefundRollback()
	{
		CommonRequestData crd = new CommonRequestData("2070", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList<String> bookingIds = new ArrayList<String>();
		bookingIds.add("5901605040045919");
		defaultData.put("bookingIds",bookingIds);
		defaultData.put("userId",TestData.FindValueInVariablesByFile("userId","CardTestData.xml"));
		defaultData.put("cardLocationCd",TestData.FindValueInVariablesByFile("cardLocationCd","CardTestData.xml"));
		defaultData.put("cardFacadeCd","000101");
		defaultData.put("cardSerialNo","000101");
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		return defaultData;
	}
	
	public static JSONObject Card_Get_ReSellInfo()
	{
		CommonRequestData crd = new CommonRequestData("2071", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("serialCD","000101");
		return defaultData;
	}
	
	public static JSONObject Card_Get_BatchAddInfo()
	{
		CommonRequestData crd = new CommonRequestData("2072", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("beginFacadeCD","000100");
		defaultData.put("endFacadeCD","000101");
		defaultData.put("queryMode","0");
		return defaultData;
	}
	
	public static JSONObject Card_ReSell()
	{
		CommonRequestData crd = new CommonRequestData("2073", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","00000110184");
		defaultData.put("serialCD","00000110184");
		defaultData.put("userID","ADMIN");
		defaultData.put("medium","ID");
		defaultData.put("sellLocationCD","59");
		defaultData.put("workstation","USER-20160226DV");
		defaultData.put("memberID","00000010036");
		defaultData.put("memberName","2");
		defaultData.put("documentType","身份证");
		defaultData.put("documentNO","320211198508131234");
		defaultData.put("address","0");
		defaultData.put("postCode","0");
		defaultData.put("mobilePhone","6");
		defaultData.put("birthDate","1985-08-13");
		defaultData.put("mailAddress","0");
		defaultData.put("phone","0");
		defaultData.put("sex","F");
		defaultData.put("nation","0");
//		defaultData.put("nativePlace","0");
		defaultData.put("needNews","0");

		return defaultData;
	}
	
	public static JSONObject Card_GetEvents()
	{
		CommonRequestData crd = new CommonRequestData("2080", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		return defaultData;
	}
	
	public static JSONObject Card_AddEvents()
	{
		CommonRequestData crd = new CommonRequestData("2081", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("cardLocationCd","59");
		defaultData.put("event","1");
		defaultData.put("approvalUserId","ADMIN");
		defaultData.put("userId","ADMIN");
		return defaultData;
	}
	
	public static JSONObject Card_DeleteEvents(String str)
	{
		CommonRequestData crd = new CommonRequestData("2082", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userId","ADMIN");
		defaultData.put("cardLocationCd","59");
		defaultData.put("no", str);
		return defaultData;
	}
	
	public static JSONObject Card_WebSellGradeList()
	{
		CommonRequestData crd = new CommonRequestData("2083", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_WebSellInfo()
	{
		CommonRequestData crd = new CommonRequestData("2084", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("gradeID","1");
		return defaultData;
	}
	
	public static JSONObject Card_ExchangeCCB(JSONObject CardInfo)
	{
		CommonRequestData crd = new CommonRequestData("2085", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID","ADMIN");
		defaultData.put("facadeCD",CardInfo.get("facadeCD"));
		defaultData.put("replaceFlagOld","N");
		defaultData.put("replaceFlagNew","Y");
		defaultData.put("balance",CardInfo.get("balance"));
		defaultData.put("cumulationMarking",CardInfo.get("cumulationMarking"));
		defaultData.put("tradeMarking",CardInfo.get("tradeMarking"));
		defaultData.put("upgradeMarking",CardInfo.get("upgradeMarking"));
		defaultData.put("sellLocationCD","59");
		return defaultData;
	}
	
	public static JSONObject Card_AddMoney_ID()
	{
		CommonRequestData crd = new CommonRequestData("2086", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_Get_WalletGiftType()
	{
		CommonRequestData crd = new CommonRequestData("2087", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_Get_WalletVoucherGroup()
	{
		CommonRequestData crd = new CommonRequestData("2088", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_ManuallyWallet()
	{
		CommonRequestData crd = new CommonRequestData("2089", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userID","ADMIN");
		defaultData.put("manuallyType","0");
		defaultData.put("facadeCD","000101");
		defaultData.put("sellLocationCD","59");
		defaultData.put("giftType","C");
		defaultData.put("giftNo","592016042500183");
		defaultData.put("giftName","11");
		defaultData.put("giftMoney",30);
		defaultData.put("giftCount","1");
		defaultData.put("validityDate","2016-4-25");
		defaultData.put("module","BO");
		return defaultData;
	}
	
	public static JSONObject Card_Check_NoCardSell()
	{
		CommonRequestData crd = new CommonRequestData("2090", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("beginFacadeCD","000105");
		defaultData.put("endFacadeCD","000106");
		defaultData.put("noCardBatchType","1");
		return defaultData;
	}
	
	public static JSONObject Card_RecoverWallet(String str)
	{
		CommonRequestData crd = new CommonRequestData("2091", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList<String> seqID = new ArrayList<String>();
		seqID.add(str);
		defaultData.put("userID","ADMIN");
		defaultData.put("facadeCD","000101");
		defaultData.put("sellLocationCD","59");
		defaultData.put("seqID",seqID);
		return defaultData;
	}
	
	public static JSONObject Card_GetCardGift()
	{
		CommonRequestData crd = new CommonRequestData("2092", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_GiftExchange()
	{
		CommonRequestData crd = new CommonRequestData("2093", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		ArrayList giftListNodes = new ArrayList();
		JSONObject GiftListNode = new JSONObject();
		defaultData.put("userID","ADMIN");
		defaultData.put("facadeCD","000101");
		defaultData.put("sellLocationCD","59");
		defaultData.put("webExchangeFlag","N");
		defaultData.put("exchangePlace","BO");
		defaultData.put("totalMarking",0);
		defaultData.put("paymentType","Cash");
		defaultData.put("paymentName","Cash");
		defaultData.put("writeShiftFlag",true);
		defaultData.put("totalMoney",0);
		defaultData.put("workstation","workstation");
		defaultData.put("tokenNum",CommonUntil.getPassNum());
		GiftListNode.put("giftName","money");
		GiftListNode.put("giftID","GM5920160429002");
		GiftListNode.put("birthdayGift",false);
		GiftListNode.put("exchangeIntegral",0);
		GiftListNode.put("exchangeMoney",0);
		GiftListNode.put("exchangeAmount","1");
		GiftListNode.put("exchangeFlag",false);
		giftListNodes.add(GiftListNode);
		defaultData.put("giftListNodes",giftListNodes);
		return defaultData;
	}
	
	public static JSONObject Card_QueryGiftExchange()
	{
		CommonRequestData crd = new CommonRequestData("2094", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("facadeCD","000101");
		defaultData.put("queryLocationCD","59");
		return defaultData;
	}
	
	public static JSONObject Card_QueryManuallyWallet()
	{
		CommonRequestData crd = new CommonRequestData("2095", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("manuallyType","0");
		defaultData.put("beginFacadeCD","000101");
		defaultData.put("endFacadeCD","000102");
		return defaultData;
	}
	
	public static JSONObject Card_ParmsSetting()
	{
		CommonRequestData crd = new CommonRequestData("2201", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_SetCardPolicy()
	{
		CommonRequestData crd = new CommonRequestData("2201", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject Card_UpdateBindingPolicy()
	{
		CommonRequestData crd = new CommonRequestData("2117", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject CardBindingPolicyInfo = new JSONObject();
		ArrayList BindindPolicyList = new ArrayList();
		CardBindingPolicyInfo.put("LocationCd","59");
		CardBindingPolicyInfo.put("OrderCD","000101");
		CardBindingPolicyInfo.put("BeginFacadeCD","000105");
		CardBindingPolicyInfo.put("EndFacadeCD","000106");
		CardBindingPolicyInfo.put("totalcount","0");
		BindindPolicyList.add(CardBindingPolicyInfo);
		//&totalcount=0
		
		defaultData.put("BindindPolicyList",BindindPolicyList);
		return defaultData;
	}
	
	public static JSONObject Card_GetOrderResult()
	{
		CommonRequestData crd = new CommonRequestData("2118", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject CardBindingPolicyInfo = new JSONObject();
//		defaultData.put("FormCD","1111111111");
		return defaultData;
	}
	
	public static JSONObject Card_GetBindingPolicy()
	{
		CommonRequestData crd = new CommonRequestData("2119", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("FormCD","151026012");
		return defaultData;
	}
	
	public static JSONObject Card_QueryTicketBuyPage()
	{
		CommonRequestData crd = new CommonRequestData("2122", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject Page = new JSONObject();
		defaultData.put("FacadeCD","000101");
		defaultData.put("CardLocationCd","59");
		Page.put("PageIndex","1");
		Page.put("PageSize","5");
		defaultData.put("Page",Page);
		return defaultData;
	}
	
	public static JSONObject Card_GetCardBuyingPage()
	{
		CommonRequestData crd = new CommonRequestData("2123", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject Page = new JSONObject();
		defaultData.put("cardFacadeCd","000101");
		defaultData.put("CardLocationCd","59");
		Page.put("PageIndex","1");
		Page.put("PageSize","5");
		defaultData.put("Page",Page);
		return defaultData;
	}
	
	public static JSONObject Card_QueryAddMoneyPage()
	{
		CommonRequestData crd = new CommonRequestData("2124", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		JSONObject Page = new JSONObject();
		defaultData.put("FacadeCd","000101");
		defaultData.put("CardLocationCd","59");
		Page.put("PageIndex",1);
		Page.put("PageSize",5);
		defaultData.put("Page",Page);
		return defaultData;
	}
}
