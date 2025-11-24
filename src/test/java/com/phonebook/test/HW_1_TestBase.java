package com.phonebook.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class HW_1_TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final String BASE_URL = "https://demowebshop.tricentis.com/";

    @BeforeMethod
    public void setUp() {
        initDriver();
        openBaseUrl();
        configureBrowser();
    }

    private void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void openBaseUrl() {
        driver.get(BASE_URL);
    }

    private void configureBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
