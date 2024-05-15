package Locators;

import org.openqa.selenium.By;

public class L01_Register {
    /**
     * Fields
     * **/
    public static By firstNameField = By.name("FirstName");
    public static By lastNameField = By.name("LastName");
    public static By emailField = By.name("Email");
    public static By companyNameField = By.name("Company");
    public static By passwordField = By.name("Password");
    public  static By confirmPasswordField = By.name("ConfirmPassword");
    /**
     * Buttons
     * **/
    public static By registerButton = By.name("register-button");
    public static By continueButton = By.xpath("//*[contains(@class, 'register-continue-button')]");
    /**
     * Links
     * **/
    public static By registerLink = By.linkText("Register");
    public static By myAccountLink = By.cssSelector("a[class = ico-account]");
    public static By logoutLink = By.cssSelector("a[class = ico-logout]");
    /**
     * Lists
     * **/
    public static By dobDayField = By.name("DateOfBirthDay");
    public static By dobMonthField = By.name("DateOfBirthMonth");
    public static By dobYearField = By.name("DateOfBirthYear");
    /**
     * Radio buttons
     * **/
    public static By genderMale = By.id("gender-male");
    public  static By genderFemale = By.id("gender-female");
    /**
     * Checkboxes
     * **/
    public static By newsletterBox = By.id("Newsletter");
    /**
     * Messages
     * **/
    public static By successMessage = By.xpath("//*[contains(text(), 'registration completed')]");
}
