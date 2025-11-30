package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void registerUser(User user) {
        click(By.cssSelector("a.ico-register"));
        //click(By.id("gender-male"));
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
        click(By.id("register-button"));
    }

    public void login(String email, String password) {
        click(By.cssSelector("a.ico-login"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("a.ico-logout"));
    }

    public void logout() {
        if (isLoggedIn()) click(By.cssSelector("a.ico-logout"));
    }

    public String getLoginErrorMessage() {
        return "";
    }
}

