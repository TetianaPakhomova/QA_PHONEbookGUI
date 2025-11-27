package com.demowebshop.test;

import com.yourprojectname.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    private String userEmail;
    private final String password = "Test12345$";

    @BeforeMethod
    public void registerAndLoginUser(){
        userEmail = "ss" + System.currentTimeMillis() + "@gmail.com";
        User user = new User("SS", "SS", userEmail, password);
        app.user().registerUser(user);

        app.user().login(userEmail, password);
        Assert.assertTrue(app.user().isLoggedIn());
    }

    @Test
    public void addItemToCartTest(){
        app.item().addFirstItemToCart();
        String itemName = app.item().getAddedItemName();

        Assert.assertTrue(itemName.length() > 0);
    }
}