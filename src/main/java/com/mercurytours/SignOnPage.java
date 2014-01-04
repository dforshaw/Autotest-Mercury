package com.mercurytours;

import com.mercurytours.utilities.FieldChecks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is the page object class for the Sign On page
 */

public class SignOnPage extends Page {

/* ****** TO DO
   ******       Find out which approach for defining Page Object elements is "better"
*/

// Define form elements on the page

/*  Use these with Page Factory Pattern
    @FindBy(name = "userName")
    private WebElement userLogin;

    @FindBy(name = "password")
    private WebElement userPassword;

    @FindBy(name = "login")
    private WebElement signInButton;
*/
//    private WebElement userLogin = driver.findElement(By.name("userName"));
//    private WebElement userPassword = driver.findElement(By.name("password"));
//    private WebElement signInButton = driver.findElement(By.name("login"));

//    private WebElement userLogin = driver.findElement(By.xpath("//input[@name='userName']"));
//    private WebElement userPassword = driver.findElement(By.xpath("//input[@name='password']"));
//    private WebElement signInButton = driver.findElement(By.xpath("//input[@name='login']"));

    private WebElement userLogin = driver.findElement(By.cssSelector("input[name=userName]"));
    private WebElement userPassword = driver.findElement(By.cssSelector("input[name=password]"));
    private WebElement signInButton = driver.findElement(By.cssSelector("input[name=login]"));

// Constructor: uses super class to instantiate driver
// Loads Sign On page if not on the correct page
    public SignOnPage(WebDriver driver) {

        super(driver);

        if (!"Sign-on: Mercury Tours".equals(driver.getTitle())) {
            driver.get(BaseUrl + "/mercurysignon.php");
        }
    }

// Method: Sign On page allows user to type their username into the User Name field
    public SignOnPage typeUsername(String username) {
//        System.out.println("type the Username");

/* ******* REFACTOR
   *******          the "stale check testing"
   *******          to the utilities package
   *******          in order to use with all 3 form elements
*/
        try {
            FieldChecks.escapeStaleState(driver, By.cssSelector("input[name=userName]"));
            userLogin.sendKeys(username);
        } catch (Exception see) {
            System.out.println(see);
        }
/*

        if(!FieldChecks.isElementPresent(driver, By.name("userName"))){
//            System.out.println("Username is NOT present");
        } else {
//            System.out.println("Username is present");
//            System.out.println(username);
            try {
                userLogin.sendKeys(username);
            } catch (Exception see) {
                //recover from error
                System.out.println("***** Error: STALE username reference *****");
//                System.out.println(see);

                int numElements = driver.findElements(By.name("userName")).size();
//                System.out.println(numElements);

                if (numElements != 1) {
                    System.out.println("***** Error: too many username references *****");
                } else {
//                    userLogin = driver.findElement(By.name("userName"));
                    userLogin = driver.findElement(By.cssSelector("input[name=userName]"));
                    userLogin.sendKeys(username);
                    System.out.println(">>> SUCCESSFUL ENTRY : userName");
                }
            }
        }
*/
        return this;
    }

// Method: Sign On page allows user to type their password into the Password field
    public SignOnPage typePassword(String password) {
//        System.out.println("type the password");

        if(!FieldChecks.isElementPresent(driver, By.name("password"))){
//            System.out.println("Password is NOT present");
        } else {
//            System.out.println("Password is present");
//            System.out.println(password);
            try {
                userPassword.sendKeys(password);
            } catch (Exception see) {
                //recover from error
                System.out.println("***** Error: STALE password reference *****");
//                System.out.println(see);

                int numElements = driver.findElements(By.name("password")).size();
//                System.out.println(numElements);

                if (numElements != 1) {
                    System.out.println("***** Error: too many password references *****");
                } else {
//                    userPassword = driver.findElement(By.name("password"));
                    userPassword = driver.findElement(By.cssSelector("input[name=password]"));
                    userPassword.sendKeys(password);
                    System.out.println(">>> SUCCESSFUL ENTRY : password");
                }
            }
        }

        return this;
    }

// Method: Sign On page allows user to submit the Sign On form
    public HomePage submitSignOn() {
  //       System.out.println("click the submit button");

        if(!FieldChecks.isElementPresent(driver, By.name("login"))){
//            System.out.println("Submit button is NOT present");
        } else {
//            System.out.println("Submit button is present");
            try {
                signInButton.submit();
            } catch (Exception see) {
                //recover from error
                System.out.println("***** Error: STALE submit button reference *****");
//                System.out.println(see);

                int numElements = driver.findElements(By.name("login")).size();
//                System.out.println(numElements);

                if (numElements != 1) {
                    System.out.println("***** Error: too many login button references *****");
                } else {
//                    signInButton = driver.findElement(By.name("login"));
                    signInButton = driver.findElement(By.cssSelector("input[name=login]"));
                    signInButton.submit();
                    System.out.println(">>> SUCCESSFUL ENTRY : login button");
                }
            }
        }

        return new HomePage(driver);
    }

// Method: Sign On page allows user to login as a service using their username & password
    public HomePage SignOnAs(String username, String password) {
//        System.out.println("Ready to sign on");
        typeUsername(username);
        typePassword(password);
        return submitSignOn();
    }

/* ******* REFACTOR
   *******          the signInButton.submit() to include
   *******          the "stale check testing"
   *******          from the utilities package
*/

// Method: Sign On page allows user to attempt login using an incorrect username & password
    public SignOnPage submitSignOnExpectingFailure() {

        signInButton.submit();
        return new SignOnPage(driver);
    }
}
