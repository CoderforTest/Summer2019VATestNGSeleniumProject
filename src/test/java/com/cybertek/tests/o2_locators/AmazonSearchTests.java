package com.cybertek.tests.o2_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchTests {
    public static void main(String[] args) {
        priceDetails();
        titleTest();
        bookDetailsTest();

    }

    /*
    TS003: Price details
    Go to amazon.com
    Search for selenium cookbook
    Click on result Selenium Testing Tools Cookbook - Second Edition
    Verify paperback price $44.99
    Verify Kindle price $22.39
    */
    private static void priceDetails() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium cookbook");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        WebElement book = driver.findElement(By.linkText("Selenium Testing Tools Cookbook - Second Edition"));
        book.click();

        String expectedPaperbackPrice = "$44.99";

        WebElement pPrice = driver.findElement(By.xpath("(//span[@class='a-size-base mediaTab_subtitle'])[2]"));
        String actualPPrice = pPrice.getText();

        if (expectedPaperbackPrice.equals(actualPPrice)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualPPrice = " + actualPPrice);
            System.out.println("expectedPaperbackPrice = " + expectedPaperbackPrice);
        }

        String expectedKPrice = "$22.39";
        WebElement kPrice = driver.findElement(By.xpath("(//span[@class='a-size-base mediaTab_subtitle'])[1]"));
        String actualKPrice = kPrice.getText();

        if (expectedKPrice.equals(actualKPrice)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualKPrice = " + actualKPrice);
            System.out.println("expectedKPrice = " + expectedKPrice);
        }

        driver.quit();

    }

    /*
    TS002: Book details
Go to amazon.com
Search for selenium cookbook
verify the first result is
Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering
Verify that author is Mark Collin
*/
    private static void bookDetailsTest() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium cookbook");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();

        String expectedBook = "Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering Selenium WebDriver, 2nd Edition";
        WebElement res1 = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        String actualBook = res1.getText();

        if (expectedBook.equals(actualBook)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualBook = " + actualBook);
            System.out.println("expectedBook = " + expectedBook);
        }

        String expectedAuthor = "Mark Collin";
        WebElement author1 = driver.findElement(By.xpath("(//a[@class='a-size-base a-link-normal'])[1]"));
        String actualAuthor = author1.getText();

        if (expectedAuthor.equals(actualAuthor)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualAuthor = " + actualAuthor);
            System.out.println("expectedAuthor = " + expectedAuthor);
        }

        driver.quit();

    }

/*
TS001 : Verify title
Go to amazon.com
Search for selenium cookbook
click link books
verify title ends with books
click on any department
verify title does not end with books
 */
    private static void titleTest() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("selenium cookbook");
        WebElement searchBtn = driver.findElement(By.className("nav-input"));
        searchBtn.click();
        WebElement booksLink = driver.findElement(By.linkText("Books"));
        booksLink.click();
        String title = driver.getTitle();
        System.out.println(title);
        if (title.endsWith("Books")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println(title + ": did not end with Books");
        }

        WebElement anyDepartment = driver.findElement(By.linkText("Any Department"));
        anyDepartment.click();

        title = driver.getTitle();
        if (!title.endsWith("Books")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("ACTUAL: " + title);
        }

        driver.quit();

    }


}

/*

___
xpath using text
//tag[.='text']
//span[.='Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering Selenium WebDriver, 2nd Edition']
<span class="a-size-medium a-color-base a-text-normal" dir="auto">Mastering Selenium WebDriver 3.0: Boost the performance and reliability of your automated checks by mastering Selenium WebDriver, 2nd Edition</span>

tag : span

1 attribute: class
value: a-size-medium a-color-base a-text-normal

2 attribute: dir
value: auto

//E[@A=’t']

(//span[@class='a-size-medium a-color-base a-text-normal'])[1]

//form/div//input  --> giving 2 inputs, child and all decsendants

//form/div//input[2]  --> only gives the second input
					  --> only gives one input

(//form/div//input)[2] --> finds all the elements that match xpath "//form/div//input" and returns the 3rd one out of those matches

//span[@class='a-size-base mediaTab_subtitle']
 */