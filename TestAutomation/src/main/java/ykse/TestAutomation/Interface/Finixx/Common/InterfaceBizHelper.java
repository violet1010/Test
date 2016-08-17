package ykse.TestAutomation.Interface.Finixx.Common;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Common.HttpSampler;
import ykse.TestAutomation.Interface.Finixx.Common.TestData;
import ykse.TestAutomation.Interface.Finixx.Common.CommonRequestData;
public  class InterfaceBizHelper {
	static Logger logger = new Log("interface_Finixx").logger; 
	static String url = TestData.FindValueInVariables("testurl");

	 public static String Ticket_GetSession(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/session", CommonRequestData.signRequestData(data).toString());
		  return responseStr;		  
	  }
	 public static String Ticket_GetSessionNoExtraInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sessionnomoreextra", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	 }

	public static String Ticket_GetSessionDetails(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sessiondetails", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSessionFilms(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sessionfilm", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetFilmImage(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/filmimage", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSeatCounts(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/seatscount", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetOneDateSeatCounts(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getonedateseatcount", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetFilmCarriers(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/filmcarriers", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetFilmDimensional(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/filmdimensional", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSessionPricePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sessionpricepolicy", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetShowDateFilmInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/showdatefilminfo", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetAllChannelPrice(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sessionallchannelprice", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetHalls(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/halls", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSections(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/sections", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSeatPlan(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/seatplan", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_RepositionSeats(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/repositionseats", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_ReleaseSeats(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/releaseseats", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetAllocateSeats(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getallocateseats", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetAllocateSeatBookingId(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/allocateseatsbookingid", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSeatStatus(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getseatstatus", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSeatCode(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getseatcode", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetSeatRowColId(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getrowcolid", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetChannelSeatPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getchannelseatpolicy", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetChannelSeatDetails(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getchannelseatdetails", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetChannelSeatDetailsByShow(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getchannelseatdetailsbyshow", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetMaxThroughSeatCount(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getMaxThroughSeatCount", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetAllSessionBookingId(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getAllSessionBookingId", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_CreateInfoCode(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/createTicketInfoCode", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_GetPaymentTypes(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/getpaymenttypes", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String Ticket_Refund_BoPos_Order(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost("http://172.33.0.125:29955/" + "api/ticket/refundboposorder", CommonRequestData.signRequestData(data).toString());
	      return responseStr;//192.168.0.252
	}
	
	public static String Ticket_Card_Refund_BoPos(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost("http://172.33.0.125:29955/" + "api/card/cardrefundbopos", CommonRequestData.signRequestData(data).toString());
	      return responseStr;//172.33.0.75
	}
	
	public static String Ticket_Card_Refund_BoPos_RollBack(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost("http://172.33.0.125:29955/" + "api/card/cardrefundboposrollback", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}
	
	public static String Card_GetAllSessionPricePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/ticket/cardallpricepolicy", CommonRequestData.signRequestData(data).toString());
	      return responseStr;
	}

	public static String PosSelectDtls(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Select_DTLs", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosMemberPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Member_Policy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosSpecialPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_SpecialPolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosIntegralExchangePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/PosIntegralExchangePolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosIntegralPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/PosIntegralPolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosMonthsDayLimit(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/PosMonthsDayLimit", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_SpecialAndPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_SpecialAndPolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String PosTicketandgoods(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/PosSelectTicketAndGoods", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_Select_Sale_Report(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Select_Sale_Report", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_Sale_Payment_Group(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Sale_Payment_Group", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_SaleGiftVoucher(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/possalegiftvoucher", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_SpecialAndPolicyAndGoods(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_SpecialAndPolicyAndGoods", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_CheckVoucherExchangeGoods(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/poscheckvoucherexchangegoods", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_GetGoodStock(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/posgetposgoodstock", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}

	public static String Pos_GetMemberCardPolicyAndSP(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/shop/pos_getmembercardpolicyandsp", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	}
	
	 public static String cardcompany(JSONObject data) {	
		 String responseStr =  HttpSampler.sendPost(url + "/api/card/cardcompany", CommonRequestData.signRequestData(data).toString());
		 return responseStr;		  
	  }
	 
	
	//已调通
	public static String posGoodsBigKind(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosGoodsBigKind", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posGoodsListClassPlace(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosGoodsListClassPlace", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posOnegoodsInfo(JSONObject data) {
		 String responseStr =  HttpSampler.sendPost(url + "/api/shop/PosOnegoodsInfo", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//未调通
	public static String posSelectGoodsInfoFuzzy(JSONObject data) {		
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/GetPosSelectGoodsInfo_Fuzzy", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posSelectHotSaleDtls(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_select_HotSale_Dtls", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	//已调通
	public static String posFavourableFormula(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_FFormula", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posFavourableFormulaDetails(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_FFormula_Details", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posFFormulaClass(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_FFormula_Class", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posFFormulaDetailsSelect(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_FFormula_Details_Select", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posFFormulaSelectGoods(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_FFormula_Select_Goods", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posId(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosId", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posSale(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Sale", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posSelectTempInfo(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Select_Temp_Info", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posTemp(JSONObject data) {
		String responseStr =  HttpSampler.sendPost(url + "/api/shop/Pos_Temp", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posSelectTempListUme(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosSelectTemp_List_Ume", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	public static String posSelectTempInfoUme(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosSelectTemp_Info_Ume", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posDeleteTempId(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_Delete_Temp_Id", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//没有返回数据
	public static String getPosAgency(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_GetPosAgency", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posSelectpickup(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosSelectpickup", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//未调通
	public static String posOrderFetchConfirm(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/orderfetchcofirm", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posGetWorkStationStockInfo(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_GetWorkStationStockInfo", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posStockConfirm(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/stockconfirm", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//未调通
	public static String posExamineGoods(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosExamineGoods", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	//已调通
	public static String posRemoveCache(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_RemoveCache", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posSetSelect(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosSet", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posTicketInfo(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/PosSelectTicketInfo", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	//已调通
	public static String posHoldSelectForm(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_Select_Hold_Form", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	//已调通
	public static String posHoldSelectDtls(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_Select_Hold_DTLs", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}

	//已调通
	public static String posSelectForm(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_Select_Form", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	//已调通
	public static String posSelectDtls(JSONObject data) {
		String responseStr = HttpSampler.sendPost(url + "/api/shop/Pos_Select_DTLs", CommonRequestData.signRequestData(data).toString());
		return responseStr;
	}
	
	 public static String Card_GetCardInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetUsePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/usepolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
		
	 public static String Card_GetGradePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/gradepolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetLimitTickets(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardlimit", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_Consume(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardconsume", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_ConsumeRollback(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardconsumerollback", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetStateInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardstateinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetCardBuying(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardbuying", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetPaymentType(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardpaymenttype", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetCompany(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardcompany", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSales(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardsales", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSellInit(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardsellinit", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSoftDog(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getsoftdog", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetReading(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardreading", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSellInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardsellinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSellGroupID(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardsellgroupid", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_Sell(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardsell", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_AddMoney(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardaddmoney", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetSummaryInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getsummaryinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetPrefabricateUsePolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricateusepolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetPrefabricateGrade(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricategrade", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetPrefabricateTradePolicyHdrs(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricatetradepolicyhdrs", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_GetPrefabricateOrdersList(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricateorderlist", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  } 
	 
	 public static String Card_OrdersByOrderCD(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardordersbyordercd", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Prefabricate(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricate", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryTicketBuy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryticketbuy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryTicketBuyDiscount(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryticketbuydiscount", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryPosBuy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryposbuy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryAddMoney(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryaddmoney", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryTransfer(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querytransfer", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryMarking(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querymarking", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryExchange(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryexchange", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryOtherSystemsConsume(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryothersystemsconsume", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryEditMemberInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryeditmemberinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryWallet(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querywallet", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_ConsumeIntegral(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardconsumeintegral", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_ConsumeIntegralRollback(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardconsumeintegralrollback", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_ChenkIDCardSameSerial(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardchenkidcardsameserial", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Order(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardorder", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_CheckOrderFacadeCdIsUse(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/checkorderfacadecdisuse", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_CardReportloss(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/reportloss", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_CardCancelloss(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cancelloss", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_CardActivation(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardactivation", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_OrderGetSerialNumber(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getserialnumber", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_CardExchange(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardexchange", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_EditMemberInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardeditmemberinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_ResetPassword(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardresetpassword", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_UMEImportPre(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardumeimportpre", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetMemberInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getmemberinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetPrefabricateInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardgetpreinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_PrefabricateEdit(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardprefabricateedit", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryOrder(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardqueryorder", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryPrefabricate(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardqueryprefabricate", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Cancel(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardcancel", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Annul(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardannul", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_EditPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardeditpolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GLOBALSYS(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardglobalsys", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_TransferList(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querytransferlist", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Transfer(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardtransfer", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_RePrintSell(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardreprintsell", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_RePRintAdd(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardreprintadd", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Update_Add_PrintTimes(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardupdateaddprinttimes", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_RePrintConsume(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardreprintconsume", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_RePrintGift(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardreprintgift", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_AddMoney_WriteCard(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardaddwritecard", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_OldCardInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getoldcardnfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Get_NewCardInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getnewcardnfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_Refund(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardrefund", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_RefundRollback(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardrefundrollback", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_Get_ReSellInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getresellinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_Get_BatchAddInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getbatchaddinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_ReSell(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardresell", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_GetEvents(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardeventget", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_AddEvents(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardeventadd", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_DeleteEvents(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardeventdelete", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_WebSellGradeList(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardwebsellgradelist", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_WebSellInfo(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardwebsellinfo", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_ExchangeCCB(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardexchangeccb", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_AddMoney_ID(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardaddmoneyid", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_Get_WalletGiftType(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardwalletgifttype", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_Get_WalletVoucherGroup(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardwalletvouchergroup", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_ManuallyWallet(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardmanuallywallet", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_Check_NoCardSell(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardchecknocardsell", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_RecoverWallet(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardrecoverwallet", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_GetCardGift(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardgift", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_GiftExchange(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardgiftexchange", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_QueryGiftExchange(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querycardgiftexchange", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_QueryManuallyWallet(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/querycardmanuallywallet", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_ParmsSetting(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardParmsSetting", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_SetCardPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/CardReceiver", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }	
	 
	 public static String Card_UpdateBindingPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardupdatebindingpolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetOrderResult(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardorderesult", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetBindingPolicy(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/getcardbindingpolicy", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryTicketBuyPage(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryticketbuypage", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_GetCardBuyingPage(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/cardbuyingpage", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 
	 public static String Card_QueryAddMoneyPage(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/card/queryaddmoney", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
	 public static String Basic_GetAllSystemSetting(JSONObject data) {
		  String responseStr =  HttpSampler.sendPost(url + "/api/basic/allsystemsetting", CommonRequestData.signRequestData(data).toString());
		  return responseStr;
	  }
}


