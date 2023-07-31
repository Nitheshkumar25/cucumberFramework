package runner;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.runner.RunWith;

import io.cucumber.plugin.Plugin;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import static factory.DriverStore.driver;
import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions", "myHooks"},tags = "@logFeature",
        publish = true,
        monochrome = true,
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
// plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})


public class TestRunner {

//	plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},

}

