package SocialMedia_CommentSection;

import Login_Register.Form;
import Login_Register.Hooks;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


import static Login_Register.Locators.*;
public class Social_Polls_Scenario extends Hooks {
    SHAFT.TestData.JSON testData;
    Form form;
    @BeforeMethod
    public void initializations(){
        // Create a form object to be used to use the poll choice option
        form = new Form(driver);
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/exampleComment.json");
    }
    @Test(priority = 5)
    public void icons_checking()  {
        //check facebook icon is working
        driver.element().scrollToElement(elementLocatorIcons);
        driver.element().click(faceBookIcon);
        ArrayList<String> tabs = new ArrayList<>(driver.browser().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(1));
        String acutalResult = driver.browser().getCurrentURL();
        String expectedResult = "https://www.facebook.com/nopCommerce";
        Assert.assertEquals(acutalResult,expectedResult);
        System.out.println(driver.browser().getCurrentWindowTitle());
        driver.browser().switchToWindow(tabs.getFirst());

        //check twitter icon is working
        driver.element().scrollToElement(elementLocatorIcons);
        driver.element().click(twitterIcon);
        tabs = new ArrayList<>(driver.browser().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(2));
        acutalResult = driver.browser().getCurrentURL();
        expectedResult = "https://twitter.com/nopCommerce";
        Assert.assertEquals(acutalResult,expectedResult);
        System.out.println(driver.browser().getCurrentWindowTitle());
        driver.browser().switchToWindow(tabs.getFirst());

        //check YouTube icon is working
        driver.element().scrollToElement(elementLocatorIcons);
        driver.element().click(youTubeIcon);
        tabs = new ArrayList<>(driver.browser().getWindowHandles());
        driver.browser().switchToWindow(tabs.getLast());
        acutalResult = driver.browser().getCurrentURL();
        expectedResult = "https://www.youtube.com/user/nopCommerce";
        Assert.assertEquals(acutalResult,expectedResult);
        System.out.println(driver.browser().getCurrentWindowTitle());
        driver.browser().switchToWindow(tabs.getFirst());
    }

    @Test(priority = 6)
    public void polls_checking()  {
        form.chooseFromPoll(testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE"), driver);
    }
}
