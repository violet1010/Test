package ykse.TestAutomation.Web.Finixx.Common;

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
	static Logger logger = new Log("web_Finixx").logger;
	public static int sleepBase = 1000;

	public static Boolean start_and_login(WebDriver driver,String Url) {
		logger.info("加载首页页面");
		String baseUrl = Url;

		// 登录 login
		driver.get(baseUrl);
		logger.info("输入账号密码");
		WebFunHelper.sendKeysById("text_login_loginId", "loginId", driver);
		WebFunHelper.sendKeysById("text_login_password", "passWord", driver);
		logger.info("点击登陆");
		WebFunHelper.clickClassName("class_Submit_login", driver);
		//WebFunHelper.clickById("SureButton", driver);
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_MenuBtnImg")));
		WebElement Pass = null;
		try {
			Pass = driver.findElement(By.className("ykf2_MenuBtnImg"));
		} catch (Exception e) {
			logger.error("没有找到此信息");
		}
		if (Pass == null) {
			return false;
		}
		
		return true;
	}
	
	public static boolean UserManager_add(WebDriver driver){

		logger.info("点击新建");
		WebFunHelper.switchFrame("xpath_frame_userIndex",driver);
		//WebFunHelper.clickByXpath("xpath_add", driver);
		WebFunHelper.clickById("text_add", driver);
		WebFunHelper.sendKeysById("text_user_id", "userId", driver);
		WebFunHelper.sendKeysById("text_user_userLname", "userLname", driver);
		WebFunHelper.sendKeysById("text_user_userFname", "userFname", driver);
		WebFunHelper.sendKeysById("text_user_userPassword", "userPassword", driver);
		WebFunHelper.sendKeysById("text_user_userPasswordConfirm", "userPasswordConfirm", driver);
		logger.info("点击保存");
		WebFunHelper.clickByXpath("xpath_frame_userAdd_save", driver);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_FloatTitle")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("添加成功", driver);
		WebFunHelper.clickById("SureButton", driver);
		return returnBl;
		
	}
	
	public static boolean UserManager_search(WebDriver driver){
		logger.info("输入账号");
		WebFunHelper.sendKeysByXpath("xpath_search_user", "userId", driver);
		logger.info("输入姓氏");
		WebFunHelper.sendKeysByXpath("xpath_search_lastname", "userLname", driver);
		logger.info("点击查询");
		WebFunHelper.clickByXpath("xpath_search", driver);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_LinkEdit")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("修改", driver);
		return returnBl;
	}
	public static boolean User_import(String fileName, WebDriver driver) throws InterruptedException {

		logger.info("点击导入");
		WebFunHelper.clickById("file_uploadUploader", driver);
		WebFunHelper.importFile(fileName);
		Thread.sleep(5*sleepBase);
		logger.info("判断是否显示结果");
		boolean returnBl = WebFunHelper.isTextPresent("结果提示框", driver);
		WebFunHelper.clickById("SureButton", driver);
		
		return returnBl;
	}
	public static boolean UserManager_change(WebDriver driver){

		logger.info("点击修改按钮");
		WebFunHelper.clickByLinkText("a_user_passcard", driver);
		logger.info("选择卡类型");
		WebFunHelper.sendKeysByselect("select_passcard_type", "usercardtype", driver);
		logger.info("选择端口号");
		WebFunHelper.sendKeysByselect("select_passcard_port", "usercardport", driver);
		logger.info("点击读卡");
		WebFunHelper.clickByXpath("button_user_passcard_read", driver);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_FloatCon")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("修改成功", driver);
		WebFunHelper.clickById("SureButton", driver);
		return returnBl;
		
	}
	
	public static boolean UserManager_PassWord_Change(WebDriver driver){
		logger.info("点击修改密码");
		WebFunHelper.clickByLinkText("text_user_password_change", driver);
		logger.info("输入新密码");
		WebFunHelper.sendKeysById("text_user_userPassword_new", "userPassword_new", driver);
		logger.info("输入确认密码");
		WebFunHelper.sendKeysById("text_user_userPasswordConfirm", "userPasswordConfirm_new", driver);
		logger.info("点击保存");
		WebFunHelper.clickByXpath("xpath_frame_userAdd_save", driver);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_FloatCon")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("操作成功", driver);
		WebFunHelper.clickById("SureButton", driver);
		return returnBl;
	}
	
	public static boolean UserManager_PassCard(WebDriver driver){
		logger.info("点击绑定员工卡");
		WebFunHelper.clickByLinkText("text_user_password_change", driver);
		logger.info("输入新密码");
		WebFunHelper.sendKeysById("text_user_userPassword_new", "userPassword_new", driver);
		logger.info("输入确认密码");
		WebFunHelper.sendKeysById("text_user_userPasswordConfirm", "userPasswordConfirm_new", driver);
		logger.info("点击保存");
		WebFunHelper.clickByXpath("xpath_frame_userAdd_save", driver);
		new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.className("ykf2_FloatCon")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("操作成功", driver);
		WebFunHelper.clickById("SureButton", driver);
		return returnBl;
	}
	public static boolean UserManager_GrantLog(WebDriver driver){
		logger.info("点击授权日志");
		WebFunHelper.clickByLinkText("a_user_grantlog", driver);
		driver.switchTo().defaultContent(); 
		WebElement Pass = null;
		try{
			WebFunHelper.switchFrame("xpath_frame_systemlog", driver);
		Pass = driver.findElement(By.className("ykf2_FloatTitle"));
		}
		catch (Exception e)
		{
			logger.info("没有弹出框");
		}
		if(Pass != null){
			WebFunHelper.clickById("SureButton", driver);
		}
		//new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("xpath_button_search")));
		WebFunHelper.PrintScreen(driver);
		boolean returnBl = WebFunHelper.isTextPresent("参数设置 > 系统日志 > 授权日志", driver);
		
		return returnBl;
		
	}
	
	
}
