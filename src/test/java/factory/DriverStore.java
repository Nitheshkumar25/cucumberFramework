package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverStore {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	

	private static void initBrowserDriver(String browser) {

		switch (browser) {
			case "chrome" -> {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			case "edge" -> {
				WebDriverManager.chromedriver().setup();
				driver = new EdgeDriver();
			}
			case "firefox" -> {
				WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			}
		}

	}

}
