package com.mercurytours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

// Define By locators instead of WebElements to avoid StaleElementException

    By userLoginLocator = By.cssSelector("input[name=userName]");
    By userPasswordLocator = By.cssSelector("input[name=password]");
    By signInButtonLocator = By.cssSelector("input[name=login]");


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

        driver.findElement(userLoginLocator).sendKeys(username);
        return this;
    }

// Method: Sign On page allows user to type their password into the Password field
    public SignOnPage typePassword(String password) {

        driver.findElement(userPasswordLocator).sendKeys(password);
        return this;
    }

// Method: Sign On page allows user to submit the Sign On form
    public HomePage submitSignOn() {

        driver.findElement(signInButtonLocator).submit();
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

        driver.findElement(signInButtonLocator).submit();
        return new SignOnPage(driver);
    }
}
