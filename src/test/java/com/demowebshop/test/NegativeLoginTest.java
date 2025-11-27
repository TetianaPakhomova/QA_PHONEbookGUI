package com.demowebshop.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    private final String userEmail = "wronguser@gmail.com";
    private final String password = "WrongPass123";

    @BeforeMethod
    public void loginUser(){
        app.user().login(userEmail, password);
    }

    @Test
    public void loginWithInvalidCredentials(){
        Assert.assertFalse(app.user().isLoggedIn());
    }
}

