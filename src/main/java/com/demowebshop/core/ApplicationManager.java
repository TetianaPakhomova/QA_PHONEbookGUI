package com.demowebshop.core;

import com.demowebshop.fw.ItemHelper;
import com.demowebshop.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ApplicationManager {

    private WebDriver driver;
    private WebDriverWait wait;

    private UserHelper userHelper;
    private ItemHelper itemHelper;

    private final String browser;
    private static final String BASE_URL = "https://demowebshop.tricentis.com/";

    public ApplicationManager(String browser){
        this.browser = browser;
    }

    public void init(){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();

        userHelper = new UserHelper(driver, wait);
        itemHelper = new ItemHelper(driver, wait);

        driver.get(BASE_URL);
    }

    public void stop(){
        if(driver != null) driver.quit();
    }

    public UserHelper user(){ return userHelper; }
    public ItemHelper item(){ return itemHelper; }

    public WebDriver getDriver(){ return driver; }

    public void takeScreenshot(String methodName) {

    }

    public Object getUser() {
        return null;
    }
}