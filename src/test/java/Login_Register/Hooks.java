package Login_Register;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.DriverManager;

public class Hooks {
    public static SHAFT.GUI.WebDriver driver;
    @BeforeClass
    public void startDriverSession(){
        // Initializations
        String siteURL = "https://demo.nopcommerce.com/";
        String siteTitle = "nopCommerce demo store";
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
        DriverManager.driver = driver;
    }
    @AfterClass
    public void EndDriverSession(){
        // Quit the WebDriver instance
        driver.quit();
    }
}
