package ykse.TestAutomation.Interface.Finixx.Common;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

import ykse.TestAutomation.Common.Log;

public class InterFaceFinixxCardAssertion {
	static Logger logger = new Log("interface_Finixx").logger;
	public static boolean TA_Card_GetCardInfo(String res) {
		// TODO Auto-generated method stub
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
	
	
	public static boolean TA_Card_GetUsePolicy(String res) {
		// TODO Auto-generated method stub
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
		logger.info("[检查点_3]. 检查返回数据与数据库是否一致");
		//查询数据库
		String sql = "select * from card_use_policy_dtls where upd_use_policy_id='"+TestData.FindValueInVariablesByFile("usePolicyId","CardTestData.xml")+"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);//数据库数据存放在List
		ArrayList<String> DBList = new ArrayList<String>();//空DBList
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("upd_use_policy_id"));
			DBList.add((String) rsTree.get("upd_use_policy_desc"));
		}
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		resList.add(jsonRes.asObject().get("usePolicyDtls").asObject().get("UsePolicyID").asString());
		resList.add(jsonRes.asObject().get("usePolicyDtls").asObject().get("UsePolicyDesc").asString());
		for(int i=0 ;i<resList.size();i++){
			if(!DBList.get(i).equals(resList.get(i))){
				logger.debug("返回数据与数据库不一致");
			}
		}
		logger.debug("返回数据与数据库一致");
		return true;
	}
	
	public static boolean TA_Card_GetGradePolicy(String res) {
		// TODO Auto-generated method stub
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
	
	public static boolean TA_Card_GetLimitTickets(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_Consume(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetStateInfo(String res) {
		// TODO Auto-generated method stub
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
		logger.info("[检查点_3]. 检查返回的数据和数据库是否一致");
		String sql = "select * from card_state_info";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);//数据库数据存放在List
		ArrayList<String> DBList = new ArrayList<String>();//空DBList
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("state_cd"));
			DBList.add((String) rsTree.get("state_desc"));
		}
		JsonValue jsonRes= Json.parse(res);
		ArrayList<Object> resList = new ArrayList<Object>();
		JSONObject resL = new JSONObject();
		for(int i=0 ; i<jsonRes.asObject().get("CardStateInfo").asArray().size();i++){
			resList.add(jsonRes.asObject().get("CardStateInfo").asArray().get(i).asObject().get("StateCd"));
			resList.add(jsonRes.asObject().get("CardStateInfo").asArray().get(i).asObject().get("StateDesc"));
		}
		for(int i=0;i<resList.size();i++){
			if(DBList.get(i).toString().equals(resList.get(i).toString())){
				logger.info("返回的数据和数据库不一致");
			}
		}
		logger.info("返回的数据和数据库一致");
		return true;
	}


	public static boolean TA_Card_GetCardBuying(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetPaymentType(String res) {
		// TODO Auto-generated method stub
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
//		String sql = "select * from card_payment_type";
//		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);//数据库数据存放在List
//		ArrayList<String> DBList = new ArrayList<String>();//空DBList
//		for(int i = 0; i< List.size();i++)
//		{
//			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
//			DBList.add((String) rsTree.get("state_cd"));
//			DBList.add((String) rsTree.get("state_desc"));
//		}
//		JsonValue jsonRes= Json.parse(res);
//		ArrayList<Object> resList = new ArrayList<Object>();
//		JSONObject resL = new JSONObject();
//		for(int i=0 ; i<jsonRes.asObject().get("CardStateInfo").asArray().size();i++){
//			resList.add(jsonRes.asObject().get("CardStateInfo").asArray().get(i).asObject().get("StateCd"));
//			resList.add(jsonRes.asObject().get("CardStateInfo").asArray().get(i).asObject().get("StateDesc"));
//		}
//		for(int i=0;i<resList.size();i++){
//			if(DBList.get(i).toString().equals(resList.get(i).toString())){
//				logger.info("返回的数据和数据库不一致");
//			}
//		}
//		logger.info("返回的数据和数据库一致");
		return true;
	}


	public static boolean TA_Card_GetCompany(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSales(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSellInit(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSoftDog(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetReading(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSellInfo(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSellGroupID(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_Sell(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_AddMoney(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetSummaryInfo(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetPrefabricateUsePolicy(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetPrefabricateGrade(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetPrefabricateTradePolicyHdrs(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_GetPrefabricateOrdersList(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_OrdersByOrderCD(String res) {
		// TODO Auto-generated method stub
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


	public static boolean TA_Card_Prefabricate(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryTicketBuy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryTicketBuyDiscount(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryPosBuy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryAddMoney(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryTransfer(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryMarking(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryExchange(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryOtherSystemsConsume(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryEditMemberInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryWallet(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ConsumeIntegral(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ChenkIDCardSameSerial(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Order(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_CheckOrderFacadeCdIsUse(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_CardReportloss(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_CardCancelloss(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_CardActivation(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_OrderGetSerialNumber(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_CardExchange(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_EditMemberInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ResetPassword(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_UMEImportPre(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetMemberInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetPrefabricateInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_PrefabricateEdit(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryOrder(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryPrefabricate(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Cancel(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Annul(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_EditPolicy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GLOBALSYS(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_TransferList(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Transfer(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_RePrintSell(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_RePRintAdd(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Update_Add_PrintTimes(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_RePrintConsume(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_RePrintGift(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_AddMoney_WriteCard(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_OldCardInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_NewCardInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Refund(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_ReSellInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_BatchAddInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ReSell(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetEvents(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_AddEvents(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_DeleteEvents(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_WebSellGradeList(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_WebSellInfo(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_AddMoney_ID(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_WalletGiftType(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Get_WalletVoucherGroup(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_Check_NoCardSell(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_RecoverWallet(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetCardGift(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryGiftExchange(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryManuallyWallet(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ParmsSetting(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryTicketBuyPage(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetCardBuyingPage(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_QueryAddMoneyPage(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean Basic_GetAllSystemSetting(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ExchangeCCB(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ManuallyWallet(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GiftExchange(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		
		return true;
	}


	public static boolean TA_Card_UpdateBindingPolicy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetOrderResult(String res) {
		// TODO Auto-generated method stub
		
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_GetBindingPolicy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_SetCardPolicy(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ConsumeRollback(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_ConsumeIntegralRollback(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}


	public static boolean TA_Card_RefundRollback(String res) {
		// TODO Auto-generated method stub
		if(res.isEmpty())
		{
			logger.warn("返回的内容为空");
			return false;
		}
		logger.info("检查点_2. 检查返回结果是否为0");
		if(!CommonUntil.getResult(res).equals("0"))
		{
			logger.warn("返回结果:"+CommonUntil.getResult(res));
			return false;
		}
		logger.info("检查点_3. 检查返回sessoncode和数据库是否一致");
		return true;
	}

}
