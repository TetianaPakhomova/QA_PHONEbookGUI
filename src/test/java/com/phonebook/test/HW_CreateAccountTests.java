package com.phonebook.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.html.HTMLWriter;

public class HW_CreateAccountTests extends HW_TestBase {

    @Test
    public void registrationPositiveTest() {

        driver.findElement(By.cssSelector("[href='/registration']")).click();

        driver.findElement(By.name("name")).sendKeys("TestUser");

        driver.findElement(By.name("lastName")).sendKeys("Tester");

        driver.findElement(By.name("email"))
                .sendKeys("user" + System.currentTimeMillis() + "SS@gmail.com");

        driver.findElement(By.name("password")).sendKeys("Test12345$");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Contacts')]")));

    }
}

