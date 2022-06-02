package com.ToolsQA.Elements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Sdet32l1.GenricScript.ExcelMethods;
import com.Sdet32l1.GenricScript.FileMethods;
import com.Sdet32l1.GenricScript.IConstantsPath;
import com.Sdet32l1.GenricScript.JavaMethods;
import com.Sdet32l1.GenricScript.WebDriverMethods;
import com.ToolsQA.ObjectRepository.ToolsQAPage;
import io.github.bonigarcia.wdm.WebDriverManager;

//CreateElementsTest

public class CreateElementsTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		JavaMethods jm=new JavaMethods();
		FileMethods.openPropertyFile(IConstantsPath.PROPERTYFILEPATH);
		ExcelMethods.openExcel(IConstantsPath.EXCELPATH);
		String url=FileMethods.getDataFromPropertyFile("url");
//		String un=FileMethods.getDataFromPropertyFile("un");
//		String pwd=FileMethods.getDataFromPropertyFile("pwd");
		String browser=FileMethods.getDataFromPropertyFile("browser");
		String timeout=FileMethods.getDataFromPropertyFile("timeout");

		long longTimeOut=jm.stringToLong(timeout);
		int randnumber=jm.getRandomNumber(1000);
		
		WebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		default: {
			System.out.println("please specify the browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		break;
		}
		
		WebDriverMethods.navigateApp(url, driver);
		WebDriverMethods.waitTillPageLoad(longTimeOut, driver);
		
		ToolsQAPage toolsQAPage=new ToolsQAPage(driver);
		toolsQAPage.clickElements();
		toolsQAPage.clickElementsBtn();
}
}
//comment
