package ykse.TestAutomation.Web.Finixx.Common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ykse.TestAutomation.Common.FromEndRF;
import ykse.TestAutomation.Common.Log;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;


public class WebFunHelper {
	static String logName = "web_Finixx";
	static Logger logger = new Log(logName).logger;

	public static  boolean isTextPresent(String name,WebDriver driver) {
		try{
		return driver.findElement(By.tagName("body")).getText().contains(name);// 遍历body节点下的所有节点 取其文本值 并判断是否包含 文本 what
		}
		catch (Exception e){
		return false;// 没有该文本 则 返回 false
		}
		}

	public static boolean isElementExsit(By locator,WebDriver driver) {  
        boolean flag = false;  
        try {  
            WebElement element=driver.findElement(locator);  
            flag=null!=element;  
        } catch (NoSuchElementException e) {  
        	logger.debug("Element:" + locator.toString()  
                    + " is not exsit!");  
        }  
        return flag;  
    }

	public static void sendKeysById(String key, String content, WebDriver driver) {
		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		String contentValue = TestData.FindValueInVariables(content);
		try {

			logger.debug("在" + note + "的对应元素:" + value + "中输入" + content);
			//清除readonly的方法
			String js="document.getElementById('"+value+"').removeAttribute('readOnly');"
					+ "document.getElementById('"+value+"').setAttribute('value','"+content+"');";
			((JavascriptExecutor) driver).executeScript(js);
	
			driver.findElement(By.id(value)).clear();
			driver.findElement(By.id(value)).sendKeys(contentValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			logger.error("在" + key + "对应的" + value + "中输入失败");
			logger.error(e.getMessage());
		} finally {
			 WebFunHelper.PrintScreen(driver);
		}

	}
	public static void sendKeysByClass(String key,String content, WebDriver driver){
		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		String contentValue = TestData.FindValueInVariables(content);
		try {

			logger.debug("在" + note + "的对应元素:" + value + "中输入" + content);
			driver.findElement(By.className(value)).clear();
			driver.findElement(By.className(value)).sendKeys(contentValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			logger.error("在" + key + "对应的" + value + "中输入失败");
			logger.error(e.getMessage());
		} finally {
			 WebFunHelper.PrintScreen(driver);
		}
	}
	
	public static void sendKeysByXpath(String key,String content, WebDriver driver){
		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		String contentValue = TestData.FindValueInVariables(content);
		try {

			logger.debug("在" + note + "的对应元素:" + value + "中输入" + content);
			driver.findElement(By.xpath(value)).clear();
			driver.findElement(By.xpath(value)).sendKeys(contentValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			logger.error("在" + key + "对应的" + value + "中输入失败");
			logger.error(e.getMessage());
		} finally {
			 WebFunHelper.PrintScreen(driver);
		}
	}
	public static void sendKeysByselect(String key,String content, WebDriver driver){
		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		String contentValue = TestData.FindValueInVariables(content);
		try {

			logger.debug("在" + note + "的对应元素:" + value + "中输入" + content);
			driver.findElement(By.id(value)).clear();
			((Select) driver.findElement(By.id(value))).selectByVisibleText(contentValue);
		} catch (Exception e) {

			logger.error("在" + key + "对应的" + value + "中输入失败");
			logger.error(e.getMessage());
		} finally {
			 WebFunHelper.PrintScreen(driver);
		}
	}

	public static void clickById(String key, WebDriver driver) {

		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		try {
			// WebFunHelper.PrintScreen(driver);
			logger.debug("点击" + note + key + "的对应元素:" + value);
			driver.findElement(By.id(value)).click();
	

		}

		catch (Exception e) {
			// TODO Auto-generated catch block

			// AndroidFunHelper.PrintScreen(driver);
			if (key != "button_header_back") {

				logger.error("点击" + note + key + "对应的" + value + "失败");
			}

		} finally {
			WebFunHelper.PrintScreen(driver);
		}
	}

	public static void clickByLinkText(String key, WebDriver driver) {

		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		try {
			// WebFunHelper.PrintScreen(driver);
			logger.debug("点击" + note + key + "的对应元素:" + value);
			driver.findElement(By.linkText(value)).click();

		}

		catch (Exception e) {
			// TODO Auto-generated catch block

			// AndroidFunHelper.PrintScreen(driver);
			if (key != "button_header_back") {

				logger.error("点击" + note + key + "对应的" + value + "失败");
			}

		} finally {
			WebFunHelper.PrintScreen(driver);
		}
	}
	public static void clickByXpath(String key, WebDriver driver) {

		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		try {
			// WebFunHelper.PrintScreen(driver);
			logger.debug("点击" + note + key + "对应的Xpath: " + value);
			driver.findElement(By.xpath(value)).click();

		}

		catch (Exception e) {
			// TODO Auto-generated catch block

			// AndroidFunHelper.PrintScreen(driver);
			e.printStackTrace();
			if (key != "button_header_back") {

				logger.error("点击" + note + key + "对应的Xpath: " + value + "失败");
			}

		} finally {
			WebFunHelper.PrintScreen(driver);
		}
	}
	
	public static void clickClassName(String key, WebDriver driver) {

		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		try {
			// WebFunHelper.PrintScreen(driver);
			logger.debug("点击" + note + key + "对应的类:" + value);
			
			driver.findElement(By.className(value)).click();

		}

		catch (Exception e) {
			// TODO Auto-generated catch block

			// AndroidFunHelper.PrintScreen(driver);

				logger.error("点击" + note + key + "对应的" + value + "失败");
			

		} finally {
			WebFunHelper.PrintScreen(driver);
		}
	}
	
	public static void switchFrame(String key, WebDriver driver) {

		String value = UItree.FindValueInUItree(key);
		String note = UItree.FindNoteInUItree(key);
		try {
			// WebFunHelper.PrintScreen(driver);
			logger.debug("切换到" + note + key + "对应的frame:" + value);
			
			driver.switchTo().frame(driver.findElement(By.xpath(value)));
		}

		catch (Exception e) {
			// TODO Auto-generated catch block

			// AndroidFunHelper.PrintScreen(driver);
			if (key != "button_header_back") {

				logger.error("切换到" + note + key + "对应的frame:" + value + "失败");
			}

		} finally {
			WebFunHelper.PrintScreen(driver);
		}
	}


	public static void PrintScreen(WebDriver driver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(date);
		String stepName = FromEndRF.read("target/"+Log.log4jdir+"/output/logs/"+logName+".log");
		try {
			String fileName = "target/"+Log.log4jdir+"/output/picShot_web_Finixx/" + stepName + time + ".jpg";
			FileUtils.copyFile(scrFile, new File(fileName));
			String fileNameForReport = "output/picShot_web_mc/" + stepName + time + ".jpg";
			logger.debug("截图已保存到" + fileNameForReport);

		} catch (IOException e) {
			logger.error("截图保存失败");

			e.printStackTrace();
		}
	}

	public static boolean importFile(String fileName) throws InterruptedException {
		// TODO Auto-generated method stub
		boolean res = true;
		logger.debug("导入文件"+fileName);
		try {
			Process p =  Runtime.getRuntime().exec("src\\main\\java\\ykse\\TestAutomation\\Common\\import.exe "+fileName);
			p.waitFor();
		} catch (IOException e) {
			res=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return  res;
		
	}
	

}
