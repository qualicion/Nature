package com.nature.core.pageobjects;

import com.nature.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.nature.core.dsl.WebDriverDsl.getText;
import static com.nature.core.dsl.WebDriverDsl.waitForNewPage;

public class RegConfirmationPage {

    private static WebDriver driver = DriverManager.getInstance().getDriver();

    @FindBy(id = "content-heading")
    private WebElement content_heading;

    private static final String MESSAGE = "Thank you for registering at Nature Account, you are almost done.";

    public RegConfirmationPage() {
        PageFactory.initElements(driver, this);
    }

    public RegConfirmationPage waitForPage() {
        waitForNewPage(content_heading);
        return this;
    }


    public void validateConfirmationMessage() {
        Assert.assertEquals(getText(content_heading), MESSAGE,"Registration confirmation message does not match");
    }

    public RegConfirmationPage and() {
        return this;
    }


}