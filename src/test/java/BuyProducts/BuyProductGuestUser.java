package BuyProducts;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyProductGuestUser {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON userInfo;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    By Computers = By.xpath("(//a[@href='/computers'])[1]");
    By Desktops = By.xpath("//img[@alt='Picture for category Desktops']");
    By AddToCart = By.xpath("(//button[contains(@class, 'product-box-add-to-cart-button')])[2]");
    By ShoppingCart = By.xpath("//span[@class='cart-label']");
    By AgreeTerms = By.id("termsofservice");
    By CheckOut = By.id("checkout");
    By CheckOutGuest = By.xpath("//button[contains(@class, 'checkout-as-guest-button')]");
    By FirstName = By.id("BillingNewAddress_FirstName");
    By LastName = By.id("BillingNewAddress_LastName");
    By Email = By.id("BillingNewAddress_Email");
    By Company = By.id("BillingNewAddress_Company");
    By CountryButton = By.id("BillingNewAddress_CountryId");
    By SelectCountry = By.xpath("//*[text()='Egypt']");
   // By StateButton = By.id("BillingNewAddress_StateProvinceId");
   // By SelectState = By.xpath("//*[text()='Egypt']");
    By City = By.id("BillingNewAddress_City");
    By Address1 = By.id("BillingNewAddress_Address1");
    By Address2 = By.id("BillingNewAddress_Address2");
    By ZipCode = By.id("BillingNewAddress_ZipPostalCode");
    By PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By FaxNumber = By.id("BillingNewAddress_FaxNumber");
    By ContinueButton = By.xpath("(//button[contains(@class, 'new-address-next-step-button')])[1]");



    @Test
    public void BuyProductGuest(){
    driver.element().click(Computers);
    driver.element().click(Desktops);
    driver.element().click(AddToCart);
    driver.element().click(ShoppingCart);
    driver.element().click(AgreeTerms);
    driver.element().click(CheckOut);
    driver.element().click(CheckOutGuest);

    driver.element().type(FirstName, userInfo.getTestData("First_Name"))
                .keyPress(FirstName, Keys.ENTER);
    driver.element().type(LastName, userInfo.getTestData("Last_Name"))
                .keyPress(LastName, Keys.ENTER);
    driver.element().type(Email, userInfo.getTestData("Email"))
                .keyPress(Email, Keys.ENTER);
    driver.element().type(Company, userInfo.getTestData("Company"))
                .keyPress(Company, Keys.ENTER);

    driver.element().click(CountryButton);
    driver.element().click(SelectCountry);

    driver.element().type(City, userInfo.getTestData("City"))
                .keyPress(City, Keys.ENTER);
        driver.element().type(Address1, userInfo.getTestData("Address1"))
                .keyPress(Address1, Keys.ENTER);
        driver.element().type(Address2, userInfo.getTestData("Address2"))
                .keyPress(Address2, Keys.ENTER);
        driver.element().type(ZipCode, userInfo.getTestData("ZipCode"))
                .keyPress(ZipCode, Keys.ENTER);
        driver.element().type(PhoneNumber, userInfo.getTestData("PhoneNumber"))
                .keyPress(PhoneNumber, Keys.ENTER);
        driver.element().type(FaxNumber, userInfo.getTestData("FaxNumber"))
                .keyPress(FaxNumber, Keys.ENTER);
        driver.element().click(ContinueButton);



    }

    @BeforeMethod
    public void RunThisFirst(){
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        // Create new driver object
        driver = new SHAFT.GUI.WebDriver();
        // Go to the website
        driver.browser().navigateToURL(siteURL);
        // To ensure that the site loaded and there is no problem in the connection
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();

    }
    @AfterMethod
    public void RunThisLast(){
        driver.quit();
        SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
