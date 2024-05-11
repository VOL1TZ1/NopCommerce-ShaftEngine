package Scenarios_by_mazen.socialMedia_communityPolls_scenario;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Objects;

public class Social_Polls_Scenario {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    String siteUrl = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    By faceBookIcon = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
    By twitterIcon = By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]");
    By youTubeIcon = By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]");
    By poll1 = By.cssSelector("li[class=\"answer\"] input[id=\"pollanswers-1\"]");
     By poll2 = By.id("[id=\"pollanswers-2\"]");
    By poll3 = By.id("[id=\"pollanswers-3\"]");
     By poll4 = By.id("[id=\"pollanswers-4\"]");
     By voteButton = By.id("vote-poll-1");
    By elementLocator = By.id("poll-block-1"); //to scroll
    By elementLocatorIcons = By.cssSelector("div[class=\"social\"]");//to scroll
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
//        driver.element().scrollToElement(elementLocator);
//        // driver.element().type(poll1,testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE?")).click(poll1);
//        driver.element().click(poll1);
//        driver.element().click(voteButton);
        if(Objects.equals(testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE"),"Excellent")){
            driver.element().scrollToElement(elementLocator);
            driver.element().click(poll1);
        }
        else if(Objects.equals(testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE"),"Good")){
            driver.element().scrollToElement(elementLocator);
            driver.element().click(poll1);
        }
        else if(Objects.equals(testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE"),"Poor")){
            driver.element().scrollToElement(elementLocator);
            driver.element().click(poll3);
        }
        else if(Objects.equals(testData.getTestData("DO_YOU_LIKE_NOPCOMMERCE"),"Very bad")){
            driver.element().scrollToElement(elementLocator);
            driver.element().click(poll4);
        }
        else{
            SHAFT.Report.report("the testData file is contain invalid data");

        }
    }
    @BeforeMethod
    public void runThisFirst(){
        //create new driver
        driver = new SHAFT.GUI.WebDriver();
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/testData.json");

//        maximize
//        driver.browser().fullScreenWindow();
        //go to website
        driver.browser().navigateToURL(siteUrl);
        //to ensure the site loaded is no problem
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();

    }
    @AfterMethod
    public void runThisLast(){
        driver.quit();
      //  SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }




}
