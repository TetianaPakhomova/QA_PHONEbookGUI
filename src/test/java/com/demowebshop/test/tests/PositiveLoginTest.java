package com.demowebshop.test.tests;

import com.demowebshop.core.ApplicationManager;
import com.demowebshop.models.User;
import com.demowebshop.test.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    private final String password = "Test12345$";

    @BeforeMethod
    public void loginUser(){
        String userEmail = "test" + System.currentTimeMillis() + "@gmail.com";
        User user = new User("SS","SS", userEmail,password);

        TestBase app = null;
        app.user().registerUser();
        Assert.assertTrue(app.user().isLoggedIn());

        app.user().logout();
        app.user().login(userEmail,password);
        Assert.assertTrue(app.user().isLoggedIn());
    }

    @Test
    public void loginAddItemToCart(){
        ApplicationManager app = null;
        app.item().addFirstItemToCart();
        String itemName = app.item().getAddedItemName();
        Assert.assertTrue(itemName.length() > 0);
    }
}