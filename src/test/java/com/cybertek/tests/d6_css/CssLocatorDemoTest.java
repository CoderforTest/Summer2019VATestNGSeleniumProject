package com.cybertek.tests.d6_css;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssLocatorDemoTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//using ID : # is id
        WebElement element = driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(element.getText());//Don't click!
//using class: (.) dot is class
        WebElement element2 = driver.findElement(By.cssSelector(".nav-link"));
        System.out.println(element2.getText());  //Home
//USING ATTRIBUTE AND VALUE
        WebElement element3 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        System.out.println(element3.getText());  //Home
// all button that has class btn and ban-primary
        WebElement element4 = driver.findElement(By.cssSelector("button[name='button6']"));
        System.out.println(element4.getText());  //Don't click!
//MULTIPLE ATTRIBUTES
        WebElement element5 = driver.findElement(By.cssSelector("button[name='button6'][onclick='button6()']"));
        System.out.println(element5.getText());  //Don't click!
//DYNAMIC ATTRIBUTES
        //CONTAINS
        WebElement element6 = driver.findElement(By.cssSelector("button[id*='button_']"));
        System.out.println(element6.getText());  //Button 3
        //STARTS WITH
        WebElement element7 = driver.findElement(By.cssSelector("button[id^='button_']"));
        System.out.println(element7.getText());  //Button 3
        //ENDS WITH
        WebElement element8 = driver.findElement(By.cssSelector("button[id$='_button']"));
        System.out.println(element8.getText());  //Button 4
        //BY TAGNAME
        //CHILD AND DESCENDENTS-find any h3 element whose parent is div
        WebElement element9 = driver.findElement(By.cssSelector("div>h3"));
        System.out.println(element9.getText());  //Multiple buttons
        //find grandchild
        WebElement element10 = driver.findElement(By.cssSelector("ul a")); // ul>li>a - just find its descendant: ul a
        System.out.println(element10.getText());  //Multiple buttons

        WebElement element11 = driver.findElement(By.cssSelector("#content > div:nth-child(4) > div > div > h4"));
        System.out.println("element11 is " + element11.getText());
        driver.quit();
        }
    }