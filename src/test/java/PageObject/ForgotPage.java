package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Testcases.BasicServer;

public class ForgotPage extends BasicServer{
	
	public ForgotPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Forgot Password?\"]")
	WebElement forgotclick;
	
	@FindBy(xpath= "//android.widget.EditText")
	WebElement inpEmailForg;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Submit\"]")
	WebElement submitbtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please enter your email\"]")
	WebElement forgemailErrMsg;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"josearroyo@demoo.com\"]")
	WebElement forgcorrEmail;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"User Not Registered\"]")
	WebElement toastMsg;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"Enter OTP\"]")
	WebElement inpOTP;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"New Password\"]")
	WebElement newPassword;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"Confirm Password\"]")
	WebElement confirmPass;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\'OTP sent successfully\']")
	WebElement  OTPtoast;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\'Enter OTP\']")
	WebElement inpOTPField;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please enter a valid OTP.\"]")
	WebElement entervalidotp;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"New Password\"]")
	WebElement inpnewpass;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"Confirm Password\"]")
	WebElement confipass;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")
	WebElement newpasseyeTogg;
	
	@FindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView")
	WebElement confpasseyeTogg;
	
	@FindBy(xpath = "(//android.widget.EditText[@text=\"Password@123\"])[1]")
	WebElement invalformatnewPass;
	
	@FindBy(xpath = "(//android.widget.EditText[@text=\"Password@123\"])[1]")
	WebElement invalformatconfPass;
	
	@FindBy(xpath = "(//android.widget.EditText[@text=\"password\"])[2]")
	WebElement passnotMatch;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Back to Login\"]")
	WebElement backToLoginBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"OTP is required\"]")
	WebElement otperrmsg;
	@FindBy(xpath = "//android.widget.TextView[@text=\"New password is required\"]")
	WebElement newpasserrmsg;
	@FindBy(xpath = "//android.widget.TextView[@text=\"Confirm your password\"]")
	WebElement conpasserrmsg;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Password must be at least 10 characters and include letters, numbers, and symbols\"]")
	WebElement invalidpassErrMsg;
	
	public void clickForgot() {
		forgotclick.click();
	}

	public void setIncorrEmail(String email){
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(inpEmailForg));
		element.sendKeys(email);
		
	}
	
	//toast message function firstly we used visibility of toast message and after invisiblity of toast message bt invisibility used different locator xpath
	public String getToastMsg(){
		WebElement element = wait.until(ExpectedConditions.visibilityOf(toastMsg));
		String msg = element.getText().trim();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//android.widget.TextView)[0]")));
		return msg;
	}
	
	public String getOTPMsg(){
		WebElement element = wait.until(ExpectedConditions.visibilityOf(OTPtoast));
		String msg = element.getText().trim();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//android.widget.TextView)[0]")));
		return msg;
	}
	
	public String enterValidOtpToast(){
		WebElement element = wait.until(ExpectedConditions.visibilityOf(entervalidotp));
		String msg = element.getText().trim();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//android.widget.TextView)[0]")));
		return msg;
	}
	
	public void setCorrEmail(String email){
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(forgcorrEmail));
		element.sendKeys(email);
	}
	
	public void submit(){
		submitbtn.click();
	}
	
	public void EmptyFields() {
		submitbtn.click();
	}
	
	public void inpOTP(String otpnum) {
		inpOTPField.sendKeys(otpnum);
	}
	public void inpnewpass(String newpass) {
		inpnewpass.sendKeys(newpass);
	}
	public void inpconfpass(String confpass) {
		confipass.sendKeys(confpass);
	}
	
	public void invFormatNewPass(String newpass) {
		invalformatnewPass.sendKeys(newpass);
	}
	public void invFormatConfPass(String confpass) {
		invalformatconfPass.sendKeys(confpass);
	}
	
	public void passNotMatch(String incorrpass) {
		passnotMatch.sendKeys(incorrpass);
	}
	
	public void ResendBtn() {
		passnotMatch.click();
	}
	
	public void BackLoginbtn() {
		backToLoginBtn.click();
	}
	
	public void newpassEye() {
		newpasseyeTogg.click();
	}
	public void confpassEye() {
		confpasseyeTogg.click();
	}
	public String getErrorMessage() {
		try {
			return (forgemailErrMsg.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
			
	}
	
	public String getOTPErrMsg() {
		
			return (otperrmsg.getText());
	}
	public String getNewpassErrMsg() {
		
		return (newpasserrmsg.getText());
	}
	public String getConpassErrMsg() {
		
		return (conpasserrmsg.getText());
	}
	
	public String getInvalidPassErrMsg() {
		
		return (invalidpassErrMsg.getText());
	}
	
}
