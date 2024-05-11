package Scenarios_by_mazen.wish_list;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wish_List {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;
    String siteUrl = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";

    By scrollDown = By.cssSelector("div[class=\"product-grid home-page-product-grid\"]");     //to scroll
    By scrollUp =By.cssSelector("div[class=\"header-upper\"]");

    By wishListIconInItem=By.cssSelector("div[data-productid=\"18\"] button[title=\"Add to wishlist\"]");
    By wishListButton = By.cssSelector("a[class=\"ico-wishlist\"]");

    By titleForItem = By.cssSelector("div[data-productid=\"18\"] div[class=\"details\"]");

    By barClose = By.cssSelector("span[title=\"Close\"]");
    By itemTitle = By.cssSelector("a[href=\"/htc-one-m8-android-l-50-lollipop\"][class=\"product-name\"]");




    @Test(priority = 6)
    public void check_wish_list(){
        //scroll down
        driver.element().scrollToElement(scrollDown);
        //click to add to wish list
        driver.element().click(wishListIconInItem);
        // return title for item
        String expectedTitle =driver.element().getText(titleForItem);
        System.out.println(expectedTitle);
        //scroll up
        driver.element().scrollToElement(scrollUp);
        //close the bar that refer to added item successfully
        driver.element().click(barClose);
        //go to wish list page
        driver.element().click(wishListButton);
        //get actual title from wish list page
        String actualTitle = driver.element().getText(itemTitle);
        System.out.println(actualTitle);
        //to verify the item added successfully
        Assert.assertTrue(expectedTitle.contains(actualTitle));




    }
    @BeforeMethod
    public void runThisFirst(){
        //create new driver
        driver = new SHAFT.GUI.WebDriver();
//        maximize
//        driver.browser().fullScreenWindow();
        //go to website
        driver.browser().navigateToURL(siteUrl);
        //to ensure the site loaded is no problem
        driver.verifyThat().browser().title().isEqualTo(siteTitle).perform();

    }
    @AfterMethod
    public void runThisLast(){
        driver.quit();
        //  SHAFT.Properties.reporting.openAllureReportAfterExecution();
    }
}
