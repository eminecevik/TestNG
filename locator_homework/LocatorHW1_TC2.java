package com.cybertek.tests.locator_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW1_TC2 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        String title = driver.getTitle();

        String expectedTitle = "Selenium";

        if(title.contains(expectedTitle)){
            System.out.println("PASS");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("title = " + title);
        }else{
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("title = " + title);
        }

        driver.quit();
    }
    }
