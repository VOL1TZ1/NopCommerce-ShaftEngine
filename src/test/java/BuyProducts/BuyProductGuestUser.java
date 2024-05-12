package BuyProducts;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class BuyProductGuestUser {

    // Declare class variables
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON userInfo;
    Faker FakerObject;
    String EmailGen;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";





    // Test method to perform the purchase as a guest
    @Test
    public void BuyProductGuest(){

    //Click on Elements to navigate and add products to cart
    driver.element().click(Computers);
    driver.element().click(Desktops);
    driver.element().click(AddToCart);
    driver.element().click(ShoppingCart);

    // Verify expected result (The item selected has been added successfully.)
    driver.assertThat().element(ExpectedResult).exists().perform();

    //Fill in the guest check out information
    driver.element().click(AgreeTerms);
    driver.element().click(CheckOut);
    driver.element().click(CheckOutGuest);

    //Add the information needed to The Checkout process
    driver.element().type(FirstName, userInfo.getTestData("First_Name"));
    driver.element().type(LastName, userInfo.getTestData("Last_Name"));
    driver.element().type(Email, EmailGen);
    driver.element().type(Company, userInfo.getTestData("Company"));
    //Select the country
    driver.element().click(CountryButton);
    driver.element().click(SelectCountry);

    driver.element().type(City, userInfo.getTestData("City"));
    driver.element().type(Address1, userInfo.getTestData("Address1"));
    driver.element().type(Address2, userInfo.getTestData("Address2"));
    driver.element().type(ZipCode, userInfo.getTestData("ZipCode"));
    driver.element().type(PhoneNumber, userInfo.getTestData("PhoneNumber"));
    driver.element().type(FaxNumber, userInfo.getTestData("FaxNumber"));
    driver.element().click(ContinueButton);

    //Confirm Shipping method
    driver.element().click(ContinueShipping);
    //Confirm payment method
    driver.element().click(ContinuePayment);
    //Confirm Payment information
    driver.element().click(ContinueInformation);
    //Confirm order
    driver.element().click(ConfirmOrder);
    //verify that the order has been successfully processed
    driver.verifyThat().element(SuccessMessage).exists().perform();
    driver.element().click(Finish);


    }

    // Method to run before each test method
    @BeforeMethod
    public void RunThisFirst(){
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        FakerObject = new Faker();
        EmailGen = FakerObject.internet().safeEmailAddress();
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
