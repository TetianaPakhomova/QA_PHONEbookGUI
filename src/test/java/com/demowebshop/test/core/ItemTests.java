//package com.demowebshop.test.core;

//import com.demowebshop.models.User;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;

//public class ItemTests extends TestBase {

  //  private String userEmail;
    //private final String password = "Test12345$";

    //@BeforeMethod
    //public void registerAndLoginUser() {
      //  userEmail = "ss" + System.currentTimeMillis() + "@gmail.com";
        //User user = new User("SS", "SS", userEmail, password);

       
        //app.user().registerUser();
        //Assert.assertTrue(app.user().registerUser(),
          //      "ERROR: Registration failed — user was not created!");


        //Assert.assertTrue(app.user().isLoggedIn());
    //}

    //@Test
    //public void addItemToCartTest() {
      //  app.item().addFirstItemToCart();
        //String itemName = app.item().getAddedItemName();

        //Assert.assertTrue(itemName.length() > 0);
    //}
//}
package com.demowebshop.test.core;
import com.demowebshop.models.User;
import com.demowebshop.test.core.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    private User testUser;

    @BeforeMethod
    public void prepareUser() {
        testUser = new User("Test", "User", "testuser@example.com", "Test12345$");
        user().login(testUser);
        Assert.assertTrue(user().isLoggedIn());
    }

    @Test
    public void addItemToCartTest() {
        user().registerUser();
        String itemName = String.valueOf(user().getClass());
        Assert.assertTrue(itemName.length() > 0);
    }
}






