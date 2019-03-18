package com.nature.functionaltest;

import com.nature.core.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = "@register"
)


public class CucumberRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver = DriverManager.getInstance().getDriver();

    @Before
    @BeforeTest
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    @AfterTest
    public static void close() {
        driver.close();
        driver.quit();
    }
}