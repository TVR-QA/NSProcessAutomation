package com.qa.functions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;
public class vendorFunctions extends TestBase{
	//navigating to vendor
	
	@FindBy(xpath = "//li[@id='ns-header-menu-main-item5']")
	WebElement lists;
	
	@FindBy(xpath = "//li[@data-title='Relationships']")
	WebElement relationships;
	
	@FindBy(xpath = "//li[@data-title='Vendors']")
	WebElement vendors;
	
	@FindBy(xpath = "//li[@data-title='Vendors']//following::li[@data-title='New']")
	WebElement new_vendor;
	
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement submit_vendor;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement company_name;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='fax']")
	WebElement fax;
	
	@FindBy(xpath = "//img[@id='inpt_terms11_arrow']")
	WebElement terms_arrow;
	
	@FindBy(xpath = "//td[@id='financiallnk']")
	WebElement financial_tab;
	
	@FindBy(xpath = "//img[@id='inpt_currency10_arrow']")
	WebElement currency_arrow;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> drop_down_lists;
	
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement secondary_vendor_save;
	
	@FindBy(xpath = "//input[@id='isperson_fs_inp']")
	List<WebElement> select_vendor_radio_button;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//span//input[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement vendor_description;
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement vendor_name_after_saving;
	
	Actions action=new Actions(driver);
	
	JavascriptExecutor jsx = (JavascriptExecutor)driver;

	
	public vendorFunctions()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean isAlertPresent_() {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			System.err.println("Alert isn't present!!");
			return false;
		}

	}
	public void navigate_to_vendor() throws InterruptedException
	{
		action.moveToElement(lists).build().perform();
		Thread.sleep(2000);
		action.moveToElement(relationships).build().perform();
		Thread.sleep(2000);
		action.moveToElement(vendors).build().perform();
		Thread.sleep(2000);
		action.moveToElement(new_vendor).click().build().perform();
	}
	public void vendor_validations(String company_name,String firstname,String last_name,String email,String phone,String fax,String currency,String terms,ExtentTest test,ExtentReports report) throws InterruptedException
	{
		navigate_to_vendor();
		submit_vendor.click();
		ExtentTest test1=null;
		test1=test.createNode("Vendor Creation without giving data");
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test1.pass(alert.getText());
			alert.accept();
		}
		else
		{
			test1.fail("Error message is not displaying");
		}
		select_vendor_radio_button.get(1).click();
		this.firstname.sendKeys(firstname);
		submit_vendor.click();
		ExtentTest test2=test.createNode("Vendor Creation with only firstname");
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test2.pass(alert.getText());
			alert.accept();
		}	
		else
		{
			test2.fail("Error message is not displaying");
		}
		this.firstname.clear();
		lastname.sendKeys(last_name);
		submit_vendor.click();
		ExtentTest test3=test.createNode("Vendor Creation with only lastname");
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test3.pass(alert.getText());
			alert.accept();
		}	
		else
		{
			test3.fail("Error message is not displaying");
		}
		navigate_to_vendor();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		ExtentTest test4=test.createNode("Vendor creation with valid data");
		this.company_name.sendKeys(company_name);
		this.email.sendKeys(email);
		this.phone.sendKeys(phone);
		this.fax.sendKeys(fax);
		jsx.executeScript("arguments[0].scrollIntoView(true);",financial_tab);
		Thread.sleep(2000);
		financial_tab.click();
		terms_arrow.click();
		Thread.sleep(2000);
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(terms.trim()))
			{
				drop_down_lists.get(i).click();
				break;
			}
		}
		currency_arrow.click();
		Thread.sleep(2000);
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(currency.trim()))
			{
				drop_down_lists.get(i).click();
				break;
			}
		}
		
		secondary_vendor_save.click();
		if(vendor_description.getText().trim().equals("Vendor successfully Saved"))
		{
			test4.pass(vendor_name_after_saving.getText()+" is created successfully" );
			test4.pass("Vendor is created with following data: "+"</br>"+" Vendor name is: "+company_name+"</br>"+" Email is: "+email+"</br>"+" Phone number is: "+phone+"</br>"+" Fax number is: "+fax+"</br>"+" Term is: "+terms+"</br>"+" currecy is: "+currency);
		}

	}
	public void vendor_invalid_validations(String company_name,String firstname,String last_name,String email,String phone,String fax,String currency,String terms,ExtentTest test) throws InterruptedException
	{
		
		navigate_to_vendor();
		this.company_name.sendKeys(company_name);
		this.email.sendKeys(email);
		action.sendKeys(Keys.TAB).build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test.fail(alert.getText());
			alert.accept();
		}
		this.email.clear();
		this.phone.sendKeys(phone);
		action.sendKeys(Keys.TAB).build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test.fail(alert.getText());
			alert.accept();
		}
		this.phone.clear();
		this.fax.sendKeys(fax);
		action.sendKeys(Keys.TAB).build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			String fax_text="Phone number should have seven digits or more.";
			if(alert.getText().equals(fax_text))
			{
			test.fail("Fax number should have seven digits or more");
			}
			alert.accept();
		}
		this.fax.clear();
		jsx.executeScript("arguments[0].scrollIntoView(true);",financial_tab);
		Thread.sleep(2000);
		financial_tab.click();
		terms_arrow.click();
		int term_count=0;
		int curr_count=0;
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(terms.trim()))
			{
				term_count=term_count+1;
			}
		}
		if(term_count==0)
		{
			test.fail("Terms are not present in the list... please select terms from the list");
		}
		currency_arrow.click();
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(currency.trim()))
			{
				curr_count=curr_count+1;
			}
		}
		if(curr_count==0)
		{
			test.fail("Currency is not present in the list... please select currency from the list");
		}
		

		
		}
		
	
	

}
