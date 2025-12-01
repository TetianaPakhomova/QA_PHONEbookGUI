//package com.demowebshop.fw;

//import com.demowebshop.core.BaseHelper;
//import com.demowebshop.models.User;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

//public class UserHelper extends BaseHelper {

  //  public UserHelper(WebDriver driver, WebDriverWait wait) {
    //    super(driver, wait);
    //}



    //public boolean registerUser() {
      //  click(By.cssSelector("a.ico-register"));
        //User user = null;
        //type(By.id("FirstName"), user.getFirstName());
        //type(By.id("LastName"), user.getLastName());
        //type(By.id("Email"), user.getEmail());
        //type(By.id("Password"), user.getPassword());
        //type(By.id("ConfirmPassword"), user.getPassword());
        //click(By.id("register-button"));
        //return false;
    //}

    //public void login(String email, String password) {
      //  click(By.cssSelector("a.ico-login"));
        //type(By.id("Email"), email);
        //type(By.id("Password"), password);
        //click(By.cssSelector("input.button-1.login-button"));
    //}

    //public boolean isLoggedIn() {
      //  return isElementPresent(By.cssSelector("a.ico-logout"));
    //}

    //public void logout() {
      //  if (isLoggedIn()) click(By.cssSelector("a.ico-logout"));
    //}

    //public String getLoginErrorMessage() {
     //   return "";
    //
package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserHelper {

    private WebDriver driver;
    private WebDriverWait wait;
    
    public UserHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void registerUser() {
        driver.get("https://demowebshop.tricentis.com/register");
        User user = null;
        driver.findElement(By.id("FirstName")).sendKeys(user.getFirstName());
        driver.findElement(By.id("LastName")).sendKeys(user.getLastName());
        driver.findElement(By.id("Email")).sendKeys(user.getEmail());
        driver.findElement(By.id("Password")).sendKeys(user.getPassword());
        driver.findElement(By.id("ConfirmPassword")).sendKeys(user.getPassword());
        driver.findElement(By.id("register-button")).click();
    }
    
    public boolean isRegistrationSuccessful() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result")));
            return driver.findElement(By.cssSelector(".result"))
                    .getText()
                    .contains("Your registration completed");
        } catch (Exception e) {
            return false;
        }
    }
    
    public void login(User user) {
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.id("Email")).sendKeys(user.getEmail());
        driver.findElement(By.id("Password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector("input.login-button")).click();
    }
    
    public boolean isLoggedIn() {
        return driver.findElements(By.linkText("Log out")).size() > 0;
    }
    
    public void logout() {
        if (isLoggedIn()) {
            driver.findElement(By.linkText("Log out")).click();
        }
    }

    public void login(String userEmail, String password) {
    }

    public String getLoginErrorMessage() {
        return "";
    }

    public boolean isLoginLinkPresent() {
        return false;
    }

    public void clickOnSignOutButton() {
    }
}