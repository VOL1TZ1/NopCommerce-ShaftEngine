package Navigate;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigateToCategory {
    SHAFT.GUI.WebDriver driver;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    By computersCategory=  By.linkText("Computers");
    String computersURL="https://demo.nopcommerce.com/computers";
    By desktopSub = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div");
    String desktopURL="https://demo.nopcommerce.com/desktops";
    By item= By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");

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
        driver.element().click(computersCategory);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(computersURL).perform();
        // Click on the Desktop Subcategory
        driver.element().click(desktopSub);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(desktopURL).perform();
        driver.element().click(item);



    }
    @AfterMethod
    public void runThisLast(){
        driver.quit();
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
