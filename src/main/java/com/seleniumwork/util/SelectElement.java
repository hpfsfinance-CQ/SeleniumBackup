package com.seleniumwork.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement {

	public SelectElement() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 通过文本选择下拉框元素，最长等待时间24秒
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectByText(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		Select select = new Select(new GetElement().getElement(driver, locator));
		Boolean flag;
		Long limitTime =0L;
		do {
			flag = false;
			try {
				select.selectByVisibleText(value);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					limitTime = limitTime+500;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(limitTime<24*1000){
					flag = true;
				}else{
					log.error("Cannot find or select the value: "+locator.getClass().getName()+"["+locator.getLocatorName()+"."+value+"]");
				}
			}
		} while (flag);
	}
	/**
	 * 通过文本选择下拉框元素，最长等待时间24秒
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectByValue(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		Select select = new Select(new GetElement().getElement(driver, locator));
		Boolean flag;
		Long limitTime =0L;
		do {
			flag = false;
			try {
				select.selectByValue(value);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					limitTime = limitTime+500;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(limitTime<24*1000){
					flag = true;
				}else{
					log.error("Cannot find or select the value: "+locator.getClass().getName()+"["+locator.getLocatorName()+"."+value+"]");
				}
			}
		} while (flag);
	}
	/**
	 * 通过文本选择下拉框元素，最长等待时间24秒
	 * @param driver
	 * @param locator
	 * @param value
	 */
	public void selectByVisibleText(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		Select select = new Select(new GetElement().getElement(driver, locator));
		if(select==null){
			System.out.println("select元素是空");
		}
		Boolean flag;
		Long limitTime =0L;
		int i =1;
		do {
			flag = false;
			try {
				System.out.println("prepaer"+i);
				//select = new Select(new GetElement().getElement(driver, locator));
				System.out.println(select.toString());
				select.selectByVisibleText(value);
				System.out.println("select"+i);
			} catch (Exception e) {
				try {
					Thread.sleep(500);
					limitTime = limitTime+500;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(limitTime<24*1000){
					System.out.println(limitTime+"time < 24s");
					flag = true;
				}else{
					log.error("Cannot find or select the value: "+locator.getClass().getName()+"["+locator.getLocatorName()+"."+value+"]");
				}
			}
			i++;
		} while (flag);
	}
	/**
	 * 
	* @Title: OnChange 
	* @Description: 模拟手动运行javascript代码
	* @param @param driver
	* @param @param locator
	* @param @param value javascript代码的名称或文本内容
	* @return void 
	* @throws
	 */
	public void OnChange(WebDriver driver,Locator locator,String value){
		Log log	= new Log(this.getClass());
		//Select select = new Select(new GetElement().getElement(driver, locator));
		((JavascriptExecutor) driver).executeScript(value, new GetElement().getElement(driver, locator));
	}
}
