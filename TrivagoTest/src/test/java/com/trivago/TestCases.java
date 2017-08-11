package com.trivago;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(TestContextUtil.class)

public class TestCases extends DriverFactory {
	/** The log. */
	private static Logger log = LogManager.getLogger(TestCases.class);

	@Test(description="Verify Article Header Name After Selecting The Destination")
	
	public static void TC1_VerifyHeaderNameAfterSelectingDestination() {
		
		log.info("Verify Article Header Name After Selecting The Destination ... Starts ");
		double i=21.2%10;
		log.info(i);

		// Click on the Menu Icon
		UtilityClass.clickOnLocator(System.getProperty(CommonConstants.MenuXpath));
		// Select Destination "USA"
		UtilityClass.clickOnLocator(System.getProperty(CommonConstants.USADestinationXpath));
		// Get Header of Article
		String CountryName = UtilityClass.getTextOfLocator(System.getProperty(CommonConstants.ArticleheaderXapth));
		System.out.println(CountryName);
		// verify Header should be same as the destination selcted
		Assert.assertTrue(CountryName.equals("USA"), "Article Header Name is Not Shown Proper");

		log.info("Verify Article Header Name After Selecting The Destination ... Ends ");

	}

}
