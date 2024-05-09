package Login_Register;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Objects;

import static Login_Register.Locators.*;

public class Register_User_Scenario {
        SHAFT.GUI.WebDriver driver;
        SHAFT.TestData.JSON userInfo;
        Form form;
        String siteURL = "https://demo.nopcommerce.com/";
        String siteTitle = "nopCommerce demo store";
        @Test
        public void registerNewUser(){
            // Click on Register link
            driver.element().click(registerLink);
            // Choose the gender
            if(Objects.equals(userInfo.getTestData("Gender"), "Male")){
                driver.element().click(genderMale);
            } else if (Objects.equals(userInfo.getTestData("Gender"), "Female")) {
                driver.element().click(genderFemale);
            } else {
                SHAFT.Report.report("The gender field in the userInfo.json contains invalid data!!");
            }
            // Fill in the first name
            form.writeToFieldOnly(userInfo.getTestData("First_Name"),firstNameField);
            // Fill in the Last name
            form.writeToFieldOnly(userInfo.getTestData("Last_Name"),lastNameField);
            // Fill in the date of birth
            form.chooseFromList(userInfo.getTestData("DoB_Day"), dobDayField);
            form.chooseFromList(userInfo.getTestData("DoB_Month"), dobMonthField);
            form.chooseFromList(userInfo.getTestData("DoB_Year"), dobYearField);
            // Fill in the email
            form.writeToFieldOnly(userInfo.getTestData("Email"),emailField);
            // Fill in the Company name
            form.writeToFieldOnly(userInfo.getTestData("Company"),companyNameField);
            // Fill in the password
            form.writeToFieldOnly(userInfo.getTestData("Password"),passwordField);
            // Fill in the confirmation password
            form.writeToFieldOnly(userInfo.getTestData("Password"),confirmPasswordField);
            // Press the save button
            driver.element().click(registerButton);
            // Check if that the email is not duplicated
            driver.assertThat().element(emailExistsErrorMessage).doesNotExist().perform();
            // Check that the success message appears
            driver.assertThat().element(successMessage).exists().perform();
            // Press the continue button
            driver.element().click(continueButton);
            // Press logout
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
