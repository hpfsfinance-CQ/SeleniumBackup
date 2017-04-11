package com.seleniumwork.util;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.jackson.Log4jJsonObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





public class GetElement {
	WebElement e;
	public GetElement() {
		
	}
	
	/**
	 * 
	* @Title: getElement 
	* @Description: 通过Xpath或cssselector查找webelement
	* @param @param driver
	* @param @param locator webelement对象
	* @param @return
	* @return 返回该webelement，若没查返回null. 
	* @throws
	 */
	public WebElement getElement(WebDriver driver,Locator locator) {
		//WebElement e;
		Log log	= new Log(this.getClass());
		int timeout = locator.getWaitSec();
		
		do  {
			try {
				switch (locator.getBy()) {
				case xpath:
					log.debug("find element By xpath");
					e = driver.findElement(By.xpath(locator.getLoatorvalue()));
					break;
				case id:
					log.debug("find element By id");
					e = driver.findElement(By.id(locator.getLoatorvalue()));
					break;
				case name:
					log.debug("find element By name");
					e = driver.findElement(By.name(locator.getLoatorvalue()));
					break;
				case cssSelector:
					log.debug("find element By cssSelector");
					e = driver.findElement(By.cssSelector(locator.getLoatorvalue()));
					break;
				case className:
					log.debug("find element By className");
					e = driver.findElement(By.className(locator.getLoatorvalue()));
					break;
				case tagName:
					log.debug("find element By tagName");
					e = driver.findElement(By.tagName(locator.getLoatorvalue()));
					break;
				case linkText:
					log.debug("find element By linkText");
					e = driver.findElement(By.linkText(locator.getLoatorvalue()));
					break;
				case partialLinkText:
					log.debug("find element By partialLinkText");
					e = driver.findElement(By.partialLinkText(locator.getLoatorvalue()));
					break;
				default:
					e = driver.findElement(By.id(locator.getLoatorvalue()));
				}
				log.info(locator.getLocatorName()+" is existed ,go on");
				return e;
			} catch (Exception e2) {
				//e2.printStackTrace();
				log.warn(locator.getLocatorName()+" current is not existed ,go on");
				try {
					System.out.println("sleep "+timeout+"*1000 minseconds ");
					Thread.sleep(timeout*1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				timeout+=timeout;
				System.out.println("current  timeout is "+timeout);
			}
		}while(24>timeout);
		log.error("Cannot find the element: "+locator.getClass().getName()+"["+locator.getLocatorName()+"]");
		return null;
	}

}
