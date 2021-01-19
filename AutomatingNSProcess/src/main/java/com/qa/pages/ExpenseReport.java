package com.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class ExpenseReport extends TestBase {
	@FindBy(id="ns-header-menu-main-item5")
	WebElement Transactions;
	@FindBy(linkText="Employees")
	WebElement Employees;
	@FindBy(linkText="Enter Expense Reports")
	WebElement enter_expense_report;
	@FindBy(xpath="//img[@id='inpt_customform1_arrow']")
	WebElement form_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> form_list;
	@FindBy(xpath="//img[@id='inpt_entity2_arrow']")
	WebElement employee_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> employee_list;
	@FindBy(xpath="//tr[@class='uir-machine-row uir-machine-row-odd listtextnonedit uir-machine-row-focused']//td[count(//div[text()='Category']//parent::td//preceding-sibling::*)+1]")
	WebElement category_click;
	@FindBy(xpath="//img[@id='inpt_category7_arrow']")
	WebElement category_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> category_select;
	@FindBy(xpath="//tr[@class='uir-machine-row uir-machine-row-odd listtextnonedit uir-machine-row-focused']//td[count(//div[text()='Currency']//parent::td//preceding-sibling::*)+1]")
	WebElement currency_click;
	@FindBy(xpath="//img[@id='inpt_currency8_arrow']")
	WebElement currency_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> currency_list;
	@FindBy(xpath="//tr[@class='uir-machine-row uir-machine-row-odd listtextnonedit uir-machine-row-focused']//td[count(//div[text()='Amount']//parent::td//preceding-sibling::*)+1]")
	WebElement amount_click;
	@FindBy(xpath="//input[@id='amount_formattedValue']")
	WebElement amount;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit;
	@FindBy(xpath="//td[@id='tdbody_approve']")
	WebElement approve;
	@FindBy(xpath="//td[@id='tdbody_payment']")
	WebElement payment;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement expense_id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement expense_status;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement approve_id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement approve_status;
	public ExpenseReport()
	{
		PageFactory.initElements(driver, this);
	}
	public void navigate_To_Expense_Report()
	{
		Actions action=new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		action.moveToElement(Employees).build().perform();
		enter_expense_report.click();
	}
	
	public void expense_details() throws InterruptedException
	{
		Thread.sleep(5000);
		form_arrow.click();
		form_list.get(3).click();
		Thread.sleep(3000);
		employee_arrow.click();
		employee_list.get(3).click();
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(5000);
		category_click.click();
		category_arrow.click();
		category_select.get(3).click();
		Thread.sleep(1000);
		currency_click.click();
		currency_arrow.click();
		currency_list.get(1).click();
		amount_click.click();
	}
	public void amount_enter(String amt) throws InterruptedException
	{
		amount.sendKeys(amt);
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		action.moveToElement(submit).build().perform();
		submit.click();
		System.out.println("The expense report"+" "+"" +expense_id.getText()+" "+"is in"+" " +expense_status.getText()+" "+"status");
		Thread.sleep(5000);
		approve.click();
		System.out.println("The approved expense report "+" "+"" +approve_id.getText()+" "+"is in"+" " +approve_status.getText()+" "+"status");
		Thread.sleep(3000);
		payment.click();
	}

}
