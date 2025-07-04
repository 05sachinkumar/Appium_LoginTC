package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest extends BasicServer {
//	 @Test
//	 public void setUpAppium() throws MalformedURLException, URISyntaxException {
//	        // Explicitly initialize the Appium driver
//	      ConfigAppium();
//	 }
	@Test
	public void InvalidEmail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Email\"]")))
				.sendKeys("jossearroyo@demo.com");
		
		driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("Password@12345");
		// driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Login']")))
				.click();
	}

	@Test
	public void InvalidPass() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\'jossearroyo@demo.com\']")))
				.sendKeys("josearroyo@demo.com");
			
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\'Password@12345\']")))
				.sendKeys("Password@1234");
		
		WebElement loginbtn = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Login']")));
		loginbtn.click();
	}
	
	@Test
	public void Login()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"josearroyo@demo.com\"]")))
				.sendKeys("josearroyo@demo.com");
			
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//android.widget.EditText[@text=\"Password@1234\"]")))
				.sendKeys("Password@12345");
		
		WebElement loginbtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Login\"]")));
		loginbtn.click();
	}
	
}