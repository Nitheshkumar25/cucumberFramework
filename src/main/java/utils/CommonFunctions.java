package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonFunctions {
	static WebDriver driver;
	static XSSFWorkbook workbook;

	static XSSFSheet testSheet;
	static {
		try {
			workbook = new XSSFWorkbook(new File(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx"));
			testSheet= workbook.getSheetAt(0);
		} catch (IOException | InvalidFormatException e) {
			throw new RuntimeException(e);
		}
	}

	public static void typeText(String text, WebElement ele) {
		ele.sendKeys(text);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static <T> void initPageObjects(WebDriver drivers, Class<T> pages) {
		PageFactory.initElements(drivers, pages);

		driver = drivers;

	}
	public static WebElement findElement(int RowNum,int locTypeColNum,int locValueColNum) {
		WebElement foundElement=null;
		String locatorType= String.valueOf(testSheet.getRow(RowNum).getCell(locTypeColNum));
		String locatorValue=String.valueOf(testSheet.getRow(RowNum).getCell(locValueColNum));
		if(locatorType.equalsIgnoreCase("xpath"))
			foundElement= driver.findElement(By.xpath(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			foundElement= driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equalsIgnoreCase("tagName"))
			foundElement= driver.findElement(By.cssSelector(locatorValue));

		return foundElement;
	}
	public static void verifyURL(String url) {
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}

	public static void verifyErrorMessage(String message, WebElement ele) {
		Assert.assertEquals(message, ele.getText());

	}



	public static void waitForSec(int time) throws InterruptedException {
		TimeUnit.SECONDS.sleep(time);
	}

	// scroll down using Dynamic value

	public static void scrollDown(int sec) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,'" + sec + "')");
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
	 	e.printStackTrace();
		}
	}


	public static void assertProduct(String assertData, WebElement ele, String typeOfAssert) {
		if (typeOfAssert.equalsIgnoreCase("value"))
			Assert.assertEquals(assertData, ele.getAttribute("value"));
		else if (typeOfAssert.equalsIgnoreCase("title"))
			Assert.assertEquals(assertData, ele.getAttribute("title"));
		else if (typeOfAssert.equalsIgnoreCase("productText"))
			Assert.assertEquals(assertData, ele.getText());

	}
	private static final Logger logger = null;

	public static Logger setLog(Class<?> className){

		return  LogManager.getLogger(className.getName());

	}
}
