package ykse.TestAutomation.App.Android.Common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import ykse.TestAutomation.App.Android.Common.*;
import ykse.TestAutomation.Common.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AndroidFunHelper {
	private static AppiumDriver<WebElement> dr;
	private static int sleepBase = 1;
	static Logger logger = new Log("app_android").logger;
	
	public static Boolean isElementDisplay(String Elementkey,AppiumDriver<WebElement> driver)
	{
		Boolean isSuccess = false;
		String ElementValue = UItree.FindValueInUItree(Elementkey);
		try {
			if (driver.findElementById(ElementValue) != null) {
				logger.debug("元素"+ElementValue+"存在");
				
				isSuccess = true;
				
			}
		} catch (Exception em) {
			logger.debug("元素"+ElementValue+"不存在");
			return isSuccess;
		}
		return isSuccess;
		
		
	}
	
	public static void clickElementById(String key, AppiumDriver<WebElement> driver) throws NoSuchElementException, MalformedURLException, InterruptedException
	{
		String value = UItree.FindValueInUItree(key);
		try {
			AndroidFunHelper.PrintScreen(driver);
			logger.debug("点击"+key+"的对应元素:"+value);
			Point Rect = driver.findElementById(value).getLocation();
			new TouchAction(driver).press(Rect.x, Rect.y).release().perform();
		//driver.findElementById(value).click();
		
		
		}
	
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			AndroidFunHelper.PrintScreen(driver);
			if(key!="button_header_back"){
				
			logger.warn("点击"+key+"对应的"+value+"失败");
			}
			
			throw e;
		}
	}
	public static void sendKeysById(String key, String content,AppiumDriver<WebElement> driver) throws MalformedURLException, InterruptedException
	{
		String value = UItree.FindValueInUItree(key);
		try {
			String note = UItree.FindNoteInUItree(key);
			
			AndroidFunHelper.PrintScreen(driver);
			logger.debug("在"+note+"的对应元素:"+value+"中输入"+content);
		driver.findElementById(value).sendKeys(content);
		
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidFunHelper.PrintScreen(driver);
			logger.error("在"+key+"对应的"+value+"中输入失败");
			logger.error(e.getMessage());
		}
		
	}
	
	
	
	public static void findElementAndClick(String key, String name, AppiumDriver<WebElement> driver)
	{
		
		try {

			String value = UItree.FindValueInUItree(key);
			
			List<WebElement> cities = driver.findElementsById(value);
			for (int i = 0; i < cities.size(); i++) {
				String city = cities.get(i).getText();
				if (city.contains(name)) {
					AndroidFunHelper.PrintScreen(driver);
					logger.debug("点击"+key+"的对应元素:"+value);
					cities.get(i).click();
				
					
					break;
				}

			}
		
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("点击失败");
			logger.error(e.getMessage());
		}
	}
	
	public static Boolean findElementIsDisplay(String key, String name, AppiumDriver<WebElement> driver) throws MalformedURLException, InterruptedException
	{
		
		try {

			String value = UItree.FindValueInUItree(key);
			
			List<WebElement> cities = driver.findElementsById(value);
			AndroidFunHelper.PrintScreen(driver);
			logger.debug("查找"+key+"的对应元素:"+value+"是否包含"+name);
			for (int i = 0; i < cities.size(); i++) {
				String city = cities.get(i).getText();
				if (city.contains(name)) {					
					AndroidFunHelper.PrintScreen(driver);
					
					break;
				}

			}
		
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("无此元素");		
			
			logger.error(e.getMessage());
			AndroidFunHelper.PrintScreen(driver);
			return false;
		}
		return true;
	}
	

	public static String FindValueInTestSetup(String key) {
		SAXReader sr = new SAXReader();// 获取读取xml的对象。
		try {
			Document doc = sr.read("src/resources/TestSetup.xml");
			Element resRoot = doc.getRootElement();
			for (int i = 0; i < resRoot.elements().size(); i++) {
				if (((Element) resRoot.elements().get(i)).attributeValue("name").equals(key)) {

					return ((Element) resRoot.elements().get(0)).attributeValue("value");
				}
			}
			return null;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block、
			logger.error("查找失败");
			logger.error(e.getMessage());
		}
		return null;
	}

    public static void swipeScreenToRight( int repeat, AppiumDriver<WebElement> driver) throws MalformedURLException, InterruptedException {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            java.util.HashMap<String, Integer> swipeObj = new java.util.HashMap<String, Integer>();
            int width = driver.manage().window().getSize().width;
            int height = driver.manage().window().getSize().height;
            swipeObj.put("startX", width*3/8);
            swipeObj.put("startY", height/2);
            swipeObj.put("endX", width/8);
            swipeObj.put("endY", height/2);
            AndroidFunHelper.PrintScreen(driver);
            logger.debug("向右滑屏"+repeat+"次");
            for (int i = 0; i < repeat; i++) {
                try {
                    js.executeScript("mobile: flick", swipeObj);
                   
                    Thread.sleep(sleepBase *1000);
                } 
                catch (Exception ex) {
                	AndroidFunHelper.PrintScreen(driver);
                	logger.error("滑动屏幕失败");
                    ex.printStackTrace();
                }
            }
        }
    
	public static void scroll(String direction, AppiumDriver<WebElement> driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		java.util.HashMap<String, String> scrollObject = new java.util.HashMap<String, String>();
		scrollObject.put("direction", direction);
		js.executeScript("mobile: scroll", scrollObject);
	}

	public static void ClickByID(String id, String log) throws InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase * 2000);
		System.out.println("Click " + log);
		dr.findElementById(id).click();
		Thread.sleep(sleepBase * 5000);
	
	}

	public static void ClickByIndex(String className, int index, String log)
			throws InterruptedException, MalformedURLException {
		Thread.sleep(sleepBase *2000);
		java.util.List<WebElement> arr = dr.findElementsByClassName(className);
		arr.get(index).click();
		System.out.println("Click " + log);
		Thread.sleep(sleepBase * 5000);
		
	}

	public static void PrintScreen(AppiumDriver<WebElement> driver) throws InterruptedException, MalformedURLException {
		
		System.out.println();

		File file = null;
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String time=format.format(date);
		System.out.println(); // new Date()为获取当前系统时间
		String stepName = FromEndRF.read("target/"+Log.log4jdir+"/output/logs/app_android.log");
		try {
			file = driver.getScreenshotAs(OutputType.FILE);
			String fileName = "target/"+Log.log4jdir+"/output/picShot_app_android/" + stepName +time + ".jpg";
			
			FileUtils.copyFile(file, new File(fileName));
			String fileNameForReport = "output/picShot_app_android/" + stepName +time + ".jpg";
			logger.debug("截图已保存到"+fileNameForReport);
			
		} catch (IOException e) {
			logger.error("截图保存失败");
			e.printStackTrace();
		}
	}
	
	 public static void swipeScreenToBelow( int repeat,AppiumDriver<WebElement> driver) throws MalformedURLException, InterruptedException {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        java.util.HashMap<String, Integer> swipeObj = new java.util.HashMap<String, Integer>();
	        int width = driver.manage().window().getSize().width;
	        int height = driver.manage().window().getSize().height;
	        swipeObj.put("startX", width*1/2);
	        swipeObj.put("startY", height*6/10);
	        swipeObj.put("endX", width*1/2);
	        swipeObj.put("endY", height*5/10);
	        AndroidFunHelper.PrintScreen(driver);
	        logger.debug("向下滑屏"+repeat+"次");
	        for (int i = 0; i < repeat; i++) {
	            try {
	                js.executeScript("mobile: flick", swipeObj);
	               
	                Thread.sleep(sleepBase *1000);
	            } 
	            catch (Exception ex) {
	            	AndroidFunHelper.PrintScreen(driver);
	            	logger.error("滑动屏幕失败");
	                ex.printStackTrace();
	            }
	        }
	    }
	 public static void clickElementByLinkText(String Text, AppiumDriver<WebElement> driver) throws NoSuchElementException{
		 try {
				//String value = UItree.FindValueInUItree(key);
			 logger.debug("点击"+Text+"的对应元素:"+Text);
				driver.findElementByLinkText(Text).click();
				
				
				}
		 catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				if(Text!="button_header_back"){
				logger.error("点击"+Text+"失败");
				logger.error(e.getMessage());}
				
				throw e;
			}
	 }
	public static void findElementIndexAndClick(String key, int num, AppiumDriver<WebElement> driver) 
		// 点击 多个同名的第num个元素
		{
			
			try {
				logger.debug("点击对应"+key+"的第"+num+"个元素");
				String value = UItree.FindValueInUItree(key);
				
				driver.findElementsById(value).get(num).click();
			
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				logger.error("点击失败");
				logger.error(e.getMessage());
			}
		}
	
	public static void clickElementByClassName(String key, AppiumDriver<WebElement> driver) throws NoSuchElementException
	{
		String value = UItree.FindValueInUItree(key);
		try {
			logger.debug("点击"+key+"的对应元素:"+value);
		driver.findElementById(value).click();
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			if(key!="button_header_back"){
			logger.error("点击"+key+"对应的"+value+"失败");
			logger.error(e.getMessage());}
			
			throw e;
		}
	}
	
	public static void clickElementByXpath(String key, AppiumDriver<WebElement> driver) throws NoSuchElementException
	{
		String value = UItree.FindValueInUItree(key);
		try {
			logger.debug("点击"+key+"的对应元素:"+value);
			driver.findElementByXPath(value).click();
			
		}
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			if(key!="button_header_back"){
			logger.error("点击"+key+"对应的"+value+"失败");
			logger.error(e.getMessage());}
			
			throw e;
		}
	}
	
	public static void sendKeysByClassName(String key, String content,AppiumDriver<WebElement> driver) throws MalformedURLException, InterruptedException
	{
		String value = UItree.FindValueInUItree(key);
		try {
			String note = UItree.FindNoteInUItree(key);
			AndroidFunHelper.PrintScreen(driver);
			logger.debug("在"+note+"的对应元素:"+value+"中输入"+content);
		driver.findElementByClassName(value).sendKeys(content);
		
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidFunHelper.PrintScreen(driver);
			logger.error("在"+key+"对应的"+value+"中输入失败");
			logger.error(e.getMessage());
		}
		
	}
}
