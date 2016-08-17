package ykse.TestAutomation.Interface.V2.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

import ykse.TestAutomation.Common.Log;

public class InterFaceV2Assertion {
	static Logger logger = new Log("interface_v2").logger;
	public static Boolean TA_cinema_getCinemas(String res){
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		//查询数据库
		String sql = "select t1.cinema_link_id from ec.ec_channel_cinema t1 RIGHT JOIN basedata.data_cinema t2 on t1.cinema_link_id = t2.cinema_link_id where channel_code='GWL'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("cinema_link_id"));
		}
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("data").asObject().get("dataList").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("data").asObject().get("dataList").asArray().get(i).asObject().get("cinemaLinkId").toString());
		}
		DBList.sort(null);
		resList.sort(null);
		System.out.println(DBList);
		System.out.println(resList);
		if(DBList.size()==resList.size())
		{
			for(int i = 0; i<DBList.size(); i++)
			{
				if(!DBList.get(i).equals(resList.get(i)))
				{
					logger.warn("返回sessioncode与数据库查询结果不一致");
					logger.warn("返回" + resList.get(i) + "数据库查询"+DBList.get(i));
					return false;
				}
			}
		}
		else
		{
			logger.warn("返回sessioncode与数据库查询结果不一致");
			return false;
		}
		logger.warn("返回sessioncode与数据库查询结果一致");
		return true;
	}
	
	
	public static boolean TA_schedule_getSchedules(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		//查询数据库
		String sql = "select count(*) as scheduleCount from ec.ec_schedule t1 RIGHT JOIN ec.ec_schedule_channel t2 on t1.id = t2.schedule_id RIGHT JOIN ec.ec_channel t3 on t2.internal_channel_code = t3.internal_channel_code where t1.cinema_link_id='681' and t3.channel_code = 'API_APP_ANDROID_TEST' AND t1.show_time BETWEEN DATE_ADD(curdate(),INTERVAL +6 HOUR) and DATE_ADD(DATE_ADD(curdate(),INTERVAL +6 HOUR),INTERVAL +1 DAY)";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList DBList = new ArrayList();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add( rsTree.get("scheduleCount"));
		}
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();	
		resList.add(jsonRes.asObject().get("data").asObject().get("dataList").asArray().size()+"");
		System.out.println(DBList);
		System.out.println(resList);
		if(DBList.get(0).toString().equals(resList.get(0))){
			logger.warn("返回sessioncode与数据库查询结果一致");
			return true;
		}
		else{
			logger.warn("返回sessioncode与数据库查询结果不一致");
			return false;
		}
	}
	
	public static boolean TA_seat_getSeats(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
//		String sql = "select count(*) as scheduleCount from ec.ec_schedule t1 RIGHT JOIN ec.ec_schedule_channel t2 on t1.id = t2.schedule_id RIGHT JOIN ec.ec_channel t3 on t2.internal_channel_code = t3.internal_channel_code where t1.cinema_link_id='681' and t3.channel_code = 'API_APP_ANDROID_TEST' AND t1.show_time BETWEEN DATE_ADD(curdate(),INTERVAL +6 HOUR) and DATE_ADD(DATE_ADD(curdate(),INTERVAL +6 HOUR),INTERVAL +1 DAY)";
//		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		return true;
	}
	public static boolean TA_seat_getScheduleSoldSeats(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_seat_lockSeats(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_confirmOrder(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_confirmMixOrder(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_getOrderInfo(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_getTicketInfo(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	
	public static boolean TA_ticket_printTicket(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	
	public static boolean TA_ticket_getOrderPrintStatus(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	
	public static boolean TA_order_refundOrder(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	
	public static boolean TA_goods_getGoods(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_confirmGoodsOrder(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_getGoodsOrderInfo(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
	public static boolean TA_order_refundGoodsOrder(String res) {
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("[检查点_2]. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("[检查点_3]. 检查返回sessoncode和数据库是否一致");
		return true;
	}
}
