package Login_Register;

import org.openqa.selenium.By;

public class Locators {

    /**
     * Login Scenario Locators
     * **/
    static By loginLink = By.cssSelector("a[class = ico-login]");
    static By loginButton = By.xpath("//*[contains(@class, 'login-button')]");
    /**
     * Modify User Info Scenario Locators
     * **/
    static By saveButton = By.id("save-info-button");
    static By validationError = By.className("validation-summary-errors");
    static By closeNotification = By.cssSelector("span[class=close]");
    /**
     * Buy Product (Add To Card)
     * **/
    public static By Computers = By.xpath("(//a[@href='/computers'])[1]");
    public static By Desktops = By.xpath("//img[@alt='Picture for category Desktops']");
    public static By AddToCart = By.xpath("(//button[contains(@class, 'product-box-add-to-cart-button')])[2]");
    public static By ShoppingCart = By.xpath("//span[@class='cart-label']");
    public static By ExpectedResult = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    /**
     * Buy Product (Agree And Confirm Terms)
     * **/
    public static By AgreeTerms = By.id("termsofservice");
    public static By CheckOut = By.id("checkout");
    /**
     * Buy Product (ModifyQuantity)
     * **/
    public static By IncreaseItem = By.xpath("//div[contains(@class, 'quantity up')]");
    public static By DecreaseItem = By.xpath("//div[contains(@class, 'quantity down')]");

    public static By RemoveItem = By.className("remove-btn");
    public static By SubTotalPriceList = By.xpath("(//span[@class='value-summary'])[1]");
    public static By TotalPrice = By.className("product-subtotal");
    public static By EmptyShoppingCart = By.xpath("//div[contains(text(), 'Your Shopping Cart is empty!')]");
    /**
     * Navigate (NavigateBySearch)
     * **/
    public static By searchBox= By.id("small-searchterms");
    public static By searchButton= By.xpath("//*[@id=\"small-search-box-form\"]/button");
    public static By item=By.linkText("Apple MacBook Pro 13-inch");
    /**
     * Navigate (NavigateToBanner)
     * **/
    public static By bannerImage= By.className("nivo-main-image");
    /**
     * Navigate (NavigateToCategory)
     * **/
    public static By desktopSub = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[1]/div/div[1]/div");
    public static By itemCat = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/h2/a");
    /**
     * SocialMedia_CommentSection (Add_Comment)
     * **/
    public static By locateNewSection = By.cssSelector("div[class=\"news-list-homepage\"]");
    public static By buttonDetails = By.cssSelector("a[href=\"/new-online-store-is-open\"][class=\"read-more\"]");
    public static By locateCommentFields = By.cssSelector("form[action=\"/News/NewsCommentAdd?newsitemid=3\"]");
    public static By titleField = By.id("AddNewComment_CommentTitle");
    public static By bodyField = By.id("AddNewComment_CommentText");
    public static By newCommentButton = By.cssSelector("button[name=\"add-comment\"]");
    public static By verifyMsgAddedComment = By.cssSelector("div[class=\"notifications\"]");
    /**
     * SocialMedia_CommentSection (Social_Polls_Scenario)
     * **/
    public static By pollOptionExcellent = By.cssSelector("li[class=\"answer\"] input[id=\"pollanswers-1\"]");
    public static By pollOptionGood = By.id("[id=\"pollanswers-2\"]");
    public static By pollOptionPoor = By.id("[id=\"pollanswers-3\"]");
    public static By pollOptionVeryBad = By.id("[id=\"pollanswers-4\"]");
    public static By faceBookIcon = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
    public static By twitterIcon = By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]");
    public static By youTubeIcon = By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]");
    public static By elementLocator = By.id("poll-block-1"); //to scroll
    public static By elementLocatorIcons = By.cssSelector("div[class=\"social\"]");//to scroll
    /**
     * SocialMedia_CommentSection (Wish_List)
     * **/
    public static By scrollDown = By.cssSelector("div[class=\"product-grid home-page-product-grid\"]");     //to scroll
    public static By scrollUp =By.cssSelector("div[class=\"header-upper\"]");
    public static By wishListIconInItem=By.cssSelector("div[data-productid=\"18\"] button[title=\"Add to wishlist\"]");
    public static By wishListButton = By.cssSelector("a[class=\"ico-wishlist\"]");
    public static By titleForItem = By.cssSelector("div[data-productid=\"18\"] div[class=\"details\"]");
    public static By barClose = By.cssSelector("span[title=\"Close\"]");
    public static By itemTitle = By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"][class=\"product-name\"]");
    /**
     * Registration Scenario Locators
     * **/
    public static By registerLink = By.linkText("Register");
    public static By genderMale = By.id("gender-male");
    public  static By genderFemale = By.id("gender-female");
    public static By firstNameField = By.name("FirstName");
    public static By lastNameField = By.name("LastName");
    public static By dobDayField = By.name("DateOfBirthDay");
    public static By dobMonthField = By.name("DateOfBirthMonth");
    public static By dobYearField = By.name("DateOfBirthYear");
    public static By emailField = By.name("Email");
    public static By companyNameField = By.name("Company");
    public static By passwordField = By.name("Password");
    public  static By confirmPasswordField = By.name("ConfirmPassword");
    public static By registerButton = By.name("register-button");
    public static By continueButton = By.xpath("//*[contains(@class, 'register-continue-button')]");
    public static By myAccount = By.cssSelector("a[class = ico-account]");
    public static By logoutLink = By.cssSelector("a[class = ico-logout]");
    public static By successMessage = By.xpath("//*[contains(text(), 'registration completed')]");
    /**
     * Buy Product (As A Guest)
     * **/
    public static By CheckOutGuest = By.xpath("//button[contains(@class, 'checkout-as-guest-button')]");
    public static By FirstName = By.id("BillingNewAddress_FirstName");
    public static By LastName = By.id("BillingNewAddress_LastName");
    public static By Email = By.id("BillingNewAddress_Email");
    public static By Company = By.id("BillingNewAddress_Company");
    public static By CountryButton = By.id("BillingNewAddress_CountryId");
    public static By SelectCountry = By.xpath("//*[text()='Egypt']");
    public static By City = By.id("BillingNewAddress_City");
    public static By Address1 = By.id("BillingNewAddress_Address1");
    public static By Address2 = By.id("BillingNewAddress_Address2");
    public static By ZipCode = By.id("BillingNewAddress_ZipPostalCode");
    public static By PhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    public static By FaxNumber = By.id("BillingNewAddress_FaxNumber");
    public static By ContinueButton = By.xpath("(//button[contains(@class, 'new-address-next-step-button')])[1]");
    //Locators For Confirm shipping address
    public static By ContinueShipping = By.xpath("//button[contains(@class, 'shipping-method-next-step-button')]");
    //Locators For choosing payment method
    public static By CreditCard = By.id("paymentmethod_1");
    public static By CardHolderName = By.id("CardholderName");
    public static By CardNumber = By.id("CardNumber");
    public static By ExpireMonth = By.id("ExpireMonth");
    public static By ExpireYear = By.id("ExpireYear");
    public static By CardCode = By.id("CardCode");
    //Locators for confirm the process
    public static By ContinuePayment = By.xpath("//button[contains(@class, 'payment-method-next-step-button')]");
    public static By ContinueInformation = By.xpath("//button[contains(@class, 'payment-info-next-step-button')]");
    public static By ConfirmOrder = By.xpath("//button[contains(@class, 'confirm-order-next-step-button')]");
    public static By SuccessMessage = By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]");
    public static By Finish = By.xpath("//button[contains(@class, 'order-completed-continue-button')]");
}
