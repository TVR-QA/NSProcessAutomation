package com.qa.nsprocess;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.exceldataReader.ExcelReader;
import com.qa.functions.Sales_order_functions;
import com.qa.functions.Expense_report_functions;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class ExpenseReport extends TestBase {
	TestUtil testUtil;
	ExcelReader reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	Sales_order_functions page;
	Expense_report_functions expense;

	public void send_email() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./Expense_report/myReport.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		// attachment.setDescription("Test Report");
		// attachment.setName("Bulk Email Invoices");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
		email.setSSLOnConnect(true);
		email.addTo("sindhuja.b@tvarana.com", "Sindhu");
		email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
		email.setSubject("Expense report Validation Report");
		email.setMsg("Here is the report please find the attachment");
		email.attach(attachment);
		email.send();
	}

	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Expense_report/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Netsuite Login Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja");
	}

	@AfterTest
	public void endReport() throws EmailException {
		extent.flush();
		send_email();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			// test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		// driver.quit();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
	@DataProvider
	public Object[][] invalid_data() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\Expensereportdata.xlsx", 1);
	}
	@Test(dataProvider = "invalid_data",priority = 1)
	public void expense_report_validation_using_invalid_data(String employee,String category,String currency,String rate) throws InterruptedException
	{
			test=extent.createTest("So validating using invalid data");
			expense=new Expense_report_functions();
			expense.invalid_data_validation(employee, category, currency, rate, test);
			
	}

	@DataProvider
	public Object[][] Expense_report_creation() throws IOException {
		reader = new ExcelReader();
		return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\Expensereportdata.xlsx", 0);
	}

	@Test(dataProvider = "Expense_report_creation", priority = 1)
	public void Expense_report_creation(String employee, String amount, String currency, String category,
			String quantity, String rate, String testcase, String department, String class1, String location,
			String memo, String advance) throws InterruptedException {
		expense = new Expense_report_functions();
		expense.expense_report_validations(employee, category, currency, quantity, rate, test, extent);
		test = extent.createTest(testcase);
		expense.expense_details(employee, amount, currency, category, quantity, rate, testcase, department, class1,
				location, memo, advance, test);
		expense.payment(test, extent);
	}

}
