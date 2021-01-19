package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class ReturnAuthorization extends TestBase {
	@FindBy(xpath="//td[@id='tdbody_return']")
	WebElement return_button;
	@FindBy(xpath="//img[@id='inpt_orderstatus3_arrow']")
	WebElement status_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> status_dropdown;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement submit;
	@FindBy(xpath="//td[@id='tdbody_receive']")
	WebElement receive;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public ReturnAuthorization()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ItemReceipt return_details() throws InterruptedException
	{
		return_button.click();
		Thread.sleep(5000);
		status_arrow.click();
		status_dropdown.get(1).click();
		Thread.sleep(3000);
		submit.click();
		System.out.println("The Return Authorization"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");
		Thread.sleep(5000);
		receive.click();
		return new ItemReceipt();
	}
	

}
