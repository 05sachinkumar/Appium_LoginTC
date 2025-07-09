package Tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BasicServer {
	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static Logger log = Logger.getLogger(BasicServer.class);
	
	@BeforeSuite
	public void ConfigAppium() throws MalformedURLException, URISyntaxException
	{
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		log.info("Setting up Appium server and driver...");
		
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Sachin Kumar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				 
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("Medium");
				options.setApp("C:\\Users\\Sachin Kumar\\FirstAppium\\src\\test\\resource\\odio-staging1.apk");
				
				driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				log.info("Application started successfully");
	}
	
	@AfterSuite
	public void tearDown()
	{
		log.info("Test suite finished. Tearing down driver and server...");
//		driver.quit();
//		service.stop();
	}
}
