package com.yourprojectname.core;

import com.yourprojectname.fw.ItemHelper;
import com.yourprojectname.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ApplicationManager {

    private WebDriver driver;
    private WebDriverWait wait;
    private UserHelper userHelper;
    private ItemHelper itemHelper;
    private String browser;

    private static final String BASE_URL = "https://demowebshop.tricentis.com/";

    public ApplicationManager(String browser){
        this.browser = browser;
    }

    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
        userHelper = new UserHelper(driver, wait);
        itemHelper = new ItemHelper(driver, wait);
    }

    public void stop(){
        if(driver != null){
            driver.quit();
        }
    }

    public UserHelper user() { return userHelper; }
    public ItemHelper item() { return itemHelper; }
    public WebDriver getDriver() { return driver; }
}