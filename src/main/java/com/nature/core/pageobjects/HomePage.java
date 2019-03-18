package com.nature.core.pageobjects;

import com.nature.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.nature.core.dsl.WebDriverDsl.*;

public class HomePage {

    private static final String URL = "https://www.nature.com/";
    private static WebDriver driver = DriverManager.getInstance().getDriver();

    @FindBy(id = "login-button")
    private WebElement login;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        openUrl(URL);
        waitForElementToBeVisible(login);
    }

    public void click_login() {
        click(login);
    }


    public HomePage waitForPage() {
        waitForNewPage(login);
        return this;
    }

    public HomePage and() {
        return this;
    }

}