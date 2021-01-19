package com.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class CustomerRefund extends TestBase{
	@FindBy(xpath="//td[@id='paymentlnk']")
	WebElement payment;
	@FindBy(xpath="//img[@id='inpt_paymentmethod17_arrow']")
	WebElement payment_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> dropdown_link;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public CustomerRefund()
	{
		PageFactory.initElements(driver, this);
	}
	public void customer_refund_details() throws InterruptedException
	{
		 Thread.sleep(5000);
		   JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			Actions action=new Actions(driver);
			action.moveToElement(payment).build().perform();
			payment.click();
			payment_arrow.click();
			dropdown_link.get(2).click();
			Thread.sleep(2000);
			action.moveToElement(submit).build().perform();
			submit.click();
			System.out.println("The Customer Refund"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");

	}
	

}
