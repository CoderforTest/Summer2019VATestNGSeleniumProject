package com.cybertek.tests.Assignments.Assignment11Nov;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice-cybertekschool.herokuapp.com");

        driver.findElement(By.linkText("Registration Form")).click();
//driver.findElement(By.linkText("firstname")).sendKeys("123");
driver.findElement(By.name("firstname")).sendKeys("123");

//WebElement actualVie = driver.findElement(By.xpath("html/body/div/div[2]/div/div/div/div/form/div/div/i"));
WebElement actView = driver.findElement(By.id("content"));

String actualView = actView.getText();

        System.out.println("Content of the page is:");
        System.out.println(actualView);
        System.out.println("========================================");
if (actualView.contains("first name can only consist of alphabetical letters")){
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
Step 3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”
 */