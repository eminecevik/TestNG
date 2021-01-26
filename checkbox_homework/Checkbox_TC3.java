package com.cybertek.tests.checkbox_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox_TC3 {

    @Test
    public void test1(){
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2.Go to the website
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        //3.Verify “Check All” button text is “Check All”
        WebElement checkAllButton = driver.findElement(By.id("check1"));

        String actualText = checkAllButton.getAttribute("value");
        //System.out.println("actualText = " + actualText);

        String expectedText = "Check All";
        //System.out.println("expectedText = " + expectedText);

        Assert.assertEquals(actualText, expectedText, "Verify text match");

        //4.Click to “Check All” button
        checkAllButton.click();

        //5.Verify all check boxes are checked
        WebElement isChecked = driver.findElement(By.id("isChkd"));

        String actualIsChecked = isChecked.getAttribute("value");
        //System.out.println("actualIsChecked = " + actualIsChecked);

        String expectedIsChecked = "true";
        //System.out.println("expectedIsChecked = " + expectedIsChecked);

        Assert.assertEquals(actualIsChecked,expectedIsChecked, "Verify all checkboxes checked");

        //6.Verify button text changed to “Uncheck All”

        actualText = checkAllButton.getAttribute("value");
        //System.out.println("actualText = " + actualText);

        expectedText = "Uncheck All";
        //System.out.println("expectedText = " + expectedText);

        Assert.assertEquals(actualText, expectedText, "Verify button text changed");

        driver.quit();

    }
}
