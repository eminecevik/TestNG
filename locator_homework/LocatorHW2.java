package com.cybertek.tests.locator_homework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW2 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        // Locate all the WebElements on the page using XPATH locator only (total of 6)

        WebElement home = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println("home.getText() = " + home.getText());

        WebElement forgotPassword = driver.findElement(By.xpath("//h2"));
        System.out.println("forgotPassword.getText() = " + forgotPassword.getText());

        WebElement emailText = driver.findElement(By.xpath("//label"));
        System.out.println("emailText.getText() = " + emailText.getText());

        WebElement emailInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        emailInputBox.sendKeys("mike@john.com");

        WebElement retrievePasswordButton = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        System.out.println("retrievePasswordButton.getText() = " + retrievePasswordButton.getText());


        driver.quit();
    }

}

