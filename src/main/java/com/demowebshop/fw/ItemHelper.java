package com.demowebshop.fw;

import com.demowebshop.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver, WebDriverWait wait) {
       super(driver, wait);
    }

    public void addFirstItemToCart() {
        click(By.xpath("(//h2[@class='product-title']/a)[1]"));
        click(By.cssSelector("input[value='Add to cart']"));
    }

    public String getAddedItemName() {
        click(By.cssSelector("a.ico-cart"));
        return driver.findElement(By.cssSelector(".cart-item-row .product a")).getText();
   }
}








