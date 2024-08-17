package Locators;

import org.openqa.selenium.By;

public class L02_Login {
    /**
     * Links
     * **/
    public static By loginLink = By.cssSelector("a[class = ico-login]");
    /**
     * Buttons
     * **/
    public static By loginButton = By.xpath("//*[contains(@class, 'login-button')]");
    /**
     * Messages
     * **/
    public static By validationError = By.className("validation-summary-errors");
}
