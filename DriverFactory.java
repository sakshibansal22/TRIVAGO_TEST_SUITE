package com.trivago;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@Listeners(TestContextUtil.class)
public class DriverFactory {
	/** The log. */
	private static Logger log = LogManager.getLogger(DriverFactory.class);

	public static WebDriver driver;

	@BeforeTest
	public static void beforetest() throws MalformedURLException {

		File f = new File("src/main/java");
		File fs = new File(f, "geckodriver.exe");

		System.setProperty("webdriver.gecko.driver", fs.getAbsolutePath());
		// Create driver
		driver = new FirefoxDriver();
		log.info("Driver has been created");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open Trivago Url
		driver.navigate().to("http://room5.trivago.com/");

		log.info("Redirteced to room5.trivago.com");

	}
}
