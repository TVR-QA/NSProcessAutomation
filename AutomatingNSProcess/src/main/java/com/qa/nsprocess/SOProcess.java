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
import com.qa.pages.AuthPage;
import com.qa.util.TestBase;
	import com.qa.util.TestUtil;

	public class SOProcess extends TestBase {
		TestUtil testUtil;
		ExcelReader reader;
		ExtentSparkReporter htmlReporter;
		ExtentReports extent;
		ExtentTest test;
		Sales_order_functions page;
		AuthPage authpage;

		public void send_email() throws EmailException
		{
			EmailAttachment attachment = new EmailAttachment();
			  attachment.setPath("./SO_report/myReport.html");
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
			  email.setSubject("Sales Order Validation Report");
			  email.setMsg("Here is the report please find the attachment");
			  email.attach(attachment);
			  email.send();
		}
		@BeforeTest
		public void setExtent() {
			// specify location of the report
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/SO_report/myReport.html");
			htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
			htmlReporter.config().setReportName("Sales Order Automation"); // Name of the report
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
				//test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			}
			driver.quit();
		}

		@BeforeMethod
		public void setUp() throws InterruptedException {
			testUtil = new TestUtil();
			testUtil.setUp();
		}
		@DataProvider
		public Object[][] SO_validations() throws IOException {
			reader = new ExcelReader();
			return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\SoData.xlsx", 1);
		}
		@Test(dataProvider = "SO_validations",priority=2)
		public void so_Validations(String customer_name,String item_name,String quantity,String location,String terms) throws InterruptedException
		{
			
			test=extent.createTest("SO validations by giving Invalid data");
			authpage=new AuthPage();
			authpage.navigateToSO();
			page=new Sales_order_functions();
			page.so_validations(customer_name, item_name, quantity,location,terms,test);
			
		}

		@DataProvider
		public Object[][] So_process() throws IOException {
			reader = new ExcelReader();
			return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\SoData.xlsx", 0);
		}
		@Test(dataProvider = "So_process", priority = 1)
		public void So_process(String cus_searchbox,String item_searchbox,String quantity,String amount,String testcase,String location,String rate,String terms,String discount_item,String contact,String fax_no,String shipping_cost,String sales_rep,String ship_carrier,String ship_tax,String payment_method,String shipping_method) throws InterruptedException
		{
			authpage=new AuthPage();
			authpage.navigateToSO();
			page=new Sales_order_functions();
			page.validations(cus_searchbox, item_searchbox, quantity, amount,testcase,location,test,extent);
			test=extent.createTest(testcase);
			page.so_customer_details(cus_searchbox,item_searchbox, quantity, amount,testcase,location,rate, terms, discount_item, contact, fax_no, shipping_cost, sales_rep,ship_carrier,ship_tax,payment_method,shipping_method,test);
			page.item_shipment(location,test, extent);
			page.invoice_creation(test, extent);
			page.payment_creation(test, extent);
			page.return_authorization(test, extent);
			page.item_receipt_creation(test, extent);
			page.credit_memo(test, extent);
			page.customer_refund(test, extent);
			page.navigating_to_return_auth(test, extent);	
			
		}

	}

