package Navigate;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;


public class NavigateToCategory {
    SHAFT.GUI.WebDriver driver;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    String computersURL="https://demo.nopcommerce.com/computers";
    String desktopURL="https://demo.nopcommerce.com/desktops";


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
    public void category(){
        // Click on the Computer Category
        driver.element().click(Computers);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(computersURL).perform();
        // Click on the Desktop Subcategory
        driver.element().click(desktopSub);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(desktopURL).perform();
        driver.element().click(itemCat);



    }
    @AfterMethod
    public void runThisLast(){
        driver.quit();
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
