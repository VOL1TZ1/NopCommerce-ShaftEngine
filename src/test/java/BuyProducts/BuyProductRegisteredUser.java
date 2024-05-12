package BuyProducts;

import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Objects;
import static Login_Register.Locators.*;


public class BuyProductRegisteredUser {

    // Declare class variables
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON userInfo;
    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    String EmailGen;
    Faker FakerObject;



    // Test method to perform the purchase as a RegisteredUser With Credit Card As Payment Method
    @Test
    public void BuyProductGuest() {
        //Click on Elements to navigate and add products to cart
        driver.element().click(Computers);
        driver.element().click(Desktops);
        driver.element().click(AddToCart);
        driver.element().click(ShoppingCart);
        //Verify That the selected item has been added successfully
        driver.assertThat().element(ExpectedResult).exists().perform();
        //Agree to terms and proceed to the checkout process
        driver.element().click(AgreeTerms);
        driver.element().click(CheckOut);
        //Click on Register Button
        driver.element().click(registerLink);
        //After redirect to the Register Page fill the information needed
        if (Objects.equals(userInfo.getTestData("Gender"), "Male")) {
            driver.element().click(genderMale);
        } else if (Objects.equals(userInfo.getTestData("Gender"), "Female")) {
            driver.element().click(genderFemale);
        } else {
            SHAFT.Report.report("The gender field in the userInfo.json contains invalid data!!");
        }
        // Fill in the first name
        driver.element().type(firstNameField, userInfo.getTestData("First_NameReg"))
                .keyPress(firstNameField, Keys.ENTER);
        // Fill in the Last name
        driver.element().type(lastNameField, userInfo.getTestData("Last_NameReg"))
                .keyPress(lastNameField, Keys.ENTER);
        // Fill in the date of birth
        driver.element().select(dobDayField, userInfo.getTestData("DoB_Day"))
                .keyPress(dobDayField, Keys.ENTER);
        driver.element().select(dobMonthField, userInfo.getTestData("DoB_Month"))
                .keyPress(dobMonthField, Keys.ENTER);
        driver.element().select(dobYearField, userInfo.getTestData("DoB_Year"))
                .keyPress(dobYearField, Keys.ENTER);

        // Fill in the email
        driver.element().type(emailField, EmailGen);

        // Fill in the Company name
        driver.element().type(companyNameField, userInfo.getTestData("CompanyReg"));

        // Fill in the password
        driver.element().type(passwordField, userInfo.getTestData("Password"));

        // Fill in the confirmation password
        driver.element().type(confirmPasswordField, userInfo.getTestData("Password"));

        //Click on the register button and verify that the user has been added successfully
        driver.element().click(registerButton);
        driver.verifyThat().element(successMessage).exists().perform();
        driver.element().click(continueButton);

        //Proceed to the CheckOut and agree on terms
        driver.element().click(AgreeTerms);
        driver.element().click(CheckOut);

        //Fill the information needed for the checkout
        driver.element().type(FirstName, userInfo.getTestData("First_Name"));
        driver.element().type(LastName, userInfo.getTestData("Last_Name"));
        driver.element().type(Email, EmailGen);
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

        //Confirm Shipping method
        driver.element().click(ContinueShipping);

        //Confirm payment method with credit card
        driver.element().click(CreditCard);
        driver.element().click(CreditCard);
        driver.element().click(ContinuePayment);

        //Add CreditCard Information
        driver.element().type(CardHolderName, userInfo.getTestData("CardHolderName"));
        driver.element().type(CardNumber, userInfo.getTestData("CardNumber"));
        driver.element().select(ExpireMonth, userInfo.getTestData("Exp_Month"));
        driver.element().select(ExpireYear, userInfo.getTestData("Exp_Year"));
        driver.element().type(CardCode, userInfo.getTestData("CardCode"));
        driver.element().click(ContinueInformation);

        //Confirm Order
        driver.element().click(ConfirmOrder);

        //Verify That the order has been added successfully
        driver.verifyThat().element(SuccessMessage).exists().perform();
        driver.element().click(Finish);

    }


    // Method to run before each test method


    @BeforeMethod
    public void RunThisFirst(){

        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo2.json");

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