package Scenarios_by_mazen.add_comment_in_news_sction;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Add_Comment {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    String siteUrl = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    By locateNewSction = By.cssSelector("div[class=\"news-list-homepage\"]");
    By buttonDetails = By.cssSelector("a[href=\"/new-online-store-is-open\"][class=\"read-more\"]");
    By locateCommentFields = By.cssSelector("form[action=\"/News/NewsCommentAdd?newsitemid=3\"]");
    By titleField = By.id("AddNewComment_CommentTitle");
    By bodyField = By.id("AddNewComment_CommentText");
    By newCommentButton = By.cssSelector("button[name=\"add-comment\"]");

    By verifyMsgAddedComment = By.cssSelector("div[class=\"notifications\"]");





    @Test
    public void addComment(){
        //scroll down to find section news
        driver.element().scrollToElement(locateNewSction);
        //locate button details for item one in category news
        driver.element().click(buttonDetails);
        //scroll down to comments fields
        driver.element().scrollToElement(locateCommentFields);
        //locate title fields
        driver.element().type(titleField,testData.getTestData("Comment_Title"));
        //locate body fields
        driver.element().type(bodyField,testData.getTestData("Comment_Body"));
        //locate new comment button
        driver.element().click(newCommentButton);

        //assertion
        String expectedRes = "News comment is successfully added.";
        String actualRes = driver.element().getText(verifyMsgAddedComment);
        //soft assertion
        driver.verifyThat().element(verifyMsgAddedComment).text().isEqualTo(expectedRes).perform();
        //Assert.assertTrue(expectedRes.contains(actualRes));






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
