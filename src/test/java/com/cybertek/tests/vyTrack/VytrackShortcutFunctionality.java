package com.cybertek.tests.vyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackShortcutFunctionality {

    public static void main(String[] args) throws InterruptedException {

        // Vytrack shortcut functionality
        // 1. Open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2. Go to Vytrack login page
        driver.get("https://qa2.vytrack.com/user/login");

        // 3. Login as a sales manager
        WebElement userNameInput = driver.findElement(By.name("_username"));
        String expectedUserName = "user19";
        userNameInput.sendKeys("salesmanager119");
        WebElement passwordInput = driver.findElement(By.name("_password"));
        passwordInput.sendKeys("UserUser123");
        WebElement enterCredentials = driver.findElement(By.id("_submit"));
        enterCredentials.click();

        // 4. Verify Dashboard page is open
        String titleOfPage = driver.getTitle();
        if(titleOfPage.equals("Dashboard")){
            System.out.println("STEP4 PASS");
        } else{
            System.out.println("STEP4 FAIL");
        }

        // 5. Click on Shortcuts icon
        WebElement ShortcutsIcon = driver.findElement(By.xpath("//i[@class='fa-share-square']/following-child::before"));
        ShortcutsIcon.click();



        // 6. Click on link See full list
        WebElement SeeFullListLink = driver.findElement(By.xpath("//body[@class='desktop-version lang-en']"));
        SeeFullListLink.click();

        Thread.sleep(3000);
        driver.quit();
    }
}
/*
Vytrack shortcut functionality
1. Open browser
2. Go to Vytrack login page
3. Login as a sales manager

4. Verify Dashboard page is open
5. Click on Shortcuts icon
6. Click on link See full list
7. Click on link Opportunities
8. Verify Open opportunities page is open
9. Click on Shortcuts icon
10. Click on link See full list
11. Click on link Vehicle Service Logs
12. Verify error message text is You do not have permission to perform this action.
13. Verify Shortcut Actions List page is still open
 */
