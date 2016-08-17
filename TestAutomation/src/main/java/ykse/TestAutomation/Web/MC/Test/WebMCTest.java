
package ykse.TestAutomation.Web.MC.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
//import org.junit.After;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.log4j.Logger;
import org.junit.runners.MethodSorters;

import ykse.TestAutomation.Web.MC.Common.*;
import ykse.TestAutomation.Common.*;


public class WebMCTest {
	static Logger logger = new Log("web_mc").logger;
	private static WebDriver driver;
	private static String baseUrl;
	// "E:\firefox\Mozilla Firefox\firefox.exe"
	// "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"
	@BeforeClass(alwaysRun = true)
	@Parameters({ "brower", "Path","Url" })
	public static void setUp(String brower, String Path, String Url) throws Exception {
		System.setProperty(brower, "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty(brower, Path);
		DesiredCapabilities dc = DesiredCapabilities.firefox(); // 设置需要驱动的浏览器，其他的浏览器都是以此类推
		driver = new RemoteWebDriver(new URL("http://192.168.10.75:4444/wd/hub"), dc); 
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

	@Test(groups = { "P0" })  
	public void TC_login() throws InterruptedException {
		
	
		logger.info("[步骤_1]. 使用MC账号进行登陆");
		Boolean result = WebBizHelper.start_and_login(driver);
		logger.info("检查点_1. 检查页面是否包含首页按钮，以确认是否登陆成功");
		logger.warn("****用例执行结束****");
		Assert.assertTrue(result);
	}

	@Test(groups = { "P1" },dependsOnMethods = { "TC_login" }) 
	public void TC_basicSetting() throws InterruptedException {
		//driver.findElement(By.linkText("基础设置")).click();
	
		logger.info("[步骤_1]. 点击基础设置页面按钮");
		WebFunHelper.clickByLinkText("text_basicSetting_title", driver);
		Thread.sleep(2000);
		
		logger.info("[检查点_1]. 检查页面中是否含有影院组名称字段");
		Boolean result = WebFunHelper.isTextPresent("影院组名称",driver);
		
		logger.warn("****用例执行结束****");
		assertEquals(result,true);
		
	}


	@Test
	public void TC_cinemaGroup_SearchLevel1() throws InterruptedException {

		logger.info("查询影院组");
		// 基础设置-影院组管理-查询 searchCinemaGroup(或命名为queryCinemaGroup合适一点？？？)
		WebFunHelper.clickByXpath("xpath_cinemaGroupManagement", driver);
		//driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li/a/span")).click();
		Thread.sleep(2000);
		WebFunHelper.clickClassName("class_formGroup", driver);
		//driver.findElement(By.className("form-group")).click();
		Thread.sleep(2000);
		WebFunHelper.clickByLinkText("text_UMEGroup_title", driver);
		//driver.findElement(By.linkText("UME影院组")).click();
		Thread.sleep(2000);
		WebFunHelper.clickByXpath("xpath_submit", driver);
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		logger.warn("****用例执行结束****");
		
	}

	@Test
	public void TC_cinemaGroupDetails() throws InterruptedException {
		logger.info("基础设置-影院组管理-查看详情");
		// 基础设置-影院组管理-查看详情CinemaGroupDetails
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td[2]/div/a/span")))
				.build().perform();
		Thread.sleep(1000);
		// 查看影院组详情
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/div/ul/li[2]/a")).click();
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		By testDate = By.linkText("查看下属影院");
		Boolean result = WebFunHelper.isElementExsit(testDate, driver);
		// 在详情页查看下属影院——弹出小窗
		driver.findElement(By.xpath("//div[@class='basic-group']/div/a")).click();
		Thread.sleep(2000);
		// 查看下属影院小窗的关闭按钮
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		// driver.findElement(By.xpath("//button[@class='ngdialog-close']")).click();
		Thread.sleep(2000);
		// 影院组详情页的关闭按钮
		driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon tabs-header-close']")).click();
		Thread.sleep(2000);
		assertEquals(result,true);
		
	}

	@Test
	public void cinemaGroup_AddLevel2() throws InterruptedException {

		// 基础设置-影院组管理-添加下属二级影院组
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/div/a/span"))).build()
				.perform();
		Thread.sleep(2000);

		// 添加下属二级影院组addCinemaGroup
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/div/ul/li/a")).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		// 填写影院组信息(现在只有必填项)，
		driver.findElement(By.name("cinemaGroupName")).clear();
		driver.findElement(By.name("cinemaGroupName")).sendKeys("seleniumtestcinemagroup1");
		// 这个名字要自己循环换多个影院组名称
		driver.findElement(By.name("cinemaGroupCode")).clear();
		driver.findElement(By.name("cinemaGroupCode")).sendKeys("ABCDE");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void cinemaGroup_AddLevel3() throws InterruptedException {

		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/a/span")))
				.build().perform();
		Thread.sleep(2000);
		// 添加下属三级级影院组addCinemaGroup_Level3
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
		// li1-编辑，li2-删除，li3-添加3级影院组，li4-详情
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		// 填写影院组信息(现在只有必填项)，
		driver.findElement(By.name("cinemaGroupName")).clear();
		driver.findElement(By.name("cinemaGroupName")).sendKeys("seleniumtestcinemagroup2");
		// 这个名字要自己循环换多个影院组名称
		driver.findElement(By.name("cinemaGroupCode")).clear();
		driver.findElement(By.name("cinemaGroupCode")).sendKeys("ABCDEF");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void cinemaGroupDetails_Level2() throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/span")).click();
		Thread.sleep(2000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/a/span")))
				.build().perform();
		Thread.sleep(2000);
		// 查看二级影院组详情
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);

		// 在详情页查看下属二级影院——弹出小窗
		driver.findElement(By.xpath("//div[@class='basic-group']/div/a")).click();
		Thread.sleep(2000);
		// 查看下属二级影院小窗的关闭按钮
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Thread.sleep(2000);
		// 二级影院组详情页的关闭按钮
		driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon tabs-header-close']")).click();
		Thread.sleep(2000);
		// 详情页有个编辑按钮跳转，不知道怎么写？？
	}

	@Test
	public void cinemaGroup_EditLevel2() throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/span")).click();
		Thread.sleep(2000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/a/span")))
				.build().perform();
		Thread.sleep(2000);
		// 编辑下属二级影院组editCinemaGroup_Level2
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/ul/li[1]/a")).click();
		Thread.sleep(2000);
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		// 填写影院组信息(现在只有必填项)，
		driver.findElement(By.name("cinemaGroupName")).clear();
		driver.findElement(By.name("cinemaGroupName")).sendKeys("seleniumtestcinemagroup33");
		Thread.sleep(1000);
		// 这个影院组名字要自己循环换多个影院组名称
		driver.findElement(By.name("introduction")).clear();
		driver.findElement(By.name("introduction")).sendKeys("75影院历史悠久");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void cinemaGroup_DeleteLevel2() throws InterruptedException {
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr/td/span")).click();
		Thread.sleep(2000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/a/span")))
				.build().perform();
		Thread.sleep(2000);
		// 删除下属二级影院组deleteCinemaGroup_Level2
		driver.findElement(By.xpath("//tbody[@id='cinemagroupTreeMC']/tr[2]/td[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		// new WebDriverWait(driver, 15).until(
		// ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ngdialog-content']"))
		// );
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ngdialog16']/div[2]")));
		Thread.sleep(2000);
		// 确定删除
		driver.findElement(By.xpath("//div[3]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	@Test
	public void searchCinema() throws InterruptedException {

		// 影院管理
		driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[2]/a/span")).click();
		Thread.sleep(2000);
		// -按城市查询searchCinema
		driver.findElement(By.name("cityName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("广州")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
		// 清除查询条件
		// driver.findElement(By.name("cityName")).clear();
		// Thread.sleep(2000);

		// -按影院查询searchCinema
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@name='cinemaName']"));
		driver.findElement(By.name("cinemaname")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.name("cinemaName")).clear();
		// Thread.sleep(2000);

		// 按影院状态searchCinema
		driver.findElement(By.name("statusName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("启用")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.name("cinemaEnabled")).clear();
		// Thread.sleep(2000);

		// 按影院编码查询 searchCinema
		driver.findElement(By.name("cinemaId")).sendKeys("88888147");
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.name("cinemaId")).clear();
		// Thread.sleep(1000);

		// 按影院内码查询 searchCinema
		driver.findElement(By.name("cinemaLinkId")).sendKeys("147");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.name("cinemaLinkId")).clear();
		// Thread.sleep(1000);
	}

	@Test
	public void searchCinemaDetails() throws InterruptedException {
		// 基础设置-影院管理-查看详情CinemaDetails
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
		Thread.sleep(1000);

		// 查看影院详情
		driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[2]/a")).click();
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		// 影院详情页的关闭按钮
		driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon tabs-header-close']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void searchCinema_Edit() throws InterruptedException {
		// 基础设置-影院管理-编辑影院editCinema
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
		Thread.sleep(1000);

		// 编辑影院
		driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li/a")).click();
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
		Thread.sleep(1000);
		// 编辑影院信息(现在只有必填项)，
		driver.findElement(By.name("bulletinBoard")).clear();
		driver.findElement(By.name("bulletinBoard")).sendKeys("75影院有营销优惠活动，欢迎大家踊跃参与，还有现场礼品哦！");
		Thread.sleep(1000);
		// 这个影院组名字要自己循环换多个影院组名称
		driver.findElement(By.name("introduction")).clear();
		driver.findElement(By.name("introduction")).sendKeys("75影院历史悠久");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void fimls() throws InterruptedException {
		// 影片管理
		driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[3]/a/span")).click();
		Thread.sleep(2000);
		// -按查询条件查询fimls
		driver.findElement(By.name("filmName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("寻龙诀")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("id")).sendKeys("001105952015");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void fimlsDetails() throws InterruptedException {
		// 影片详情
		driver.findElement(By.xpath("//tbody/tr/td[2]/a")).click();
		Thread.sleep(2000);
		// 影片详情页的关闭按钮
		driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon tabs-header-close']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void halls() throws InterruptedException {
		// 影厅管理
		driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[4]/a/span")).click();
		Thread.sleep(2000);
		// -按查询条件查询fimls
		driver.findElement(By.name("cityName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("广州")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("cinemaName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("hallTypeName")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("cinemaId")).sendKeys("88888147");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	}

	@Test
	public void hallDetails() throws InterruptedException {
		// 影片详情
		driver.findElement(By.xpath("//tbody/tr/td[2]/a")).click();
		Thread.sleep(2000);
		// 影片详情页的关闭按钮
		driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon tabs-header-close']")).click();
		Thread.sleep(2000);
	}


	@Test
	public void bGoodsInformationAlter() throws InterruptedException {

		// 卖品信息管理,编辑
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("卖品信息管理")).click();
		Thread.sleep(1000);
		// 1.选中一条数据
		driver.findElement(By.className("form-group")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).sendKeys("薯条_大南仓");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		// 2. 点击【编辑】卖品信息
		driver.findElement(By.className("btn-link")).click();
		// 2.1点击编辑，修改卖品信息，保存，然后关闭
		Thread.sleep(2000);
		String goodDesc1 = "";
		for (int i = 0; i < 28; i++) {
			goodDesc1 = goodDesc1 + (char) (Math.random() * 26 + 'A');
		}
		// System.out.println("settext_goodDesc1:" + goodDesc1);
		String goodDesc2 = "卖品11111111备注信息";
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).sendKeys(goodDesc1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@type='submit']")).click();
		// 保存
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div/div/div/div[2]/div/form/div[3]/button[2]"))
				.click(); // 关闭
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@ng-click='confirm(1);']")).click();// 关闭后确认
		Thread.sleep(2000);
		try {
			String getback = driver
					.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div/div/div[2]/table/thead/tr/th[3]/div"))
					.getText();
			// System.out.println("closeGetback:"+getback);
			if (getback.equals("卖品名称")) {
				System.out.println("Passed, 1.关闭窗口返回到列表---卖品信息管理-编辑");
			}
		} catch (Exception e) {
		}

		driver.findElement(By.className("btn-link")).click();
		// 2.2点击编辑，修改卖品信息，不保存，关闭，关闭后取消
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).click();
		String gettext = driver.findElement(By.xpath("//textarea[@name='goodsremark']")).getText();
		// System.out.println("gettext:"+gettext);
		if (gettext.equals(goodDesc1)) {
			System.out.println("Passed, 2.卖品信息跟修改内容一致---卖品信息管理-编辑");
		} else {
			System.out.println("Failed, 2.卖品信息跟修改内容不一致---卖品信息管理-编辑");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).clear();
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).sendKeys(goodDesc2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div/div/div/div[2]/div/form/div[3]/button[2]"))
				.click(); // 关闭
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@ng-click='closeThisDialog();']")).click();
		// 关闭后取消
		Thread.sleep(2000);

		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).click();
		// 2.3修改卖品信息，不保存，关闭，关闭后确认
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).clear();
		driver.findElement(By.xpath("//textarea[@name='goodsremark']")).sendKeys("卖品22222222备注信息");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div/div/div/div[2]/div/form/div[3]/button[2]"))
				.click(); // 关闭
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@ng-click='confirm(1);']")).click();// 关闭后确认
		Thread.sleep(2000);
		System.out.println("---------------------------------");

	}

	@Test
	public void bSearchGoodsInformation() throws InterruptedException {

		// 卖品信息管理,选择查询条件，查询
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("卖品信息管理")).click();
		Thread.sleep(1000);
		// 选择全部影院，查询
		driver.findElement(By.className("form-group")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		try {
			String serchExc = driver.findElement(By.xpath("//span[@ng-bind='msg.getGoods']")).getText();
			System.out.println("serchExc:" + serchExc);
			if (serchExc.equals("系统异常")) {
				System.out.println("Failed, 查询出现系统异常------卖品信息管理-查询");
			}
		} catch (Exception e) {
		}
		// 选择一影院，查询
		driver.findElement(By.className("form-group")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		// 卖品---输入卖品名称，查询
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).sendKeys("薯条_大南仓");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		try {
			String getb = driver
					.findElement(By
							.xpath("/html/body/div/div[2]/div[3]/div/div/div/div/div/div[2]/table/tbody/tr/td[3]/span"))
					.getText();
			// System.out.println("closeGetback:"+getb);
			if (getb.equals("薯条_大南仓")) {
				System.out.println("Passed, 1.显示符合查询条件的结果---卖品信息管理-查询");
			}
		} catch (Exception e) {
		}
		// 卖品---没有记录信息，正确提示
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).sendKeys("780000xxxxxxxx");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		try {

			String nomes = driver.findElement(By.xpath("//span[@ng-bind='msg.getGoods']")).getText();
			Thread.sleep(2000);
			// System.out.println(nomes);
			if (nomes.equals("暂无数据")) {
				System.out.println("Passed, 2.没有该商品信息提示暂无数据------卖品信息管理-查询");
			}
		} catch (Exception e) {
		}
		System.out.println("---------------------------------");
	}

	@Test
	public void bSearchMembershipCard() throws InterruptedException {

		// 会员卡管理,查询
		Thread.sleep(800);
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("会员卡管理")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请选择城市']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("广州")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请选择影院']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		try {
			String getci = driver.findElement(By.xpath("//span[@ng-bind='card.cinemaName']")).getText();
			Thread.sleep(2000);
			System.out.println("getci:" + getci);
			Thread.sleep(1000);
			if (getci.equals("75影院")) {
				System.out.println("Passed，1.显示符合查询条件的结果---会员卡管理，查询");
			}
		} catch (Exception e) {
		}

		System.out.println("---------------------------------");
	}

	@Test
	public void bCouponManage() throws InterruptedException {

		// 劵管理，查询
		Thread.sleep(1000);
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.linkText("劵管理")).click();
			// System.out.println("linkText:ok!----劵管理");
		} catch (Exception e) {
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div/ul/li[6]/a/span")).click();
			// System.out.println("need Xpath!----劵管理");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='voucherCinemaName']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@ng-disabled='toggle.getCinemaVoucherList.isLoading']")).click();
		Thread.sleep(2000);
		System.out.println("---------------------------------");
	}

	@Test
	public void bSearchGoodSalesManage() throws InterruptedException {

		// 查询商品
		String searchGoodName = "薯条_大南仓";

		// 卖品销售管理，查询条件
		Thread.sleep(1000);
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(2000);
		try {
			driver.findElement(By.linkText("卖品销售管理")).click();
			// System.out.println("linkText:ok!---卖品销售管理");
		} catch (Exception e) {
			// driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div/ul/li[4]/a/span")).click();
			System.out.println("need Xpath!---卖品销售管理");
		}
		Thread.sleep(1000);
		// 选择查询条件,查询，显示符合查询结果
		driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div/div[1]/div/div/form/div[1]/div/input[3]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='channelname']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("淘宝电影")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='请输入卖品名']")).sendKeys(searchGoodName);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		try {
			String getGoodname = driver
					.findElement(By
							.xpath("/html/body/div/div[2]/div[3]/div/div/div[1]/div/div/div[2]/table/tbody/tr/td[4]/span"))
					.getText();
			System.out.println("getGoodname:" + getGoodname);
			if (getGoodname.contains(searchGoodName)) {
				System.out.println("Passed，1.显示符合查询条件的结果---卖品销售管理，查询");
			} else {
				System.out.println("Failed，1.显示不符合查询条件的结果---卖品销售管理，查询");
			}
		} catch (Exception e) {
		}
		System.out.println("---------------------------------");
	}

	@Test
	public void bSearchCineamaScheduling() throws InterruptedException {

		// 影院排期管理，查询，刷新
		Thread.sleep(800);
		driver.findElement(By.linkText("商品")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("影院排期管理")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='请选择影院']")).click();
		Thread.sleep(1500);
		driver.findElement(By.linkText("75影院")).click();// 选择影院名称
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div/div/div/form/div[3]/div/input"))
				.click();// 选择影厅查询
		Thread.sleep(3000);
		driver.findElement(By.linkText("电影云专用普通厅")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@type='submit']")).click();// 查询
		Thread.sleep(1500);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div/div/div/form/div[4]/div/input"))
				.click();// 选择影片查询
		Thread.sleep(1500);
		driver.findElement(By.linkText("寻龙诀")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@type='text']")).click();// 刷新
		Thread.sleep(1500);

		try {
			String filmName = driver.findElement(By.xpath("//div[@title='寻龙诀']")).getText();
			// System.out.println("filmName:"+filmName);
			if (filmName.contains("寻龙诀")) {
				System.out.println("Passed，1.显示符合查询条件的影片信息---影院排期管理，查询");
			}
		} catch (Exception e) {
		}
		System.out.println("---------------------------------");

	}

	@Test
	public void checkScreeningsPrice() throws InterruptedException {
		driver.findElement(By.linkText("定价")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[1]/div[@id='main-container']/div[1]/div/div/div/ul/li[1]/a/span")).click();
		Thread.sleep(5000);
		// 选择城市
		driver.findElement(By.xpath("//input[@placeholder='请选择城市']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("广州")).click();
		Thread.sleep(5000);
		// 选择影院
		driver.findElement(By.xpath("//input[@placeholder='请选择影院']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("75影院")).click();
		Thread.sleep(5000);
		// 选择影厅
		driver.findElement(By.xpath("//input[@placeholder='请选择影厅']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("普通厅")).click();
		// 选择影片
		driver.findElement(By.xpath("//input[@placeholder='请选择影片']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("老炮儿")).click();
		Thread.sleep(2000);
		// 选择状态
		driver.findElement(By.xpath("//input[@placeholder='全部状态']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		// 选择渠道
		driver.findElement(By.name("WEB网站")).click(); // 渠道选择web网站
		Thread.sleep(6000);
		// 点击查询
		driver.findElement(By.className("btn btn-primary btn-search")).click();
		Thread.sleep(2000);
		// 获取查询结果所有行
		/*
		 * int i = 0; int j = 0; List<WebElement> rows = driver
		 * .findElements(By.xpath(
		 * "//div[@className='table-scroll']/tbody/tr[@className='ng-scope']"));
		 * System.out.println("检测出查询结果：" + rows.size() + "行"); for (WebElement
		 * row : rows) { // 遍历表格第i行 i = i + 1; // 正位于表格第i行
		 * System.out.println("第" + i + "行数据"); List<WebElement> cols =
		 * driver.findElements(By.tagName("td")); for (WebElement col : cols) {
		 * // 遍历第i行第j列 System.out.println("第" + i + "行，第" + j + "个数据"); String
		 * id = col.getText(); System.out.println("Text：" + id); // 获取td文本
		 */

	}
	// }

	@Test
	public void addScreeningsPriceRule() throws InterruptedException {

		WebBizHelper.addScreeningsPriceRule(1, driver);// 新增定价规则
	}

	@Test
	public void queryScreeningsPriceRule() throws InterruptedException {

		WebBizHelper.queryScreeningsPriceRule(driver);// 查询定价规则
	}

	@Test
	public void auditScreeningsPriceRulePass_saveAndSubmit() throws InterruptedException {

		int auditState = 1;
		int addState = 1;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.auditScreeningsPriceRule(getTitle, auditState, addState, driver);// 审核定价规则
	}

	@Test
	public void auditScreeningsPriceRulePass_save() throws InterruptedException {

		int auditState = 1;
		int addState = 2;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.auditScreeningsPriceRule(getTitle, auditState, addState, driver);// 审核定价规则
	}

	@Test
	public void auditScreeningsPriceRuleNoPass() throws InterruptedException {

		int auditState = 2;
		int addState = 1;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.auditScreeningsPriceRule(getTitle, auditState, addState, driver);// 审核定价规则
	}

	@Test
	public void modifyScreeningsPriceRule() throws InterruptedException {

		int addState = 1;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.modifyScreeningsPriceRule(getTitle, driver);// 修改定价规则
	}

	@Test
	public void deleteScreeningsPriceRule() throws InterruptedException {

		int addState = 1;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.deleteScreeningsPriceRule(getTitle, driver);// 删除定价规则
	}

	@Test
	public void screeningsPriceRule_adjustPriority() throws InterruptedException {

		int addState = 1;
		String getTitle = WebBizHelper.addScreeningsPriceRule(addState, driver); // 新增定价规则
		WebBizHelper.screeningsPriceRule_adjustPriority(getTitle, driver);// 调整定价规则优先级
	}

	@Test
	public void addGoodPriceRule_batchPricing_plusFixedAmount_saveAndSubmit() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
	}

	@Test
	public void addGoodPriceRule_batchPricing_minusFixedAmount_save() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 2;
		int saveState = 2;
		WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
	}

	@Test
	public void addGoodPriceRule_batchPricing_multiplyFixedProportionAndPlus_saveAndSubmit()
			throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 3;
		int saveState = 1;
		WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
	}

	@Test
	public void addGoodPriceRule_batchPricing_multiplyFixedProportionAndminus_save() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 4;
		int saveState = 2;
		WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
	}

	@Test
	public void addGoodPriceRule_separatePricing_saveAndSubmit() throws InterruptedException {

		int priceState = 2;
		int pricingStrategyState = 0;
		int saveState = 1;
		WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
	}

	@Test
	public void queryGoodPriceRule() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.queryGoodPriceRule(getTitle, driver); // 查询卖品定价规则
	}

	@Test
	public void auditGoodPriceRulePass() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		int auditState = 1;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.auditGoodPriceRule(getTitle, saveState, auditState, driver); // 审核卖品定价规则
	}

	@Test
	public void auditGoodPriceRuleNoPass() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 2;
		int auditState = 2;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.auditGoodPriceRule(getTitle, saveState, auditState, driver); // 审核卖品定价规则
	}
	
	@Test
	public void modifyGoodPriceRule() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.modifyGoodPriceRule(getTitle, driver); // 修改卖品定价规则
	}
	
	@Test
	public void GoodPriceRule_adjustPriority() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.GoodPriceRule_adjustPriority(getTitle, driver); // 调整卖品定价规则优先级
	}
	

	@Test
	public void deleteGoodPriceRule() throws InterruptedException {

		int priceState = 1;
		int pricingStrategyState = 1;
		int saveState = 1;
		String getTitle = WebBizHelper.addGoodPriceRule(priceState, pricingStrategyState, saveState, driver); // 新增卖品定价规则
		WebBizHelper.deleteGoodPriceRule(getTitle, driver); // 删除卖品定价规则
	}

	@Test
	public void activity_select() throws InterruptedException {
		boolean pass = WebBizHelper.activity_select(null, null, null, null, null, driver);
		assertEquals("Check activity_select is correct", pass, true);
	}

	@Test
	public void activity_create() throws InterruptedException {
		String type = "立减";
		String activityName = "立减9.9";
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = format.format(date);
		String endTime = format.format(date);
		String introduce = activityName;
		String activityTag = activityName;
		String activitySupplement = activityName;
		String activityDescription = activityName;

		WebBizHelper.activity_create(driver);
		WebBizHelper.activity_create_type(type, driver);
		WebBizHelper.activity_create_info(type, activityName, startTime, endTime, introduce, activityTag,
				activitySupplement, activityDescription, driver);
		WebBizHelper.activity_create_condition(type, driver);

		assertEquals("Check activity_select is correct",
				driver.findElement(By
						.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[3]/span"))
				.getText().contains(activityName), true);

	}

	@Test
	public void activity_Audit() throws InterruptedException {
		String type = "立减";
		String activityName = "立减9.9";
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = format.format(date);
		String endTime = format.format(date);
		String introduce = activityName;
		String activityTag = activityName;
		String activitySupplement = activityName;
		String activityDescription = activityName;

		WebBizHelper.activity_create(driver);
		WebBizHelper.activity_create_type(type, driver);
		WebBizHelper.activity_create_info(type, activityName, startTime, endTime, introduce, activityTag,
				activitySupplement, activityDescription, driver);
		WebBizHelper.activity_create_condition(type, driver);
		WebBizHelper.activity_create_price(type, driver);

		boolean Pass = WebBizHelper.activity_Audit(true, driver);

		assertEquals("Check activity_select is correct", Pass, true);
	}

	@Test
	public void activity_stop() throws InterruptedException {
		activity_Audit();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();

		driver.findElement(By.linkText("暂停")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(5000);

		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();

		assertNotNull("Check activity_stop is correct", driver.findElement(By.linkText("继续执行")));
	}

	@Test
	public void activity_continue() throws InterruptedException {
		activity_stop();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();
		driver.findElement(By.linkText("继续执行")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/button[1]")).click();
		Thread.sleep(5000);

		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();

		assertNotNull("Check activity_stop is correct", driver.findElement(By.linkText("暂停")));
	}

	@Test
	public void activity_details() throws InterruptedException {
		activity_Audit();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();
		driver.findElement(By.linkText("详情")).click();

		boolean pass = driver
				.findElement(By
						.xpath("/html/body/div/div[2]/div[3]/div/div/div/div/div[2]/div/form/div[2]/div[1]/div/div[1]/div[1]/span[1]"))
				.getText().contains("创建人");
		assertEquals("Check activity_details is correct", pass, true);
	}


	
	@Test
	public void home() throws InterruptedException{
		driver.findElement(By.xpath("//div/div[1]/div/ul/li[1]/a")).click();
		
		assertEquals("Check home is correct", driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/div/div/div/div[1]/div/span[1]/span[1]")).getText().contains("实时票房"), true);
		assertEquals("Check home is correct", driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/div/div/div/div[1]/div/span[2]/span[1]")).getText().contains("实时预售票房"), true);
		assertEquals("Check home is correct", driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/div/div/div/div[1]/div/span[3]/span[1]")).getText().contains("实时人次"), true);
		assertEquals("Check home is correct", driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/div/div/div/div[1]/div/span[4]/span[1]")).getText().contains("实时昨日卖品销售额"), true);
		assertEquals("Check home is correct", driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/div/div/div/div[1]/div/span[3]/span[1]")).getText().contains("实时昨日SPP"), true);
	}
	
	@Test
	public void channelInfo_select() throws InterruptedException{
		WebBizHelper.base_setUp(driver);
		WebBizHelper.channelInfo_select(0, 0, 0, driver);
		
		assertNotNull("Check channelInfo is correct", driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[2]")));
	}
	
	@Test
	public void channelInfo_addChannel() throws InterruptedException, SQLException{
		WebBizHelper.base_setUp(driver);
		WebBizHelper.channelInfo_addChannel(driver);
		
		//assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelInfo_addCinema() throws InterruptedException, SQLException{
		channelInfo_addChannel();
		WebBizHelper.channelInfo_addCinema(driver);
		
	//	assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelInfo_deleteCinema() throws InterruptedException, SQLException{	
		channelInfo_addCinema();
		WebBizHelper.channelInfo_deleteCinema(driver);
		
	//	assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelInfo_stop() throws InterruptedException, SQLException{	
		channelInfo_addChannel();
		WebBizHelper.channelInfo_stop(driver);
	
	//	assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelInfo_Enable() throws InterruptedException, SQLException{	
		channelInfo_stop();
		WebBizHelper.channelInfo_Enable(driver);
		
	//	assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelInfo_set() throws InterruptedException, SQLException{	
		channelInfo_addChannel();
		WebBizHelper.channelInfo_set(driver);
		
		assertEquals("Check channelInfo_set is correct", driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[2]/button[1]")).getText().contains("查看秘钥"),true);
		assertEquals("Check channelInfo_set is correct", driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[2]/button[3]")).getText().contains("添加影院"),true);
	}
	
	@Test
	public void channelInfo_batchEnable() throws InterruptedException, SQLException{	
		channelInfo_stop();
		WebBizHelper.channelInfo_batchEnable(driver);
		
	//	assert???;//校验需要提供方法.弹窗校验
	}	
	
	@Test
	public void channelInfo_batchStop() throws InterruptedException, SQLException{	
		WebBizHelper.base_setUp(driver);
		WebBizHelper.channelInfo_batchStop(driver);
		
		//assert???;//校验需要提供方法.弹窗校验
		
		channelInfo_batchEnable();  //后置动作，把停用的重新启用，以免影响其他操作
	}
	
	@Test
	public void channelInfo_batchAddCinema() throws InterruptedException, SQLException{	
		WebBizHelper.base_setUp(driver);
		WebBizHelper.channelInfo_batchAddCinema(driver);
		
	//	assert???;//校验需要提供方法.弹窗校验
	}
	
	@Test
	public void channelJurisdiction_select() throws InterruptedException, SQLException{	
		WebBizHelper.base_setUp(driver);
		WebBizHelper.channelJurisdiction_select(null, null, null, null, driver);
		
		assertNotNull("Check channelInfo is correct", driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[2]")));
	}
	
	 @Test
	    public void abuyordersearch_empty() throws InterruptedException{
	    	
			WebBizHelper.abuyordersearch_empty(driver);  //购票订单-直接点击查询
		}
	    
	    @Test
	    public void bbuyordersearch_accurate() throws InterruptedException{
	    	
			WebBizHelper.bbuyordersearch_accurate(driver);  //购票订单-输入条件-精确查询
		}
	  
	    @Test
	    public void cbuyordersearch_senior() throws InterruptedException{
	    	
			WebBizHelper.cbuyordersearch_senior(driver);  //购票订单-高级查询
		}
	    
	    @Test
	    public void dbuyorder_operate() throws InterruptedException{
	    	
			WebBizHelper.dbuyorder_operate(driver);  //购票订单-操作-详情、退票
		}
	    
	    @Test
	    public void dbuyorder_Refund() throws InterruptedException{
	    	//购票订单-操作-批量退票
	    	//查询出票成功的订单
			//driver.findElement(By.xpath("//div[@class='order-btn-section margin-long']/button[2]/span")).click();
			driver.findElement(By.xpath("//button[@class='btn btn-link']")).click();
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//form[@name='formOrder']/div[2]/div[3]/div")).click();
			driver.findElement(By.name("cinemaname）")).click();
			driver.findElement(By.linkText("841影院（98）")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("statusname）")).click();
			driver.findElement(By.linkText("出票成功")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
	    	
	    	//点击勾选列表前的复选框
	    	driver.findElement(By.xpath("//tbody/tr/div[@class='checkbox']")).click(); 
	    	driver.findElement(By.xpath("//tbody/tr[2]/div[@class='checkbox']")).click();
			Thread.sleep(2000);
			//点击批量退订按钮
			driver.findElement(By.xpath("//button[@class='btn btn-primary-light btn-sm']")).click(); 
			Thread.sleep(2000);
			//打开退票小窗：dialog-wrapper order-refund
			new WebDriverWait(driver, 15)
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-wrapper order-refund']")));
			Thread.sleep(1000);
			//确认退票
			driver.findElement(By.xpath("//div[@class='dialog-wrapper order-refund']/div[3]/div/button")).click(); 
			Thread.sleep(2000);
		}
	  
	    @Test
	    public void agoodordersearch_empty() throws InterruptedException{
	    	
			WebBizHelper.agoodordersearch_empty(driver);  //卖品订单-直接查询
		}
	    
	    @Test
	    public void bgoodordersearch_accurate() throws InterruptedException{
	    	
			WebBizHelper.bgoodordersearch_accurate(driver);  //卖品订单-输入条件-精准查询
		}
	    
	    @Test
	    public void cgoodordersearch_senior() throws InterruptedException{
	    	
			WebBizHelper.cgoodordersearch_senior(driver);  //卖品订单-高级查询
		}
	    
	    @Test
		public void queryTicketBoxDetailReport() throws InterruptedException {

			WebBizHelper.queryTicketBoxDetailReport(driver); // 查询票房销售明细报表
		}
	    
	    @Test
		public void queryTicketSalesOverviewReport() throws InterruptedException {

			WebBizHelper.queryTicketSalesOverviewReport(driver); // 查询票房销售总览报表
		}
	    
	    @Test
		public void EditCoupons() throws InterruptedException {

			WebBizHelper.EditCoupons(driver); // 修改券管理
		}
	    
	    @Test
		public void BatchOperationCoupons_open() throws InterruptedException {

	    	int state=1;
			WebBizHelper.BatchOperationCoupons(state,driver); // 批量开放券管理
		}
	    
	    @Test
	  		public void BatchOperationCoupons_close() throws InterruptedException {

	  	    	int state=2;
	  			WebBizHelper.BatchOperationCoupons(state,driver); // 批量关闭券管理
	  		}
	    
	    @Test
  		public void openOrCloseCoupons_open() throws InterruptedException {

  	    	int state=1;
  			WebBizHelper.openOrCloseCoupons(state,driver); // 开放券管理
  		}
	    
	    @Test
  		public void openOrCloseCoupons_close() throws InterruptedException {

  	    	int state=2;
  			WebBizHelper.openOrCloseCoupons(state,driver); // 关闭券管理
  		}
	    
	    @Test
  		public void queryBannerSetting() throws InterruptedException {

  	    	WebBizHelper.queryBannerSetting(driver); // 查询banner设置
  		}
	    
	    @Test
  		public void addBannerSetting() throws InterruptedException {

  	 //   	WebBizHelper.addBannerSetting(driver); // 新建banner
  		}
	    
	    @Test
  		public void editBannerSetting() throws InterruptedException {
  	    	// 编辑banner
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击编辑，打开编辑页；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[1]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
			Thread.sleep(1000);
			//编辑页面信息，点击保存。
			driver.findElement(By.name("bannerName")).clear();
			driver.findElement(By.name("bannerName")).sendKeys("编辑新banner");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
  		}
	    
	    @Test
  		public void delectBannerSetting() throws InterruptedException {
  	    	// 删除banner
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击删除，打开删除小窗；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[3]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-wrapper']/div/h5")));
			Thread.sleep(1000);
			//点击确认删除
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(1000);
			
	    }
	    
	    @Test
  		public void openBannerSetting() throws InterruptedException {
  	    	// 启用banner
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击启用，打开启用提示小窗；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[2]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dialog-wrapper']")));
			Thread.sleep(1000);
			//点击确认启用
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(1000);
			
	    }
	    
	    @Test
  		public void closeBannerSetting() throws InterruptedException {
  	    	// 启用banner
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击启用，打开启用提示小窗；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[2]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dialog-wrapper']")));
			Thread.sleep(1000);
			//点击确认启用
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Thread.sleep(1000);
			
	    }
	    
	    @Test
  		public void addAndQueryInformationArticles() throws InterruptedException {

  	    	WebBizHelper.addAndQueryInformationArticles(driver); // 新建资讯文章
  		}
	    
	    @Test
  		public void modifyInformationArticles() throws InterruptedException {
	    	String title=WebBizHelper.addAndQueryInformationArticles(driver);
  	    	WebBizHelper.modifyInformationArticles(title,driver); // 修改资讯文章
  		}
	    
	    @Test
  		public void enableAndDisableInformationArticles() throws InterruptedException {
	    	String title=WebBizHelper.addAndQueryInformationArticles(driver);
  	    	WebBizHelper.enableAndDisableInformationArticles(title,driver); // 启用和停用资讯文章
  		}
	    
	    @Test
  		public void deleteInformationArticles() throws InterruptedException {
	    	String title=WebBizHelper.addAndQueryInformationArticles(driver);
  	    	WebBizHelper.deleteInformationArticles(title,driver); // 删除资讯文章
  		}
	    
	    @Test
  		public void queryChannelSchedulingManagement() throws InterruptedException {
	    	WebBizHelper.queryChannelSchedulingManagement(driver); //商品-查询渠道排期管理 
  		}
	    
	    @Test
  		public void modifyAndQueryDetailsCardManagement() throws InterruptedException {
	    	WebBizHelper.modifyAndQueryDetailsCardManagement(driver); //商品-修改会员卡管理 
  		}
	    
	    @Test
		public void channelJurisdiction_set() throws InterruptedException, SQLException{	
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelJurisdiction_set(driver);
	    }
	    
	    @Test
		public void channelJurisdiction_batchSet() throws InterruptedException, SQLException{	
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelJurisdiction_batchSet(driver);
	    }
	    
	    @Test
		public void channelUser_select() throws InterruptedException, SQLException{	
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_select(null, null, null, null, driver);
	    }
	    
	    @Test
		public void channelUser_create() throws InterruptedException, SQLException{	
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_create(null, null, null, driver);
			
			assertEquals("Check channelUser_create is correct", driver.findElement(By.xpath("//div[10]/div[2]/div[1]/span")).
					getText().contains("成功"), true);
			
			 driver.findElement(By.xpath("//div[10]/div[2]/div[2]")).click();
	    }
	    
	    @Test
		public void channelUser_edit() throws InterruptedException{		
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_edit(driver);
	    }
	    
	    @Test
		public void channelUser_recharge() throws InterruptedException{	
	    	String momey = "100";
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_recharge(momey, driver);
	    }
	    
	    @Test
		public void channelUser_settlement() throws InterruptedException{	
	    	String momey = "100";
			WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_recharge(momey, driver);
			WebBizHelper.channelUser_settlement(momey, driver);
	    }
	    
	    @Test
		public void channelUser_stop() throws InterruptedException{	
	    	WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_stop(driver);
	    }
	    
	    @Test
		public void channelUser_enable() throws InterruptedException{	
	    	WebBizHelper.base_setUp(driver);
			WebBizHelper.channelUser_stop(driver);
			WebBizHelper.channelUser_enable(driver);
	    }
	    
	    @Test
		public void refundPolicy_select() throws InterruptedException{	
	    	WebBizHelper.base_setUp(driver);
	    	WebBizHelper.refundPolicy_select(null, driver);
	    }
	    
	    @Test
	  	public void refundPolicy_create() throws InterruptedException, SQLException{	
	    	String policyName = "自动测试";
	    	String time = "30";
	    	String number = "30";
	    	WebBizHelper.base_setUp(driver);
	    	WebBizHelper.refundPolicy_create(policyName, time, number, null, driver);
	    }
	    
		@Test
		public void refundPolicyName_Search() throws InterruptedException {

			// 基础设置-退票政策管理-查询 refundPolicyName_Search
			driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("policyName")).clear();
			driver.findElement(By.id("policyName")).sendKeys("淘宝退票");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}

		public void refundPolicyName_Add() throws InterruptedException {

			// 基础设置-退票政策管理-编辑 refundPolicyName_Add
			driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
			Thread.sleep(2000);
			//点击新建按钮，打开新建编辑页；
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
			Thread.sleep(1000);
			//编辑页面信息，点击保存。
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("新建一条自动化测试用");
			driver.findElement(By.name("remark")).clear();
			driver.findElement(By.name("remark")).sendKeys("喜欢怎么退就怎么退");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		
		public void refundPolicyName_Copy() throws InterruptedException {

			// 基础设置-退票政策管理-编辑 refundPolicyName_Copy
			driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
			Thread.sleep(2000);
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击复制，打开复制编辑页；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[3]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
			Thread.sleep(1000);
			//编辑页面信息，点击保存。
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("复制出来删除的");
			driver.findElement(By.name("remark")).clear();
			driver.findElement(By.name("remark")).sendKeys("喜欢怎么退就怎么退");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		
		@Test
		public void refundPolicyName_Edit() throws InterruptedException {

			// 基础设置-退票政策管理-编辑 refundPolicyName_Edit
			driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
			Thread.sleep(2000);
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击编辑，打开编辑页；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[1]/a")).click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='tabs-header-border']")));
			Thread.sleep(1000);
			//编辑页面信息，点击保存。
			driver.findElement(By.name("remark")).clear();
			driver.findElement(By.name("remark")).sendKeys("想退就退");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		
		public void refundPolicyName_Delect() throws InterruptedException {

			// 基础设置-退票政策管理-编辑 refundPolicyName_Delect
			driver.findElement(By.xpath("//div[@id='sidebar-scroll']/div/div/ul/li[8]/a/span")).click();
			Thread.sleep(2000);
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//tbody/tr/td[2]/div/a/span"))).build().perform();
			Thread.sleep(2000);
			//点击删除，打开删除小弹窗；
			driver.findElement(By.xpath("//tbody/tr/td[2]/div/ul/li[2]/a")).click();
			//上面这行，要选择上面复制出来的那条，用来删掉，但是按路径找的话，不准确，
			//因为复制和新增是插在最后一行的，各个时间的行数不同，无法确定最后一行是第几，
			//因此，最好可以指定选择上面copy或者add那条。
			Thread.sleep(2000);
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//class[@id='dialog-header']/h5")));
			Thread.sleep(1000);
			//点击确认删除
			driver.findElement(By.xpath("//div[@class='dialog-button']/button")).click();
			Thread.sleep(1000);
		}
		
	    
	    @Test
	  	public void member() throws InterruptedException{
	    	WebBizHelper.member(driver);
	    }
	    
	    @Test
	  	public void goodSaleDetailedReport() throws InterruptedException{
	    	WebBizHelper.Report(driver);
	    	WebBizHelper.goodSaleDetailedReport(null, null, null, null, driver);
	    }
	    
	    @Test
	  	public void goodSaleReport() throws InterruptedException{
	    	WebBizHelper.Report(driver);
	    	WebBizHelper.goodSaleReport(null, null, null, driver);
	    }
	    
	    @Test
	  	public void statistics_ticket() throws InterruptedException{
	    	WebBizHelper.statistics(driver);
	    	WebBizHelper.statistics_ticket(driver);
	    }
	    
	    @Test
	  	public void statistics_consumer() throws InterruptedException{
	    	WebBizHelper.statistics(driver);
	    	WebBizHelper.statistics_consumer(driver);
	    }
	    
	    @Test
	  	public void statistics_good() throws InterruptedException{
	    	WebBizHelper.statistics(driver);
	    	WebBizHelper.statistics_good(driver);
	    }
	    
	    @Test
	  	public void statistics_film() throws InterruptedException{
	    	WebBizHelper.statistics(driver);
	    	WebBizHelper.statistics_film(null, null, driver);
	    }
	    
	    @Test
	  		public void SellGoodSalesManagement_onSaleAndHaltTheSale() throws InterruptedException {
		    	WebBizHelper.SellGoodSalesManagement_onSaleAndHaltTheSale(driver); //商品-卖品销售管理 -开售/停售
	  		}
	    
	    @Test
  		public void SellGoodSalesManagement_banthOnSaleAndBanthHaltTheSale() throws InterruptedException {
	    	WebBizHelper.SellGoodSalesManagement_banthOnSaleAndBanthHaltTheSale(driver); //商品-卖品销售管理 -批量开售/停售
  		}
	   
	    /*
	    @Test
  		public void modifyBannerSetting() throws InterruptedException {
	    	WebBizHelper.modifyBannerSetting(driver); //编辑banner
  		}
	    */
	    
}	


