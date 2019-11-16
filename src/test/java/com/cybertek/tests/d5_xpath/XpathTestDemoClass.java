package com.cybertek.tests.d5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTestDemoClass {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement link = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        System.out.println(link.getText());

        WebElement link2 = driver.findElement(By.xpath("/html/body/div/div/div/div/h3"));
        System.out.println(link2.getText());

        WebElement link3 = driver.findElement(By.xpath("//li/a"));
        System.out.println(link3.getText());

        WebElement link4 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        System.out.println(link4.getText());

        WebElement link5 = driver.findElement(By.xpath("//button[.='Button 1']"));
        System.out.println(link5.getText());

        WebElement link6 = driver.findElement(By.xpath("//button[contains(text(), 'utton 1')]"));
        System.out.println(link6.getText());

        WebElement link7 = driver.findElement(By.xpath("//button[contains(text(), 'utton 1')]"));
        System.out.println(link7.getText());
    }
}