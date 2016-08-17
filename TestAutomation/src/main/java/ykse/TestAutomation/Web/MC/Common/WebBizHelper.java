package ykse.TestAutomation.Web.MC.Common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ykse.TestAutomation.Common.Log;

import org.openqa.selenium.support.ui.Select;

public class WebBizHelper {
	static Logger logger = new Log("web_mc").logger;
	public static int sleepBase = 1;

	public static Boolean start_and_login(WebDriver driver) {
		logger.info("加载首页页面");
		String baseUrl = "http://172.33.0.189:8080/";

		// 登录 login
		driver.get(baseUrl);
		/*
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("abcd1234");
		driver.findElement(By.id("loginId")).clear();
		driver.findElement(By.id("loginId")).sendKeys("ykseauto");
		*/
		logger.info("输入账号密码");
		WebFunHelper.sendKeysById("text_login_loginId", "loginId", driver);
		WebFunHelper.sendKeysById("text_login_password", "passWord", driver);
		logger.info("点击登陆");
		driver.findElement(By.id("login")).click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("首页")));
		WebElement Pass = null;
		try {
			Pass = driver.findElement(By.linkText("首页"));
		} catch (Exception e) {
			logger.error("没有找到此信息");
		}
		if (Pass == null) {
			return false;
		}
		return true;
	}

	public static boolean activity(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[1]/div/ul/li[5]/a")).click();
		Thread.sleep(sleepBase * 5000);
		if (driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li/a")).getText().contains("营销")) {

			return true;
		}
		return false;
	}

	// 若不填查询条件则传空值
	public static boolean activity_select(String activityId, String activityName, String activityState,
			String auditStatus, String cinemaName, WebDriver driver) throws InterruptedException {

		activity(driver);
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li/a")).click(); // 子目录营销
		Thread.sleep(sleepBase * 5000);

		if (activityId != null) {
			driver.findElement(By.xpath("//input[@name='activityId']")).sendKeys(activityId);
		}
		if (activityName != null) {
			driver.findElement(By.xpath("//input[@name='activityName']")).sendKeys(activityName);
		}
		if (activityState != null) {
			Select selectActivityState = new Select(driver.findElement(By.xpath("//input[@name='activityStatus']")));
			selectActivityState.selectByVisibleText(activityState);
		}
		if (auditStatus != null) {
			Select selectAuditStatus = new Select(driver.findElement(By.xpath("//input[@name='auditStatus']")));
			selectAuditStatus.selectByVisibleText(auditStatus);
		}
		if (cinemaName != null) {
			Select selectCinemaName = new Select(driver.findElement(By.xpath("//input[@name='cinemaName']")));
			selectCinemaName.selectByVisibleText(cinemaName);
		}
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div[7]/button")).click();
		Thread.sleep(sleepBase * 3000);

		WebElement activity = null;
		try {
			activity = driver.findElement(By.linkText("操作"));
		} catch (Exception e) {
			System.out.println("没有找到此信息");
		}
		if (activity != null) {
			return true;
		}
		return false;
	}

	public static boolean activity_create(WebDriver driver) throws InterruptedException {
		activity(driver);
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li/a")).click(); // 子目录营销
		Thread.sleep(sleepBase * 5000);

		driver.findElement(By.xpath("//div[@class='promoActivityTable']/div/div[1]/button[1]")).click();
		Thread.sleep(sleepBase * 3000);

		WebElement new_activity = null;
		try {
			new_activity = driver.findElement(By.linkText("新建营销活动"));
		} catch (Exception e) {
			System.out.println("没有找到此信息");
		}
		if (new_activity != null) {
			return true;
		}
		return false;
	}

	// type分立减、套餐
	public static boolean activity_create_type(String type, WebDriver driver) throws InterruptedException {
		if (type == "立减") {
			// driver.findElement(By.xpath("//div[@class='ways ng-scope
			// active']")).click();
			// System.out.println("1");
			// Select selectType = new
			// Select(driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div")));
			// selectType.deselectByIndex(2);
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[1]/div[2]/div/div/input"))
					.click();
			driver.findElement(By.linkText(type)).click();
		} else if (type == "套餐") {
			driver.findElement(
					By.className("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[1]/div[3]"))
					.click();
		} else {
			System.out.println("type参数有误");
			return false;
		}
		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[1]/button"))
				.click();
		Thread.sleep(sleepBase * 2000);

		WebElement new_activity = null;
		try {
			new_activity = driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/h4"));
		} catch (Exception e) {
			System.out.println("没有找到此信息");
		}
		if (new_activity == null) {
			return false;
		}
		return true;
	}

	// 时间以yyyy-mm-dd格式
	public static boolean activity_create_info(String type, String activityName, String startTime, String endTime,
			String introduce, String activityTag, String activitySupplement, String activityDescription,
			WebDriver driver) throws InterruptedException {
		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[1]/input"))
				.sendKeys(activityName);

		JavascriptExecutor removeStartTime = (JavascriptExecutor) driver;
		removeStartTime.executeScript("document.getElementsByName(\"timeStart\")[0].removeAttribute(\"readonly\");");
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(startTime);

		JavascriptExecutor removeEndTime = (JavascriptExecutor) driver;
		removeEndTime.executeScript("document.getElementsByName(\"timeEnd\")[0].removeAttribute(\"readonly\");");
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[2]/div[1]/div[1]/div[1]/input[2]"))
				.sendKeys(endTime);

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[3]/label"))
				.click(); // 去除时间框

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[3]/textarea"))
				.sendKeys(introduce);
		if (type != "套餐") {
			driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[4]/input"))
					.sendKeys(activityTag);
		}
		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[6]/input"))
				.sendKeys(activitySupplement);
		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[8]/textarea"))
				.sendKeys(activityDescription);

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[2]/div[10]/button[1]"))
				.click();
		Thread.sleep(sleepBase * 2000);

		WebElement new_activity = null;
		try {
			new_activity = driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/h4"));
		} catch (Exception e) {
			System.out.println("没有找到此信息");
		}
		if (new_activity == null) {
			return false;
		}
		return true;
	}

	// 时间以yyyy-mm-dd格式
	public static boolean activity_create_condition(String type, WebDriver driver) throws InterruptedException {
		/*
		 * if(userParticipation == "all"){ driver.findElement(By.xpath(
		 * "//div[@class='promoUser[t.index]']/label[1]/div")); }else
		 * if(userParticipation == "card"){ driver.findElement(By.xpath(
		 * "//div[@class='promoUser[t.index]']/label[2]/div")); }else
		 * if(userParticipation == "member"){ driver.findElement(By.xpath(
		 * "//div[@class='promoUser[t.index]']/label[3]/div")); }else{
		 * System.out.println(
		 * "userParticipation参数不正确，请核对userParticipation参数为all、card、member");
		 * return false; }
		 */ // 这段代码为后续使用,userParticipation的内容为all、card、member;
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[2]/ul/li/label/span"))
				.click();
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[3]/div[2]/label[1]"))
				.click();
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[4]/ul/li/label/span"))
				.click();
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[5]/ul/li/label/span"))
				.click();

		try {
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[6]/ul/li/label/span"))
					.click();
		} catch (Exception e) {
			System.out.println("没有找到影厅选择按钮");
		}

		if (type == "套餐") {
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[9]/div[2]/input"))
					.sendKeys("2");
			driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[11]/button"))
					.click();
			Thread.sleep(sleepBase * 5000);
			driver.findElement(By.xpath("//div[@class='goods ng-scope']/button")).click();
			Select selectGood = new Select(
					driver.findElement(By.xpath("//div[@class='goods ng-scope']/table/tbody/tr/td[2]/div/input")));
			selectGood.selectByIndex(2);
			driver.findElement(By.xpath("//div[@class='goods ng-scope']/table/tbody/tr/td[3]/input")).sendKeys("2");
		}

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[3]/div[10]/button[1]"))
				.click();
		Thread.sleep(sleepBase * 3000);

		WebElement activityPrice = null;
		try {
			activityPrice = driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[4]/h4[1]"));
		} catch (Exception e) {
			System.out.println("没有找到此信息");
		}
		if (activityPrice == null) {
			return false;
		}
		return true;
	}

	public static void activity_create_price(String type, WebDriver driver) throws InterruptedException {

		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[4]/div[1]/div[3]/div/input"))
				.sendKeys("20");

		if (type == "折扣") {
			driver.findElement(By.xpath("//div[@class='promoAC ng-scope']/input")).sendKeys("2");
		}

		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[4]/div[2]/div[2]/div/div/div[1]/input"))
				.sendKeys("2");
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[4]/div[2]/div[2]/div/div/div[2]/input"))
				.sendKeys("2");

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[4]/form/div[4]/div[4]/button[1]"))
				.click();
		Thread.sleep(sleepBase * 5000);
	}

	public static boolean activity_Audit(boolean Audit, WebDriver driver) throws InterruptedException {
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[1]/div/div[3]/div/table/tbody/tr[1]/td[2]")))
				.build().perform();

		driver.findElement(By.linkText("审核")).click();
		Thread.sleep(sleepBase * 5000);

		if (Audit) {
			driver.findElement(By.xpath("//div[@class='detail']/div[1]/label[1]/span")).click();
			driver.findElement(By.xpath("//div[@class='auditBtn ng-scope']/button")).click();
			Thread.sleep(sleepBase * 5000);

			action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
			if (driver.findElement(By.linkText("暂停")).getText().contains("暂停")) {
				return true;
			}
		} else {
			driver.findElement(By.xpath("//div[@class='detail']/div[1]/label[2]/span")).click();
			driver.findElement(By.xpath("//div[@class='auditBtn ng-scope']/button")).click();
			Thread.sleep(sleepBase * 5000);
			if (driver
					.findElement(By
							.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/table/tbody/tr/td[6]/a"))
					.getText().contains("原因")) {
				return true;
			}
		}

		return false;
	}

	public static String addScreeningsPriceRule(int addState, WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-场次定价
		Thread.sleep(5000);
		// 新建定价规则
		driver.findElement(By.xpath("//button[@class='btn btn-primary addBtn']")).click();
		Thread.sleep(5000);
		// 新增页内容编辑
		java.util.Random rd = new java.util.Random(); // 随机数
		String ruleTitle = "规则" + rd.nextInt();
		driver.findElement(By.xpath("//input[@class='form-control newRulesTitle-1']")).sendKeys(ruleTitle);
		System.out.println("规则标题：" + ruleTitle);
		// 选择规则
		driver.findElement(By.xpath("//div[@class='types']/label[1]")).click(); // 点击选择批量定价
		// 选择适用条件
		driver.findElement(By.xpath("//div[@class='channels']/ul/li/label/input[@class='check-all']")).click(); // 全选渠道
		driver.findElement(By.xpath("//div[@class='filmLimit']/label[2]/div")).click(); // 选择“指定影片”

		try {
			if (driver.findElement(By.xpath("//div[@class='tab-content']")).isDisplayed()) {
				System.out.println(driver.findElement(By.xpath("//div[@class='tab-content']")).isDisplayed());
				System.out.println("指定影片按钮切换成功");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		driver.findElement(By.xpath("//div[@class='filmLimit']/label[1]/div")).click(); // 选择影片“不限”
		driver.findElement(By.xpath("//div[@class='version ng-scope']/ul/li/label/input[@class='check-all']")).click(); // 全选“版本”
		driver.findElement(By.xpath("//div[@class='cinema ng-scope']/ul/li/label/input[@class='check-all']")).click(); // 全选“影院”
		Thread.sleep(3000);

		// 设置有效期
		String startTimeName = "timeStart";
		String EndTimeName = "timeEnd";
		beginTimeAndEndTime(startTimeName, EndTimeName, driver);

		driver.findElement(By.linkText("+添加适用时段")).click(); // 添加适用时段
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[1]/label/input[@type='checkbox']"))
				.click(); // 周一
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[2]/label/input[@type='checkbox']"))
				.click(); // 周二
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[3]/label/input[@type='checkbox']"))
				.click(); // 周三
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[4]/label/input[@type='checkbox']"))
				.click(); // 周四
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[5]/label/input[@type='checkbox']"))
				.click(); // 周五
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[6]/label/input[@type='checkbox']"))
				.click(); // 周六
		driver.findElement(
				By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[7]/label/input[@type='checkbox']"))
				.click(); // 周日

		// 开始、结束时间
		JavascriptExecutor removeAttributeTimeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeTimeS.executeScript("document.getElementsByName(\"timeS\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setStartTimeElement = driver.findElement(By.name("timeS"));
		Thread.sleep(3000);
		setStartTimeElement.sendKeys("00:00");

		JavascriptExecutor removeAttributeTimeE = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeTimeE.executeScript("document.getElementsByName(\"timeE\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setEndTimeElement = driver.findElement(By.name("timeE"));
		Thread.sleep(3000);
		setEndTimeElement.sendKeys("23:59");

		// 点击两次label消除日期控件
		driver.findElement(By.xpath("//form[@name='formAddPricingRules']/div[8]/h4")).click();
		driver.findElement(By.xpath("//form[@name='formAddPricingRules']/div[8]/h4")).click();

		// 设置价格政策
		driver.findElement(By.xpath("//div[@class='ways']/label[4]/span")).click(); // 选择固定价

		Thread.sleep(3000);
		driver.findElement(By.name("fixed")).sendKeys("30");
		if (addState == 1) {
			driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']/span")).click(); // 保存并提交审核
		} else if (addState == 2) {
			driver.findElement(By.xpath("//div[@class='btn-section']/button[2]/span")).click(); // 保存
		}

		String text = null;
		try {
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ngdialog-content']")));
			Thread.sleep(3000);
			text = driver
					.findElement(By.xpath("//div[@class='ngdialog-content']/div[@class='dialog-alert-wrapper']/span"))
					.getText();
			System.out.println("弹窗结果:" + text);
			WebElement close = driver.findElement(By.className("ngdialog-close"));
			close.click();
			if (text.contains("成功")) {
				System.out.println(text);
				Thread.sleep(5000);
				return ruleTitle;
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return text;
	}

	public static void queryScreeningsPriceRule(WebDriver driver) throws InterruptedException {
		String getTitle = addScreeningsPriceRule(1, driver);
		driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a")).click(); // 场次定价
		Thread.sleep(3000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("pricerulestatusname")).click();
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);

		// 对查询结果进行操作
		WebElement table = driver.findElement(By.xpath("//div[@class='table-scroll']"));
		// List<WebElement> tr =
		// driver.findElements(By.xpath("//table/tbody/tr[@class='ng-scope']"));
		List<WebElement> tr = table.findElements(By.xpath("//tbody/tr[@class='ng-scope']"));
		if (tr.size() == 1) {
			System.out.println("tr结果为：" + tr.size() + "，查询成功");
			// 悬停
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
			driver.findElement(By.linkText("详情")).click();
			Thread.sleep(7000);
			String title = driver
					.findElement(By
							.xpath("//div[@class='detail']/div[@class='section'][1]/div[@class='fl']/span[@class='ng-binding']"))
					.getText();
			System.out.println("title:" + title);
			if (title.equals(getTitle)) {
				System.out.println("getTitle:" + getTitle + "与title：" + title + "值相等，校验通过");
			} else {
				System.out.println("getTitle:" + getTitle + "与title：" + title + "值不相等，校验不通过");
			}
			driver.findElement(By.xpath("//div[@class='btn-section']/button")).click(); // 关闭详情
		} else {
			System.out.println("tr.size:" + tr.size());
		}

	}

	public static void auditScreeningsPriceRule(String getTitle, int auditState, int addState, WebDriver driver)
			throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a")).click(); // 场次定价
		Thread.sleep(3000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		if (auditState == 1) // 以下执行审核通过
		{
			if (addState == 1) {
				driver.findElement(By.linkText("审核")).click();
			} else if (addState == 2) {
				driver.findElement(By.linkText("提交审核")).click();
				Thread.sleep(6000);
				driver.findElement(By.linkText("审核")).click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='aduit']/label[1]/span")).click();
			driver.findElement(By.xpath("//div[@class='aduit']/div[3]/button")).click(); // 点击确定
			Thread.sleep(5000);
			driver.findElement(By.linkText("定价")).click(); // 重新进入定价
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a"))
					.click(); // 重新进入场次定价
			Thread.sleep(5000);
			driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
			driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
			driver.findElement(By.linkText("全部状态")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“审核通过”
			driver.findElement(By.linkText("审核通过")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
			Thread.sleep(2000);
			String audit_state = driver
					.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[@class='ng-scope']/td[6]/span"))
					.getText();
			System.out.println("状态：" + audit_state);
			if (audit_state.equals("审核通过")) {
				System.out.println("规则：" + getTitle + "审核通过");
			} else {
				System.out.println("规则：" + getTitle + "的查询状态为" + audit_state);
			}
		} else if (auditState == 2) { // 以下执行审核不通过
			driver.findElement(By.linkText("审核")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='aduit']/label[2]/span")).click(); // 点击审核不通过
			Thread.sleep(2000);
			String input = getTitle + "选择审核不通过按钮";
			driver.findElement(By.name("auditNoPaddReason")).sendKeys(input); // 输入不通过原因
			driver.findElement(By.xpath("//div[@class='aduit']/div[4]/button")).click(); // 点击确定
			Thread.sleep(5000);
			driver.findElement(By.linkText("定价")).click(); // 重新进入定价
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a"))
					.click(); // 重新进入场次定价
			Thread.sleep(5000);
			driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
			driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
			driver.findElement(By.linkText("全部状态")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“审核未通过”
			driver.findElement(By.linkText("审核未通过")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
			Thread.sleep(2000);
			String audit_state = driver
					.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[@class='ng-scope']/td[6]/span"))
					.getText();
			System.out.println("状态：" + audit_state);
			if (audit_state.contains("审核未通过")) {
				System.out.println("规则：" + getTitle + "审核未通过");
				driver.findElement(By.linkText("(原因)")).click();
				Thread.sleep(3000);
				String reason = driver.findElement(By.xpath("//div[@class='dialog-body']/span")).getText();
				if (reason.equals(input)) {
					System.out.println("获取审核未通过原因：" + reason + "与输入结果：" + input + "  一致");
				} else {
					System.out.println("获取审核未通过原因：" + reason + ",输入结果：" + input);
				}
				driver.findElement(By.xpath("//div[@class='ngdialog-close']")).click(); // 关闭原因弹窗
			} else {
				System.out.println("规则：" + getTitle + "的查询状态为" + audit_state);
			}
		}
	}

	public static void modifyScreeningsPriceRule(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a")).click(); // 场次定价
		Thread.sleep(3000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("修改")).click();
		Thread.sleep(5000);
		// 获取原来的时间
		String startTime = driver.findElement(By.name("timeStart")).getText(); // 获取开始时间
		System.out.println("startTime:" + startTime);
		String endTime = driver.findElement(By.name("timeEnd")).getText(); // 获取结束时间
		System.out.println("endTime:" + endTime);

		// 修改选择规则
		driver.findElement(By.xpath("//div[@class='types']/label[2]")).click(); // 点击选择场次定价
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='shows']/button[@type='button']")).click(); // 点击添加场次
		Thread.sleep(5000);
		driver.findElement(By
				.xpath("//div[@class='contents']/div[@class='table-scroll']/table/thead/tr/th/div[@class='fix-header']/label[@class='checkbox']/input[@class='check-all']"))
				.click(); // 全选所有场次
		driver.findElement(By.xpath("//div[@class='show-btns']/button[@type='type']")).click(); // 点击添加到适用场次
		Thread.sleep(7000);

		// 输入原来的开始时间
		JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeS.executeScript("document.getElementsByName(\"timeStart\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setStartDateElement = driver
				.findElement(By.xpath("//div[@class='appliedShowTimes-header']/div/input[@name='timeStart']"));
		Thread.sleep(3000);
		setStartDateElement.sendKeys(startTime);

		// 输入原来的结束时间
		JavascriptExecutor removeAttribute = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttribute.executeScript("document.getElementsByName(\"timeStart\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setEndDateElement = driver
				.findElement(By.xpath("//div[@class='appliedShowTimes-header']/div/input[@name='timeEnd']"));
		Thread.sleep(3000);
		setEndDateElement.sendKeys(endTime);

		// 设置价格政策
		driver.findElement(By.xpath("//div[@class='ways']/label[3]/span")).click(); // 选择最低限价
		Thread.sleep(3000);
		driver.findElement(By.name("limit")).sendKeys("10");
		driver.findElement(
				By.xpath("//div[@class='btn-section']/button[@class='btn btn-default'][@type='sumbit']/span")).click(); // 保存
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ngdialog-content']")));
		Thread.sleep(3000);
		String text = driver
				.findElement(By.xpath("//div[@class='ngdialog-content']/div[@class='dialog-alert-wrapper']/span"))
				.getText();
		System.out.println("弹窗结果:" + text);
		if (text.contains("修改成功")) {
			System.out.println(getTitle + "修改成功");
		} else {
			System.out.println(getTitle + "弹窗结果:" + text);
		}
		driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗

		// 进入详情检查修改内容
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-场次定价
		Thread.sleep(5000);
		// 悬停
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("详情")).click();
		Thread.sleep(5000);
		String checkTitle = driver.findElement(By.xpath("//div[@class='detail']/div[4]/div[1]/span[@class='title']"))
				.getText();
		if (checkTitle.equals("适用场次")) {
			System.out.println("修改场次成功");
			String price = driver.findElement(By.xpath("//div[@class='detail']/div[4]/div[2]/span[2]")).getText();
			if (price.contains("最低限价")) {
				System.out.println("定价策略:" + price + "修改成功");
				System.out.println("修改校验成功");
			} else {
				System.out.println("定价策略:" + price + "未修改成功");
			}
		} else {
			System.out.println("checkTitle:" + checkTitle + ",与对比值：适用场次不符");
		}
		driver.findElement(By.xpath("//div[@class='btn-section']/button")).click(); // 关闭详情
	}

	public static void deleteScreeningsPriceRule(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a")).click(); // 场次定价
		Thread.sleep(3000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='dialog-footer']/button[@class='btn btn-primary']")).click(); // 确定删除
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ngdialog-content']")));
		String deleteInformation = driver
				.findElement(By.xpath("//div[@class='ngdialog-content']/div[@class='dialog-alert-wrapper']/span"))
				.getText();
		if (deleteInformation.contains("删除成功")) {
			System.out.println(getTitle + "删除成功");
		} else {
			System.out.println(getTitle + "删除操作的弹窗信息：" + deleteInformation);
		}
		driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗

		// 通过查询进行进一步删除检查
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-场次定价
		Thread.sleep(5000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚操作的规则
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);
		String information = driver
				.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[@class='msg ng-scope']/td"))
				.getText();
		System.out.println("获取表格信息：" + information);
		if (information.contains("结果为空")) {
			System.out.println("通过查询" + getTitle + "操作，验证删除操作通过");
		} else {
			System.out.println("通过查询" + getTitle + "操作，验证删除操作不通过");
		}
	}

	public static void screeningsPriceRule_adjustPriority(String getTitle, WebDriver driver)
			throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@id='sidebar-scroll'][1]/div/div/ul[@class='nav-main']/li[2]/a")).click(); // 场次定价
		Thread.sleep(3000);
		driver.findElement(By.name("rulesTitle")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.name("status")).click(); // 规则状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("pricerulestatusname")).click(); // 审核状态选择“全部状态”
		driver.findElement(By.linkText("全部状态")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);

		String before = driver.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr/td[8]")).getText();
		System.out.println("before:" + before);

		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("调整优先级")).click();
		Thread.sleep(2000);
		String after = Integer.toString(Integer.parseInt(before) + 1); // 优先级+1
		System.out.println("after:" + after);
		driver.findElement(By.name("rulesPriority")).sendKeys(after);
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(6000);
		String getPriority = driver.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr/td[8]"))
				.getText();
		if (getPriority.equals(after)) {
			System.out.println("调整前:" + before + ",调整后：" + after + ",调整优先级成功");
		} else {
			System.out.println("调整前:" + before + ",调整后：" + after);
		}

	}

	public static String addGoodPriceRule(int priceState, int pricingStrategyState, int saveState, WebDriver driver)
			throws InterruptedException {
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-卖品定价
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='top-wrapper']/button[@class='btn btn-primary btn-new']")).click(); // 新建卖品定价规则
		Thread.sleep(3000);
		java.util.Random rd = new java.util.Random(); // 随机数
		String ruleTitle = "卖品定价规则" + rd.nextInt();
		driver.findElement(By.name("rulesTitle")).sendKeys("ruleTitle"); // 输入规则标题
		System.out.println("定价规则标题：" + ruleTitle);
		if (priceState == 1) {
			driver.findElement(By.xpath("//div[@clas='types']/div[1]")).click(); // 点击批量定价
			driver.findElement(By.xpath("//div[@class='goodsSet']/button[@class='btn btn-primary']")).click(); // 添加卖品
			Thread.sleep(5000);
			driver.findElement(By
					.xpath("//th[@class='check-section']/div[@class='fix-header']/label[@class='t-checkbox']/input[@class='check-all']"))
					.click(); // 全选卖品
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='dialog-footer']/button[@class='btn btn-primary'][@type='type']"))
					.click(); // 添加卖品（确认添加卖品）
			Thread.sleep(5000);
		} else if (priceState == 2) {
			driver.findElement(By.xpath("//div[@clas='types']/div[2]")).click(); // 点击单独定价
			driver.findElement(By.xpath("//div[@class='goodsSet']/button[@class='btn btn-primary']")).click(); // 添加卖品
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[1]/td[1]/label/input")).click(); // 选择第一个商品
			driver.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[2]/td[1]/label/input")).click(); // 选择第二个商品
			driver.findElement(By.xpath("//div[@class='table-scroll']/table/tbody/tr[3]/td[1]/label/input")).click(); // 选择第三个商品
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='dialog-footer']/button[@class='btn btn-primary'][@type='type']"))
					.click(); // 添加卖品（确认添加卖品）
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//form[@name='formAddgoodsPriceRules']/table/tbody/tr[1]/td[4]/input[@type='text']"))
					.sendKeys("10"); // 设置首商品价格
			driver.findElement(
					By.xpath("//form[@name='formAddgoodsPriceRules']/table/tbody/tr[2]/td[4]/input[@type='text']"))
					.sendKeys("20"); // 设置第二个商品价格
			driver.findElement(
					By.xpath("//form[@name='formAddgoodsPriceRules']/table/tbody/tr[3]/td[4]/input[@type='text']"))
					.sendKeys("30"); // 设置第三个商品价格
			Thread.sleep(2000);
		}

		// 选择定价策略
		if (pricingStrategyState == 1) {
			driver.findElement(By.xpath("//div[@class='price ng-scope']/div[2]/div[@class='introInfo']")).click(); // 选择加固定金额
			Thread.sleep(1000);
			driver.findElement(By.name("addFix")).sendKeys("10"); // 输入金额
			Thread.sleep(1000);
		} else if (pricingStrategyState == 2) {
			driver.findElement(By.xpath("//div[@class='price ng-scope']/div[3]/div[@class='introInfo']")).click(); // 选择减固定金额
			Thread.sleep(1000);
			driver.findElement(By.name("reduceFix")).sendKeys("0.1"); // 输入金额
			Thread.sleep(1000);
		} else if (pricingStrategyState == 3) {
			driver.findElement(By.xpath("//div[@class='price ng-scope']/div[4]/div[@class='introInfo']")).click(); // 选择乘固定比例加
			Thread.sleep(1000);
			driver.findElement(By.name("multiplyFixAdd1")).sendKeys("80"); // 乘固定比例
			Thread.sleep(1000);
			driver.findElement(By.name("multiplyFixAdd2")).sendKeys("10"); // 加固定金额
			Thread.sleep(1000);
		} else if (pricingStrategyState == 4) {
			driver.findElement(By.xpath("//div[@class='price ng-scope']/div[5]/div[@class='introInfo']")).click(); // 选择乘固定比例减
			Thread.sleep(1000);
			driver.findElement(By.name("multiplyFixReduce1")).sendKeys("80"); // 乘固定
			Thread.sleep(1000);
			driver.findElement(By.name("multiplyFixReduce2")).sendKeys("10"); // 减固定金额
			Thread.sleep(1000);
		}

		driver.findElement(By.className("check-all")).click(); // 全选适用渠道
		Thread.sleep(2000);

		// 设置有效期
		String startTimeName = "timeStart";
		String EndTimeName = "timeEnd";
		beginTimeAndEndTime(startTimeName, EndTimeName, driver);

		driver.findElement(By.linkText("+添加适用时段")).click(); // 添加适用时段
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[1]/label/input[@week='1']"))
				.click(); // 周一
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[2]/label/input[@week='2']"))
				.click(); // 周二
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[3]/label/input[@week='3']"))
				.click(); // 周三
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[4]/label/input[@week='4']"))
				.click(); // 周四
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[5]/label/input[@week='5']"))
				.click(); // 周五
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[6]/label/input[@week='6']"))
				.click(); // 周六
		driver.findElement(By.xpath("//div[@class='appliedShowTimes-wrapper']/div[2]/ul/li[7]/label/input[@week='7']"))
				.click(); // 周日

		// 开始、结束时间
		JavascriptExecutor removeAttributeTimeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeTimeS.executeScript("document.getElementsByName(\"timeS\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setStartTimeElement = driver.findElement(By.name("timeS"));
		Thread.sleep(3000);
		setStartTimeElement.sendKeys("00:00");

		JavascriptExecutor removeAttributeTimeE = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeTimeE.executeScript("document.getElementsByName(\"timeE\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setEndTimeElement = driver.findElement(By.name("timeE"));
		Thread.sleep(3000);
		setEndTimeElement.sendKeys("23:59");

		// 保存并提交审核||保存
		if (saveState == 1) {
			driver.findElement(By.xpath("//div[@class='goodsPricerules-keep-btns']/button[@class='btn btn-primary']"))
					.click(); // 保存并提交审核
		} else if (saveState == 2) {
			driver.findElement(
					By.xpath("//div[@class='goodsPricerules-keep-btns']/button[@class='btn btn-default'][1]")).click(); // 保存
		}
		Thread.sleep(5000);
		String text = null;
		try {
			new WebDriverWait(driver, 15)
					.until(ExpectedConditions.presenceOfElementLocated(By.className("dialog-alert-wrapper")));
			Thread.sleep(3000);
			text = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText();
			System.out.println("弹窗结果:" + text);
			WebElement close = driver.findElement(By.className("ngdialog-close"));
			close.click();
			if (text.contains("成功")) {
				System.out.println(text);
				Thread.sleep(5000);
				return ruleTitle;
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return "新建不成功";
	}

	public static void queryGoodPriceRule(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-卖品定价
		Thread.sleep(5000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("详情")).click();
		Thread.sleep(7000);
		String title = driver
				.findElement(By.xpath("//div[@class='detail']/div[@class='section']/span[@class='ng-binding']"))
				.getText();
		System.out.println("title:" + title);
		if (title.equals(getTitle)) {
			System.out.println("getTitle:" + getTitle + "与title：" + title + "值相等，校验通过");
		} else {
			System.out.println("getTitle:" + getTitle + "与title：" + title + "值不相等，校验不通过");
		}
		driver.findElement(By.xpath("//div[@class='btn-section']/button")).click(); // 关闭详情
	}

	public static void modifyGoodPriceRule(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-卖品定价
		Thread.sleep(5000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("修改")).click();
		Thread.sleep(7000);
		java.util.Random rd = new java.util.Random(); // 随机数
		String modifyRuleTitle = "修改规则" + rd.nextInt();
		driver.findElement(By.name("rulesTitle")).sendKeys(modifyRuleTitle); // 修改卖品规则名称
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@clas='types']/div[2]")).click(); // 点击单独定价
		Thread.sleep(1000);
		List<WebElement> td = driver.findElements(By.xpath(
				"//from[@name='formAddgoodsPriceRules']/table/tbody/tr[@class='ng-scope']/td[@class='ng-scope']/input[@type='text']"));
		System.out.println("td.size():" + td.size());
		int j = 10;
		for (int i = 0; i < td.size(); i++) {
			j = j + 1;
			td.get(i).sendKeys(Integer.toString(j));
			System.out.println("td[" + i + "]输入金额：" + j);
		}

		driver.findElement(By.xpath("//div[@class='goodsPricerules-keep-btns']/button[@class='btn btn-primary']"))
				.click(); // 保存并提交审核

		try {
			String popupText = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText();
			System.out.println("弹窗内容：" + popupText);
			if (popupText.contains("修改成功")) {
				System.out.println("修改完毕，截获系统提示：" + popupText);
			}
			driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
		} catch (Exception e) {
			System.out.println("未能获取到弹窗信息");
		}

		// 再次通过查询检查修改是否生效
		driver.findElement(By.linkText("定价")).click();
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[3]/a/span")).click(); // 点击卖品定价
		Thread.sleep(5000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		try {
			String result = driver.findElement(By.xpath("//div[@class='tab-content']/div/div[4]/span")).getText();
			System.out.println("查询结果：" + result);
			if (result.equals("暂无数据")) {
				System.out.println("卖品规则标题：" + getTitle + "修改成功");
			} else {
				System.out.println("卖品规则标题：" + getTitle + "修改不成功");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		driver.findElement(By.name("goodspricerulename")).clear(); // 清空输入框
		driver.findElement(By.name("goodspricerulename")).sendKeys(modifyRuleTitle); // 输入刚修改的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		List<WebElement> tr = driver.findElements(By.xpath(
				"//div[@class='tab-content']/div/div[@class='table-scroll goodsPriceTable ng-scope']/table/tbody/tr[@class='ng-scope']"));
		int trSize = tr.size();
		if (trSize > 1) {
			System.out.println("查询结果值为：" + trSize + "与预期存在偏差");
		} else {
			System.out.println(
					"查询结果与预期一致，结果标题为：" + driver.findElement(By.xpath("//td[1]/div[@class='box']/span")).getText());
		}

	}

	public static void deleteGoodPriceRule(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-卖品定价
		Thread.sleep(5000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='dialog-footer']/button[@class='btn btn-primary']")).click(); // 点击确认删除
		Thread.sleep(5000);
		try {
			String popupText = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText();
			System.out.println("popupText:" + popupText);
			if (popupText.contains("删除成功")) {
				driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
				Thread.sleep(5000);
				// 查询
				driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
				driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
				String result = driver.findElement(By.xpath("//div[@class='tab-content']/div/div[4]/span")).getText();
				System.out.println("查询结果：" + result);
				if (result.equals("暂无数据")) {
					System.out.println("卖品规则标题：" + getTitle + "删除成功");
				} else {
					System.out.println("卖品规则标题：" + getTitle + "删除不成功");
				}
			} else {
				driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void auditGoodPriceRule(String getTitle, int saveState, int auditState, WebDriver driver)
			throws InterruptedException {
		Thread.sleep(5000);
		String rootDirectoryName = "定价";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入定价-卖品定价
		Thread.sleep(5000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚新增的卖品定价规则名称
		driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
		Thread.sleep(3000);
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		if (saveState == 1) {
			driver.findElement(By.linkText("审核")).click();
			Thread.sleep(7000);
		} else if (saveState == 2) {
			driver.findElement(By.linkText("提交审核")).click();
			Thread.sleep(5000);
			String popupText = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText(); // 获取弹窗内容
			System.out.println(popupText);
			if (popupText.contains("提交审核成功")) {
				System.out.println(getTitle + "提交审核操作成功");
			}
			driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform(); // 再悬停一下
			driver.findElement(By.linkText("审核")).click();
			Thread.sleep(7000);
		}
		// 执行审核通过
		if (auditState == 1) {
			driver.findElement(By.xpath("//div[@class='aduit']/label[1]/span")).click(); // 审核通过
			driver.findElement(By.xpath("//div[@class='aduit']/div[3]/button")).click(); // 点击确定
			Thread.sleep(5000);
			try {
				String auditPopup = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText(); // 获取弹窗内容
				System.out.println("auditPopup:" + auditPopup);
				if (auditPopup.contains("审核通过成功")) {
					driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
					driver.findElement(By.name("goodspricerulename")).clear(); // 清空输入框
					driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚审核的卖品定价规则名称
					driver.findElement(By.name("goodspricerulestatusname")).click(); // 点击审核状态
					driver.findElement(By.linkText("审核通过")).click(); // 选择审核通过状态
					driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
					Thread.sleep(5000);
					String tableResult = driver
							.findElement(By
									.xpath("//div[@class='tab-content']/div/div[@class='table-scroll goodsPriceTable ng-scope']/table/tbody/tr/td[5]/div[@class='box']/span"))
							.getText();
					if (tableResult.equals("审核通过")) {
						System.out.println(getTitle + "审核通过");
					} else {
						System.out.println("tableResult:" + tableResult);
					}
				} else {
					driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		// 执行审核不通过
		else if (auditState == 2) {
			driver.findElement(By.xpath("//div[@class='aduit']/label[2]/span")).click(); // 点击审核不通过
			Thread.sleep(2000);
			String input = getTitle + "选择了审核不通过按钮";
			driver.findElement(By.name("auditNoPaddReason")).sendKeys(input); // 输入不通过原因
			driver.findElement(By.xpath("//div[@class='aduit']/div[4]/button")).click(); // 点击确定
			Thread.sleep(5000);
			try {
				String auditPopup = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText(); // 获取弹窗内容
				System.out.println("auditPopup:" + auditPopup);
				if (auditPopup.contains("审核不通过成功")) {
					driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
					driver.findElement(By.name("goodspricerulename")).clear(); // 清空输入框
					driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle); // 输入刚审核的卖品定价规则名称
					driver.findElement(By.name("goodspricerulestatusname")).click(); // 点击审核状态
					driver.findElement(By.linkText("审核未通过")).click(); // 选择审核未通过状态
					driver.findElement(By.xpath("//div[@class='btn-query']/button[@type='submit']")).click(); // 点击查询
					Thread.sleep(5000);
					driver.findElement(By.linkText("(原因)")).click(); // 点击原因
					Thread.sleep(2000);
					String popupResult = driver.findElement(By.xpath("//div[@class='dialog-body']/span")).getText();
					if (popupResult.equals(input)) {
						System.out.println(getTitle + "审核不通过，操作成功");
					} else {
						System.out.println("popupResult:" + popupResult);
					}
					driver.findElement(By.xpath("//div[@class='dialog-footer']/button[@class='btn btn-primary']"))
							.click(); // 点击确定，关闭原因弹窗
				} else {
					driver.findElement(By.className("ngdialog-close")).click(); // 关闭弹窗
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	}

	public static void GoodPriceRule_adjustPriority(String getTitle, WebDriver driver) throws InterruptedException {
		Thread.sleep(7000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[3]/a/span")).click(); // 点击卖品定价
		Thread.sleep(3000);
		driver.findElement(By.name("goodspricerulename")).sendKeys(getTitle);// 查询刚新增的规则
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(5000);
		String before = driver
				.findElement(By
						.xpath("//div[@class='tab-content']/div/div[@class='table-scroll goodsPriceTable ng-scope']/table/tbody/tr/td[8]/div/span"))
				.getText(); // 获取修改前的值
		System.out.println("before:" + before);

		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("操作"))).build().perform();
		driver.findElement(By.linkText("调整优先级")).click();
		Thread.sleep(2000);
		// 先输入原来的值
		driver.findElement(By.name("rulesPriority")).clear();
		driver.findElement(By.name("rulesPriority")).sendKeys(before); // 优先级输入原来的值
		driver.findElement(By.name("rulesPriority")).click();
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(2000);
		try {
			String popupText = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText();
			if (popupText.contains("已经存在")) {
				System.out.println("输入已存在的优先级提示：" + popupText + "，校验成功");
			} else {
				System.out.println("popupText:" + popupText);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.findElement(By.className("ngdialog-close")).click(); // 关闭警告弹窗

		// 输入更改的值
		driver.findElement(By.name("rulesPriority")).clear();
		String after = Integer.toString(Integer.parseInt(before) + 1); // 优先级+1
		System.out.println("after:" + after);
		driver.findElement(By.name("rulesPriority")).sendKeys(after);
		driver.findElement(By.name("rulesPriority")).click();
		driver.findElement(By.linkText("确定")).click();
		Thread.sleep(6000);

		String getPriority = driver
				.findElement(By
						.xpath("//div[@class='tab-content']/div/div[@class='table-scroll goodsPriceTable ng-scope']/table/tbody/tr/td[8]/div/span"))
				.getText();
		if (getPriority.equals(after)) {
			System.out.println("调整前:" + before + ",调整后：" + after + ",调整优先级成功");
		} else {
			System.out.println("调整前:" + before + ",调整后：" + after);
		}

	}

	public static void base_setUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("基础设置")).click();
		Thread.sleep(5000);
	}

	// channelType的值1为全部，2为分销商，3为自由渠道，0为不限；channelName的值代表查询地几个名词，0为不限；state的值1为全部，2为为未开放，3为已开放，0为不限
	public static void channelInfo_select(int channelType, int channelName, int state, WebDriver driver)
			throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		/*
		 * driver.findElement(By.xpath(
		 * "//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/div/input[2]"
		 * )).click(); switch (channelType){ case 0 : break; case 1 :
		 * driver.findElement(By.xpath(
		 * "//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/div/ul/li[1]/a"
		 * )).click(); break; case 2 : driver.findElement(By.xpath(
		 * "/y/div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/div/ul/li[2]/a"
		 * )).click(); break; case 3 : driver.findElement(By.xpath(
		 * "/y/div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/div/ul/li[3]/a"
		 * )).click(); break; }
		 */
		if (channelType != 0) {
			if (channelType < 4) {
				Select select_channelName = new Select(driver.findElement(
						By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/div/input[2]")));
				select_channelName.selectByIndex(channelName);
			}
		}

		if (channelName != 0) {
			Select select_channelName = new Select(driver.findElement(
					By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[2]/div/div[1]/ul")));
			select_channelName.selectByIndex(channelName);
		}

		if (state != 0) {
			if (state < 4) {
				Select select_state = new Select(driver.findElement(
						By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[3]/div/div[1]/ul")));
				select_state.selectByIndex(state);
			}
		}

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[4]/button")).click();
		Thread.sleep(3000);
	}

	public static void channelInfo_addChannel(WebDriver driver) throws InterruptedException, SQLException {
		// 删除数据库
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/ec?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");
		Statement stmt;
		stmt = con.createStatement();

		String selectSql_delete = "delete from ec.ec_channel where channel_code = \"1234\"; ";
		long deleteRes_delete = stmt.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		System.out.println("SQL1_DELETE:" + deleteRes_delete);

		// 开始测试
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span"));

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/div[1]/div[4]/button")).click();

		try { // 没有删除则提示这个
			WebElement add = null;
			add = driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[2]/div"));
			if (add.getText().contains("没有课添加的渠道")) {
				System.out.println("没有课添加的渠道");
				driver.findElement(By.xpath("//div[2]/div[2]/div[2]")).click();
			}
		} catch (Exception e) {
		}

		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[2]/div/div/label/span")).click(); // 添加
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(3000);
	}

	public static void channelInfo_addCinema(WebDriver driver) throws InterruptedException, SQLException {
		// 删除数据库
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/ec?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");
		Statement stmt;
		stmt = con.createStatement();

		String selectSql_delete = "delete from ec.ec_channel_cinema where channel_code = \"1234\"; ";
		long deleteRes_delete = stmt.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		System.out.println("SQL1_DELETE:" + deleteRes_delete);

		// 开始测试
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[3]/div")))
				.build().perform();
		driver.findElement(By.linkText("添加影院")).click();

		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/label/span")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(3000);
	}

	public static void channelInfo_deleteCinema(WebDriver driver) throws InterruptedException {
		channelInfo_set(driver);
		Thread.sleep(2000);
		driver.findElement(By
				.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[9]/div/div/div/span[2]"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_stop(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[3]/div")))
				.build().perform();
		driver.findElement(By.linkText("停用")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_Enable(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[3]/div")))
				.build().perform();
		driver.findElement(By.linkText("启用")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_set(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(driver
				.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[3]/div")))
				.build().perform();
		driver.findElement(By.linkText("设置")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_batchEnable(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/thead/tr/th[1]/div/label"))
				.click();
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/div[1]/div[3]/button[1]"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_batchStop(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/thead/tr/th[1]/div/label"))
				.click();
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/div[1]/div[3]/button[2]"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelInfo_batchAddCinema(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[5]/a/span")); // 点击
																							// 渠道信息管理
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/table/thead/tr/th[1]/div/label"))
				.click();
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/div[1]/div[3]/button[3]"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[2]")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelJurisdiction_select(String cinemaName, String channelType, String channelName,
			String payType, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[6]/a/span")).click();

		if (cinemaName != null) {
			Select select_channelName = new Select(driver.findElement(
					By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[1]/div/div[1]/ul")));
			select_channelName.selectByVisibleText(cinemaName);
		}

		if (channelType != null) {
			Select select_channelType = new Select(driver
					.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[2]/div/ul")));
			select_channelType.selectByVisibleText(channelType);
		}

		if (channelName != null) {
			Select select_channelName = new Select(driver
					.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[3]/div/ul")));
			select_channelName.selectByVisibleText(channelName);
		}

		if (payType != null) {
			Select select_payType = new Select(driver.findElement(
					By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[4]/div/ul]")));
			select_payType.selectByVisibleText(payType);
		}

		driver.findElement(
				By.xpath("/html/body/div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[5]/button")).click();
	}

	public static void abuyordersearch_empty(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("订单")).click(); // 点击订单模块
		Thread.sleep(2000);
		driver.findElement(By.linkText("购票订单")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击购票订单
		Thread.sleep(2000);
	}

	public static void bbuyordersearch_accurate(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("orderid")).sendKeys("20160311XXX14700000026"); // 输入全局订单号
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.name("orderid")).clear();
		driver.findElement(By.name("bookingid")).sendKeys("1470160311004878"); // 输入售票系统订单ID
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		// 清空查询条件
		// driver.findElement(By.name("bookingid")).clear();
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Thread.sleep(2000);
	}

	// 订单-购票订单-操作-退票+详情
	// 对上一步查询的订单操作

	public static void dbuyorder_operate(WebDriver driver) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement((WebElement) driver.findElement(By.linkText("操作"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='orderTable']/table/tbody/tr/td[3]/div/ul/li[1]/a")).click(); // 点击详情
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon
		// tabs-header-close']")).click(); //窗口上关闭
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary-light ']")).click(); // 页面下的关闭
		Thread.sleep(2000);
		Actions action1 = new Actions(driver);
		action.moveToElement((WebElement) driver.findElement(By.linkText("操作"))).build().perform(); // 悬停在操作按钮上
		driver.findElement(By.xpath("//div[@id='orderTable']/table/tbody/tr/td[3]/div/ul/li[2]/a")).click(); // 点击退票
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ngdialog1']/div[2]/div/div[3]/div/button[2]")).click(); // 点击取消
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@id='ngdialog1']/div[2]/div[2]")).click();
		// 点击退票弹窗关闭按钮
		action.moveToElement((WebElement) driver.findElement(By.linkText("操作"))).build().perform(); // 悬停在操作按钮上
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='orderTable']/table/tbody/tr/td[3]/div/ul/li[2]/a")).click(); // 点击退票
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[8]/div[2]/div[1]/div[3]/div/button[1]")).click(); // 点击确定
		Thread.sleep(2000);
		Thread.sleep(2000);

	}

	// 购票订单-高级查询
	public static void cbuyordersearch_senior(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='button']")).click(); // 点击“高级查询”
		Thread.sleep(2000);
		driver.findElement(By.name("channeltype")).click();
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("channelname")).click();
		driver.findElement(By.linkText("全部")).click(); // 渠道查询
		Thread.sleep(2000);
		try {
			driver.findElement(By.name("cinemaname")).click(); // 影院名查询
			driver.findElement(By.linkText("75影院")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("----找不到影院");
		}
		driver.findElement(By.name("statusname")).click(); // 订单状态查询
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		// 日期选择未写
		// 获取购票开始日期输入框，清除readonly属性，并输入日期
		try {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS.executeScript("document.getElementsByName(\"booksd\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			WebElement setStartDateElement = driver
					.findElement(By.xpath("//div[@class='form-group']/input[@name='booksd']"));
			Thread.sleep(3000);
			setStartDateElement.clear();
			setStartDateElement.sendKeys("2016-03-10 15:55:");
			driver.findElement(By.className("content-body")).click();

		} catch (Exception e) {
			System.out.println("---输入不了时间");
		}
		// 获取购票结束日期输入框，清除readonly属性，并输入日期
		try {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS.executeScript("document.getElementsByName(\"booked\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			WebElement setStartDateElement = driver
					.findElement(By.xpath("//div[@class='form-group']/input[@name='booked']"));
			Thread.sleep(3000);
			setStartDateElement.clear();
			setStartDateElement.sendKeys("2016-03-10 15:56");
			driver.findElement(By.className("content-body")).click();

		} catch (Exception e) {
			System.out.println("---输入不了时间");
		}
		/*
		 * //获取退票开始日期输入框，清除readonly属性，并输入日期 try{ JavascriptExecutor
		 * removeAttributeS=(JavascriptExecutor) driver;
		 * removeAttributeS.executeScript(
		 * "document.getElementsByName(\"refundsd\")[0].removeAttribute(\"readonly\");"
		 * ); Thread.sleep(3000); WebElement setStartDateElement = driver
		 * .findElement(By.xpath(
		 * "//div[@class='form-group']/input[@name='refundsd']"));
		 * Thread.sleep(3000); setStartDateElement.sendKeys("2016-01-16 00:00");
		 * driver.findElement(By.className("content-body")).click();
		 * 
		 * } catch(Exception e){ System.out.println("---输入不了时间"); }
		 * //获取退票结束日期输入框，清除readonly属性，并输入日期 try{ JavascriptExecutor
		 * removeAttributeS=(JavascriptExecutor) driver;
		 * removeAttributeS.executeScript(
		 * "document.getElementsByName(\"refunded\")[0].removeAttribute(\"readonly\");"
		 * ); Thread.sleep(3000); WebElement setStartDateElement = driver
		 * .findElement(By.xpath(
		 * "//div[@class='form-group']/input[@name='refunded']"));
		 * Thread.sleep(3000); setStartDateElement.sendKeys("2016-03-16 00:00");
		 * driver.findElement(By.className("content-body")).click();
		 * 
		 * } catch(Exception e){ System.out.println("---输入不了时间"); }
		 * //获取放映开始日期输入框，清除readonly属性，并输入日期 try{ JavascriptExecutor
		 * removeAttributeS=(JavascriptExecutor) driver;
		 * removeAttributeS.executeScript(
		 * "document.getElementsByName(\"showsd\")[0].removeAttribute(\"readonly\");"
		 * ); Thread.sleep(3000); WebElement setStartDateElement = driver
		 * .findElement(By.xpath(
		 * "//div[@class='form-group']/input[@name='showsd']"));
		 * Thread.sleep(3000); setStartDateElement.sendKeys("2016-01-16 00:00");
		 * driver.findElement(By.className("content-body")).click();
		 * 
		 * } catch(Exception e){ System.out.println("---输入不了时间"); }
		 * //获取放映结束日期输入框，清除readonly属性，并输入日期 try{ JavascriptExecutor
		 * removeAttributeS=(JavascriptExecutor) driver;
		 * removeAttributeS.executeScript(
		 * "document.getElementsByName(\"showed\")[0].removeAttribute(\"readonly\");"
		 * ); Thread.sleep(3000); WebElement setStartDateElement = driver
		 * .findElement(By.xpath(
		 * "//div[@class='form-group']/input[@name='showed']"));
		 * Thread.sleep(3000); setStartDateElement.sendKeys("2016-03-16 00:00");
		 * driver.findElement(By.className("content-body")).click();
		 * 
		 * } catch(Exception e){ System.out.println("---输入不了时间"); }
		 */
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[@type='button']")).click();
		// //返回“精度查询”
		// Thread.sleep(2000);
	}
	// 订单-卖品订单-不输入任何信息-查询

	public static void agoodordersearch_empty(WebDriver driver) throws InterruptedException {

		driver.findElement(By.linkText("订单")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("卖品订单")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	// 订单-卖品订单-精确查询

	public static void bgoodordersearch_accurate(WebDriver driver) throws InterruptedException {
		// 按全局订单号查询
		driver.findElement(By.name("goodsorderid")).sendKeys("16030201472259000003");
		Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.name("goodsorderid")).clear();
		// 按售票系统订单号查询
		driver.findElement(By.name("holdid")).sendKeys("16030201472259000003");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(2000);
		try {
			// 查看订单详情,并关闭详情页
			driver.findElement(
					By.xpath("//div[@id='main-container']/div[3]/div/div/div/div/div/div[2]/table/tbody/tr/td[2]/a"))
					.click(); // 点击详情
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//a[@class='iconfont icon-guanbiicon
			// tabs-header-close']")).click(); //窗口上关闭
			// Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn btn-default']")).click(); // 页面下的关闭
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("---找不到数据");
		}
	}

	// 订单-卖品订单-高级查询

	public static void cgoodordersearch_senior(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//form[@name='formGoodsOrder']/div[3]/button[@type='button']")).click(); // 点击“高级查询”

		Thread.sleep(2000);
		try {
			driver.findElement(By.name("cinemaname")).click(); // 影院名查询
			driver.findElement(By.linkText("75影院")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("---找不到影院");
		}
		driver.findElement(By.name("channelname")).click();
		driver.findElement(By.linkText("全部")).click(); // 渠道查询
		Thread.sleep(2000);
		driver.findElement(By.name("statusname")).click(); // 订单状态查询
		driver.findElement(By.linkText("全部")).click();
		Thread.sleep(2000);
		// 日期选择未写

		// 获取开始日期输入框，清除readonly属性，并输入日期

		try {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"goodsorderstart\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			WebElement setStartDateElement = driver
					.findElement(By.xpath("//div[@class='form-group']/input[@name='goodsorderstart']"));
			Thread.sleep(3000);
			setStartDateElement.sendKeys("2016-03-01 00:00");
			driver.findElement(By.className("content-body")).click();

		} catch (Exception e) {
			System.out.println("---输入不了时间");
		}
		// 获取结束日期输入框，清除readonly属性，并输入日期
		try {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"goodsorderend\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			WebElement setStartDateElement = driver
					.findElement(By.xpath("//div[@class='form-group']/input[@name='goodsorderend']"));
			Thread.sleep(3000);
			setStartDateElement.sendKeys("2016-03-16 00:00");
			driver.findElement(By.className("content-body")).click();

		} catch (Exception e) {
			System.out.println("---输入不了时间");
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(2000);
	}

	public static void queryTicketBoxDetailReport(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "报表";
		String SubDirectoryPath = "//ul[@class='nav-main']/li/a";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入报表-票房销售明细报表
		Thread.sleep(3000);
		driver.findElement(By.name("cinemaName")).click(); // 选择影院
		driver.findElement(By.linkText("全部影院")).click();
		driver.findElement(By.name("channelName")).click(); // 选择销售渠道
		driver.findElement(By.linkText("全部渠道")).click();
		JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeS.executeScript("document.getElementsByName(\"beginDate\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		driver.findElement(By.name("beginDate")).sendKeys("2015-09-01");

		removeAttributeS.executeScript("document.getElementsByName(\"endDate\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = date.format(new Date()); // 获取当前系统时间
		driver.findElement(By.name("endDate")).sendKeys(nowDate);
		driver.findElement(By.id("btnQ")).click(); // 点击查询
		Thread.sleep(5000);

		new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.className("total-wrapper"))); // 总计所在div
		WebElement total = driver.findElement(By.className("sales-overview")); // 总计数据栏
		String totalTickets = total.findElement(By.xpath("//div[@class='box red'][1]/div[2]")).getText();
		String totalTicketsNum = total.findElement(By.id("totalActualTickets")).getText();

		String totalAmount = total.findElement(By.xpath("//div[@class='box red'][2]/div[2]")).getText();
		String totalAmountNum = total.findElement(By.id("actualTotalAmount")).getText();

		String totalNum = total
				.findElement(By.xpath("//div[@class='box-lg']/div[@class='box red']/div[1]/span[@class='red']"))
				.getText() + total
						.findElement(By
								.xpath("//div[@class='box-lg']/div[@class='box red']/div[1]/span[@class='red']/span[@id='totalTickets']"))
						.getText(); // 总售票数
		String totalTicketsAmount = total
				.findElement(By.xpath("//div[@class='box-lg']/div[@class='box red']/div[2]/span[@class='red']"))
				.getText() + total
						.findElement(By
								.xpath("//div[@class='box-lg']/div[@class='box red']/div[2]/span[@class='red']/span[@id='totalTicketsAmount']"))
						.getText();
		String refundTickets = total.findElement(By.xpath("//div[@class='box-lg']/div[@class='box green']/div[1]/span"))
				.getText() + total
						.findElement(By
								.xpath("//div[@class='box-lg']/div[@class='box green']/div[1]/span/span[@id='refundTickets']"))
						.getText();
		String refundTicketsAmount = total
				.findElement(By.xpath("//div[@class='box-lg']/div[@class='box green']/div[2]/span")).getText() + total
						.findElement(By
								.xpath("//div[@class='box-lg']/div[@class='box green']/div[2]/span/span[@id='refundTicketsAmount']"))
						.getText();
		if (totalTickets != null) {
			System.out.println(totalTickets + totalTicketsNum);
			System.out.println(totalAmount + totalAmountNum);
			System.out.println(totalNum);
			System.out.println(totalTicketsAmount);
			System.out.println(refundTickets);
			System.out.println(refundTicketsAmount);
			System.out.println("报表查询成功");
		}
	}

	public static void queryTicketSalesOverviewReport(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "报表";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[2]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入报表-票房销售总览报表
		Thread.sleep(3000);
		driver.findElement(By.id("channelList")).click(); // 销售渠道
		driver.findElement(By.linkText("全部渠道")).click();

		JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeS.executeScript("document.getElementsByName(\"beginDate\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		driver.findElement(By.name("beginDate")).sendKeys("2015-09-01"); // 开始日期

		removeAttributeS.executeScript("document.getElementsByName(\"endDate\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = date.format(new Date()); // 获取当前系统时间
		driver.findElement(By.name("endDate")).sendKeys(nowDate); // 结束日期

		driver.findElement(By.id("btnQ")).click(); // 查询
		Thread.sleep(5000);
		if (driver.findElement(By.id("grid")).isDisplayed()) {
			String result = driver.findElement(By.xpath("//div[@id='pager']/span")).getText()
					+ driver.findElement(By.xpath("//div[@id='pager']/span/strong"));
			System.out.println(result);
			System.out.println("报表查询成功");
		} else {
			System.out.println("报表控件是否显示：" + driver.findElement(By.id("grid")).isDisplayed());
		}
	}

	public static void EditCoupons(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[6]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-券管理
		Thread.sleep(5000);
		driver.findElement(By.name("voucherCinemaName")).click(); // 影院
		driver.findElement(By.linkText("全部")).click(); // 选全部影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(4000);
		String cinemaName = null;
		try {
			List<WebElement> tr = driver.findElements(By.xpath("//table[@id='channelinfo-table']/tbody/tr")); // 查询结果的行
			System.out.println("tr.size:" + tr.size());
			String getClassAfter = null;
			if (tr.size() != 0) {
				// 悬停
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("编辑")).click(); // 点击编辑
				Thread.sleep(3000);

				cinemaName = driver.findElement(By.name("cinemaName")).getAttribute("value"); // 获取影片名
				System.out.println("cinemaName:" + cinemaName);

				String getClassBefore = driver
						.findElement(By
								.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
						.getAttribute("class");
				System.out.println("全选控件className：" + getClassBefore);

				if (getClassBefore.contains("checked")) {
					System.out.println("全选控件当前状态为全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击取消全选
					getClassAfter = driver
							.findElement(By
									.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.getAttribute("class");
					if (getClassAfter.equals("t-checkbox")) {
						System.out.println("进行取消全选操作");
					} else {
						System.out.println("取消全选操作失败，getClassAfter:" + getClassAfter);
					}
				} else if (getClassBefore.equals("t-checkbox")) {
					System.out.println("全选控件当前状态为非全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击全选
					getClassAfter = driver
							.findElement(By
									.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.getAttribute("class");
					if (getClassAfter.contains("checked")) {
						System.out.println("进行全选操作");
					} else {
						System.out.println("取消全选操作失败，getClassAfter:" + getClassAfter);
					}
				}

			}
			driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']")).click(); // 保存
			Thread.sleep(4000);
			// 通过查询验证保存是否生效
			driver.findElement(By.name("voucherCinemaName")).click(); // 影院
			driver.findElement(By.linkText(cinemaName)).click(); // 选全部影院
			driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
			String nowGetClassAfter = driver
					.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
					.getAttribute("class"); // 再次获取复选框class属性
			if (nowGetClassAfter.equals(getClassAfter)) {
				System.out.println("查询后验证复选框修改成功");
			} else {
				System.out.println("nowGetClassAfter:" + nowGetClassAfter + ",getClassAfter:" + getClassAfter);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void BatchOperationCoupons(int state, WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[6]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-券管理
		Thread.sleep(5000);
		driver.findElement(By.name("voucherCinemaName")).click(); // 影院
		driver.findElement(By.linkText("全部")).click(); // 选全部影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(4000);
		String cinemaName = null;
		try {
			List<WebElement> tr = driver.findElements(By.xpath("//table[@id='channelinfo-table']/tbody/tr")); // 查询结果的行
			System.out.println("tr.size:" + tr.size());

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By
					.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
					.build().perform();
			driver.findElement(By.linkText("编辑")).click(); // 点击编辑
			Thread.sleep(3000);

			cinemaName = driver.findElement(By.name("cinemaName")).getAttribute("value"); // 获取影片名
			System.out.println("cinemaName:" + cinemaName);

			String getClassBefore = driver
					.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
					.getAttribute("class"); // 获取class为得知input的勾选状态
			if (state == 1) {
				if (getClassBefore.contains("checked")) {
					System.out.println("全选控件当前状态为全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击取消全选
					driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']"))
							.click(); // 保存
					System.out.println("全选控件已恢复至非全选状态");
					Thread.sleep(4000);
				} else {
					System.out.println("全选控件当前状态为非全选");
				}

				Thread.sleep(3000);
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选刚修改的影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				driver.findElement(By
						.xpath("//th[@class='check-section']/div[@class='fix-header']/label[@class='checkbox']/input[@class='check-all']"))
						.click(); // 全选
				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//div[@class='top-wrapper']/div[@class='left-content ng-scope']/button[1]")).click(); // 点击批量开放券使用
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定批量开放
				Thread.sleep(7000);
				// 通过查询验证影院是否批量开放成功
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选全部影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(3000);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("编辑")).click(); // 点击编辑
				Thread.sleep(3000);
				String getClassAfterOpen = driver
						.findElement(By
								.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
						.getAttribute("class"); // 获取class为得知input的勾选状态
				if (getClassAfterOpen.contains("checked")) {
					System.out.println("批量开放成功，getClassAfterOpen：" + getClassAfterOpen);
				} else {
					System.out.println("批量开放不成功，getClassAfterOpen：" + getClassAfterOpen);
				}
			} else if (state == 2) {
				if (getClassBefore.equals("t-checkbox")) {
					System.out.println("全选控件当前状态为非全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击全选
					driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']"))
							.click(); // 保存
					System.out.println("全选控件已恢复至全选状态");
					Thread.sleep(4000);
				} else {
					System.out.println("全选控件当前状态为全选");
				}
				Thread.sleep(3000);
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText("全部")).click(); // 选全部影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				driver.findElement(By
						.xpath("//th[@class='check-section']/div[@class='fix-header']/label[@class='checkbox']/input[@class='check-all']"))
						.click(); // 全选
				Thread.sleep(3000);
				driver.findElement(
						By.xpath("//div[@class='top-wrapper']/div[@class='left-content ng-scope']/button[2]")).click(); // 点击批量关闭券使用
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定批量关闭
				Thread.sleep(7000);
				// 通过查询验证影院是否批量关闭成功
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选全部影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(3000);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("编辑")).click(); // 点击编辑
				Thread.sleep(3000);
				String getClassAfterOpen = driver
						.findElement(By
								.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
						.getAttribute("class"); // 获取class为得知input的勾选状态
				if (getClassAfterOpen.contains("checked")) {
					System.out.println("批量关闭不成功，getClassAfterOpen：" + getClassAfterOpen);
				} else {
					System.out.println("批量关闭成功，getClassAfterOpen：" + getClassAfterOpen);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void openOrCloseCoupons(int state, WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[6]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-券管理
		Thread.sleep(5000);
		driver.findElement(By.name("voucherCinemaName")).click(); // 影院
		driver.findElement(By.linkText("全部")).click(); // 选全部影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(4000);
		String cinemaName = null;
		try {
			List<WebElement> tr = driver.findElements(By.xpath("//table[@id='channelinfo-table']/tbody/tr")); // 查询结果的行
			System.out.println("tr.size:" + tr.size());

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By
					.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
					.build().perform();
			driver.findElement(By.linkText("编辑")).click(); // 点击编辑
			Thread.sleep(3000);

			cinemaName = driver.findElement(By.name("cinemaName")).getAttribute("value"); // 获取影片名
			System.out.println("cinemaName:" + cinemaName);

			String getClassBefore = driver
					.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
					.getAttribute("class"); // 获取class为得知input的勾选状态
			if (state == 1) {
				if (getClassBefore.contains("checked")) {
					System.out.println("全选控件当前状态为全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击取消全选
					driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']"))
							.click(); // 保存
					System.out.println("全选控件已恢复至非全选状态");
					Thread.sleep(4000);
				} else {
					System.out.println("全选控件当前状态为非全选");
				}

				Thread.sleep(3000);
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选上方编辑的影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("开放")).click(); // 点击开放
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定开放
				Thread.sleep(7000);
				// 通过查询验证影院是否开放成功
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选全部影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(3000);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("编辑")).click(); // 点击编辑
				Thread.sleep(3000);
				String getClassAfterOpen = driver
						.findElement(By
								.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
						.getAttribute("class"); // 获取class为得知input的勾选状态
				if (getClassAfterOpen.contains("checked")) {
					System.out.println("开放成功，getClassAfterOpen：" + getClassAfterOpen);
				} else {
					System.out.println("开放不成功，getClassAfterOpen：" + getClassAfterOpen);
				}
			} else if (state == 2) {
				if (getClassBefore.equals("t-checkbox")) {
					System.out.println("全选控件当前状态为非全选");
					driver.findElement(By
							.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
							.click(); // 点击全选
					driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']"))
							.click(); // 保存
					System.out.println("全选控件已恢复至全选状态");
					Thread.sleep(4000);
				} else {
					System.out.println("全选控件当前状态为全选");
				}
				Thread.sleep(3000);
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选刚编辑的影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(3000);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("关闭")).click(); // 点击关闭
				driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定关闭
				Thread.sleep(7000);
				// 通过查询验证影院是否关闭成功
				driver.findElement(By.name("voucherCinemaName")).click(); // 影院
				driver.findElement(By.linkText(cinemaName)).click(); // 选全部影院
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(3000);
				action.moveToElement(driver.findElement(By
						.xpath("//table[@id='channelinfo-table']/tbody/tr[1]/td[@class='ng-scope']/div[@class='dropdown']/a[@class='btn-more']/span")))
						.build().perform();
				driver.findElement(By.linkText("编辑")).click(); // 点击编辑
				Thread.sleep(3000);
				String getClassAfterOpen = driver
						.findElement(By
								.xpath("//div[@class='basic-group checkbox-group']/div[@class='content-group check-list']/label[1]/div"))
						.getAttribute("class"); // 获取class为得知input的勾选状态
				if (getClassAfterOpen.contains("checked")) {
					System.out.println("批量关闭不成功，getClassAfterOpen：" + getClassAfterOpen);
				} else {
					System.out.println("批量关闭成功，getClassAfterOpen：" + getClassAfterOpen);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void queryBannerSetting(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "基础设置";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[9]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入基础设置-内容编辑
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[1]/a/span")).click(); // banner设置
		Thread.sleep(5000);
		// 获取查询记录数
		try {
			WebElement record = driver.findElement(By.xpath("//div[@class='total-wrap']/span[2]")); // 获取记录数
			System.out.println("record.isDisplayed():" + record.isDisplayed());
			if (record.isDisplayed()) {
				int recordNum = Integer.parseInt(record.getText());
				System.out.println("页面开启时记录数：" + recordNum);

				driver.findElement(By.name("statusName")).click(); // 状态
				driver.findElement(By.linkText("过期")).click(); // 选择过期
				driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
				Thread.sleep(5000);
				WebElement noData = driver.findElement(
						By.xpath("//div[@class='tab-content']/div/div[3]/div[@class='tip-section ng-scope']/span"));
				System.out.println("noData.isDisplayed()" + noData.isDisplayed());
				if (noData.isDisplayed()) {
					String result = noData.getText();
					System.out.println("result:" + result);
					if (result.equals("暂无数据")) {
						System.out.println("查询结束，没有符合查询条件的数据");
					}
				} else {
					System.out.println("再次查询record.isDisplayed():" + record.isDisplayed());
					if (record.isDisplayed()) {
						int NowRecordNum = Integer.parseInt(record.getText());
						System.out.println("查询后记录数：" + NowRecordNum);
						if (recordNum != NowRecordNum) {
							System.out.println("查询成功");
						} else {
							System.out.println("recordNum:" + recordNum + ",NowRecordNum:" + NowRecordNum + ",需要进一步验证");
						}
					}

				}
			} else {
				System.out.println("没有banner记录");
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static String addBannerSetting(WebDriver driver) throws InterruptedException, IOException {
		String rootDirectoryName = "基础设置";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[9]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入基础设置-内容编辑
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[1]/a/span")).click(); // banner设置
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='right-content']/button[@type='button']")).click(); // 新建banner

		java.util.Random rd = new java.util.Random(); // 随机数
		String bannerTitle = "banner" + rd.nextInt();
		driver.findElement(By.name("bannerName")).sendKeys(bannerTitle); // banner标题
		driver.findElement(By.xpath("//div[@class='radio-list']/label[1]/span")).click(); // banner类型-营销活动
		driver.findElement(By.id("110100")).click(); // 北京
		Thread.sleep(1000);
		driver.findElement(By.id("130800")).click(); // 承德
		Thread.sleep(1000);
		driver.findElement(By.id("140200")).click(); // 大同
		Thread.sleep(1000);
		driver.findElement(By.className("check-all")).click(); // 全选渠道

		// 此处应有banner图片上传
		driver.findElement(By.xpath("//div[@class='banner-img-content']/button[@type='button']")).click(); //更换banner图片
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='dialog-body']/form[2]/div[@class='btn btn-primary btn-sm btn-file']/input[class='file']")).click(); //上传本地图片
		Runtime runtime=Runtime.getRuntime();
		Process p=runtime.exec("‪E:\\DYY\\upfile.exe");
		//Process p=runtime.exec("\"‪E:/DYY/upfile.exe\"");
		//p=runtime.exec("\"‪E:/DYY/upfile.exe\"");
		
		// 开始--结束时间
		String startTimeName = "startTime";
		String EndTimeName = "endTime";
		beginTimeAndEndTime(startTimeName, EndTimeName, driver);

		driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']")).click(); // 保存
		Thread.sleep(5000);
		WebElement popup = driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span"));
		if (popup.isDisplayed()) {
			System.out.println("弹窗内容：" + popup.getText());
			if (popup.getText().equals("保存成功")) {
				System.out.println(bannerTitle + "保存成功");
				return bannerTitle;
			} else {
				System.out.println("保存失败");

			}

		}
		return "新建失败";
	}

	public static void beginTimeAndEndTime(String startTimeName, String EndTimeName, WebDriver driver)
			throws InterruptedException {

		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = date.format(new Date()); // 获取当前系统时间
		System.out.println(nowDate); // 输出当前系统时间

		// 获取开始日期输入框，清除readonly属性，并输入日期
		JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeS.executeScript("document.getElementsByName(startTimeName)[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setStartDateElement = driver
				.findElement(By.xpath("//div[@class='appliedShowTimes-header']/div/input[@name=startTimeName]"));
		Thread.sleep(3000);
		setStartDateElement.sendKeys(nowDate);
		System.out.println("开始时间：" + nowDate);

		// 获取结束日期输入框，清除readonly属性，并输入日期
		JavascriptExecutor removeAttributeE = (JavascriptExecutor) driver;
		// remove readonly attribute
		removeAttributeE.executeScript("document.getElementsByName(EndTimeName)[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		WebElement setEndDateElement = driver
				.findElement(By.xpath("//div[@class='appliedShowTimes-header']/div/input[@name=EndTimeName]"));
		String nowYear = nowDate.split("-")[0]; // 截取年份
		System.out.println("截取到的当前年份为：" + nowYear);
		String nowMonth = nowDate.split("-")[1]; // 截取月份
		System.out.println("截取到的当前月份为：" + nowMonth);
		String nowDay = nowDate.split("-")[2]; // 截取日期
		System.out.println("截取到的当前日为：" + nowDay);
		// 最终月份在当前月份基础上加1，当前是12月份，则选择1月
		String lastMonth = null;
		if (nowMonth.contains("0")) {
			int month = Integer.parseInt(nowMonth);
			System.out.println("nowMonth转换类型后：" + nowMonth);
			if (month < 10) {
				month = Integer.parseInt((nowMonth.split("0")[1]));
				int lsMonth = month + 1;
				if (lsMonth / 10 == 1) {
					lastMonth = Integer.toString(lsMonth);
					System.out.println("最终月份：" + lastMonth);
				} else {
					lastMonth = "0" + Integer.toString(lsMonth);
					System.out.println("最终月份：" + lastMonth);
				}

			}
			if (month == 10) {
				lastMonth = Integer.toString(month + 1);
				System.out.println("最终月份：" + lastMonth);
			}
		} else if (nowMonth.equals("12")) {
			lastMonth = "01";
			System.out.println("最终月份：" + lastMonth);
		} else {
			lastMonth = Integer.toString(Integer.parseInt(nowMonth) + 1);
			System.out.println("最终月份：" + lastMonth);
		}

		// 最终日选择当前月的最后1天，若当天为最后1天，则选择下月最后1天
		String lastDay = null;
		int lsDay = Integer.parseInt(nowDay) + 1;
		if (lsDay < 10) {
			lastDay = "0" + Integer.toString(lsDay);
			System.out.println("最终日：" + lastDay);
		} else if (lsDay <= 28) {
			lastDay = Integer.toString(lsDay);
			System.out.println("最终日：" + lastDay);
		} else if (lsDay > 28) {
			if (lastMonth == "02") {
				lastDay = "28";
				System.out.println("最终日：" + lastDay);
			} else if (lsDay > 30) {
				if (lastMonth == "04" || lastMonth == "06" || lastMonth == "09" || lastMonth == "11") {
					lastDay = "30";
					System.out.println("最终日：" + lastDay);
				} else if (lsDay > 31) {
					if (lastMonth == "01" || lastMonth == "03" || lastMonth == "05" || lastMonth == "07"
							|| lastMonth == "08" || lastMonth == "10" || lastMonth == "12") {
						lastDay = "31";
						System.out.println("最终日：" + lastDay);
					}
				}
			}

		}

		// 最终年为今年，若最终月为12月，则年份加1
		String lastYear = null;
		if (lastMonth == "12") {
			lastYear = Integer.toString(Integer.parseInt(nowYear) + 1);
			System.out.println("最终年：" + lastYear);
		} else {
			lastYear = nowYear;
			System.out.println("最终年：" + lastYear);
		}

		String lastDate = lastYear + "-" + lastMonth + "-" + lastDay;
		System.out.println("最终时间：" + lastDate);
		setEndDateElement.sendKeys(lastDate);
		System.out.println("结束时间：" + lastDate);
	}

	public static void EnterTheFirstLevelSubDirectory(String rootDirectoryName, String SubDirectoryPath,
			WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText(rootDirectoryName)).click(); // 进入根目录
		Thread.sleep(3000);
		driver.findElement(By.xpath(SubDirectoryPath)).click(); // 进入子目录
	}

	public static String addAndQueryInformationArticles(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "基础设置";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[9]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[2]/a/span")).click(); // 进入资讯文章
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='right-content']/button")).click(); // 新建文章
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//form[@name='formAdd']/div[1]/div[1]/div[@class='basic-group']/div[@class='dropdown']/input[@name='typeName']"))
				.click(); // 文章类型
		driver.findElement(By.linkText("活动")).click(); // 选择活动
		driver.findElement(By.className("check-all")).click(); // 全选使用渠道
		driver.findElement(By.id("110100")).click(); // 选择 北京、承德、大同
		driver.findElement(By.id("130800")).click();
		driver.findElement(By.id("140200")).click();
		Thread.sleep(1000);
		java.util.Random rd = new java.util.Random(); // 随机数
		String title = "文章" + rd.nextInt();
		driver.findElement(By.xpath("//input[@placeholder='文章标题'][@name='title']")).sendKeys(title); // 输入文章标题
		String startTime = "startTime"; // 设置开始、结束时间
		String EndTimeName = "endTime";
		beginTimeAndEndTime(startTime, EndTimeName, driver);
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@type='submit']")).click(); // 保存
		Thread.sleep(5000);
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[2]/a/span")).click(); // 进入资讯文章
		Thread.sleep(3000);
		driver.findElement(By.name("title")).sendKeys(title); // 查询条件-文章标题
		driver.findElement(By.xpath("//div[@class='basic-btn-section']/button[@type='submit']")).click(); // 查询
		Thread.sleep(3000);
		try {
			boolean displayedState = driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span"))
					.isDisplayed(); // 暂无数据
			if (displayedState == true) {
				System.out.println("查询成功");
				System.out.println(driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span")).getText()); // 暂无数据
				System.out.println("新建文章不成功");
			} else {
				String getResultTitle = driver.findElement(By.xpath("//td[@class='first']/span")).getText();
				if (getResultTitle.equals(title)) {
					System.out.println("查询成功");
					System.out.println("新建文章成功");
					return title;
				} else {
					System.out.println("查询成功，新建不成功，getResultTitle：" + getResultTitle + "title:" + title);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return "新建校验不成功，需进一步检查";
	}

	public static void modifyInformationArticles(String title, WebDriver driver) throws InterruptedException {
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[@class='tab-content']/div[1]/div[4]/table/tbody/tr/td[2]/div/"))) // 操作
				.build().perform();

		driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(sleepBase * 5000);

		driver.findElement(By.id("130600")).click(); // 选择保定、沧州
		driver.findElement(By.id("130900")).click();

		java.util.Random rd = new java.util.Random(); // 随机数
		String modifytitle = "文章" + rd.nextInt();
		driver.findElement(By.xpath("//input[@placeholder='文章标题'][@name='title']")).clear(); // 清除原标题
		driver.findElement(By.xpath("//input[@placeholder='文章标题'][@name='title']")).sendKeys(modifytitle); // 输入文章标题
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@type='submit']")).click(); // 保存
		Thread.sleep(5000);

		driver.findElement(By.name("title")).sendKeys(title); // 查询条件-文章标题（查询旧记录是否依然存在）
		try {
			boolean displayedState = driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span"))
					.isDisplayed(); // 暂无数据
			String getResult = null;
			if (displayedState == true) {
				getResult = driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span")).getText();
				System.out.println("旧文章记录不存在,查询结果:" + getResult); // 暂无数据
			} else {
				String getResultTitle = driver.findElement(By.xpath("//td[@class='first']/span")).getText();
				if (getResultTitle.equals(title)) {
					System.out.println("旧文章记录依然存在，修改不成功，获取文章标题为：" + title);
				} else {
					System.out.println("修改不成功，获取文章标题为：" + title);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		String rootDirectoryName = "基础设置";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[9]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[2]/a/span")).click(); // 进入资讯文章
		Thread.sleep(5000);
		driver.findElement(By.name("title")).sendKeys(modifytitle); // 查询条件-文章标题（查询新记录是否依然存在）
		driver.findElement(By.xpath("//div[@class='basic-btn-section']/button[@type='submit']")).click(); // 查询
		Thread.sleep(3000);
		try {
			boolean displayedState = driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span"))
					.isDisplayed(); // 暂无数据
			if (displayedState == true) {
				System.out.println(driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span")).getText()); // 暂无数据
				System.out.println("修改文章不成功");
			} else {
				String getResultTitle = driver.findElement(By.xpath("//td[@class='first']/span")).getText();
				if (getResultTitle.equals(modifytitle)) {
					System.out.println("修改文章成功");
				} else {
					System.out.println(
							"修改文章不成功，getResultTitle：" + getResultTitle + "，modifytitle：" + modifytitle + "结果不一致");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void enableAndDisableInformationArticles(String title, WebDriver driver) throws InterruptedException {
		// 进行启用操作
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[@class='tab-content']/div[1]/div[4]/table/tbody/tr/td[2]/div/"))) // 操作
				.build().perform();

		driver.findElement(By.linkText("启用")).click();
		Thread.sleep(sleepBase * 5000);

		driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定
		Thread.sleep(6000);

		String articleState1 = driver
				.findElement(By.xpath("//div[@class='table-scroll article-table ng-scope']/table/tbody/tr[1]/td[7]"))
				.getText(); // 获取当前文章状态
		if (articleState1.equals("启用")) {
			System.out.println(title + "启用成功");
		} else {
			System.out.println("title:" + title + "，当前状态为：" + articleState1 + "，启用失败");
		}

		// 进行停用操作
		action.moveToElement(
				driver.findElement(By.xpath("//div[@class='tab-content']/div[1]/div[4]/table/tbody/tr/td[2]/div/"))) // 操作
				.build().perform();

		driver.findElement(By.linkText("停用")).click();
		Thread.sleep(sleepBase * 5000);

		driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定
		Thread.sleep(6000);
		String articleState2 = driver
				.findElement(By.xpath("//div[@class='table-scroll article-table ng-scope']/table/tbody/tr[1]/td[7]"))
				.getText(); // 获取当前文章状态
		if (articleState2.equals("停用")) {
			System.out.println(title + "停用成功");
		} else {
			System.out.println("title:" + title + "，当前状态为：" + articleState2 + "，停用失败");
		}

	}

	public static void deleteInformationArticles(String title, WebDriver driver) throws InterruptedException {
		// 进行启用操作
		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[@class='tab-content']/div[1]/div[4]/table/tbody/tr/td[2]/div/"))) // 操作
				.build().perform();

		driver.findElement(By.linkText("删除")).click();
		Thread.sleep(sleepBase * 3000);
		driver.findElement(By.xpath("//div[@class='dialog-button']/button[@class='btn btn-primary']")).click(); // 确定
		Thread.sleep(6000);

		try {
			boolean displayedState = driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span"))
					.isDisplayed(); // 暂无数据
			if (displayedState == true) {
				System.out.println(driver.findElement(By.xpath("//div[@class='tip-section ng-scope']/span")).getText()); // 暂无数据
				System.out.println("删除文章成功");
			} else {
				String getResultTitle = driver.findElement(By.xpath("//td[@class='first']/span")).getText();
				if (getResultTitle.equals(title)) {
					System.out.println("删除文章不成功，记录依然存在");
				} else {
					System.out.println("删除文章不成功，getResultTitle：" + getResultTitle + "，title：" + title + "结果不一致");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void queryChannelSchedulingManagement(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[2]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-渠道排期
		Thread.sleep(2000);
		driver.findElement(By.name("cinema")).click(); // 选择影院名称
		String cinemaName = driver.findElement(By.xpath("//div[@name='formSchedule']/div[1]/div/div/ul/li[1]/a"))
				.getText();
		System.out.println("cinemaName:" + cinemaName);
		driver.findElement(By.linkText(cinemaName)).click(); // 选择下拉列表第一个影院
		driver.findElement(By.name("scheduleChannel")).click(); // 选择渠道
		driver.findElement(By.linkText("ykse-app-android_test渠道测试")).click(); // 选择安卓app渠道
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(5000);
		try {
			WebElement date = driver.findElement(By.xpath("//div[@class='date-section']/span[2]")); // 获取排期日期控件
			if (date.isDisplayed()) {
				System.out.println("获取排期查询结果日期为：" + date.getText() + "，查询成功");
			} else {
				WebElement result = driver.findElement(
						By.xpath("//div[@class='tab-content']/div/div[@class='tip-section ng-scope']/div")); // 暂无数据控件
				if (result.isDisplayed()) {
					if (result.getText() == "暂无数据") {
						System.out.println("获取查询结果：" + result.getText() + "，查询成功");
					} else {
						System.out.println("获取查询结果：" + result.getText());
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void modifyAndQueryDetailsCardManagement(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[3]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-会员卡管理
		Thread.sleep(2000);
		driver.findElement(By.name("cityname")).click(); // 城市
		driver.findElement(By.linkText("广州")).click(); // 广州
		driver.findElement(By.xpath("//input[@placeholder='请选择影院']")).click(); // 选择影院名称
		WebElement cinema = driver.findElement(
				By.xpath("//div[@class='dropdown-menu dropdown-menu-sm dropdown-search ng-scope']/ul/li[2]/a"));
		String cinemaName = cinema.getText();
		driver.findElement(By.linkText(cinemaName)).click(); // 选择影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 点击查询
		Thread.sleep(4000);

		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//table[@class='table table-hover table-center table-main']/tbody/tr/td[2]/div/a"))).build()
				.perform();
		driver.findElement(By.linkText("编辑")).click();
		Thread.sleep(sleepBase * 5000);

		String valueCardDisclaimer = driver.findElement(By.name("valuecarddecl")).getText(); // 储蓄卡免责声明
		String rightsCardDisclaimer = driver.findElement(By.name("rightscarddecl")).getText(); // 权益卡免责声明
		String timeCardDisclaimer = driver.findElement(By.name("timecarddecl")).getText(); // 次卡免责声明
		String giftCardDisclaimer = driver.findElement(By.name("giftcarddecl")).getText(); // 礼品卡免责声明

		java.util.Random rd = new java.util.Random(); // 随机数
		driver.findElement(By.name("valuecarddecl")).clear();
		String modifyValueCardDisclaimer = "储蓄卡免责声明" + rd.nextInt();
		driver.findElement(By.name("valuecarddecl")).sendKeys(modifyValueCardDisclaimer);
		System.out.println("储蓄卡免责声明:" + modifyValueCardDisclaimer);

		driver.findElement(By.name("rightscarddecl")).clear();
		String modifyRightsCardDisclaimer = "权益卡免责声明" + rd.nextInt();
		driver.findElement(By.name("rightscarddecl")).sendKeys(modifyRightsCardDisclaimer);
		System.out.println("权益卡免责声明:" + modifyRightsCardDisclaimer);

		driver.findElement(By.name("timecarddecl")).clear();
		String modifyTimeCardDisclaimer = "次卡免责声明" + rd.nextInt();
		driver.findElement(By.name("timecarddecl")).sendKeys(modifyTimeCardDisclaimer);
		System.out.println("次卡免责声明:" + modifyTimeCardDisclaimer);

		driver.findElement(By.name("giftcarddecl")).clear();
		String modifyGiftCardDisclaimer = "礼品免责声明" + rd.nextInt();
		driver.findElement(By.name("giftcarddecl")).sendKeys(modifyGiftCardDisclaimer);
		System.out.println("礼品卡免责声明:" + modifyGiftCardDisclaimer);

		driver.findElement(By.xpath("//div[@class='btn-section']/button[1]")).click(); // 保存
		Thread.sleep(5000);

		action.moveToElement(driver.findElement(
				By.xpath("//table[@class='table table-hover table-center table-main']/tbody/tr/td[2]/div/a"))).build()
				.perform();
		driver.findElement(By.linkText("详情")).click();
		Thread.sleep(sleepBase * 5000);

		String getValueCardText = driver.findElement(By.name("valuecarddecl")).getText();
		String getRightsCardText = driver.findElement(By.name("rightscarddecl")).getText();
		String getTimeCardText = driver.findElement(By.name("rightscarddecl")).getText();
		String getGiftCardText = driver.findElement(By.name("giftcarddecl")).getText();
		if ((getValueCardText.equals(modifyValueCardDisclaimer)) && (getValueCardText != valueCardDisclaimer)) {
			System.out.println("储蓄卡免责声明校验通过");
			if ((getRightsCardText.equals(modifyRightsCardDisclaimer)) && (getRightsCardText != rightsCardDisclaimer)) {
				System.out.println("权益卡免责声明校验通过");
				if ((getTimeCardText.equals(modifyTimeCardDisclaimer)) && (getTimeCardText != timeCardDisclaimer)) {
					System.out.println("次卡免责声明校验通过");
					if ((getGiftCardText.equals(modifyGiftCardDisclaimer)) && (getGiftCardText != giftCardDisclaimer)) {
						System.out.println("礼品卡免责声明校验通过");
						System.out.println("修改校验通过");
					} else {
						System.out.println("礼品卡getGiftCardText:" + getGiftCardText + "，modifyGiftCardDisclaimer："
								+ modifyGiftCardDisclaimer + "，giftCardDisclaimer：" + giftCardDisclaimer);
					}
				} else {
					System.out.println("次卡getTimeCardText:" + getTimeCardText + "，modifyTimeCardDisclaimer："
							+ modifyTimeCardDisclaimer + "，timeCardDisclaimer：" + timeCardDisclaimer);
				}
			} else {
				System.out.println("权益卡getRightsCardText:" + getRightsCardText + "，modifyRightsCardDisclaimer："
						+ modifyRightsCardDisclaimer + "，rightsCardDisclaimer：" + rightsCardDisclaimer);
			}
		} else {
			System.out.println("储蓄卡getValueCardText:" + getValueCardText + "，modifyValueCardDisclaimer："
					+ modifyValueCardDisclaimer + "，valueCardDisclaimer：" + valueCardDisclaimer);
		}
	}

	public static void channelJurisdiction_set(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[6]/a/span")).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[3]/div"))).build()
				.perform();
		driver.findElement(By.linkText("设置权限")).click();

		driver.findElement(By
				.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/div/div/form/div[11]/div[6]/div/div/div[1]/label/span"))
				.click();
		driver.findElement(By
				.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/div/div/form/div[11]/div[6]/div/div/div[2]/label/span"))
				.click();

		Select select = new Select(driver.findElement(By.xpath(
				"//div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/div/div/form/div[11]/div[8]/div/div/div/ul")));
		select.selectByIndex(2);

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div[2]/div/div/form/div[12]/button[1]"))
				.click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelJurisdiction_batchSet(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[6]/a/span")).click();

		driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[4]/table/tbody/tr[1]/td[1]/label/div"))
				.click();
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[4]/div[1]/button")).click();

		driver.findElement(By.xpath("//div[2]/div[2]/form/div/div[3]/div[1]/button[1]")).click();
		Thread.sleep(2000);
	}

	public static void channelUser_select(String channelName, String userName, String startTime, String endTime,
			WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();

		if (channelName != null) {
			Select select_channelName = new Select(driver.findElement(
					By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[1]/div/div[1]/ul")));
			select_channelName.selectByVisibleText(channelName);
		}

		if (userName != null) {
			Select select_channelType = new Select(driver
					.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div[1]/div/div/div[1]/form/div[2]/div/ul")));
			select_channelType.selectByVisibleText(userName);
		}

		if (startTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"caVTimeS\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/form/div[3]/input[1]"))
					.sendKeys(startTime);
		}

		if (endTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"caVTimeE\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/form/div[3]/input[2]"))
					.sendKeys(endTime);
		}

		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[3]/div/form/div[5]/button"))
				.click();
	}

	public static void channelUser_create(String code, String userName, String money, WebDriver driver)
			throws InterruptedException, SQLException {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);

		// 删除数据库
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/ec?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");
		Statement stmt;
		stmt = con.createStatement();

		String selectSql_delete = "delete from ec.ec_settle_account where name = \"" + userName + "\"; ";
		long deleteRes_delete = stmt.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		System.out.println("SQL1_DELETE:" + deleteRes_delete);

		// 开始测试
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/div[1]/button"))
				.click();

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[1]/div/input"))
				.sendKeys(userName);

		Select select_channelType = new Select(driver.findElement(By.xpath(
				"//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[2]/div/div/div/ul")));
		select_channelType.selectByVisibleText("1234");

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[4]/div/input"))
				.sendKeys(code);

		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[5]/div/input"))
				.sendKeys(money);

		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[7]/div/ul/li/label/span"))
				.click();

		JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
		removeAttributeS
				.executeScript("document.getElementsByName(\"CAnewTimeStart\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[12]/div/input[1]"))
				.sendKeys(time);

		JavascriptExecutor removeAttributeE = (JavascriptExecutor) driver;
		removeAttributeE
				.executeScript("document.getElementsByName(\"CAnewTimeEnd\")[0].removeAttribute(\"readonly\");");
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[1]/div[12]/div/input[2]"))
				.sendKeys(time);

		driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[2]/button[1]"))
				.click();
		Thread.sleep(3000);
	}

	public static void channelUser_edit(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/table/tbody/tr[1]/td[2]/div")))
				.build().perform();
		driver.findElement(By.linkText("编辑")).click();
		driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div[2]/div/div/div[3]/form/div[2]/button[1]")).click();
		Thread.sleep(3000);
	}

	public static void channelUser_recharge(String momey, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/table/tbody/tr[1]/td[2]/div")))
				.build().perform();
		driver.findElement(By.linkText("充值")).click();

		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/form/div/div[1]/div[3]/input")).sendKeys(momey);
		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/form/div/div[2]/button[1]")).click();
		Thread.sleep(3000);
	}

	public static void channelUser_settlement(String momey, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/table/tbody/tr[1]/td[2]/div")))
				.build().perform();
		driver.findElement(By.linkText("结算")).click();

		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/div/form/div[1]/div[3]/input")).sendKeys(momey);
		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/div/form/div[2]/button")).click();
		Thread.sleep(3000);
	}

	public static void channelUser_stop(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/table/tbody/tr[1]/td[2]/div")))
				.build().perform();
		driver.findElement(By.linkText("停用")).click();

		driver.findElement(By.xpath("//div[4]/div[2]/div[1]/div/div[2]/button[2]")).click();
		Thread.sleep(3000);
	}

	public static void channelUser_enable(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[7]/a/span")).click();
		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(
				By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[9]/div/div/table/tbody/tr[1]/td[2]/div")))
				.build().perform();
		driver.findElement(By.linkText("启用")).click();

		Thread.sleep(3000);
	}

	public static void refundPolicy_select(String policy, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[8]/a/span")).click();
		Thread.sleep(3000);

		if (policy != null) {
			driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[1]/input"))
					.sendKeys(policy);
		}
		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[1]/form/div[2]/button")).click();
		Thread.sleep(3000);
	}

	public static void refundPolicy_create(String policyName, String time, String number, String describe,
			WebDriver driver) throws InterruptedException, SQLException {
		// 删除信息
		Connection con = null;
		con = DriverManager.getConnection(
				"jdbc:mysql://172.33.0.190:3306/ec?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true",
				"root", "123456");
		Statement stmt;
		stmt = con.createStatement();

		String selectSql_delete = "delete from ec.refund_policy where name = \"" + policyName + "\"; ";
		long deleteRes_delete = stmt.executeUpdate(selectSql_delete); // 如果为0则没有进行删除操作，如果大于0，则记录删除的条数
		System.out.println("SQL1_DELETE:" + deleteRes_delete);

		// 开始测试
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[8]/a/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div/div[4]/div[1]/div[2]/button")).click();

		driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[1]/div/input"))
				.sendKeys(policyName);

		Select select_type = new Select(driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[2]/div/div/ul")));
		select_type.selectByIndex(1);

		driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[4]/div/input"))
				.sendKeys(time);

		driver.findElement(
				By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[10]/div/input"))
				.sendKeys(number);

		if (describe != null) {
			driver.findElement(By
					.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[1]/div[12]/div/div/textarea"))
					.sendKeys(describe);
		}

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div[1]/div/div[2]/div/div/form/div[2]/button[1]"))
				.click();
		Thread.sleep(3000);
	}

	public static void member(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[1]/div/ul/li[7]")).click();

		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li/a/span")).click();
		Thread.sleep(3000);
	}

	public static void Report(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[1]/div/ul/li[8]")).click();
		Thread.sleep(3000);
	}

	public static void goodSaleDetailedReport(String cinemaName, String channelName, String startTime, String endTime,
			WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[3]/a/span")).click();
		Thread.sleep(3000);

		if (cinemaName != null) {
			Select select_cinemaName = new Select(driver.findElement(By.xpath(
					"//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[1]/div/div/ul")));
			select_cinemaName.selectByVisibleText(cinemaName);
		}
		if (channelName != null) {
			Select select_channelName = new Select(driver.findElement(By.xpath(
					"//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[2]/div/div/ul")));
			select_channelName.selectByVisibleText(channelName);
		}
		if (startTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"beginDate\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[3]/input[1]"))
					.sendKeys(startTime);
		}
		if (endTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS.executeScript("document.getElementsByName(\"endDate\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[3]/input[2]"))
					.sendKeys(endTime);
		}

		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[5]/button"))
				.click();
		Thread.sleep(3000);
	}

	public static void goodSaleReport(String channelName, String startTime, String endTime, WebDriver driver)
			throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[3]/a/span")).click();
		Thread.sleep(3000);

		if (channelName != null) {
			Select select_channelName = new Select(driver.findElement(By.xpath(
					"//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[1]/div/div/ul")));
			select_channelName.selectByVisibleText(channelName);
		}
		if (startTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS
					.executeScript("document.getElementsByName(\"beginDate\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[2]/input[1]"))
					.sendKeys(startTime);
		}
		if (endTime != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS.executeScript("document.getElementsByName(\"endDate\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(By
					.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[2]/input[2]"))
					.sendKeys(endTime);
		}

		driver.findElement(By
				.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/div/div[1]/form/div/div[1]/div[2]/div[1]/div[4]/button"))
				.click();
		Thread.sleep(3000);
	}

	public static void statistics(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[1]/div/ul/li[9]")).click();
		Thread.sleep(3000);
	}

	public static void statistics_ticket(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div/div[2]/div[1]/div/div/div/ul/li[1]/a/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div/div[2]/div[3]/div/div/div/div/div/form/div[4]/button[1]")).click();
		Thread.sleep(3000);
	}

	public static void statistics_consumer(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[2]/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div[1]/div/div/form/div[3]/button")).click();
		Thread.sleep(3000);
	}

	public static void statistics_good(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[3]/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div[1]/div/div/form/div[3]/button")).click();
		Thread.sleep(3000);
	}

	public static void statistics_film(String date, String cinema, WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div/div/ul/li[4]/a")).click();
		Thread.sleep(3000);

		if (date != null) {
			JavascriptExecutor removeAttributeS = (JavascriptExecutor) driver;
			removeAttributeS.executeScript("document.getElementsByName(\"booksd\")[0].removeAttribute(\"readonly\");");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/form/div[1]/div/input"))
					.sendKeys(date);
		}
		if (cinema != null) {
			Select select_cinema = new Select(driver.findElement(
					By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div/div/div/form/div[2]/div/div/div/ul")));
			select_cinema.selectByVisibleText(cinema);
		}
		driver.findElement(By.xpath("//div[1]/div[2]/div[3]/div/div/div/div/div/form/div[3]/button")).click();
		Thread.sleep(3000);
	}

	public static void SellGoodSalesManagement_onSaleAndHaltTheSale(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[4]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-卖品销售管理
		Thread.sleep(2000);
		driver.findElement(By.name("cinemaname")).click(); // 影院名称
		driver.findElement(By.linkText("全部")).click(); // 全部影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(4000);

		try {
			List<WebElement> tr = driver.findElements(By.xpath(
					"//table[@class='table table-hover table-main check-list table-center table-margin']/tbody/tr"));
			System.out.println("tr.size():" + tr.size());
			String goodID = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span")).getText(); // 获取卖品ID
			String channel = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
			String beforeButtonState = tr.get(0).findElement(By.xpath("//td[3]/a")).getText(); // 按钮状态
			System.out.println("卖品：" + goodID + "在渠道：" + channel + "上，按钮的初始状态为：" + beforeButtonState);
			String state1 = null;
			String state2 = null;
			if (beforeButtonState.equals("停售")) {
				state1 = "停售";
				state2 = "开售";
			} else if (beforeButtonState.equals("开售")) {
				state1 = "开售";
				state2 = "停售";
			}

			if (beforeButtonState.equals(state1)) {
				tr.get(0).findElement(By.xpath("//td[3]/a")).click(); // 点击开售/停售
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']")).click(); // 确定
				Thread.sleep(6000);

				String modifygoodID1 = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span")).getText(); // 获取卖品ID
				String modifychannel1 = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
				String modifyButtonState1 = tr.get(0).findElement(By.xpath("//td[3]/a")).getText(); // 按钮状态
				String modifyState1 = tr.get(0).findElement(By.xpath("//td[10]/span")).getText(); // 表格中当前状态

				if (modifygoodID1.equals(goodID) && modifychannel1.equals(channel)) {
					System.out.println("卖品：" + modifygoodID1 + "在渠道：" + modifychannel1 + "在'" + state1 + "'"
							+ "后的当前状态为：" + modifyState1 + "，当前按钮状态：" + modifyButtonState1 + "，第一步校验成功");
					if (modifyButtonState1.equals(state2)) {
						tr.get(0).findElement(By.xpath("//td[3]/a")).click(); // 点击开售/停售
						Thread.sleep(2000);
						driver.findElement(By.xpath("//div[@class='btn-section']/button[@class='btn btn-primary']"))
								.click(); // 确定
						Thread.sleep(6000);

						String modifygoodID2 = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span"))
								.getText(); // 获取卖品ID
						String modifychannel2 = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
						String modifyButtonState2 = tr.get(0).findElement(By.xpath("//td[3]/a")).getText(); // 按钮状态
						String modifyState2 = tr.get(0).findElement(By.xpath("//td[10]/span")).getText(); // 表格中当前状态

						if (modifygoodID2.equals(modifygoodID1) && modifychannel2.equals(modifychannel1)
								&& modifyState2.equals(modifyButtonState1)) {
							System.out.println("卖品：" + modifygoodID2 + "在渠道：" + modifychannel2 + "在'" + state2 + "'"
									+ "后的当前状态为：" + modifyState2 + "，当前按钮状态：" + modifyButtonState2 + "，第二步校验成功");

						}
					}
				} else {
					System.out.println("校验失败，需进一步检查");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void SellGoodSalesManagement_banthOnSaleAndBanthHaltTheSale(WebDriver driver)
			throws InterruptedException {
		String rootDirectoryName = "商品";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[4]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入商品-卖品销售管理
		Thread.sleep(2000);
		driver.findElement(By.name("cinemaname")).click(); // 影院名称
		driver.findElement(By.linkText("全部")).click(); // 全部影院
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // 查询
		Thread.sleep(4000);

		try {
			List<WebElement> tr = driver.findElements(By.xpath(
					"//table[@class='table table-hover table-main check-list table-center table-margin']/tbody/tr"));
			System.out.println("tr.size():" + tr.size());
			String goodID = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span")).getText(); // 获取卖品ID
			String channel = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
			String beforeState = tr.get(0).findElement(By.xpath("//td[10]/span")).getText(); // 初始状态
			System.out.println("卖品：" + goodID + "在渠道：" + channel + "上，初始状态为：" + beforeState);
			String state1 = null;
			String state2 = null;
			String batchOperation1 = null;
			String batchOperation2 = null;
			int i1 = 0;
			int i2 = 0;
			if (beforeState.equals("停售")) {
				state1 = "停售";
				i1 = 1;
				i2 = 2;
				batchOperation1 = "批量开售";
				state2 = "开售";
				batchOperation2 = "批量停售";
			} else if (beforeState.equals("开售")) {
				state1 = "开售";
				i1 = 2;
				i2 = 1;
				batchOperation1 = "批量停售";
				state2 = "停售";
				batchOperation2 = "批量开售";
			}

			if (beforeState.equals(state1)) {
				driver.findElement(By
						.xpath("//th[@class='check-section']/div[@class='fix-header']/label[@class='checkbox']/input"))
						.click(); // 全选
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='top-text']/button[" + i1 + "]")).click(); // 点击批量开售/停售
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@class='dialog-footer']/button[1]")).click(); // 确定
				Thread.sleep(5000);

				String modifygoodID1 = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span")).getText(); // 获取卖品ID
				String modifychannel1 = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
				String modifyState1 = tr.get(0).findElement(By.xpath("//td[10]/span")).getText(); // 表格中当前状态

				if (modifygoodID1.equals(goodID) && modifychannel1.equals(channel)) {
					System.out.println("卖品：" + modifygoodID1 + "在渠道：" + modifychannel1 + "在'" + batchOperation1 + "'"
							+ "后的当前状态为：" + modifyState1 + "，第一步校验成功");
					if (modifyState1.equals(state2)) {
						driver.findElement(By.xpath("//div[@class='top-text']/button[" + i2 + "]")).click(); // 点击批量开售/停售
						Thread.sleep(3000);
						driver.findElement(By.xpath("//div[@class='dialog-footer']/button[1]")).click(); // 确定
						Thread.sleep(5000);

						String modifygoodID2 = tr.get(0).findElement(By.xpath("//td[@class='text-left']/span"))
								.getText(); // 获取卖品ID
						String modifychannel2 = tr.get(0).findElement(By.xpath("//td[7]")).getText(); // 渠道
						String modifyState2 = tr.get(0).findElement(By.xpath("//td[10]/span")).getText(); // 表格中当前状态

						if (modifygoodID2.equals(modifygoodID1) && modifychannel2.equals(modifychannel1)
								&& modifyState2.equals(state1)) {
							System.out.println("卖品：" + modifygoodID2 + "在渠道：" + modifychannel2 + "在'" + batchOperation2
									+ "'" + "后的当前状态为：" + modifyState2 + "，第二步校验成功");

						}
					}
				} else {
					System.out.println("校验失败，需进一步检查");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
/*
	public static void modifyBannerSetting(WebDriver driver) throws InterruptedException {
		String rootDirectoryName = "基础设置";
		String SubDirectoryPath = "//ul[@class='nav-main']/li[9]/a/span";
		EnterTheFirstLevelSubDirectory(rootDirectoryName, SubDirectoryPath, driver); // 进入基础设置-内容编辑
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav-main']/li[9]/ul/li[1]/a/span")).click(); // banner设置
		Thread.sleep(5000);

		// 悬停
		Actions action = new Actions(driver);
		action.moveToElement(
				driver.findElement(By.xpath("//div[@class='tab-content']/div[1]/div[5]/table/tbody/tr/td[2]/div/"))) // 操作
				.build().perform();
		
		driver.findElement(By.linkText("编辑")).click();  //编辑
		Thread.sleep(3000);
		//String nowBannerName=driver.findElement(By.name("bannerName")).getText(); //获取当前名称
		List<WebElement> citys=driver.findElements(By.xpath("//div[@class='city-tags']/div"));  //获取已选取的城市
		int size=citys.size();
		System.out.println("citys.size():"+size);
		String[] cityName = new String[size];  
		for(int i=0;i<size;i++){
			cityName[i]=citys.get(i).findElement(By.xpath("//span[1]")).getText(); //获取城市名
			citys.get(i).findElement(By.xpath("//span[2]")).click(); //点击关闭
		}
		driver.findElement(By.id("110100")).click(); //选北京
		for(int i=0;i<size;i++){
		if(cityName[i]!="北京"){
			System.out.println("城市修改完成");
			break;
		}else{
			System.out.println("cityName["+i+"]:"+cityName[i]);
		}
		driver.findElement(By.xpath("//div[@class='btn-section']/button[@type='submit']")).click(); //保存
		String popupText=driver.findElement(By.xpath("//div[@class='dialog-alert-wrapper']/span")).getText();
		if (popupText.equals("保存成功")){
			System.out.println("修改成功");
		}else{
			System.out.println("popupText:"+popupText);
		}
	}
	} */
	
	
}
