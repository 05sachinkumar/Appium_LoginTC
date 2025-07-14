package Testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.HomePage;

public class HomeTest extends BasicServer{
	
	public static Logger log = Logger.getLogger(HomeTest.class);
	HomePage hp;
	
	@BeforeMethod
	public void setEmailPassObject() {
		hp = new HomePage(driver);
	}
	
	@Test(priority = 1)
	public void verifyLogin() {
		log.info("* Verifying test case: verify Login successfully *");
		hp.setEmailPass(p.getProperty("adminEmail"));
		hp.setPassword(p.getProperty("adminPassword"));
		hp.clickLogin();
	
	}

}