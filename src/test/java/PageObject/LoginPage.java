package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BasicServer;

public class LoginPage extends BasicServer{
	
	public LoginPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"Email\"]")
	WebElement inpEmail;

	@FindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
	WebElement inpPass;

	@FindBy(xpath = "//android.widget.TextView[@text='Login']")
	WebElement Loginbtn;
	
	@FindBy(xpath= "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")
	WebElement Loginpasseye;

	@FindBy(xpath = "//android.widget.EditText[@text=\"password\"]")
	WebElement clearpass;
	
	@FindBy(xpath = "//android.widget.EditText[@text=\"josearroyo@demo.com\"]")
	WebElement clearemail;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please enter your email\"]")
	WebElement emailErrMsg;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Please enter your password\"]")
	WebElement passErrMsg;

	
	public void setEmail(String email) {
		inpEmail.clear();
		inpEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		inpPass.clear();
		inpPass.sendKeys(password);
	}

	public void clickLogin() {
		Loginbtn.click();
	}
	
	public void passEyebtn()
	{
		Loginpasseye.click();
	}
	
	public void emptyPass()
	{
		clearpass.clear();
	}
	public void emptyEmail()
	{
		clearemail.clear();
	}
	
	public String getErrorMessage() {
		try {
			return (emailErrMsg.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	public String getErrorMessage1() {
		
			return (passErrMsg.getText());
	}
	
}
