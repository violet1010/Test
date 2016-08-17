package ykse.TestAutomation.Interface.Finixx.Common;

import java.util.ArrayList;
import java.util.UUID;

import org.json.JSONObject;


public class InterFaceFinixxGoodsData {
	
	public static JSONObject POS_posGoodsBigKind()
	{
		CommonRequestData crd = new CommonRequestData("4001", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id","BOOM");
		defaultData.put("returnpic_yn", "false");
		defaultData.put("channelCd", "BO");
		return defaultData;
	}
	
	public static JSONObject POS_PosGoodsListClassPlace(JSONObject class_id )
	{
		CommonRequestData crd = new CommonRequestData("4002", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_source","BO");
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("class_id", class_id.get("class_id"));
		defaultData.put("returnpic_yn", "false");
		return defaultData;
	}
	
	public static JSONObject POS_PosOnegoodsInfo()
	{
		CommonRequestData crd = new CommonRequestData("4002", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("id_type", "GoodsId");
		defaultData.put("goods_id", "8000000062");
		defaultData.put("channelCd", "BO");
		return defaultData;
	}
	
	public static JSONObject GetPosSelectGoodsInfo_Fuzzy()
	{
		CommonRequestData crd = new CommonRequestData("4025", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("WorkStationId", "BOOM");
		defaultData.put("PosGoodsId", "8000000011");
		defaultData.put("PosGoodsName", "");
		defaultData.put("PosGoodsLongId", "");
		defaultData.put("PosGoodsShortId", "");
		defaultData.put("channelCd", "WEB");	
		return defaultData;
	}

	public static JSONObject Pos_select_HotSale_Dtls()
	{
		CommonRequestData crd = new CommonRequestData("4023", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("channelCd", "WEB");	
		return defaultData;
	}
	
	public static JSONObject PosFavourable_Formula()
	{
		CommonRequestData crd = new CommonRequestData("4005", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("channelCd", "WEB");	
		return defaultData;
	}

	public static JSONObject PosFavourable_Formula_Details()
	{
		CommonRequestData crd = new CommonRequestData("4006", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pff_formula_id", "8000000036");
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("channelCd", "WEB");	
		return defaultData;
	}
	
	public static JSONObject Pos_FFormula_Class()
	{
		CommonRequestData crd = new CommonRequestData("4020", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("type_id", "01");	
		return defaultData;
	}
	
	public static JSONObject Pos_FFormula_Details_Select()
	{
		CommonRequestData crd = new CommonRequestData("4021", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "BOOM");
		defaultData.put("pff_formula_id", "8160119152407");	
		return defaultData;
	}
	
	public static JSONObject Pos_FFormula_Select_Goods()
	{
		CommonRequestData crd = new CommonRequestData("4022", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();	
		ArrayList<String> list = new ArrayList<String>();
		list.add("8160119152407");
		defaultData.put("goods_id_list",list);
		defaultData.put("workerstation_id", "BOOM");
		return defaultData;
	}
	
	public static JSONObject PosId()
	{
		CommonRequestData crd = new CommonRequestData("4007", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();	
		return defaultData;
	}
	
	public static JSONObject PosSale()
	{
		CommonRequestData crd = new CommonRequestData("4008", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();	
		
		defaultData.put("pos_sale_op", "Hold");
		defaultData.put("pos_source", "");
		defaultData.put("pos_sale_id", "59120160503033081");
		defaultData.put("pos_index_id", "");
		defaultData.put("pos_Amount", "8");
		defaultData.put("pos_sale_user", "122");
		defaultData.put("pos_workstation", "POS2");
		defaultData.put("pos_opend_date", "");
		defaultData.put("pos_class_seq", "");
		defaultData.put("pos_hand_discount", "");
		defaultData.put("pos_pay_fetch", "");
		defaultData.put("pos_temp_id", "");
		defaultData.put("pos_sys_sale", "");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject  PosSaleGoodsNod = new JSONObject();
		PosSaleGoodsNod.put("pos_goods_detail_bm","8160120100053");
		PosSaleGoodsNod.put("pos_goods_detail_sl","10");
		PosSaleGoodsNod.put("pos_goods_detail_jg","5");
		PosSaleGoodsNod.put("pos_goods_detail_jf","0");
		PosSaleGoodsNod.put("pos_goods_detail_zkl","0");
		PosSaleGoodsNod.put("pos_goods_detail_zke","0");
		PosSaleGoodsNod.put("pos_goods_detail_zkj","");
		PosSaleGoodsNod.put("pos_goods_detail_qh","");
		PosSaleGoodsNod.put("pos_goods_detail_jljf","");
		PosSaleGoodsNod.put("pos_goods_detail_yhbm","");
		PosSaleGoodsNod.put("pos_goods_detail_yhxl","");
		PosSaleGoodsNod.put("pos_goods_detail_plbm","");
		list.add(PosSaleGoodsNod);
		defaultData.put("pos_sale_goods_nods",list);
		ArrayList<JSONObject> PosSalePayNodslist = new ArrayList<JSONObject>();
		JSONObject  PosSalePayNod = new JSONObject();
		PosSalePayNod.put("pos_goods_pay_fklx","");
		PosSalePayNod.put("pos_goods_pay_je","");
		PosSalePayNod.put("pos_goods_pay_bm","");
		PosSalePayNod.put("pos_goods_pay_dsb","");
		PosSalePayNod.put("pos_goods_pay_hnm","");
		PosSalePayNod.put("pos_special_id","");
		PosSalePayNod.put("pos_card_grade_id","");
		PosSalePayNod.put("pos_goods_pay_qsl","");
		PosSalePayNod.put("pos_goods_pay_sjje","");
		PosSalePayNod.put("pos_goods_pay_hyxl","");
		PosSalePayNod.put("pos_goods_pay_cxid","");
		PosSalePayNod.put("pos_goods_pay_cxms","");
		PosSalePayNod.put("pos_goods_pay_jfm","");
		PosSalePayNod.put("pos_goods_pay_ywy","");
		PosSalePayNod.put("pos_goods_pay_change","");
		PosSalePayNod.put("pos_electronic_card","");
		PosSalePayNod.put("pos_electronic_seq","");
		PosSalePayNod.put("pos_other_party_id","");
		PosSalePayNodslist.add(PosSalePayNod);
		defaultData.put("PosSalePayNods",PosSalePayNodslist);
		
		ArrayList<JSONObject> PosSalePermissionNodslist = new ArrayList<JSONObject>();
		JSONObject  PosSalePermissionNod = new JSONObject();
		PosSalePermissionNod.put("pos_per_qxm","");
		PosSalePermissionNod.put("pos_per_yhm","");
		PosSalePermissionNodslist.add(PosSalePermissionNod);
		defaultData.put("PosSalePermissionNods",PosSalePermissionNodslist);
		
		ArrayList<JSONObject> PosSaleStockDetailNodslist = new ArrayList<JSONObject>();
		JSONObject  PosSaleStockDetailNod = new JSONObject();
		PosSaleStockDetailNod.put("pos_goods_pid","");
		PosSaleStockDetailNod.put("pos_goods_gid","");
		PosSaleStockDetailNod.put("pos_goods_gp","");
		PosSaleStockDetailNod.put("pos_goods_ps","");
		PosSaleStockDetailNod.put("pos_goods_mc","");
		PosSaleStockDetailNodslist.add(PosSaleStockDetailNod);
		defaultData.put("PosSaleStockDetailNods",PosSaleStockDetailNodslist);
				
		defaultData.put("pos_dll_ver", "");
		int i=0;
		defaultData.put("SaleSpeed",i);
		
		ArrayList<JSONObject> pos_order_remarklist = new ArrayList<JSONObject>();
		JSONObject PosOrderRemarkNod = new JSONObject();
		PosOrderRemarkNod.put("saleform_id","");
		PosOrderRemarkNod.put("saleform_type","");
		PosOrderRemarkNod.put("member_card_id","");
		PosOrderRemarkNod.put("credit_card_id","");
		PosOrderRemarkNod.put("remarks","");
		pos_order_remarklist.add(PosOrderRemarkNod);		
		defaultData.put("PosSaleStockDetailNods",pos_order_remarklist);
		
		
		defaultData.put("Pos_Pickup_Status", "None");
		defaultData.put("Pos_Pickup_Status_Time", "None");
		defaultData.put("PafProjectName", "None");
		
		return defaultData;
	}
	
	public static JSONObject Pos_Select_Temp_Info()
	{
		CommonRequestData crd = new CommonRequestData("4028", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "A1-PC");
		defaultData.put("pos_select_id", "592016050400022");	
		return defaultData;
	}
	

	public static JSONObject PosTemp()
	{
		CommonRequestData crd = new CommonRequestData("4031", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_user", "LGH");
		defaultData.put("pos_workstation", "A1-PC");
		defaultData.put("pos_opend_date", "2015-03-17");	
		defaultData.put("pos_class_seq", "1");	
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject  PosSaleGoodsNod = new JSONObject();
		PosSaleGoodsNod.put("pos_goods_detail_bm","8140427101029");
		PosSaleGoodsNod.put("pos_goods_detail_sl","1");
		PosSaleGoodsNod.put("pos_goods_detail_jg","16.00");
		PosSaleGoodsNod.put("pos_goods_detail_jf","0");
		PosSaleGoodsNod.put("pos_goods_detail_zkl","");
		PosSaleGoodsNod.put("pos_goods_detail_zke","");
		PosSaleGoodsNod.put("pos_goods_detail_qh","");
		PosSaleGoodsNod.put("pos_goods_detail_jljf","0");
		PosSaleGoodsNod.put("pos_goods_detail_yhbm","");
		PosSaleGoodsNod.put("pos_goods_detail_yhxl","0");
		PosSaleGoodsNod.put("pos_goods_detail_plbm","");
		list.add(PosSaleGoodsNod);
		defaultData.put("pos_sale_goods_nods",list);
		
		ArrayList<JSONObject> pos_sale_stock_detail_nodslist = new ArrayList<JSONObject>();
		JSONObject   PosSaleStockDetailNod = new JSONObject();
		PosSaleStockDetailNod.put("pos_goods_pid","");
		PosSaleStockDetailNod.put("pos_goods_gid","");
		PosSaleStockDetailNod.put("pos_goods_gp","");
		PosSaleStockDetailNod.put("pos_goods_ps","");
		PosSaleStockDetailNod.put("pos_goods_sl","");
		PosSaleStockDetailNod.put("pos_goods_mc","");
		pos_sale_stock_detail_nodslist.add(PosSaleStockDetailNod);
		defaultData.put("PosSaleStockDetailNods",pos_sale_stock_detail_nodslist);
		
		defaultData.put("pos_dll_ver", "");
		int i=1;
		defaultData.put("SaleSpeed",i);
		
		ArrayList<JSONObject> pos_order_remarklist = new ArrayList<JSONObject>();
		JSONObject PosOrderRemarkNod = new JSONObject();
		PosOrderRemarkNod.put("saleform_id","");
		PosOrderRemarkNod.put("saleform_type","");
		PosOrderRemarkNod.put("member_card_id","");
		PosOrderRemarkNod.put("credit_card_id","");
		PosOrderRemarkNod.put("remarks","");
		pos_order_remarklist.add(PosOrderRemarkNod);		
		defaultData.put("PosSaleStockDetailNods",pos_order_remarklist);
		
		
		return defaultData;
	}
	
	public static JSONObject PosSelectTemp_List_Ume()
	{
		CommonRequestData crd = new CommonRequestData("4030", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_opend_date", "2015-03-17");
		defaultData.put("pos_sale_user", "LGH");
		defaultData.put("pos_workstation", "A1-PC");
		return defaultData;
	}
	
	public static JSONObject PosSelectTemp_Info_Ume()
	{
		CommonRequestData crd = new CommonRequestData("4029", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_workstation", "A1-PC");
		defaultData.put("pos_select_id", "592016050400022");
		return defaultData;
	}
	
	public static JSONObject Pos_Delete_Temp_Id()
	{
		CommonRequestData crd = new CommonRequestData("4032", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_id", "592016050400025");
		return defaultData;
	}
	
	public static JSONObject Pos_GetPosAgency()
	{
		CommonRequestData crd = new CommonRequestData("4027", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		
		return defaultData;
	}
	
	public static JSONObject Pos_Selectpickup()
	{
		CommonRequestData crd = new CommonRequestData("4034", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_id", "562014040735483");
		return defaultData;
	}
	
	public static JSONObject Pos_Order_Fetch_Confirm()
	{
		CommonRequestData crd = new CommonRequestData("4035", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();	
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject OrderInfo = new JSONObject();
		OrderInfo.put("OrderId","59120160429033234");
		list.add(OrderInfo);		
		defaultData.put("orderlist",list);
		defaultData.put("userid", "");
		return defaultData;
	}
	
	public static JSONObject Pos_GetWorkStationStockInfo()
	{
		CommonRequestData crd = new CommonRequestData("4033", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("workerstation_id", "WEBSITE");
		defaultData.put("pos_opend_date", "2016-02-03");
		defaultData.put("pos_sale_user", "");
		
		return defaultData;
	}
	
	public static JSONObject Pos_Stock_Confirm_putworkStationId()
	{
		CommonRequestData crd = new CommonRequestData("4036", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userid", "");
		defaultData.put("workStationId", "WEBSITE");	
		return defaultData;
	}
	
	public static JSONObject Pos_Stock_Confirm_putuserid()
	{
		CommonRequestData crd = new CommonRequestData("4036", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("userid", "WEBSITE");
		defaultData.put("workStationId", "");	
		return defaultData;
	}
	
	
	public static JSONObject Pos_Examine_Goods()
	{
		CommonRequestData crd = new CommonRequestData("4037", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_user","LGH");
		defaultData.put("pos_workstation","A1-PC");	
		defaultData.put("pos_opend_date", "");
		defaultData.put("pos_class_seq", "");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject  PosGoodsNod = new JSONObject();
		PosGoodsNod.put("pos_goods_detail_bm","");
		PosGoodsNod.put("pos_goods_detail_sl","");
		PosGoodsNod.put("pos_goods_detail_jg","");
		list.add(PosGoodsNod);
		defaultData.put("pos_sale_goods_nods",list);
		
		ArrayList<JSONObject> pos_check_goods_nodslist = new ArrayList<JSONObject>();
		JSONObject  PosCheckGoodsNod = new JSONObject();
		PosCheckGoodsNod.put("SscdGoodId","");
		PosCheckGoodsNod.put("SscdCountDb","");
		PosCheckGoodsNod.put("SscdCheckAmountDb","");
		PosCheckGoodsNod.put("SscdCountChk","");
		PosCheckGoodsNod.put("SscdAmountChk","");		
		pos_check_goods_nodslist.add(PosCheckGoodsNod);
		defaultData.put("pos_sale_goods_nods",pos_check_goods_nodslist);
		defaultData.put("pos_sale_Amount", "");	
		defaultData.put("pos_return_amount", "");
		defaultData.put("pos_dll_ver", "");				
		return defaultData;
	}
	
	
	public static JSONObject Pos_RemoveCache()
	{
		CommonRequestData crd = new CommonRequestData("4013", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("RemoveName", "Goods");	
		return defaultData;
	}
	
	public static JSONObject PosSetSelect()
	{
		CommonRequestData crd = new CommonRequestData("4014", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject PosTicketInfo()
	{
		CommonRequestData crd = new CommonRequestData("4010", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		return defaultData;
	}
	
	public static JSONObject PosHoldSelectForm()
	{
		CommonRequestData crd = new CommonRequestData("4011", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_op", "Hold");	
		defaultData.put("Pos_Workerstation_ID", "BOOM");	
		defaultData.put("Pos_Select_type", "Id");	
		defaultData.put("Pos_Source", "Padpos");
		defaultData.put("pos_select_id", "59120160120033082");
		defaultData.put("pos_select_days", "");
		defaultData.put("pos_hold_fetch", "Check");
		
		return defaultData;
	}
	
	public static JSONObject PosHoldSelectDtls()
	{
		CommonRequestData crd = new CommonRequestData("4012", "1.0.0.0");
		JSONObject defaultData = crd.getRequestData();
		defaultData.put("pos_sale_op", "Hold");	
		defaultData.put("pos_select_id", "59120160120033082");
		
		return defaultData;
	}
	
	
}
