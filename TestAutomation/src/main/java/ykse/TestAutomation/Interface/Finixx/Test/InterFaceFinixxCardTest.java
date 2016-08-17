package ykse.TestAutomation.Interface.Finixx.Test;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Interface.Finixx.Common.CommonUntil;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxCardAssertion;
import ykse.TestAutomation.Interface.Finixx.Common.InterFaceFinixxCardData;
import ykse.TestAutomation.Interface.Finixx.Common.InterfaceBizHelper;
import ykse.TestAutomation.Interface.Finixx.Common.TestData;


public class InterFaceFinixxCardTest {
	Logger logger = new Log("interface_Finixx").logger;
	
	@BeforeClass
	public static void setUp() throws Exception {

	}

	@AfterClass
	public static void tearDown() throws Exception {
		// driver.close();
	}
	@BeforeMethod(alwaysRun = true)
	public void BeforeCase() throws Exception {
		
		logger.warn("****开始执行用例****");
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterCase() throws Exception {
		logger.warn("****用例执行结束****");
		
	}

	@Test
	public void TC_cardcompany_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1]. 获取公司名称（Card_GetCompany）");
		JSONObject data = new JSONObject();
		String res = InterfaceBizHelper.cardcompany(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
	
		//Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.1 Card_GetCardInfo 获取会员卡信息
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetCardInfo() throws InterruptedException {
		boolean result = false;		
		logger.info("[步骤_1]. 获取会员卡信息（Card_GetCardInfo）");
		String res_Card_GetCardInfo = InterfaceBizHelper.Card_GetCardInfo(InterFaceFinixxCardData.Card_GetCardInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetCardInfo(res_Card_GetCardInfo);
		Assert.assertEquals(result,true);
	}


	/**
	*2.6.2 Card_GetUsePolicy 获取会员卡使用政策
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetUsePolicy() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取会员卡使用政策（Card_GetUsePolicy）");
		String res_Card_GetUsePolicy = InterfaceBizHelper.Card_GetUsePolicy(InterFaceFinixxCardData.Card_GetUsePolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_GetUsePolicy(res_Card_GetUsePolicy);
		Assert.assertEquals(result,true);
	}

	/**
	*2.6.3 Card_GetGradePolicy 获取会员卡等级政策
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetGradePolicy() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取会员卡等级政策（Card_GetGradePolicy）");
		String res_Card_GetGradePolicy = InterfaceBizHelper.Card_GetGradePolicy(InterFaceFinixxCardData.Card_GetGradePolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_GetGradePolicy(res_Card_GetGradePolicy);	
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.4 Card_GetLimitTickets 获取会员卡折扣票数
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetLimitTickets() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取会员卡折扣票数（Card_GetLimitTickets）");
		String res_Card_GetLimitTickets = InterfaceBizHelper.Card_GetLimitTickets(InterFaceFinixxCardData.Card_GetLimitTickets());
		result = InterFaceFinixxCardAssertion.TA_Card_GetLimitTickets(res_Card_GetLimitTickets);	
	
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.5 Card_Consume 会员卡消费
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_Consume() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 会员卡消费（Card_Consume）");
		String res_Card_Consume= InterfaceBizHelper.Card_Consume(InterFaceFinixxCardData.Card_Consume());
		result = InterFaceFinixxCardAssertion.TA_Card_Consume(res_Card_Consume);
		Assert.assertEquals(result,true);
	}	
	
	/**
	*2.6.6 Card_ConsumeRollback 会员卡购票消费回滚
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_ConsumeRollback() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 会员卡购票消费回滚（Card_GetLimitTickets）");
		JSONObject data = new JSONObject();
		String res_Card_ConsumeRollback= InterfaceBizHelper.Card_ConsumeRollback(InterFaceFinixxCardData.Card_ConsumeRollback());
		result = InterFaceFinixxCardAssertion.TA_Card_ConsumeRollback(res_Card_ConsumeRollback);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.7 Card_GetStateInfo 获取会员卡状态描述
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetStateInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员卡状态描述（Card_GetStateInfo）");
		String res_Card_GetStateInfo= InterfaceBizHelper.Card_GetStateInfo(InterFaceFinixxCardData.Card_GetStateInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetStateInfo(res_Card_GetStateInfo);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.8 Card_GetCardBuying 获取会员卡消费记录
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetCardBuying() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取会员卡消费记录（Card_GetCardBuying）");
		String res_Card_GetCardBuying= InterfaceBizHelper.Card_GetCardBuying(InterFaceFinixxCardData.Card_GetCardBuying());
		result = InterFaceFinixxCardAssertion.TA_Card_GetCardBuying(res_Card_GetCardBuying);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.9 Card_GetPaymentType 获取会员付款方式
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPaymentType() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取会员付款方式（Card_GetPaymentType）");
		String res_Card_GetPaymentType= InterfaceBizHelper.Card_GetPaymentType(InterFaceFinixxCardData.Card_GetPaymentType());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPaymentType(res_Card_GetPaymentType);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.10	Card_GetCompany	获取公司名称
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetCompany() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取公司名称（Card_GetCompany）");
		String res_Card_GetCompany= InterfaceBizHelper.Card_GetCompany(InterFaceFinixxCardData.Card_GetCompany());
		result = InterFaceFinixxCardAssertion.TA_Card_GetCompany(res_Card_GetCompany);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.11	Card_GetSales 获取业务员
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSales() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 获取业务员（Card_GetSales）");
		String res_Card_GetSales= InterfaceBizHelper.Card_GetSales(InterFaceFinixxCardData.Card_GetSales());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSales(res_Card_GetSales);	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.12	Card_GetSellInit 获取发卡权限
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSellInit() throws InterruptedException {
		boolean result = false;
		
		logger.info("[步骤_1]. 获取发卡权限（Card_GetSellInit）");
		String res_Card_GetSellInit= InterfaceBizHelper.Card_GetSellInit(InterFaceFinixxCardData.Card_GetSellInit());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSellInit(res_Card_GetSellInit);
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.13	Card_GetSoftDog	检测加密狗
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSoftDog() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 检测加密狗（Card_GetSoftDog）");
		String res_Card_GetSoftDog= InterfaceBizHelper.Card_GetSoftDog(InterFaceFinixxCardData.Card_GetSoftDog());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSoftDog(res_Card_GetSoftDog);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.14	Card_GetReading	获取读卡需要的信息
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetReading() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 获取读卡需要的信息（Card_GetReading）");
		String res_Card_GetReading= InterfaceBizHelper.Card_GetReading(InterFaceFinixxCardData.Card_GetReading());
		result = InterFaceFinixxCardAssertion.TA_Card_GetReading(res_Card_GetReading);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.15	Card_GetSellInfo 获取会员卡发卡相关信息
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSellInfo() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 获取会员卡发卡相关信息（Card_GetSellInfo）");
		String res_Card_GetSellInfo= InterfaceBizHelper.Card_GetSellInfo(InterFaceFinixxCardData.Card_GetSellInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSellInfo(res_Card_GetSellInfo);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.16	Card_GetSellGroupID	获取团体卡发卡批次号
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSellGroupID() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 获取团体卡发卡批次号（Card_GetSellGroupID）");
		String res_Card_GetSellGroupID= InterfaceBizHelper.Card_GetSellGroupID(InterFaceFinixxCardData.Card_GetSellGroupID());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSellGroupID(res_Card_GetSellGroupID);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.17	Card_Sell 发卡
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_Sell() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1]. 发卡（Card_Sell）");
		String res_Card_Sell= InterfaceBizHelper.Card_Sell(InterFaceFinixxCardData.Card_Sell());
		result = InterFaceFinixxCardAssertion.TA_Card_Sell(res_Card_Sell);
		logger.info("[步骤_2]. 销卡（Card_Annul）");
		String facadecd = CommonUntil.GetsellFacadeCD(res_Card_Sell);
		String res_Card_Annul= InterfaceBizHelper.Card_Annul(InterFaceFinixxCardData.Card_Annul(facadecd));
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.18	Card_AddMoney 卡充值
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_AddMoney() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 卡充值（Card_AddMoney）");
		String res_Card_AddMoney= InterfaceBizHelper.Card_AddMoney(InterFaceFinixxCardData.Card_AddMoney());
		result = InterFaceFinixxCardAssertion.TA_Card_AddMoney(res_Card_AddMoney);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.19	Card_GetSummaryInfo	取会员资料(会员概要信息)
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetSummaryInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  取会员资料(会员概要信息)（Card_GetSummaryInfo）");
		String res_Card_GetSummaryInfo= InterfaceBizHelper.Card_GetSummaryInfo(InterFaceFinixxCardData.Card_GetSummaryInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetSummaryInfo(res_Card_GetSummaryInfo);		
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.20	Card_GetPrefabricateUsePolicy 获取使用政策列表
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPrefabricateUsePolicy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取使用政策列表（Card_GetPrefabricateUsePolicy）");
		String res_Card_GetPrefabricateUsePolicy= InterfaceBizHelper.Card_GetPrefabricateUsePolicy(InterFaceFinixxCardData.Card_GetPrefabricateUsePolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPrefabricateUsePolicy(res_Card_GetPrefabricateUsePolicy);		
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.21	Card_GetPrefabricateGrade 获取等级政策列表
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPrefabricateGrade() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取等级政策列表（Card_GetPrefabricateGrade）");
		String res_Card_GetPrefabricateGrade= InterfaceBizHelper.Card_GetPrefabricateGrade(InterFaceFinixxCardData.Card_GetPrefabricateGrade());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPrefabricateGrade(res_Card_GetPrefabricateGrade);		
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.22	Card_GetPrefabricateTradePolicyHdrs	获取购票积分政策概要列表
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPrefabricateTradePolicyHdrs() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取购票积分政策概要列表（Card_GetPrefabricateTradePolicyHdrs）");
		String res_Card_GetPrefabricateTradePolicyHdrs= InterfaceBizHelper.Card_GetPrefabricateTradePolicyHdrs(InterFaceFinixxCardData.Card_GetPrefabricateTradePolicyHdrs());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPrefabricateTradePolicyHdrs(res_Card_GetPrefabricateTradePolicyHdrs);			
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.23	Card_GetPrefabricateOrdersList	获取可用的订制单号
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPrefabricateOrdersList() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取可用的订制单号（Card_GetPrefabricateOrdersList）");
		String res_Card_GetPrefabricateOrdersList= InterfaceBizHelper.Card_GetPrefabricateOrdersList(InterFaceFinixxCardData.Card_GetPrefabricateOrdersList());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPrefabricateOrdersList(res_Card_GetPrefabricateOrdersList);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.24	Card_OrdersByOrderCD 根据订制单号取可用的预制卡号
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_OrdersByOrderCD() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1].  获取可用的订制单号（Card_GetPrefabricateOrdersList）");
		String res_Card_GetPrefabricateOrdersList= InterfaceBizHelper.Card_GetPrefabricateOrdersList(InterFaceFinixxCardData.Card_GetPrefabricateOrdersList());		
		logger.info("[步骤_2].  根据订制单号取可用的预制卡号（Card_OrdersByOrderCD）");
		String CardOrder = CommonUntil.getCardOrder(res_Card_GetPrefabricateOrdersList);
		String res_Card_OrdersByOrderCD= InterfaceBizHelper.Card_OrdersByOrderCD(InterFaceFinixxCardData.Card_OrdersByOrderCD(CardOrder));
		result = InterFaceFinixxCardAssertion.TA_Card_OrdersByOrderCD(res_Card_OrdersByOrderCD);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.25	Card_Prefabricate 卡预制
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_Prefabricate() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  获取可用的订制单号（Card_GetPrefabricateOrdersList）");
		String res_Card_GetPrefabricateOrdersList= InterfaceBizHelper.Card_GetPrefabricateOrdersList(InterFaceFinixxCardData.Card_GetPrefabricateOrdersList());		
		logger.info("[步骤_2].  根据订制单号取可用的预制卡号（Card_OrdersByOrderCD）");
		String CardOrder = CommonUntil.getCardOrder(res_Card_GetPrefabricateOrdersList);
		String res_Card_OrdersByOrderCD= InterfaceBizHelper.Card_OrdersByOrderCD(InterFaceFinixxCardData.Card_OrdersByOrderCD(CardOrder));
		logger.info("[步骤_3].  卡预制（Card_Prefabricate）");
		String facadeCD = CommonUntil.getfacadeCD(res_Card_OrdersByOrderCD);
		String res_Card_Prefabricate= InterfaceBizHelper.Card_Prefabricate(InterFaceFinixxCardData.Card_Prefabricate(facadeCD));
		result = InterFaceFinixxCardAssertion.TA_Card_Prefabricate(res_Card_Prefabricate);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.26	Card_QueryTicketBuy	查询售票消费记录
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryTicketBuy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询售票消费记录（Card_QueryTicketBuy）");
		String res_Card_QueryTicketBuy= InterfaceBizHelper.Card_QueryTicketBuy(InterFaceFinixxCardData.Card_QueryTicketBuy());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryTicketBuy(res_Card_QueryTicketBuy);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.27	Card_QueryTicketBuyDiscount	查询打折卡消费记录
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryTicketBuyDiscount() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询打折卡消费记录（Card_QueryTicketBuyDiscount）");
		String res_Card_QueryTicketBuyDiscount= InterfaceBizHelper.Card_QueryTicketBuyDiscount(InterFaceFinixxCardData.Card_QueryTicketBuyDiscount());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryTicketBuyDiscount(res_Card_QueryTicketBuyDiscount);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.28	Card_QueryPosBuy 查询卖品记录
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryPosBuy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询卖品记录（Card_QueryPosBuy）");
		String res_Card_QueryPosBuy= InterfaceBizHelper.Card_QueryPosBuy(InterFaceFinixxCardData.Card_QueryPosBuy());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryPosBuy(res_Card_QueryPosBuy);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.29	Card_QueryAddMoney	查询充值记录
	* @author hyc
	* @Time2016-04-20
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryAddMoney() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询充值记录（Card_QueryAddMoney）");
		String res_Card_QueryAddMoney= InterfaceBizHelper.Card_QueryAddMoney(InterFaceFinixxCardData.Card_QueryAddMoney());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryAddMoney(res_Card_QueryAddMoney);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.30	Card_QueryTransfer	查询转账记录
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryTransfer() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询转账记录（Card_QueryTransfer）");
		String res_Card_QueryTransfer= InterfaceBizHelper.Card_QueryTransfer(InterFaceFinixxCardData.Card_QueryTransfer());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryTransfer(res_Card_QueryTransfer);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.31	Card_QueryMarking	查询积分获取记录
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryMarking() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询积分获取记录（Card_QueryMarking）");
		String res_Card_QueryMarking= InterfaceBizHelper.Card_QueryMarking(InterFaceFinixxCardData.Card_QueryMarking());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryMarking(res_Card_QueryMarking);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.32	Card_QueryExchange	查询换购记录
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryExchange() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询换购记录（Card_QueryExchange）");
		String res_Card_QueryExchange= InterfaceBizHelper.Card_QueryExchange(InterFaceFinixxCardData.Card_QueryExchange());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryExchange(res_Card_QueryExchange);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.33	Card_QueryOtherSystemsConsume 查询其它系统导入记录
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryOtherSystemsConsume() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询其它系统导入记录（Card_QueryOtherSystemsConsume）");
		String res_Card_QueryOtherSystemsConsume= InterfaceBizHelper.Card_QueryOtherSystemsConsume(InterFaceFinixxCardData.Card_QueryOtherSystemsConsume());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryOtherSystemsConsume(res_Card_QueryOtherSystemsConsume);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.34	Card_QueryEditMemberInfo 查询修改会员资料记录
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryEditMemberInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询修改会员资料记录（Card_QueryEditMemberInfo）");
		String res_Card_QueryEditMemberInfo= InterfaceBizHelper.Card_QueryEditMemberInfo(InterFaceFinixxCardData.Card_QueryEditMemberInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryEditMemberInfo(res_Card_QueryEditMemberInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.35	Card_QueryWallet 查询电子钱包
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryWallet() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询电子钱包（Card_QueryWallet）");
		String res_Card_QueryWallet= InterfaceBizHelper.Card_QueryWallet(InterFaceFinixxCardData.Card_QueryWallet());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryWallet(res_Card_QueryWallet);
		Assert.assertEquals(result,true);
	}
		
//	/**
//	*2.6.36	Card_ConsumeIntegral 会员积分消费
//	* @author hyc
//	* @Time2016-04-21
//	*/
//	@Test(groups={"P0"})
//	public void TC_Card_ConsumeIntegral() throws InterruptedException {
//		boolean result = false;
//		logger.info("[步骤_1].  会员积分消费（Card_ConsumeIntegral）");
//		String res_Card_ConsumeIntegral= InterfaceBizHelper.Card_ConsumeIntegral(InterFaceFinixxCardData.Card_ConsumeIntegral());
//		result = InterFaceFinixxCardAssertion.TA_Card_ConsumeIntegral(res_Card_ConsumeIntegral);
//		Assert.assertEquals(result,true);
//	}
	
	
	/**
	*2.6.37	Card_ConsumeIntegralRollback 会员积分消费回滚
	* @author hyc
	* @Time2016-04-28
	*/
	@Test(groups={"P0"})
	public void TC_Card_ConsumeIntegralRollback() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  会员积分消费回滚（Card_ConsumeIntegralRollback）");
		String res_Card_ConsumeIntegralRollback= InterfaceBizHelper.Card_ConsumeIntegralRollback(InterFaceFinixxCardData.Card_ConsumeIntegralRollback());
		result = InterFaceFinixxCardAssertion.TA_Card_ConsumeIntegralRollback(res_Card_ConsumeIntegralRollback);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.38	Card_ChenkIDCardSameSerial	预制芯片号与卡号相同的ID卡权限
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_ChenkIDCardSameSerial() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  预制芯片号与卡号相同的ID卡权限（Card_ChenkIDCardSameSerial）");
		String res_Card_ChenkIDCardSameSerial= InterfaceBizHelper.Card_ChenkIDCardSameSerial(InterFaceFinixxCardData.Card_ChenkIDCardSameSerial());
		result = InterFaceFinixxCardAssertion.TA_Card_ChenkIDCardSameSerial(res_Card_ChenkIDCardSameSerial);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.39	Card_Order	卡订制
	* @author hyc
	* @Time2016-04-21
	*/
	@Test(groups={"P0"})
	public void TC_Card_Order() throws InterruptedException {
		boolean result = false;	
		logger.info("[步骤_1].  卡订制（Card_Order）");
		String res_Card_Order= InterfaceBizHelper.Card_Order(InterFaceFinixxCardData.Card_Order());
		result = InterFaceFinixxCardAssertion.TA_Card_Order(res_Card_Order);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.40	Card_CheckOrderFacadeCdIsUse 检测卡号段中是否有卡号已订制
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
    public void TC_Card_CheckOrderFacadeCdIsUse() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].检测卡号段中是否有卡号已订制（Card_CheckOrderFacadeCdIsUse）");
		String res_Card_CheckOrderFacadeCdIsUse= InterfaceBizHelper.Card_CheckOrderFacadeCdIsUse(InterFaceFinixxCardData.Card_CheckOrderFacadeCdIsUse());
		result = InterFaceFinixxCardAssertion.TA_Card_CheckOrderFacadeCdIsUse(res_Card_CheckOrderFacadeCdIsUse);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.41	Card_CardReportloss	报失
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
    public void TC_Card_CardReportloss() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].报失（Card_CardReportloss）");
		String res_Card_CardReportloss= InterfaceBizHelper.Card_CardReportloss(InterFaceFinixxCardData.Card_CardReportloss());
		result = InterFaceFinixxCardAssertion.TA_Card_CardReportloss(res_Card_CardReportloss);
		logger.info("[步骤_2].取消报失（Card_CardCancelloss）");
		String res_Card_CardCancelloss= InterfaceBizHelper.Card_CardCancelloss(InterFaceFinixxCardData.Card_CardCancelloss());
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.42	Card_CardCancelloss	取消报失
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_CardCancelloss() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].报失（Card_CardReportloss）");
		String res_Card_CardReportloss= InterfaceBizHelper.Card_CardReportloss(InterFaceFinixxCardData.Card_CardReportloss());
		logger.info("[步骤_2].取消报失（Card_CardCancelloss）");
		String res_Card_CardCancelloss= InterfaceBizHelper.Card_CardCancelloss(InterFaceFinixxCardData.Card_CardCancelloss());
		result = InterFaceFinixxCardAssertion.TA_Card_CardCancelloss(res_Card_CardCancelloss);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.43	Card_CardActivation	卡激活
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_CardActivation() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 卡激活（Card_CardActivation）");
		String res_Card_CardActivation= InterfaceBizHelper.Card_CardActivation(InterFaceFinixxCardData.Card_CardActivation());
		result = InterFaceFinixxCardAssertion.TA_Card_CardActivation(res_Card_CardActivation);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.44	Card_OrderGetSerialNumber 取订制可用卡号后半段
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_OrderGetSerialNumber() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取订制可用卡号后半段（Card_OrderGetSerialNumber）");
		String res_Card_OrderGetSerialNumber= InterfaceBizHelper.Card_OrderGetSerialNumber(InterFaceFinixxCardData.Card_OrderGetSerialNumber());
		result = InterFaceFinixxCardAssertion.TA_Card_OrderGetSerialNumber(res_Card_OrderGetSerialNumber);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.45	Card_CardExchange	换卡
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_CardExchange() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 换卡（Card_CardExchange）");
		String res_Card_CardExchange= InterfaceBizHelper.Card_CardExchange(InterFaceFinixxCardData.Card_CardExchange());
		result = InterFaceFinixxCardAssertion.TA_Card_CardExchange(res_Card_CardExchange);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.46	Card_EditMemberInfo	修改会员资料
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_EditMemberInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 修改会员资料（Card_EditMemberInfo）");
		String res_Card_EditMemberInfo= InterfaceBizHelper.Card_EditMemberInfo(InterFaceFinixxCardData.Card_EditMemberInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_EditMemberInfo(res_Card_EditMemberInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.47	Card_ResetPassword	修改重设密码
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_ResetPassword() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 修改重设密码（Card_ResetPassword）");
		String res_Card_ResetPassword= InterfaceBizHelper.Card_ResetPassword(InterFaceFinixxCardData.Card_ResetPassword());
		result = InterFaceFinixxCardAssertion.TA_Card_ResetPassword(res_Card_ResetPassword);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.48	Card_UMEImportPre UME新卡导入
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_UMEImportPre() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. UME新卡导入（Card_UMEImportPre）");
		String res_Card_UMEImportPre= InterfaceBizHelper.Card_UMEImportPre(InterFaceFinixxCardData.Card_UMEImportPre());
		result = InterFaceFinixxCardAssertion.TA_Card_UMEImportPre(res_Card_UMEImportPre);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.49	Card_GetMemberInfo	取会员资料
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetMemberInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取会员资料（Card_GetMemberInfo）");
		String res_Card_GetMemberInfo= InterfaceBizHelper.Card_GetMemberInfo(InterFaceFinixxCardData.Card_GetMemberInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetMemberInfo(res_Card_GetMemberInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.50	Card_GetPrefabricateInfo 取预制信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetPrefabricateInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取预制信息（Card_GetPrefabricateInfo）");
		String res_Card_GetPrefabricateInfo= InterfaceBizHelper.Card_GetPrefabricateInfo(InterFaceFinixxCardData.Card_GetPrefabricateInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_GetPrefabricateInfo(res_Card_GetPrefabricateInfo);
		Assert.assertEquals(result,true);
	}
	
		
	/**
	*2.6.51	Card_PrefabricateEdit	修改预制错误
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_PrefabricateEdit() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取预制信息（Card_GetPrefabricateInfo）");
		String res_Card_GetPrefabricateInfo= InterfaceBizHelper.Card_GetPrefabricateInfo(InterFaceFinixxCardData.Card_GetPrefabricateInfo());
		logger.info("[步骤_2]. 修改预制错误（Card_PrefabricateEdit）");
		String oldfacadeCD = CommonUntil.getPrefabicatefacadeCD(res_Card_GetPrefabricateInfo);
		String res_Card_PrefabricateEdit= InterfaceBizHelper.Card_PrefabricateEdit(InterFaceFinixxCardData.Card_PrefabricateEdit(oldfacadeCD));
		result = InterFaceFinixxCardAssertion.TA_Card_PrefabricateEdit(res_Card_PrefabricateEdit);
		Assert.assertEquals(result,true);
	}
	
	
	/**
	*2.6.52	Card_QueryOrder	订制查询
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryOrder() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 订制查询（Card_QueryOrder）");
		String res_Card_QueryOrder= InterfaceBizHelper.Card_QueryOrder(InterFaceFinixxCardData.Card_QueryOrder());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryOrder(res_Card_QueryOrder);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.53	Card_QueryPrefabricate	预制查询
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryPrefabricate() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 预制查询（Card_QueryPrefabricate）");
		String res_Card_QueryPrefabricate= InterfaceBizHelper.Card_QueryPrefabricate(InterFaceFinixxCardData.Card_QueryPrefabricate());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryPrefabricate(res_Card_QueryPrefabricate);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.54	Card_Cancel	退卡
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Cancel() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 退卡（Card_Cancel）");
		String res_Card_Cancel= InterfaceBizHelper.Card_Cancel(InterFaceFinixxCardData.Card_Cancel());
		result = InterFaceFinixxCardAssertion.TA_Card_Cancel(res_Card_Cancel);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.55  Card_Annul	销卡
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Annul() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 发卡（Card_Sell）");
		String res_Card_Sell= InterfaceBizHelper.Card_Sell(InterFaceFinixxCardData.Card_Sell());
		logger.info("[步骤_2]. 销卡（Card_Annul）");
		String facadecd = CommonUntil.GetsellFacadeCD(res_Card_Sell);
		String res_Card_Annul= InterfaceBizHelper.Card_Annul(InterFaceFinixxCardData.Card_Annul(facadecd));
		result = InterFaceFinixxCardAssertion.TA_Card_Annul(res_Card_Annul);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.56	Card_EditPolicy	修改积分政策
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_EditPolicy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 修改积分政策（Card_EditPolicy）");
		String res_Card_EditPolicy= InterfaceBizHelper.Card_EditPolicy(InterFaceFinixxCardData.Card_EditPolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_EditPolicy(res_Card_EditPolicy);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.57	CARD_GLOBALSYS	获取会员系统设置信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GLOBALSYS() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员系统设置信息政策（Card_GLOBALSYS）");
		String res_Card_GLOBALSYS= InterfaceBizHelper.Card_GLOBALSYS(InterFaceFinixxCardData.Card_GLOBALSYS());
		result = InterFaceFinixxCardAssertion.TA_Card_GLOBALSYS(res_Card_GLOBALSYS);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.58	Card_Get_TransferList	取转账列表
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_TransferList() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取转账列表（Card_Get_TransferList）");
		String res_Card_Get_TransferList= InterfaceBizHelper.Card_Get_TransferList(InterFaceFinixxCardData.Card_Get_TransferList());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_TransferList(res_Card_Get_TransferList);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.59	Card_Transfer	卡转账
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Transfer() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 卡转账（Card_Transfer）");
		String res_Card_Transfer= InterfaceBizHelper.Card_Transfer(InterFaceFinixxCardData.Card_Transfer());
		result = InterFaceFinixxCardAssertion.TA_Card_Transfer(res_Card_Transfer);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.60	Card_Get_RePrintSell	查询补打发卡凭证信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_RePrintSell() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询补打发卡凭证信息（Card_Get_RePrintSell）");
		String res_Card_Get_RePrintSell= InterfaceBizHelper.Card_Get_RePrintSell(InterFaceFinixxCardData.Card_Get_RePrintSell());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_RePrintSell(res_Card_Get_RePrintSell);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.61	Card_Get_RePRintAdd	查询补打充值凭证信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_RePRintAdd() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询补打充值凭证信息（Card_Get_RePRintAdd）");
		String res_Card_Get_RePRintAdd= InterfaceBizHelper.Card_Get_RePRintAdd(InterFaceFinixxCardData.Card_Get_RePRintAdd());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_RePRintAdd(res_Card_Get_RePRintAdd);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.62	Card_Update_Add_PrintTimes	更新充值凭证打印次数
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Update_Add_PrintTimes() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 更新充值凭证打印次数（Card_Update_Add_PrintTimes）");
		String res_Card_Update_Add_PrintTimes= InterfaceBizHelper.Card_Update_Add_PrintTimes(InterFaceFinixxCardData.Card_Update_Add_PrintTimes());
		result = InterFaceFinixxCardAssertion.TA_Card_Update_Add_PrintTimes(res_Card_Update_Add_PrintTimes);		
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.64	Card_Get_RePrintConsume	查询补打消费凭证信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_RePrintConsume() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询补打消费凭证信息（Card_Get_RePrintConsume）");
		String res_Card_Get_RePrintConsume= InterfaceBizHelper.Card_Get_RePrintConsume(InterFaceFinixxCardData.Card_Get_RePrintConsume());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_RePrintConsume(res_Card_Get_RePrintConsume);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.64	Card_Get_RePrintGift	查询补打换礼凭证信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_RePrintGift() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询补打换礼凭证信息（Card_Get_RePrintGift）");
		String res_Card_Get_RePrintGift= InterfaceBizHelper.Card_Get_RePrintGift(InterFaceFinixxCardData.Card_Get_RePrintGift());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_RePrintGift(res_Card_Get_RePrintGift);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.65	Card_AddMoney_WriteCard	更新充值写卡标识
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_AddMoney_WriteCard() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 更新充值写卡标识（Card_AddMoney_WriteCard）");
		String res_Card_AddMoney_WriteCard= InterfaceBizHelper.Card_AddMoney_WriteCard(InterFaceFinixxCardData.Card_AddMoney_WriteCard());
		result = InterFaceFinixxCardAssertion.TA_Card_AddMoney_WriteCard(res_Card_AddMoney_WriteCard);	
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.66	Card_Get_OldCardInfo 取旧卡信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_OldCardInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取旧卡信息（Card_Get_OldCardInfo）");
		String res_Card_Get_OldCardInfo= InterfaceBizHelper.Card_Get_OldCardInfo(InterFaceFinixxCardData.Card_Get_OldCardInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_OldCardInfo(res_Card_Get_OldCardInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.67	Card_Get_NewCardInfo 取新卡信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_NewCardInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取新卡信息（Card_Get_NewCardInfo）");
		String res_Card_Get_NewCardInfo= InterfaceBizHelper.Card_Get_NewCardInfo(InterFaceFinixxCardData.Card_Get_NewCardInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_NewCardInfo(res_Card_Get_NewCardInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.68	Card_Refund	会员卡退还操作
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Refund() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 会员卡退还操作（Card_Refund）");
		String res_Card_Refund= InterfaceBizHelper.Card_Refund(InterFaceFinixxCardData.Card_Refund());
		result = InterFaceFinixxCardAssertion.TA_Card_Refund(res_Card_Refund);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.69	Card_RefundRollback	会员卡退还回滚
	* @author hyc
	* @Time2016-04-28
	*/
	@Test(groups={"P0"})
	public void TC_Card_RefundRollback() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 会员卡退还回滚（Card_RefundRollback）");
		String res_Card_RefundRollback= InterfaceBizHelper.Card_RefundRollback(InterFaceFinixxCardData.Card_RefundRollback());
		result = InterFaceFinixxCardAssertion.TA_Card_RefundRollback(res_Card_RefundRollback);
		Assert.assertEquals(result,true);
	}	
	
	/**
	*2.6.70	Card_Get_ReSellInfo	取卡重发信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_ReSellInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取卡重发信息（Card_Get_ReSellInfo）");
		String res_Card_Get_ReSellInfo= InterfaceBizHelper.Card_Get_ReSellInfo(InterFaceFinixxCardData.Card_Get_ReSellInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_ReSellInfo(res_Card_Get_ReSellInfo);
		Assert.assertEquals(result,true);
	}
	
		
	/**
	*2.6.71	Card_Get_BatchAddInfo	取批量充值信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_BatchAddInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取批量充值信息（Card_Get_BatchAddInfo）");
		String res_Card_Get_BatchAddInfo= InterfaceBizHelper.Card_Get_BatchAddInfo(InterFaceFinixxCardData.Card_Get_BatchAddInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_BatchAddInfo(res_Card_Get_BatchAddInfo);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.72	Card_ReSell	卡重发
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_ReSell() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 卡重发（Card_ReSell）");
		String res_Card_ReSell= InterfaceBizHelper.Card_ReSell(InterFaceFinixxCardData.Card_ReSell());
		result = InterFaceFinixxCardAssertion.TA_Card_ReSell(res_Card_ReSell);
//		logger.info("[步骤_1]. 销卡（Card_Annul）");
//		String facadecd = CommonUntil.GetResellFacadeCD(res_Card_ReSell);
//		String res_Card_Annul= InterfaceBizHelper.Card_Annul(InterFaceFinixxCardData.Card_Annul(facadecd));
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.74	Card_GetEvents	获取会员活动
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetEvents() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员活动（Card_GetEvents）");
		String res_Card_GetEvents= InterfaceBizHelper.Card_GetEvents(InterFaceFinixxCardData.Card_GetEvents());
		result = InterFaceFinixxCardAssertion.TA_Card_GetEvents(res_Card_GetEvents);		
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.75	Card_AddEvents	增加会员活动
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_AddEvents() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 增加会员活动（Card_AddEvents）");
		String res_Card_AddEvents= InterfaceBizHelper.Card_AddEvents(InterFaceFinixxCardData.Card_AddEvents());
		result = InterFaceFinixxCardAssertion.TA_Card_AddEvents(res_Card_AddEvents);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.76	Card_DeleteEvents	删除会员活动	
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_DeleteEvents() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 增加会员活动（Card_AddEvents）");
		String res_Card_AddEvents= InterfaceBizHelper.Card_AddEvents(InterFaceFinixxCardData.Card_AddEvents());
		logger.info("[步骤_2]. 获取会员活动（Card_GetEvents）");
		String res_Card_GetEvents= InterfaceBizHelper.Card_GetEvents(InterFaceFinixxCardData.Card_GetEvents());
		logger.info("[步骤_3]. 删除会员活动（Card_DeleteEvents）");
		String Eventsno = CommonUntil.getEventsno(res_Card_GetEvents);
		String res_Card_DeleteEvents= InterfaceBizHelper.Card_DeleteEvents(InterFaceFinixxCardData.Card_DeleteEvents(Eventsno));
		result = InterFaceFinixxCardAssertion.TA_Card_DeleteEvents(res_Card_DeleteEvents);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.77	Card_WebSellGradeList	获取网上发卡等级列表
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_WebSellGradeList() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取网上发卡等级列表（Card_WebSellGradeList）");
		String res_Card_WebSellGradeList= InterfaceBizHelper.Card_WebSellGradeList(InterFaceFinixxCardData.Card_WebSellGradeList());
		result = InterFaceFinixxCardAssertion.TA_Card_WebSellGradeList(res_Card_WebSellGradeList);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.78	Card_WebSellInfo	获取网上会员卡发卡相关信息
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_WebSellInfo() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取网上会员卡发卡相关信息（Card_WebSellInfo）");
		String res_Card_WebSellInfo= InterfaceBizHelper.Card_WebSellInfo(InterFaceFinixxCardData.Card_WebSellInfo());
		result = InterFaceFinixxCardAssertion.TA_Card_WebSellInfo(res_Card_WebSellInfo);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.79	Card_ExchangeCCB	建行卡换卡后激活新卡
	* @author hyc
	* @Time2016-04-25
	*/
	@Test(groups={"P0"})
	public void TC_Card_ExchangeCCB() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员卡信息（Card_GetCardInfo）");
		String res_Card_GetCardInfo = InterfaceBizHelper.Card_GetCardInfo(InterFaceFinixxCardData.Card_GetCardInfo());
		logger.info("[步骤_2]. 建行卡换卡后激活新卡（Card_ExchangeCCB）");
		JSONObject CardInfo = CommonUntil.GetCardInfo(res_Card_GetCardInfo);
		String res_Card_ExchangeCCB= InterfaceBizHelper.Card_ExchangeCCB(InterFaceFinixxCardData.Card_ExchangeCCB(CardInfo));
		result = InterFaceFinixxCardAssertion.TA_Card_ExchangeCCB(res_Card_ExchangeCCB);
		Assert.assertEquals(result,true);
	}
		
	
	/**
	*2.6.80	Card_AddMoney_ID	获取充值流水号
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_AddMoney_ID() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取充值流水号（Card_AddMoney_ID）");
		String res_Card_AddMoney_ID= InterfaceBizHelper.Card_AddMoney_ID(InterFaceFinixxCardData.Card_AddMoney_ID());
		result = InterFaceFinixxCardAssertion.TA_Card_AddMoney_ID(res_Card_AddMoney_ID);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.81	Card_Get_WalletGiftType	取电子钱包赠品类型
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_WalletGiftType() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取电子钱包赠品类型（Card_Get_WalletGiftType）");
		String res_Card_Get_WalletGiftType= InterfaceBizHelper.Card_Get_WalletGiftType(InterFaceFinixxCardData.Card_Get_WalletGiftType());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_WalletGiftType(res_Card_Get_WalletGiftType);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.82	Card_Get_WalletVoucherGroup	取电子钱包可用券批次
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Get_WalletVoucherGroup() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取电子钱包可用券批次（Card_Get_WalletVoucherGroup）");
		String res_Card_Get_WalletVoucherGroup= InterfaceBizHelper.Card_Get_WalletVoucherGroup(InterFaceFinixxCardData.Card_Get_WalletVoucherGroup());
		result = InterFaceFinixxCardAssertion.TA_Card_Get_WalletVoucherGroup(res_Card_Get_WalletVoucherGroup);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.83	Card_ManuallyWallet	手动赠送电子钱包
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_ManuallyWallet() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 手动赠送电子钱包（Card_ManuallyWallet）");
		String res_Card_ManuallyWallet= InterfaceBizHelper.Card_ManuallyWallet(InterFaceFinixxCardData.Card_ManuallyWallet());
		result = InterFaceFinixxCardAssertion.TA_Card_ManuallyWallet(res_Card_ManuallyWallet);
		Assert.assertEquals(result,true);
	}
		
	
	/**
	*2.6.84	Card_Check_NoCardSell	检测无卡批量发卡卡号段
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_Check_NoCardSell() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 检测无卡批量发卡卡号段（Card_Check_NoCardSell）");
		String res_Card_Check_NoCardSell= InterfaceBizHelper.Card_Check_NoCardSell(InterFaceFinixxCardData.Card_Check_NoCardSell());
		result = InterFaceFinixxCardAssertion.TA_Card_Check_NoCardSell(res_Card_Check_NoCardSell);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.85	Card_RecoverWallet	电子钱包回收
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_RecoverWallet() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1].  查询电子钱包（Card_QueryWallet）");
		String res_Card_QueryWallet= InterfaceBizHelper.Card_QueryWallet(InterFaceFinixxCardData.Card_QueryWallet());
		logger.info("[步骤_1]. 电子钱包回收（Card_RecoverWallet）");
		String seqID = CommonUntil.getWalletseqID(res_Card_QueryWallet);
		String res_Card_RecoverWallet= InterfaceBizHelper.Card_RecoverWallet(InterFaceFinixxCardData.Card_RecoverWallet(seqID));
		result = InterFaceFinixxCardAssertion.TA_Card_RecoverWallet(res_Card_RecoverWallet);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.86	Card_GetCardGift	取积分兑换礼品
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetCardGift() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 取积分兑换礼品（Card_GetCardGift）");
		String res_Card_GetCardGift= InterfaceBizHelper.Card_GetCardGift(InterFaceFinixxCardData.Card_GetCardGift());
		result = InterFaceFinixxCardAssertion.TA_Card_GetCardGift(res_Card_GetCardGift);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.87 	Card_GiftExchange	礼品兑换
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GiftExchange() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 礼品兑换（Card_GiftExchange）");
		String res_Card_GiftExchange= InterfaceBizHelper.Card_GiftExchange(InterFaceFinixxCardData.Card_GiftExchange());
		result = InterFaceFinixxCardAssertion.TA_Card_GiftExchange(res_Card_GiftExchange);
		Assert.assertEquals(result,true);
	}
		
	@Test
	public void TC_Card_GiftExchange_DEBUG() throws InterruptedException {
		
		logger.info("[步骤_1]. 礼品兑换（Card_GiftExchange）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2093");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("sellLocationCD","681");
		data.put("webExchangeUser","681");
		data.put("webExchangeDate","681");
		data.put("exchangePlace","681");
		data.put("totalMarking","681");
		
		ArrayList giftListNodes = new  ArrayList();
		JSONObject GiftListNode = new JSONObject();
		GiftListNode.put("giftName","681");
		GiftListNode.put("giftID","681");
		GiftListNode.put("birthdayGift",false);
		GiftListNode.put("exchangeIntegral","681");
		GiftListNode.put("exchangeMoney","681");
		GiftListNode.put("exchangeAmount","681");
		GiftListNode.put("exchangeFlag",false);
		giftListNodes.add(GiftListNode);
		String res = InterfaceBizHelper.Card_GiftExchange(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
	
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.88	Card_QueryGiftExchange	查询卡礼品兑换记录
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryGiftExchange() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询卡礼品兑换记录（Card_QueryGiftExchange）");
		String res_Card_QueryGiftExchange= InterfaceBizHelper.Card_QueryGiftExchange(InterFaceFinixxCardData.Card_QueryGiftExchange());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryGiftExchange(res_Card_QueryGiftExchange);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.89	Card_QueryManuallyWallet	查询电子钱包批量赠送卡号
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryManuallyWallet() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询电子钱包批量赠送卡号（Card_QueryManuallyWallet）");
		String res_Card_QueryManuallyWallet= InterfaceBizHelper.Card_QueryManuallyWallet(InterFaceFinixxCardData.Card_QueryManuallyWallet());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryManuallyWallet(res_Card_QueryManuallyWallet);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.90	Card_ParmsSetting	会员通用设置
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_ParmsSetting() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 会员通用设置（Card_ParmsSetting）");
		String res_Card_ParmsSetting= InterfaceBizHelper.Card_ParmsSetting(InterFaceFinixxCardData.Card_ParmsSetting());
		result = InterFaceFinixxCardAssertion.TA_Card_ParmsSetting(res_Card_ParmsSetting);
		Assert.assertEquals(result,true);
	}
	
//	/**
//	*下发会员政策
//	* @author hyc
//	* @Time2016-04-25
//	*/
//	@Test(groups={"P0"})
//	public void TC_Card_SetCardPolicy() throws InterruptedException {
//		boolean result = false;
//		logger.info("[步骤_1]. 下发会员政策（Card_SetCardPolicy）");
//		String res_Card_SetCardPolicy= InterfaceBizHelper.Card_SetCardPolicy(InterFaceFinixxCardData.Card_SetCardPolicy());
//		result = InterFaceFinixxCardAssertion.TA_Card_SetCardPolicy(res_Card_SetCardPolicy);
//		Assert.assertEquals(result,true);
//	}
	
	/**
	*2.6.92	Card_UpdateBindingPolicy	下发会员卡绑卡政策和异步执行卡号订制
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_UpdateBindingPolicy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 下发会员卡绑卡政策和异步执行卡号订制（Card_UpdateBindingPolicy）");
		String res_Card_UpdateBindingPolicy= InterfaceBizHelper.Card_UpdateBindingPolicy(InterFaceFinixxCardData.Card_UpdateBindingPolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_UpdateBindingPolicy(res_Card_UpdateBindingPolicy);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.93	Card_GetOrderResult	根据批号查询下发结果
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetOrderResult() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 根据批号查询下发结果（Card_GetOrderResult）");
		String res_Card_GetOrderResult= InterfaceBizHelper.Card_GetOrderResult(InterFaceFinixxCardData.Card_GetOrderResult());
		result = InterFaceFinixxCardAssertion.TA_Card_GetOrderResult(res_Card_GetOrderResult);
		Assert.assertEquals(result,true);
	}
	
	/**
	*2.6.94	Card_GetBindingPolicy	根据批号获取下发绑卡政策明细
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetBindingPolicy() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 根据批号获取下发绑卡政策明细（Card_GetBindingPolicy）");
		String res_Card_GetBindingPolicy= InterfaceBizHelper.Card_GetBindingPolicy(InterFaceFinixxCardData.Card_GetBindingPolicy());
		result = InterFaceFinixxCardAssertion.TA_Card_GetBindingPolicy(res_Card_GetBindingPolicy);		
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.95	Card_QueryTicketBuyPage	获取会员卡售票消费的分页记录
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryTicketBuyPage() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员卡售票消费的分页记录（Card_QueryTicketBuyPage）");
		String res_Card_QueryTicketBuyPage= InterfaceBizHelper.Card_QueryTicketBuyPage(InterFaceFinixxCardData.Card_QueryTicketBuyPage());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryTicketBuyPage(res_Card_QueryTicketBuyPage);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.96	Card_GetCardBuyingPage	获取会员卡消费记录
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_GetCardBuyingPage() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 获取会员卡消费记录（Card_GetCardBuyingPage）");
		String res_Card_GetCardBuyingPage= InterfaceBizHelper.Card_GetCardBuyingPage(InterFaceFinixxCardData.Card_GetCardBuyingPage());
		result = InterFaceFinixxCardAssertion.TA_Card_GetCardBuyingPage(res_Card_GetCardBuyingPage);
		Assert.assertEquals(result,true);
	}
		
	/**
	*2.6.97	Card_QueryAddMoneyPage	查询充值记录
	* @author hyc
	* @Time2016-04-22
	*/
	@Test(groups={"P0"})
	public void TC_Card_QueryAddMoneyPage() throws InterruptedException {
		boolean result = false;
		logger.info("[步骤_1]. 查询充值记录（Card_QueryAddMoneyPage）");
		String res_Card_QueryAddMoneyPage= InterfaceBizHelper.Card_QueryAddMoneyPage(InterFaceFinixxCardData.Card_QueryAddMoneyPage());
		result = InterFaceFinixxCardAssertion.TA_Card_QueryAddMoneyPage(res_Card_QueryAddMoneyPage);	
		Assert.assertEquals(result,true);
	}
	

	@Test
	public void TC_Card_GetCardInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡信息（Card_GetCardInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2001");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
	
		//文档要求的
		data.put("cardLocationCd", "681");
		data.put("cardFacadeCd", "6811610000001");
		data.put("cardSerialNo", "6811610000001");
		String res = InterfaceBizHelper.Card_GetCardInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}

	@Test
	public void TC_Card_GetUsePolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡使用政策（Card_GetUsePolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2002");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("usePolicyId", "UPD00001");
		String res = InterfaceBizHelper.Card_GetUsePolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}

	@Test
	public void TC_Card_GetGradePolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡等级政策（Card_GetUsePolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2003");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("gradeld", "7");
		String res = InterfaceBizHelper.Card_GetGradePolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetLimitTickets_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡折扣票数（Card_GetLimitTickets）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2004");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd", "681");
		data.put("cardFacadeCd", "681");
		data.put("cardGradeId", "6");
		data.put("cardUsePolicyId", "681");
		data.put("showDate", "2016-01-01");
		data.put("showTime", "681");
		data.put("filmCd", "681");
		data.put("cinemaCd", "681");
		data.put("channelCd", "681");
		String res = InterfaceBizHelper.Card_GetLimitTickets(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Consume_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 会员卡消费（Card_Consume）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2005");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userId", "681");
		data.put("writeCardFlg", false);
		data.put("fingerFlg", false);
		data.put("channelCd", "681");
		
		ArrayList filmsInfo  = new ArrayList();
		
		JSONObject FilmInfoNode = new JSONObject();			
		FilmInfoNode.put("bookingId", "681");
		FilmInfoNode.put("session_RefSeqNo", "681");
		FilmInfoNode.put("throughFlg", "681");
		FilmInfoNode.put("sectionId", "681");
		FilmInfoNode.put("totalAmount", "681");
		FilmInfoNode.put("calculateMarkingMoney", "681");
		FilmInfoNode.put("calculatePerTicketTimes", "681");
		FilmInfoNode.put("totalDisSeats", "681");
		FilmInfoNode.put("totalSeats", "681");
		FilmInfoNode.put("totalConsumeMarking", "681");
		FilmInfoNode.put("remarks", "681");
		
		JSONObject posBooking = new JSONObject();
		posBooking.put("bookingId", "681");
		posBooking.put("totalAmount", "681");
		posBooking.put("totalConsumeMarking", "681");
		posBooking.put("remarks", "681");
		
		filmsInfo.add(FilmInfoNode);
		filmsInfo.add(posBooking);
		
		ArrayList wallet  = new ArrayList();
		JSONObject MemberCardWallet = new JSONObject();
		MemberCardWallet.put("walletItemSeqNo", "681");
		MemberCardWallet.put("useCount", "681");
		MemberCardWallet.put("bookingId", "681");
		MemberCardWallet.put("systemCd", "681");
		wallet.add("MemberCardWallet");
		
		data.put("cardLocationCd", "681");
		data.put("cardFacadeCd", "681");
		data.put("cardSerialNo", "681");
		String res = InterfaceBizHelper.Card_Consume(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}	
	
	@Test
	public void TC_Card_ConsumeRollback_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 会员卡购票消费回滚（Card_GetLimitTickets）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2006");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd", "681");
		data.put("cardFacadeCd", "681");
		
		ArrayList bookingIds = new  ArrayList();
		bookingIds.add("11");
		
		data.put("userId", "681");
		String res = InterfaceBizHelper.Card_ConsumeRollback(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetStateInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡状态描述（Card_GetStateInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2007");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetStateInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetCardBuying_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡消费记录（Card_GetCardBuying）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2008");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardFacadeCd","681");
		data.put("cardLocationCd","681");
		data.put("bookingId","681");
		String res = InterfaceBizHelper.Card_GetCardBuying(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPaymentType_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员付款方式（Card_GetPaymentType）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2009");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetPaymentType(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetCompany_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取公司名称（Card_GetCompany）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2010");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetCompany(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSales_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取业务员（Card_GetSales）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2011");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetSales(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSellInit_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取发卡权限（Card_GetSellInit）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2012");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetSellInit(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSoftDog_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 检测加密狗（Card_GetSoftDog）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2013");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardId","681");
		String res = InterfaceBizHelper.Card_GetSoftDog(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetReading_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取读卡需要的信息（Card_GetReading）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2014");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetReading(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSellInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡发卡相关信息（Card_GetSellInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2015");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("serialCD","681");
		data.put("icbcFlag","681");
		data.put("ccbFlag","681");
		String res = InterfaceBizHelper.Card_GetSellInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSellGroupID_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取团体卡发卡批次号（Card_GetSellGroupID）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2016");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetSellGroupID(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Sell_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 发卡（Card_Sell）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2017");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("beginFacadeCD","681");
		data.put("endFacadeCD","681");
		data.put("noCardBatchFlag",false);
		data.put("noCardBatchType","681");
		data.put("serialCD","681");
		data.put("icbcflag","681");
		data.put("ccbflag","681");
		data.put("ccbreplace","681");
		data.put("groupFlag","681");
		data.put("groupCD","681");
		data.put("paymentTypeFee","681");
		data.put("paymentNameFee","681");
		data.put("paymentTypeAdd","681");
		data.put("paymentNameAdd","681");
		data.put("paymentNO","681");
		data.put("addMoney","681");
		data.put("fee","681");
		data.put("membershipFee","681");
		data.put("parValue","681");
		data.put("companyCD","681");
		data.put("salesCD","681");
		data.put("paySalesCD","681");
		data.put("billNO","681");
		data.put("workstation","681");
		data.put("saleSpeed","681");
		data.put("module","681");
		data.put("valid","681");
		data.put("memberName","681");
		data.put("documentType","681");
		data.put("documentNO","681");
		data.put("userPassword","681");
		data.put("mobile","681");
		data.put("birthday","681");
		data.put("email","681");
		data.put("address","681");
		data.put("postCode","681");
		data.put("sellExplanation","681");
		data.put("phone","681");
		data.put("sex","681");
		data.put("nation","681");
		data.put("nativePlace","681");
		data.put("photoFlag",false);
		data.put("photo","681");
		data.put("invoiceNumber","681");
		data.put("writeShiftFlag",false);
		data.put("addMoneyID","681");
		data.put("creditCardNum","681");
		data.put("channelCD","681");
		
		
		String res = InterfaceBizHelper.Card_Sell(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_AddMoney_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 卡充值（Card_AddMoney）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2018");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("beginFacadeCD","681");
		data.put("endFacadeCD","681");
		data.put("companyCD","681");
		data.put("addMoney","681");
		data.put("sellLocationCD","681");
		data.put("addLocationCD","681");
		data.put("paymentType","681");
		data.put("paymentName","681");
		data.put("addModule","681");
		data.put("discount","681");
		data.put("paymentNO","681");
		data.put("fingerFlag","681");
		data.put("batchAdd",false);
		data.put("batchMode","681");
		data.put("salesCD","681");
		data.put("billNO","681");
		data.put("workstation","681");
		data.put("saleSpeed","681");
		data.put("addReason","681");
		data.put("invoiceNumber","681");
		data.put("writeShiftFlag",false);
		data.put("addMoneyID","681");
		String res = InterfaceBizHelper.Card_AddMoney(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetSummaryInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  取会员资料(会员概要信息)（Card_GetSummaryInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2019");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("serialCD","681");
		data.put("queryByFacadeCD",false);
		data.put("sellLocationCD","681");
		data.put("memberName","681");
		data.put("documentNO","681");
		data.put("mobilePhone","681");
		data.put("noPreInfo",false);
		data.put("queryCenterPolicy",false);		
		String res = InterfaceBizHelper.Card_GetSummaryInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPrefabricateUsePolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  获取使用政策列表（Card_GetPrefabricateUsePolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2020");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的		
		String res = InterfaceBizHelper.Card_GetPrefabricateUsePolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPrefabricateGrade_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  获取等级政策列表（Card_GetPrefabricateGrade）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2021");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的		
		String res = InterfaceBizHelper.Card_GetPrefabricateGrade(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPrefabricateTradePolicyHdrs_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  获取购票积分政策概要列表（Card_GetPrefabricateTradePolicyHdrs）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2022");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的		
		String res = InterfaceBizHelper.Card_GetPrefabricateTradePolicyHdrs(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPrefabricateOrdersList_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  获取可用的订制单号（Card_GetPrefabricateOrdersList）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2023");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("preFlag",false);
		String res = InterfaceBizHelper.Card_GetPrefabricateOrdersList(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_OrdersByOrderCD_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  根据订制单号取可用的预制卡号（Card_OrdersByOrderCD）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2024");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardOrdersByOrderCd","681");
		data.put("preFlag",false);
		String res = InterfaceBizHelper.Card_OrdersByOrderCD(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Prefabricate_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  卡预制（Card_Prefabricate）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2025");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		ArrayList<JSONObject> cardPrefabricateList = new ArrayList<JSONObject>();
		JSONObject CardPrefabricateNode = new JSONObject();
		CardPrefabricateNode.put("facadeCD","201230098130");
		CardPrefabricateNode.put("serialCD","201230098131");
		cardPrefabricateList.add(CardPrefabricateNode);
		data.put("cardPrefabricateList",cardPrefabricateList);
		data.put("type",TestData.FindValueInVariablesByFile("type","CardTestData.xml"));
		data.put("cardFaceFee",0);
		data.put("usePloicyID","1");
		data.put("flow",TestData.FindValueInVariablesByFile("flow","CardTestData.xml"));
		data.put("flowDescription","aa");
		data.put("gradePolicyID","1");
		data.put("specialID","01");
		data.put("levelForeverFlag",false);
		data.put("defaultMarking",0);
		data.put("meDium",TestData.FindValueInVariablesByFile("meDium","CardTestData.xml"));
		data.put("userId","ADMIN");
		data.put("rePrefabricateFlag",false);
		data.put("upGradeType","03");
		String res = InterfaceBizHelper.Card_Prefabricate(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryTicketBuy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询售票消费记录（Card_QueryTicketBuy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2026");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryTicketBuy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryTicketBuyDiscount_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询打折卡消费记录（Card_QueryTicketBuyDiscount）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2027");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryTicketBuyDiscount(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryPosBuy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询卖品记录（Card_QueryPosBuy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2028");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryPosBuy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryAddMoney_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询充值记录（Card_QueryAddMoney）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2029");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryAddMoney(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryTransfer_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询转账记录（Card_QueryTransfer）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2030");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryTransfer(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryMarking_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询积分获取记录（Card_QueryMarking）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2031");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryMarking(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryExchange_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询换购记录（Card_QueryExchange）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2032");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryExchange(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryOtherSystemsConsume_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询其它系统导入记录（Card_QueryOtherSystemsConsume）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2033");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryOtherSystemsConsume(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryEditMemberInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询修改会员资料记录（Card_QueryEditMemberInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2034");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryEditMemberInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	
	
	@Test
	public void TC_Card_QueryWallet_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  查询电子钱包（Card_QueryWallet）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2035");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_QueryWallet(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ConsumeIntegral_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  会员积分消费（Card_ConsumeIntegral）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2036");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("op","681");
		data.put("systemCd","681");
		data.put("userId","681");
		data.put("remarks","681");
		
		ArrayList filmsInfo = new ArrayList();
		
		JSONObject FilmInfoNode = new JSONObject();
		FilmInfoNode.put("totalAmount","681");
		FilmInfoNode.put("totalMarking","681");
		FilmInfoNode.put("bookingId","681");
		
		JSONObject posInfo = new JSONObject();
		posInfo.put("bookingId","681");
		posInfo.put("totalAmount","681");
		posInfo.put("totalMarking","681");
		
		filmsInfo.add(FilmInfoNode);
		filmsInfo.add(posInfo);
		

		data.put("cardLocationCd","681");
		data.put("cardFacadeCd","681");
		data.put("cardSerialNo","681");
		String res = InterfaceBizHelper.Card_ConsumeIntegral(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ConsumeIntegralRollback_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  会员积分消费回滚（Card_ConsumeIntegralRollback）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2037");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("op","681");
		data.put("userId","681");
		
		ArrayList bookingIds = new ArrayList();
		bookingIds.add("111");
		data.put("cardLocationCd","681");
		data.put("cardFacadeCd","681");
		String res = InterfaceBizHelper.Card_ConsumeIntegralRollback(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ChenkIDCardSameSerial_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  预制芯片号与卡号相同的ID卡权限（Card_ChenkIDCardSameSerial）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2038");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_ChenkIDCardSameSerial(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Order_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.  卡订制（Card_Order）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2039");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		ArrayList cardOrderList = new ArrayList();
		JSONObject CardOrderNode = new JSONObject();
		CardOrderNode.put("formCD", "2039");
		CardOrderNode.put("beginFacadeCD", "2039");
		CardOrderNode.put("endFacadeCD", "2039");
		CardOrderNode.put("locationCD", "2039");
		CardOrderNode.put("remark", "2039");
		CardOrderNode.put("totalCount", "2039");
		CardOrderNode.put("description", "2039");
		CardOrderNode.put("jumpNumberFlag", false);
		CardOrderNode.put("jumpFinalNumberFlag", false);		
		ArrayList jumpNumber = new ArrayList(); 
		CardOrderNode.put("jumpNumber", "2039");
		cardOrderList.add(CardOrderNode);
		data.put("creatUserId", "2039");
		String res = InterfaceBizHelper.Card_Order(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_CheckOrderFacadeCdIsUse_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.检测卡号段中是否有卡号已订制（Card_CheckOrderFacadeCdIsUse）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2041");
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("beginFacadeCD", "2039");
		data.put("endFacadeCD", "2039");
		String res = InterfaceBizHelper.Card_CheckOrderFacadeCdIsUse(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_CardReportloss_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.报失（Card_CardReportloss）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2042");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2039");
		data.put("facadeCD", "2039");
		data.put("type", "2039");
		data.put("menberUserName", "2039");
		data.put("telphone", "2039");
		data.put("documentNO", "2039");
		data.put("reportLossLocationCD", "2039");
		data.put("sellLocationCD", "2039");
		String res = InterfaceBizHelper.Card_CardReportloss(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_CardCancelloss_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1.取消报失（Card_CardCancelloss）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2043");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2039");
		data.put("facadeCD", "2039");
		data.put("cancelLossLocationCD", "2039");
		data.put("sellLocationCD", "2039");
		String res = InterfaceBizHelper.Card_CardCancelloss(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_CardActivation_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 卡激活（Card_CardActivation）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2044");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2039");
		data.put("facadeCD", "2039");
		data.put("cardType", "2039");
		data.put("reason", "2039");
		data.put("balance", "2039");
		data.put("memberFee", "2039");
		data.put("paymentType", "2039");
		data.put("paymentName", "2039");
		data.put("salesCD", "2039");
		data.put("billNO", "2039");
		data.put("invalidationDate", "2039");
		data.put("discount", "2039");
		data.put("activationType", "2039");
		data.put("cardLocationCD", "2039");
		data.put("writeShiftFlag", false);
		String res = InterfaceBizHelper.Card_CardActivation(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_OrderGetSerialNumber_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取订制可用卡号后半段（Card_OrderGetSerialNumber）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2045");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_OrderGetSerialNumber(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_CardExchange_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 换卡（Card_CardExchange）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2046");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("newGradeID", "2046");
		data.put("newUsePolicyID", "2046");
		data.put("newCardType", "2046");
		data.put("newConsumePolicyID", "2046");
		data.put("writeShiftFlag", false);
		
		JSONObject CardReplacingNode = new JSONObject();
		CardReplacingNode.put("oldFacadeCD", "2046");
		CardReplacingNode.put("oldCardType", "2046");
		CardReplacingNode.put("balance", "2046");
		CardReplacingNode.put("cumulationMarking", "2046");
		CardReplacingNode.put("tradeMarking", "2046");
		CardReplacingNode.put("upgradeMarking", "2046");
		CardReplacingNode.put("newFacadeCD", "2046");
		CardReplacingNode.put("newCardType", "2046");
		CardReplacingNode.put("upgradeFlag", false);
		CardReplacingNode.put("feeMarkingFlag", false);
		CardReplacingNode.put("feeMarking", "2046");
		CardReplacingNode.put("locationCD", "2046");
		CardReplacingNode.put("oldSellLocationCD", "2046");
		CardReplacingNode.put("reason", "2046");
		
		JSONObject CardSell = new JSONObject();
		CardSell.put("userID", "2046");
		CardSell.put("beginFacadeCD", "2046");
		CardSell.put("endFacadeCD", "2046");
		CardSell.put("noCardBatchFlag", "2046");
		CardSell.put("noCardBatchType", "2046");
		CardSell.put("serialCD", "2046");
		CardSell.put("icbcflag", "2046");
		CardSell.put("ccbflag", "2046");
		CardSell.put("ccbreplace", "2046");
		CardSell.put("groupFlag", "2046");
		CardSell.put("groupCD", "2046");
		CardSell.put("paymentTypeFee", "2046");
		CardSell.put("paymentNameFee", "2046");
		CardSell.put("paymentTypeAdd", "2046");
		CardSell.put("paymentNameAdd", "2046");
		CardSell.put("paymentNO", "2046");
		CardSell.put("addMoney", "2046");
		CardSell.put("fee", "2046");
		CardSell.put("membershipFee", "2046");
		CardSell.put("parValue", "2046");
		CardSell.put("companyCD", "2046");
		CardSell.put("salesCD", "2046");
		CardSell.put("paySalesCD", "2046");
		CardSell.put("billNO", "2046");
		CardSell.put("workstation", "2046");
		CardSell.put("saleSpeed", "2046");
		CardSell.put("module", "2046");
		CardSell.put("valid", "2046");
		CardSell.put("memberName", "2046");
		CardSell.put("documentType", "2046");
		CardSell.put("documentNO", "2046");
		CardSell.put("userPassword", "2046");
		CardSell.put("mobile", "2046");
		CardSell.put("birthday", "2046");
		CardSell.put("email", "2046");
		CardSell.put("address", "2046");
		CardSell.put("postCode", "2046");
		CardSell.put("sellExplanation", "2046");
		CardSell.put("phone", "2046");
		CardSell.put("sex", "2046");
		CardSell.put("nation", "2046");
		CardSell.put("nativePlace", "2046");
		CardSell.put("photoFlag", "2046");
		CardSell.put("photo", "2046");
		CardSell.put("invoiceNumber", "2046");
		CardSell.put("writeShiftFlag", false);
		CardSell.put("addMoneyID", "2046");	
		
		String res = InterfaceBizHelper.Card_CardExchange(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_EditMemberInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 修改会员资料（Card_EditMemberInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2047");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2046");
		data.put("facadeCD", "2046");
		data.put("sellLocationCD", "2046");
		data.put("memberID", "2046");
		data.put("memberName", "2046");
		data.put("documentType", "2046");
		data.put("documentNO", "2046");
		data.put("address", "2046");
		data.put("postCode", "2046");
		data.put("mobilePhone", "2046");
		data.put("birthDate", "2046");
		data.put("mailAddress", "2046");
		data.put("phone", "2046");
		data.put("sex", "2046");
		data.put("nation", "2046");
		data.put("nativePlace", "2046");
		data.put("needNews", "2046");
		data.put("editPhotoFlag", false);
		data.put("photo", "2046");
		String res = InterfaceBizHelper.Card_EditMemberInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ResetPassword_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 修改重设密码（Card_ResetPassword）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2048");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2046");
		data.put("facadeCD", "2046");
		data.put("sellLocationCD", "2046");
		data.put("oldPassword", "2046");
		data.put("newPassWord", "2046");
		data.put("operate", "2046");
		data.put("documentNO", "2046");
		String res = InterfaceBizHelper.Card_ResetPassword(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_UMEImportPre_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. UME新卡导入（Card_UMEImportPre）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2049");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID", "2046");
		data.put("beginFacadeCD", "2046");
		data.put("endFacadeCD", "2046");
		data.put("tradePolicyID", "2046");
		data.put("flow", "2046");
		data.put("flowDescription", "2046");
		String res = InterfaceBizHelper.Card_UMEImportPre(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetMemberInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取会员资料（Card_GetMemberInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2050");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("sellLocationCd", "2046");
		data.put("facadeCD", "2046");
		data.put("memberID", "2046");
		String res = InterfaceBizHelper.Card_GetMemberInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetPrefabricateInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取预制信息（Card_GetPrefabricateInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2051");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("queryMode", "2046");
		data.put("facadeCD", "2046");
		data.put("serialCD", "2046");
		String res = InterfaceBizHelper.Card_GetPrefabricateInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_PrefabricateEdit_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 修改预制错误（Card_PrefabricateEdit）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2052");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("serialCD", "2046");
		data.put("cardType", "2046");
		data.put("cardFaceFee", "2046");
		data.put("usePloicyID", "2046");
		data.put("consumePolicyID", "2046");
		data.put("flow", "2046");
		data.put("flowDescription", "2046");
		data.put("gradePolicyID", "2046");
		data.put("specialID", "2046");
		data.put("levelForeverFlag", false);
		data.put("defaultMarking", "2046");
		data.put("meDium", "2046");
		data.put("userID", "2046");
		data.put("oldFacadeCD", "2046");
		String res = InterfaceBizHelper.Card_PrefabricateEdit(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryOrder_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 订制查询（Card_QueryOrder）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2053");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("formCD", "2046");
		data.put("queryMode", "2046");
		String res = InterfaceBizHelper.Card_QueryOrder(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryPrefabricate_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 预制查询（Card_QueryPrefabricate）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2054");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("formCD", "2046");
		data.put("queryMode", "2046");
		String res = InterfaceBizHelper.Card_QueryPrefabricate(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Cancel_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 退卡（Card_Cancel）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2055");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("userID", "2046");
		data.put("cardType", "2046");
		data.put("balance", "2046");
		data.put("refundBalance", "2046");
		data.put("refundFee", "2046");
		data.put("paymentType", "2046");
		data.put("paymentName", "2046");
		data.put("salesCD", "2046");
		data.put("billNO", "2046");
		data.put("reason", "2046");
		data.put("roleID", "2046");
		data.put("sellLocationCD", "2046");
		data.put("writeShiftFlag", false);
		String res = InterfaceBizHelper.Card_Cancel(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Annul_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 销卡（Card_Annul）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2056");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("userID", "2046");
		data.put("memberID", "2046");
		data.put("refund", "2046");
		data.put("paymentType", "2046");
		data.put("paymentName", "2046");
		data.put("salesCD", "2046");
		data.put("billNO", "2046");
		data.put("reason", "2046");
		data.put("memcCreateUserID", "2046");
		data.put("memcCreateUserDate", "2046");
		data.put("sellLocationCD", "2046");
		data.put("writeShiftFlag", false);
		String res = InterfaceBizHelper.Card_Annul(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_EditPolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 修改积分政策（Card_EditPolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2057");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD", "2046");
		data.put("userID", "2046");
		data.put("oldCumulationMarking", "2046");
		data.put("oldTradeMarking", "2046");
		data.put("oldUpgradeMarking", "2046");
		data.put("oldConsumeUpgradeTM", "2046");
		data.put("oldFirstDate", "2046");
		data.put("oldLastDate", "2046");
		data.put("oldInvalidationDate", "2046");
		data.put("oldGradeID", "2046");
		data.put("oldLevelForeverFlag", false);
		data.put("sellLocationCD", "2046");
		data.put("oldUsePolicyID", "2046");
		data.put("oldConsumePolicyID", "2046");	
		data.put("newCumulationMarking", "2046");	
		data.put("newTradeMarking", "2046");	
		data.put("newUpgradeMarking", "2046");	
		data.put("newConsumeUpgradeTM", "2046");	
		data.put("newFirstDate", "2046");	
		data.put("newLastDate", "2046");	
		data.put("newInvalidationDate", "2046");	
		data.put("newGradeID", "2046");	
		data.put("newLevelForeverFlag", false);	
		data.put("newUsePolicyID", "2046");	
		data.put("newConsumePolicyID", "2046");	
		String res = InterfaceBizHelper.Card_EditPolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GLOBALSYS_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员系统设置信息政策（Card_GLOBALSYS）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2058");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GLOBALSYS(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_TransferList_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取转账列表（Card_Get_TransferList）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2059");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("outFacadeCD","681");
		data.put("gradeID","681");
		String res = InterfaceBizHelper.Card_Get_TransferList(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Transfer_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 卡转账（Card_Transfer）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2060");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("outFacadeCD","681");
		data.put("userID","681");
		data.put("outSellLocationCD","681");
		data.put("transferMoney","681");
		data.put("transferTradeMarking","681");
		data.put("transferUpgradeMarking","681");
		data.put("transferType","681");
		data.put("inFacadeCD","681");
		data.put("inSellLocationCD","681");
		data.put("inGradeID","681");
		data.put("fillZero",false);
		data.put("outHandInput",false);	
		data.put("inHandInput",false);
		String res = InterfaceBizHelper.Card_Transfer(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_RePrintSell_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询补打发卡凭证信息（Card_Get_RePrintSell）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2061");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("queryMode","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		String res = InterfaceBizHelper.Card_Get_RePrintSell(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_RePRintAdd_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询补打充值凭证信息（Card_Get_RePRintAdd）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2062");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("queryMode","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		String res = InterfaceBizHelper.Card_Get_RePRintAdd(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Update_Add_PrintTimes_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 更新充值凭证打印次数（Card_Update_Add_PrintTimes）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2063");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("addSeqID","681");
		data.put("printTimes","681");
		data.put("userID","681");
		String res = InterfaceBizHelper.Card_Update_Add_PrintTimes(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_RePrintConsume_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询补打消费凭证信息（Card_Get_RePrintConsume）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2064");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("queryMode","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		String res = InterfaceBizHelper.Card_Get_RePrintConsume(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_RePrintGift_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询补打换礼凭证信息（Card_Get_RePrintGift）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2065");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("queryMode","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		String res = InterfaceBizHelper.Card_Get_RePrintGift(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_AddMoney_WriteCard_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 更新充值写卡标识（Card_AddMoney_WriteCard）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2066");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("addID","681");
		data.put("addLocationCD","681");
		String res = InterfaceBizHelper.Card_AddMoney_WriteCard(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_OldCardInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取旧卡信息（Card_Get_OldCardInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2067");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_Get_OldCardInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_NewCardInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取新卡信息（Card_Get_NewCardInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2068");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		String res = InterfaceBizHelper.Card_Get_NewCardInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Refund_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 会员卡退还操作（Card_Refund）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2069");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userId","681");
		data.put("writeCardFlg",false);
		data.put("fingerFlg",false);
		data.put("channelCd","681");
		
		JSONObject posBooking = new JSONObject();
		posBooking.put("RefundBookingId","681");
		posBooking.put("bookingId","681");
		posBooking.put("totalAmount","681");
		posBooking.put("totalConsumeMarking","681");
		posBooking.put("remarks","681");
		
		ArrayList wallet = new ArrayList();
		JSONObject MemberCardWallet = new JSONObject();
		MemberCardWallet.put("walletItemSeqNo","681");
		MemberCardWallet.put("useCount","681");
		MemberCardWallet.put("bookingId","681");
		MemberCardWallet.put("systemCd","681");
		wallet.add(MemberCardWallet);
		
		data.put("cardLocationCd","681");
		data.put("cardFacadeCd","681");
		data.put("cardSerialNo","681");
		String res = InterfaceBizHelper.Card_Refund(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_RefundRollback_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 会员卡退还回滚（Card_RefundRollback）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2070");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		ArrayList bookingIds = new ArrayList();
		bookingIds.add("111111");
		data.put("userId","681");
		data.put("cardLocationCd","681");
		data.put("cardFacadeCd","681");
		data.put("cardSerialNo","681");		
		String res = InterfaceBizHelper.Card_RefundRollback(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_ReSellInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取卡重发信息（Card_Get_ReSellInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2071");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("serialCD","681");	
		String res = InterfaceBizHelper.Card_Get_ReSellInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_BatchAddInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取批量充值信息（Card_Get_BatchAddInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2072");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("beginFacadeCD","681");
		data.put("endFacadeCD","681");	
		data.put("companyCD","681");
		data.put("queryMode","681");
		String res = InterfaceBizHelper.Card_Get_BatchAddInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ReSell_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 卡重发（Card_ReSell）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2073");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("serialCD","681");	
		data.put("userID","681");
		data.put("medium","681");
		data.put("sellLocationCD","681");
		data.put("workstation","681");
		data.put("memberID","681");
		data.put("userPassword","681");
		data.put("memberName","681");
		data.put("documentType","681");
		data.put("documentNO","681");
		data.put("address","681");
		data.put("postCode","681");
		data.put("mobilePhone","681");
		data.put("birthDate","681");
		data.put("mailAddress","681");
		data.put("phone","681");
		data.put("sex","681");
		data.put("nation","681");
		data.put("nativePlace","681");
		data.put("needNews","681");
		String res = InterfaceBizHelper.Card_ReSell(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetEvents_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员活动（Card_GetEvents）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2080");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("cardLocationCd","681");	
		String res = InterfaceBizHelper.Card_GetEvents(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_AddEvents_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 增加会员活动（Card_AddEvents）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2081");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("cardLocationCd","681");
		data.put("event","681");
		data.put("approvalUserId","681");
		data.put("userId","681");
		String res = InterfaceBizHelper.Card_AddEvents(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_DeleteEvents_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 删除会员活动（Card_DeleteEvents）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2082");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("no","681");
		data.put("cardLocationCd","681");
		data.put("userId","681");
		String res = InterfaceBizHelper.Card_DeleteEvents(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_WebSellGradeList_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取网上发卡等级列表（Card_WebSellGradeList）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2083");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_WebSellGradeList(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_WebSellInfo_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取网上会员卡发卡相关信息（Card_WebSellInfo）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2084");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("gradeID","681");
		String res = InterfaceBizHelper.Card_WebSellInfo(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ExchangeCCB_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 建行卡换卡后激活新卡（Card_ExchangeCCB）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2085");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("facadeCD","681");
		data.put("replaceFlagOld","681");
		data.put("replaceFlagNew","681");
		data.put("balance","681");
		data.put("cumulationMarking","681");
		data.put("tradeMarking","681");
		data.put("upgradeMarking","681");
		data.put("sellLocationCD","681");
		String res = InterfaceBizHelper.Card_ExchangeCCB(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_AddMoney_ID_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取充值流水号（Card_AddMoney_ID）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2086");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_AddMoney_ID(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_WalletGiftType_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取电子钱包赠品类型（Card_Get_WalletGiftType）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2087");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_Get_WalletGiftType(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Get_WalletVoucherGroup_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取电子钱包可用券批次（Card_Get_WalletVoucherGroup）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2088");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_Get_WalletVoucherGroup(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ManuallyWallet_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 手动赠送电子钱包（Card_ManuallyWallet）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2089");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("manuallyType","681");
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		data.put("giftType","681");
		data.put("giftNo","681");
		data.put("giftName","681");
		data.put("giftMoney","681");
		data.put("giftCount","681");
		data.put("validityDate","681");
		data.put("endFacadeCD","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		data.put("gradeID","681");
		data.put("module","681");
		String res = InterfaceBizHelper.Card_ManuallyWallet(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_Check_NoCardSell_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 检测无卡批量发卡卡号段（Card_Check_NoCardSell）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2090");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("beginFacadeCD","681");
		data.put("endFacadeCD","681");
		data.put("noCardBatchType","681");
		String res = InterfaceBizHelper.Card_Check_NoCardSell(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_RecoverWallet_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 电子钱包回收（Card_RecoverWallet）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2091");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("userID","681");
		data.put("facadeCD","681");
		data.put("sellLocationCD","681");
		ArrayList seqID = new ArrayList();
		seqID.add("681");
		String res = InterfaceBizHelper.Card_RecoverWallet(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetCardGift_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 取积分兑换礼品（Card_GetCardGift）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2092");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_GetCardGift(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
//	@Test
//	public void TC_Card_GiftExchange_DEBUG() throws InterruptedException {
//		logger.warn("****开始执行用例****");
//		logger.info("步骤_1. 礼品兑换（Card_GiftExchange）");
//		JSONObject data = new JSONObject();
//		//固定的
//		data.put("code", "2093");	
//		data.put("version", "1.0.0.0");
//		data.put("serialNumber","635954467784333968");
//		data.put("userName","BO");
//		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
//		data.put("locationcd","681");
//		
//		//文档要求的
//		data.put("userID","681");
//		data.put("facadeCD","681");
//		data.put("sellLocationCD","681");
//		data.put("sellLocationCD","681");
//		data.put("webExchangeUser","681");
//		data.put("webExchangeDate","681");
//		data.put("exchangePlace","681");
//		data.put("totalMarking","681");
//		
//		ArrayList giftListNodes = new  ArrayList();
//		JSONObject GiftListNode = new JSONObject();
//		GiftListNode.put("giftName","681");
//		GiftListNode.put("giftID","681");
//		GiftListNode.put("birthdayGift",false);
//		GiftListNode.put("exchangeIntegral","681");
//		GiftListNode.put("exchangeMoney","681");
//		GiftListNode.put("exchangeAmount","681");
//		GiftListNode.put("exchangeFlag",false);
//		giftListNodes.add(GiftListNode);
//		String res = InterfaceBizHelper.Card_GiftExchange(data);
//		// 检查返回是否如预期
//		logger.info("检查点_1. 检查返回内容是否为空");
//		boolean result = false;
//		if(!res.isEmpty())	
//		{
//			result = true;
//		}
//		logger.warn("****用例执行结束****");
//		Assert.assertEquals(result,true);
//	}
	
	@Test
	public void TC_Card_QueryGiftExchange_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询卡礼品兑换记录（Card_QueryGiftExchange）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2094");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("facadeCD","681");
		data.put("queryLocationCD","681");
		String res = InterfaceBizHelper.Card_QueryGiftExchange(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryManuallyWallet_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询电子钱包批量赠送卡号（Card_QueryManuallyWallet）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2095");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("manuallyType","681");
		data.put("beginFacadeCD","681");
		data.put("endFacadeCD","681");
		data.put("beginDate","681");
		data.put("endDate","681");
		data.put("gradeID","681");
		String res = InterfaceBizHelper.Card_QueryManuallyWallet(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_ParmsSetting_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 会员通用设置（Card_ParmsSetting）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2201");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		String res = InterfaceBizHelper.Card_ParmsSetting(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_UpdateBindingPolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 下发会员卡绑卡政策和异步执行卡号订制（Card_UpdateBindingPolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2117");	
		data.put("version", "1.0.13.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("BindindPolicyList","681");
		data.put("CardBindingPolicyInfo","681");
		data.put("LocationCd","681");
		data.put("OrderCD","681");
		data.put("BeginFacadeCD","681");
		data.put("EndFacadeCD","681");
		data.put("Remark","681");
		data.put("TotalCount","681");
		data.put("Description","681");
		data.put("JumpNumberFlag","681");
		data.put("JumpFinalNumberFlag","681");
		data.put("JumpNumber","681");
		data.put("CardPolicyGradeList","681");
		data.put("PolicyGradeCD","681");
		data.put("CardPolicyUseList","681");
		data.put("PolicyUseCD","681");
		data.put("CardPolicyTradeList","681");
		data.put("PolicyTradeCD","681");
		data.put("RepeatFacadeList","681");
		data.put("RepeatFacadeCD","681");
		String res = InterfaceBizHelper.Card_UpdateBindingPolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetOrderResult_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 根据批号查询下发结果（Card_GetOrderResult）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2118");	
		data.put("version", "1.0.13.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("FormCD","681");
		String res = InterfaceBizHelper.Card_GetOrderResult(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetBindingPolicy_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 根据批号获取下发绑卡政策明细（Card_GetBindingPolicy）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2119");	
		data.put("version", "1.0.13.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("FormCD","681");
		String res = InterfaceBizHelper.Card_GetBindingPolicy(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryTicketBuyPage_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡售票消费的分页记录（Card_QueryTicketBuyPage）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2122");	
		data.put("version", "1.0.13.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("FacadeCD","681");
		data.put("CardLocationCd","681");
		data.put("Page","681");
		data.put("PageIndex","681");
		data.put("PageSize","681");
		String res = InterfaceBizHelper.Card_QueryTicketBuyPage(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_GetCardBuyingPage_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 获取会员卡消费记录（Card_GetCardBuyingPage）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2123");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardFacadeCd","681");
		data.put("cardLocationCd","681");
		data.put("bookingId","681");
		data.put("thirdId","681");
		data.put("Page","681");
		data.put("PageIndex","681");
		data.put("PageSize","681");
		String res = InterfaceBizHelper.Card_GetCardBuyingPage(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
	
	@Test
	public void TC_Card_QueryAddMoneyPage_DEBUG() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("步骤_1. 查询充值记录（Card_QueryAddMoneyPage）");
		JSONObject data = new JSONObject();
		//固定的
		data.put("code", "2124");	
		data.put("version", "1.0.0.0");
		data.put("serialNumber","635954467784333968");
		data.put("userName","BO");
		data.put("password","9C4876E4C86A6248472BA13A3584E9C8");
		data.put("locationcd","681");
		
		//文档要求的
		data.put("cardLocationCd","681");
		data.put("facadeCD","681");
		data.put("Page","681");
		data.put("PageIndex","681");
		data.put("PageSize","681");
		String res = InterfaceBizHelper.Card_QueryAddMoneyPage(data);
		// 检查返回是否如预期
		logger.info("检查点_1. 检查返回内容是否为空");
		boolean result = false;
		if(!res.isEmpty())	
		{
			result = true;	
		}
		logger.warn("****用例执行结束****");
		Assert.assertEquals(result,true);
	}
}

