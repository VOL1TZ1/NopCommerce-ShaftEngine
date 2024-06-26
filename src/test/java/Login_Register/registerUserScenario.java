package Login_Register;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;

import coreElements.FormField;
import org.testng.annotations.*;
import pages.P01_Register;

import java.util.Objects;

import static Login_Register.Locators.*;
public class registerUserScenario extends Hooks{
        SHAFT.TestData.JSON userInfo;
        Form form;
        String email;
        String siteTitle = "nopCommerce demo store";
        @BeforeMethod
        public void runThisFirst(){
            // Extract user information
            userInfo = new SHAFT.TestData.JSON("userInfo.json");
            // Create a form object to be used to fill out form fields
            form = new Form(driver);
            // Create a faker object
            Faker fakerObject = new Faker();
            // Generate a random email
            email = fakerObject.internet().safeEmailAddress();
        }
        @Test
        public void registerNewUser(){
            // Click on Register link
            driver.element().click(registerLink);
            // Choose the gender
            form.chooseGenderRadioButton(userInfo.getTestData("Gender"), driver);
            // Fill in the first name
            form.writeToFieldOnly(userInfo.getTestData("First_Name"),firstNameField);
            // Fill in the Last name
            form.writeToFieldOnly(userInfo.getTestData("Last_Name"),lastNameField);
            // Fill in the date of birth
            form.chooseFromList(userInfo.getTestData("DoB_Day"), dobDayField);
            form.chooseFromList(userInfo.getTestData("DoB_Month"), dobMonthField);
            form.chooseFromList(userInfo.getTestData("DoB_Year"), dobYearField);
            // Fill in the email
            form.writeToFieldOnly(email,emailField);
            // Fill in the Company name
            form.writeToFieldOnly(userInfo.getTestData("Company"),companyNameField);
            // Fill in the password
            form.writeToFieldOnly(userInfo.getTestData("Password"),passwordField);
            // Fill in the confirmation password
            form.writeToFieldOnly(userInfo.getTestData("Password"),confirmPasswordField);
            // Press the save button
            driver.element().click(registerButton);
            // Check that the success message appears
            driver.assertThat().element(successMessage).exists().perform();
            // Press the continue button
            driver.element().click(continueButton);
            // Check that the user is returned to the main page
            driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
            // Navigate to my account
            driver.element().click(myAccount);
            /***********************************************************************************/
            // Check the gender
            if(Objects.equals(userInfo.getTestData("Gender"), "Male")){
                driver.verifyThat().element(genderMale).isSelected().perform();
            } else if (Objects.equals(userInfo.getTestData("Gender"), "Female")) {
                driver.verifyThat().element(genderFemale).isSelected().perform();
            } else {
                SHAFT.Report.report("The gender field in the userInfo.json contains invalid data!!");
            }
            // Check the First Name
            form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("First_Name"), firstNameField);
            // Check the Last Name
            form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("Last_Name"), lastNameField);
            // Check the Email
            form.checkCriticalFieldHasTheSameValueAs(email, emailField);
            // Press logout
            driver.element().click(logoutLink);
            // Save the new email address to the user data file
            JsonFileModifier.modifyValue("src/test/resources/testDataFiles/userInfo.json","Email", email);
        }
}
