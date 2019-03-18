package com.nature.core.dsl;

import com.google.common.base.Predicate;
import com.nature.core.DriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WebDriverDsl {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverDsl.class);
    private static final long WAIT_TIMEOUT = 60;

    private static WebDriver driver = DriverManager.getInstance().getDriver();

    private WebDriverDsl() {
    }

    public static void waitForElementToBeVisible(WebElement element) {

        new WebDriverWait(driver, WAIT_TIMEOUT).until((Predicate<WebDriver>) input -> isVisible(element));
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void waitForNewPage(WebElement webElement) {
        waitForElementToBeVisible(webElement);
    }


    public static void fillText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void dropdownByValue(WebElement element, String value) {
        if (value != null) {
            focus(element);
            selectElement(element).selectByValue(value);
        }
    }

    public static void click(WebElement element) {
        element.click();
    }

    public static void clickFromList(List<WebElement> elements, String language) {
        elements.stream().filter(f -> f.getText().contains(language)).findAny().ifPresent(WebElement::click);
    }

    public static boolean isValueExistingInList(List<WebElement> elements, String value) {
        return elements.stream().anyMatch(f -> f.getText().contains(value));
    }


    public static String split(String text) {
        String[] split = text.split(":");
        return split[1].split("\n")[0];
    }


    private static boolean isVisible(WebElement element) {
        boolean retval;

        try {
            retval = element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            LOGGER.debug("Element was not found!", e);
            retval = false;
        }

        return retval;
    }


    private static Select selectElement(WebElement element) {
        focus(element);
        return new Select(element);
    }

    private static void focus(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }


}