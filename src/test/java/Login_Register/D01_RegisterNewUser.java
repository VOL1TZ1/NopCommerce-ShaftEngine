package Login_Register;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import pages.DriverManager;

import static pages.P01_Register.*;

public class D01_RegisterNewUser extends DriverManager {
    SHAFT.TestData.JSON userInfo = new SHAFT.TestData.JSON("userInfo.json");
    Faker fakerObject = new Faker();
    // create a new email
    String newEmail = fakerObject.internet().safeEmailAddress();
    @Test
    public void registerNewUser(){
        String registrationPageTitle = "nopCommerce demo store. Register";
        // Start the registration process
        register.click();
        register.validateUrl(registrationPageTitle);
        male.click();
        firstName.enterText(userInfo.getTestData("First_Name"));
        lastName.enterText(userInfo.getTestData("Last_Name"));
        birthDay.selectOption(userInfo.getTestData("DoB_Day"));
        birthMonth.selectOption(userInfo.getTestData("DoB_Month"));
        birthYear.selectOption(userInfo.getTestData("DoB_Year"));
        email.enterText(newEmail);
        companyName.enterText(userInfo.getTestData("Company"));
        newsletter.unCheck();
        password.enterText(userInfo.getTestData("Password"));
        confirmPassword.enterText(userInfo.getTestData("Password"));
        save.click();
        Continue.click();
    }

    @Test
    public void validateRegisteredUser(){
        String myAccountPageTitle = "nopCommerce demo store. Account";
        myAccount.click();
        myAccount.validateUrl(myAccountPageTitle);
        male.validateCriticalCheckboxIsChecked();
        firstName.validateCriticalField(userInfo.getTestData("First_Name"));
        lastName.validateCriticalField(userInfo.getTestData("Last_Name"));
        email.validateCriticalField(newEmail);
        //newsletter.validateNonCriticalCheckboxIsUnChecked();
        Logout.click();
        JsonFileModifier.modifyValue("src/test/resources/testDataFiles/userInfo.json","Email", newEmail);
    }
}
