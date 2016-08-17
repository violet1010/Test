package ykse.TestAutomation.Interface.Finixx.Common;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

import ykse.TestAutomation.Common.Log;

public class InterFaceFinixxGoodsAssertion {
   static Logger logger = new Log("interface_Finixx").logger;
	public static boolean TA_POS_posGoodsBigKind(String res) {
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
	
	public static boolean TA_PosGoodsListClassPlace(String res) {
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
	
	public static boolean TA_PosOnegoodsInfo(String res) {
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
	
	public static boolean TA_GetPosSelectGoodsInfo_Fuzzy(String res) {
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
	
	public static boolean TA_Pos_select_HotSale_Dtls(String res) {
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
	
	public static boolean TA_PosFavourable_Formula(String res) {
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
	
	public static boolean TA_PosFavourable_Formula_Details(String res) {
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
	
	public static boolean TA_Pos_FFormula_Class(String res) {
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
	
	public static boolean TA_Pos_FFormula_Details_Select(String res) {
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
	
	public static boolean TA_Pos_FFormula_Select_Goods(String res) {
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
	
	public static boolean TA_PosId(String res) {
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
	
	public static boolean TA_PosSale(String res) {
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
	
	public static boolean TA_Pos_Select_Temp_Info(String res) {
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
	
	public static boolean TA_PosTemp(String res) {
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
	
	public static boolean TA_PosSelectTemp_List_Ume(String res) {
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
	public static boolean TA_PosSelectTemp_Info_Ume(String res) {
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
	public static boolean TA_Pos_Delete_Temp_Id(String res) {
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
	
	public static boolean TA_Pos_GetPosAgency(String res) {
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
	
	public static boolean TA_Pos_Selectpickup(String res) {
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

	public static boolean TA_Pos_Order_Fetch_Confirm(String res) {
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
	
	public static boolean TA_Pos_GetWorkStationStockInfo(String res) {
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
	
	public static boolean TA_Pos_Stock_Confirm(String res) {
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
	
	public static boolean TA_Pos_Examine_Goods(String res) {
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
	
	public static boolean TA_Pos_RemoveCache(String res) {
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
	
	public static boolean TA_PosSetSelect(String res) {
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
	
	public static boolean TA_PosTicketInfo(String res) {
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
	
	public static boolean TA_PosHoldSelectForm(String res) {
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
	
	public static boolean TA_PosHoldSelectDtls(String res) {
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
	
}
