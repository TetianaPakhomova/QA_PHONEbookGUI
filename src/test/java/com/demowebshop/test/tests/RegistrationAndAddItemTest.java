package com.demowebshop.test.tests;

import com.demowebshop.models.User;
import com.demowebshop.test.core.MyDataProviders;
import com.demowebshop.test.core.UserData;
import com.demowebshop.test.core.TestBase;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RegistrationAndAddItemTest extends TestBase {

    @Test(dataProvider = "userDataFromCSV", dataProviderClass = MyDataProviders.class)
    public void registerUserAndAddItemToCart(UserData userData) {

        User user = new User(
                userData.getFirstName(),
                userData.getLastName(),
                userData.getEmail(),
                userData.getPassword()
        );
        app.user().registerUser(user);

        app.item().addFirstItemToCart();

        String itemName = app.item().getAddedItemName();
        Assert.assertTrue(itemName.length() > 0);

        app.user().logout();
    }
}