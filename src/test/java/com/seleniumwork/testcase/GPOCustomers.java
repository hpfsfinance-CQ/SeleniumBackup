package com.seleniumwork.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.seleniumwork.page.GPO.Customers;
import com.seleniumwork.page.GPO.HPEFSHome;
import com.seleniumwork.page.GPO.LoginGPO;
import com.seleniumwork.page.GPO.Phoenix;
import com.seleniumwork.util.DriverFactory;

public class GPOCustomers {

	@Test
	public void createSchedule() throws InterruptedException{
		
		WebDriver driver = DriverFactory.getIEDriver();
	    driver.get("http://g1w6334g.austin.hpecorp.net/portal/server.pt?open=space&name=Login&control=Login&doLogout=&clearsession=true&in_hi_userid=10418&cached=true");//????,??????????? page ??
	    driver.manage().window().maximize();
	    LoginGPO lg=new LoginGPO("\\page-locator-repository.xml",driver,"/login.xls");
		lg.loginGPO();
		Thread.sleep(3000);
		HPEFSHome hpefsHome=new HPEFSHome("\\page-locator-repository.xml", driver, null);
		hpefsHome.goToPhoenix();
		Thread.sleep(3000);
		Phoenix Phoenix = new Phoenix("\\page-locator-repository.xml", driver, null);
		Phoenix.goToCustomers();
		Customers Customers = new Customers("\\page-locator-repository.xml", driver, "/Customers.xls");
		Customers.customersAddNew();
		Thread.sleep(3000);
		Customers.initialCustomers();
	}

}
