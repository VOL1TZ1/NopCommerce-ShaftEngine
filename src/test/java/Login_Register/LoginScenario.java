package Login_Register;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class LoginScenario extends Hooks{
    SHAFT.TestData.JSON userInfo;
    Form form;
    @BeforeMethod
    public void initializations(){
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        // Create a form object to be used to fill out form fields
        form = new Form(driver);
    }
    @Test(priority = 1)
    public void loginUser(){
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
        // Validate the email is the same as the one entered to log in
        form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("Email"), emailField);
        // Click on the logout link
        driver.element().click(logoutLink);
    }
}
