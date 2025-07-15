package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testcases.BasicServer;

public class LogoutPage extends BasicServer{
	
	public LogoutPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//com.horcrux.svg.GroupView")
	WebElement MenuToggle;
	
	@FindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
	WebElement logoutbtn;
	
	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	WebElement confirmbtn;
	
	public void menuTogg() {
		MenuToggle.click();
	}
	
	public void Logout() {
		logoutbtn.click();
		confirmbtn.click();
	}
	
}
