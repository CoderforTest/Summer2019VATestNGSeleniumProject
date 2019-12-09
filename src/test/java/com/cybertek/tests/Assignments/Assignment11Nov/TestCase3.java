package com.cybertek.tests.Assignments.Assignment11Nov;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Multiple Buttons")).click();

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/button[1]")).click();

        WebElement buttonOne= driver.findElement(By.id("result"));
        String buttonOneActualResult = buttonOne.getText();

        String buttonOneExpectedResult = "Clicked on button one!";

        if (buttonOneActualResult.equals(buttonOneExpectedResult)){
            System.out.println("Expected result message: " + buttonOneExpectedResult);
            System.out.println("Actual result message: " + buttonOneActualResult);
            System.out.println("Test Case 3 Result: PASS");
        } else{
            System.out.println("Expected result message: " + buttonOneExpectedResult);
            System.out.println("Actual result message: " + buttonOneActualResult);
            System.out.println("Test Case 3 Result: FAIL");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!"
 */