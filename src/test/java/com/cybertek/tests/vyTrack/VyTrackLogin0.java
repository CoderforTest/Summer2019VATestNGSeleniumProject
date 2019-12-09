package com.cybertek.tests.vyTrack;

import com.cybertek.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackLogin0 {
    public static void main(String[] args) throws InterruptedException {

/*
Go to the login page of VyTrack
• Enter valid credential (can be any role)
• Click login button
• Verify that the user login successfully

By.name(“_username”)
By.name(“_password”)
By.id(“_submit”)
     */

        // calling getDriver method from WebDriverFactory file of utilities package.
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // go to https://qa2.vytrack.com/user/login
        driver.get("https://qa2.vytrack.com/user/login");

        // find Username box
        WebElement userNameInput = driver.findElement(By.name("_username"));

        // enter Username
        String expectedUserName = "user19";
        userNameInput.sendKeys(expectedUserName);

        // find Password box
        WebElement passwordInput = driver.findElement(By.name("_password"));

        // enter Password
        String expectedPassword = "UserUser123";
        passwordInput.sendKeys(expectedPassword);

        // press click button
        WebElement enterCredentials = driver.findElement(By.id("_submit"));
        enterCredentials.click();

   String expectedURLResult = "https://qa2.vytrack.com/";
   String actualURLResult = driver.getCurrentUrl();

        if (expectedURLResult.equals(actualURLResult)) {
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        // quit from chrome browser
        driver.quit();

    }
}