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
    By ExpectedResult = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    By AgreeTerms = By.id("termsofservice");
    By CheckOut = By.id("checkout");
    By CheckOutGuest = By.xpath("//button[contains(@class, 'checkout-as-guest-button')]");
    By FirstName = By.id("BillingNewAddress_FirstName");
    By LastName = By.id("BillingNewAddress_LastName");
    By Email = By.id("BillingNewAddress_Email");
    By Company = By.id("BillingNewAddress_Company");
    By CountryButton = By.id("BillingNewAddress_CountryId");
    By SelectCountry = By.xpath("//*[text()='Egypt']");

    By City = By.id("BillingNewAddress_City");
    By Address1 = By.id("BillingNewAddress_Address1");
    By Address2 = By.id("BillingNewAddress_Address2");
    By ZipCode = By.id("BillingNewAddress_ZipPostalCode");
    By PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By FaxNumber = By.id("BillingNewAddress_FaxNumber");
    By ContinueButton = By.xpath("(//button[contains(@class, 'new-address-next-step-button')])[1]");

    By ContinueShipping = By.xpath("//button[contains(@class, 'shipping-method-next-step-button')]");
    By ContinuePayment = By.xpath("//button[contains(@class, 'payment-method-next-step-button')]");
    By ContinueInformation = By.xpath("//button[contains(@class, 'payment-info-next-step-button')]");
    By ConfirmOrder = By.xpath("//button[contains(@class, 'confirm-order-next-step-button')]");
    By SuccessMessage = By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]");
    By Finish = By.xpath("//button[contains(@class, 'order-completed-continue-button')]");

    @Test
    public void BuyProductGuest(){
    driver.element().click(Computers);
    driver.element().click(Desktops);
    driver.element().click(AddToCart);
    driver.element().click(ShoppingCart);
    driver.assertThat().element(ExpectedResult).exists().perform();
    driver.element().click(AgreeTerms);
    driver.element().click(CheckOut);
    driver.element().click(CheckOutGuest);


    driver.element().type(FirstName, userInfo.getTestData("First_Name"));

    driver.element().type(LastName, userInfo.getTestData("Last_Name"));

    driver.element().type(Email, userInfo.getTestData("Email"));

    driver.element().type(Company, userInfo.getTestData("Company"));


    driver.element().click(CountryButton);
    driver.element().click(SelectCountry);

    driver.element().type(City, userInfo.getTestData("City"));

        driver.element().type(Address1, userInfo.getTestData("Address1"));

        driver.element().type(Address2, userInfo.getTestData("Address2"));

        driver.element().type(ZipCode, userInfo.getTestData("ZipCode"));

        driver.element().type(PhoneNumber, userInfo.getTestData("PhoneNumber"));

        driver.element().type(FaxNumber, userInfo.getTestData("FaxNumber"));

        driver.element().click(ContinueButton);
        driver.element().click(ContinueShipping);
        driver.element().click(ContinuePayment);
        driver.element().click(ContinueInformation);
        driver.element().click(ConfirmOrder);
        driver.verifyThat().element(SuccessMessage).exists().perform();
        driver.element().click(Finish);


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
