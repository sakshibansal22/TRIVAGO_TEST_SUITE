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
	
@Test(dependsOnMethods = { "TC1_VerifyHeaderNameAfterSelectingDestination" },description="Click on home page icon ")
	
	public static void TC1_ClickOnHomePageIcon() {
		
		log.info("Click on home page icon ... Starts ");
		
		
		// Click on HomePage ICOn
		UtilityClass.clickOnLocator(System.getProperty(CommonConstants.HomeIconXapth));
		// Get Header of Article
		String CountryName = UtilityClass.getTextOfLocator(System.getProperty(CommonConstants.ArticleheaderXapth));
		System.out.println(CountryName);
		// verify Header should be same as the destination selcted
		Assert.assertTrue(CountryName.equals("USA"), "Article Header Name is Not Shown Proper");

		log.info("Click on home page icon ... Ends ");

	}
	
@Test(description="Verify Article Header Name After Selecting The Budget")
	
	public static void TC2_VerifyHeaderNameAfterSelectingBudget() {
		
		log.info("Verify Article Header Name After Selecting The Budget ... Starts ");
		

		// Click on the Menu Icon
		UtilityClass.clickOnLocator(System.getProperty(CommonConstants.MenuXpath));
		// Select Buget
		UtilityClass.clickOnLocator(System.getProperty(CommonConstants.BudgetXpath));
		// Get Header of Article
		String HeaderName = UtilityClass.getTextOfLocator(System.getProperty(CommonConstants.ArticleheaderXapth));
		System.out.println(HeaderName);
		// verify Header should be same as the selcted option
		Assert.assertTrue(HeaderName.equals("BUDGET"), "Article Header Name is Not Shown Proper");

		log.info("Verify Article Header Name After Selecting The Budget... Ends ");

	}

@Test(description="Search Destination using search box ")

public static void TC3_SearchDestinationUsingSearchBox() {
	
	log.info("Search Destination using search box ... Starts ");
	

	// Click on the search Icon
	UtilityClass.clickOnLocator(System.getProperty(CommonConstants.ScearchIconXapth));
	// Enter Test
	UtilityClass.enterTextLocator(System.getProperty(CommonConstants.ScearchTextBoxXapth), "USA");
	// Get Header of Article
	String HeaderName = UtilityClass.getTextOfLocator(System.getProperty(CommonConstants.ArticleheaderXapth));
	System.out.println(HeaderName);
	// verify Header should be same as the selcted option
	Assert.assertTrue(HeaderName.equals("CATEGORY"), "Article Header Name is Not Shown Proper");

	log.info("Search Destination using search box.. Ends ");

}


}
