package Testcases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.ForgotPage;
	
public class ForgotTest extends BasicServer{
	public static Logger log = Logger.getLogger(ForgotTest.class);
	ForgotPage fp;
	
	@BeforeMethod
	public void setupLoginPageObjects() {
		fp = new ForgotPage(driver);
	}
	
	
	@Test(priority = 1)
	public void verifyemptyEmail() {
		log.info("* Verifying test case: verifyEmptyEmail *");
		fp.clickForgot();
		fp.submit();
		
		String emailmsg = fp.getErrorMessage();
		Assert.assertEquals(emailmsg, p.getProperty("forgEmailReq"));
		log.info("Actual Emial errmsg for Forgotpass:"+emailmsg);
	}

	@Test(priority = 2)
	public void verifyIncorrEmail() {
		log.info("* Verifying test case: verifyIncorrEmail *");
		fp.setIncorrEmail(p.getProperty("forgwrongEmail"));
		fp.submit();
		
		String actToastMsg = fp.getToastMsg();
		Assert.assertEquals(actToastMsg, p.getProperty("toastText"));
		log.info("Actual Toast Message is: "+actToastMsg);
		log.info("the OTP form opened");
		
		
	}
	
	@Test(priority = 3)
	public void verifyCorrEmail() {
		log.info("* Verifying test case: verifyCorrEmail *");
		fp.setIncorrEmail(p.getProperty("adminEmail"));
		fp.submit();
		
		String actOTPtoast = fp.getOTPMsg();
		Assert.assertEquals(actOTPtoast, p.getProperty("otpText"));
		log.info("Actual Toast Message is: "+actOTPtoast);
		log.info("Toast OTP message is printed");
	}
	
	@Test(priority = 4)
	public void verifyEmptyOtpForm() {
		log.info("* Verifying test case: VerifyEmptyOTP Feids *");
		fp.EmptyFields();
	}
	
	@Test(priority = 5)
	public void verifyEnterValidOtp() {
		log.info("* Verifying test case: VerifyEnternValid OTP *");
		fp.inpOTP(p.getProperty("otp"));
		fp.inpnewpass(p.getProperty("newpassText"));
		fp.newpassEye();
		fp.inpconfpass(p.getProperty("confpassText"));
		fp.confpassEye();
		fp.submit();
		
		String actentervalidOTP = fp.enterValidOtpToast();
		Assert.assertEquals(actentervalidOTP, p.getProperty("entervalidotpText"));
		log.info("Actual Toast Message for Enter Valid OTPis: "+actentervalidOTP);
		log.info("Toast msg enter valid otp is printed");
	}
	
	@Test(priority = 6)
	public void verifyInvalidFormatPass() {
		log.info("* Verifying test case: VerifyInvalidFormat New and Confirm Password *");
		fp.invFormatNewPass(p.getProperty("invalidnewpassText"));
		fp.invFormatConfPass(p.getProperty("invalidnewconfpassText"));
		fp.submit();
	}
	
	@Test(priority = 7)
	public void VerifyPassNotMatch() {
		log.info("* Verifying test case: Verify New and Confirm Password Do not Match*");
		fp.passNotMatch(p.getProperty("incorrpassText"));
		fp.submit();
		log.info("New and Confirm Password does not match");
	}

	
}

