package com.nature.core.pageobjects;

import com.nature.core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.nature.core.dsl.WebDriverDsl.click;
import static com.nature.core.dsl.WebDriverDsl.fillText;
import static com.nature.core.dsl.WebDriverDsl.waitForNewPage;

public class RegisterPage {
    private static WebDriver driver = DriverManager.getInstance().getDriver();

    @FindBy(id = "registration-first-name")
    private WebElement first_name;

    @FindBy(id = "registration-last-name")
    private WebElement last_name;

    @FindBy(id = "registration-password")
    private WebElement reg_password;

    @FindBy(id = "registration-email")
    private WebElement reg_email;

    @FindBy(id = "registration-password-confirm")
    private WebElement password_confirm;

    @FindBy(id = "registration-terms-conditions")
    private WebElement terms_and_condition;

    @FindBy(id = "registration-submit")
    private WebElement submit;



    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }



    public RegisterPage waitForPage() {
        waitForNewPage(reg_email);
        return this;
    }


    public void fillForm(String fname, String lname, String email, String password) {
        fillText(first_name, fname);
        fillText(last_name, lname);
        fillText(reg_email, email);
        fillText(reg_password, password);
        fillText(password_confirm, password);
        click(terms_and_condition);
        click(submit);
    }


    public RegisterPage and() {
        return this;
    }
}