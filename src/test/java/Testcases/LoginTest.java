package Testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class LoginTest extends BasicServer {

	public static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage lp;
	
	@BeforeMethod
	public void setupLoginPageObjects() {
		lp = new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void verifyemptyEmail() {
		log.info("* Verifying test case: verifyemptyEmail *");

		lp.setEmail("");
		lp.setPassword(p.getProperty("adminPassword"));
		lp.clickLogin();
		
		String emailmsg = lp.getErrorMessage();
		Assert.assertEquals(emailmsg, p.getProperty("EmailReq"));
		log.info("Actual Emial errmsg:"+emailmsg);
	}
	
	@Test(priority = 2)
	public void verifyemptyPass() {
		log.info("* Verifying test case: verifyemptyPass *");

		lp.setEmail(p.getProperty("adminEmail"));
		lp.passEyebtn();
		lp.emptyPass();
		lp.clickLogin();
		lp.emptyEmail();
		lp.clickLogin();
		
		String passmsg = lp.getErrorMessage1();
		Assert.assertEquals(passmsg, p.getProperty("PassReq"));
		log.info("Actual Pass errmsg:"+passmsg);
	}
	
	
	
}