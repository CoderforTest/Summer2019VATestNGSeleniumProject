package com.cybertek.tests.d8_select_list;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void printAllOptions() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement element = driver.findElement(By.id("state"));

        Select stateList = new Select(element);

        List<WebElement> options = stateList.getOptions();

        for(WebElement option : options){
            System.out.println(option.getText());
        }

        String actualSelection = stateList.getFirstSelectedOption().getText();
        System.out.println("actual selection = " + actualSelection);

        Assert.assertEquals(actualSelection,"Select a State");

        // SELECT
        Thread.sleep(1000);





    }


}