package Login_Register;

import org.openqa.selenium.By;

public class Locators {
    /**
     * Registration Scenario Locators
     * **/
    static By registerLink = By.linkText("Register");
    static By continueButton = By.xpath("//*[contains(@class, 'register-continue-button')]");
    static By myAccount = By.cssSelector("a[class = ico-account]");
    static By logoutLink = By.cssSelector("a[class = ico-logout]");
    static By genderMale = By.id("gender-male");
    static By genderFemale = By.id("gender-female");
    static By firstNameField = By.name("FirstName");
    static By lastNameField = By.name("LastName");
    static By dobDayField = By.name("DateOfBirthDay");
    static By dobMonthField = By.name("DateOfBirthMonth");
    static By dobYearField = By.name("DateOfBirthYear");
    static By emailField = By.name("Email");
    static By companyNameField = By.name("Company");
    static By passwordField = By.name("Password");
    static By confirmPasswordField = By.name("ConfirmPassword");
    static By registerButton = By.name("register-button");
    static By successMessage = By.xpath("//*[contains(text(), 'registration completed')]");
    static By emailExistsErrorMessage = By.xpath("//*[contains(text(), 'email already exists')]");
    /**
     * Login Scenario Locators
     * **/
    static By loginLink = By.cssSelector("a[class = ico-login]");
    static By loginButton = By.xpath("//*[contains(@class, 'login-button')]");
}
