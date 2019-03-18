package com.nature.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static final DriverManager INSTANCE = new DriverManager();

    private static ThreadLocal<WebDriver> registry = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return INSTANCE;
    }

    public WebDriver getDriver() {
        WebDriver driver = registry.get();

        if (driver == null) {
            driver = new ChromeDriver();
            registry.set(driver);
        }
        return driver;
    }
}