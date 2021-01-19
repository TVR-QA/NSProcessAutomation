package com.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class ItemShipment extends TestBase {
	@FindBy(xpath="//span[@id='itemreceive1_fs']")
	WebElement fulfill_checkbox;
	@FindBy(xpath="//img[@id='inpt_location17_arrow']")
	WebElement location_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> location_dropdown;
	@FindBy(id="inventorydetail_helper_popup_1")
	WebElement inventory_detail;
	@FindBy(id="tdbody_secondaryok")
	WebElement inventory_ok;
	@FindBy(id="spn_secondarymultibutton_submitter")
	WebElement fulfill_save;
	@FindBy(xpath="//*[@id=\"tdbody_process\"]")
	WebElement fulfill;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	public ItemShipment(){
		PageFactory.initElements(driver, this);
	}
	public Invoice item_shipment() throws InterruptedException
	{
		fulfill.click();
		Thread.sleep(3000);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,500)", "");
		fulfill_checkbox.click();
		Actions action=new Actions(driver);
		action.moveToElement(location_arrow).build().perform();
		location_arrow.click();
		location_dropdown.get(1).click();
		inventory_detail.click();
		driver.switchTo().frame("childdrecord_frame");
		Thread.sleep(3000);
		inventory_ok.click();
		fulfill_save.click();
		System.out.println("The Item Shipment"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");

		return new Invoice();
	}
	
}
