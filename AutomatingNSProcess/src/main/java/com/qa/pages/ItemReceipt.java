package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class ItemReceipt extends TestBase{
	@FindBy(xpath="//span[@id='itemreceive1_fs']")
	WebElement item_receive;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit;
	@FindBy(xpath="//td[@id='tdbody_refund']")
	WebElement refund_button;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public ItemReceipt()
	{
		PageFactory.initElements(driver, this);
	}
	
	public CreditMemo item_receipt_details() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		action.moveToElement(item_receive).build().perform();
		item_receive.click();
		Thread.sleep(2000);
		submit.click();
		System.out.println("The Item Receipt"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");
		Thread.sleep(5000);
		refund_button.click();
		return new CreditMemo();
	}
}