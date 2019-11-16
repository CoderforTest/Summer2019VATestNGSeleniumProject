package com.cybertek.tests.Assignment11Nov;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();




        driver.findElement(By.name("email")).sendKeys("testers@email");


        WebElement actView = driver.findElement(By.id("content"));

        String actualView = actView.getText();

        System.out.println("Content of the page is:");
        System.out.println(actualView);
        System.out.println("========================================");
        if (actualView.contains("email address is not a valid") && actualView.contains("Email format is not correct")){
            System.out.println("PASS");
        } else{
            System.out.println("FAIL");
        }

        Thread.sleep(3000);
       driver.quit();
    }
}
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a validEmail format is not correct”
 */