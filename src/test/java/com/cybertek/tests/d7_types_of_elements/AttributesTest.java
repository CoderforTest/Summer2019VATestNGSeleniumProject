package com.cybertek.tests.d7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributesTest {

        @Test
        public void test1() {
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/radio_buttons");

            WebElement blue = driver.findElement(By.id("blue"));
            System.out.println(blue.getAttribute("name"));

            System.out.println(blue.getAttribute("outerHTML"));
            System.out.println(blue.getAttribute("innerHTML"));

            driver.quit();
        }
    }
