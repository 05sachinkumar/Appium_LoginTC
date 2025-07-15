package Testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.ProfilePage;

public class ProfileTest extends BasicServer{
	
	public static Logger log = Logger.getLogger(ProfileTest.class);
	ProfilePage pp;
	
	@BeforeMethod
	public void setupForgotPageObjects() {
		pp = new ProfilePage(driver);
	}
	
	@Test(priority = 1)
	public void verifyMenuClick() {
		log.info("Verify Testcase: Click Menu toggle for ProfilePage");
		pp.menuClick();
		log.info("Menu Toggle is Clicked");
	}
	
	@Test(priority = 2)
	public void verifyProfileClick() {
		log.info("Verify Testcase: Clicking on profile page");
		pp.profileClick();
		log.info("Profile page is opened");
	}
}
