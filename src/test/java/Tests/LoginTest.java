package Tests;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest extends BasicServer {

	public static Logger log = Logger.getLogger(LoginTest.class);
	
	@Test
	public void InvalidEmail() 
	{
		log.info("Running test: InvalidEmail");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Email\"]")))
				.sendKeys("jossearroyo@demo.com");
		log.info("Entered invalid email");
		
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("password");
		log.info("Entered password");
		log.info("Clicking login button");
		// driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Login']")))
		.click();
		log.info("InvalidEmail test completed");
	}

	@Test
	public void InvalidPass() throws InterruptedException 
	{
		log.info("Running test: InvalidPass");
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\'jossearroyo@demo.com\']")))
				.sendKeys("josearroyo@demo.com");
		
		log.info("Clicking eye toggle visibility");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.ImageView")))
				.click();
		
		log.info("Entered invalid password");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\'password\']")))
				.sendKeys("Password@1234");
		
		WebElement loginbtn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Login']")));
				loginbtn.click();
		log.info("InvalidPass test completed");
	}

	@Test
	public void Login()
	{
		log.info("Running test: Login");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		log.info("Entered email");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"josearroyo@demo.com\"]")))
				.sendKeys("josearroyo@demo.com");
			
		log.info("Entered password");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Password@1234\"]")))
				.sendKeys("password");
		
		log.info("Clicking Login button");
		WebElement loginbtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]")));
				loginbtn.click();
		log.info("Login test completed");
	}
	
}