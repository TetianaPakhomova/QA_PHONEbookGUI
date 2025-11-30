package com.demowebshop.test.tests;

import com.demowebshop.models.User;
import com.demowebshop.test.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    private String userEmail;
    private final String password = "Test12345$";

    @BeforeMethod
    public void prepareUserData(){
        userEmail = "user" + System.currentTimeMillis() + "@gmail.com";
    }

    @Test
    public void createAccountSuccessfully(){
        User user = new User("John", "Doe", userEmail, password);
        app.user().registerUser(user);

        Assert.assertTrue(app.user().isLoggedIn());

       // app.user().logout();
       // Assert.assertFalse(app.user().isLoggedIn());
    }
}