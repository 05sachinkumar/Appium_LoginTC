package Testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LogoutPage;

public class LogoutTest extends BasicServer{
	
	public static Logger log = Logger.getLogger(LogoutTest.class);
	LogoutPage lp;
	
	@BeforeMethod
	public void setLogoutPageObject() {
		lp = new LogoutPage(driver);
	}
	
	@Test(priority = 1)
	public void VerifyToggleBtn() {
		log.info("** Verify testcase: clicking the Menu toggle btn **");
		lp.menuTogg();
		log.info("menu toggle is opened");
	}
	
	@Test(priority = 2)
	public void VerifyLogout() {
		log.info("** Verify testcase: clicking the logout tab **");
		lp.Logout();
		log.info("Logout pop-up is opened");
		log.info("the page is logout");
	}
}
