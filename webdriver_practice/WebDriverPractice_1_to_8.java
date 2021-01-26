package com.cybertek.tests.webdriver_practice;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverPractice_1_to_8 {

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
    public void test1(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        registrationForm.click();

        //Step 3. Enter “wrong_dob” into date of birth input box.
        WebElement birthInputBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthInputBox.sendKeys("wrong_dob");

        //Step 4. Verify that warning message is displayed: “The date of birth is not valid”
        WebElement wrongResult = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']"));
        String actualResult = wrongResult.getText();

        String expectedResult = "The date of birth is not valid";

        Assert.assertEquals(actualResult, expectedResult, "Warning message is displayed");


    }

    @Test
    public void test2(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        registrationForm.click();

        //Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript

        WebElement programmingLanguageC = driver.findElement(By.xpath("//label[@for='inlineCheckbox1']"));
        String actualResult1 = programmingLanguageC.getText();
        String expectedResult1 = "C++";
        Assert.assertEquals(actualResult1, expectedResult1, "Verify programming language C++ displayed");

        WebElement programmingLanguageJava = driver.findElement(By.xpath("//label[@for='inlineCheckbox2']"));
        String actualResult2 =programmingLanguageJava.getText();
        String expectedResult2 = "Java";
        Assert.assertEquals(actualResult2, expectedResult2, "Verify programming language Java displayed");

        WebElement programmingLanguageJavaS = driver.findElement(By.xpath("//label[@for='inlineCheckbox3']"));
        String actualResult3 =programmingLanguageJavaS.getText();
        String expectedResult3 = "JavaScript";
        Assert.assertEquals(actualResult3, expectedResult3, "Verify programming language JavaScript displayed");

        /*
        List<WebElement> button = driver.findElements(By.cssSelector(".form-check-label"));
        Assert.assertEquals(button.get(0).getText(), "C++");
        Assert.assertEquals(button.get(1).getText(), "Java");
        Assert.assertEquals(button.get(2).getText(), "JavaScript");
         */

    }

    @Test
    public void test3(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        registrationForm.click();

        //Step 3. Enter only one alphabetic character into first name input box.
        WebElement nameInputBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        nameInputBox.sendKeys("a");

        //Step 4. Verify that warning message is displayed
        WebElement wrongMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));

        String actualResult = wrongMessage.getText();
        String expectedResult = "first name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualResult, expectedResult, "Verify warning message is displayed");


    }
    @Test
    public void test4(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. Click on “Registration Form”
        WebElement registrationForm = driver.findElement(By.xpath("//a[@href='/registration_form']"));
        registrationForm.click();

        //Step 3. Enter only one alphabetic character into last name input box.
        WebElement lastNameInputBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameInputBox.sendKeys("b");

        //Step 4. Verify that warning message is displayed
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));

        String actualResult = warningMessage.getText();
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";

        Assert.assertEquals(actualResult, expectedResult, "Verify warning message is displayed");
    }

    @Test
    public void test5() throws InterruptedException {

        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[@href='/registration_form']")).click();
        //Step 3. Enter any valid first name.
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("jonh");
        //Step 4. Enter any valid last name.
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("smith");
        //Step 5. Enter any valid user name.
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("smithjohn");
        //Step 5. Enter any valid email.
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("john@smith.com");
        //Step 6. Enter any valid password.
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
        //Step 7. Enter any valid phone number.
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("571-600-9081");
        //Step 8. Select gender.
        driver.findElement(By.cssSelector("input[value='male']")).click();
        //Step 9. Enter any valid date of birth.
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("10/07/1987");

        //Step 10. Select any department.
        WebElement dropdown = driver.findElement(By.name("department"));
        Select departDrop = new Select(dropdown);
        departDrop.selectByVisibleText("Mayor's Office");

        //Step 11. Enter any job title.
        WebElement jobtitle = driver.findElement(By.name("job_title"));
        Select job = new Select(jobtitle);
        job.selectByVisibleText("Product Owner");

        //Step 12. Select java as a programming language.
        List<WebElement> options = driver.findElements(By.xpath("//label[@class='form-check-label']"));
        options.get(0).click();

        //Step 13. Click Sign up.
        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(4000);
        //Step 14. Verify that following success message is displayed:
        String actualResult = driver.findElement(By.xpath("//div/p")).getText();
        String expectedResult = "You've successfully completed registration!";
        Assert.assertEquals(actualResult, expectedResult, "Verify Success Message");

    }

    @Test
    public void test6() throws InterruptedException {
        //Step 1. Go to
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(3000);

        //Step 2. Copy and save email as a string.
        WebElement tempEmail = driver.findElement(By.id("email"));
        String email = tempEmail.getText();


        //Step 3. Then go to
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");

        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();

        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys("Elena Andia");

        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(email);

        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();

        //Step 8. Verify that following message is displayed
        String actualMessage = driver.findElement(By.name("signup_message")).getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actualMessage, expectedMessage, "Verify Success Message is displayed");

        //Step 9. Navigate back to the
        driver.navigate().to("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Step 10. Verify that you’ve received an email from
        String actualText = driver.findElement(By.xpath("//*[contains(., 'do-not-reply')]")).getText();

        Assert.assertTrue(actualText.contains("do-not-reply@practice.cybertekschool.com"));

        //Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//div[@id='home']/div/table/tbody/tr[1]")).click();

        //Step 12. Verify that email is from:
        String actualEmail = driver.findElement(By.id("odesilatel")).getText();
        String expectedEmail = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualEmail, expectedEmail, "Verify that emails match");

        //Step 13. Verify that subject is:
        String actualSubject = driver.findElement(By.id("predmet")).getText();
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualSubject, expectedSubject, "Verify that subjects are match");

    }

    @Test
    public void test7(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “File Upload".
        driver.findElement(By.xpath("//a[@href='/upload']")).click();

        //Step 3. Upload any file with .txt extension from your computer.
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\emine\\Desktop\\file.txt");

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        String actualSubject = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        String expectedSubject = "File Uploaded!";
        Assert.assertEquals(actualSubject, expectedSubject, " Verify that subject is: “File Uploaded!”");

        //Step 6. Verify that uploaded file name is displayed.
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        String expectedFileName = "file.txt";
        Assert.assertEquals(actualFileName, expectedFileName, "Verify file name is displayed");

    }

    @Test
    public void test8(){
        //Step 1. Go to
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.xpath("//a[@href='/autocomplete']")).click();

        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");

        driver.findElement(By.xpath("//input[@type='button']")).click();

        //Step 4. Verify that following message is displayed
        WebElement successMessage = driver.findElement(By.id("result"));
        Assert.assertTrue(successMessage.isDisplayed());
    }

}
