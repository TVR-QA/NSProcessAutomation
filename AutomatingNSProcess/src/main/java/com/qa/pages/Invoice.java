package com.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class Invoice extends TestBase {
	@FindBy(xpath="//td[@id='tdbody_submitinv']")
	WebElement bill;
	@FindBy(xpath="//img[@id='inpt_approvalstatus3_arrow']")
	WebElement approval_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> approval_status;
	@FindBy(xpath="//img[@id='inpt_location10_arrow']")
	WebElement location_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> location;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement save_invoice;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public Invoice()
	{
		PageFactory.initElements(driver, this);
	}
	public Payment invoice_details() throws InterruptedException
	{
		Thread.sleep(5000);
		bill.click();
		Thread.sleep(6000);
		Actions action=new Actions(driver);
		action.moveToElement(approval_arrow).build().perform();
		approval_arrow.click();
		approval_status.get(1).click();
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,500)", "");
		action.moveToElement(location_arrow).build().perform();
		location_arrow.click();
		location.get(16).click();
		jsx.executeScript("window.scrollBy(0,500)", "");
		save_invoice.click();
		System.out.println("The Invoice"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");

		return new Payment();
	}
	

}
