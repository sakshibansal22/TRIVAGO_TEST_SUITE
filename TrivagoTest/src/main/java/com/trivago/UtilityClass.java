package com.trivago;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass extends DriverFactory {

	public static void clickOnLocator(String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Xpath))));

		driver.findElement(By.xpath(Xpath)).click();

	}
	
	public static String getTextOfLocator(String Xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Xpath))));

		return driver.findElement(By.xpath(Xpath)).getText();

	}

}
