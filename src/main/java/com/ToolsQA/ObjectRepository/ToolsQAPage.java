package com.ToolsQA.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToolsQAPage {
//comment from user
	@FindBy(xpath="//h5[.='Elements']/../..//div[@class='avatar mx-auto white']")
	private WebElement  elementsImg;
	
	@FindBy(xpath="//div[.='Elements']")
	private WebElement elementsBtn;
	
	@FindBy(xpath="//span[@class='rct-checkbox']")
	private WebElement checkBox;
	
	public ToolsQAPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickElements() 
	{
		elementsImg.click();
	}
	public void clickElementsBtn() 
	{
		elementsBtn.click();
	}
	public void clickCheckBox() 
	{
		checkBox.click();
	}
}
