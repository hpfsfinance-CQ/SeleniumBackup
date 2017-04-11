package com.seleniumwork.util;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PopWindows {
	String mainWindow;
	String newWindow="";
	WebDriver driver;
	public PopWindows(WebDriver driver,String mainWindow){
		this.driver = driver;
		this.mainWindow = mainWindow;
	}
	public void switchToNewWindow(){
		//获得所有窗口句柄
		Set<String> handles = driver.getWindowHandles();
		//判断是否为查找窗口，并操作查找窗口上的元素
		System.out.println(handles.size());
		while (handles.size()==1) {
			try {
				Thread.sleep(500);
				handles = driver.getWindowHandles();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(String handle : handles){
			if (handle.equals(mainWindow)==false){
				//切换到查找页面
				this.newWindow = handle;
				driver.switchTo().window(handle);
			}
		}
	}
	public void switchToMainWindow(){
		driver.switchTo().window(mainWindow);
				
	}
	public void closeNewWindow(){
		Set<String> handles = driver.getWindowHandles();
		boolean falg = false;
		for(String handle : handles){
			if (handle.equals(newWindow)==true){
				falg = true;
			}
		}
		if(falg){
			driver.switchTo().window(newWindow).close();
		}
		driver.switchTo().window(mainWindow);
	}
	
}
