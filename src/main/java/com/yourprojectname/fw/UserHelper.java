package com.yourprojectname.fw;

import com.yourprojectname.core.BaseHelper;
import com.yourprojectname.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void registerUser(User user) {
        click(By.linkText("Register"));
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
        click(By.id("register-button"));
    }

    public void login(String email, String password) {
        click(By.linkText("Log in"));
        type(By.id("Email"), email);
        type(By.id("Password"), password);
        click(By.cssSelector("input.button-1.login-button"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.linkText("Log out"));
    }
}