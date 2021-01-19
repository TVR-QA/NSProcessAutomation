package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.functions.Sales_order_functions;
import com.qa.util.TestBase;

public class HomePage extends TestBase{
	@FindBy(id="ns-header-menu-main-item5")
	WebElement Transactions;
	@FindBy(linkText="Sales")
	WebElement Sales;
	@FindBy(linkText="Enter Sales Orders")
	WebElement EnterSO;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public Sales_order_functions navigateToSO()
	{
		Actions action=new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		action.moveToElement(Sales).build().perform();
		EnterSO.click();
		return new Sales_order_functions();
		
	}
	
}
