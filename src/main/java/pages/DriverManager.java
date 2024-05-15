package pages;

import com.shaft.driver.SHAFT;
import coreElements.Element;
import coreElements.Message;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverManager {
    public static SHAFT.GUI.WebDriver driver;
    @BeforeClass
    public void startDriverSession(){
        // Initializations
        String siteURL = "https://demo.nopcommerce.com/";
        String siteTitle = "nopCommerce demo store";
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        Element.setDriver(driver);
        Message.setDriver(driver);
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
    }
    @AfterClass
    public void EndDriverSession(){
        // Quit the WebDriver instance
        driver.quit();
    }
}
