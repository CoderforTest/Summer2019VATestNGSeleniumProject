package com.cybertek.tests.vyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTrackLoginNegativeTestCase {
    public static void main(String[] args) throws InterruptedException {

        // Go to the login page of VyTrack
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");

        // Enter invalid credential (can be any role)
        driver.findElement(By.id("prependedInput")).sendKeys("aaa");
        driver.findElement(By.id("prependedInput2")).sendKeys("bbb");

        Thread.sleep(3000);

        // Click login button
        driver.findElement(By.id("_submit")).click();

        // Verify that the system shows error message “Invalid user name or password.”

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Invalid user name or password.')]"));
        String actualErrorMessage = errorMessage.getText();

        String expectedErrorMessage = "Invalid user name or password.";

        System.out.println("Expected error message: " + expectedErrorMessage);
        System.out.println("====================================");

        System.out.println("Actual error message: \n" + actualErrorMessage);
        System.out.println("====================================");

        if (actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Expected error message appears on the page.");
            System.out.println("NEGATIVE TEST CASE: PASS");
        } else{
            System.out.println("NEGATIVE TEST CASE: FAIL");
        }

        Thread.sleep(3000);
       driver.quit();
    }
}
/*
Go to the login page of VyTrack
• Enter invalid credential (can be any role)
• Click login button
• Verify that the system shows error message “Invalid user name or password.”
 */
