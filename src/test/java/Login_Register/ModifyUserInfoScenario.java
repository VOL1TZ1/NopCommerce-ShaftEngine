package Login_Register;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class ModifyUserInfoScenario extends Hooks{
    SHAFT.TestData.JSON userInfo;
    Form form;
    String newEmail;
    @BeforeClass
    public void initializations() {
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        // Create a form object to be used to fill out form fields
        form = new Form(Hooks.driver);
        // Create a faker object
        Faker fakerObject = new Faker();
        // Generate a random email
        newEmail = fakerObject.internet().safeEmailAddress();
    }
    @Test(priority = 2)
    public void modifyUserEmail() {
        // Click on the login link
        Hooks.driver.element().click(loginLink);
        // Fill in the email
        form.writeToFieldOnly(userInfo.getTestData("Email"), emailField);
        // Fill in the password
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        // Click on login button
        Hooks.driver.element().click(loginButton);
        // Validate that user is logged in
        Hooks.driver.assertThat().element(logoutLink).exists().perform();
        // Click on My account
        Hooks.driver.element().click(myAccount);
        // Change email to new email
        form.writeToFieldOnly(newEmail, emailField);
        // Click on save
        Hooks.driver.element().click(saveButton);
        // Close success notification
        Hooks.driver.element().click(closeNotification);
        // Click on logout
        Hooks.driver.element().click(logoutLink);
        // Login again using old mail
        Hooks.driver.element().click(loginLink);
        form.writeToFieldOnly(userInfo.getTestData("Email"), emailField);
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        Hooks.driver.element().click(loginButton);
        // Check for the error message
        Hooks.driver.assertThat().element(validationError).exists().perform();
        // Login again using new mail
        form.writeToFieldOnly(newEmail, emailField);
        form.writeToFieldOnly(userInfo.getTestData("Password"), passwordField);
        Hooks.driver.element().click(loginButton);
        // Click on My account
        Hooks.driver.element().click(myAccount);
        // Validate the email is the same as the one entered to log in
        form.checkCriticalFieldHasTheSameValueAs(newEmail, emailField);
        // Click on the logout link
        Hooks.driver.element().click(logoutLink);
        // Save the new email address to the user data file
        JsonFileModifier.modifyValue("testDataFiles/userInfo.json", "Email", newEmail);
    }
}
