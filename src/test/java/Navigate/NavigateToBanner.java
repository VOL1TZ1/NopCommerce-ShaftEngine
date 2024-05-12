package Navigate;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class NavigateToBanner {
    SHAFT.GUI.WebDriver driver;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    String expectedSite ="https://demo.nopcommerce.com/cell-phones?viewmode=grid&orderby=0&pagesize=6";

    @BeforeMethod
    public void runThisFirst(){
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site is loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
    }
    @Test(priority = 4)
    public void Banner(){
        driver.element().click(bannerImage);
        //String actualSite =driver.browser().getCurrentURL();
        driver.verifyThat().browser().title().isEqualTo(expectedSite).perform();
    }
    @AfterMethod
    public void runThisLast(){
        driver.quit();
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
