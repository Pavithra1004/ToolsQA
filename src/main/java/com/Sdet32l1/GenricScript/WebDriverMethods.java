package com.Sdet32l1.GenricScript;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all the webdriver common actions
 * @author anand
 *
 */
public class WebDriverMethods {
	
	static WebDriverWait wait;
	static Actions act;
	static Select select;
	static JavascriptExecutor js;
	/**
	 * This method is used to navigate to applicator
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url,WebDriver driver)
	{
		driver.get(url);
	}
	/**
	 * This method is used for browser setting
	 * @param longTimeOut
	 * @param driver
	 */
	public static void browserSetting(long longTimeOut,WebDriver driver)
	{
		driver.manage().window().maximize();
		waitTillPageLoad(longTimeOut,driver);
	}
	/**
	 * This method is used to implicitly wait until page load
	 * @param longTimeOut
	 * @param seconds
	 */
	public static void waitTillPageLoad(long longTimeOut, WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);

	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();

	}
	/**
	 * This method is used to mouse over on the element
	 * @param driver
	 * @param moreLink
	 */
	public static void mouseOverOnTheElement(WebDriver driver,WebElement moreLink) {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
	}
	/**
	 * This method is used for closde the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.close();
	}
	/**
	 * This method is used to wait the control till the particular element is visible
	 * @param element
	 */
	public static void waitUntillElememtVisible(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to wait the control till the particular element is clickable
	 * @param element
	 */
	public static void waitUntillElememtClickable(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used for initialize the wait instance
	 * @param driver
	 * @param timeOut
	 */
	public static void explicitlyWait(WebDriver driver,long timeOut)
	{
		wait=new WebDriverWait(driver, timeOut);
	}
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowOnTitle(WebDriver driver,String partialText)
	{
		Set<String> window = driver.getWindowHandles();
		for(String Id:window)
		{
			driver.switchTo().window(Id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to initialize the select class
	 * @param ele
	 */
	public static void initializeSelect(WebElement ele)
	{
		select = new Select(ele);

	}
	/**
	 * This method is used to select by visible text
	 * @param ele
	 * @param VisibleText
	 */
	public static void dropDownByVisibleText(String VisibleText)
	{
		select.selectByVisibleText(VisibleText);
	}
	/**
	 * This method is used to select by Index
	 * @param ele
	 * @param index
	 */
	public static void dropDownByIndex(int index)
	{
		select.selectByIndex(index);
	}
	/**
	 * This method is used to select by Value
	 * @param ele
	 * @param value
	 */
	public static void dropdownByValue(String value)
	{
		select.selectByValue(value);
	}
	/**
	 * double click 
	 * @param driver
	 */
	//	public static void doubleClick(WebDriver driver)
	//	{
	//		 act=new Actions(driver);
	//		act.doubleClick();
	//	}
	/**
	 * This method is used to double click on element
	 * @param driver
	 * @param ele
	 */
	public static void doubleClick(WebDriver driver,WebElement ele)
	{
		act.doubleClick(ele).perform();
	}
	/**
	 * This method is used to right click on element
	 * @param ele
	 * @param driver
	 */
	public static void rightClick(WebElement ele,WebDriver driver)
	{
		act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * This method is used to mouseover on element
	 * @param ele
	 * @param driver
	 */
	public static void mouseOver(WebElement ele,WebDriver driver)
	{
		act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method is used to drag and drop the element
	 * @param ele
	 * @param driver
	 */
	public static void dragAndDrop(WebElement ele,WebDriver driver)
	{
		act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	/**
	 * This method is used to switch the frame by using index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame by using webElement
	 * @param driver
	 * @param nameorId
	 */
	public static void switchToFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	/**
	 * This method is used to switch the frame by using name or Id
	 * @param driver
	 * @param nameorId
	 */
	public static void switchToFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	/**
	 * This is used to switch back to home frame
	 * @param driver
	 */
	public static void switchBackHome(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public static  void initializeJs(WebDriver driver)
	{
		 js=(JavascriptExecutor)driver;		
	}
	
	public static void clickThroughJs(WebDriver driver,WebElement ele,String data)
	{
		js.executeScript("arguements[0].value=arguements[1]", ele,data);
	}
	public static void clickThroughJs(WebElement ele)
	{
		js.executeScript("arguements[0].click()", ele);
	}
	public static void navigateAppThroughJs(String url)
	{
		js.executeScript("window.location=arguements[0]", url);
	
	}
	public static void scrollToSpecifiedHeight(String Height)
	{
		js.executeScript("window.scrollBy(0,"+Height+")");
	}
	public static void scrollToBottom()
	{
		js.executeScript("window.scrollBy(0.document.body.scrollHeight)");
	}
	public static void scrollTillElement(WebElement ele)
	{
		js.executeScript("arguement[0].scrollIntoView()", ele);
	}
	
	public static void takesScreenShot(WebDriver driver,String fileName) throws IOException
	{
		JavaMethods jm=new JavaMethods();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File("./Screenshot/"+fileName+"_"+jm.dateTimeInFormat()+".png");
		System.out.println(dst.getAbsolutePath());
		FileUtils.copyFile(src, dst);	
			
	}
	public static void allertaccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void allertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void allertSendData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	public static void getAlertText(WebDriver driver,String data)
	{
		driver.switchTo().alert().getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}