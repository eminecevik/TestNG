package com.cybertek.tests.locator_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW1_TC1 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.sendKeys("phone");

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//h1/span[1]"));

        String searchResultText = searchResult.getText();

        System.out.println("Search Result = " + searchResultText);

        driver.quit();


    }
}