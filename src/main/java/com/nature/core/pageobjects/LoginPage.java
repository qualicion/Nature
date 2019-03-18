package com.nature.core.pageobjects;

import com.nature.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.nature.core.dsl.WebDriverDsl.click;
import static com.nature.core.dsl.WebDriverDsl.waitForNewPage;


public class LoginPage {
    private static WebDriver driver = DriverManager.getInstance().getDriver();

    @FindBy(css = ".mb30 a.general-button.inline-block.grid-4")
    private WebElement register_now;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage waitForPage() {
        waitForNewPage(register_now);
        return this;
    }

    public void register() {
        click(register_now);
    }

    public LoginPage and() {
        return this;
    }
}