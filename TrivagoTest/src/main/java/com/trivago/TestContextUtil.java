
package com.trivago;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

public class TestContextUtil extends DriverFactory implements ITestListener, IReporter {


	private final String testConfigFile="testconfig.properties";
	private static Logger log=LogManager.getLogger(TestContextUtil.class);
	protected PrintWriter writer;

    
    

	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		Object currentClass=result.getInstance();
		
		if (result.getStatus() == ITestResult.FAILURE) {
			File file = new File("");
			Date date =new Date();
			Reporter.setCurrentTestResult(result);
			log.info(file.getAbsolutePath());
			Reporter.log(file.getAbsolutePath());
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(file.getAbsolutePath() + "/reports/" + date.toString()
						+ "/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reporter.setCurrentTestResult(result);
			Reporter.log("<a href='" + file.getAbsolutePath() + "/reports/" + "/"
					+ result.getName() + ".jpg'> <img src='" + file.getAbsolutePath() + "/reports/"
					+ "/" + result.getName()
					+ ".jpg' height='100' width='100'>click to open the link</a>");
			
			
			Reporter.setCurrentTestResult(null);
		}
	

		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onStart(ITestContext context) {
		// read all the properties from the testconfig.properties
		// Set them as System properties
		Properties properties = readTestProperties();
		for (Object key : properties.keySet()) {
			log.info(key.toString() + " : " + properties.get(key).toString());
			context.setAttribute(key.toString(), properties.get(key).toString());
			setPropertyIfNotExist(key.toString(), properties.get(key)
					.toString());
		}
	}

	private void setPropertyIfNotExist(String key, String value) {
		Properties properties = System.getProperties();
		if (properties.getProperty(key) == null) {
			properties.setProperty(key, value);
		} else {
			log.info("Property "
					+ key
					+ " : "
					+ value
					+ " found externally. Not setting from testconfig.properties");
		}
	}

	private Properties readTestProperties() {
		Properties properties = null;
		String testConfig = System.getProperty("test.config");
		try {
			if (StringUtils.isBlank(testConfig)) {
				testConfig = testConfigFile;
			}
			if ((properties = FileUtil.readFileFromExternalPath(testConfig)) == null) {
				properties = FileUtil.readFileAsProperties(testConfig);
			}
		} catch (Exception e) {
			log.error("Failed to load test properties file " + testConfig);
			e.printStackTrace();
		}
		return properties;
	}


	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	
	

}
