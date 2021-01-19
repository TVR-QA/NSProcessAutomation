package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class ExpensePayment extends TestBase {
	@FindBy(xpath="//img[@id='inpt_approvalstatus6_arrow']")
	WebElement approval_arrow1;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> approval_list1;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement submit_expense_payment;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement expense_payment_id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement expense_payment_status;
	public ExpensePayment()
	{
		PageFactory.initElements(driver, this);
	}
	public void payment_details() throws InterruptedException
	{
		Thread.sleep(5000);
		approval_arrow1.click();
		approval_list1.get(1).click();
		Thread.sleep(3000);
		submit_expense_payment.click();
		System.out.println("The Payment"+" "+"" +expense_payment_id.getText()+" "+"is in"+" " +expense_payment_status.getText()+" "+"status");
		
	}
	
	
	

}
