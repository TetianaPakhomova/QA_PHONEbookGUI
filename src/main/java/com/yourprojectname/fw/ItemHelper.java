package com.yourprojectname.fw;

import com.yourprojectname.core.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void addFirstItemToCart(){
        click(By.cssSelector(".product-item:first-child .product-title a"));
        click(By.cssSelector("input[value='Add to cart']"));
    }

    public String getAddedItemName(){
        return getText(By.cssSelector(".cart-item-row .product-name a"));
    }
}