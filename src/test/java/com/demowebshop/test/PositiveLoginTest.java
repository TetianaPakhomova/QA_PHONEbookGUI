package com.demowebshop.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    private final String userEmail = "ss12345@gmail.com";
    private final String password = "Test12345$";

    @BeforeMethod
    public void loginUser(){
        app.user().login(userEmail, password);
    }

    @Test
    public void loginAndAddItemToCart(){
        app.item().addFirstItemToCart();
        String itemName = app.item().getAddedItemName();
        Assert.assertTrue(itemName.length() > 0);
    }
}
