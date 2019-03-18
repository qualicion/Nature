package com.nature.functionaltest;

import com.nature.core.pageobjects.HomePage;
import com.nature.core.pageobjects.LoginPage;
import com.nature.core.pageobjects.RegConfirmationPage;
import com.nature.core.pageobjects.RegisterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NatureRegistrationTest {

private HomePage homePage = new HomePage();
private LoginPage loginPage = new LoginPage();
private RegConfirmationPage regConfirmationPage = new RegConfirmationPage();
private RegisterPage registerPage = new RegisterPage();



    @Given("^I am on nature home page$")
    public void i_am_on_nature_home_page() {
        homePage.open();
    }

    @When("^I navigate to the registration page$")
    public void i_navigate_to_the_registration_page()  {
        homePage.waitForPage().and().click_login();
        loginPage.waitForPage().and().register();
    }


    @Then("^I should be able to register with my \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_should_be_able_to_register_with_my(String fname, String lname, String email, String password) {
        registerPage.waitForPage().and().fillForm(fname,lname, email, password);

    }


    @Then("^I should get a confirmation message$")
    public void i_should_get_a_confirmation_message() {
        regConfirmationPage.waitForPage().and().validateConfirmationMessage();
    }
}