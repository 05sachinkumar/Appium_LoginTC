package Testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	
	public static Properties p;
	public static WebDriverWait wait;
	
	@BeforeSuite
	public void ConfigAppium() throws URISyntaxException, IOException
	{
		FileReader file = new FileReader("C://Users//Sachin Kumar//FirstAppium//src//test//resource//config.properties");
		p = new Properties();
		p.load(file);
		
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
				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
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
