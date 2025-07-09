package Tests;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChangePassTest extends BasicServer{

	public static Logger log = Logger.getLogger(ChangePassTest.class);
	
   private final By currpassfield = By.xpath("//android.widget.EditText[@text=\"Current Password\"]");
   private final By updatebtn = By.xpath("//android.widget.TextView[@text=\"Update\"]");
   private final By newpasswdfield = By.xpath("//android.widget.EditText[@text=\"New Password\"]");
   private final By confirmpasswd = By.xpath("//android.widget.EditText[@text=\"Confirm Password\"]");
   private final By currpasseyetogg = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.ImageView");
   private final By newpasseyetogg = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.widget.ImageView");
   private final By confirmpasseye = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[9]/android.widget.ImageView");
   private final By invalidcurrpass = By.xpath("//android.widget.EditText[@text=\"Password@1234\"]");
   private final By newpasspresent = By.xpath("(//android.widget.EditText[@text=\"Password@123\"])[1]");
   private final By confirpasspresent = By.xpath("//android.widget.EditText[@text=\"Password@123\"]");
   private final By currpassfield1 = By.xpath("//android.widget.EditText[@text=\"Password@1234\"]");
   private final By invalidcurrpass1 = By.xpath("//android.widget.EditText[@text=\"Password1234\"]");
   
	@Test
	public void ChangePass() throws InterruptedException
	{
		log.info("again we click menu icon for change password tab");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//com.horcrux.svg.GroupView/com.horcrux.svg.RectView[2]")))
		.click();
		
		log.info("Clicking on change password tab");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Change Password\"]")))
		.click();
		
		// for empty fields
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
		
		// for Wrong current password
		wait.until(ExpectedConditions.presenceOfElementLocated(currpassfield)).sendKeys("Password@1234");
		wait.until(ExpectedConditions.elementToBeClickable(currpasseyetogg)).click();
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(newpasswdfield)).sendKeys("Password@123");
		wait.until(ExpectedConditions.elementToBeClickable(newpasseyetogg)).click();
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(confirmpasswd)).sendKeys("Password@123");
		wait.until(ExpectedConditions.elementToBeClickable(confirmpasseye)).click();
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
		Thread.sleep(5000);
		
		// for invalid format of current password
		wait.until(ExpectedConditions.presenceOfElementLocated(invalidcurrpass)).sendKeys("Password1234");
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
		
		// for wrong format of New and Confirm password
		wait.until(ExpectedConditions.presenceOfElementLocated(invalidcurrpass1)).sendKeys("Password@12345");
		wait.until(ExpectedConditions.presenceOfElementLocated(newpasspresent)).sendKeys("password");
		wait.until(ExpectedConditions.presenceOfElementLocated(confirpasspresent)).sendKeys("password");
		
		wait.until(ExpectedConditions.elementToBeClickable(updatebtn)).click();
	}
}
