package com.mercurytours;

import org.openqa.selenium.*;

/**
 * This is the page object class for the Register page
 */

public class RegisterPage extends BasePageObject {

    // Define By locators instead of WebElements to avoid StaleElementException
    By userFirstNameLocator = By.cssSelector("input[name=firstName]");
    By userLastNameLocator = By.cssSelector("input[name=lastName]");
    By userPhoneLocator = By.cssSelector("input[name=phone]");
    By userLoginLocator = By.cssSelector("input[name=userName]");

    public RegisterPage(WebDriver driver) {
        super(driver);

        if (!"Register: Mercury Tours".equals(driver.getTitle())) {
            driver.get(BaseUrl + "/mercuryregister.php");
        }
    }

// Register page allows user to enter their Contact Information

    // Method: Enter user's first name into the First Name field
    private RegisterPage typeUserFirstName(String userFirstName) {

        driver.findElement(userFirstNameLocator).clear();
        driver.findElement(userFirstNameLocator).sendKeys(userFirstName);
        return this;
    }

    // Method: Enter user's last name into the Last Name field
    private RegisterPage typeUserLastName(String userLastName) {

        driver.findElement(userLastNameLocator).clear();
        driver.findElement(userLastNameLocator).sendKeys(userLastName);
        return this;
    }

    // Method: Enter user's phone number into the phone field
    private RegisterPage typeUserPhone(String userPhone) {

        driver.findElement(userPhoneLocator).clear();
        driver.findElement(userPhoneLocator).sendKeys(userPhone);
        return this;
    }

    // Method: Enter user's username into the Email field
    private RegisterPage typeUsername(String username) {

        driver.findElement(userLoginLocator).clear();
        driver.findElement(userLoginLocator).sendKeys(username);
        return this;
    }

    // Method: Enter user's Contact Information
    public RegisterPage typeContactInformation(String userFirstName,
                                               String userLastName,
                                               String userPhone,
                                               String username) {

        typeUserFirstName(userFirstName);
        typeUserLastName(userLastName);
        typeUserPhone(userPhone);
        typeUsername(username);
        return this;
    }
}
