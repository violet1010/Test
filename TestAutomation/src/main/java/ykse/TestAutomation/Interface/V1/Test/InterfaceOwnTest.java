package ykse.TestAutomation.Interface.V1.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import ykse.TestAutomation.Common.*;
import ykse.TestAutomation.Interface.V1.Common.InterfaceBizHelper;
import ykse.TestAutomation.Interface.V1.Common.TestData;

public class InterfaceOwnTest {
	
	Logger logger = new Log("interface_v1").logger;
	
	@BeforeClass
	public static void setUp() throws Exception {

	}

	@AfterClass
	public static void tearDown() throws Exception {
		// driver.close();
	}

	@Test
	public void TC_queryCinemas() throws InterruptedException {
		JSONObject data = new JSONObject();
		logger.warn("****开始执行用例****");
		logger.info("[步骤_1]. 请求查询影院列表接口");
		String res = InterfaceBizHelper.queryCinemas(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为test");
		String xxx = TestData.FindContent("loginId");
		logger.warn(xxx);
		logger.warn("****用例执行结束****");
		Assert.assertEquals(res, "test");
	}

	@Test
	public void TC_queryCinemas_twice() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("[步骤_1]. 请求查询影院列表接口二");
		JSONObject data = new JSONObject();
		String res = InterfaceBizHelper.queryCinemas(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为test2");
		logger.warn("****用例执行结束****");
		Assert.assertEquals(res, "test2");
	}
	
	@Test
	public void TC_queryCinemas_four() throws InterruptedException {
		logger.warn("****开始执行用例****");
		logger.info("[步骤_1]. 请求查询影院列表接口二");
		JSONObject data = new JSONObject();
		String res = InterfaceBizHelper.queryCinemas(data);
		// 检查返回是否如预期
		logger.info("[检查点_1]. 检查返回内容是否为test2");
		logger.warn("****用例执行结束****");
		Assert.assertEquals(res, "test2");
	}


}
