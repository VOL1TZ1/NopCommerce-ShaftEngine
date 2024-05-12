package Login_Register;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class LoginScenario {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON userInfo;
    Form form;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
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
        // Validate the email is the same as the one entered to login
        form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("Email"), emailField);
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
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
    }

    @AfterClass
    public void runThisLast(){
        driver.quit();
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
