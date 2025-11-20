package com.phonebook.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void isHomeComponentPresentTest() {
       System.out.println("Home Components " + isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent() {
        return driver.findElements(By.xpath("//div[2]//h1")).size()>0;
    }

    @Test
    public void findTenElementsByXPath() {

        WebElement rootDiv = driver.findElement(By.xpath("//div[@id='root']"));
        System.out.println("1. rootDiv tag: " + rootDiv.getTagName());

        WebElement navbarDiv = driver.findElement(By.xpath("//div[contains(@class,'navbar-component_nav')]"));
        System.out.println("2. navbarDiv class: " + navbarDiv.getAttribute("class"));


        WebElement header = driver.findElement(By.xpath("//h1[text()='PHONEBOOK']"));
        System.out.println("3. header text: " + header.getText());


        WebElement homeLink = driver.findElement(By.xpath("//a[@aria-current='page' and text()='HOME']"));
        System.out.println("4. homeLink text: " + homeLink.getText() + ", href: " + homeLink.getAttribute("href"));


        WebElement aboutLink = driver.findElement(By.xpath("//a[text()='ABOUT']"));
        System.out.println("5. aboutLink text: " + aboutLink.getText() + ", href: " + aboutLink.getAttribute("href"));


        WebElement loginLink = driver.findElement(By.xpath("//a[text()='LOGIN']"));
        System.out.println("6. loginLink text: " + loginLink.getText() + ", href: " + loginLink.getAttribute("href"));


        WebElement homeLinkWithStyle = driver.findElement(By.xpath("//a[contains(@style, 'border: 1px solid black')]"));
        System.out.println("7. homeLinkWithStyle text: " + homeLinkWithStyle.getText() + ", style: " + homeLinkWithStyle.getAttribute("style"));


        WebElement firstInnerDiv = driver.findElement(By.xpath("//div[@id='root']/div[2]/div[1]"));
        System.out.println("8. firstInnerDiv tag: " + firstInnerDiv.getTagName());


        WebElement widthDiv = driver.findElement(By.xpath("//div[contains(@style,'width: 50vw')]"));
        System.out.println("9. widthDiv style: " + widthDiv.getAttribute("style"));


        WebElement body = driver.findElement(By.xpath("//body"));
        System.out.println("10. body tag: " + body.getTagName());


    }



}



