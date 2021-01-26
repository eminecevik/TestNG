package com.cybertek.tests.webdriver_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverPractice_9_to_12 {
  
    WebDriver driver;

    //for driver setup
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    //for driver close
    @AfterMethod
    public void afterMethod(){

        driver.quit();
    }

    @Test
    public void test9(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();

        //Step 3. Then click on “200”.
        driver.findElement(By.xpath("//a[@href='status_codes/200']")).click();

        //Step 4. Verify that following message is displayed:
        String message = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(message.contains("This page returned a 200 status code"));

    }

    @Test
    public void test10(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();

        //Step 3. Then click on “301”.
        driver.findElement(By.xpath("//a[@href='status_codes/301']")).click();

        //Step 4. Verify that following message is displayed:
        String message = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(message.contains("This page returned a 301 status code"));

    }

    @Test
    public void test11(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();

        //Step 3. Then click on “404”.
        driver.findElement(By.xpath("//a[@href='status_codes/404']")).click();

        //Step 4. Verify that following message is displayed:
        String message = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(message.contains("This page returned a 404 status code"));

    }

    @Test
    public void test12(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Status Codes”.
        driver.findElement(By.xpath("//a[@href='/status_codes']")).click();

        //Step 3. Then click on “500”.
        driver.findElement(By.xpath("//a[@href='status_codes/500']")).click();

        //Step 4. Verify that following message is displayed:
        String message = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(message.contains("This page returned a 500 status code"));

    }
}
