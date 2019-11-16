package com.cybertek.tests.Assignment11Nov;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestCase2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        List<WebElement> links = driver.findElements(By.className("list-group-item"));
        int numberOfListedExamples = links.size();

        if (numberOfListedExamples==48) {
            System.out.println("Number of listed examples: " + numberOfListedExamples);
            System.out.println("Test Case 2 Result: PASS");
        } else{
            System.out.println("Number of listed examples: " + numberOfListedExamples + ". It should be 48.");
            System.out.println("Test Case 2 Result: FAIL");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Verify that number of listed examples equals to 48.
Hint: use findElements() and size() methods.
 */