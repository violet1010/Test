package ykse.TestAutomation.Interface.OWN.Common;

import org.json.JSONObject;

import ykse.TestAutomation.Common.HttpSampler;
import ykse.TestAutomation.Interface.OWN.Common.CommonRequestData;
import ykse.TestAutomation.Interface.OWN.Common.InterFaceOwnGetValueForOther;

public class InterFaceOwnData {
	
	public static String securityLogin(String api, String caseId){
		
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByApiNameAndCaseId(api,"account",caseId);
		String password = TestData.FindValueByApiNameAndCaseId(api,"password",caseId);
		String type = TestData.FindValueByApiNameAndCaseId(api,"type",caseId);
		String devicePrint = TestData.FindValueByApiNameAndCaseId(api,"devicePrint",caseId);
		String cinemaLinkId = TestData.FindValueByApiNameAndCaseId(api,"cinemaLinkId",caseId);
		parameterRequest.put("account", account);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(api);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	/*
	public static String securitySignin(String api, String caseId) {
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByApiNameAndCaseId(api,"account",caseId);
		String password = TestData.FindValueByApiNameAndCaseId(api,"password",caseId);
		String type = TestData.FindValueByApiNameAndCaseId(api,"type",caseId);
		String devicePrint = TestData.FindValueByApiNameAndCaseId(api,"devicePrint",caseId);
		String mobileCountryCode = TestData.FindValueByApiNameAndCaseId(api,"mobileCountryCode",caseId);
		
		parameterRequest.put("account", account);
		parameterRequest.put("mobileCountryCode", mobileCountryCode);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(api);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
	}
	*/
	
	public static String securitySignin(){
		//正常登录
		String apiName = "ykse.security.signin";
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByName("account");
		String password = TestData.FindValueByName("password");
		String type = TestData.FindValueByName("type");
		String devicePrint = TestData.FindValueByName("devicePrint");
		String mobileCountryCode = TestData.FindValueByName("mobileCountryCode");
		
		parameterRequest.put("account", account);
		parameterRequest.put("mobileCountryCode", mobileCountryCode);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String securitySigninWrongPW(){
		//错误密码
		String apiName = "ykse.security.signin";
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByName("account");
		String password = TestData.FindValueByName("wrongpw");
		String type = TestData.FindValueByName("type");
		String devicePrint = TestData.FindValueByName("devicePrint");
		String mobileCountryCode = TestData.FindValueByName("mobileCountryCode");
		
		parameterRequest.put("account", account);
		parameterRequest.put("mobileCountryCode", mobileCountryCode);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	
	public static String securityLogin(){
		//正常登录
		String apiName = "ykse.security.login";
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByName("account");
		String password = TestData.FindValueByName("password");
		String type = TestData.FindValueByName("type");
		String devicePrint = TestData.FindValueByName("devicePrint");
		String cinemaLinkId = TestData.FindValueByName("cinemaLinkId");
		parameterRequest.put("account", account);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String securityLoginWrongPW(){
		//错误密码
		String apiName = "ykse.security.login";
		JSONObject parameterRequest = new JSONObject();
		String account = TestData.FindValueByName("account");
		String password = TestData.FindValueByName("wrongpw");
		String type = TestData.FindValueByName("type");
		String devicePrint = TestData.FindValueByName("devicePrint");
		String cinemaLinkId = TestData.FindValueByName("cinemaLinkId");
		parameterRequest.put("account", account);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getHotFilmsPosterSizeLarge(){
		//大海报
		String apiName = "ykse.film.getHotFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeLarge");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getHotFilmsPosterSizeMiddle(){
		//中海报
		String apiName = "ykse.film.getHotFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeMiddle");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getHotFilmsPosterSizeSmall(){
		//小海报
		String apiName = "ykse.film.getHotFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeSmall");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getSoonFilmsPosterSizeLarge(){
		//大海报
		String apiName = "ykse.film.getSoonFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeLarge");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getSoonFilmsPosterSizeMiddle(){
		//中海报
		String apiName = "ykse.film.getSoonFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeSmall");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getSoonFilmsPosterSizeSmall(){
		//小海报
		String apiName = "ykse.film.getSoonFilms";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		String posterSize = TestData.FindValueByName("posterSizeLargeSmall");
		
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("posterSize", posterSize);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getFilmDetail(){
		//影片详情
		String apiName = "ykse.film.getFilmDetail";
		JSONObject parameterRequest = new JSONObject();
		
		String filmId = InterFaceOwnGetValueForOther.getSoonFilmsValue(0, "filmId");
		parameterRequest.put("filmId", filmId);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getFilmComments(){
		//获取影片评论
		String apiName = "ykse.comment.getFilmComments";
		JSONObject parameterRequest = new JSONObject();
		
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		String filmId = InterFaceOwnGetValueForOther.getSoonFilmsValue(0, "filmId");
		String page = TestData.FindValueByName("page");
		
		parameterRequest.put("filmId", filmId);
		parameterRequest.put("page", page);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String createFilmComment(){
		//新增影片评论
		String apiName = "ykse.comment.createFilmComment";
		JSONObject parameterRequest = new JSONObject();
		
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		String filmId = InterFaceOwnGetValueForOther.getSoonFilmsValue(0, "filmId");
		String content = TestData.FindValueByName("content");
		String rate = TestData.FindValueByName("rate");
		parameterRequest.put("filmId", filmId);
		parameterRequest.put("content", content);
		parameterRequest.put("rate", rate);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getCinemas(){
		//获取影院列表（无登录）
		String apiName = "ykse.cinema.getCinemas";
		JSONObject parameterRequest = new JSONObject();
		String cityCode = TestData.FindValueByName("cityCode");
		parameterRequest.put("cityCode", cityCode);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getCinemasByFilmId(){
		//获取指定影片的影院列表（无登录）
		String apiName = "ykse.cinema.getCinemasByFilmId";
		JSONObject parameterRequest = new JSONObject();
		String filmId = InterFaceOwnGetValueForOther.getHotFilmsValue(0, "filmId");
		String cityCode = TestData.FindValueByName("cityCode");
		parameterRequest.put("cityCode", cityCode);
		parameterRequest.put("filmId", filmId);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getCinemaDetail(){
		//获取指定影院的详细信息
		String apiName = "ykse.cinema.getCinemaDetail";
		JSONObject parameterRequest = new JSONObject();
		String cinemaLinkId = InterFaceOwnGetValueForOther.getCinemasValue(0, "cinemaLinkId");
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getSchedules(String cinemaLinkId){
		//获取指定影院的所有场次信息，按时间由近及远进行排序
		String apiName = "ykse.schedule.getSchedules";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getActivityDetail(String cinemaLinkId,String activityId){
		//获取活动的详细信息
		String apiName = "ykse.activity.getActivityDetail";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("activityId", activityId);	
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getSeatMap(String cinemaLinkId,JSONObject valueHss){
		//获取活动的详细信息
		String apiName = "ykse.seat.getSeatMap";
		JSONObject parameterRequest = new JSONObject();
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	
	public static String getSoldSeats(String cinemaLinkId,JSONObject valueHss){
		//获取活动的详细信息
		String apiName = "ykse.seat.getSoldSeats";
		JSONObject parameterRequest = new JSONObject();
		String sid = InterFaceOwnGetValueForOther.getLoginValue("sid");
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String lockSeats(String sid,String cinemaLinkId, JSONObject valueHss, String seatIds){
		//获取活动的详细信息
		String apiName = "ykse.seat.lockSeats";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		parameterRequest.put("seatIds", seatIds);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String unlockSeats(String sid, String cinemaLinkId, String lockOrderId){
		//获取活动的详细信息
		String apiName = "ykse.seat.unlockSeats";
		JSONObject parameterRequest = new JSONObject();

		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("lockOrderId", lockOrderId);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	
	public static String getGoodses(String sid, String cinemaLinkId){
		//获取卖品列表
		String apiName = "ykse.goods.getGoodses";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getPayInfoGOODS(String sid,String cinemaLinkId,JSONObject valuesGetGoods ){
		//获取卖品列表
		String apiName = "ykse.pay.getPayInfo";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("goodsParams", valuesGetGoods.get("goodsParams"));

		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getPayInfoTicket(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds ){
		//获取卖品列表
		String apiName = "ykse.pay.getPayInfo";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		parameterRequest.put("seatIds", seatIds);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String getPayInfoTicketGoods(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds, JSONObject valuesGetGoods){
		//获取卖品列表
	
		String apiName = "ykse.pay.getPayInfo";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		parameterRequest.put("seatIds", seatIds);
		parameterRequest.put("goodsParams", valuesGetGoods.get("goodsParams"));
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String createGoodsOrder(String sid,String cinemaLinkId,JSONObject valuesGetGoods, JSONObject valueGetPayInfo){

		//获取卖品列表
		String apiName = "ykse.order.createGoodsOrder";
		JSONObject parameterRequest = new JSONObject();
		
		parameterRequest.put("sid", sid);
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("goodsParams", valuesGetGoods.get("goodsParams"));
		parameterRequest.put("totalPrice", valueGetPayInfo.get("privilegeTotalPrice"));
		parameterRequest.put("cardNumber", valueGetPayInfo.get("cardNumber"));
		//parameterRequest.put("payToolId", valueGetPayInfo.get("payToolId"));
		parameterRequest.put("mobile", "18665778762");

		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String createTicketOrder(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds,String lockOrderId, JSONObject valueGetPayInfo ){
		//创建影票订单
		String apiName = "ykse.order.createTicketOrder";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		parameterRequest.put("seatIds", seatIds);
		parameterRequest.put("lockOrderId", lockOrderId);
		parameterRequest.put("privilegeId", valueGetPayInfo.get("privilegeId"));
		//parameterRequest.put("payToolId", valueGetPayInfo.get("payToolId"));
		parameterRequest.put("cardNumber", valueGetPayInfo.get("cardNumber"));
		parameterRequest.put("totalPrice", valueGetPayInfo.get("privilegeTotalPrice"));
		parameterRequest.put("mobile", "18665778762");
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String createTicketGoodsOrder(String sid,String cinemaLinkId,JSONObject valueHss,String seatIds, JSONObject valuesGetGoods,String lockOrderId, JSONObject valueGetPayInfo ){
		//创建影票订单
		String apiName = "ykse.order.createTicketOrder";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("hallId", valueHss.getString("hallId"));
		parameterRequest.put("scheduleId", valueHss.getString("scheduleId"));
		parameterRequest.put("scheduleKey", valueHss.getString("scheduleKey"));
		parameterRequest.put("seatIds", seatIds);
		parameterRequest.put("goodsParams", valuesGetGoods.get("goodsParams"));
		parameterRequest.put("lockOrderId", lockOrderId);
		parameterRequest.put("privilegeId", valueGetPayInfo.get("privilegeId"));
		parameterRequest.put("cardNumber", valueGetPayInfo.get("cardNumber"));
		//parameterRequest.put("payToolId", valueGetPayInfo.get("payToolId"));
		parameterRequest.put("totalPrice", valueGetPayInfo.get("privilegeTotalPrice"));
		parameterRequest.put("mobile", "18665778762");
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;

	}
	
	public static String cancelOrder(String sid, String cinemaLinkId,String orderType,JSONObject createTicketGoodsOrderValue){
		//取消订单
		String apiName = "ykse.order.cancelOrder";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("orderType", orderType);
		parameterRequest.put("orderId", createTicketGoodsOrderValue.get("orderId"));
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getPaidOrders(String sid){
		//获取已支付的订单列表
		String apiName = "ykse.order.getPaidOrders";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getUnpaidOrders(String sid){
		//获取已支付的订单列表
		String apiName = "ykse.order.getUnpaidOrders";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String register(String mobileCountryCode, String mobile, String password, String code){
		//获取已支付的订单列表
		String apiName = "ykse.account.register";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getCities(){
		//获取已支付的订单列表
		String apiName = "ykse.region.getCities";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getSid(){
		//获取已支付的订单列表
		String apiName = "ykse.security.getSid";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String logout(String tid){
		//获取已支付的订单列表
		String apiName = "ykse.security.logout";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("tid", tid);
		parameterRequest.put("devicePrint", "1");
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String sendMsgCode(String phoneNo){
		//获取已支付的订单列表
		String apiName = "ykse.mobile.sendMsgCode";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("phoneNo", phoneNo);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String sendSMSCode(String mobileCountryCode, String mobile, String type){
		//获取已支付的订单列表
		String apiName = "ykse.security.sendSMSCode";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("mobileCountryCode", mobileCountryCode);
		parameterRequest.put("mobile", mobile);
		parameterRequest.put("type", type);
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getAccountBySid(String sid){
		//获取会员基本信息
		String apiName = "ykse.account.getAccountBySid";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("sid", sid);
	
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String modifyPassword(String sid){
		//修改密码
		String apiName = "ykse.account.modifyPassword";
		String newPassword = TestData.FindValueByName("password");
		String oldPassword = TestData.FindValueByName("password");
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("sid", sid);
		parameterRequest.put("oldPassword", oldPassword);
		parameterRequest.put("newPassword", newPassword);
	
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getCardGrades(String sid, String cinemaLinkId){
		//获取影院的开卡等级列表
		String apiName = "ykse.card.getCardGrades";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
	
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getPreCardDetail(String sid,String cinemaLinkId,JSONObject values){
		//获取预制卡详细信息
		String apiName = "ykse.card.getPreCardDetail";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("gradeId", values.get("gradeId"));
	
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String applyCard(String sid,String cinemaLinkId,JSONObject preCardDetailValue){
		//申请会员卡0000006000000085
		String apiName = "ykse.card.applyCard";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("accountId", "0000006000000085");
		parameterRequest.put("cardNumber", preCardDetailValue.get("cardNumber"));
		parameterRequest.put("cardCost", preCardDetailValue.get("cardCost"));
		parameterRequest.put("membershipFee", preCardDetailValue.get("membershipFee"));
		parameterRequest.put("consumeTimes", preCardDetailValue.get("consumeTimes"));
		parameterRequest.put("gradeId", preCardDetailValue.get("gradeId"));
		parameterRequest.put("usePolicyId", preCardDetailValue.get("usePolicyId"));
		
		parameterRequest.put("balance", "10000");
		parameterRequest.put("cardPassword", "888888");
		parameterRequest.put("idCard", "18665778762");
		parameterRequest.put("cardMobile", "18665778762");
		parameterRequest.put("cardUserName", "QH");
		
		parameterRequest.put("payToolId", "IqM1iJmF");
		//parameterRequest.put("openId", values.get("openId"));
		//parameterRequest.put("authCode", values.get("authCode"));
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String bindCard(String sid,String cinemaLinkId){
		//获取预制卡详细信息
		String apiName = "ykse.card.bindCard";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("cardNumber", "00000");
		parameterRequest.put("cardPassword", "888888");
		parameterRequest.put("idCard", "18665778762");
		parameterRequest.put("cardUserName", "QH");
		parameterRequest.put("cardMobile", "18665778762");
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String unbindCard(String sid,String cinemaLinkId){
		//获取预制卡详细信息
		String apiName = "ykse.card.unbindCard";
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("cardNumber", "00000");
		parameterRequest.put("cardPassword", "888888");
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getCards(String sid){
		//获取预制卡详细信息
		String apiName = "ykse.card.getCards";
		JSONObject parameterRequest = new JSONObject();
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getCardDetail(String sid,JSONObject getCardValues){
		//获取预制卡详细信息
		String apiName = "ykse.card.getCardDetail";
		JSONObject parameterRequest = new JSONObject();
		
		parameterRequest.put("cinemaLinkId", getCardValues.get("cinemaLinkId"));
		parameterRequest.put("cardNumber", getCardValues.get("cardNumber"));
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String createRechargeOrder(String sid,JSONObject getCardValues){
		//获取预制卡详细信息
		String apiName = "ykse.card.createRechargeOrder";
		JSONObject parameterRequest = new JSONObject();
		
		parameterRequest.put("cinemaLinkId", getCardValues.get("cinemaLinkId"));
		parameterRequest.put("cardNumber", getCardValues.get("cardNumber"));
		
		//parameterRequest.put("chipNumber", getCardValues.get("chipNumber"));
		parameterRequest.put("pay", "10000");
		//parameterRequest.put("reason", getCardValues.get("reason"));
		parameterRequest.put("amountTimes", "0");
		parameterRequest.put("payToolId", "IqM1iJmF");
		//parameterRequest.put("openId", getCardValues.get("openId"));
		//parameterRequest.put("authCode", getCardValues.get("authCode"));
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getCardRecords(String sid,JSONObject getCardValues,String recordType){
		//获取预制卡详细信息
		String apiName = "ykse.card.getCardRecords";
		JSONObject parameterRequest = new JSONObject();
		
		parameterRequest.put("cinemaLinkId", getCardValues.get("cinemaLinkId"));
		parameterRequest.put("cardNumber", getCardValues.get("cardNumber"));
		parameterRequest.put("recordType", recordType);
		
		//parameterRequest.put("chipNumber", getCardValues.get("chipNumber"));
		//parameterRequest.put("pay", "10000");
		//parameterRequest.put("reason", getCardValues.get("reason"));
		//parameterRequest.put("amountTimes", "0");
		//parameterRequest.put("payToolId", "IqM1iJmF");
		//parameterRequest.put("openId", getCardValues.get("openId"));
		//parameterRequest.put("authCode", getCardValues.get("authCode"));
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String getAllCardGrades(String sid,String cinemaLinkId){
		//获取预制卡详细信息
		String apiName = "ykse.card.getAllCardGrades";
		JSONObject parameterRequest = new JSONObject();
		
		parameterRequest.put("cinemaLinkId", cinemaLinkId);

		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(apiName);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String securitySignin(String caseSetup){
		//普通登录（新版）
		
		String api = TestData.FindValueByName("securitySigninApiIsRight");
		String account = TestData.FindValueByName("securitySigninAccountIsRight");
		String password = TestData.FindValueByName("securitySigninPasswordIsRight");
		String type = TestData.FindValueByName("securitySigninPasswordIsRight");
		String devicePrint = TestData.FindValueByName("securitySigninDevicePrintIsRight");
		String mobileCountryCode = TestData.FindValueByName("securitySigninMobileCountryCodeIsRight");
		
		if (caseSetup.equals("securitySigninApiIsNotExist")){
			api = TestData.FindValueByName("securitySigninApiIsNotExist");
		}
		else if(caseSetup.equals("securitySigninApiIsEmpty")){
			api = TestData.FindValueByName("securitySigninApiIsEmpty");
		}
		else if(caseSetup.equals("securitySigninAccountIsNotExist")){
			account = TestData.FindValueByName("securitySigninAccountIsNotExist");
		}
		else if(caseSetup.equals("securitySigninAccountisEmpty")){
			account = TestData.FindValueByName("securitySigninAccountisEmpty");
		}
		else if(caseSetup.equals("securitySigninPasswordIsNotExist")){
			password = TestData.FindValueByName("securitySigninPasswordIsNotExist");
		}
		else if(caseSetup.equals("securitySigninPasswordisEmpty")){
			password = TestData.FindValueByName("securitySigninPasswordisEmpty");
		}
		else if(caseSetup.equals("securitySigninPasswordIsNotExist")){
			type = TestData.FindValueByName("securitySigninPasswordIsNotExist");
		}
		else if(caseSetup.equals("securitySigninDevicePrintIsNotExist")){
			type = TestData.FindValueByName("securitySigninDevicePrintIsNotExist");
		}
		else if(caseSetup.equals("securitySigninDevicePrintisEmpty")){
			type = TestData.FindValueByName("securitySigninDevicePrintisEmpty");
		}
		else if(caseSetup.equals("securitySigninMobileCountryCodeIsNotExist")){
			mobileCountryCode = TestData.FindValueByName("securitySigninMobileCountryCodeIsNotExist");
		}
		else if(caseSetup.equals("securitySigninMobileCountryCodeisEmpty")){
			mobileCountryCode = TestData.FindValueByName("securitySigninMobileCountryCodeisEmpty");
		}
		
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("account", account);
		parameterRequest.put("password", password);
		parameterRequest.put("type", type);
		parameterRequest.put("devicePrint", devicePrint);
		parameterRequest.put("mobileCountryCode", mobileCountryCode);
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi(api);
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,null);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
		
	}
	
	public static String securitySignin(JSONObject caseSetup){
		
		return "";
	}

	public static String payOrderWithCard(String sid, String cinemaLinkId, String orderType,JSONObject createTicketGoodsOrderValue) {
		JSONObject parameterRequest = new JSONObject();
		parameterRequest.put("cinemaLinkId", cinemaLinkId);
		parameterRequest.put("cardCinemaLinkId", cinemaLinkId);
		parameterRequest.put("cardNumber", createTicketGoodsOrderValue.get("cardNumber"));
		parameterRequest.put("cardPassword", createTicketGoodsOrderValue.get("cardPassword"));
		parameterRequest.put("orderType", orderType);
		parameterRequest.put("orderId", createTicketGoodsOrderValue.get("orderId"));
		
		CommonRequestData  commonRequestData = new CommonRequestData();
		commonRequestData.setApi("ykse.card.payOrderWithCard");
		JSONObject gatewayRequest = commonRequestData.gatewayRequest();
		String sign = commonRequestData.getSign(parameterRequest,sid);
		gatewayRequest.put("sid", sid);
		gatewayRequest.put("sign", sign);
		gatewayRequest.put("data", parameterRequest.toString());
		
		String response =  HttpSampler.sendGet("http://172.33.0.188:8080/route", gatewayRequest);
		return response;
	}



}
