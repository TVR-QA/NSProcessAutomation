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

public class Expense_report_functions extends TestBase {
	@FindBy(xpath = "//div[@class='descr']")
	WebElement expense_confirm;
	@FindBy(xpath = "//input[@id='rate_formattedValue']")
	WebElement rates;
	@FindBy(xpath = "//input[@id='quantity_formattedValue']")
	WebElement quantitys;
	@FindBy(xpath = "//li[@data-title='Transactions']")
	WebElement Transactions;
	@FindBy(linkText = "Employees")
	WebElement Employees;
	@FindBy(linkText = "Enter Expense Reports")
	WebElement enter_expense_report;
	@FindBy(xpath = "//img[@id='inpt_customform1_arrow']")
	WebElement form_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> form_list;
	@FindBy(xpath = "//img[@id='inpt_entity2_arrow']")
	WebElement employee_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> employee_list;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Category']//preceding-sibling::td)+1]")
	List<WebElement> category_click;
	@FindBy(xpath = "//img[@id='inpt_category6_arrow']")
	WebElement category_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> category_select;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Currency']//preceding-sibling::td)+1]")
	List<WebElement> currency_click;
	@FindBy(xpath = "//img[@id='inpt_currency7_arrow']")
	WebElement currency_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> currency_list;
	@FindBy(xpath = "//tr[@class='uir-machine-row uir-machine-row-odd listtextnonedit uir-machine-row-focused']//td[count(//div[text()='Amount']//parent::td//preceding-sibling::*)+1]")
	List<WebElement> amount_click;
	@FindBy(xpath = "//input[@id='amount_formattedValue']")
	WebElement amount;
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit;
	@FindBy(xpath = "//td[@id='tdbody_approve']")
	WebElement approve;
	@FindBy(xpath = "//td[@id='tdbody_payment']")
	WebElement payment;
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement expense_id;
	@FindBy(xpath = "//div[@class='uir-record-status']")
	WebElement expense_status;
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement approve_id;
	@FindBy(xpath = "//div[@class='uir-record-status']")
	WebElement approve_status;
	@FindBy(xpath = "//img[@id='inpt_approvalstatus6_arrow']")
	WebElement approval_arrow1;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> approval_list1;
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement submit_expense_payment;
	@FindBy(xpath = "//div[@class='uir-record-id']")
	WebElement expense_payment_id;
	@FindBy(xpath = "//div[@class='uir-record-status']")
	WebElement expense_payment_status;
	@FindBy(xpath = "//input[@id='accountingapproval_fs_inp']//following-sibling::img")
	WebElement accounting_approval;
	@FindBy(xpath = "//input[@id='memo']")
	WebElement before_memo;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Memo']//preceding-sibling::td)+1]")
	List<WebElement> memo_line_click;
	@FindBy(xpath = "//span[@id='expense_memo_fs']//input")
	WebElement memo_line;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Department']//preceding-sibling::td)+1]")
	WebElement department_click;
	@FindBy(xpath = "//img[@id='inpt_department8_arrow']")
	WebElement department_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> department_list;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Location']//preceding-sibling::td)+1]")
	List<WebElement> location_click;
	@FindBy(xpath = "//span[@id='expense_location_fs']//following-sibling::img")
	WebElement location_arrow;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Class']//preceding-sibling::td)+1]")
	List<WebElement> class_click;
	@FindBy(xpath = "//span[@id='expense_class_fs']//following-sibling::img")
	WebElement class_arrow;
	@FindBy(xpath = "//span[@id='memo_fs_lbl_uir_label']//following-sibling::span")
	WebElement memo_after;
	@FindBy(xpath = "//span[@id='custbodyadvance_reimburse_fs_lbl_uir_label']//following-sibling::span")
	WebElement advance_reimbusure;
	@FindBy(xpath = "//span[@id='amount_fs_lbl_uir_label']//following-sibling::span")
	WebElement total_reimbursement_amount;
	@FindBy(xpath = "//input[@id='advance_formattedValue']")
	WebElement advance_enter;
	@FindBy(xpath = "//input[@id='expense_addedit']")
	WebElement ok_button;
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement expense_save_first;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Rate']//preceding-sibling::td)+1]")
	List<WebElement> rate_click;
	@FindBy(xpath = "//table[@id='expense_splits']//tbody//tr[@id='expense_headerrow']//following-sibling::tr//td[count(//td[@data-label='Quantity']//preceding-sibling::td)+1]")
	List<WebElement> quantity_click;

	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 100);

	public Expense_report_functions() {
		PageFactory.initElements(driver, this);
	}

	public void navigate_To_Expense_Report() {
		Actions action = new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		action.moveToElement(Employees).build().perform();
		enter_expense_report.click();
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
	public void invalid_data_validation(String employee,String category,String currency,String rate,ExtentTest test) throws InterruptedException
	{
		int emp_count=0;
		int cat_count=0;
		int cur_count=0;
		int rate_count=0;
		navigate_To_Expense_Report();
		Thread.sleep(5000);
		form_arrow.click();
		form_list.get(1).click();
		Thread.sleep(3000);
		employee_arrow.click();
		for (int i = 0; i < employee_list.size(); i++) {
			WebElement emp = employee_list.get(i);
			if (emp.getText().equals(employee.trim())) {
				emp_count=emp_count+1;
			
			}
		}
		if(emp_count==0)
		{
			test.fail("Employee name is not present in the list..please select employee from the list");
		}
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		category_click.get(0).click();
		category_arrow.click();
		for (int i = 0; i < category_select.size(); i++) {
			WebElement cat = category_select.get(i);
			if (cat.getText().equals(category.trim())) {
				cat_count=cat_count+1;
			}
		}
		if(cat_count==0)
		{
			test.fail("Category is not present in the list..please select category from the list");
		}
			
		currency_click.get(0).click();
		currency_arrow.click();
		for (int i = 0; i < currency_list.size(); i++) {
			WebElement cur = currency_list.get(i);
			if (cur.getText().equals(currency.trim())) {
				cur_count=cur_count+1;
			}
		}
		if(cur_count==0)
		{
			test.fail("Currency is not present in the list..Please select currency from the list");
		}
		
	}

	public void expense_report_validations(String employee_name, String category, String currency, String quantity,
			String rate, ExtentTest test, ExtentReports report) throws InterruptedException {
		String[] two_category = new String[2];
		for (int i = 0; i < two_category.length; i++) {
			two_category = category.split(",");
		}
		String[] two_currency = new String[2];
		for (int i = 0; i < two_currency.length; i++) {
			two_currency = currency.split(",");
		}
		String[] two_quantity = new String[2];
		for (int i = 0; i < two_quantity.length; i++) {
			two_quantity = quantity.split(",");
		}
		String[] two_rate = new String[2];
		for (int i = 0; i < two_rate.length; i++) {
			two_rate = rate.split(",");
		}
		navigate_To_Expense_Report();
		Thread.sleep(5000);
		form_arrow.click();
		form_list.get(1).click();
		Thread.sleep(3000);
		expense_save_first.click();
		test = report.createTest("Expense report validation without entering mandatory fields");
		ExtentTest test1 = null;
		if (isAlertPresent_() == true) {
			Alert alert = driver.switchTo().alert();
			test1 = test.createNode("Expense Report saving without giving data");
			test1.pass(alert.getText());
			alert.accept();
		}
		employee_arrow.click();
		for (int i = 0; i < employee_list.size(); i++) {
			WebElement emp = employee_list.get(i);
			if (emp.getText().equals(employee_name.trim())) {
				emp.click();
				break;
			}
		}
		Thread.sleep(4000);
		expense_save_first.click();
		if (isAlertPresent_() == true) {
			Alert alert = driver.switchTo().alert();
			ExtentTest test2 = test.createNode("Expense report saving without expense item");
			test2.pass(alert.getText());
			alert.accept();
		}
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(2000);
		category_click.get(0).click();
		category_arrow.click();
		for (int i = 0; i < category_select.size(); i++) {
			WebElement cat = category_select.get(i);
			if (cat.getText().equals(two_category[0].trim())) {
				cat.click();
				break;
			}
		}
		Thread.sleep(3000);
		submit.click();
		if (isAlertPresent_() == true) {
			Alert alert = driver.switchTo().alert();
			ExtentTest test3 = test.createNode("Expense report saving without Amount, Quantity, Rate");
			test3.pass(alert.getText());
			alert.accept();
		}

	}

	public void expense_details(String employee_name, String amount1, String currency, String category, String quantity,
			String rate, String testcase, String department, String class1, String location, String memo,
			String advance, ExtentTest test) throws InterruptedException {

		navigate_To_Expense_Report();
		if (isAlertPresent_() == true) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		String[] two_category = new String[2];
		for (int i = 0; i < two_category.length; i++) {
			two_category = category.split(",");
		}
		String[] two_currency = new String[2];
		for (int i = 0; i < two_currency.length; i++) {
			two_currency = currency.split(",");
		}
		String[] two_quantity = new String[2];
		for (int i = 0; i < two_quantity.length; i++) {
			two_quantity = quantity.split(",");
		}
		String[] two_rate = new String[2];
		for (int i = 0; i < two_rate.length; i++) {
			two_rate = rate.split(",");
		}
		String[] two_dept = new String[2];
		for (int i = 0; i < two_dept.length; i++) {
			two_dept = department.split(",");
		}
		String[] two_class = new String[2];
		for (int i = 0; i < two_class.length; i++) {
			two_class = class1.split(",");
		}
		String[] two_location = new String[2];
		for (int i = 0; i < two_location.length; i++) {
			two_location = location.split(",");
		}
		String[] two_memo = new String[2];
		for (int i = 0; i < two_memo.length; i++) {
			two_memo = memo.split(",");
		}

		Thread.sleep(5000);
		form_arrow.click();
		form_list.get(1).click();
		Thread.sleep(3000);
		employee_arrow.click();
		for (int i = 0; i < employee_list.size(); i++) {
			WebElement emp = employee_list.get(i);
			if (emp.getText().equals(employee_name.trim())) {
				emp.click();
				break;
			}
		}
		Thread.sleep(4000);
		accounting_approval.click();
		before_memo.click();
		String before_memo_value = before_memo.getAttribute("value");
		advance_enter.click();
		Actions action = new Actions(driver);
		action.doubleClick(advance_enter).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		advance_enter.sendKeys(advance.trim());
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(5000);
		for (int k = 0; k < 2; k++) {
			category_click.get(k).click();
			category_arrow.click();
			for (int i = 0; i < category_select.size(); i++) {
				WebElement cat = category_select.get(i);
				if (cat.getText().equals(two_category[k].trim())) {
					cat.click();
					break;
				}
			}
			Thread.sleep(4000);
			
			action.sendKeys(Keys.TAB).build().perform();
			quantitys.sendKeys(two_quantity[k]);
			action.sendKeys(Keys.TAB).build().perform();
			rates.sendKeys(two_rate[k]);
			Thread.sleep(3000);
			action.sendKeys(Keys.TAB).build().perform();
			wait.until(ExpectedConditions.visibilityOf(currency_click.get(k)));
			currency_click.get(k).click();
			currency_arrow.click();
			for (int i = 0; i < currency_list.size(); i++) {
				WebElement cur = currency_list.get(i);
				if (cur.getText().equals(two_currency[k].trim())) {
					cur.click();
					break;
				}
			}
			Thread.sleep(4000);
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(2000);
			amount.clear();
			int amount_f=Integer.parseInt(two_rate[k])*Integer.parseInt(two_quantity[k]);
			amount.sendKeys(String.valueOf(amount_f));
			action.sendKeys(Keys.TAB).build().perform();
			memo_line.sendKeys(two_memo[k].trim());
			Thread.sleep(3000);
			action.sendKeys(Keys.TAB).build().perform();
			department_arrow.click();
			for (int i = 0; i < department_list.size(); i++) {
				if (department_list.get(i).getText().trim().equals(two_dept[k].trim())) {
					department_list.get(i).click();
					break;
				}
			}
			class_click.get(k).click();
			class_arrow.click();
			for (int i = 0; i < department_list.size(); i++) {
				if (department_list.get(i).getText().equals(two_class[k].trim())) {
					department_list.get(i).click();
					break;
				}
			}
			location_click.get(k).click();
			location_arrow.click();
			for (int i = 0; i < department_list.size(); i++) {
				if (department_list.get(i).getText().equals(two_location[k].trim())) {
					department_list.get(i).click();
					break;
				}
			}
			Thread.sleep(5000);
			if (k == 1)
				break;
			action.moveToElement(ok_button).build().perform();
			ok_button.click();

		}
		Thread.sleep(2000);
		action.moveToElement(submit).build().perform();
		submit.click();
		System.out.println("Expense report" + " " + "" + expense_id.getText() + " " + "is successfully created with"
				+ " " + expense_status.getText() + " " + "status");
		Thread.sleep(5000);
		String after_memo_text = memo_after.getText().trim();
		ExtentTest test3 = test.createNode("Expense Report Details");
		if (expense_confirm.getText().trim().equals("Transaction successfully Saved")) {

			test3.pass("Expense Report" + " " + "" + expense_id.getText() + " " + "is successfully created with" + " "
					+ expense_status.getText() + " " + "status");
			test3.pass("Expense Report is created with following data" + "</br>" + "Employee is: "
					+ employee_name.trim() + "</br>" + "Currencies are: " + two_currency[0] + ", " + two_currency[1]
					+ "</br>" + "Categories are: " + two_category[0] + ", " + two_category[1] + "</br>"
					+ "quantites are: " + two_quantity[0] + ", " + two_quantity[1] + "</br>" + "Rates are: "
					+ two_rate[0] + ", " + two_rate[1] + "</br>" + "Departments are: " + two_dept[0] + ", "
					+ two_dept[1] + "</br>" + "Classes are: " + two_class[0] + ", " + two_class[1] + "</br>"
					+ "Locations are: " + two_location[0] + ", " + two_location[1] + "</br>" + "Line memos are: "
					+ two_memo[0] + ", " + two_memo[1]);
		} else {
			test.fail("Expense Report is not created");
		}
		ExtentTest test1 = test.createNode("Validating Field values sourcing from Workflow");
		if (before_memo_value.trim().equals("New Expense Report Creation is started")) {
			test1.pass("Memo Value is sourced correctly before Loading Expense Report");
		} else {
			test1.fail("Memo value is not sourced correctly");
		}
		if (after_memo_text.trim().equals("Expense Report is created successfully")) {
			test1.pass("Memo value is sourced correctly after submitting Expense Report");
		} else {
			test1.fail("Memo value is not sourced correctly");
		}
		jsx.executeScript("window.scrollBy(0,500)", "");

		ExtentTest test2 = test.createNode("Validating Field Value sourcing from Script");
		double advance_ = Double.parseDouble(advance.trim());
		int advan = (int) advance_;
		double total_rem = Double.parseDouble(total_reimbursement_amount.getText().replace(",", "").trim());
		int total_r = (int) total_rem;
		double total_r_a = Double.parseDouble(advance_reimbusure.getText().replace(",", "").trim());
		int total_r_a_ = (int) total_r_a;
		if (total_r + advan == total_r_a_) {
			test2.pass("Advance&Reimbursable field value is sourced Correctly");
		}
		jsx.executeScript("window.scrollTo(0,0)");
	}

	public void payment(ExtentTest test, ExtentReports report) throws InterruptedException {
		test = report.createTest("Creating Bill Payment");
		payment.click();
		Thread.sleep(5000);
		submit_expense_payment.click();
		System.out.println("Payment" + " " + "" + expense_payment_id.getText() + " " + "is successfully created ");
		if (expense_confirm.getText().trim().equals("Transaction successfully Saved")) {
			test.pass("Payment" + " " + "" + expense_payment_id.getText() + " " + "is successfully created ");
		} else {
			test.fail("Payment is not created");
		}

	}

}
