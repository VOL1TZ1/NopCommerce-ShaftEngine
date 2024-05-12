package Navigate;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class NavigateBySearch {
   SHAFT.GUI.WebDriver driver;
   String siteURL = "https://demo.nopcommerce.com/";
   String siteTitle = "nopCommerce demo store";
    String searchItem="Apple MacBook Pro 13-inch";
    String searchURL="https://demo.nopcommerce.com/search?q=Apple+MacBook+Pro+13-inch";
    String itemURL="https://demo.nopcommerce.com/apple-macbook-pro-13-inch";


    @BeforeMethod
   public void runThisFirst(){
      // Create new driver object
      driver = new SHAFT.GUI.WebDriver();
      // Go to the website
      driver.browser().navigateToURL(siteURL);
      // To ensure that the site is loaded and there is no problem in the connection
      driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();
   }

   @Test
   public void itemSearch(){

      // Type the item in the Search bar
      driver.element().type(searchBox,searchItem);
      driver.element().click(searchButton);
      // To ensure that the page is loaded and there is no problem in the connection
      driver.verifyThat().browser().url().isEqualTo(searchURL).perform();
      // Click on the item
      driver.element().click(item);
      // To ensure that the page is loaded and there is no problem in the connection
      driver.verifyThat().browser().url().isEqualTo(itemURL).perform();
   }
   @AfterMethod
   public void runThisLast(){
      driver.quit();
      SHAFT.Properties.reporting.openAllureReportAfterExecution();
   }
}
