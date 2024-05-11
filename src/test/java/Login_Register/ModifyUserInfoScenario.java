package Login_Register;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Login_Register.Locators.*;
import static Login_Register.Locators.myAccount;

public class ModifyUserInfoScenario {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON userInfo;
    Form form;
    Faker fakerObject;
    String newEmail;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    @Test(priority = 2)
    public void modifyUserEmail(){
        // Click on the login link
        driver.element().click(loginLink);
        // Fill in the email
        form.writeToFieldOnly(userInfo.getTestData("Email"), emailField);
        // Fill in the password
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        // Click on login button
        driver.element().click(loginButton);
        // Validate that user is logged in
        driver.assertThat().element(logoutLink).exists().perform();
        // Click on My account
        driver.element().click(myAccount);
        // Change email to new email
        form.writeToFieldOnly(newEmail, emailField);
        // Click on save
        driver.element().click(saveButton);
        // Close success notification
        driver.element().click(closeNotification);
        // Click on logout
        driver.element().click(logoutLink);
        // Login again using old mail
        driver.element().click(loginLink);
        form.writeToFieldOnly(userInfo.getTestData("Email"), emailField);
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        driver.element().click(loginButton);
        // Check for the error message
        driver.assertThat().element(validationError).exists().perform();
        // Login again using new mail
        form.writeToFieldOnly(newEmail, emailField);
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        driver.element().click(loginButton);
        // Click on My account
        driver.element().click(myAccount);
        // Validate the email is the same as the one entered to login
        form.checkCriticalFieldHasTheSameValueAs(newEmail, emailField);
        // Click on the logout link
        driver.element().click(logoutLink);
    }
    @BeforeClass
    public void runThisFirst(){
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Create a form object to be used to fill out form fields
        form = new Form(driver);
        // Create a faker object
        fakerObject = new Faker();
        // Generate a random email
        newEmail = fakerObject.internet().safeEmailAddress();
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
    }

    @AfterClass
    public void runThisLast(){
        driver.quit();
        JsonFileModifier.modifyValue("testDataFiles/userInfo.json", "Email", newEmail);
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
