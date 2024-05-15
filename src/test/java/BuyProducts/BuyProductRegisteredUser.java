package BuyProducts;

import Login_Register.Form;
import Login_Register.Hooks;
import com.github.javafaker.Faker;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;


public class BuyProductRegisteredUser extends Hooks {

    // Declare class variables
    SHAFT.TestData.JSON userInfo;
    SHAFT.TestData.JSON creditCardInfo;
    String EmailGen;
    Form form;
    @BeforeMethod
    public void Initializations(){
        // Extract user information
        userInfo = new SHAFT.TestData.JSON("userInfo.json");
        creditCardInfo = new SHAFT.TestData.JSON("fakeCreditCardInfo.json");
        form = new Form(driver);
        Faker FakerObject = new Faker();
        EmailGen = FakerObject.internet().safeEmailAddress();
    }
    
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
        //Click on Register coreElements.Button
        driver.element().click(registerLink);
        //After redirect to the Register Page fill the information needed
        form.chooseGenderRadioButton(userInfo.getTestData("Gender"), driver);
        // Fill in the first name
        form.writeToFieldOnly(userInfo.getTestData("First_Name"),firstNameField);
        // Fill in the Last name
        form.writeToFieldOnly(userInfo.getTestData("Last_Name"),lastNameField);
        // Fill in the date of birth
        form.chooseFromList(userInfo.getTestData("DoB_Day"), dobDayField);
        form.chooseFromList(userInfo.getTestData("DoB_Month"), dobMonthField);
        form.chooseFromList(userInfo.getTestData("DoB_Year"), dobYearField);
        // Fill in the email
        form.writeToFieldOnly(EmailGen,emailField);
        // Fill in the Company name
        form.writeToFieldOnly(userInfo.getTestData("Company"),companyNameField);
        // Fill in the password
        form.writeToFieldOnly(userInfo.getTestData("Password"),passwordField);
        // Fill in the confirmation password
        form.writeToFieldOnly(userInfo.getTestData("Password"),confirmPasswordField);
        // Press the save button
        driver.element().click(registerButton);
        // Check that the success message appears
        driver.assertThat().element(successMessage).exists().perform();
        // Press the continue button
        driver.element().click(continueButton);

        //Proceed to the CheckOut and agree on terms
        driver.element().click(AgreeTerms);
        driver.element().click(CheckOut);

        //Validate the information added during registration
        form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("First_Name"), FirstName);
        form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("Last_Name"), LastName);
        form.checkCriticalFieldHasTheSameValueAs(EmailGen, Email);
        form.checkCriticalFieldHasTheSameValueAs(userInfo.getTestData("Company"), Company);

        //Fill the rest of the information needed for the checkout
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
        driver.element().type(CardHolderName, creditCardInfo.getTestData("CardHolderName"));
        driver.element().type(CardNumber, creditCardInfo.getTestData("CardNumber"));
        driver.element().select(ExpireMonth, creditCardInfo.getTestData("Exp_Month"));
        driver.element().select(ExpireYear, creditCardInfo.getTestData("Exp_Year"));
        driver.element().type(CardCode, creditCardInfo.getTestData("CardCode"));
        driver.element().click(ContinueInformation);

        //Confirm Order
        driver.element().click(ConfirmOrder);


        //Verify That the order has been added successfully
        driver.verifyThat().element(SuccessMessage).exists().perform();
        driver.element().click(Finish);

    }
}