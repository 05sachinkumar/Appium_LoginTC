package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BasicServer;

public class HomePage extends BasicServer{
	public HomePage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.EditText[@text=\'Email\']")
	WebElement inpEmail;

	@FindBy(xpath = "//android.widget.EditText[@text=\'Password\']")
	WebElement inpPass;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Login']")
	WebElement Loginbtn;
	
	public void setEmailPass(String email) {
		inpEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		inpPass.sendKeys(password);
	}
	
	public void clickLogin() {
		Loginbtn.click();
	}
	
}
