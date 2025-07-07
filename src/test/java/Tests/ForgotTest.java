package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
	
public class ForgotTest extends BasicServer{
	
	@Test
	public void forgotPass() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\'Forgot Password?\']")))
		.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Please enter your registered email\"]")))
		.sendKeys("jossearroyo@demo.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Back to Login\"]")))
		.click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Forgot Password?\"]")))
		.click();	
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Please enter your registered email\"]")))
		.sendKeys("josearroyo@demo.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\'Enter OTP\']"))).sendKeys("12345");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"New Password\"]"))).sendKeys("Password@1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Confirm Password\"]"))).sendKeys("password@1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"password@1234\"]"))).sendKeys("Password@1234");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Submit\"]")))
		.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Back to Login\"]")))
		.click();
	}
	
	  // Common locators
//    private final By forgotPasswordBtn = By.xpath("//android.widget.TextView[@text=\'Forgot Password?\']");
//    private final By emailField = By.xpath("//android.widget.EditText[@text=\'Please enter your registered email\']");
//    private final By submitBtn = By.xpath("//android.view.ViewGroup[@content-desc=\'Submit\']");
//    private final By backToLoginBtn = By.xpath("//android.widget.TextView[@text=\'Back to Login\']");
//    private final By emptysubmit = By.xpath("//android.widget.TextView[@text=\"Submit\"]");
//    private final By otpField = By.xpath("//android.widget.EditText[@text=\'Enter OTP\']");
//
//    @Test
//    public void forgotPass() throws InterruptedException 
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//        // First forgot password attempt
//        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordBtn)).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(emailField)).sendKeys("jossearroyo@demo.com");
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
//
//        // Go back to login screen
//        wait.until(ExpectedConditions.elementToBeClickable(backToLoginBtn)).click();
//
//        // Second forgot password attempt
//        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordBtn)).click();
//        wait.until(ExpectedConditions.presenceOfElementLocated(emailField)).sendKeys("josearroyo@demo.com");
//        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
//        Thread.sleep(5000);
//    }
//
//    @Test
//    public void EmptyFields() 
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Ensure the Submit button is clickable without entering data
//        wait.until(ExpectedConditions.presenceOfElementLocated(emptysubmit));
//        wait.until(ExpectedConditions.elementToBeClickable(emptysubmit)).click();
//    }
//
//    @Test
//    public void EnterOTP() 
//    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        // Enter OTP and click submit
//        wait.until(ExpectedConditions.presenceOfElementLocated(otpField)).sendKeys("12345");
//        wait.until(ExpectedConditions.elementToBeClickable(emptysubmit)).click();
//    }
}
