package com.cybertek.tests.checkbox_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox_TC2 {

    @Test
    public void test1(){
        //1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2.Go to the website
        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox = driver.findElement(By.xpath("//input[@*='isAgeSelected']"));

        WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));

        //Verify checkbox is not selected
        Assert.assertFalse(checkbox.isSelected());
        Assert.assertFalse(message.isDisplayed(), "Success – Check box is checked” message is NOT displayed.");
        System.out.println("message.getText() = " + message.getText());

        //4.Click to checkbox
        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());


        //5.Verify “Success – Check box is checked” message is displayed.
        Assert.assertTrue(message.isDisplayed(), "Success – Check box is checked");
        System.out.println("message.getText() = " + message.getText());

        driver.quit();

    }
}
