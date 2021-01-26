package com.cybertek.tests.locator_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW1_TC3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("selenium webdriver");

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='pure-button pure-button-primary-progressive']"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement searchResult = driver.findElement(By.xpath("//a[@title='Selenium (software)']"));
        searchResult.click();

        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();

        if(currentUrl.endsWith("Selenium_(software)")){

            System.out.println("PASS");
            System.out.println("currentUrl = " + currentUrl);

        }else{
            System.out.println("FAIL");
            System.out.println("currentUrl = " + currentUrl);
        }

        driver.quit();

    }
}
