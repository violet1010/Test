package ykse.TestAutomation.Interface.Finixx.Test;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ykse.TestAutomation.Common.Log;
import ykse.TestAutomation.Interface.Finixx.Common.InterfaceBizHelper;
import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxGoodsAssertion;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxGoodsData;
import ykse.TestAutomation.Interface.Finixx.Common.CommonUntil;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxTicketAssertion;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxTicketData;


public class InterFaceFinixxGoodsTest {
	
	Logger logger = new Log("interface_Finixx").logger;
	
	@BeforeClass
	public static void setUp() throws Exception {

	}

	@AfterClass
	public static void tearDown() throws Exception {
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeCase() throws Exception {
		
		logger.warn("****开始执行用例****");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterCase() throws Exception {
		logger.warn("****用例执行结束****");
		
	}
	
//	public JSONObject posGoods(){
//		
//		JSONObject data = new JSONObject();
//		data.put("code", "4001");
//		data.put("version", "1.0.0.1");
//		data.put("serialNumber","635954467784333968");
//		data.put("userName","BO");
//		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
//		data.put("locationcd","681");
//		return data;
//		
//	}
	
//	@Test
//	public void TC_posGoodsBigKind() throws InterruptedException {
//		
//		
//		logger.info("[步骤_1]. 获取分类信息（Pos_Goods_BigKind）");
//		
//		JSONObject data = posGoods();
//		data.put("workerstation_id", TestData.FindValueInVariables("workerstationId"));
//		System.out.println(TestData.FindValueInVariables("workerstationId"));
//		String res = InterfaceBizHelper.posGoodsBigKind(data);
//		
//		logger.info("[检查点_1]. 检查返回内容是否包含4001");
//		boolean result = false;
//		if(res.contains("4001")){
//			result = true;
//		}
//		Assert.assertEquals(result,true);
//	
//	
//		
//		System.out.println(data);
//	}
	
	@Test
	public void TC_PosSelectDtls_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1]. 查询订单明细内容（PosSelectDtls）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4016");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		
		data.put("pos_sale_op","Hold");
//		JSONObject PosSelectType = new JSONObject();
//		PosSelectType.put("Sale","");
//		PosSelectType.put("Return","");
//		PosSelectType.put("Hold","");
//		PosSelectType.put("Gain","");
//		PosSelectType.put("Temp","");
//		PosSelectType.put("SelectAll","");
		data.put("pos_select_id","681120160412231785");
		
		
		String res = InterfaceBizHelper.PosSelectDtls(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosMemberPolicy_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1]. 获取会员折扣（PosMemberPolicy）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4009");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("Member_Grade_Id","2823");
		
		String res = InterfaceBizHelper.PosMemberPolicy(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosSpecialPolicy_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].获取特殊优惠政策（PosSpecialPolicy）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4017");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("workerstation_id","SP001");
		data.put("member_card_grade_id","2823");
		
		String res = InterfaceBizHelper.PosSpecialPolicy(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosIntegralExchangePolicy_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].获取卖品积分兑换政策（PosIntegralExchangePolicy）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4019");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		ArrayList<String> list = new ArrayList<String>();
		list.add("8000000213");
		data.put("goods_id_list",list);
		
		String res = InterfaceBizHelper.PosIntegralExchangePolicy(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosIntegralPolicy_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].查询卖品积分卡政策（PosIntegralPolicy）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4038");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("Member_Grade_Id","2823");
		
		String res = InterfaceBizHelper.PosIntegralPolicy(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosMonthsDayLimit_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].查会员卡日月限额（PosMonthsDayLimit）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4039");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("Member_Grade_Id","2823");//等级编码
		data.put("Member_Facade_Cd","13161616193");//卡号
		
		String res = InterfaceBizHelper.PosMonthsDayLimit(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_SpecialAndPolicy_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].卖品会员等级政策 与 特殊优惠政策（Pos_SpecialAndPolicy）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4040");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("workerstation_id","WIN-ATP4C0OQRFN");
		data.put("member_card_grade_id","2823");
		
		String res = InterfaceBizHelper.Pos_SpecialAndPolicy(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_PosTicketandgoods_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].获取票类绑定（PosTicketandgoods）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4018");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("pos_workstation","WIN-ATP4C0OQRFN");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject PosTicketandgoodsNod = new JSONObject();
		PosTicketandgoodsNod.put("PtgTicketType","114订座");
		PosTicketandgoodsNod.put("TicketCount","2");
		list.add(PosTicketandgoodsNod);
		data.put("PosTicketandgoodsNods", list);
		
		String res = InterfaceBizHelper.PosTicketandgoods(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_Select_Sale_Report_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].销售汇总报表（Pos_Select_Sale_Report）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4024");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("UserId","TAOBAO");
		data.put("OpenDate","2016-04-01");
		data.put("ClassSeqNo", "2");
		
		String res = InterfaceBizHelper.Pos_Select_Sale_Report(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_Sale_Payment_Group_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].查询轮班按付款方式汇总列表（Pos_Sale_Payment_Group）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4026");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("UserId","TAOBAO");
		data.put("OpenDate", "2016-04-01");
		data.put("ClassSeqNo", "1");
		
		String res = InterfaceBizHelper.Pos_Sale_Payment_Group(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_SaleGiftVoucher_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].卖品消费赠券-获取券（Pos_SaleGiftVoucher）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4041");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("locCd","681");
		data.put("orderId", "681120160414231881");
		data.put("userId", "YKSE");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject GiftVoucherPayment = new JSONObject();
		GiftVoucherPayment.put("amount","10");
		GiftVoucherPayment.put("paymentTypeCd","现金");
		list.add(GiftVoucherPayment);
		data.put("payments", list);
		
		String res = InterfaceBizHelper.Pos_SaleGiftVoucher(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_SpecialAndPolicyAndGoods_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].卖品查询会员等级与特殊优惠政策及商品（Pos_SpecialAndPolicyAndGoods）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4044");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("workerstation_id","WIN-ATP4C0OQRFN");
		data.put("member_card_grade_id", "2823");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject good = new JSONObject();
		good.put("goodId","8120314018");
		good.put("price","1");
		list.add(good);
		data.put("goodList", list);
		
		String res = InterfaceBizHelper.Pos_SpecialAndPolicyAndGoods(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_CheckVoucherExchangeGoods_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].判断商品是否允许使用兑换券（Pos_CheckVoucherExchangeGoods）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4045");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("groupId","2016030531");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject good = new JSONObject();
		good.put("goodId","8120314018");
		list.add(good);
		data.put("goodList", list);
		
		String res = InterfaceBizHelper.Pos_CheckVoucherExchangeGoods(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Pos_GetGoodStock_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].获取商品库存（Pos_GetGoodStock）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4046");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("workStationId","SP001");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject good = new JSONObject();
		good.put("goodId","8120314018");
		list.add(good);
		data.put("goodList", list);
		
		String res = InterfaceBizHelper.Pos_GetGoodStock(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	
	@Test
	public void TC_Pos_GetMemberCardPolicyAndSP_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1].卖品查询会员等级与特殊优惠政策及商品（Pos_GetMemberCardPolicyAndSP）");
		JSONObject data = new JSONObject();
		//固定
		data.put("code", "4047");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		//文档
		data.put("workerstationId","WIN-ATP4C0OQRFN");
		data.put("memberCardGradeId","2823");
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject good = new JSONObject();
		good.put("goodId","8120314018");
		good.put("price","1");
		list.add(good);
		data.put("goodList", list);
		data.put("memberCardIssueLocCD","681");
		data.put("channelCD","TAOBAO");
		data.put("facadeCd","13161616193");
		
		String res = InterfaceBizHelper.Pos_GetMemberCardPolicyAndSP(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	public JSONObject posGoods(){
		
		JSONObject data = new JSONObject();
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		return data;
		
	}
	
	@Test
	public void TC_posGoodsBigKind() throws InterruptedException {
		//获取分类信息
		
		logger.info("[步骤_1]. 获取分类信息（Pos_Goods_BigKind）");
		
		JSONObject data = posGoods();
		data.put("code", "4001");
		data.put("workerstation_id", "WIN-ATP4C0OQRFN");
		//System.out.println(TestData.FindValueInVariables("workerstationId"));
		String res = InterfaceBizHelper.posGoodsBigKind(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4001");
		boolean result = false;
		if(res.contains("4001")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		
		System.out.println(data);
	}
	
	@Test
	public void TC_posGoodsListClassPlace() throws InterruptedException {
		//查询商品列表信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4002");
		data.put("workerstation_id", "SP001");
		data.put("returnpic_yn", false);
		data.put("pos_source", "TAOBAO");
		data.put("class_id", "ZPDL01");
		String res = InterfaceBizHelper.posGoodsListClassPlace(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4002");
		boolean result = false;
		if(res.contains("4002")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posOnegoodsInfo() throws InterruptedException {
		//查询单个商品信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4002");
		data.put("workerstation_id", "SP001");
		data.put("id_type", "GoodsId");
		data.put("goods_id", "8120314018");
		//data.put("channelCd", "TAOBAO");
		String res = InterfaceBizHelper.posOnegoodsInfo(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4002");
		boolean result = false;
		if(res.contains("4002")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectGoodsInfoFuzzy() throws InterruptedException {
		//查询单个商品信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4025");
		data.put("workerstation_id", "SP001");
		data.put("PosGoodsId", "8120314018");
		//data.put("PosGoodsName", "8120314018");
		//data.put("PosGoodsLongId", "8120314018");
		//data.put("PosGoodsShortId", "8120314018");
		//data.put("channelCd", "8120314018");
		//data.put("channelCd", "TAOBAO");
		String res = InterfaceBizHelper.posSelectGoodsInfoFuzzy(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4025");
		boolean result = false;
		if(res.contains("4025")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectHotSaleDtls() throws InterruptedException {
		//查询热卖商品信息(本地卖品设置推荐购买)
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4023");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posSelectHotSaleDtls(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4023");
		boolean result = false;
		if(res.contains("4023")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_PosFavourableFormula() throws InterruptedException {
		//查询自由套餐列表信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4005");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posFavourableFormula(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4005");
		boolean result = false;
		if(res.contains("4005")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posFavourableFormulaDetails() throws InterruptedException {
		//查询自由套餐明细列表信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4006");
		data.put("pff_formula_id", "8000000087");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posFavourableFormulaDetails(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4006");
		boolean result = false;
		if(res.contains("4006")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posFFormulaClass() throws InterruptedException {
		//查询自由套餐明细列表信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4020");
		data.put("type_id", "2132");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posFFormulaClass(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4020");
		boolean result = false;
		if(res.contains("4020")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posFFormulaDetailsSelect() throws InterruptedException {
		//查询自由套餐列表信息
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4021");
		data.put("pff_formula_id", "8000000213");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posFFormulaDetailsSelect(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4021");
		boolean result = false;
		if(res.contains("4021")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posFFormulaSelectGoods() throws InterruptedException {
		//根据商品列表获取套餐提示
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4022");
		data.put("goods_id_list", "8000000213");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posFFormulaSelectGoods(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4022");
		boolean result = false;
		if(res.contains("4022")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posId() throws InterruptedException {
		//根据商品列表获取套餐提示
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4007");
		//data.put("goods_id_list", "8000000213");
		data.put("workerstation_id", "SP001");
		//data.put("channelCd", "TAOBAO");
	
		String res = InterfaceBizHelper.posId(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4022");
		boolean result = false;
		if(res.contains("4007")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSale() throws InterruptedException {
		//卖品消费接口（PosSale）[不对外]
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4008");
		//data.put("goods_id_list", "8000000213");
		data.put("workerstation_id", "SP001");
		data.put("pos_sale_op", "Sale");
	
		String res = InterfaceBizHelper.posSale(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4022");
		boolean result = false;
		if(res.contains("4008")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectTempInfo() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4028");
		//data.put("goods_id_list", "8000000213");
		data.put("workerstation_id", "WIN-ATP4C0OQRFN");
		data.put("pos_select_id", "68112016041200006");
	
		String res = InterfaceBizHelper.posSelectTempInfo(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4028");
		boolean result = false;
		if(res.contains("4028")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posTemp() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4028");
		//data.put("goods_id_list", "8000000213");
		data.put("workerstation_id", "WIN-ATP4C0OQRFN");
		data.put("pos_select_id", "68112016041200006");
	
		String res = InterfaceBizHelper.posTemp(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4028");
		boolean result = false;
		if(res.contains("4028")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectTempListUme() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4028");
		//data.put("goods_id_list", "8000000213");
		data.put("pos_opend_date", "2016-04-12");
		data.put("pos_sale_user", "YKSE");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posSelectTempListUme(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4028");
		boolean result = false;
		if(res.contains("4028")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	
	@Test
	public void TC_posSelectTempInfoUme() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4029");
		//data.put("goods_id_list", "8000000213");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_select_id", "68112016041200008");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posSelectTempInfoUme(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4028");
		boolean result = false;
		if(res.contains("4028")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posDeleteTempId() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4032");
		//data.put("goods_id_list", "8000000213");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_sale_id", "68112016041200009");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posDeleteTempId(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4032");
		boolean result = false;
		if(res.contains("4032")){
			result = true;
		}
		//Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posGetPosAgency() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4027");
		//data.put("goods_id_list", "8000000213");
		//data.put("pos_opend_date", "2016-04-12");
		//data.put("pos_sale_id", "68112016041200009");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.getPosAgency(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4027");
		boolean result = false;
		if(res.contains("4027")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectpickup() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4034");
		//data.put("goods_id_list", "8000000213");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_sale_id", "681120160412231785");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posSelectpickup(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4034");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posOrderFetchConfirm() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4035");
		
		//data.put("goods_id_list", "8000000213");
		//data.put("pos_opend_date", "2016-04-12");
		//data.put("pos_sale_id", "681120160412231785");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posOrderFetchConfirm(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4034");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	
	@Test
	public void TC_posGetWorkStationStockInfo() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4033");
		
		//data.put("goods_id_list", "8000000213");
		data.put("pos_sale_user", "YKSE");
		data.put("pos_opend_date", "2016-04-12");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posGetWorkStationStockInfo(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	
	@Test
	public void TC_posStockConfirm() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4036");
		
		//data.put("goods_id_list", "8000000213");
		data.put("userid", "BO");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posStockConfirm(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posExamineGoods() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4037");
		
		//data.put("goods_id_list", "8000000213");
		data.put("userid", "BO");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posExamineGoods(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	

	
	@Test
	public void TC_posRemoveCache() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4013");
		
		//data.put("goods_id_list", "8000000213");
		data.put("RemoveName", "All");
		//data.put("pos_opend_date", "2016-04-12");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posRemoveCache(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSetSelect() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4014");
		
		//data.put("goods_id_list", "8000000213");
		//data.put("userid", "BO");
		//data.put("pos_opend_date", "2016-04-12");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posSetSelect(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}

	@Test
	public void TC_posTicketInfo() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4010");
		
		//data.put("goods_id_list", "8000000213");
		//data.put("userid", "BO");
		//data.put("pos_opend_date", "2016-04-12");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		String res = InterfaceBizHelper.posTicketInfo(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posHoldSelectForm() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4011");
		
		data.put("pos_sale_op", "Sale");
		data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		data.put("Pos_Select_type", "Id");
		data.put("pos_Source", "Gapos");
		data.put("pos_select_id", "681120160412231785");
		data.put("pos_select_days", "300");
		data.put("pos_hold_fetch", "Uncheck");
		
		String res = InterfaceBizHelper.posHoldSelectForm(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posHoldSelectDtls() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4012");
		
		data.put("pos_sale_op", "Hold");
		//data.put("pos_workstation", "WIN-ATP4C0OQRFN");
		//data.put("Pos_Select_type", "Id");
		//data.put("pos_Source", "Gapos");
		data.put("pos_select_id", "681120160412231785");
		//data.put("pos_select_days", "300");
		//data.put("pos_hold_fetch", "Uncheck");
		
		String res = InterfaceBizHelper.posHoldSelectDtls(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_posSelectForm() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4015");
		
		data.put("pos_sale_op", "SelectAll");
		data.put("WorkerStation ", "WIN-ATP4C0OQRFN");
		//data.put("Pos_Select_type", "Id");
		//data.put("pos_Source", "Gapos");
		data.put("OrderId", "681120160412231785");
		data.put("SelectDays", "300");
		//data.put("pos_hold_fetch", "Uncheck");
		
		String res = InterfaceBizHelper.posSelectForm(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	
	@Test
	public void TC_POS_posSelectDtls() throws InterruptedException {
		//查询挂单
		
		logger.info("[步骤_1]. 查询商品列表信息（Pos_Goods_Lists）");
		
		JSONObject data = posGoods();
		data.put("code", "4016");
		
		data.put("pos_sale_op", "Hold");
		//data.put("WorkerStation ", "WIN-ATP4C0OQRFN");
		//data.put("Pos_Select_type", "Id");
		//data.put("pos_Source", "Gapos");
		data.put("pos_select_id", "1545454");
		//data.put("SelectDays", "300");
		//data.put("pos_hold_fetch", "Uncheck");
		
		String res = InterfaceBizHelper.posSelectDtls(data);
		
		logger.info("[检查点_1]. 检查返回内容是否包含4033");
		boolean result = false;
		if(res.contains("\"result\":0")){
			result = true;
		}
		Assert.assertEquals(result,true);
	
	
		System.out.println(data);
	}
	/**
	*获取分类信息
	* @author linguohu
	* @Time2016-04-21 09:53
	*/
	
	
	@Test(groups={"P0"})
	public void TC_POS_posGoodsBigKind_getgoosbigkind() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].获取分类信息（Pos_Goods_BigKind");
		//调用接口
		String res_POS_posGoodsBigKind = InterfaceBizHelper.posGoodsBigKind(InterFaceFinixxGoodsData.POS_posGoodsBigKind());
		result = InterFaceFinixxGoodsAssertion.TA_POS_posGoodsBigKind(res_POS_posGoodsBigKind);
		Assert.assertEquals(result, true);
	}
	
	
	
	/**
	*查询商品列表信息
	* @author linguohu
	* @Time2016-04-21 09:53
	*/	
	
	@Test(groups={"P0"})
	public void TC_POS_posGoods_Lists_getGoosLists() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取分类信息（Pos_Goods_BigKind）");
		String res_POS_posGoodsBigKind = InterfaceBizHelper.posGoodsBigKind(InterFaceFinixxGoodsData.POS_posGoodsBigKind());
		logger.info("[步骤_2].查询商品列表信息（Pos_Goods_Lists");
		JSONObject class_id = CommonUntil.GetGoodsBigKindclass_id(res_POS_posGoodsBigKind);
		String res_POS_PosGoodsListClassPlace = "";
		if (!class_id.equals(""))
		{
			res_POS_PosGoodsListClassPlace = InterfaceBizHelper.posGoodsListClassPlace(InterFaceFinixxGoodsData.POS_PosGoodsListClassPlace(class_id));
			
		}
		result = InterFaceFinixxGoodsAssertion.TA_PosGoodsListClassPlace(res_POS_PosGoodsListClassPlace);
	
		Assert.assertEquals(result,true);
	}	
	

	
	/**
	*查询单个商品信息
	* @author linguohu
	* @Time2016-04-21 09:53
	*/	
	
	@Test(groups={"P0"})
	public void TC_POS_posOnegoodsInfo_getOneGoodsInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询单个商品信息（PosOnegoodsInfo）");
		//调用接口
		String res_POS_posOnegoodsInfo = InterfaceBizHelper.posOnegoodsInfo(InterFaceFinixxGoodsData.POS_PosOnegoodsInfo());
		result = InterFaceFinixxGoodsAssertion.TA_PosOnegoodsInfo(res_POS_posOnegoodsInfo);
		Assert.assertEquals(result, true);
	}
	
	
	/**
	*查询某一商品
	* @author linguohu
	* @Time2016-04-21 10:13
	*/	
	
	@Test(groups={"P0"})
	public void TC_POS_posSelectGoodsInfoFuzzy_selectOneGoods() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].模糊查询商品（Pos_Select_GoodsInfo_Fuzzy）");
		//调用接口
		String res_GetPosSelectGoodsInfo_Fuzzy = InterfaceBizHelper.posSelectGoodsInfoFuzzy(InterFaceFinixxGoodsData.GetPosSelectGoodsInfo_Fuzzy());
		result = InterFaceFinixxGoodsAssertion.TA_GetPosSelectGoodsInfo_Fuzzy(res_GetPosSelectGoodsInfo_Fuzzy);
		Assert.assertEquals(result, true);
	}
	

	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-04-21 10:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posSelectHotSaleDtls_selectHotSaleDtls() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询热卖商品信息（Pos_select_HotSale_Dtls）");
		//调用接口
		String res_Pos_select_HotSale_Dtls = InterfaceBizHelper.posSelectHotSaleDtls(InterFaceFinixxGoodsData.Pos_select_HotSale_Dtls());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_select_HotSale_Dtls(res_Pos_select_HotSale_Dtls);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 09:57
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosFavourableFormula_selectFavourableFormula() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询自由套餐列表信息（PosFavourable_Formula）");
		//调用接口
		String res_PosFavourable_Formula = InterfaceBizHelper.posFavourableFormula(InterFaceFinixxGoodsData.PosFavourable_Formula());
		result = InterFaceFinixxGoodsAssertion.TA_PosFavourable_Formula(res_PosFavourable_Formula);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 10:07
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posFavourableFormulaDetails_selectFavourableFormulaDetails() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询自由套餐明细列表信息（PosFavourable_Formula_Details）");
		//调用接口
		String res_PosFavourable_Formula_Details = InterfaceBizHelper.posFavourableFormulaDetails(InterFaceFinixxGoodsData.PosFavourable_Formula_Details());
		result = InterFaceFinixxGoodsAssertion.TA_PosFavourable_Formula_Details(res_PosFavourable_Formula_Details);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 10:13
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posFFormulaClass_getFormulaClass() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询自由套餐列表信息（Pos_FFormula_Class）");
		//调用接口
		String res_Pos_FFormula_Class = InterfaceBizHelper.posFFormulaClass(InterFaceFinixxGoodsData.Pos_FFormula_Class());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_FFormula_Class(res_Pos_FFormula_Class);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 10:19
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posFFormulaDetailsSelect_getFormulaDetails() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询自由套餐列表信息（Pos_FFormula_Details_Select）");
		//调用接口
		String res_Pos_FFormula_Details_Select = InterfaceBizHelper.posFFormulaDetailsSelect(InterFaceFinixxGoodsData.Pos_FFormula_Details_Select());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_FFormula_Details_Select(res_Pos_FFormula_Details_Select);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 10:32
	*/	
	@Test(groups={"P0"})
	public void TC_Pos_FFormula_Select_Goods_getGoods() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].根据商品列表获取套餐提示（Pos_FFormula_Select_Goods）");
		//调用接口
		String res_Pos_FFormula_Select_Goods = InterfaceBizHelper.posFFormulaSelectGoods(InterFaceFinixxGoodsData.Pos_FFormula_Select_Goods());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_FFormula_Select_Goods(res_Pos_FFormula_Select_Goods);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 11:32
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posId_getposid() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].获取单号（PosId）");
		//调用接口
		String res_PosId = InterfaceBizHelper.posId(InterFaceFinixxGoodsData.PosId());
		result = InterFaceFinixxGoodsAssertion.TA_PosId(res_PosId);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 15:00
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posSale_getposSale() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].卖品消费接口（PosSale）[不对外]");
		//调用接口
		String res_PosSale = InterfaceBizHelper.posSale(InterFaceFinixxGoodsData.PosSale());
		result = InterFaceFinixxGoodsAssertion.TA_PosSale(res_PosSale);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-03 17:00
	*/	
	@Test(groups={"P0"})
	public void TC_POS_posSelectTempInfo_selectTempInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询挂单（Pos_Select_Temp_Info）");
		//调用接口
		String res_Pos_Select_Temp_Info = InterfaceBizHelper.posSelectTempInfo(InterFaceFinixxGoodsData.Pos_Select_Temp_Info());
		result = InterFaceFinixxGoodsAssertion.TA_PosSale(res_Pos_Select_Temp_Info);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 09:10
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosTemp_selectPosTemp() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].临时挂单接口（PosTemp）");
		//调用接口
		String res_PosTemp = InterfaceBizHelper.posTemp(InterFaceFinixxGoodsData.PosTemp());
		result = InterFaceFinixxGoodsAssertion.TA_PosTemp(res_PosTemp);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 09:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosSelectTemp_List_Ume_selectTemp() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询挂单（PosSelectTemp_List_Ume）");
		//调用接口
		String res_PosSelectTemp_List_Ume = InterfaceBizHelper.posSelectTempListUme(InterFaceFinixxGoodsData.PosSelectTemp_List_Ume());
		result = InterFaceFinixxGoodsAssertion.TA_PosSelectTemp_List_Ume(res_PosSelectTemp_List_Ume);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 10:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosSelectTemp_Info_Ume_selectTemp() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询临时挂单（PosSelectTemp_Info_Ume）");
		//调用接口
		String res_PosSelectTemp_Info_Ume = InterfaceBizHelper.posSelectTempInfoUme(InterFaceFinixxGoodsData.PosSelectTemp_Info_Ume());
		result = InterFaceFinixxGoodsAssertion.TA_PosSelectTemp_Info_Ume(res_PosSelectTemp_Info_Ume);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 11:00
	*/	
	@Test(groups={"P0"})
	public void TTC_POS_Pos_Delete_Temp_Id_deleteTemp() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].删除临时挂单（Pos_Delete_Temp_Id）");
		//调用接口
		String res_Pos_Delete_Temp_Id = InterfaceBizHelper.posDeleteTempId(InterFaceFinixxGoodsData.Pos_Delete_Temp_Id());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Delete_Temp_Id(res_Pos_Delete_Temp_Id);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 11:00
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_GetPosAgency_get() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].获取业务员信息（Pos_GetPosAgency）");
		//调用接口
		String res_Pos_GetPosAgency = InterfaceBizHelper.getPosAgency(InterFaceFinixxGoodsData.Pos_GetPosAgency());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_GetPosAgency(res_Pos_GetPosAgency);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 11:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_Selectpickup_select() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询备货明细信息（Pos_Selectpickup）");
		//调用接口
		String res_Pos_Selectpickup = InterfaceBizHelper.posSelectpickup(InterFaceFinixxGoodsData.Pos_Selectpickup());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Selectpickup(res_Pos_Selectpickup);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 11:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_Order_Fetch_Confirm_commit() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].备货取货确认（Pos_Order_Fetch_Confirm）");
		//调用接口
		String res_Pos_Order_Fetch_Confirm = InterfaceBizHelper.posOrderFetchConfirm(InterFaceFinixxGoodsData.Pos_Order_Fetch_Confirm());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Order_Fetch_Confirm(res_Pos_Order_Fetch_Confirm);
		Assert.assertEquals(result, true);
	}
	
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 14:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_GetWorkStationStockInfo_putworkerstationid() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].货架需验货商品存货（Pos_GetWorkStationStockInfo）");
		//调用接口
		String res_Pos_GetWorkStationStockInfo = InterfaceBizHelper.posGetWorkStationStockInfo(InterFaceFinixxGoodsData.Pos_GetWorkStationStockInfo());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_GetWorkStationStockInfo(res_Pos_GetWorkStationStockInfo);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 14:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_Stock_Confirm_putworkerstationid() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].前台登录验货检查 是否存在未验货（Pos_Stock_Confirm）");
		//调用接口
		String res_Pos_Stock_Confirm = InterfaceBizHelper.posStockConfirm(InterFaceFinixxGoodsData.Pos_Stock_Confirm_putworkStationId());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Stock_Confirm(res_Pos_Stock_Confirm);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 14:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_Stock_Confirm_putuserid() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].前台登录验货检查 是否存在未验货（Pos_Stock_Confirm）");
		//调用接口
		String res_Pos_Stock_Confirm = InterfaceBizHelper.posStockConfirm(InterFaceFinixxGoodsData.Pos_Stock_Confirm_putuserid());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Stock_Confirm(res_Pos_Stock_Confirm);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-04 15:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_Examine_Goods_put() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].前台验货 自动售退（Pos_Examine_Goods）");
		//调用接口
		String res_Pos_Examine_Goods = InterfaceBizHelper.posExamineGoods(InterFaceFinixxGoodsData.Pos_Examine_Goods());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_Examine_Goods(res_Pos_Examine_Goods);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-05 10:30
	*/	
	@Test(groups={"P0"})
	public void TC_POS_Pos_RemoveCache_choseGoods() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].手动清理卖品前台缓存（Pos_RemoveCache）");
		//调用接口
		String res_Pos_RemoveCache = InterfaceBizHelper.posRemoveCache(InterFaceFinixxGoodsData.Pos_RemoveCache());
		result = InterFaceFinixxGoodsAssertion.TA_Pos_RemoveCache(res_Pos_RemoveCache);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-05 10:39
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosSetSelect_pos() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查所有 POS_SET 信息（PosSetSelect）");
		//调用接口
		String res_PosSetSelect = InterfaceBizHelper.posSetSelect(InterFaceFinixxGoodsData.PosSetSelect());
		result = InterFaceFinixxGoodsAssertion.TA_PosSetSelect(res_PosSetSelect);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-05 10:42
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosTicketInfo_pos() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].获取卖品小票结尾打印信息（PosTicketInfo）");
		//调用接口
		String res_PosTicketInfo = InterfaceBizHelper.posTicketInfo(InterFaceFinixxGoodsData.PosTicketInfo());
		result = InterFaceFinixxGoodsAssertion.TA_PosTicketInfo(res_PosTicketInfo);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-05 10:58
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosHoldSelectForm_selectHold() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询订货单据信息（PosHoldSelectForm）");
		//调用接口
		String res_PosHoldSelectForm = InterfaceBizHelper.posHoldSelectForm(InterFaceFinixxGoodsData.PosHoldSelectForm());
		result = InterFaceFinixxGoodsAssertion.TA_PosHoldSelectForm(res_PosHoldSelectForm);
		Assert.assertEquals(result, true);
	}
	
	/**
	*查询热卖商品信息
	* @author linguohu
	* @Time2016-05-05 11:20
	*/	
	@Test(groups={"P0"})
	public void TC_POS_PosHoldSelectDtls_selecSale() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].查询订单明细信息（PosHoldSelectDtls）");
		//调用接口
		String res_PosHoldSelectDtls = InterfaceBizHelper.posHoldSelectDtls(InterFaceFinixxGoodsData.PosHoldSelectDtls());
		result = InterFaceFinixxGoodsAssertion.TA_PosHoldSelectDtls(res_PosHoldSelectDtls);
		Assert.assertEquals(result, true);
	}
	
}

