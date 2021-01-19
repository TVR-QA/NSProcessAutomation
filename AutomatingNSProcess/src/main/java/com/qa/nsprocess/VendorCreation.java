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
import com.qa.functions.vendorFunctions;
import com.qa.pages.AuthPage;
import com.qa.util.TestBase;
	import com.qa.util.TestUtil;

	public class VendorCreation extends TestBase {
		TestUtil testUtil;
		ExcelReader reader;
		ExtentSparkReporter htmlReporter;
		ExtentReports extent;
		ExtentTest test;
		vendorFunctions vendor;
		AuthPage authpage;

		public void send_email() throws EmailException
		{
			EmailAttachment attachment = new EmailAttachment();
			  attachment.setPath("./SO_report/myReport.html");
			  attachment.setDisposition(EmailAttachment.ATTACHMENT);
			  MultiPartEmail email = new MultiPartEmail();
			  email.setHostName("smtp.gmail.com");
			  email.setSmtpPort(465);
			  email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
			  email.setSSLOnConnect(true);
			  email.addTo("sindhuja.b@tvarana.com", "Sindhu");
			  email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
			  email.setSubject("Vendor Test Report");
			  email.setMsg("Here is the report please find the attachment");
			  email.attach(attachment);
			  email.send();
		}
		@BeforeTest
		public void setExtent() {
			// specify location of the report
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/vendor_report/myReport.html");
			htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
			htmlReporter.config().setReportName("Vendor Test Report"); // Name of the report
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
		public Object[][] vendor_invalid_validations() throws IOException {
			reader = new ExcelReader();
			return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\Vendor_data.xlsx", 1);
		}
		@Test(dataProvider = "vendor_invalid_validations",priority=1)
		public void vendor_invalid_validations(String company_name,String firstname,String last_name,String email,String phone,String fax,String currency,String terms) throws InterruptedException
		{
			
			test=extent.createTest("Vendor creation with invalid data");
			authpage=new AuthPage();
			vendor=new vendorFunctions();
			vendor.vendor_invalid_validations(company_name, firstname, last_name, email, phone, fax, currency, terms, test);
		}
		@DataProvider
		public Object[][] vendor_validations() throws IOException {
			reader = new ExcelReader();
			return reader.readExcelData("C:\\Users\\Sindhuja\\Desktop\\Vendor_data.xlsx", 0);
		}
		@Test(dataProvider = "vendor_validations",priority=2)
		public void vendor_validations(String company_name,String firstname,String last_name,String email,String phone,String fax,String currency,String terms) throws InterruptedException
		{
			
			test=extent.createTest("Vendor creation with giving valid data and without giving data");
			authpage=new AuthPage();
			vendor=new vendorFunctions();
			vendor.vendor_validations(company_name, firstname, last_name, email, phone, fax, currency, terms, test, extent);
		}
	}
