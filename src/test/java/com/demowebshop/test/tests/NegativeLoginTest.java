package com.demowebshop.test.tests;

import com.demowebshop.test.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @BeforeMethod
    public void loginUser(){
        String userEmail = "wronguser@gmail.com";
        String password = "WrongPass123";
        user().login(userEmail, password);
    }

    @Test
    public void loginWithInvalidCredentials(){
        TestBase app = null;
        Assert.assertFalse(app.user().isLoggedIn());

        String errorMessage = app.user().getLoginErrorMessage();
        Assert.assertTrue(!errorMessage.isEmpty());
    }
}