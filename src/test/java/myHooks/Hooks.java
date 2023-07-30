package myHooks;

import static factory.DriverStore.driver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.common.io.Files;
import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import factory.DriverStore;

import static utils.ConfigReader.*;
import static utils.CommonFunctions.*;
import static utils.Constants.*;
public class Hooks {
	@BeforeAll
	public static void setup() {
//accessing private method using reflection api
		try {
			ReadProp(PROPERTY_FILE_PATH);
			Method method;
			method = DriverStore.class.getDeclaredMethod("initBrowserDriver", String.class);
			method.setAccessible(true);
			method.invoke(method, prop.getProperty("browser"));
			initPageObjects(driver,  pageObjects.LoginPage.class);
			initPageObjects(driver, pageObjects.SearchPage.class);
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Before
	public void precondition() {

		WebElement myaccount = driver.findElement(By.xpath("//span[text()='My Account']"));
		myaccount.click();
		WebElement logIn = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		logIn.click();
	}
	@After
	public static void writeExtentReport(Scenario scenario) throws IOException {

		String scenarioName = scenario.getName().replaceAll(" ","_");

		if(scenario.getName().contains("correct Product name")) {

			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", scenario.getName());

		}
		//add logs to report
		ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "Test PASSed:"+scenarioName);

		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MarkupHelper.createLabel("Test PASSed:"+scenarioName, ExtentColor.GREEN));

	}
	@AfterStep
	public void captureStepLogs(Scenario scenario){
	}
}