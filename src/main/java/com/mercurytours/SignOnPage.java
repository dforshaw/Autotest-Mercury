package com.mercurytours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This is the page object class for the Sign On page
 */

public class SignOnPage extends Page {

//    MercuryAccount mercury_account = new MercuryAccount();
//    String BaseUrl = mercury_account.mercury_url;

// Constructor: uses super class to instantiate driver
// Loads Sign On page if not on the correct page
    public SignOnPage(WebDriver driver) {
        super(driver);

        if (!"Sign-on: Mercury Tours".equals(driver.getTitle())) {
            driver.get(BaseUrl + "/mercurysignon.php");
        }
    }

// Define elements on the page
//    WebElement userLogin = driver.findElement(By.name("username"));
//    WebElement userPassword = driver.findElement(By.name("password"));
//    WebElement signInButton = driver.findElement(By.name("login"));

// Method: Sign On page allows user to type their username into the User Name field
    public SignOnPage typeUsername(String username) {

//        userLogin.sendKeys(username);
        driver.findElement(By.name("userName")).sendKeys(username);

        return this;
    }

// Method: Sign On page allows user to type their password into the Password field
    public SignOnPage typePassword(String password) {

//        userPassword.sendKeys(password);
        driver.findElement(By.name("password")).sendKeys(password);

        return this;
    }

// Method: Sign On page allows user to submit the Sign On form
    public HomePage submitSignOn() {

//        signInButton.submit();
        driver.findElement(By.name("login")).submit();

        return new HomePage(driver);
    }

// Method: Sign On page allows user to login as a service using their username & password
    public HomePage SignOnAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitSignOn();
    }

// Method: Sign On page allows user to attempt login using an incorrect username & password
    public SignOnPage submitSignOnExpectingFailure() {

//        signInButton.submit();
        driver.findElement(By.name("login")).submit();
        return new SignOnPage(driver);
    }
}
