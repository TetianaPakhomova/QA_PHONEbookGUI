package com.demowebshop.test;

import com.yourprojectname.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    private final String userEmail = "ss12345@gmail.com";
    private final String password = "Test12345$";

    @BeforeMethod
    public void registerAndLogin(){
        User user = new User("SS","SS", userEmail,password);
        app.user().registerUser(user);
        app.user().login(userEmail, password);
    }

    @Test
    public void createAccountAndPurchaseItem(){
        app.item().addFirstItemToCart();
        String itemName = app.item().getAddedItemName();
        Assert.assertTrue(itemName.length() > 0);
    }
}
