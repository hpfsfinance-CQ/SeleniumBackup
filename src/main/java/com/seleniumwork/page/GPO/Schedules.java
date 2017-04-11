package com.seleniumwork.page.GPO;

import java.lang.annotation.Target;
import java.util.Set;

import org.apache.tools.ant.taskdefs.Input;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import com.seleniumwork.util.BasePage;
import com.seleniumwork.util.DataEngine;
import com.seleniumwork.util.Locator;
import com.seleniumwork.util.PopWindows;
import com.seleniumwork.util.SelectElement;

public class Schedules extends BasePage{
	Locator schedulesAddNew = getLocators().get("schedulesAddNew");
	Locator schedulesDetailsCancel = getLocators().get("schedulesDetailsCancel");
	Locator schedulesDetailsSave = getLocators().get("schedulesDetailsSave");
	Locator schedulesInvDestRule = getLocators().get("schedulesInvDestRule");
	Locator schedulesHPFSLegalEntity = getLocators().get("schedulesHPFSLegalEntity");
	Locator schedulesReceiveInCCY = getLocators().get("schedulesReceiveInCCY");
	Locator schedulesBusinessSubSegement = getLocators().get("schedulesBusinessSubSegement");
	Locator schedulesTerm = getLocators().get("schedulesTerm");
	Locator schedulesSchdeuleType = getLocators().get("schedulesSchdeuleType");
	Locator schedulesRegion = getLocators().get("schedulesTerm");
	Locator schedulesProcessSegment = getLocators().get("schedulesSchdeuleType");
	Locator schedulesFrequency = getLocators().get("schedulesFrequency");
	Locator schedulesAdvance = getLocators().get("schedulesAdvance");
	Locator schedulesTermsAndConditions = getLocators().get("schedulesTermsAndConditions");
	Locator schedulesBillingAddress = getLocators().get("schedulesBillingAddress");
	Locator schedulesOpportunity = getLocators().get("schedulesOpportunity");
	Locator schedulesBillingMethod = getLocators().get("schedulesBillingMethod");
	Locator schedulesInvoiceFormat = getLocators().get("schedulesInvoiceFormat");
	Locator schedulesUPMTermLevel = getLocators().get("schedulesUPMTermLevel");
	Locator schedulesDetailsBtSave = getLocators().get("schedulesDetailsBtSave");
	Locator schedulesAPAStartDate = getLocators().get("schedulesAPAStartDate");
	Locator schedulesAPAExpiryDate = getLocators().get("schedulesAPAExpiryDate");
	Locator schedulesCOF = getLocators().get("schedulesCOF");
	Locator schedulesInterimRent = getLocators().get("schedulesInterimRent");
	Locator schedulesMAXUPMPayment = getLocators().get("schedulesMAXUPMPayment");
	Locator schedulesOpportunityConfirm = getLocators().get("schedulesOpportunityConfirm");
	
	public Schedules(String xmlLocatorPath,WebDriver driver,String strDataSourcePath){
		super(xmlLocatorPath, driver, strDataSourcePath);
	}
	public void schedulesAddNew() {
		getElement.getElement(driver, schedulesAddNew).click();
	}
	public void schedulesDetailsCancel() {
		getElement.getElement(driver, schedulesDetailsCancel).click();			
	}
	public void schedulesDetailsSave() {
		getElement.getElement(driver, schedulesDetailsSave).click();			
	}
	
	//
	
	public void initialScheduledetailes() throws InterruptedException{
		SelectElement selectElement  = new SelectElement();
		selectElement.selectByVisibleText(driver, schedulesInvDestRule, DataEngine.getValueByRowID(strDataSourcePath,"InvDestRule",1));
		selectElement.selectByVisibleText(driver, schedulesHPFSLegalEntity, DataEngine.getValueByRowID(strDataSourcePath,"HPFSLegalEntity",1));
		Thread.sleep(3000);
		selectElement.selectByVisibleText(driver, schedulesReceiveInCCY, DataEngine.getValueByRowID(strDataSourcePath,"ReceiveInCCY",1));
		selectElement.selectByVisibleText(driver, schedulesBusinessSubSegement, DataEngine.getValueByRowID(strDataSourcePath,"BusinessSubSegement",1));
		//region总是报 Element should have been "select" but was "input"
		//new Select(getElement.getElement(driver, schedulesRegion)).selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"Region",1));
		//总是识别不到值text和value都不行
		//new Select(getElement.getElement(driver, schedulesProcessSegment)).selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"ProcessSegment",1));
		getElement.getElement(driver, schedulesTerm).clear();
		getElement.getElement(driver, schedulesTerm).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"Term",1));
		if (DataEngine.getValueByRowID(strDataSourcePath,"APAStartDate",1) != null) {
			getElement.getElement(driver, schedulesAPAStartDate).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"APAStartDate",1));
		}
		if (DataEngine.getValueByRowID(strDataSourcePath,"APAExpiryDate",1) != null) {
			getElement.getElement(driver, schedulesAPAExpiryDate).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"APAExpiryDate",1));
		}
		selectElement.selectByVisibleText(driver, schedulesSchdeuleType, DataEngine.getValueByRowID(strDataSourcePath,"SchdeuleType",1));		
		selectElement.selectByVisibleText(driver, schedulesFrequency, DataEngine.getValueByRowID(strDataSourcePath,"Frequency",1));
		selectElement.selectByVisibleText(driver, schedulesAdvance, DataEngine.getValueByRowID(strDataSourcePath,"Advance",1));
		selectElement.selectByVisibleText(driver, schedulesTermsAndConditions, DataEngine.getValueByRowID(strDataSourcePath,"TermsAndConditions",1));
		/*WebElement target = getElement.getElement(driver, schedulesBillingAddress);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
		Thread.sleep(3000);*/
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//滚动到页面底部
		Thread.sleep(3000);
		if (DataEngine.getValueByRowID(strDataSourcePath,"BillingAddress",1) != null) {
			getElement.getElement(driver, schedulesBillingAddress).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"BillingAddress",1));
		}
		if (DataEngine.getValueByRowID(strDataSourcePath,"COF",1) != null) {
			getElement.getElement(driver, schedulesCOF).clear();
			getElement.getElement(driver, schedulesCOF).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"COF",1));
		}	
		//opportunity字段
		String mainWindow = driver.getWindowHandle();
		System.out.println(mainWindow);		
		getElement.getElement(driver, schedulesOpportunity).click();
//		Thread.sleep(3000);
		PopWindows popWindows =  new PopWindows(driver, mainWindow);
		popWindows.switchToNewWindow();
		Actions Action = new Actions(driver);
		Action.doubleClick(getElement.getElement(driver, schedulesOpportunityConfirm)).perform();
//		popWindows.closeNewWindow();双击后Unable to get browser
/*		//获得所有窗口句柄
//		Set<String> handles = driver.getWindowHandles();
//		//判断是否为查找窗口，并操作查找窗口上的元素
//		for(String handle : handles){
//			if (handle.equals(mainWindow)==false){
//				//切换到查找页面
//				driver.switchTo().window(handle);
//				System.out.println(driver.getTitle());
//				System.out.println("AAAA");
//				Thread.sleep(5000);
//				Actions Action = new Actions(driver);
//				Action.doubleClick(getElement.getElement(driver, schedulesOpportunityConfirm)).perform();
//				Thread.sleep(3000);
//			}
//		}
		Thread.sleep(3000);
//		driver.switchTo().window(mainWindow);*/
		driver.switchTo().window(mainWindow);
		
		selectElement.selectByValue(driver, schedulesBillingMethod, DataEngine.getValueByRowID(strDataSourcePath,"BillingMethod",1));
		Thread.sleep(3000);
		if (DataEngine.getValueByRowID(strDataSourcePath,"InterimRent",1) != null) {
			selectElement.selectByVisibleText(driver, schedulesInterimRent, DataEngine.getValueByRowID(strDataSourcePath,"InterimRent",1));
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		selectElement.selectByVisibleText(driver, schedulesInvoiceFormat, DataEngine.getValueByRowID(strDataSourcePath,"InvoiceFormat",1));
		Thread.sleep(3000);
		selectElement.selectByVisibleText(driver, schedulesUPMTermLevel, DataEngine.getValueByRowID(strDataSourcePath,"UPMTermLevel",1));
		Thread.sleep(3000);
		if (DataEngine.getValueByRowID(strDataSourcePath,"MAXUPMPayment",1) != null) {
			getElement.getElement(driver, schedulesMAXUPMPayment).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"MAXUPMPayment",1));
		}	
		
		
	}
	public void schedulesDetailsBtSave()  {
		getElement.getElement(driver, schedulesDetailsBtSave).click();
		
		try{
			Thread.sleep(3000);
			System.out.println(driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			
		}catch (Exception e) {
			System.out.println("没有alert框");
		}
	}

	/*
	public void schedulesInvDestRule() {
		//getElement.getElement(driver, schedulesInvDestRule).click();
		new Select(getElement.getElement(driver, schedulesInvDestRule)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"InvDestRule",1));
//		System.out.println("xixixi");
//		Select input = getElement.getSelectElement(driver, schedulesInvDestRule);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"InvDestRule",1));
	}
	public void schedulesHPFSLegalEntity() {
//		getElement.getElement(driver, schedulesHPFSLegalEntity).click();
		new Select(getElement.getElement(driver, schedulesHPFSLegalEntity)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"HPFSLegalEntity",1));
//		Select input = getElement.getSelectElement(driver, schedulesHPFSLegalEntity);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"HPFSLegalEntity",1));
	}
	public void schedulesReceiveInCCY() {
//		getElement.getElement(driver, schedulesReceiveInCCY).click();
		new Select(getElement.getElement(driver, schedulesReceiveInCCY)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"ReceiveInCCY",1));
//		Select input = getElement.getSelectElement(driver, schedulesReceiveInCCY);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"ReceiveInCCY",1));
	}
	public void schedulesBusinessSubSegement() {
//		getElement.getElement(driver, schedulesBusinessSubSegement).click();
		new Select(getElement.getElement(driver, schedulesBusinessSubSegement)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"BusinessSubSegement",1));
//		Select input = getElement.getSelectElement(driver, schedulesBusinessSubSegement);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"BusinessSubSegement",1));
	}
	public void schedulesRegion() {
//		getElement.getElement(driver, schedulesRegion).click();
		new Select(getElement.getElement(driver, schedulesRegion)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"Region",1));
//		Select input = getElement.getSelectElement(driver, schedulesRegion);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"ProcessRegion",1));
	}
	public void schedulesProcessSegment() {
//		getElement.getElement(driver, schedulesProcessSegment).click();
		new Select(getElement.getElement(driver, schedulesProcessSegment)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"ProcessSegment",1));
//		Select input = getElement.getSelectElement(driver, schedulesProcessSegment);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"ProcessSegment",1));		
	}
	public void schedulesTerm() {
		getElement.getElement(driver, schedulesTerm).clear();
		getElement.getElement(driver, schedulesTerm).sendKeys("1");;			
	}
	public void schedulesSchdeuleType() {
//		getElement.getElement(driver, schedulesSchdeuleType).click();
		new Select(getElement.getElement(driver, schedulesSchdeuleType)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"SchdeuleType",1));
//		Select input = getElement.getSelectElement(driver, schedulesSchdeuleType);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"SchdeuleType",1));
	}
	public void schedulesFrequency() {
//		getElement.getElement(driver, schedulesFrequency).click();
		new Select(getElement.getElement(driver, schedulesFrequency)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"Frequency",1));
//		Select input = getElement.getSelectElement(driver, schedulesFrequency);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"Frequency",1));
	}
	public void schedulesAdvance() {
//		getElement.getElement(driver, schedulesAdvance).click();
		new Select(getElement.getElement(driver, schedulesAdvance)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"Advance",1));
//		Select input = getElement.getSelectElement(driver, schedulesAdvance);
//		input.selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"Advance",1));
	}
	public void schedulesTermsAndConditions() {
//		getElement.getElement(driver, schedulesTermsAndConditions).click();	
		new Select(getElement.getElement(driver, schedulesTermsAndConditions)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"TermsAndConditions",1));
	}
	public void schedulesBillingAddress() throws InterruptedException {
		WebElement target = getElement.getElement(driver, schedulesBillingAddress);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
		Thread.sleep(3000);
		getElement.getElement(driver, schedulesBillingAddress).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"BillingAddress",1));
//		new Select(getElement.getElement(driver, schedulesBillingAddress)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"BillingAddress",1));
	}
	public void schedulesOpportunity() {
		getElement.getElement(driver, schedulesOpportunity).sendKeys(DataEngine.getValueByRowID(strDataSourcePath,"Opportunity",1));
//		new Select(getElement.getElement(driver, schedulesOpportunity)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"Opportunity",1));
	}
	public void schedulesBillingMethod() throws InterruptedException {
		WebElement target = getElement.getElement(driver, schedulesBillingMethod);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
		Thread.sleep(3000);
//		getElement.getElement(driver, schedulesBillingMethod).click();
		new Select(getElement.getElement(driver, schedulesBillingMethod)).selectByValue(DataEngine.getValueByRowID(strDataSourcePath,"BillingMethod",1));;
	}
	public void schedulesInvoiceFormat() {
//		getElement.getElement(driver, schedulesInvoiceFormat).click();
		new Select(getElement.getElement(driver, schedulesInvoiceFormat)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"InvoiceFormat",1));
	}
	public void schedulesUPMTermLevel() throws InterruptedException {
		WebElement target = getElement.getElement(driver, schedulesUPMTermLevel);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", target);
		Thread.sleep(3000);
//		getElement.getElement(driver, schedulesUPMTermLevel).click();
		new Select(getElement.getElement(driver, schedulesUPMTermLevel)).selectByVisibleText(DataEngine.getValueByRowID(strDataSourcePath,"UPMTermLevel",1));
	}
	*/
	
}
