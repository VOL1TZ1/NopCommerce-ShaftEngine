package Login_Register;

import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;
import pages.DriverManager;

import static pages.P01_Register.*;
import static pages.P02_Login.*;
public class D02_LoginRegisteredUser extends DriverManager {
    SHAFT.TestData.JSON userInfo = new SHAFT.TestData.JSON("userInfo.json");

    @Test
    public void loginUser(){
        Login.click();
        email.enterText(userInfo.getTestData("Email"));
        password.enterText(userInfo.getTestData("Password"));
        login.click();
        myAccount.click();
        email.validateCriticalField(userInfo.getTestData("Email"));
        Logout.click();
    }
}
