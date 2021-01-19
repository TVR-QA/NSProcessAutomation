package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;

public class AuthPage extends TestBase {
	@FindBy(xpath="//td[@class='smalltextnolink']//following-sibling::td")
	WebElement question;
	@FindBy(css="tr td input[type='password'][name='answer']")
	WebElement answer;
	@FindBy(css="tr td input[type='submit'][name='submitter']")
	WebElement authsubmit;
	@FindBy(xpath = "//li[@data-title='Transactions']")
	WebElement Transactions;
	@FindBy(linkText="Sales")
	WebElement Sales;
	@FindBy(linkText="Enter Sales Orders")
	WebElement EnterSO;
	@FindBy(xpath = "//a[@href='?role_switch=234071887']")
	WebElement choose_role;
	public AuthPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateAuthPageTitle()
	{
		return driver.getTitle();
	}
	public String authquestion()
	{
		return question.getText();
	}
	public void enterAuthCode(String code)
	{
		answer.sendKeys(code);
		authsubmit.click();
	}
	public void  choose_role()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",choose_role);
		choose_role.click();
	}
	public void navigateToSO()
	{
		Actions action=new Actions(driver);
		action.moveToElement(Transactions).build().perform();
		action.moveToElement(Sales).build().perform();
		EnterSO.click();
		
	}
	
	

}
