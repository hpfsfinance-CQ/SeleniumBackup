package com.seleniumwork.page.GPO;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.seleniumwork.util.BasePage;
import com.seleniumwork.util.DataEngine;
import com.seleniumwork.util.Locator;
import com.seleniumwork.util.SelectElement;


public class Customers extends BasePage {
	Locator customersAddNew = getLocators().get("customersAddNew");
	Locator customersCustomerName = getLocators().get("customersCustomerName");
	Locator customersCurrency = getLocators().get("customersCurrency");
	Locator customersCustomerSupportTeam = getLocators().get("customersCustomerSupportTeam");
	Locator customersLeasingBusinessModel = getLocators().get("customersLeasingBusinessModel");
	Locator customersDocusignReason = getLocators().get("customersDocusignReason");
	Locator customersAdobeReason = getLocators().get("customersAdobeReason");
	Locator customersClientCountry = getLocators().get("customersClientCountry");
	Locator customersRegion = getLocators().get("customersRegion");
	Locator customersLanguage = getLocators().get("customersLanguage");
	Locator customersInvoiceFormat = getLocators().get("customersInvoiceFormat");
	Locator customersInvDestRule = getLocators().get("customersInvDestRule");
	Locator customersMAType = getLocators().get("customersMAType");
	Locator customersLegalEntity = getLocators().get("customersLegalEntity");
	Locator customersMarketSegment = getLocators().get("customersMarketSegment");
	Locator customersProcessSegment = getLocators().get("customersProcessSegment");
	Locator customersCountry = getLocators().get("customersCountry");
	Locator customersStreetAddress = getLocators().get("customersStreetAddress");
	Locator customersCity = getLocators().get("customersCity");
	Locator customersState = getLocators().get("customersState");
	Locator customersMainPhone = getLocators().get("customersMainPhone");
	Locator customersUser = getLocators().get("customersUser");
	Locator customerButtomsSave = getLocators().get("customerButtomsSave");
	Locator customersPostCode = getLocators().get("customersPostCode");
	Locator customersSICCode = getLocators().get("customersSICCode");
	Locator customersLookUp = getLocators().get("customersLookUp");
	Locator customersLookUpSearch = getLocators().get("customersLookUpSearch");
	Locator customersLookUpConfirm = getLocators().get("customersLookUpConfirm");
	Locator customersUserSearch = getLocators().get("customersUserSearch");
	Locator customersUserSelect = getLocators().get("customersUserSelect");
	
	
	/*
	 * get parameter value
	 */
	
	//customersInvoiceFormat
	String strcustomersInvoiceFormat = DataEngine.getValueByRowID(strDataSourcePath,"InvoiceFormat",1);
	String strcustomersMAType = DataEngine.getValueByRowID(strDataSourcePath,"InvoiceFormat",1);
	
	public Customers(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		super(xmlLocatorPath, driver, strDataSourcePath);
	}
	public void customersAddNew(){
		getElement.getElement(driver, customersAddNew).click();
	}
	public void initialCustomers() throws InterruptedException{
		SelectElement selectElement = new SelectElement();
		getElement.getElement(driver, customersCustomerName).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"CustomerName",1));
		selectElement.selectByVisibleText(driver, customersCurrency, DataEngine.getValueByRowID(strDataSourcePath,"Currency",1));
		selectElement.selectByVisibleText(driver, customersLeasingBusinessModel, DataEngine.getValueByRowID(strDataSourcePath,"LeasingBusinessModel",1));
		Thread.sleep(3000);
		selectElement.selectByValue(driver, customersCustomerSupportTeam, DataEngine.getValueByRowID(strDataSourcePath,"CustomerSupportTeam",1));
		selectElement.selectByVisibleText(driver, customersDocusignReason, DataEngine.getValueByRowID(strDataSourcePath,"DocusignReason",1));
		selectElement.selectByVisibleText(driver, customersAdobeReason, DataEngine.getValueByRowID(strDataSourcePath,"AdobeReason",1));
		selectElement.selectByVisibleText(driver, customersClientCountry, DataEngine.getValueByRowID(strDataSourcePath,"ClientCountry",1));
		selectElement.selectByVisibleText(driver, customersRegion, DataEngine.getValueByRowID(strDataSourcePath,"Region",1));
		selectElement.selectByVisibleText(driver, customersLanguage, DataEngine.getValueByRowID(strDataSourcePath,"Language",1));
		Thread.sleep(3000);
		selectElement.selectByValue(driver, customersMAType, DataEngine.getValueByRowID(strDataSourcePath,"MAType",1));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滚动到页面底部
		//获取当前窗口句柄
		String sreach_handle = driver.getWindowHandle();
		System.out.println(sreach_handle);
		getElement.getElement(driver, customersSICCode).click();
		Thread.sleep(5000);
		//获得所有窗口句柄
		Set<String> handles = driver.getWindowHandles();
		//判断是否为查找窗口，并操作查找窗口上的元素
		for(String handle : handles){
			if (handle.equals(sreach_handle)==false){
				//切换到查找页面
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				System.out.println("AAAA");
				Thread.sleep(5000);
				getElement.getElement(driver, customersLookUp).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"LookUp",1));
				getElement.getElement(driver, customersLookUpSearch).click();
				Actions Action = new Actions(driver);
				Action.doubleClick(getElement.getElement(driver, customersLookUpConfirm)).perform();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(sreach_handle);
		selectElement.selectByVisibleText(driver, customersLegalEntity, DataEngine.getValueByRowID(strDataSourcePath,"LegalEntity",1));
		selectElement.selectByVisibleText(driver, customersMarketSegment, DataEngine.getValueByRowID(strDataSourcePath,"MarketSegment",1));
		Thread.sleep(3000);
		selectElement.selectByVisibleText(driver, customersProcessSegment, DataEngine.getValueByRowID(strDataSourcePath,"ProcessSegment",1));
		selectElement.selectByValue(driver, customersInvoiceFormat, DataEngine.getValueByRowID(strDataSourcePath,"InvoiceFormat",1));
		selectElement.selectByVisibleText(driver, customersInvDestRule,DataEngine.getValueByRowID(strDataSourcePath,"InvDestRule",1));
		selectElement.selectByVisibleText(driver, customersCountry, DataEngine.getValueByRowID(strDataSourcePath,"Country",1));
		getElement.getElement(driver, customersCity).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"City",1));
		getElement.getElement(driver, customersStreetAddress).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"StreetAddress",1));
		selectElement.selectByVisibleText(driver, customersState, DataEngine.getValueByRowID(strDataSourcePath,"State",1));
		getElement.getElement(driver, customersPostCode).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"PostCode",1));
		getElement.getElement(driver, customersMainPhone).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"MainPhone",1));
		String current_handle = driver.getWindowHandle();
		getElement.getElement(driver, customersUser).click();
		Thread.sleep(5000);
		Set<String> handles1 = driver.getWindowHandles();
		//判断是否为查找窗口，并操作查找窗口上的元素
		for(String handle : handles1){
			if (handle.equals(current_handle)==false){
				//切换到查找页面
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
				System.out.println("BBB");
				Thread.sleep(5000);
				getElement.getElement(driver, customersUserSearch).click();
				Actions Action = new Actions(driver);
				Action.doubleClick(getElement.getElement(driver, customersUserSelect)).perform();
				Thread.sleep(3000);
			}
		}
		driver.switchTo().window(current_handle);
		
		Actions Action = new Actions(driver);
		Action.doubleClick(getElement.getElement(driver,customerButtomsSave)).perform();
		Thread.sleep(3000);
		
	}
	}
	
