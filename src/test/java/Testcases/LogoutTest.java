package Testcases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LogoutTest extends BasicServer{
	
	public static Logger log = Logger.getLogger(LogoutTest.class);
	
	@Test
	public void Logout() throws InterruptedException
	{
		log.info("Running test: Logout");
		
		Thread.sleep(5000);
		log.debug("Waiting for profile/menu icon to appear");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
//		log.info("again we click menu icon for change password tab");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//com.horcrux.svg.GroupView/com.horcrux.svg.RectView[2]")))
//		.click();
//		
//		log.info("Clicking on change password tab");
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Change Password\"]")))
//		.click();
//		
//		// code for change password
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Update\"]")))
//		.click();
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Current Password\"]")))
//		.sendKeys("Password@1234");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Update\"]")))
//		.click();
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"New Password\"]")))
//		.sendKeys("Password@123");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Update\"]")))
//		.click();
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Confirm Password\"]")))
//		.sendKeys("Password@123");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Update\"]")))
//		.click();
//		
		
		
		log.info("clicking menu btn for logout");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//com.horcrux.svg.GroupView")))
		.click();
		
		log.info("Clicking 'Logout' option");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Logout\"]")))
		.click();
		
		log.info("Clicking 'OK' on confirmation pop-up");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")))
		.click();
		log.info("Logout test completed successfully");
	}
	
}
