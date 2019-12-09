package com.cybertek.tests.Assignments.HW2;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

//import utilities.BrowserFactory;

public class TestCases_Homework2_Marufjan {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //WebDriverWait wait = new WebDriverWait(driver,10);
    }

    @AfterMethod
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test(priority = 1)
    public void testCase1() {

        driver.navigate().to("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.name("birthday")).sendKeys("13/13/2010");
        WebElement verifyMessage = driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        System.out.println("Verify message is Displayed " + verifyMessage.isDisplayed());
    }

    @Test(priority = 2)
    public void testCase2() {
        //Click on “Registration Form”
        driver.navigate().to("http://practice.cybertekschool.com/registration_form");
        //Verify that following options for programming languages are displayed: c++, java,JavaScript
        WebElement language = driver.findElement(By.xpath("//div[@class='form-group'][3]/div"));  // we found the line with element
        List<WebElement> list = language.findElements(By.tagName("label")); // pay attention we used 'language' element. We assign List of WebElement tagname of the language element
        for (WebElement each : list) {    // instead of writing as one element, u used arraylist and loop to find all programming languages
            String strlang = each.getText(); // we assign each element text a String

            System.out.println(strlang + " programming Language is displayed " + each.isDisplayed());  // and we printed it
        }
    }

    @Test(priority = 3)
    public void testCase3() {
        //Click on “Registration Form”
        driver.navigate().to("http://practice.cybertekschool.com/registration_form");
        //Enter only one alphabetic character into firstname input box.
        driver.findElement(By.name("firstname")).sendKeys("f");
        //Verify that warning message is displayed:
        //“first name must be more than 2 and less than 64 characters long”
        WebElement message = driver.findElement(By.xpath("(//small[@data-bv-for='firstname'])[2]"));
        System.out.println("warning message is displayed: " + message.isDisplayed());
        String ActualMessage = message.getText();
        System.out.println(ActualMessage);
        String expectedMessage = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(ActualMessage, expectedMessage);
    }

    @Test(priority = 4)
    public void testCase4() {
        //Click on “Registration Form”
        driver.navigate().to("http://practice.cybertekschool.com/registration_form");
        //Enter only one alphabetic character into firstname input box.
        driver.findElement(By.name("lastname")).sendKeys("f");
        //Verify that warning message is displayed:
        //“The last name must be more than 2 and less than 64 characters long”
        WebElement message = driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]"));
        System.out.println("warning message is displayed: " + message.isDisplayed());
        String ActualMessage = message.getText();
        System.out.println(ActualMessage);
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(ActualMessage, expectedMessage);
    }

    @Test(priority = 5)
    public void testCase5() {
        driver.navigate().to("http://practice.cybertekschool.com/registration_form");

        //firstname
        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstname.sendKeys("Fatih");
        // lastname
        WebElement lastname = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastname.sendKeys("Meric");
        //Username
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("ffthmrc");
        // Email
        WebElement email = driver.findElement(By.cssSelector("input[name='email']"));
        email.sendKeys("bedretkurza345@gmail.com");
        // password
        WebElement password = driver.findElement(By.cssSelector("input[name='password']"));
        password.sendKeys("87654321");
        // phone
        WebElement phone = driver.findElement(By.cssSelector("input[name='phone']"));
        phone.sendKeys("974-242-5310");
        //gender select
        WebElement gender = driver.findElement(By.cssSelector("input[value='male']"));
        gender.click();
        //Date of birth
        WebElement date = driver.findElement(By.cssSelector("input[name='birthday']"));
        date.sendKeys("01/24/1988");
        //Deparment/office
        WebElement deparment = driver.findElement(By.cssSelector("select[name='department']"));
        Select option = new Select(deparment);
        option.selectByValue("DE");
        //Job Title
        WebElement job = driver.findElement(By.cssSelector("select[name='job_title']"));
        Select optionjob = new Select(job);
        optionjob.selectByVisibleText("QA");
        // Select programming language
        WebElement language = driver.findElement(By.id("inlineCheckbox2"));
        language.click();
        //Sing Up
        WebElement singup = driver.findElement(By.id("wooden_spoon"));
        singup.click();
    }

    @Test(priority = 6)
    public void TestCase6() {
        //Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");
        //Step 2. Copy and save email as a string.
        String tempEmail = driver.findElement(By.id("email")).getText();
        // I manipulated String email for full name
        String fullName = tempEmail.substring(0, tempEmail.indexOf(".")) + " " + tempEmail.substring(tempEmail.indexOf(".") + 1, tempEmail.indexOf("@"));
        System.out.println(fullName);
        //Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
        driver.navigate().to("http://practice.cybertekschool.com/");
        //Step 4. And click on “Sign Up For Mailing List".
        driver.findElement(By.xpath("//a[contains(text(),'Sign Up For Mailing List')]")).click();
        //Step 5. Enter any valid name.
        driver.findElement(By.name("full_name")).sendKeys(fullName);
        //Step 6. Enter email from the Step 2.
        driver.findElement(By.name("email")).sendKeys(tempEmail);
        //Step 7. Click Sign Up
        driver.findElement(By.name("wooden_spoon")).click();
        //Step 8. Verify that following message is displayed:
        //“Thank you for signing up. Click the button below to return to the home page.”
        WebElement message = driver.findElement(By.name("signup_message"));
        String actual = message.getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        System.out.println("message is displayed " + message.isDisplayed());
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(actual, expected);

        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.navigate().to("https://www.tempmailaddress.com/");

        //Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        boolean neww = driver.findElement(By.id("schranka")).getText().contains("do-not-reply@practice.cybertekschool.com");
        System.out.println("do-not-reply@practice.cybertekschool.com " + neww);
        // Step 11. Click on that email to open it.
        driver.findElement(By.xpath("//td[@class='from'][contains(text(),'do-not-reply@practice.cybertekschool.com')]")).click();
        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        // WebElement verifyDoNOtReply = driver.findElement(By.id("odesilatel"));

        //Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String verifymessage = driver.findElement(By.id("predmet")).getText();
        String expectedmessage = "Thanks for subscribing to practice.cybertekschool.com!";
        boolean b1 = verifymessage.equals(expectedmessage);
        System.out.println("Verify message : " + b1);
    }

    @Test(priority = 7)
    public void testCase7() {

        //Step 2. And click on “File Upload".
        driver.get("http://practice.cybertekschool.com/upload");

        // Step 3. Upload any file with .txt extension from your computer.
        WebElement uploadelement = driver.findElement(By.id("file-upload"));
        uploadelement.sendKeys("C:\\Users\\delluser\\Desktop\\text.txt");

        //Step 4. Click “Upload” button.
        driver.findElement(By.id("file-submit")).click();

        //Step 5. Verify that subject is: “File Uploaded!”
        boolean b1 = driver.findElement(By.xpath("//h3")).getText().contains("File Uploaded!");
        System.out.println("File Uploaded! " + b1);

        //Step 6. Verify that uploaded file name is displayed.
        String actual = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual, "text.txt");
    }

    @Test(priority = 8)
    public void testCase8() {
        //Step 2. And click on “Autocomplete”.
        driver.get("http://practice.cybertekschool.com/autocomplete");
        //Step 3. Enter “United States of America” into country input box.
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();
        //Step 4. Verify that following message is displayed:
        //“You selected: United States of America”
        WebElement displayed = driver.findElement(By.id("result"));
        System.out.println("You selected: United States of America is displayed "+displayed.isDisplayed());
    }

    @Test( )
    public void testCase9_10_11_12() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/status_codes");
        List<WebElement> code = driver.findElements(By.xpath("//div/ul/li"));

        for (int i = 1 ; i <=code.size() ; i++) {
            driver.findElement(By.xpath("//div/ul/li[" + i + "]/a")).click();
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElement(By.xpath("//div/p")).isDisplayed(), "Test " + i + " successfully");
            System.out.println("Test "+i+ " successfully");
            driver.navigate().back();
            Thread.sleep(3000);
        }
    }
}