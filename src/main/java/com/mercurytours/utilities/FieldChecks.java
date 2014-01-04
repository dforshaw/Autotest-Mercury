package com.mercurytours.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.thoughtworks.selenium.SeleneseTestBase.fail;

public class FieldChecks {

    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;  // Success!
        } catch (NoSuchElementException ignored) {
            return false;
        }
    }

    public static void escapeStaleState(WebDriver driver, By by) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (isElementPresent(driver, by));
                    break;
            } catch (Exception e) {}

            Thread.sleep(1000);
        }

    }



    /**
     * Attempts to click on an element multiple times (to avoid stale element
     * exceptions caused by rapid DOM refreshes)
     *
     * @param d
     *            The WebDriver
     * @param by
     *            By element locator
     *
     * SOURCE: http://yesterdayseggs.com/gwt-selenium-webdriver-and-the-dreaded-staleelementreferenceexception/
     */
    public static void dependableClick(WebDriver d, By by)
    {
        final int MAXIMUM_WAIT_TIME = 30;
        final int MAX_STALE_ELEMENT_RETRIES = 25;

        WebDriverWait wait = new WebDriverWait(d, MAXIMUM_WAIT_TIME);
        int retries = 0;
        while (true)
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(by)).click();

                return;
            }
            catch (StaleElementReferenceException e)
            {
                if (retries < MAX_STALE_ELEMENT_RETRIES)
                {
                    retries++;
                    continue;
                }
                else
                {
                    throw e;
                }
            }
        }
    }
}
