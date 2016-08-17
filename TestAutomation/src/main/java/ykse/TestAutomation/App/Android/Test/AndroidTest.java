
package ykse.TestAutomation.App.Android.Test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import ykse.TestAutomation.App.Android.Common.*;
import ykse.TestAutomation.Common.*;
public class AndroidTest {
	private AppiumDriver<WebElement> driver;
	static Logger logger = new Log("app_android").logger;
	private static int sleepBase = AndroidBizHelper.sleepBase;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "deviceName", "platformVersion", "appPath", "appActivity", "ip", "port" })
	public void setUp(@Optional("613f015")String deviceName, @Optional("4.4.4")String platformVersion, @Optional("E:/ykse.apk")String appPath, @Optional("com.ykse.ticket.app.ui.activity.WelcomeActivity")String appActivity, @Optional("127.0.0.1")String ip,
			@Optional("4723")String port) throws Exception {

		driver = AndroidBizHelper.launchApp(deviceName, platformVersion, appPath, appActivity, ip, port);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		if (driver != null) {
			logger.debug("关闭APP");
			driver.closeApp();
		}
	}

	@BeforeMethod(alwaysRun = true)

	public void BeforeMethod() throws Exception {
		Thread.sleep(sleepBase * 1000);
		Boolean backToMainSuccess = AndroidBizHelper.backToMainActivity(driver);
		if(!backToMainSuccess)
		{
			logger.error("返回到主界面失败");
			
		}
		logger.info("****开始执行用例****");
		
		
	}
	
	@AfterMethod(alwaysRun = true)

	public void FinMethod() throws Exception {
		logger.info("****用例执行结束****");
		
	}

	// 检查热应影片
	@Test(groups = { "P0" })
	public void TC_start_cityChoose() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]查询");
		logger.info("[步骤_1]. 根据设备状态判断是否需要划屏进入主界面");
		if (!(Boolean) driver.getCapabilities().getCapability("noReset")) {
			
			AndroidBizHelper.cityChoose(driver);
			try{
				
			}catch(Exception e){
				
			}
		}
		else
		{
			logger.info("已设置noReset参数，不进行划屏操作");
		}
		
		logger.info("[检查点_1]. 判断UI界面是否存在用户按钮，检查是否已成功进入主界面");
	
		Boolean result = AndroidFunHelper.isElementDisplay("button_tv_user", driver);
		
		
		assertEquals(result, true);
	}

	@Test(groups = { "P0" })
	public void TC_my_login() throws Exception, InterruptedException, MalformedURLException {
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String account_category_code = TestData.FindValueInVariables("account_category_code");
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 开始登陆操作");
		AndroidBizHelper.login(phone_num, password, driver);
		
		logger.info("[检查点_1]. 根据数据库判断登陆用户是否正确");
		// 校验登录
		Connection con = null;
		String account_name = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt;
		stmt = con.createStatement();

		String selectSql = "select nickname from cif_account where account_id in (select account_id from cif_third_account where third_account_id=\""
				+ phone_num + "\") and account_category_code = \"" + account_category_code + "\"";
		ResultSet selectRes = stmt.executeQuery(selectSql);

		while (selectRes.next()) {
			account_name = selectRes.getString("nickname");
		}

		logger.info("数据库查询" + selectSql);
		logger.info("数据库查询到的用户名" + account_name);
		
		if(account_name == null){
			account_name = phone_num.substring(0,3)+"****"+phone_num.substring(phone_num.length()-4,phone_num.length()); ;
		}
		
		Thread.sleep(sleepBase * 1000);
		WebElement username = null;
		try {
			username = driver.findElementById("com.ykse.ticket:id/fu_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		AndroidFunHelper.PrintScreen(driver);

		assertEquals("Check login is correct", username.getText().contains(account_name), true);
		logger.info("校验成功");
	}

	@Test(groups = { "P0" })
	public void TC_my_loginbycard() throws Exception, InterruptedException, MalformedURLException {
		String cardnum = TestData.FindValueInVariables("cardnum_login");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String cityName = TestData.FindValueInVariables("cityName");
		String cinemaName = TestData.FindValueInVariables("cinemaName");
		String cinemaId = TestData.FindValueInVariables("cinemaId");
		AndroidBizHelper.backToMainActivity(driver);
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 开始登陆操作");
		
		AndroidBizHelper.login_cardlogin(cardnum, cardpassword, cityName, cinemaName, driver);
		
		logger.info("[检查点_1]. 根据数据库判断登陆用户是否正确");
		// 校验登录
		String account_name = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
					"root", "123456");
			Statement stmt = con.createStatement();

			String selectSql = "select account_name from cif_account WHERE account_id =(select account_id from card_member_relation where card_number =\""
					+ cardnum + "\"" + "and cinema_link_id =\"" + cinemaId + "\"" + ")";
			logger.info("数据库查询" + selectSql);
			ResultSet selectRes = stmt.executeQuery(selectSql);
			while (selectRes.next()) {
				account_name = selectRes.getString("account_name");
			}
		} catch (Exception e) {
			logger.error("MYSQL ERROR:" + e.getMessage());
		}
		logger.info(account_name);
		Thread.sleep(sleepBase * 2000);
		WebElement username = null;
		try {
			username = driver.findElementById("com.ykse.ticket:id/fu_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check cardlogin is correct", username.getText().contains(account_name), true);
		logger.info("校验成功");
	}

	@Test(groups = { "P0" })
	public void TC_my_forgetpassward() throws Exception, InterruptedException, MalformedURLException {
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 开始忘记密码操作");
		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
			AndroidBizHelper.login(phone_num, password, driver);
		} catch (Exception e) {
			logger.info("已登录");
		}
		AndroidBizHelper.forgetPassword(phone_num, password, driver);
		Thread.sleep(sleepBase * 2000);
		
		logger.info("[检查点_1]. 根据跳转页面判断是否成功");
		// 校验
		WebElement btn_login = driver.findElementById("com.ykse.ticket:id/btn_login");
		assertEquals("Check forgetPassword is correct", btn_login.getText().contains("登录"), true);
		logger.info("校验成功");
	}

	@Test
	(groups = { "P0" })
	public void TC_my_register() throws Exception, InterruptedException, MalformedURLException {
		
		String phone_num = TestData.FindValueInVariables("phoneNum_register");
		String password = TestData.FindValueInVariables("passWord");
		String channel_code = TestData.FindValueInVariables("channel_code");
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 开始注册操作");
		AndroidBizHelper.register(phone_num, password, channel_code, driver);

		logger.info("[检查点_1]. 根据数据库判断登陆用户是否正确");
		// 校验注册
		Connection con_cif = null;
		String account_name = null;
		WebElement username = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_cif = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_cif;
		stmt_cif = con_cif.createStatement();

		String selectSql_cif = "select nickname from cif.cif_account where account_id in (select account_id from cif.cif_third_account where third_account_id=\""
				+ phone_num + "\") and register_channel = \"" + channel_code + "\"";
		logger.info("数据库查询" + selectSql_cif);
		ResultSet selectRes_cif = stmt_cif.executeQuery(selectSql_cif);
		Thread.sleep(sleepBase * 10000);
		while (selectRes_cif.next()) {
			account_name = selectRes_cif.getString("nickname");
		}
		
		if(account_name == null){
			account_name = phone_num.substring(0,3)+"****"+phone_num.substring(phone_num.length()-4,phone_num.length()); ;
		}
		
		logger.info(account_name);
		try {
			username = driver.findElementById("com.ykse.ticket:id/fu_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check register is correct", username.getText().contains(account_name), true);
		logger.info("校验成功");

	}

	@Test(groups = { "P0" })
	public void TC_film_clickCinemaFromFilm() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]影院");
		logger.info("[步骤_1]. 通过影片选择影院");
		int res = AndroidBizHelper.clickCinemaFromFilm(driver);
		logger.info("[检查点_1]. 检查是否已点到预期影片");
		Assert.assertNotEquals(res, -1);
		
	}

	@Test(groups = { "P0" })
	public void TC_filmdetails_filmdetailstobuy() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[步骤_1]. 进入销售界面");	
		boolean res = AndroidBizHelper.click_buyTickets_on_filmsDetails(driver);
		logger.info("[检查点_1]. 检查是否已点到预期影片");
		Assert.assertEquals(res, true);
	}

	@Test(groups = { "P0" })
	public void TC_my_mycard_bingcard() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]会员卡");
		logger.info("[步骤_1]. 绑卡");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String cardnum = TestData.FindValueInVariables("cardNum");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String currentCity = TestData.FindValueInVariables("cityName");
		String cinemaName = TestData.FindValueInVariables("cinemaName");
		String carduser = TestData.FindValueInVariables("cardUser");
		String cardphonenum = TestData.FindValueInVariables("cardphoneNum");
		String idcard = TestData.FindValueInVariables("idCard");
		
		AndroidBizHelper.login(phone_num, password, driver);
		
		AndroidBizHelper.bingcard(cardnum, cardpassword, currentCity, cinemaName, carduser, idcard, cardphonenum,
				phone_num, driver);
		
		logger.info("[检查点_1]. 根据卡列表判断是否绑定会员卡成功");
		// 校验
		String value = UItree.FindValueInUItree("button_my_card_cardnum");
		logger.info("value: " + value);
		List<WebElement> cardnumshows = driver.findElementsById(value);
		String cardnumshow = null;
		for (int i = 0; i < cardnumshows.size(); i++) {
			cardnumshow = cardnumshows.get(i).getText();
			logger.info(cardnumshow);
			if (cardnumshow.equals(cardnum)) {
				break;
			}
		}
		assertEquals("Check currentCity is correct", cardnumshow.equals(cardnum), true);
		logger.info("校验成功");		
	}

	@Test(groups = { "P0" })
	public void TC_my_loginByUesr() throws Exception, InterruptedException, MalformedURLException {
		
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 使用普通用户进行登录");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String account_category_code = TestData.FindValueInVariables("account_category_code");
		AndroidBizHelper.loginByUesr(phone_num, password, driver);
		// 校验
		logger.info("[检查点_1]. 判断登陆的用户信息是否与数据库一致");
		Connection con = null;
		String account_name = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt;
		stmt = con.createStatement();

		String selectSql = "select nickname from cif_account where account_id in (select account_id from cif_third_account where third_account_id=\""
				+ phone_num + "\") and account_category_code = \"" + account_category_code + "\"";
		ResultSet selectRes = stmt.executeQuery(selectSql);
		Thread.sleep(sleepBase * 10000);

		while (selectRes.next()) {
			account_name = selectRes.getString("nickname");
		}

		logger.info("数据库查询" + selectSql);
		logger.info("数据库查询到的用户名" + account_name);
		Thread.sleep(sleepBase * 1000);
		
		if(account_name == null){
			account_name = phone_num.substring(0,3)+"****"+phone_num.substring(phone_num.length()-4,phone_num.length()); ;
		}
		
		WebElement username = null;
		try {
			username = driver.findElementById("com.ykse.ticket:id/fu_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals("Check currentCity is correct", username.getText().contains(account_name), true);

		
	}

	@Test(groups = { "P0" })
	public void TC_my_loginByUesr_notbingphone() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]登陆");
		logger.info("[步骤_1]. 使用未绑定手机的用户进行登陆");
		String userName = TestData.FindValueInVariables("userName");
		String password = TestData.FindValueInVariables("passWord");
		String account_category_code = TestData.FindValueInVariables("account_category_code");
		String bingPhone = "10000000000";
		
		AndroidBizHelper.backToMainActivity(driver);
		AndroidBizHelper.loginByUesr_notbingphone(bingPhone, userName, password, driver);
		// 校验
		logger.info("[检查点_1]. 判断登陆的用户信息是否与数据库一致");
		
		Connection con = null;
		String account_name = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt;
		stmt = con.createStatement();

		String selectSql = "select nickname from cif_account where account_id in (select account_id from cif_third_account where third_account_id=\""
				+ bingPhone + "\") and account_category_code = \"" + account_category_code + "\"";
		ResultSet selectRes = stmt.executeQuery(selectSql);
		Thread.sleep(sleepBase * 10000);

		while (selectRes.next()) {
			account_name = selectRes.getString("nickname");
		}

		logger.info("数据库查询" + selectSql);
		logger.info("数据库查询到的用户名" + account_name);
		Thread.sleep(sleepBase * 1000);
		
		if(account_name == null){
			account_name = bingPhone.substring(0,3)+"****"+bingPhone.substring(bingPhone.length()-4,bingPhone.length()); ;
		}
		
		WebElement user_name = null;
		try {
			user_name = driver.findElementById("com.ykse.ticket:id/fu_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		AndroidFunHelper.PrintScreen(driver);
		//logger.info(user_name.getText());
		
		assertEquals("Check userName is correct", user_name.getText().contains(account_name), true);

	}

	// 校验会员卡列表、卡折扣、卡类型
	@Test(groups = { "P0" })
	public void TC_my_mycard_list() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]会员卡");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String cardnum = TestData.FindValueInVariables("cardNum");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String currentCity = TestData.FindValueInVariables("cityName");
		String cinemaName = TestData.FindValueInVariables("cinemaName");
		String carduser = TestData.FindValueInVariables("cardUser");
		String cardphonenum = TestData.FindValueInVariables("cardphoneNum");
		String idcard = TestData.FindValueInVariables("idCard");
		
		logger.info("[步骤_1]. 判断是否已登录，及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		
		logger.info("[步骤_2]. 绑定会员卡");
		AndroidBizHelper.bingcard(cardnum, cardpassword, currentCity, cinemaName, carduser, idcard, cardphonenum,
				phone_num, driver);
		AndroidBizHelper.backToMainActivity(driver);
		Thread.sleep(sleepBase * 3000);
		
		logger.info("[步骤_3]. 查询卡列表");
		AndroidBizHelper.myCardList(driver);
		
		// 校验
		List<WebElement> cardList = null;
		WebElement cardDiscount = null;
		WebElement cardType = null;
		try {
			cardList = driver.findElementsById("com.ykse.ticket:id/lmc_member_card_message_layout");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cardDiscount = driver.findElementById("com.ykse.ticket:id/lmc_member_card_discount_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			cardType = driver.findElementById("com.ykse.ticket:id/lmc_member_card_type");
		} catch (Exception e) {
			e.printStackTrace();
		}

		AndroidFunHelper.PrintScreen(driver);

		logger.info("[检查点_1]. 校验已绑的卡是否存在");
		assertNotNull("Check myCardList is correct", cardList); // 校验已绑的卡是否存在case144
		logger.info("[检查点_2]. 校验已绑的卡是否显示折扣");
		assertNotNull("Check myCardDiscount is correct", cardDiscount.getText()); // 校验已绑的卡是否显示折扣case170
		logger.info("[检查点_2]. 校验已绑的卡是否显示类型");
		assertNotNull("Check myCardType is correct", cardType.getText()); // 校验已绑的卡是否显示类型case171
		logger.info("校验成功");
	}

	@Test(groups = { "P0" })
	public void TC_film_cityChoose() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]查询");
		String currentCity = TestData.FindValueInVariables("cityName");
		logger.info("[步骤_1]. 开始选择城市列表操作");
		AndroidBizHelper.cityChoose_by_film(currentCity, driver);

		logger.info("[检查点_1]. 校验城市列表是否存在城市");
		// 校验
		String value = UItree.FindValueInUItree("button_film_city");
		WebElement city = driver.findElementById(value);
		assertEquals("Check cityChoose_by_film is correct", city.getText(), currentCity);
		logger.info("校验成功");
	}

	@Test(groups = { "P0" })
	public void TC_cinema_cityChoose() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]查询");
		String currentCity = TestData.FindValueInVariables("cityName");
		logger.info("[步骤_1]. 开始选择城市列表操作");
		AndroidBizHelper.cityChoose_by_cinema(currentCity, driver);

		logger.info("[检查点_1]. 校验城市列表是否存在城市");
		// 校验
		String value = UItree.FindValueInUItree("button_film_city");
		WebElement city = driver.findElementById(value);
		assertEquals("Check cityChoose_by_cinema is correct", city.getText(), currentCity);
		logger.info("校验成功");
	}


	@Test(groups = { "P0" })
	// 影院列表进入排期，用例27
	public void TC_film_checkFilmList() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]影片");
		logger.info("[步骤_1]. 点击进入“影院”列表");
		AndroidBizHelper.clickCinemaFromFilm(driver);// 点击进入“影院”列表
		logger.info("[步骤_2]. 开始影院列表进入排期操作");
		boolean isPass = AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1]. 校验影院列表进入排期是否成功");
		assertEquals("Check check_filmList_on_Scheduling", isPass, true);
		logger.info("校验成功");
	}


	@Test(groups = { "P0" })
	// 仅购买卖品，用例35
	public void TC_good_checkGood() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]卖品");
		logger.info("[步骤_1]. 判断是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 开始只买卖品操作");
		boolean isPass = AndroidBizHelper.buy_good_only(driver);
		logger.info("[检查点_1]. 校验卖品");
		assertEquals("Check buy_good_only", isPass, true);
		logger.info("校验成功");
	}

	@Test(groups = { "P1" })
	// 划动影片,用例40
	public void TC_swich_film() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]影片");
		logger.info("[步骤_1]. 点击进入“影院”列表");
		AndroidBizHelper.clickCinemaFromFilm(driver);
		logger.info("[步骤_2]. 划动影片");
		boolean isPass = AndroidBizHelper.swich_film(driver);
		logger.info("[检查点_1]. 校验滑动是否成功");
		assertEquals("Check swich_film", isPass, true);
		logger.info("校验成功");
	}

	@Test(groups = { "P0" })
	// 影片选影院；排期列表购票；选座；选卖品
	public void TC_confirm_order() throws Exception, InterruptedException, MalformedURLException {
		// 影片选影院，用例8
		logger.info("[FeatureName]下单");
		logger.info("[步骤_1]. 判断是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		
		logger.info("[步骤_2]. 开始影片选影院操作");
		boolean isPass1 = false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver) != -1) {
			isPass1 = true;
		}
		logger.info("[检查点_1]. 校验影片选影院是否成功");
		assertEquals("Check film_to_cinema", isPass1, true);
		logger.info("影片选影院通过");
		
		logger.info("[步骤_3]. 开始排期列表购票操作");
		// 排期列表购票，用例27
		boolean isPass2 = AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1]. 校验排期列表购票是否成功");
		assertEquals("Check check_filmList_on_Scheduling", isPass2, true);
		logger.info("排期列表购票通过");
		
		// 选座
		logger.info("[步骤_4]. 开始选座操作");
		AndroidBizHelper.lockSeats(1, driver);
		
		//选卖品
		logger.info("[步骤_5]. 开始选卖品操作");
		boolean isPass3=false;
		if(AndroidBizHelper.goodChoose(driver)!=0)
		{
			isPass3=true;
		}
		logger.info("[检查点_2]. 校验卖品是否成功");
		assertEquals("Check goodChoose", isPass3, true);		
		//选择优惠方式
	/*	boolean isPass4=AndroidBizHelper.discountChosen(driver);
		AndroidFunHelper.clickElementById("button_confirmOrder_ensure", driver);
		//输入手机号并点击确认订单		
		String phoneNum=variables.FindValueInVariables("cardphoneNum");
		AndroidBizHelper.inputPhoneNumber(phoneNum, driver);
	    //会员卡最终支付，校验是否支付成功
		String cardpassWord=variables.FindValueInVariables("cardpassWord");
		assertEquals("Check cardPay", AndroidBizHelper.cardPay(cardpassWord,driver), true);	
		
   */
	}

	@Test(groups = { "P0" })
	public void TC_my_card_cardInfo() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]会员卡");
		String cardnum = TestData.FindValueInVariables("cardNum");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String carduser = TestData.FindValueInVariables("cardUser");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		
		logger.info("[步骤_1]. 开始登录操作");
		AndroidBizHelper.login(phone_num, password, driver);
		
		logger.info("[步骤_2]. 开始查询卡详情操作");
		AndroidBizHelper.my_card_cardInfo(cardnum, cardpassword, driver);

		// 校验
		logger.info("[检查点_1]. 校验卡详情是否成功");
		WebElement card_User = null;
		try {
			card_User = driver.findElementById("com.ykse.ticket:id/amcd_member_card_user_name_tv");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check my_card_cardInfo is correct", card_User.getText(), carduser);
		logger.info("校验成功");
	}

	@Test
	public void TC_my_card_cardInfo_record() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]会员卡");
		logger.info("[步骤_1]. 卡消费充值记录case开始");
		String cardnum = TestData.FindValueInVariables("cardNum");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		AndroidBizHelper.login(phone_num, password, driver);
		AndroidBizHelper.my_card_cardInfo_record(cardnum, cardpassword, driver);
		
		logger.info("[检查点_1]. 校验充值记录页面是否成功");
		List<WebElement> recharge = null;
		try {
			recharge = driver.findElementsById("com.ykse.ticket:id/lmcr_type_text");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check my_card_cardInfo_recordByRecharge is correct", recharge.get(0).getText(), "充值");
		logger.info("充值记录页面校验成功");

		logger.info("[检查点_2]. 校验消费记录页面是否成功");
		// 消费记录&校验
		AndroidFunHelper.clickElementById("button_my_card_cardinfo_record_consumption", driver);
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入消费记录页面");

		List<WebElement> consumption = null;
		try {
			consumption = driver.findElementsById("com.ykse.ticket:id/lmcr_type_text");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check my_card_cardInfo_recordByConsumption is correct", consumption.get(0).getText(), "消费");
		logger.info("消费记录页面校验成功");
	}

	@Test(groups = { "P1" })
	public void TC_my_card_cardInfo_unbing() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]会员卡");
		logger.info("[步骤_1]. 会员卡解绑操作开始");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String cardnum = TestData.FindValueInVariables("cardNum");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String currentCity = TestData.FindValueInVariables("cityName");
		String cinemaName = TestData.FindValueInVariables("cinemaName");
		String carduser = TestData.FindValueInVariables("cardUser");
		String cardphonenum = TestData.FindValueInVariables("cardphoneNum");
		String idcard = TestData.FindValueInVariables("idCard");
		AndroidBizHelper.login(phone_num, password, driver);
		AndroidBizHelper.my_card_cardInfo_unbing(cardnum, cardpassword, currentCity, cinemaName, carduser, idcard,
				cardphonenum, phone_num, driver);

		logger.info("[检查点_1]. 校验会员卡解绑是否成功");
		// 校验
		String value = UItree.FindValueInUItree("button_my_card_cardnum");
		logger.info("value: " + value);
		List<WebElement> cardnumshows = driver.findElementsById(value);
		String cardnumshow = null;
		for (int i = 0; i < cardnumshows.size(); i++) {		
			if (cardnumshows.get(i).getText().equals(cardnum)) {
				cardnumshow = cardnumshows.get(i).getText();
				logger.info(cardnumshow);
				break;
			}
		}
		assertNull("Check my_card_cardInfo_unbing is correct", cardnumshow); // 为空则说明卡列表没有此卡，验证通过
		logger.info("校验成功");

		logger.info("[步骤_2]. 重新绑卡操作");
		// 重新绑卡
		AndroidBizHelper.backToMainActivity(driver);
		AndroidBizHelper.bingcard(cardnum, cardpassword, currentCity, cinemaName, carduser, idcard, cardphonenum,
				phone_num, driver);
		logger.info("重新绑卡成功");
	}

	@Test(groups = { "P0" })
	public void TC_order_payWithCard() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]支付");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片紧影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 选座操作");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1].影院到座位图是否成功");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		
		logger.info("[步骤_4]. 选卖品操作");
		AndroidBizHelper.chooseGood(true,driver);
		logger.info("[步骤_5]. 输入手机号码操作");
		AndroidBizHelper.eidtOrderPhoneNum(driver);
		logger.info("[步骤_6]. 下单操作");
		AndroidBizHelper.creatOrderWithCard(true,driver);
		boolean isPass = AndroidBizHelper.payWithCard(driver);
		
		logger.info("[检查点_2]. 会员卡支付是否成功");
		assertEquals("Check payWithCard",isPass,true);
		//校验卖品
		

		//Boolean isPass = AndroidBizHelper.check_filmList_on_Scheduling(driver);		

	}
	
	@Test(groups = { "P0" })
	public void TC_order_payWithCardNoActivity() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]支付");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片紧影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 选座操作");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1].影院到座位图是否成功");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选卖品操作");
		AndroidBizHelper.chooseGood(true,driver);
		logger.info("[步骤_5]. 输入手机号码操作");
		AndroidBizHelper.eidtOrderPhoneNum(driver);
		logger.info("[步骤_6]. 下单操作");
		AndroidBizHelper.creatOrderWithCard(false,driver);
		boolean isPass = AndroidBizHelper.payWithCard(driver);
		logger.info("[检查点_2]. 会员卡支付是否成功");
		assertEquals("Check payWithCard",isPass,true);
		//校验卖品
		

		//Boolean isPass = AndroidBizHelper.check_filmList_on_Scheduling(driver);		

	}
	
	@Test(groups = { "P1" })
	public void TC_order_payWithCardNoActivityInDetail() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]支付");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片紧影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 选座操作");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1].影院到座位图是否成功");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选卖品操作");
		AndroidBizHelper.chooseGood(true,driver);
		logger.info("[步骤_5]. 输入手机号码操作");
		AndroidBizHelper.eidtOrderPhoneNum(driver);
		logger.info("[步骤_6]. 下单操作");
		AndroidBizHelper.creatOrderWithCard(false,driver);
		boolean isPass = AndroidBizHelper.closePayWithCard(driver);
		logger.info("[检查点_2]. 会员卡支付是否成功");
		assertEquals("Check payWithCard",isPass,true);
		//校验卖品
		

		//Boolean isPass = AndroidBizHelper.check_filmList_on_Scheduling(driver);		

	}
	
	@Test(groups = { "P0" })
	public void TC_order_chooseGood() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]卖品");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片紧影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 选座操作");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1].影院到座位图是否成功");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选卖品操作");
		boolean isPass = AndroidBizHelper.chooseGood(true,driver);
		logger.info("[检查点_2]. 选座卖品是否成功");
		assertEquals("Check chooseGoods",isPass,true);
		//校验卖品
		

		//Boolean isPass = AndroidBizHelper.check_filmList_on_Scheduling(driver);		

	}
	
	@Test(groups = { "P0" })
	public void TC_my_card_applyForCard() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]支付");
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		String cardpassword = TestData.FindValueInVariables("cardpassWord");
		String currentCity = TestData.FindValueInVariables("cityName");
		String cinemaName = TestData.FindValueInVariables("cinemaName");
		String carduser = TestData.FindValueInVariables("cardUser");
		String cardphonenum = TestData.FindValueInVariables("cardphoneNum");
		String idcard = TestData.FindValueInVariables("idCard");
		String cardType = TestData.FindValueInVariables("cardType");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 申请会员卡操作");
		AndroidBizHelper.my_card_applyForCard(cardType, cardpassword, currentCity, cinemaName, carduser, idcard, cardphonenum, phone_num, driver);
		
		//校验
		logger.info("[检查点_1]. 申请会员卡是否成功");
		WebElement applyPayTittle = null;
		try{
			applyPayTittle = driver.findElementById("com.ykse.ticket:id/ihb_tv_name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Check my_card_cardInfo_unbing is correct", applyPayTittle.getText().contains(cardType),true);
		logger.info("测试通过");
	}
	
	@Test(groups = { "P0" })
	public void TC_order_noCoupon() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]支付");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片紧影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
	
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 选座操作");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选择卖品操作");
		AndroidBizHelper.chooseGood(true,driver);
		
		//AndroidFunHelper.clickElementById("button_order_activity", driver);
		
		//校验
		logger.info("[检查点_1]. 检测没有券功能是否成功");
		WebElement coupon = null;
		try{
			coupon = driver.findElementByClassName("button_order_coupon");
		}catch(Exception e){
			logger.info("没有找到输入券框");
		}
		assertNull("Check TC_order_noCoupon is correct",coupon);
		logger.info("测试通过");
	}
	
	@Test(groups = { "P0" })
	public void TC_order_addCoupon() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]券");
		logger.info("[步骤_1]. 添加优惠券");
		//判断是否已登录
		AndroidBizHelper.judgeLogin_and_login(driver);
		
		//进入确认订单
		String coupon_num = AndroidBizHelper.addCoupon(1, driver);
		logger.info("[检查点_1]. 检查添加优惠券是否成功");
		//校验
		WebElement payType = driver.findElementById("com.ykse.ticket:id/aco_vou_message_tv");
		assertEquals("Check TC_order_addCoupon is correct", payType.getText().contains("选择了"),true);
		
	}
	
	@Test(groups = { "P0" })
	public void TC_order_couponPay() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]券");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		//判断是否已登录
		AndroidBizHelper.judgeLogin_and_login(driver);
		
		//下单
		logger.info("[步骤_2]. 添加券操作");
		String allCoupon = AndroidBizHelper.addCoupon(1, driver);
		AndroidFunHelper.clickElementById("button_order_ensure", driver);
		Thread.sleep(sleepBase * 10000);
		
		//校验
		logger.info("[检查点_1]. 检测券功能是否成功");
		String value = UItree.FindValueInUItree("button_paySuccess_checkTicket");
		WebElement paySuccess_checkTicket = null;
		try{
			paySuccess_checkTicket = driver.findElementById(value);
		}catch(Exception e){
			logger.error("找不到查看电影票按钮");
		}
		assertNotNull("Check TC_order_couponPay is correct",paySuccess_checkTicket);
		
		//后置动作，将使用的兑换券修改为未使用状态
		logger.info("[步骤_3]. 后置动作，将使用的兑换券修改为未使用状态");
		Connection con = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@172.33.0.83:1521:GVDB", "gvdba", "manager");
		Statement stmt;
		stmt = con.createStatement();
		String selectSql = "UPDATE gv_comp_pass_vouchers set cpv_redeemed_flg = 'N' where cpv_barcode in ("
		+allCoupon+")";
		long selectRes = stmt.executeUpdate(selectSql);
		logger.info("SQL_UPDATE:" + selectRes);
		logger.info("修改成功");		
	}

	@Test(groups = { "P1" })
	public void TC_order_addTwoCoupon() throws Exception, InterruptedException, MalformedURLException {	
		logger.info("[FeatureName]券");
		//判断是否已登录
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		
		//进入确认订单
		logger.info("[步骤_2]. 添加券操作");
		AndroidBizHelper.addCoupon(2, driver);
		
		//校验
		logger.info("[检查点_1]. 检测券功能是否成功");
		WebElement payType = driver.findElementById("com.ykse.ticket:id/aco_pay_method");
		assertEquals("Check TC_order_addTwoCoupon is correct", payType.getText().contains("选择了"),true);
		logger.info("测试通过");
	}
	
	@Test(groups = { "P0" })
	public void TC_click_LockSeatsFromFilm() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]座位");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片选影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}			
		logger.info("影片选影院通过"); 
		logger.info("[步骤_3]. 进入选座页");
		for(int i = 0; i < 3; i++){
			List<WebElement> day = driver.findElementsById("com.ykse.ticket:id/layout_schedule_date_item");
			day.get(i).click();
			try{
				AndroidFunHelper.clickElementById("button_film_filmToLockSeat", driver);
				logger.info("成功点击选座入口");
			}catch(Exception e){
				logger.warn("没有找到选座入口");			
			}
		}
		//校验
		logger.info("[检查点_1]. 选座页是否成功");
		List<WebElement> lable = driver.findElementsById(UItree.FindValueInUItree("lable_seat_selected"));
		for (int i = 0; i < lable.size(); i++) {
			if(i==0) assertEquals("Check TC_click_LockSeatsFromFilm is correct", 
					lable.get(i).getText().contains("可选"),true);
			if(i==1) assertEquals("Check TC_click_LockSeatsFromFilm is correct", 
					lable.get(i).getText().contains("已售"),true);
			if(i==2) assertEquals("Check TC_click_LockSeatsFromFilm is correct", 
					lable.get(i).getText().contains("已选"),true);
			if(i==3) assertEquals("Check TC_click_LockSeatsFromFilm is correct", 
					lable.get(i).getText().contains("最佳观影区"),true);			
		}
		logger.info("测试通过");
	}
	
	@Test(groups = { "P1" })
	public void TC_detail_refunTicketGood() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]退单");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片选影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 进入选座页");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1]. 选座页通过");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选座卖品操作");
		AndroidBizHelper.chooseGood(true,driver);
		logger.info("[步骤_5]. 输入手机号码");
		AndroidBizHelper.eidtOrderPhoneNum(driver);
		logger.info("[步骤_6]. 会员卡下单");
		AndroidBizHelper.creatOrderWithCard(false,driver);
		AndroidBizHelper.payWithCard(driver);
		logger.info("[步骤_7]. 退票操作");
		AndroidBizHelper.refunTicket(driver);
		
		//校验
		logger.info("[检查点_2]. 退票是否成功");
		WebElement refund = null;
		try{
			refund = driver.findElementById("com.ykse.ticket:id/amod_bottom_status_tv");
		}catch(Exception e){
			logger.warn("找不到退款信息");
		}
		assertEquals("Check TC_detail_refunTicketGood is correct", refund.getText().contains("退款"),true);
		logger.info("测试通过");
	}
	
	@Test(groups = { "P1" })
	public void TC_detail_refunTicket() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]退单");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 影片选影院操作");
		boolean isPass1=false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver)!=-1)
		{
			isPass1=true;
		}		
		
		logger.info("影片选影院通过");
		logger.info("[步骤_3]. 进入选座页");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap( 1, driver);
		//cinemas_name = selectRes_notifycenter.getString("cinema_name");
		//排期列表购票，用例27
		//=AndroidBizHelper.check_filmList_on_Scheduling(driver);
		logger.info("[检查点_1]. 选座页通过");
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		//选卖品
		logger.info("[步骤_4]. 选座卖品操作");
		AndroidBizHelper.chooseGood(false,driver);
		logger.info("[步骤_5]. 输入手机号码");
		AndroidBizHelper.eidtOrderPhoneNum(driver);
		logger.info("[步骤_6]. 会员卡下单");
		AndroidBizHelper.creatOrderWithCard(false,driver);
		AndroidBizHelper.payWithCard(driver);
		logger.info("[步骤_7]. 退票操作");
		AndroidBizHelper.refunTicket(driver);
		
		//校验
		logger.info("[检查点_2]. 退票是否成功");
		WebElement refund = null;
		try{
			refund = driver.findElementById("com.ykse.ticket:id/amod_bottom_status_tv");
		}catch(Exception e){
			logger.warn("找不到退款信息");
		}
		assertEquals("Check TC_detail_refunTicketGood is correct", refund.getText().contains("退款"),true);
		logger.info("测试通过");
	}
	
	@Test(groups = { "P0" })
	public void TC_choose_onlyBayGood() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]下单");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 只买卖品操作");
		AndroidBizHelper.buy_good_only(driver);
		logger.info("[步骤_3]. 选座卖品操作");
		boolean isPass = AndroidBizHelper.chooseGood(true, driver);
		logger.info("[检查点_1]. 选座卖品通过");
		assertEquals("Check TC_choose_onlyBayGood is correct", isPass, true);	
	}
	
	@Test(groups = { "P0" })
	public void TC_order_onlyBuyGood() throws Exception, InterruptedException, MalformedURLException {
		logger.info("[FeatureName]下单");
		String cardNum = TestData.FindValueInVariables("cardNum");
		String cardpassWord = TestData.FindValueInVariables("cardpassWord");
		logger.info("[步骤_1]. 查看是否已登录及登录操作");
		AndroidBizHelper.judgeLogin_and_login(driver);
		logger.info("[步骤_2]. 只买卖品操作");
		boolean isPass =AndroidBizHelper.order_onlyBayGoo(cardNum, cardpassWord, driver);
		logger.info("[检查点_1]. 选座卖品通过");
		assertEquals("Check TC_choose_onlyBayGood is correct", isPass, true);
	}

}

