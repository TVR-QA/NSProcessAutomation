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
import com.qa.pages.AuthPage;
import com.qa.util.TestBase;

import io.cucumber.java.sl.In;

public class Sales_order_functions extends TestBase {
	//customer selection web elements
	@FindBy(xpath = "//span[@id='class_fs_lbl_uir_label']//following-sibling::span")
	WebElement class_from_so;
	@FindBy(xpath = "//span[@id='location_fs_lbl_uir_label']//following-sibling::span")
	WebElement location_from_so;
	@FindBy(xpath = "//td[@id='spn_secondarymultibutton_submitter']")
	WebElement secondary_so_save;
	@FindBy(xpath = "//div[@class='uir-record-name']")
	WebElement customer_refund_id;
	@FindBy(xpath = "//img[@id='inpt_location7_arrow']")
	WebElement location_arrow_in_credit_memo;
	@FindBy(xpath = "//img[@id='inpt_location17_arrow']")
	WebElement item_receipt_location_arrow;
	@FindBy(xpath = "//td[@id='tdbody_approvereturn']")
	WebElement approve_return;
	@FindBy(xpath = "//div[@class='descr']")
	WebElement SO_confirmation;
	@FindBy(xpath="//span[@id='parent_actionbuttons_entity_fs']")
	WebElement Customer_arrow;
	@FindBy(xpath="//a[@id='entity_popup_list']")
	WebElement Customer_list;
	@FindBy(xpath="//input[@id='st']")
	WebElement Customer_searchbox;
	@FindBy(xpath="//input[@id='Search']")
	WebElement Customer_search;
	@FindBy(xpath="//div[@id='inner_popup_div']//table//tbody//tr")
	List<WebElement> Customers_list;
	//order type webelements
	@FindBy(xpath="//img[@id='inpt_custbody_order_type22_arrow']")
	WebElement Order_type;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> Order_type_dropdown;
	//end user web elements
	@FindBy(xpath="//span[@id='parent_actionbuttons_custbody_end_user_fs']")
	WebElement EndUser_arrow;
	@FindBy(xpath="//a[@id='custbody_end_user_popup_list']")
	WebElement EndUser_List;
	@FindBy(xpath = "//img[@id='inpt_location8_arrow']")
	WebElement location_arrow_in_so;
	@FindBy(xpath="//input[@id='st']")
	WebElement EndUser_searchbox;
	@FindBy(xpath="//input[@id='Search']")
	WebElement EndUser_search;
	@FindBy(xpath="//div[@id='inner_popup_div']//table//tbody//tr")
	List<WebElement> EnderUsers_list;
	@FindBy(xpath="//span[@id='parent_actionbuttons_item_item_fs']")
	WebElement Item_arrow;
	@FindBy(xpath="//a[@id='item_popup_list']")
	WebElement item_list;
	@FindBy(xpath="//input[@id='st']")
	WebElement Item_searchbox;
	@FindBy(xpath="//input[@id='Search']")
	WebElement Item_search;
	@FindBy(xpath="//div[@id='inner_popup_div']//table/tbody/tr//following-sibling::tr//td//following-sibling::td//a")
	List<WebElement> items_list;
	@FindBy(xpath="//input[@id='quantity_formattedValue']")
	WebElement Quantity;
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='item_headerrow']//following-sibling::tr//td[9]")
	//@FindBy(xpath="//div[@class='uir-machine-table-container']//table[@id='item_splits']//tbody//tr[@class='uir-machine-row uir-machine-row-odd listtextnonedit uir-machine-row-focused']//td[8]")
	List<WebElement> Amount_click;
	@FindBy(xpath="//input[@id='amount_formattedValue']")
	WebElement Amount;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement SO_Save;
	@FindBy(xpath="//div[@class='uir-record-id']")
	WebElement id;
	@FindBy(xpath="//div[@class='uir-record-status']")
	WebElement status;
	//@FindBy(xpath="//span[@id='itemreceive1_fs']")
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='itemheader']//following-sibling::tr//td[count(//td[@data-label='Fulfill'])]//img")
	List<WebElement> fulfill_checkbox;
	@FindBy(xpath="//img[@id='inpt_location17_arrow']")
	WebElement location_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> location_dropdown;
	//@FindBy(id="inventorydetail_helper_popup_1")
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='itemheader']//following-sibling::tr//td[count(//td[@data-label='Inventory Detail']//preceding-sibling::td)+1]//span//a")
	List<WebElement> inventory_detail;
	@FindBy(id="tdbody_secondaryok")
	WebElement inventory_ok;
	@FindBy(id="spn_secondarymultibutton_submitter")
	WebElement fulfill_save;
	@FindBy(xpath="//*[@id=\"tdbody_process\"]")
	WebElement fulfill;
	@FindBy(xpath="//td[@id='tdbody_submitinv']")
	WebElement bill;
	@FindBy(xpath="//img[@id='inpt_approvalstatus2_arrow']")
	WebElement approval_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> approval_status;
	@FindBy(xpath="//img[@id='inpt_location10_arrow']")
	WebElement location_arrow1;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> location;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement save_invoice;
	@FindBy(xpath="//td[@id='tdbody_acceptpayment']")
	WebElement payment_button;
	@FindBy(xpath="//input[@id='undepfunds_fs_inp']")
	List<WebElement> account_list;
	@FindBy(xpath="//img[@id='inpt_account4_arrow']")
	WebElement account_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> account_select;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement payment_save;
	@FindBy(xpath="//a[text()='Invoice']")
	WebElement invoice_link;
	@FindBy(xpath="//td[@id='tdbody_return']")
	WebElement return_button;
	@FindBy(xpath="//img[@id='inpt_orderstatus2_arrow']")
	WebElement status_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> status_dropdown;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement submit_return;
	@FindBy(xpath="//td[@id='tdbody_receive']")
	WebElement receive;
	//@FindBy(xpath="//span[@id='itemreceive1_fs']")
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='itemheader']//following-sibling::tr//td[count(//td[@data-label='Receive'])]//img")
	List<WebElement> item_receive;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit_receive;
	@FindBy(xpath="//td[@id='tdbody_refund']")
	WebElement refund_button;
	@FindBy(xpath="//td[@id='spn_multibutton_submitter']")
	WebElement submit_refund;
	@FindBy(xpath="//td[@id='tdbody_refund']")
	WebElement refund;
	@FindBy(xpath="//td[@id='paymentlnk']")
	WebElement payment;
	@FindBy(xpath="//img[@id='inpt_paymentmethod13_arrow']")
	WebElement payment_arrow;
	@FindBy(xpath="//div[@class='dropdownDiv']//div")
	List<WebElement> dropdown_link;
	@FindBy(xpath="//td[@id='spn_secondarymultibutton_submitter']")
	WebElement submit_custrefund;
	@FindBy(xpath="//div[@class='uir-record-name']")
	WebElement payment_id;
	@FindBy(xpath = "//input[@id='memo']")
	WebElement before_memo;
	@FindBy(xpath = "//span[@id='department_fs_lbl_uir_label']//following-sibling::span")
	WebElement department1;
	@FindBy(xpath = "//span[@id='memo_fs_lbl_uir_label']//following-sibling::span")
	WebElement after_memo;
	@FindBy(xpath = "//table[@id='item_splits']//tr//following-sibling::tr//td[count(//table[@id='item_splits']//td[@data-label='Subtotal_and_Amount']//preceding-sibling::td)+1]")
	List<WebElement> inr_amount;
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement customer_refond_first;
	@FindBy(xpath = "//input[@id='item_addedit']")
	WebElement add_item;
	@FindBy(xpath = "//img[@id='inpt_entity2_arrow']")
	WebElement customer_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> customer_in_test;
	@FindBy(xpath = "//img[@id='inpt_orderstatus3_arrow']")
	WebElement so_status_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> status_list;
	@FindBy(xpath = "//input[@id='entity_display']")
	WebElement enter_customer;
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='item_headerrow']//following-sibling::tr//td[count(//td[@data-label='Item']//preceding-sibling::td)+1]")
	List<WebElement> click_item;
	@FindBy(xpath = "//table[@id='item_splits']//tbody//tr[@id='item_headerrow']//following-sibling::tr//td[3]")
	WebElement quantity_click;
	@FindBy(xpath = "//td[@id='cmmnctntablnk']")
	WebElement communication_tab;
	@FindBy(xpath = "//input[@id='tobefaxed_fs_inp']//following-sibling::img")
	WebElement fax_checkbox;
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='itemheader']//following-sibling::tr//td[count(//td[@data-label='Location']//preceding-sibling::td)+1]//img")
	List<WebElement>location_arrow_in_item_shipment;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> locations_in_shipment;
	@FindBy(xpath = "//td[@id='itemslnk']")
	WebElement item_tab;
	@FindBy(xpath = "//td[@id='spn_multibutton_submitter']")
	WebElement so_first_save;
	@FindBy(xpath = "//td[@class='bntBgB multiBnt']")
	WebElement save_action;
	@FindBy(xpath = "//td[@id='nl7']")
	WebElement save_button_in_item_receipt;
	@FindBy(xpath = "//span[@id='createdfrom_lbl_uir_label']//following-sibling::span")
	WebElement refund_link;
	@FindBy(xpath = "//img[@id='inpt_binnumber1_arrow']")
	WebElement bin_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> bin_list;
	@FindBy(xpath = "//input[@id='quantity_formattedValue']")
	WebElement bin_quantity;
	@FindBy(xpath = "//input[@id='inpt_salesrep3']")
	WebElement sales_rep;
	@FindBy(xpath = "//input[@id='inpt_discountitem17']")
	WebElement discount_item;
	@FindBy(xpath = "//table[@id='item_splits']//tr[@id='item_headerrow']//following-sibling::tr//td[8]")
	List<WebElement> rate_click;
	@FindBy(xpath = "//input[@id='rate_formattedValue']")
	WebElement rate;
	@FindBy(xpath = "//td[@id='shippinglnk']")
	WebElement shipping_tab;
	@FindBy(xpath = "//td[@id='billingtablnk']")
	WebElement billing_tab;
	@FindBy(xpath = "//td[@id='accntingtablnk']")
	WebElement accounting_tab;
	@FindBy(xpath = "//td[@id='rltnshptablnk']")
	WebElement relationship_tab;
	@FindBy(xpath = "//input[@id='shippingcost_formattedValue']")
	WebElement shipping_cost;
	@FindBy(xpath = "//input[@id='inpt_terms39_arrow']")
	WebElement terms;
	@FindBy(xpath = "//input[@id='entityid']")
	WebElement contact;
	@FindBy(xpath = "//span[@id='fax_fs']//input[@id='fax']")
	WebElement fax_enter;
	@FindBy(xpath = "//img[@id='inpt_discountitem17_arrow']")
	WebElement discount_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> discount_list;
	@FindBy(xpath = "//img[@id='inpt_terms38_arrow']")
	WebElement terms_arrow;
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> terms_list;
	@FindBy(xpath = "//span[@id='subtotal_fs_lbl_uir_label']//following-sibling::span")
	WebElement sub_total;
	@FindBy(xpath = "//img[@id='inpt_shipcarrier35_arrow']")
	WebElement ship_carrier_arrow;
	@FindBy(xpath = "//span[@id='parent_actionbuttons_shippingtaxcode_fs']")
	WebElement tax_arrow;
	@FindBy(xpath = "//div[@id='shippingtaxcode_fs_tooltipMenu']//a[@id='shippingtaxcode_popup_list']")
	WebElement tax_list;
	@FindBy(xpath = "//input[@id='st']")
	WebElement tax_enter;
	@FindBy(xpath = "//td[@id='tdbody_Search']")
	WebElement tax_search;
	@FindBy(xpath = "//div[@id='inner_popup_div']//table/tbody//tr//td//following-sibling::td//a")
	List<WebElement> tax_lists;
	@FindBy(xpath = "//img[@id='inpt_paymentmethod41_arrow']")
	WebElement payment_method_arrow;
	@FindBy(xpath = "//img[@id='inpt_shipmethod36_arrow']")
	WebElement shipping_method_arrow;
	@FindBy(xpath = "//span[@id='parent_actionbuttons_entity_fs']")
	WebElement customer_arrow1;
	@FindBy(xpath = "//table[@id='item_splits']//tbody//tr[@id='item_headerrow']//following-sibling::tr//td[count(//table[@id='item_splits']//tbody//tr[@id='item_headerrow']//td[@data-label='Project'])+1]")
	WebElement item_click;
	WebDriverWait wait=new WebDriverWait(driver, 100);
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	Actions action=new Actions(driver);
	String SO_Url_before=null;
	String fixed_loc=null;
	String return_auth_url=null;
	AuthPage authpage;

	public Sales_order_functions(){
		PageFactory.initElements(driver, this);
	}
	public void so_validations(String customer_name,String item_name,String quantity,String location,String terms,ExtentTest test) throws InterruptedException
	{
		Thread.sleep(10000);
		Customer_arrow.click();
		Customer_list.click();
		Customer_searchbox.sendKeys(customer_name);
		Customer_search.click();
		Thread.sleep(5000);
		int count_cust=0;
		int count_loc=0;
		for(int i=0;i<Customers_list.size();i++)
		{
			if(Customers_list.get(i).getText().equals(customer_name.trim()))
			{
				count_cust=count_cust+1;
			}
		}
		if(count_cust==0)
		{
			test.fail("Customer name is not present in the customer list.... please enter correct customer");
		}
		jsx.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		location_arrow_in_so.click();
		for(int i=0;i<this.location.size();i++)
		{
			if(this.location.get(i).getText().equals(location.trim()))
			{
				count_loc=count_loc+1;
			}
		}
		if(count_loc==0)
		{
			test.fail("Location is not present in the list... Please give correct location");
		}
		jsx.executeScript("window.scrollBy(0,700)");
		billing_tab.click();
		Thread.sleep(1000);
		terms_arrow.click();
		int count_terms=0;
		for(int i=0;i<terms_list.size();i++)
		{
			if(terms_list.get(i).getText().equals(terms.trim()))
			{
				count_terms=count_terms+1;
			}
		}
		if(count_terms==0)
		{
			test.fail("Terms are not present in the list... please select terms from the list");
		}
		Thread.sleep(4000);
		item_tab.click();
		jsx.executeScript("window.scrollBy(0,400)");
		int count_item=0;
		item_click.click();
		Item_arrow.click();
		item_list.click();
		Item_searchbox.sendKeys(item_name);
		Item_search.click();
		Thread.sleep(5000);
		for(int i=0;i<items_list.size();i++)
		{
			if(items_list.get(i).getText().equals(item_name.trim()))
			{
				count_item=count_item+1;
			}
		}
		if(count_item==0)
		{
			test.fail("Item is not present in the list ... please enter the correct item");
		}
		Thread.sleep(3000);
		action.doubleClick(Item_searchbox).build().perform();
		action.sendKeys(Keys.BACK_SPACE).build().perform();		
		Item_searchbox.sendKeys("Inventory Item Test - SP");
		Item_search.click();
		Thread.sleep(3000);
		items_list.get(0).click();
		Thread.sleep(4000);
		action.doubleClick(Quantity).build().perform();
		action.sendKeys(Keys.BACK_SPACE).build().perform();	
		Thread.sleep(4000);
		Quantity.sendKeys(quantity);
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test.fail(alert.getText());
			alert.accept();
		}
		
	}
	public void so_customer_details(String cus_searchbox,String item_searchbox,String quantity,String amount,String testcase,String location,String rate,String terms,String discount_item,String contact,String fax_no,String shipping_cost,String sales_rep,String shipping_carrier, String shipping_tax_code,String payment_method,String shipping_method,ExtentTest test) throws InterruptedException
	{
		ExtentTest test3=test.createNode("Sales Order data");
		String [] items=new String[3];
		for(int i=0;i<3;i++)
		{
			items=item_searchbox.split(",");
			System.out.println("Items are: "+items[i]);
		}
		String[] quantitys=new String[3];
		for(int i=0;i<3;i++)
		{
			quantitys=quantity.split(",");
			System.out.println("Quantites are: "+quantitys[i]);
		}
		String[] amounts=new String[3];
		for(int i=0;i<3;i++)
		{
			amounts=amount.split(",");
			System.out.println("Amounts are: "+amounts[i]);
		}
		String[] rates=new String[3];
		for(int i=0;i<3;i++)
		{
			rates=rate.split(",");
			System.out.println("Rates are: "+rates[i]);
		}
		authpage=new AuthPage();
		authpage.navigateToSO();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		ExtentTest test4=test.createNode("Validating field values sourcing from Workflow");
		fixed_loc=location;
		String SO_Url_before=null;
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		enter_customer.sendKeys(cus_searchbox.trim());
		Thread.sleep(3000);
		status_arrow.click();
		for(int i=0;i<status_list.size();i++)
		{
			if(status_list.get(i).getText().equals("Pending Fulfillment"))
			{
				status_list.get(i).click();
				break;
			}
		}
		before_memo.click();
		System.out.println("before memo text is:"+before_memo.getAttribute("value"));
		if(before_memo.getAttribute("value").trim().equals("New sales order creation is started"))
		{
			System.out.println("success");
			test4.pass("Memo value is sourced correctly before SO loads with: "+before_memo.getAttribute("value"));
		}
		else
		{
			test4.fail("Memo is not sourced correctly");
		}
		Thread.sleep(2000);
		this.sales_rep.sendKeys(sales_rep.trim());
		Thread.sleep(2000);
		jsx.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		shipping_tab.click();
		Thread.sleep(2000);
		ship_carrier_arrow.click();
		for(int i=0;i<dropdown_link.size();i++)
		{
			if(dropdown_link.get(i).getText().trim().equals(shipping_carrier.trim()))
			{
				dropdown_link.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		shipping_method_arrow.click();
		for(int i=0;i<dropdown_link.size();i++)
		{
			if(dropdown_link.get(i).getText().trim().equals(shipping_method.trim()))
			{
				dropdown_link.get(i).click();
				break;
			}
		}
		wait.until(ExpectedConditions.visibilityOf(this.shipping_cost));
		action.doubleClick(this.shipping_cost).build().perform();
		action.sendKeys(Keys.BACK_SPACE).build().perform();
		this.shipping_cost.sendKeys(shipping_cost.trim());
		tax_arrow.click();
		tax_list.click();
		tax_enter.sendKeys(shipping_tax_code.trim());
		tax_search.click();
		Thread.sleep(5000);
		tax_lists.get(0).click();
		Thread.sleep(5000);
		jsx.executeScript("window.scrollBy(0,-200)");
		billing_tab.click();
		terms_arrow.click();
		for(int i=0;i<terms_list.size();i++)
		{
			if(terms_list.get(i).getText().equals(terms.trim()))
			{
				terms_list.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		payment_method_arrow.click();
		for(int i=0;i<dropdown_link.size();i++)
		{
			WebElement pay_method=dropdown_link.get(i);
			if(pay_method.getText().trim().equals(payment_method.trim()))
			{
				pay_method.click();
				break;
			}
		}
		Thread.sleep(3000);
		jsx.executeScript("window.scrollBy(0,-200)");
		relationship_tab.click();
		this.contact.sendKeys(contact);
		Thread.sleep(2000);
		communication_tab.click();
		fax_enter.sendKeys(fax_no.trim());
		item_tab.click();
		discount_arrow.click();
		for(int i=0;i<discount_list.size();i++)
		{
			if(discount_list.get(i).getText().trim().equals(discount_item.trim()))
			{
				discount_list.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
	     jsx.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		for(int i=0;i<3;i++)
		{
		Item_arrow.click();
		item_list.click();
		Item_searchbox.sendKeys(items[i]);
		Item_search.click();
		Thread.sleep(10000);
		items_list.get(0).click();
		Thread.sleep(3000);
		Quantity.sendKeys(quantitys[i]);
		Thread.sleep(2000);
		rate_click.get(i).click();
		this.rate.sendKeys(rates[i].trim());
		Amount_click.get(i).click();
		Amount.sendKeys(amounts[i]);
		Thread.sleep(5000);
		add_item.click();
		if(i==2)
		break;
		click_item.get(i+1).click();
		Thread.sleep(2000);
		}
		Actions action=new Actions(driver);
		action.moveToElement(SO_Save).build().perform();
		SO_Save.click();
		wait.until(ExpectedConditions.visibilityOf(id));
		System.out.println("Sales Order "+""+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
		{
			test3.pass("Sales order is created with following data"+"</br>"+"Customer is: "+cus_searchbox+"</br>"+"Sales Rep is: "+sales_rep+"</br>"+"Items are: "+items[0]+", "+items[1]+", "+items[2]+"</br>"+"Location is: "+location+"</br>"+"Amounts are: "+amounts[0]+", "+amounts[1]+", "+amounts[1]+"</br>"+"Rates are: "+rates[0]+", "+rates[1]+", "+rates[2]+"</br>"+"Quantities are: "+quantitys[0]+", "+quantitys[1]+", "+quantitys[2]+"</br>"+"Discount item is: "+discount_item+"</br>"+"contact is: "+contact+"</br>"+"Terms are: "+terms+"</br>"+"Fax number is: "+fax_no+"</br>"+"Shipping cost is: "+shipping_cost+"</br>"+"Shipping Carrier is: "+shipping_carrier.trim()+"</br>"+"Shipping Tax code is: "+shipping_tax_code.trim()+"</br>"+" Payment method is: "+payment_method.trim()+"</br>"+"Shipping method is: "+shipping_method.trim());
			test3.pass("Sales Order "+""+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		}
		else
		{
			test3.fail("Sales Order is not created");
		}
		String subtotal_=sub_total.getText().trim();
		if(after_memo.getText().trim().equals("Sales Order is created successfully"))
		{
			test4.pass("Memo value is sourced correctly after SO submit with: "+after_memo.getText());
		}
		else
		{
			test4.fail("Memo is not sourced correctly");
		}
		jsx.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(3000);
		department1.click();
       if(department1.getText().trim().equals("Accounts"))
       {
    	   test4.pass("Department value field is sourced correctly after SO submit with: "+department1.getText());
       }
       else
       {
    	   test4.fail("Department field is not sourced correctly");
       }
       if(class_from_so.getText().trim().equals("Class-1"))
       {
    	   test4.pass("Class value is sourced correctly after SO submit with: "+class_from_so.getText());
       }
       else
       {
    	   test4.fail("Class value is not sourced correctly");
       }
       if(location_from_so.getText().trim().equals("Banglore"))
       {
    	   test4.pass("Location value is sourced correctly after SO submit with: "+location_from_so.getText());
       }
       else
       {
    	   test4.fail("Location value is not sourced correctly");
       }
	     jsx.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		ExtentTest test5=test.createNode("Validating sum of amount and subtotal value");
		double sub=Double.parseDouble(subtotal_.trim());
		int sub1=(int)sub;
		System.out.println("Subtotal is: "+sub1);
		int values[]=new int[3];
		double amount_in[]=new double[3];
		for(int i=0;i<3;i++)
		{
			amount_in[i]=Double.parseDouble(amounts[i].trim());
			values[i]=(int)amount_in[i];
			System.out.println("Amounts are: "+values[i]);
			
		}
		int count=0;
		for(int i=0;i<inr_amount.size();i++)
		{
		String total=inr_amount.get(i).getText().trim();
		System.out.println(total);
		double total1=Double.parseDouble(total);
		int total2=(int)total1;
		if(sub1+values[i]==total2)
			{
				count=count+1;
			}
		}
		
		if(count==3)
		{
			System.out.println("sum of amount and subotal is correct");
			test5.pass("Sum of Amount and total amount is sourced correctly");
		}
		
		jsx.executeScript("window.scrollTo(0,0)");

		
		
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
	public boolean isAlertPresent() throws InterruptedException
	{
		
		Actions action=new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		if(isAlertPresent_()==true)
		{
		return true;
		}
		else
		{
			
			return false;
		}
	}
	public void validations(String cus_searchbox,String item_searchbox2, String quantity2, String amount2, String testcase, String location2, ExtentTest test, ExtentReports report) throws InterruptedException
	{
		String [] items=new String[3];
		for(int i=0;i<3;i++)
		{
			items=item_searchbox2.split(",");
			System.out.println("Items are: "+items[i]);
		}
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollTo(0,0)");
		so_first_save.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test=report.createTest("Sales Order Field Validations");
			ExtentTest test1=test.createNode("Creating SO without giving data");
			test1.pass("Error message is: "+alert.getText());
			System.out.println("Error message is: "+alert.getText());
			alert.accept();
		}
		else
		{
			test.fail("Error message is not displaying");
		}
		//js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(5000);
		enter_customer.sendKeys(cus_searchbox.trim());
		Thread.sleep(5000);
		action.sendKeys(Keys.TAB).build().perform();
		action.moveToElement(so_first_save).click().build().perform();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			ExtentTest test1=test.createNode("Creating SO with only Customer");
			test1.pass("Error message is: "+alert.getText());
			System.out.println("Error message is: "+alert.getText());
			alert.accept();
		}
		js.executeScript("window.scrollTo(0,0)");
		Item_arrow.click();
		item_list.click();
		Item_searchbox.sendKeys(items[0].trim());
		Item_search.click();
		Thread.sleep(10000);
		items_list.get(0).click();
		Thread.sleep(3000);
		Quantity.sendKeys(quantity2);
		Thread.sleep(2000);
		secondary_so_save.click();
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			ExtentTest test1=test.createNode("Creating SO with customer and item without entering amount");
			test1.pass("Error message is: "+alert.getText());
			System.out.println("Error message is: "+alert.getText());
			alert.accept();
		}
		else
		{
			test.fail("Error message is not displaying");
		}
		
	}
	public void item_shipment(String location,ExtentTest test,ExtentReports report) throws InterruptedException
	{
		String locations[]=new String[3];
		for(int i=0;i<locations.length;i++)
		{
			locations=location.trim().split(",");
			System.out.println("Locations are: "+locations[i]);
		}
		test=report.createTest("Item Shipment Creation");
		SO_Url_before=driver.getCurrentUrl();
		fulfill.click();
		Thread.sleep(3000);
		jsx.executeScript("window.scrollBy(0,500)", "");
		fulfill_save.click();
		ExtentTest test1 = null;
		test1=test.createNode("Item Shipment Field Validations");
		if(isAlertPresent_()==true)
		{
			Alert alert=driver.switchTo().alert();
			test1.pass("Error message is: "+alert.getText());
			alert.accept();
		}
		else
		{
			test1.fail("Alert is not displaying");
		}
		
		for(int i=0;i<3;i++)
		{
			fulfill_checkbox.get(i).click();
//			location_arrow_in_item_shipment.get(i).click();
//			for(int j=0;j<locations_in_shipment.size();j++)
//			{
//				if(locations_in_shipment.get(j).getText().trim().equals(locations[i].trim()))
//				{
//					locations_in_shipment.get(j).click();
//					if(isAlertPresent_()==true)
//					{
//						Alert alert=driver.switchTo().alert();
//						alert.accept();
//					}
//					Thread.sleep(2000);
//					break;
//				}
//			}
			
			 try
			    {
			        @SuppressWarnings("deprecation")
					WebDriverWait wait = new WebDriverWait(driver, 5);
			        wait.until(ExpectedConditions.elementToBeClickable(inventory_detail.get(i)));
			        inventory_detail.get(i).click();
			        driver.switchTo().frame("childdrecord_frame");
					Thread.sleep(3000);
					inventory_ok.click();	
					Thread.sleep(3000);
					}
			    catch (Exception e)
			    {
			    	System.out.println("Element is not clickable");
			    }		
			

		}
		
		fulfill_save.click();
		wait.until(ExpectedConditions.visibilityOf(id));
		System.out.println("Item Shipment "+""+"" +id.getText()+" "+"is created successfully");
		Thread.sleep(5000);
		if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
		{
		test.pass("Item Shipment "+""+"" +id.getText()+" "+"is created successfully");
		}
		else
		{
			test.fail("Item Shipment is not created");
		}
	}

	public void invoice_creation(ExtentTest test,ExtentReports report) throws InterruptedException
	{
		test=report.createTest("Invoice Creation");
		bill.click();
		Thread.sleep(6000);
		action.moveToElement(approval_arrow).build().perform();
		approval_arrow.click();
		approval_status.get(1).click();
		jsx.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		jsx.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(5000);
		communication_tab.click();
		fax_checkbox.click();
		save_invoice.click();
		wait.until(ExpectedConditions.visibilityOf(id));
		System.out.println("Invoice"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		Thread.sleep(10000);
		if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
		{
		test.pass("Invoice"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		}
		else
		{
			test.fail("Invoice is not created");
		}
	}
	
	public void payment_creation(ExtentTest test,ExtentReports report) throws InterruptedException
	{
		test=report.createTest("Payment Creation");
		payment_button.click();
		Thread.sleep(5000);
		account_list.get(1).click();
		account_arrow.click();
		account_select.get(2).click();
		Thread.sleep(3000);
		action.moveToElement(payment_save).build().perform();
		payment_save.click();
		wait.until(ExpectedConditions.visibilityOf(payment_id));
		System.out.println("Payment"+" "+"" +payment_id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		jsx.executeScript("arguments[0].scrollIntoView(true);",invoice_link);
		if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
		{
		test.pass("Payment"+" "+"" +payment_id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
		}
		else
		{
			test.fail("Payment is not created");
		}
	}
	public void return_authorization(ExtentTest test,ExtentReports report) throws InterruptedException
	{
		test=report.createTest("Creating Return Authorization");
			driver.navigate().to(SO_Url_before);
		 	return_button.click();
		 	jsx.executeScript("window.scrollBy(0,500)", "");
		 	communication_tab.click();
		 	fax_checkbox.click();
			jsx.executeScript("window.scrollTo(0,0)");
			Thread.sleep(3000);
			submit_return.click();
			wait.until(ExpectedConditions.visibilityOf(approve_return));
			approve_return.click();
			wait.until(ExpectedConditions.visibilityOf(id));
			System.out.println("Return Authorization"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
			return_auth_url=driver.getCurrentUrl();
			if(SO_confirmation.getText().trim().equals("Return Authorization successfully Approved"))
			{
			test.pass("Return Authorization"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
			}
			else
			{
				test.fail("Return Authorization is not created");
			}
	}
	
	public void item_receipt_creation(ExtentTest test,ExtentReports report) throws InterruptedException
	{
			test=report.createTest("Item Receipt Creation");
			receive.click();
			Thread.sleep(5000);
			jsx.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(5000);
			ExtentTest test1=test.createNode("Item Receipt Field Validataions");
			submit_receive.click();
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				test1.pass("Error message is: "+alert.getText());
				alert.accept();		
			}
			else
			{
				test1.fail("Error message is not displaying");
			}
			action.moveToElement(item_receive.get(0)).build().perform();
			for(int i=0;i<3;i++)
			{
				item_receive.get(i).click();
				
				 try
				    {
				        @SuppressWarnings("deprecation")
						WebDriverWait wait = new WebDriverWait(driver, 5);
				        wait.until(ExpectedConditions.elementToBeClickable(inventory_detail.get(i)));
				        inventory_detail.get(i).click();
				        driver.switchTo().frame("childdrecord_frame");
						Thread.sleep(3000);
						bin_arrow.click();
						bin_list.get(1).click();
						action.sendKeys(Keys.TAB).build().perform();
						bin_quantity.sendKeys("1");
						inventory_ok.click();	
						Thread.sleep(3000);
						}
				    catch (Exception e)
				    {
				    	System.out.println("Element is not clickable");
				    }		
				

			}
			Thread.sleep(6000);
			jsx.executeScript("window.scrollTo(0,0)");
			submit_receive.click();
			System.out.println("Item Receipt"+" "+"" +id.getText()+" "+"is created successfully ");
			Thread.sleep(5000);
			if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
			{
			test.pass("Item Receipt"+" "+"" +id.getText()+" "+"is created successfully");
			}
			else
			{
				test.fail("Item Receipt is not created");
			}
	}
	
	public void credit_memo(ExtentTest test,ExtentReports report) throws InterruptedException
	{
			refund_link.click();
			test=report.createTest("Creating Credit Memo");
			refund_button.click();
			Thread.sleep(5000);
			jsx.executeScript("window.scrollBy(0,500)", "");
			communication_tab.click();
			fax_checkbox.click();
			Thread.sleep(5000);
			jsx.executeScript("window.scrollTo(0,0)", "");
			Thread.sleep(2000);
			submit_refund.click();
			System.out.println("Credit Memo"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
			Thread.sleep(5000);
			if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
			{
			test.pass("Credit Memo"+" "+"" +id.getText()+" "+"is created successfully with"+" " +status.getText()+" "+"status");
			}
			else
			{
				test.fail("Credit memo is not created");
			}
	}
	public void customer_refund(ExtentTest test,ExtentReports report) throws InterruptedException
	{
			test=report.createTest("Customer Refund Creation");
			refund.click();
			Thread.sleep(5000);
			customer_refond_first.click();
			ExtentTest test1=test.createNode("Customer Refund Field Validations");
			if(isAlertPresent_()==true)
			{
				Alert alert=driver.switchTo().alert();
				test1.pass("Error message is: "+alert.getText());
				alert.accept();
			}
			else
			{
				test1.fail("Error message is not displaying");
			}
			jsx.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(2000);
			action.moveToElement(payment).build().perform();
			payment.click();
			payment_arrow.click();
			dropdown_link.get(2).click();
			Thread.sleep(2000);
			action.moveToElement(submit_custrefund).build().perform();
			submit_custrefund.click();
			wait.until(ExpectedConditions.visibilityOf(customer_refund_id));
			System.out.println("Customer refund"+" "+"" +customer_refund_id.getText()+" "+"is created successfully ");
			if(SO_confirmation.getText().trim().equals("Transaction successfully Saved"))
			{
			test.pass("Customer refund"+" "+"" +customer_refund_id.getText()+" "+"is created successfully ");
			}
			else
			{
				test.fail("Customer refund is not created");
			}	
	}
	public void navigating_to_return_auth(ExtentTest test,ExtentReports report)
	{
			test=report.createTest("Verifying Return Authorization Status after returning");
			driver.navigate().to(return_auth_url);
			System.out.println("Return Authorization now"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");	
			test.pass("Return Authorization now"+" "+"" +id.getText()+" "+"is in"+" " +status.getText()+" "+"status");	

	}	
	
}

