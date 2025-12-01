package com.demowebshop.test.tests;


import com.demowebshop.fw.ItemHelper;
import com.demowebshop.fw.UserHelper;
import com.demowebshop.models.User;
import com.demowebshop.test.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    private final User testUser = new User(
            "Test", "User",
            "testuser@example.com",
            "Test12345$"
    );

    @BeforeMethod
    public void loginUser() {
        user().login(testUser);
        Assert.assertTrue(user().isLoggedIn());
    }

  public UserHelper user() {
      return null;
  }

    @Test
    public void addItemToCartTest() {
        item().addFirstItemToCart();
        String itemName = item().getAddedItemName();
        Assert.assertTrue(itemName.length() > 0);
    }

    private ItemHelper item() {
        return null;
    }
}
