
package ykse.TestAutomation.Web.Finixx.Test;

import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
//import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.log4j.Logger;
import ykse.TestAutomation.Web.Finixx.Common.*;
import ykse.TestAutomation.Common.*;

public class WebTest {
	static Logger logger = new Log("web_Finixx").logger;
	private static WebDriver driver;
	private static String baseUrl;
	public static int sleepBase = 1;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "brower", "Path", "Url", "deviceUrl" })
	public static void setUp(String brower, String Path, String Url, String deviceUrl) throws Exception {
		System.setProperty(brower, Path);
		// System.setProperty(brower, Path);
		DesiredCapabilities dc = DesiredCapabilities.firefox(); // 设置需要驱动的浏览器，其他的浏览器都是以此类推
		driver = new RemoteWebDriver(new URL(deviceUrl), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		baseUrl = Url;

	}

	@AfterClass(alwaysRun = true)
	public static void tearDown() throws Exception {
		// driver.close();
	}

	@BeforeMethod(alwaysRun = true)
	public void backtoMain() throws Exception {
		logger.warn("****开始执行用例****");
		logger.info("[FeatureName]用户登录");

	}

	@AfterMethod(alwaysRun = true)
	public void AfterCase() throws Exception {
		logger.warn("****用例执行结束****");

	}

	@Test(groups = { "P0" })
	public void TC_login() throws InterruptedException {

		logger.info("[步骤_1]. 使用后台账号进行登陆");
		Boolean result = WebBizHelper.start_and_login(driver, baseUrl);
		logger.info("检查点_1. 检查页面是否包含首页按钮，以确认是否登陆成功");

		Assert.assertTrue(result);
	}

	// 进入用户管理页面
	@Test(groups = { "P0" })
	public void user_manager() throws InterruptedException {
		logger.info("点击参数设置页面按钮");
		WebFunHelper.clickByXpath("xpath_parameter_title", driver);
		logger.info("点击用户管理设置");
		WebFunHelper.clickByXpath("xpath_usermanager_title", driver);
		Thread.sleep(2000);

		WebFunHelper.switchFrame("xpath_frame_userIndex", driver);

		logger.info("检查点_1. 检查页面是否包含修改按钮，以确认是否查询成功");

		// driver.switchTo().defaultContent();
	}

	// 新增用户
	@Test(groups = { "P0" }, dependsOnMethods = { "user_manager" })
	public void user_add() throws InterruptedException {
		logger.info("点击参数设置页面按钮");
		WebFunHelper.clickByXpath("xpath_parameter_title", driver);
		logger.info("点击用户管理设置");
		WebFunHelper.clickByXpath("xpath_usermanager_title", driver);
		Thread.sleep(2000);
		logger.info("新增用户");
		boolean result = WebBizHelper.UserManager_add(driver);
		logger.info("检查点_1. 检查页面是否包含添加成功");
		Assert.assertTrue(result);
		driver.switchTo().defaultContent();
	}

	// 查询用户
	@Test(groups = { "P0" }, dependsOnMethods = { "user_manager" })
	public void user_search() throws InterruptedException {

		logger.info("查询用户");
		// WebFunHelper.switchFrame("xpath_frame_userIndex",driver);
		boolean result = WebBizHelper.UserManager_search(driver);
		logger.info("检查点_1. 检查页面是否包含修改按钮，以确认是否查询成功");
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();
	}

	@Test(groups = { "P0" })
	public void user_import() throws InterruptedException {

		logger.info("[步骤_1]. 导入");
		// WebFunHelper.switchFrame("xpath_frame_userIndex",driver);

		String fileName = TestData.FindValueInVariables("需要上传的文件1");

		boolean result = WebBizHelper.User_import(fileName, driver);
		logger.info("[检查点_1]. 检查页面是否包含上传文件的名的图标");
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();
	}

	// 修改用户
	@Test(groups = { "P0" }, dependsOnMethods = { "user_search" })
	public void user_change() throws InterruptedException {
		logger.info("修改用户");
		// WebFunHelper.switchFrame("xpath_frame_userIndex", driver);
		boolean result = WebBizHelper.UserManager_change(driver);
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();
	}

	// 修改密码
	@Test(groups = { "P0" }, dependsOnMethods = { "user_search" })
	public void user_password_change() throws InterruptedException {
		logger.info("点击修改密码");
		// WebFunHelper.switchFrame("xpath_frame_userIndex", driver);
		boolean result = WebBizHelper.UserManager_PassWord_Change(driver);
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();

	}

	// 绑定员工卡
	@Test(groups = { "P0" }, dependsOnMethods = { "user_search" })
	public void user_passcard() throws InterruptedException {
		logger.info("绑定员工卡");
		// WebFunHelper.switchFrame("xpath_frame_userIndex", driver);
		boolean result = WebBizHelper.UserManager_PassCard(driver);
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();

	}

	// 授权日志
	@Test(groups = { "P0" }, dependsOnMethods = { "user_search" })
	public void user_grantlog() throws InterruptedException {
		logger.info("授权日志");
		// WebFunHelper.switchFrame("xpath_frame_userIndex", driver);
		boolean result = WebBizHelper.UserManager_GrantLog(driver);
		Assert.assertTrue(result);
		// driver.switchTo().defaultContent();
	}

	// 用户管理-导出
	@Test(groups = { "P0" }, dependsOnMethods = { "user_manager" })
	public void user_output() throws InterruptedException {

	}

	// 用户管理-导入
	@Test(groups = { "P0" }, dependsOnMethods = { "user_manager" })
	public void user_imput() throws InterruptedException {

	}

	/*
	 * @Test(groups = { "P1" },dependsOnMethods = { "TC_login" }) public void
	 * TC_basicSetting() throws InterruptedException {
	 * //driver.findElement(By.linkText("基础设置")).click();
	 * 
	 * logger.info("[步骤_1]. 点击基础设置页面按钮");
	 * WebFunHelper.clickByLinkText("text_basicSetting_title", driver);
	 * Thread.sleep(2000);
	 * 
	 * logger.info("[检查点_1]. 检查页面中是否含有影院组名称字段"); Boolean result =
	 * WebFunHelper.isTextPresent("影院组名称",driver);
	 * 
	 * logger.warn("****用例执行结束****"); assertEquals(result,true);
	 * 
	 * }
	 */

}
