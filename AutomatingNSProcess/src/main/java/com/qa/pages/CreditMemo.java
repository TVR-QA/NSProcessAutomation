package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class CreditMemo extends TestBase {
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement submit;
	@FindBy(xpath="//td[@id='tdbody_refund']")
	WebElement refund;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	
	public CreditMemo()
	{
		PageFactory.initElements(driver, this);
	}
	
	public CustomerRefund credit_details() throws InterruptedException
	{
		Thread.sleep(8000);
		submit.click();
		System.out.println("The Credit Memo"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");

		Thread.sleep(5000);
		refund.click();
		return new CustomerRefund();
	}

}
