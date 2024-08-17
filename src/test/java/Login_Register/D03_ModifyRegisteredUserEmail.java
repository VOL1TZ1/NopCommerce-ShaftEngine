package Login_Register;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import pages.DriverManager;

import static pages.P01_Register.*;
import static pages.P02_Login.*;
import static pages.P03_ModifyUserInfo.*;
public class D03_ModifyRegisteredUserEmail extends DriverManager{
    SHAFT.TestData.JSON userInfo = new SHAFT.TestData.JSON("userInfo.json");
    Faker fakerObject = new Faker();
    // create a new email
    String newEmail = fakerObject.internet().safeEmailAddress();
    @Test
    public void modifyEmail(){
        Login.click();
        email.enterText(userInfo.getTestData("Email"));
        password.enterText(userInfo.getTestData("Password"));
        login.click();
        myAccount.click();
        email.enterText(newEmail);
        saveModifiedInfo.click();
        closeNotificationButton.click();
        Logout.click();
        Login.click();
        email.enterText(userInfo.getTestData("Email"));
        password.enterText(userInfo.getTestData("Password"));
        login.click();
        loginError.validateCriticalMessageExists();
        email.enterText(newEmail);
        password.enterText(userInfo.getTestData("Password"));
        login.click();
        myAccount.click();
        email.validateCriticalField(newEmail);
        Logout.click();
        JsonFileModifier.modifyValue("src/test/resources/testDataFiles/userInfo.json", "Email", newEmail);
    }
}
