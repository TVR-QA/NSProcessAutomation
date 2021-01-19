package com.qa.functions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.qa.util.TestBase;

public class employee_functions  extends TestBase{
	
	@FindBy(xpath = "//li[@id='ns-header-menu-main-item5']")
	WebElement lists;
	
	@FindBy(xpath = "//li[@data-title='Supply Chain']//following::li[@data-title='Employees']")
	List<WebElement> employees;
	
	@FindBy(xpath = "//li[@id='ns-header-menu-main-item40']")
	WebElement new_employee;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	
	@FindBy(xpath = "//input[@id='fax']")
	WebElement fax;
	
	@FindBy(xpath = "//img[@id='inpt_supervisor2_arrow']")
	WebElement supervisior_arrow;

	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> drop_down_lists;
	
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement submit_employee;
	
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement secondary_employee_save;	
	
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement employee_name;
	
	@FindBy(xpath = "//div[@class='descr']")
	WebElement saved_successully;
	
	Actions action=new Actions(driver);
	
	public employee_functions()
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
	public void navigate_to_employee() throws InterruptedException
	{
		action.moveToElement(lists).build().perform();
		Thread.sleep(2000);
		action.moveToElement(employees.get(0)).build().perform();
		Thread.sleep(2000);
		action.moveToElement(employees.get(1)).build().perform();
		Thread.sleep(2000);
		action.moveToElement(new_employee).click().build().perform();
	}
	public void employee_validations(String firstname,String lastname,String supervisior,String email,String phone,String fax,ExtentTest test) throws InterruptedException
	{
		navigate_to_employee();
		ExtentTest test4=test.createNode("Creating Employee without any data");
		submit_employee.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test4.pass(alert.getText());
			alert.accept();
		}
		else
		{
			test4.fail("Error message is not displaying");
		}
		this.firstname.sendKeys(firstname);
		submit_employee.click();
		ExtentTest test1=test.createNode("Creating Employee with only firstname");
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
		this.firstname.clear();
		this.lastname.sendKeys(lastname);
		submit_employee.click();
		ExtentTest test2=test.createNode("Creating Employee with only lastname");
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
		ExtentTest test3=test.createNode("Creating Employee with valid data");
		navigate_to_employee();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		supervisior_arrow.click();
		Thread.sleep(2000);
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(supervisior.trim()))
			{
				drop_down_lists.get(i).click();
				break;
			}
		}
		this.email.sendKeys(email);
		this.phone.sendKeys(phone);
		this.fax.sendKeys(fax);
		submit_employee.click();
		if(saved_successully.getText().equals("Employee successfully Saved"))
		{
			test3.pass(employee_name.getText()+" is created successfully");
			test3.pass("Employee is created with following data:" +"</br>"+" Employee name is: "+firstname+" "+lastname+"</br>"+" Supervisior is: "+supervisior+" </br>"+" Email is: "+email+"</br>"+" Phone number is: "+phone+"</br>"+" Fax number is: "+fax);
		}
		else
		{
			test3.fail("Employee is not created");
		}
		
		
		
	}
	public void employee_invalid_validations(String firstname,String lastname,String supervisior,String email,String phone,String fax,ExtentTest test) throws InterruptedException
	{
		navigate_to_employee();
		this.firstname.sendKeys(firstname);
		this.lastname.sendKeys(lastname);
		int sup_count=0;
		for(int i=0;i<drop_down_lists.size();i++)
		{
			if(drop_down_lists.get(i).getText().equals(supervisior.trim()))
			{
				sup_count=sup_count+1;
			}
		}
		if(sup_count==0)
		{
			test.fail("Supervisior is not present in the list... please select Supervisior from the list");
		}
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
	}
	
}
