package com.phonebook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HW_1_CreateAccountTests extends HW_1_TestBase {


    private By registrationLink = By.cssSelector("[href='/registration']");
    private By nameInput = By.name("name");
    private By lastNameInput = By.name("lastName");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By contactsHeader = By.xpath("//h1[contains(text(),'Contacts')]");

    @Test
    public void registrationPositiveTest() {
        WebDriver driver = null;

        registrationLink.findElement(driver).click();

        driver.findElement(nameInput).sendKeys("TestUser");
        driver.findElement(lastNameInput).sendKeys("Tester");

        driver.findElement(emailInput)
                .sendKeys("user" + System.currentTimeMillis() + "SS@gmail.com");

        driver.findElement(passwordInput).sendKeys("Test12345$");

        driver.findElement(submitButton).click();

        Assert.assertTrue(
                isElementPresent(contactsHeader));

    }

    public boolean isElementPresent(By contactsHeader) {
        return false;
    }
}