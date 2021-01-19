package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class HoneyComb extends TestBase {
	@FindBy(xpath="//div[@id='spn_cRR_d1']")
	WebElement accounts;
	@FindBy(xpath="//li[@class='ns-menuitem ns-role-menuitem']")
	List<WebElement> list_account;
	public HoneyComb()
	{
		PageFactory.initElements(driver, this);
	}
	public void honeycomb()
	{
		Actions action=new Actions(driver);
		action.moveToElement(accounts).build().perform();
		list_account.get(0).click();
		
		
	}

}
