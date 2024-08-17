package SocialMedia_CommentSection;

import Login_Register.Hooks;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Login_Register.Locators.*;

public class Add_Comment extends Hooks{
    SHAFT.TestData.JSON testData;

    @BeforeMethod
    public void Initializations(){
        testData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/exampleComment.json");
    }

    @Test(priority = 6)
    public void addComment(){
        //scroll down to find section news
        driver.element().scrollToElement(locateNewSection);
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
        //soft assertion
        driver.verifyThat().element(verifyMsgAddedComment).text().isEqualTo(expectedRes).perform();
    }
}
