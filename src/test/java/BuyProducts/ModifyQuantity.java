package BuyProducts;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class ModifyQuantity {

    // Declare class variables
    SHAFT.GUI.WebDriver driver;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";


    // Test method to perform ModifyQuantity
    @Test
    public void ModifyItem(){

    //Click on Elements to navigate and add products to cart
    driver.element().click(Computers);
    driver.element().click(Desktops);
    driver.element().click(AddToCart);
    driver.element().click(ShoppingCart);
    //Increase the quantity of the item 2 times
    driver.element().click(IncreaseItem);
    driver.element().click(IncreaseItem);
    //Verify that the SubTotalPrice matches the SubTotal after increase the quantity
    SubTotalCartPrice = driver.element().getText(SubTotalPriceList);
    driver.assertThat().element(TotalPrice).text().isEqualTo(SubTotalCartPrice);
    //Decrease the quantity by 1
    driver.element().click(DecreaseItem);
    //Verify that the SubTotalPrice matches the SubTotal after decreasing the quantity
    SubTotalCartPrice = driver.element().getText(SubTotalPriceList);
    driver.assertThat().element(TotalPrice).text().isEqualTo(SubTotalCartPrice);
    //Remove the item
    driver.element().click(RemoveItem);
    //Verify that the item has been removed successfully
    driver.verifyThat().element(EmptyShoppingCart).exists().perform();



}


    // Method to run before each test method
    @BeforeMethod
    public void RunThisFirst(){

        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();

    }
    // Method to run after each test method
    @AfterMethod
    public void RunThisLast(){
        // Quit the WebDriver instance
        driver.quit();
        // Open Allure report for reporting
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
