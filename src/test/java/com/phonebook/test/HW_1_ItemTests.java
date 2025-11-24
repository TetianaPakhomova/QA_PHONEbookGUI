package com.phonebook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HW_1_ItemTests extends HW_1_TestBase {

    @BeforeMethod
    public void loginPrecondition() {
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.id("Email")).sendKeys("SS@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Test12345$");
        driver.findElement(By.cssSelector("input.login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.ico-logout")));

        Assert.assertTrue(logoutBtn.isDisplayed());
    }

    @Test
    public void addItemToCartTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='Add to cart'])[2]")));
        addToCartBtn.click();

        WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-cart")));
        cartLink.click();

        WebElement addedItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='cart']//a[@class='product-name']")));
        String expectedItemName = addedItem.getText();

        Assert.assertTrue(expectedItemName.length() > 0);
    }
}

