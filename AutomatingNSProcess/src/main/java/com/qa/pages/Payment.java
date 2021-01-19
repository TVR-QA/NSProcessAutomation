package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class Payment extends TestBase {
	@FindBy(xpath="//td[@id='tdbody_acceptpayment']")
	WebElement payment_button;
	@FindBy(xpath="//input[@id='undepfunds_fs_inp']")
	List<WebElement> account_list;
	@FindBy(xpath="//img[@id='inpt_account3_arrow']")
	WebElement account_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> account_select;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement payment_save;
	@FindBy(xpath="//a[text()='Invoice']")
	WebElement invoice_link;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public Payment()
	{
		PageFactory.initElements(driver, this);
	}
	 
	public ReturnAuthorization payment_details() throws InterruptedException
	{
		Thread.sleep(10000);
		payment_button.click();
		Thread.sleep(5000);
		account_list.get(1).click();
		account_arrow.click();
		account_select.get(2).click();
		Thread.sleep(3000);
		payment_save.click();
		System.out.println("The Payment"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");
		Thread.sleep(5000);
		 invoice_link.click();
		 
	return new ReturnAuthorization();
	}
	

}
