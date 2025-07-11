package Testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumLogin {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigAppium() throws MalformedURLException, URISyntaxException
	{

		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Sachin Kumar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				 service.start();
				 
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Medium");
				options.setApp("C:\\Users\\Sachin Kumar\\FirstAppium\\src\\test\\resource\\odio-staging1.apk");
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				System.out.println("application started successfully !!");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
