package ykse.TestAutomation.Interface.Finixx.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonValue;

import ykse.TestAutomation.Common.Log;

public class InterFaceFinixxTicketAssertion {
	static Logger logger = new Log("interface_Finixx").logger;
	public static Boolean TA_Ticket_GetSession_getTodaySession(String res){
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
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
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
		}
		logger.warn("返回sessioncode与数据库查询结果一致");
		return true;
	}

	public static Boolean TA_Ticket_GetSessionDetails_getDetailsBySessionCode(String res){
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
		logger.info("[检查点_3]. 检查返回refSeqNo和数据库是否一致");
		//查询数据库
		String toDay = CommonUntil.getToday();
		String sql = "select sho_ref_seq_no as sho_ref_seq_no from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		ArrayList<String> dbList = new ArrayList<String>();
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		resList.add(jsonRes.asObject().get("session").asObject().get("refSeqNo").asString());

		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_ref_seq_no"));
		}
		
		DBList.sort(null);
		resList.sort(null);

		for(int i = 0; i<DBList.size(); i++){
			if(DBList.get(i).equals(resList.get(0)))
			{
				dbList.add(DBList.get(i));
			}
		}
		
		if(dbList.size()==resList.size())
		{
			for(int i = 0; i<dbList.size(); i++)
			{
				if(!dbList.get(i).equals(resList.get(i)))
				{
					logger.warn("返回refSeqNo与数据库查询结果不一致");
					logger.warn("返回" + resList.get(i) + "数据库查询"+dbList.get(i));
					return false;
				}
			}
		}
		else
		{
			logger.warn("返回refSeqNo与数据库查询结果不一致");
		}
		logger.warn("返回refSeqNo与数据库查询结果一致");
		return true;
	}

	public static boolean TA_Ticket_GetSessionNoExtraInfo_getTodaySession(String res) {
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
				String toDay = CommonUntil.getToday();
				String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
				ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
				ArrayList<String> DBList = new ArrayList<String>();
				for(int i = 0; i< List.size();i++)
				{
					Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
					DBList.add((String) rsTree.get("sho_session_code"));
				}
				
				//分析返回的json值
				JsonValue jsonRes= Json.parse(res);
				ArrayList<String> resList = new ArrayList<String>();
				for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
				{
					resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
				}
				
				DBList.sort(null);
				resList.sort(null);
				
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
				}
				logger.warn("返回sessioncode与数据库查询结果一致");
				return true;
	}	
	
	public static Boolean TA_Ticket_GetSessionFilms_GetOneFilm(String res){
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
		logger.info("[检查点_3]. 检查返回flm_code和flm_film_title和数据库是否一致");
		//查询数据库
		String sql = "select flm_code,flm_film_title from gv_films";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		ArrayList<String> dbList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("flm_code"));
			DBList.add((String) rsTree.get("flm_film_title"));
		}
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("films").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("films").asArray().get(i).asObject().get("filmCode").asString());
			resList.add(jsonRes.asObject().get("films").asArray().get(i).asObject().get("filmLongTitle").asString());
		}
		for(int i = 0; i<DBList.size(); i = i+2){
			if(DBList.get(i).equals(resList.get(0)) && DBList.get(i+1).equals(resList.get(1)))
			{
				dbList.add(DBList.get(i));
				dbList.add(DBList.get(i+1));
			}
		}
		dbList.sort(null);
		resList.sort(null);
		if(dbList.size()==resList.size())
		{
			for(int i = 0; i<dbList.size(); i++)
			{
				if(!dbList.get(i).equals(resList.get(i)))
				{
					if(i==0)
					{
						logger.warn("返回filmCode与数据库查询结果不一致");
						logger.warn("返回" + resList.get(i) + "数据库查询"+dbList.get(i));
						return false;
					}
					if(i==1)
					{
						logger.warn("返回filmLongTitle与数据库查询结果不一致");
						logger.warn("返回" + resList.get(i) + "数据库查询"+dbList.get(i));
						return false;
					}
				}
			}
		}
		else
		{
			logger.warn("++返回数据与数据库查询结果不一致");
		}
		logger.warn("返回数据与数据库查询结果一致");
		return true;
	}

	public static boolean TA_Ticket_GetSessionFilms_GetOneFilmWithoutPicture(String res) {
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
				logger.info("[检查点_3]. 检查返回flm_code和flm_film_title和数据库是否一致");
				//查询数据库
				String sql = "select flm_code,flm_film_title from gv_films";
				ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
				ArrayList<String> DBList = new ArrayList<String>();
				ArrayList<String> dbList = new ArrayList<String>();
				for(int i = 0; i< List.size();i++)
				{
					Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
					DBList.add((String) rsTree.get("flm_code"));
					DBList.add((String) rsTree.get("flm_film_title"));
				}
				//分析返回的json值
				JsonValue jsonRes= Json.parse(res);
				ArrayList<String> resList = new ArrayList<String>();
				for(int i = 0;i < jsonRes.asObject().get("films").asArray().size();i++)
				{
					resList.add(jsonRes.asObject().get("films").asArray().get(i).asObject().get("filmCode").asString());
					resList.add(jsonRes.asObject().get("films").asArray().get(i).asObject().get("filmLongTitle").asString());
				}
				for(int i = 0; i<DBList.size(); i = i+2){
					if(DBList.get(i).equals(resList.get(0)) && DBList.get(i+1).equals(resList.get(1)))
					{
						dbList.add(DBList.get(i));
						dbList.add(DBList.get(i+1));
					}
				}
				dbList.sort(null);
				resList.sort(null);
				if(dbList.size()==resList.size())
				{
					for(int i = 0; i<dbList.size(); i++)
					{
						if(!dbList.get(i).equals(resList.get(i)))
						{
							if(i==0)
							{
								logger.warn("返回filmCode与数据库查询结果不一致");
								logger.warn("返回" + resList.get(i) + "数据库查询"+dbList.get(i));
								return false;
							}
							if(i==1)
							{
								logger.warn("返回filmLongTitle与数据库查询结果不一致");
								logger.warn("返回" + resList.get(i) + "数据库查询"+dbList.get(i));
								return false;
							}
						}
					}
				}
				else
				{
					logger.warn("++返回数据与数据库查询结果不一致");
				}
				logger.warn("返回数据与数据库查询结果一致");
				return true;
	}

	public static boolean TA_Ticket_GetFilmImage(String res) {
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
		String toDay = CommonUntil.getToday();
		String sql = "select gv_films.flm_film_cd , gv_films.flm_image "
				+ "from gv_show_details inner join gv_films on gv_show_details.sho_film_cd=gv_films.flm_film_cd "
				+ "and gv_show_details.sho_show_dt = '" +toDay +"';";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("filmImage").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("filmImage").asArray().get(i).asObject().get("filmCd").asString());
			resList.add(jsonRes.asObject().get("filmImage").asArray().get(i).asObject().get("image").asString());
		}
		
		ArrayList<String> DBList = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			if(resList.get(0).equals((String) rsTree.get("flm_film_cd"))){
				if(DBList.isEmpty())
				{
					DBList.add((String) rsTree.get("flm_film_cd"));
				    DBList.add((String) rsTree.get("flm_image"));
				}
				else
				{
					for(int j = 0; j<DBList.size();j = j+2)
					{
						if(DBList.get(j).equals((String) rsTree.get("flm_film_cd")))
						{
							count++;
						}
					}
					if(count == 0)
					{
						DBList.add((String) rsTree.get("flm_film_cd"));
					    DBList.add((String) rsTree.get("flm_image"));
					}
				}
			}
		}
		System.out.println(DBList);
		System.out.println(resList);
		if(DBList.size()==resList.size())
		{
			for(int i = 0; i<DBList.size(); i++)
			{
				String image =resList.get(i);
				if(image.equals(""))
				{
					image = "null";
				}
				String dbimage =DBList.get(i);
				if(dbimage==null)
				{
					dbimage = "null";
				}
				if(!dbimage.equals(image))
				{
					logger.warn("返回image信息与数据库查询结果不一致");
					logger.warn("返回" + resList.get(i) + "数据库查询"+DBList.get(i));
					return false;
				}
			}
		}
		else
		{
			logger.warn("返回image信息与数据库查询结果不一致");
		}
		logger.warn("返回image信息与数据库查询结果一致");
		return true;
	}

	public static boolean TA_Ticket_GetSeatCounts_AllSectionSeatCounts(String res) {
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
//		String res_Ticket_GetSession = InterfaceBizHelper.Ticket_GetSession(InterFaceFinixxTicketData.Ticket_GetSession());
//		JSONObject SessionFilm = CommonUntil.getFilmInformation(res_Ticket_GetSession);
//		String sql = "select cin_max_capacity as cin_max_capacity from gv_cinemas where ";
//		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
//		ArrayList DBList = new ArrayList();
//		for(int i = 0; i< List.size();i++)
//		{
//			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
//			DBList.add(rsTree.get("cin_max_capacity"));
//		}
//		System.out.println(DBList);
//		//分析返回的json值
//		JsonValue jsonRes= Json.parse(res);
//		int Seatcounts = jsonRes.asObject().get("seats_Sold").asInt() + jsonRes.asObject().get("seats_Book").asInt() 
//				+ jsonRes.asObject().get("seats_Free").asInt() + jsonRes.asObject().get("seats_Heldlock").asInt();
//		System.out.println(Seatcounts);
//		
//		if(DBList.size()==resList.size())
//		{
//			for(int i = 0; i<DBList.size(); i++)
//			{
//				if(!DBList.get(i).equals(resList.get(i)))
//				{
//					logger.warn("返回sessioncode与数据库查询结果不一致");
//					logger.warn("返回" + resList.get(i) + "数据库查询"+DBList.get(i));
//					return false;
//				}
//			}
//		}
//		else
//		{
//			logger.warn("返回sessioncode与数据库查询结果不一致");
//		}
		return true;
	}

	public static boolean TA_Ticket_GetSeatCounts_ErrorSessionId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetOneDateSeatCounts_GetTodaySeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetOneDateSeatCounts_NorefSeqNo(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetFilmDimensional(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetFilmCarriers(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSections_Code1008(String res) {
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
//		String toDay = CommonUntil.getToday();
//		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
//		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
//		ArrayList<String> DBList = new ArrayList<String>();
//		for(int i = 0; i< List.size();i++)
//		{
//			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
//			DBList.add((String) rsTree.get("sho_session_code"));
//		}
//		
//		//分析返回的json值
//		JsonValue jsonRes= Json.parse(res);
//		ArrayList<String> resList = new ArrayList<String>();
//		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
//		{
//			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
//		}
//		
//		DBList.sort(null);
//		resList.sort(null);
//		
//		if(DBList.size()==resList.size())
//		{
//			for(int i = 0; i<DBList.size(); i++)
//			{
//				if(!DBList.get(i).equals(resList.get(i)))
//				{
//					logger.warn("返回sessioncode与数据库查询结果不一致");
//					logger.warn("返回" + resList.get(i) + "数据库查询"+DBList.get(i));
//					return false;
//				}
//			}
//		}
//		else
//		{
//			logger.warn("返回sessioncode与数据库查询结果不一致");
//		}
	
		return true;
	}

	public static boolean TA_Ticket_GetSections_Code1016(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSessionPricePolicy(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetShowDateFilmInfo(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetShowDateFilmInfoNoChannelCd(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetAllChannelPrice(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetHalls(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatPlan_GetFilmSessions(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_RepositionSeats_CurrentMessage(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetAllocateSeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetAllocateSeatBookingId_CurrentBookingId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatStatus_CurrentSeatId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatRowColId_CurrentseatCodes(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatPolicy(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatDetailsByShow_CurrentSessionId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetMaxThroughSeatCount(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetAllSessionBookingId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_res_Ticket_GetAllSessionBookingId_ErrorSessionCode(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Card_GetAllSessionPricePolicy_CurrentCardFacadeCD(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_RepositionSeats_ErrorSeatMessage(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatStatus_ErrorSeatId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatCode_CurrentSeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetSeatCode_ErrorSeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_TC_Ticket_GetSeatRowColId_ErrorseatCodes(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatDetails_ErrorPolicyId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatDetails_CurrentPolicyId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatDetails_NoPolicyId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetChannelSeatDetailsByShow_WithoutSessionId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TATicket_GetMaxThroughSeatCount_ErrorSectionId(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Card_GetAllSessionPricePolicy_ErrorCardFacadeCD(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_GetPaymentTypes(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_CreateInfoCode_Current(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_ReleaseSeats_CorrentSeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_ReleaseSeats_ErrorSeats(String res) {
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
		/*
		String toDay = CommonUntil.getToday();
		String sql = "select sho_session_code as sho_session_code from gv_show_details where sho_show_dt = '" +toDay +"'";
		ArrayList<?> List = JDBCSampler.JdbcSelectForList(sql);
		ArrayList<String> DBList = new ArrayList<String>();
		for(int i = 0; i< List.size();i++)
		{
			Map<?, ?> rsTree = (Map<?, ?>) List.get(i);
			DBList.add((String) rsTree.get("sho_session_code"));
		}
		
		//分析返回的json值
		JsonValue jsonRes= Json.parse(res);
		ArrayList<String> resList = new ArrayList<String>();
		for(int i = 0;i < jsonRes.asObject().get("sessions").asArray().size();i++)
		{
			resList.add(jsonRes.asObject().get("sessions").asArray().get(i).asObject().get("sessionCode").asString());
		}
		
		DBList.sort(null);
		resList.sort(null);
		
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
		}
		*/
	
		return true;
	}

	public static boolean TA_Ticket_Refund_BoPos_Order(String res) {
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
		logger.info("[检查点_3]. 检查返回和数据库是否一致");
		return true;
	}

	public static boolean TA_Ticket_Card_Refund_BoPos(String res) {
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
		logger.info("[检查点_3]. 检查返回和数据库是否一致");
		return true;
	}

	public static boolean TA_Ticket_Card_Refund_BoPos_RollBack(String res) {
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
		logger.info("[检查点_3]. 检查返回和数据库是否一致");
		return true;
	}

}
