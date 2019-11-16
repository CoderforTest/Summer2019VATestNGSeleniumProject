package com.cybertek.tests.Assignment11Nov;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");


        driver.findElement(By.linkText("Sign Up For Mailing List")).click();

       driver.findElement(By.name("full_name")).sendKeys("Your Name and Last Name");

       driver.findElement(By.name("email")).sendKeys("Your Email");

       driver.findElement(By.name("wooden_spoon")).click();

       WebElement Result = driver.findElement(By.name("signup_message"));
       String actualResult = Result.getText();
       String expectedResult = "Thank you for signing up. Click the button below to return to the home page.";
      if (actualResult.equals(expectedResult)){
          System.out.println("Test Case 1 Result: PASS");
      } else{
          System.out.println("Test Case 1 Result: FAIL");
      }

       Thread.sleep(3000);

driver.quit();

    }
}
/*
Test case #1 Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed: “Thank you for signing up.
Click the button below to return to the home page.”
Home button should be displayed.
 */