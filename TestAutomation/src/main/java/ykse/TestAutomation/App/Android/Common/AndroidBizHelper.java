package ykse.TestAutomation.App.Android.Common;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import ykse.TestAutomation.App.Android.Common.*;
import ykse.TestAutomation.Common.*;

public class AndroidBizHelper {
	public static int sleepBase = 1;
	static Logger logger = new Log("app_android").logger;

	public static AndroidDriver<WebElement> launchApp(String deviceName, String platformVersion, String appPath,
			String appActivity, String ip, String port) throws InterruptedException, MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", appPath);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		capabilities.setCapability("appActivity", appActivity);
		logger.info("****加载APP****");
		return new AndroidDriver<WebElement>(new URL("http://" + ip + ":" + port + "/wd/hub"), capabilities);
	}

	public static Boolean judgeLogin_and_login(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String phone_num = TestData.FindValueInVariables("phoneNum");
		String password = TestData.FindValueInVariables("passWord");
		
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_tv_user", driver);		
		Thread.sleep(sleepBase * 2000);
		
		WebElement loginBtn = null;
		
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
			AndroidBizHelper.login(phone_num, password, driver);
			return true;
		} catch (Exception e) {
			logger.info("已登录");
			return false;
		}
	}

	public static Boolean backToMainActivity(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		// 返回到主界面
		logger.info("[前置步骤_1]. 尝试返回到主界面");
		AndroidFunHelper.PrintScreen(driver);
		Boolean isSuccess = false;
		String ElementValueInMain = UItree.FindValueInUItree("button_tv_user");

		try {
			Thread.sleep(sleepBase * 2000);
			driver.findElementById(UItree.FindValueInUItree("button_film_cancle")).click();
			
		} catch (Exception e) {
			logger.debug("不需要切换城市");
		}

		for (int i = 0; i < 8; i++) {
			try {
				if (driver.findElementById(ElementValueInMain).isDisplayed()) {
					logger.info("已返回到主界面");
					isSuccess = true;
					break;
				}
			} catch (NoSuchElementException em) {
				try {

					driver.findElementById(UItree.FindValueInUItree("button_header_back")).click();
				} catch (NoSuchElementException e) {
					try {
						driver.findElementById(UItree.FindValueInUItree("button_back")).click();

					} catch (NoSuchElementException ex) {

						try {

							driver.findElementById(UItree.FindValueInUItree("button_card_back")).click();
						} catch (NoSuchElementException exx) {

							try {

								driver.findElementById(UItree.FindValueInUItree("button_my_card_bingcard")).click();
							} catch (NoSuchElementException exxx) {

								try {
									driver.findElementById(UItree.FindValueInUItree("button_goodList_back")).click();
								} catch (NoSuchElementException exxxx) {

									try {

										driver.findElementById(UItree.FindValueInUItree("button_seat_warning")).click();
									} catch (NoSuchElementException exxxxx) {
										try {
											driver.findElementById(
													UItree.FindValueInUItree("button_order_card_impl_close")).click();
										} catch (NoSuchElementException exxxxxx) {

											try {
												driver.findElementById(UItree.FindValueInUItree("button_film_cancle"))
														.click();

											} catch (Exception e7) {
												try {
													driver.findElementById(UItree
															.FindValueInUItree("lable_button_cinema_search_break"))
															.click();

												} catch (Exception e8) {
													logger.debug("找不到返回按钮");
												}
											}

										}

									}

								}

							}

						}

					}
				}

			}
		}
		if (isSuccess == false)
			logger.warn("返回到主界面失败");
		return isSuccess;

	}

	public static void cityChoose(AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 5000);
		// 滑动屏幕并选择城市进入主页面
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.swipeScreenToRight(3, driver);
		AndroidFunHelper.clickElementById("button_start_start", driver);
		Thread.sleep(sleepBase * 5000);
		String cityName = TestData.FindValueInVariables("cityName");
		AndroidFunHelper.findElementAndClick("button_city_cityList", cityName, driver);
		Thread.sleep(sleepBase * 3000);
		try {
			AndroidFunHelper.clickElementById("button_film_cancle", driver);
		} catch (Exception e) {
			logger.info("没有找到切换城市的取消按钮");
		}
		// 校验
		String value = UItree.FindValueInUItree("button_film_city");
		WebElement city = driver.findElementById(value);
		assertEquals("Check cityChoose_by_cinema is correct", city.getText(), cityName);

	}

	public static void logout(AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {

		// 登出
		AndroidFunHelper.clickElementById("text_user_login_setting_layout", driver);
		Thread.sleep(sleepBase * 2000);
		for (int i = 1; i <= 10; i++) {
			try {
				AndroidFunHelper.clickElementById("button_user_btn_logout", driver);
			} catch (Exception e) {
			}
			Thread.sleep(sleepBase * 2000);
			try {
				AndroidFunHelper.clickElementById("button_user_btn_logout_sure", driver);
			} catch (Exception e) {
			}
			Thread.sleep(sleepBase * 5000);
			try {
				driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
				logger.info("登出成功");
				break;
			} catch (Exception e) {
				logger.error("登出失败,重试");
			}
			logger.info("尝试登出" + i + "次");
		}
	}

	public static void login(String phone_num, String password, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {

		logger.info("Start to app login");

		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_tv_user", driver);
		Thread.sleep(sleepBase * 2000);

		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
		} catch (Exception e) {
			logger.info("已登录");
		}
		if (loginBtn == null) {
			logout(driver);
		}

		AndroidFunHelper.clickElementById("button_user_login", driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.sendKeysById("text_user_login_edit_phone_num", phone_num, driver);
		AndroidFunHelper.sendKeysById("text_user_login_edit_password", password, driver);
		AndroidFunHelper.clickElementById("button_user_login_login", driver);
		Thread.sleep(sleepBase * 2000);
	}

	public static Boolean lockSeats(int Num, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String Popup = UItree.FindValueInUItree("button_seat_warning");

		try {
			while (driver.findElementById(Popup).isDisplayed()) {

				AndroidFunHelper.clickElementById("button_seat_warning", driver);
			}

		} catch (Exception e) {

			logger.warn("选座前的弹窗清理完毕");

		}
		int i = 1;
		for (; i < 15; i++) {

			try {
				Point Rect = driver.findElementById(UItree.FindValueInUItree("pic_film_seats_view")).getLocation();
				TouchAction gesture = new TouchAction(driver).press(Rect.x + i * 80, Rect.y + i * 80).release()
						.perform();
				driver.performTouchAction(gesture);
				Thread.sleep(sleepBase * 2000);
				logger.info(driver.findElement(By.id("com.ykse.ticket:id/as_has_select_seat")).getText());
				logger.info(
						driver.findElement(By.id("com.ykse.ticket:id/as_has_select_seat")).getText().contains(Num + "")
								+ "");
				if (driver.findElement(By.id("com.ykse.ticket:id/as_has_select_seat")).getText().contains(Num + "")) {

					driver.findElement(By.id(UItree.FindValueInUItree("button_film_seats_ensureSeat"))).click();
					break;
				}

			} catch (Exception e) {
				logger.warn("座位已被锁");

				continue;
			}

		}
		if (i == 10) {
			logger.error("锁座失败");
			return false;
		}
		return true;

	}

	// 在选择影院列表后，进入对应排期购票
	public static Boolean cinemaToSeatsMap(int Num, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {

		try {
			String cinemaName = TestData.FindValueInVariables("cinemaName");
			AndroidFunHelper.findElementAndClick("lable_cinema_filmname", cinemaName, driver);
			Thread.sleep(sleepBase * 5000);
			AndroidFunHelper.findElementIndexAndClick("index_schedule_data", Num, driver);
			Thread.sleep(sleepBase * 3000);
			AndroidFunHelper.findElementIndexAndClick("button_buy_ticket", 0, driver);
			Thread.sleep(sleepBase * 5000);
			lockSeats(1, driver);

		} catch (Exception e) {
			logger.error("无法从城市列表进入第" + Num + "个排期");
			e.printStackTrace();
			return false;

		}
		return true;

	}

	public static Boolean chooseGood(Boolean needChoose, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		Boolean isPass = true;

		if (needChoose) {
			List<WebElement> goodLis = driver.findElementsByClassName("android.widget.LinearLayout");		
			List<WebElement> goodLisChoose = goodLis.get(1).findElements(By.className("android.widget.Button"));
			WebElement plus = goodLisChoose.get(1);
			plus.click();
			//AndroidFunHelper.clickElementByLinkText("button_goodList_plus", driver);
			isPass = AndroidFunHelper.findElementIsDisplay("lable_goodList_selected", "卖品", driver);

		}
		AndroidFunHelper.clickElementById("lable_goodList_buy", driver);
		Thread.sleep(sleepBase * 3000);

		logger.info("确认卖品订单信息");
		return isPass;

	}

	public static Boolean creatOrderWithCard(Boolean needDiscount, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String cardNum = TestData.FindValueInVariables("cardNum");
		if (needDiscount) {
			try {
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.clickElementById("button_order_activity", driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.findElementAndClick("button_order_discount_cardNum", cardNum, driver);
				Thread.sleep(sleepBase * 5000);
				AndroidFunHelper.clickElementById("button_order_discount_sure", driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.clickElementById("button_order_ensure", driver);
				Thread.sleep(sleepBase * 3000);
				//选择卡支付&下单3.2版本
				AndroidFunHelper.clickElementById("button_confirmOrder_discount_sure", driver);
				Thread.sleep(sleepBase * 5000);
			} catch (Exception e) {
				logger.error("无法下单");
				e.printStackTrace();
				return false;

			}
		} else

		{
			try {
				Thread.sleep(sleepBase * 3000);
				// 选择优惠为无优惠
				AndroidFunHelper.clickElementById("button_order_activity", driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.findElementAndClick("button_order_select_activity", "不参与优惠", driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.clickElementById("button_order_discount_sure", driver);
				Thread.sleep(sleepBase * 3000);
				// 选座卡支付3.1版本
				//AndroidFunHelper.clickElementById("button_order_payType", driver);
				//Thread.sleep(sleepBase * 3000);
				//AndroidFunHelper.findElementAndClick("button_order_discount_cardNum", cardNum, driver);
				//AndroidFunHelper.clickElementById("button_confirmOrder_discount_sure", driver);
				//Thread.sleep(sleepBase * 5000);
				// 选择卡支付&下单3.2版本
				AndroidFunHelper.clickElementById("button_order_ensure", driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.findElementAndClick("button_order_discount_cardNum", cardNum, driver);
				Thread.sleep(sleepBase * 3000);
				AndroidFunHelper.clickElementById("button_confirmOrder_discount_sure", driver);
				Thread.sleep(sleepBase * 5000);
			} catch (Exception e) {
				logger.error("无法下单");
				e.printStackTrace();
				return false;

			}

		}
		return true;

	}

	public static Boolean payWithCard(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String cardpassWord = TestData.FindValueInVariables("cardpassWord");
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_order_card_impl_ensure", driver);
		Thread.sleep(sleepBase * 10000);
		try {			
			AndroidFunHelper.sendKeysById("button_order_card_impl_password", cardpassWord, driver);

			AndroidFunHelper.clickElementById("button_order_card_impl_ensure", driver);

			Thread.sleep(sleepBase * 10000);
			if (!AndroidFunHelper.findElementIsDisplay("text_order_ihwrt", "付款成功", driver)) {
				return false;
			}
		} catch (Exception e) {
			logger.error("无法支付");
			e.printStackTrace();
			return false;

		}
		return true;

	}

	public static Boolean closePayWithCard(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String cardpassWord = TestData.FindValueInVariables("cardpassWord");
		AndroidFunHelper.clickElementById("button_order_card_impl_ensure", driver);
		try {
			Thread.sleep(sleepBase * 2000);

			AndroidFunHelper.clickElementById("button_order_card_impl_close", driver);
			Thread.sleep(sleepBase * 2000);
			AndroidFunHelper.clickElementById("button_order_buy", driver);
			Thread.sleep(sleepBase * 2000);
			AndroidFunHelper.sendKeysById("button_order_card_impl_password", cardpassWord, driver);
			Thread.sleep(sleepBase * 2000);
			AndroidFunHelper.clickElementById("button_order_card_impl_ensure", driver);
			Thread.sleep(sleepBase * 10000);
			if (!AndroidFunHelper.findElementIsDisplay("text_order_ihwrt", "付款成功", driver)) {
				return false;
			}
		} catch (Exception e) {
			logger.error("无法支付");
			e.printStackTrace();
			return false;

		}
		return true;

	}

	public static Boolean eidtOrderPhoneNum(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		String phone_num = TestData.FindValueInVariables("phoneNum");

		try {
			Thread.sleep(sleepBase * 3000);
			AndroidFunHelper.clickElementById("button_order_eidt_phone", driver);
			Thread.sleep(sleepBase * 3000);
			AndroidFunHelper.sendKeysById("text_order_phonenum", phone_num, driver);
			AndroidFunHelper.clickElementById("button_order_eidt_phone_finish", driver);
		} catch (Exception e) {
			logger.error("无法下单");
			e.printStackTrace();
			return false;

		}
		return true;

	}

	public static void login_cardlogin(String cardnum, String cardpassword, String cityName, String cinemaName,
			AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {
		logger.info("Start to Login By Card");

		AndroidFunHelper.clickElementById("button_tv_user", driver);
		Thread.sleep(sleepBase * 2000);

		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
		} catch (Exception e) {
			logger.info("已登录");
		}
		if (loginBtn == null) {
			logout(driver);
		}

		AndroidFunHelper.clickElementById("button_user_login", driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.clickElementById("button_user_login_cardlogin", driver); // 会员卡登录
		Thread.sleep(sleepBase * 1000);

		AndroidFunHelper.clickElementById("button_user_login_cardlogin_choosecity", driver); // 选择城市
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.findElementAndClick("button_city_cityList", cityName, driver);
		Thread.sleep(sleepBase * 1000);

		AndroidFunHelper.clickElementById("button_user_login_cardlogin_choosecinema", driver); // 选择影院

		Thread.sleep(sleepBase * 3000);
		// 点击影院名称
		AndroidFunHelper.findElementAndClick("button_user_login_cardlogin_choosecinema_cinema", cinemaName, driver);

		Thread.sleep(sleepBase * 1000);

		AndroidFunHelper.sendKeysById("text_user_login_cardlogin_cardnum", cardnum, driver); // 输入卡号密码登录
		AndroidFunHelper.sendKeysById("text_user_login_cardlogin_cardpassword", cardpassword, driver);
		AndroidFunHelper.clickElementById("button_user_login_cardlogin_login", driver);
		Thread.sleep(sleepBase * 2000);
	}

	public static void register(String phone_num, String password, String channel_code, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {

		String verification = null;

		// 删除注册信息
		Connection con_delete = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_delete = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_delete;
		stmt_delete = con_delete.createStatement();

		String selectSql_delete = "delete from  cif_account where cif_account.register_channel=\"" + channel_code
				+ "\" and cif_account.account_id in(select cif_third_account.account_id from cif_third_account where cif_third_account.third_account_id=\""
				+ phone_num + "\")";
		long deleteRes_delete = stmt_delete.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		logger.info("SQL1_DELETE:" + deleteRes_delete);

		String selectSql_delete2 = "delete from cif_third_account where cif_third_account.third_account_id=\""
				+ phone_num
				+ "\" and cif_third_account.account_id not in(select cif_account.account_id from cif_account)";
		long deleteRes_delete2 = stmt_delete.executeUpdate(selectSql_delete2); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		logger.info("SQL2_DELETE:" + deleteRes_delete2);

		// 测试步骤开始
		logger.info("Start to launch register");

		AndroidFunHelper.clickElementById("button_tv_user", driver);
		Thread.sleep(sleepBase * 2000);

		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
		} catch (Exception e) {
			logger.info("已登录");
		}
		if (loginBtn == null) {
			logout(driver);
		}

		AndroidFunHelper.clickElementById("button_user_login", driver);
		Thread.sleep(sleepBase * 1000);

		AndroidFunHelper.clickElementById("button_user_login_register", driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.sendKeysById("text_user_login_register_phone_num", phone_num, driver);
		AndroidFunHelper.clickElementById("button_user_login_register_verification", driver);
		AndroidFunHelper.sendKeysById("text_user_login_register_password", password, driver);
		Thread.sleep(sleepBase * 5000);

		// 数据库获取验证码
		Connection con_notifycenter = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_notifycenter = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/notifycenter?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_notifycenter;
		stmt_notifycenter = con_notifycenter.createStatement();

		String selectSql_notifycenter = "SELECT sms_code FROM sms_message WHERE sms_send_num = \"" + phone_num
				+ "\" ORDER BY gmt_create desc LIMIT 0,1";
		ResultSet selectRes_notifycenter = stmt_notifycenter.executeQuery(selectSql_notifycenter);
		logger.info("数据库查询" + selectSql_notifycenter);
		while (selectRes_notifycenter.next()) {
			verification = selectRes_notifycenter.getString("sms_code");
		}
		logger.info("the verification_code is :" + verification);

		AndroidFunHelper.sendKeysById("text_user_login_register_verification", verification, driver);
		AndroidFunHelper.clickElementById("button_user_login_register_register", driver);
	}

	public static void forgetPassword(String phone_num, String password, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		logger.info("Start to app FogetPassword");

		String verification = null;

		AndroidFunHelper.clickElementById("button_tv_user", driver); // 点击我的
		Thread.sleep(sleepBase * 2000);

		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
		} catch (Exception e) {
			logger.info("已登录");
		}
		if (loginBtn == null) {
			logout(driver);
		}

		AndroidFunHelper.clickElementById("button_user_login", driver); // 点击登录
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.clickElementById("button_user_login_forgetpassword", driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.sendKeysById("text_user_login_forgetpassword_phone_num", phone_num, driver);
		AndroidFunHelper.clickElementById("button_user_login_forgetpassword_verification", driver);
		AndroidFunHelper.sendKeysById("text_user_login_forgetpassword_password", password, driver);
		Thread.sleep(sleepBase * 5000);

		// 数据库查询验证码
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/notifycenter?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt;
		stmt = con.createStatement();

		String selectSql = "SELECT sms_code FROM sms_message WHERE sms_send_num = \"" + phone_num
				+ "\" ORDER BY gmt_create desc LIMIT 0,1";
		ResultSet selectRes = stmt.executeQuery(selectSql);
		logger.info("数据库查询" + selectSql);
		while (selectRes.next()) {
			verification = selectRes.getString("sms_code");
		}
		logger.info("the verification_code is :" + verification);
		AndroidFunHelper.sendKeysById("text_user_login_forgetpassword_verification", verification, driver);
		AndroidFunHelper.clickElementById("button_user_login_forgetpassword_forgetpassword", driver);
		Thread.sleep(sleepBase * 2000);
	}

	// 影片选影院，用例8
	public static int clickCinemaFromFilm(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {

		Thread.sleep(sleepBase * 5000);
		// AndroidFunHelper.clickElementById("button_film_cancle", driver);
		AndroidFunHelper.clickElementById("button_film", driver);
		// AndroidFunHelper.clickElementById("button_film_coming", driver);

		int j = 0;
		int k = 0;
		do {
			List<WebElement> buytickets = driver.findElementsById(UItree.FindValueInUItree("button_buy_ticket")); // 影片页找“购票”按钮
			int buytickets_num = buytickets.size();
			for (int i = 0; i < buytickets_num; i++) {
				buytickets.get(i).click(); // 点击“购票”按钮
				Thread.sleep(sleepBase * 5000);

				List<WebElement> all_cin_name = driver
						.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname")); // 找影院名
				int cin_namenum = all_cin_name.size(); // 获取影院数
				logger.info(cin_namenum);
				String cin_name = all_cin_name.get(0).getText(); // 获取影院名
				logger.info(cin_name);

				if (cin_name.contains("影院")) {
					if (cin_name.contains("88")) {
						// AndroidFunHelper.clickElementById("lable_cinema_filmname",
						// driver);
						logger.info("用例编号8，点击影片列表中的购票/预售按钮，显示影片选影院页面，运行成功");
						k = 1;
						return i;
					}
				}
				try {
					if (driver.findElementById(UItree.FindValueInUItree("lable_error_message")).isDisplayed()) // 输出错误信息
					{
						WebElement errormsg = driver.findElementById(UItree.FindValueInUItree("lable_error_message"));
						String text = errormsg.getText();
						logger.info("影院列表error信息：" + text);
					}
				} catch (NoSuchElementException e) {
					logger.info("未发现错误信息");
				}
			}
			AndroidFunHelper.swipeScreenToBelow(1, driver);
			j = j + 1;
			logger.info("下划次数：" + j);
			Thread.sleep(sleepBase * 5000);
			AndroidFunHelper.clickElementById("com.ykse.ticket:id/btn_header_left", driver); // 返回影片页
			Thread.sleep(sleepBase * 5000);

		} while (k == 0);

		return -1;
	}

	// 影片详情页点击“购票”，用例9
	public static boolean click_buyTickets_on_filmsDetails(AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 5000);

		AndroidFunHelper.clickElementById("button_film", driver);
		List<WebElement> film_name = driver.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname")); // 查找影片名
		int films_num = film_name.size();
		logger.info(films_num);
		for (int i = 0; i < films_num; i++) {
			logger.info("---根据影片数目第" + i + "次循环---");
			String s = null;
			film_name.get(i).click(); // 点击“影片”页购票
			Thread.sleep(sleepBase * 3000);
			AndroidFunHelper.clickElementById("button_buy_ticket", driver); // 点击“影院”页购票
			Thread.sleep(sleepBase * 5000);
			List<WebElement> cinema_name = driver.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname")); // 找“影院”列表
			int cinemas_num = cinema_name.size();
			logger.info("影院数目为：" + cinemas_num);
			for (int j = 0; j < cinemas_num; j++) {
				logger.info("查找影院第" + j + "次迭代");
				if (cinema_name.get(j).getText().contains("88")) // 查找88影院
				{
					logger.info(j);
					String cinema_name_text = cinema_name.get(j).getText();
					logger.info(cinema_name_text); // 打印“影院”列表
					s = cinema_name_text;
					cinema_name.get(j).click(); // 点击是为了可以衔接之后的购票
					break;
				}
			}
			logger.info("s=" + s);
			if (s != null) {
				logger.info(s);
				break;
			}
			Thread.sleep(sleepBase * 5000);
			AndroidFunHelper.clickElementById("button_back", driver); // 影院页返回按钮
			// driver.findElementById(UItree.FindValueInUItree("button_back"));
			Thread.sleep(sleepBase * 3000);
			AndroidFunHelper.clickElementById("button_back", driver); // 影片详情页返回按钮
			// driver.findElementById(UItree.FindValueInUItree("button_back"));
			Thread.sleep(sleepBase * 5000);
			
		}
		return true;
	}

	public static void bingcard(String cardnum, String cardpassword, String currentCity, String cinemaName,
			String carduser, String idcard, String cardphonenum, String phone_num, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException { // 需要传入登录的手机号码(phone_num)，作为前置条件解绑的标识
		logger.info("Start to app bingcard");

		AndroidFunHelper.clickElementById("button_tv_user", driver); // 点击我的
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_my_card", driver); // 点击我的会员卡
		Thread.sleep(sleepBase * 10000);
		AndroidFunHelper.clickElementById("button_my_card_bingcard", driver); // 绑卡按钮
		Thread.sleep(sleepBase * 1000);

		// 删除绑卡信息
		Connection con_delete = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_delete = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_delete;
		stmt_delete = con_delete.createStatement();

		String selectSql_delete = "delete from card_member_relation where card_number = \"" + cardnum
				+ "\" and account_id =(select account_id from cif_third_account where third_account_id =\"" + phone_num
				+ "\")";
		long deleteRes_delete = stmt_delete.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		logger.info("SQL1_DELETE:" + deleteRes_delete);

		// 输入绑卡信息
		AndroidFunHelper.clickElementById("button_my_card_bingcard_city", driver); // 选择城市
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.findElementAndClick("button_city_cityList", currentCity, driver);
		Thread.sleep(sleepBase * 5000);

		AndroidFunHelper.clickElementById("button_my_card_bingcard_cinema", driver); // 选择影院
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.findElementAndClick("button_my_card_bingcard_cinema_cinema", cinemaName, driver);
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.sendKeysById("text_my_card_bingcard_cardnum", cardnum, driver);
		AndroidFunHelper.sendKeysById("text_my_card_bingcard_cardpassword", cardpassword, driver);

		try { // 由于此处绑卡认证为3选2，不确定认证所需信息，因此使用try，catch
			AndroidFunHelper.sendKeysById("text_my_card_bingcard_carduser", carduser, driver);
			logger.info("输入carduser：" + carduser);
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.info("没有找到carduser");
		}

		try {
			AndroidFunHelper.sendKeysById("text_my_card_bingcard_cardphone", cardphonenum, driver);
			logger.info("输入cardphonenum：" + cardphonenum);
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.info("没有找到cardphonenum");
		}

		try {
			AndroidFunHelper.sendKeysById("text_my_card_bingcard_idcard", idcard, driver);
			logger.info("输入idcard：" + idcard);
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.info("没有找到idcard");
		}

		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_my_card_bingcard_bingcard", driver);
		Thread.sleep(sleepBase * 2000);
	}

	public static void loginByUesr(String phoneNum, String passWord, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		
		logger.info("点击首页的用户按钮");
		AndroidFunHelper.clickElementById("button_tv_user", driver);
		Thread.sleep(sleepBase * 2000);

		WebElement loginBtn = null;
		try {
			loginBtn = driver.findElementById("com.ykse.ticket:id/fu_user_login_bt");
		} catch (Exception e) {
			logger.info("用户已登录，需要先登出");
			
		}
		if (loginBtn == null) {
			logout(driver);
		}
		logger.info("点击登陆按钮");
		AndroidFunHelper.clickElementById("button_user_login", driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.clickElementById("button_user_login_userlogin", driver);
		Thread.sleep(sleepBase * 1000);

		logger.info("输入账号密码");
		AndroidFunHelper.sendKeysById("text_user_login_userlogin_username", phoneNum, driver);
		AndroidFunHelper.sendKeysById("text_user_login_userlogin_password", passWord, driver);
		logger.info("点击登陆按钮");
		AndroidFunHelper.clickElementById("button_user_login_userlogin_login", driver);
		Thread.sleep(sleepBase * 2000);
	}

	public static void loginByUesr_notbingphone(String bingPhone, String userName, String passWord, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		logger.info("使用未绑定的手机的用户名登录");
		logger.info("清除用户的手机绑定信息");
		
		// 删除绑定手机信息
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/cif?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt;
		stmt = con.createStatement();

		String selectSql_delete = "delete from cif.cif_third_account where account_id = (select account_id from cif.cif_account where account_name = \""
				+ userName + "\"); ";
		long deleteRes_delete = stmt.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		logger.info("SQL1_DELETE:" + deleteRes_delete);

		// 用户名登录
		loginByUesr(userName, passWord, driver);

		// 绑定手机号码
		logger.info("输入手机号码进行绑定");
		AndroidFunHelper.sendKeysById("text_user_login_userlogin_login_phone_num", bingPhone, driver);
		AndroidFunHelper.clickElementById("button_user_login_userlogin_login_verification", driver);
		Thread.sleep(sleepBase * 5000);
		String verification = null;
		Connection con_notifycenter = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_notifycenter = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/notifycenter?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_notifycenter;
		stmt_notifycenter = con_notifycenter.createStatement();

		String selectSql_notifycenter = "SELECT sms_code FROM sms_message WHERE sms_send_num = \"" + bingPhone
				+ "\" ORDER BY gmt_create desc LIMIT 0,1";
		ResultSet selectRes_notifycenter = stmt_notifycenter.executeQuery(selectSql_notifycenter);

		while (selectRes_notifycenter.next()) {
			verification = selectRes_notifycenter.getString("sms_code");
		}
		logger.debug("the verification_code is :" + verification);
		AndroidFunHelper.sendKeysById("text_user_login_userlogin_login_verification", verification, driver);
		AndroidFunHelper.clickElementById("button_user_login_userlogin_login_bing", driver);
		Thread.sleep(sleepBase * 2000);
	}

	// 此用例需登录有绑定会员卡的账号
	public static void myCardList(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		logger.info("Start to app myCardList");

		AndroidFunHelper.clickElementById("button_tv_user", driver);
		Thread.sleep(sleepBase * 2000);

		AndroidFunHelper.PrintScreen(driver);

		AndroidFunHelper.clickElementById("button_my_card", driver);
		Thread.sleep(sleepBase * 5000);
	}

	public static void cityChoose_by_film(String currentCity, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		AndroidFunHelper.clickElementById("button_film", driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_film_city", driver);
		Thread.sleep(sleepBase * 2000);

		AndroidFunHelper.PrintScreen(driver);

		AndroidFunHelper.findElementAndClick("button_city_cityList", currentCity, driver);
		Thread.sleep(sleepBase * 3000);
	}

	public static void cityChoose_by_cinema(String currentCity, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		AndroidFunHelper.clickElementById("button_cinema", driver);
		AndroidFunHelper.clickElementById("button_film_city", driver);
		Thread.sleep(sleepBase * 2000);

		AndroidFunHelper.PrintScreen(driver);

		AndroidFunHelper.findElementAndClick("button_city_cityList", currentCity, driver);
		Thread.sleep(sleepBase * 3000);
	}

	// 影院列表进入排期，用例27

	public static boolean check_filmList_on_Scheduling(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 5000);
		// AndroidFunHelper.clickElementById("button_cinema_findCinemaName",
		// driver); // 点击进入“影院”列表
		int j = 0;
		int k = 0;
		int l = 0;
		String cinemas_name = null;
		String getCinemaName = null;
		Connection con_notifycenter = null;
		Class.forName("com.mysql.jdbc.Driver");
		con_notifycenter = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/notifycenter?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");

		Statement stmt_notifycenter;
		stmt_notifycenter = con_notifycenter.createStatement();

		String selectSql_cinema = "select cinema_name from basedata.data_cinema  where city_name =\""
				+ TestData.FindValueInVariables("cityName") + "\" ";
		ResultSet selectRes_notifycenter = stmt_notifycenter.executeQuery(selectSql_cinema);
		// 数据库表与搜索结果对比
		while (selectRes_notifycenter.next()) {
			cinemas_name = selectRes_notifycenter.getString("cinema_name");
			AndroidFunHelper.clickElementById("button_cinema_search", driver); // 点查找按钮
			Thread.sleep(sleepBase * 5000);
			// AndroidFunHelper.clickElementById("text_cinema_inputCinemaName",
			// driver);
			// Thread.sleep(sleepBase*5000);
			driver.findElementById(UItree.FindValueInUItree("text_cinema_inputCinemaName")).clear();
			AndroidFunHelper.sendKeysById("text_cinema_inputCinemaName", cinemas_name, driver); // 输入影院名
			// AndroidFunHelper.sendKeysById("text_cinema_inputCinemaName",
			// "xxxxxx", driver);
			Thread.sleep(sleepBase * 3000);
			getCinemaName = driver.findElementById(UItree.FindValueInUItree("lable_cinema_filmname")).getText();
			assertEquals("Check cityName is correct", cinemas_name.equals(getCinemaName), true);
			logger.info("数据库影院列表" + cinemas_name + "与UI搜索结果" + getCinemaName + "一致");
			// 检查影院列表,并进入88影院
			do {
				Thread.sleep(sleepBase * 3000);
				List<WebElement> film_name = driver.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname"));
				for (int i = 0; i < film_name.size(); i++) {
					String text = film_name.get(i).getText();
					logger.info(text);
					if (text.contains("88")) {
						logger.info("click " + text);
						film_name.get(i).click();
						j = 1;
						break;
					}
				}
				logger.info("下划循环开始");
				AndroidFunHelper.swipeScreenToBelow(1, driver);
				logger.info("下划循环结束");
				k = k + 1;
				logger.info("第 " + k + "次翻页");
			} while (j == 0);
			Thread.sleep(sleepBase * 5000);
			List<WebElement> filmName = driver
					.findElementsById(UItree.FindValueInUItree("lable_filmList_checkfilmList")); // 查找影片名称
			logger.info("列表影片名称：" + filmName.get(0).getText());
			do {
				AndroidFunHelper.swipeScreenToBelow(1, driver);
				List<WebElement> btns_buyTickets = driver
						.findElementsById(UItree.FindValueInUItree("button_buy_ticket"));
				logger.info("购票按钮个数：" + btns_buyTickets.size());
				if (btns_buyTickets.size() == 0) {
					logger.info("下划循环开始");
					AndroidFunHelper.swipeScreenToBelow(1, driver);
					logger.info("下划循环结束");
				} else if (btns_buyTickets.size() != 0) {
					List<WebElement> showDate = driver
							.findElementsById(UItree.FindValueInUItree("lable_film_showDate"));
					logger.info("放映日期个数：" + showDate.size());
					for (int i = 0; i < showDate.size(); i++) {
						logger.info("上映日期：" + showDate.get(i).getText());
					}
					List<WebElement> beginTime = driver
							.findElementsById(UItree.FindValueInUItree("lable_film_beginTime"));
					logger.info("上映时间个数：" + beginTime.size());
					for (int i = 0; i < beginTime.size(); i++) {
						logger.info("上映时间：" + beginTime.get(i).getText());
					}
					if (btns_buyTickets.size() != beginTime.size()) {
						return false;
					}
					l = 1;
					// assertEquals("Check
					// check_filmList_on_Scheduling",showDate.size()==beginTime.size(),true);
				}

			} while (l == 0);
			List<WebElement> btn_buyTicket = driver.findElementsById(UItree.FindValueInUItree("button_buy_ticket")); // 进入第一个场次
			btn_buyTicket.get(0).click();
		}

		return true;

	}

	// 仅购买卖品，用例35
	public static boolean buy_good_only(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		int j = 0;
		// int k = 0;

		AndroidFunHelper.clickElementById("button_cinema", driver);

		// 检查影院列表,并进入88影院
		do {
			Thread.sleep(sleepBase * 5000);
			List<WebElement> film_name = driver.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname"));
			for (int i = 0; i < film_name.size(); i++) {
				String text = film_name.get(i).getText();
				logger.info(text);
				if (text.contains("88")) {
					logger.info("click " + text);
					film_name.get(i).click();
					j = 1;
					break;
				}
			}
			// AndroidFunHelper.swipeScreenToBelow(1, driver);
			// k = k + 1;
			// logger.info("第 " + k + "次翻页");

		} while (j == 0);
		Thread.sleep(sleepBase * 8000);
		AndroidFunHelper.clickElementById("lable_cinemaDetails_cinemaName", driver); // 点击进入影院详情
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.clickElementById("button_buyGoodsOnly_cinemaDetails", driver); // 仅购买卖品
		Thread.sleep(sleepBase * 5000);

		// 校验卖品名称与增加/减少按钮数校验
		List<WebElement> goodLis = driver.findElementsByClassName("android.widget.LinearLayout");		
		List<WebElement> goodLisChoose = goodLis.get(1).findElements(By.className("android.widget.Button"));
		List<WebElement> goodLisView = goodLis.get(1).findElements(By.className("android.widget.TextView"));
		WebElement plus = goodLisChoose.get(1);
		WebElement minus = goodLisChoose.get(0);
		WebElement view = goodLisView.get(5);
		
		plus.click();
		logger.debug(view.getText());
		if(view.getText().equals("1")){
			minus.click();
			logger.debug(view.getText());
			if(view.getText() == "0"){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
		//WebElement plus = driver.    (UItree.FindValueInUItree("button_goodList_plus"));
		//List<WebElement> minus = driver.findElementsByLinkText(UItree.FindValueInUItree("button_goodList_minus"));
		/*if (goodName.size() == plus.size()) {
			if (plus.size() == minus.size()) {
				// AndroidFunHelper.clickElementById("button_goodList_back",
				// driver);
				// Thread.sleep(sleepBase * 3000);
				// AndroidFunHelper.clickElementById("button_cinemaDetails_back",
				// driver);
				// Thread.sleep(sleepBase * 3000);
				// AndroidFunHelper.clickElementById("button_film_back",
				// driver);
				// Thread.sleep(sleepBase * 3000);
				return true;
			}
		}
		// AndroidFunHelper.clickElementById("button_goodList_back", driver);
		// Thread.sleep(sleepBase * 3000);
		// AndroidFunHelper.clickElementById("button_cinemaDetails_back",
		// driver);
		// Thread.sleep(sleepBase * 3000);
		// AndroidFunHelper.clickElementById("button_film_back", driver);
		// Thread.sleep(sleepBase * 3000);
		return false;*/
	}

	// 切换影片，用例40
	public static boolean swich_film(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		int j = 0;
		int k = 0;

		// 检查影院列表,并进入88影院
		do {
			Thread.sleep(sleepBase * 3000);
			List<WebElement> film_name = driver.findElementsById(UItree.FindValueInUItree("lable_cinema_filmname"));
			for (int i = 0; i < film_name.size(); i++) {
				String text = film_name.get(i).getText();
				logger.info(text);
				if (text.contains("88")) {
					logger.info("click " + text);
					film_name.get(i).click();
					j = 1;
					break;
				}
			}
			if (j == 0) {
				AndroidFunHelper.swipeScreenToBelow(1, driver);
				k = k + 1;
				logger.info("第 " + k + "次翻页");
			}

		} while (j == 0);

		Thread.sleep(sleepBase * 3000);

		List<WebElement> image = driver.findElementsById(UItree.FindValueInUItree("image_film_filmImage"));
		String film_name1 = driver.findElementById(UItree.FindValueInUItree("lable_filmList_checkfilmList")).getText(); // 存储影片1名称
		image.get(1).click();
		Thread.sleep(sleepBase * 3000);
		String film_name2 = driver.findElementById(UItree.FindValueInUItree("lable_filmList_checkfilmList")).getText(); // 存储影片2名称
		if (film_name1 == film_name2) {
			return false;
		} else {
			logger.info("film_name1:" + film_name1 + "  ,film_name2:" + film_name2);
			return true;
		}
	}

	// 点击购票，进入选座界面，用例42
	public static boolean check_seat(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		try {
			WebElement warning = driver.findElementById(UItree.FindValueInUItree("button_seat_warning"));
			if (warning.isDisplayed()) {
				logger.info("未弹出警告");
			} else {
				warning.click(); // 警告弹窗点击“不再提示”
			}

		} catch (NoSuchElementException e) {
			logger.error("查找警告控件报错");
		}
		int j = 0;

		List<WebElement> lable = driver.findElementsById(UItree.FindValueInUItree("lable_seat_selected"));
		for (int i = 0; i < lable.size(); i++) {
			if (lable.get(i).getText().contains("已选")) {
				logger.info("获取lable名称为：" + lable.get(i).getText() + "对比值：已选");
				j = j + 1;
			} else if (lable.get(i).getText().contains("已售")) {
				logger.info("获取lable名称为：" + lable.get(i).getText() + "对比值：已售");
				j = j + 1;
			} else if (lable.get(i).getText().contains("已选")) {
				logger.info("获取lable名称为：" + lable.get(i).getText() + "对比值：已选");
				j = j + 1;
			} else if (lable.get(i).getText().contains("最佳观影区")) {
				logger.info("获取lable名称为：" + lable.get(i).getText() + "对比值：已选");
				j = j + 1;
			} else {
				logger.info("获取lable名称为：" + lable.get(i).getText());
				j = j + 1;
			}
			if (j == 4) {
				logger.info("座位图座位标识检测通过");
				return true;
			}

		}
		return false;
	}

	// 选择卖品
	public static Double goodChoose(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 3000);
		//List<WebElement> plus = driver.findElementsByLinkText(UItree.FindValueInUItree("button_goodList_plus"));
		//plus.get(0).click(); // 增加首个卖品2个
		//plus.get(0).click();
		
		List<WebElement> goodLis = driver.findElementsByClassName("android.widget.LinearLayout");		
		List<WebElement> goodLisChoose = goodLis.get(1).findElements(By.className("android.widget.Button"));
		WebElement plus = goodLisChoose.get(1);
		plus.click();
		plus.click();
		logger.info("点击：" + plus.getText() + "成功");
		
		List<WebElement> num = driver.findElementsById(UItree.FindValueInUItree("lable_goodList_selectedNum")); // 所选数目
		int num1 = Integer.parseInt(num.get(0).getText());
		logger.info("所选卖品数目：" + num1);
		List<WebElement> price1 = driver.findElementsById(UItree.FindValueInUItree("lable_goodList_price"));
		String price2 = price1.get(0).getText(); // 截取￥后的数值
		logger.info(price2);
		Double singelPrice = Double.parseDouble(price2.split("￥")[1]);
		logger.info("所选卖品单价：" + singelPrice);
		Double totalPrice = singelPrice * num1; // 计算卖品总价
		logger.info("所选卖品总价：" + totalPrice);
		AndroidFunHelper.clickElementById("lable_goodList_buy", driver);
		return totalPrice;

	}

	// 优惠方式
	public static boolean discountChosen(AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.clickElementById("list_confirmOrder_discount", driver);
		Thread.sleep(sleepBase * 5000);
		List<WebElement> price = driver.findElementsById(UItree.FindValueInUItree("lable_discount_price"));
		int ticket_price = Integer.parseInt(price.get(0).getText());
		logger.info("优惠价格:" + ticket_price);
		price.get(0).click();
		Thread.sleep(sleepBase * 5000);
		// 获取票价
		int ticket_price1 = Integer
				.parseInt(driver.findElementById(UItree.FindValueInUItree("lable_confirmOrder_totalPrice")).getText());
		logger.info("最终价格:" + ticket_price1);
		if (ticket_price == ticket_price1) {
			logger.info("优惠价格与最终价格一致");
			return true;
		}
		return false;

	}

	public static void my_card_cardInfo_record(String cardNum, String cardpassWord, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		logger.info("Start to app my_card_cardInfo_record");

		my_card_cardInfo(cardNum, cardpassWord, driver); // 进入会员卡详情页
		logger.info("进入卡详情页面");

		AndroidFunHelper.clickElementById("button_my_card_cardinfo_record", driver); // 进入充值消费记录
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入充值消费记录页面");
		
		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入充值记录页面");

		

		// 充值记录&检验
		//AndroidFunHelper.clickElementById("button_my_card_cardinfo_record_recharge", driver);
		//Thread.sleep(sleepBase * 5000);

				
	}

	public static void my_card_cardInfo_unbing(String cardnum, String cardpassword, String currentCity,
			String cinemaName, String carduser, String idcard, String cardphonenum, String phone_num,
			AppiumDriver<WebElement> driver) throws Exception, InterruptedException, MalformedURLException {

		// 进行解绑操作
		logger.info("Start to app my_card_cardInfo_unbing");
		my_card_cardInfo(cardnum, cardpassword, driver); // 进入卡详情页
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入卡详情");

		AndroidFunHelper.clickElementById("button_my_card_cardinfo_unbing", driver); // 点击解绑按钮
		Thread.sleep(sleepBase * 1000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("点解解绑按钮");

		Thread.sleep(sleepBase * 5000);

		AndroidFunHelper.clickElementById("button_my_card_unbing_sureunbing", driver);
		Thread.sleep(sleepBase * 5000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("确定解绑");
	}

	public static void my_card_applyForCard(String cardType, String cardpassword, String currentCity, String cinemaName,
			String carduser, String idcard, String cardphonenum, String phone_num, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		logger.info("Start to app my_card_cardInfo_unbing");

		AndroidFunHelper.clickElementById("button_tv_user", driver); // 点击我的
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_my_card", driver); // 点击我的会员卡
		Thread.sleep(sleepBase * 5000);

		// 寻找并点击会员卡申请按钮

		WebElement cardnumshows = null;
		for (int i = 0; i <= 10; i++) {
			AndroidFunHelper.swipeScreenToBelow(1, driver);
			Thread.sleep(sleepBase * 2000);
			try {
				cardnumshows = driver.findElementByClassName("android.widget.Button");
			} catch (Exception e) {
				logger.warn("本次划屏没有找到申请会员卡按钮");
			}
			if (cardnumshows != null) {
				cardnumshows.click();
				logger.info("点击申请会员卡成功");
				break;
			}
		}
		// 输入各种会员卡信息
		AndroidFunHelper.clickElementById("button_my_card_applyForCard_location", driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.findElementAndClick("button_city_cityList", currentCity, driver);
		Thread.sleep(sleepBase * 1000);
		AndroidFunHelper.clickElementById("button_my_card_applyForCard_cinema", driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.findElementAndClick("button_my_card_bingcard_cinema_cinema", cinemaName, driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_my_card_applyForCard_type", driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.findElementAndClick("button_my_card_applyForCard_type_cardName", cardType, driver);
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.sendKeysById("button_my_card_applyForCard_cardPassword", cardpassword, driver);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.warn("无需收起键盘");
		}
		AndroidFunHelper.sendKeysById("button_my_card_applyForCard_ensureCardPassword", cardpassword, driver);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.warn("无需收起键盘");
		}
		AndroidFunHelper.sendKeysById("button_my_card_applyForCard_cardUser", carduser, driver);
		try {
			AndroidFunHelper.swipeScreenToBelow(1, driver);
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.warn("无需收起键盘");
		}
		AndroidFunHelper.sendKeysById("button_my_card_applyForCard_idCard", idcard, driver);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.warn("无需收起键盘");
		}
		AndroidFunHelper.sendKeysById("button_my_card_applyForCard_cardPhoneNum", cardphonenum, driver);
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			logger.warn("无需收起键盘");
		}

		AndroidFunHelper.PrintScreen(driver);

		AndroidFunHelper.clickElementById("button_my_card_applyForCard_apply", driver);
		Thread.sleep(sleepBase * 2000);

		AndroidFunHelper.PrintScreen(driver);
	}

	public static void my_card_cardInfo(String cardNum, String cardpassWord, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		logger.info("Start to app my_card_cardInfo");

		AndroidFunHelper.clickElementById("button_tv_user", driver); // 点击我的
		Thread.sleep(sleepBase * 2000);
		AndroidFunHelper.clickElementById("button_my_card", driver); // 点击我的会员卡
		Thread.sleep(sleepBase * 5000);

		AndroidFunHelper.findElementAndClick("button_my_card_cardnum", cardNum, driver); // 点击会员卡
		Thread.sleep(sleepBase * 2000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入我的会员卡页");

		AndroidFunHelper.sendKeysById("text_my_card_cardnum_password", cardpassWord, driver); // 输入会员卡密码
		AndroidFunHelper.clickElementById("button_my_card_cardnum_sure", driver); // 点击确认按钮
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.PrintScreen(driver);
		logger.info("进入卡详情页");
	}

	// 输入手机号，点击确认订单
	public static void inputPhoneNumber(String cardphoneNum, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		AndroidFunHelper.clickElementById("button_confirmOrder_phoneNumber", driver); // 点击输入手机号
		AndroidFunHelper.sendKeysById("text_phoneNum_inputPhoneNumber", cardphoneNum, driver);
		AndroidFunHelper.clickElementById("button_confirmOrder_ensure", driver);
		AndroidFunHelper.clickElementById("button_phoneNum_finish", driver);
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.clickElementById("button_confirmOrder_confirm", driver);
		Thread.sleep(sleepBase * 5000);
	}

	// 输入密码，进行会员卡支付
	public static boolean cardPay(String cardpassWord, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		AndroidFunHelper.sendKeysById("text_cardPay_password", cardpassWord, driver);
		AndroidFunHelper.clickElementByLinkText("button_cardPay_ensure", driver);
		Thread.sleep(sleepBase * 5000);
		try {
			AndroidFunHelper.clickElementById("button_paySuccess_checkTicket", driver);
			return true;
		} catch (NoSuchElementException ex) {
			logger.warn("支付失败");
			AndroidFunHelper.PrintScreen(driver);
			return false;
		}
	}

	public static String addCoupon(int ticket_num, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		boolean isPass1 = false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver) != -1) {
			isPass1 = true;
		}

		logger.info("影片选影院通过");
		boolean isPass2 = AndroidBizHelper.cinemaToSeatsMap(1, driver);
		// cinemas_name = selectRes_notifycenter.getString("cinema_name");
		// 排期列表购票，用例27
		// =AndroidBizHelper.check_filmList_on_Scheduling(driver);
		assertEquals("Check cinemaToSeatsMap", isPass2, true);
		logger.info("影院到座位图通过");
		// 选卖品
		Thread.sleep(sleepBase * 5000);
		AndroidBizHelper.chooseGood(false, driver);
		Thread.sleep(sleepBase * 8000);
		
		/*3.1版本
		AndroidFunHelper.clickElementById("button_order_activity", driver);	
		for (int i = 0; i <= 10; i++) {
			AndroidFunHelper.swipeScreenToBelow(1, driver);
			try {
				coupon_text = driver.findElementByClassName("android.widget.EditText");
			} catch (Exception e) {
				logger.error("没有找到输入券框");
			}
			if (coupon_text != null) {
				break;
			}
		}*/
		
		//3.2版本
		AndroidFunHelper.clickElementById("button_order_coupon", driver);
		Thread.sleep(sleepBase * 5000);
		WebElement coupon_text = null;
		coupon_text = driver.findElementByClassName("android.widget.EditText");
		
		// 连本地数据库修改券
		Connection con_revise = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con_revise = DriverManager.getConnection("jdbc:oracle:thin:@172.33.0.88:1521:GVDB", "gvdba", "manager");
		Statement stmt_revise;
		stmt_revise = con_revise.createStatement();
		String selectSql_revise = "update gv_comp_pass_vouchers set cpv_redeemed_flg = 'N' where cpv_group_id = '2016040577' and cpv_redeemed_flg = 'Y' ";
		long reviseRes = stmt_revise.executeUpdate(selectSql_revise); // 如果为0则没有进行操作，如果大于0，则记录删除的条数
		logger.info("修改数据库条数:" + reviseRes);

		// 连本地数据库获取券
		Connection con = null;
		String coupon_num = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@172.33.0.88:1521:GVDB", "gvdba", "manager");
		Statement stmt;
		stmt = con.createStatement();
		String selectSql = "select cpv_barcode from gv_comp_pass_vouchers where cpv_group_id = '2016040577' and cpv_blank_out_flag = 'N' and cpv_enabled_flg = 'Y' ";
		ResultSet selectRes = stmt.executeQuery(selectSql);
		String allCoupon = null;
		for (int i = 1; i <= ticket_num; i++) {
			selectRes.next();
			if (selectRes.next() == false) {
				logger.error("本地库无适用的兑换券");
				break;
			}
			if (i != 1) {
				allCoupon = allCoupon + ",";
			}
			coupon_num = selectRes.getString("cpv_barcode");
			logger.info("本次输入券号为" + coupon_num);
			coupon_text.sendKeys(coupon_num);
			AndroidFunHelper.clickElementById("button_confirmOrder_discount_coupon_add", driver);
			Thread.sleep(sleepBase * 5000);
			AndroidFunHelper.findElementAndClick("button_confirmOrder_discount_couponLiset", coupon_num, driver);
			Thread.sleep(sleepBase * 2000);
			if (i == 1) {
				allCoupon = "'" + coupon_num + "'";
			} else {
				allCoupon = allCoupon + "'" + coupon_num + "'";
			}
		}

		AndroidFunHelper.clickElementById("button_confirmOrder_discount_sure", driver);
		Thread.sleep(sleepBase * 5000);
		return allCoupon;
	}

	public static void click_LockSeatsFromFilm(String cinemaName, AppiumDriver<WebElement> driver)
			throws InterruptedException, MalformedURLException {
		boolean isPass1 = false;
		if (AndroidBizHelper.clickCinemaFromFilm(driver) != -1) {
			isPass1 = true;
		}

		logger.info("影片选影院通过");
	}

	public static void refunTicket(AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {
		AndroidFunHelper.clickElementById("button_paySuccess_checkTicket", driver);
		Thread.sleep(sleepBase * 5000);
		AndroidFunHelper.clickElementById("button_detail_refun", driver);
		Thread.sleep(sleepBase * 3000);
		AndroidFunHelper.clickElementById("button_detail_refun_ensure", driver);
		Thread.sleep(sleepBase * 10000);
	}

	public static boolean order_onlyBayGoo(String cardNum, String cardpassWord, AppiumDriver<WebElement> driver)
			throws Exception, InterruptedException, MalformedURLException {
		AndroidBizHelper.buy_good_only(driver);
		boolean isPass = AndroidBizHelper.chooseGood(true, driver);
		if (isPass) {
			logger.info("选择卖品通过");
		}

		AndroidFunHelper.clickElementById("button_confirmOrder_onlyGood_payType", driver); // 点击支付方式
		Thread.sleep(sleepBase * 3000);
		AndroidFunHelper.findElementAndClick("button_order_discount_cardNum", cardNum, driver);
		AndroidFunHelper.clickElementById("button_confirmOrder_discount_sure", driver);
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.clickElementById("button_confirmOrder_onlyGood_ensure", driver);
		Thread.sleep(sleepBase * 3000);

		AndroidFunHelper.sendKeysById("button_order_card_impl_password", cardpassWord, driver);
		AndroidFunHelper.clickElementById("button_order_card_impl_ensure", driver);
		Thread.sleep(sleepBase * 10000);

		if (!AndroidFunHelper.findElementIsDisplay("text_order_ihwrt", "付款成功", driver)) {
			return false;
		}
		return true;
	}

}
