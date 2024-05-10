package BuyProducts;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModifyQuantity {
    SHAFT.GUI.WebDriver driver;

    String siteURL = "https://demo.nopcommerce.com/";
    String siteTitle = "nopCommerce demo store";
    By Computers = By.xpath("(//a[@href='/computers'])[1]");
    By Desktops = By.xpath("//img[@alt='Picture for category Desktops']");
    By AddToCart = By.xpath("(//button[contains(@class, 'product-box-add-to-cart-button')])[2]");
    By ShoppingCart = By.xpath("//span[@class='cart-label']");
    By IncreaseItem = By.xpath("//div[contains(@class, 'quantity up')]");
    By DecreaseItem = By.xpath("//div[contains(@class, 'quantity down')]");
    By TotalPrice = By.className("product-subtotal");
    By RemoveItem = By.className("remove-btn");
    By SubTotalPriceList = By.xpath("(//span[@class='value-summary'])[1]");
    String SubTotalCartPrice;
    By EmptyShoppingCart = By.xpath("//div[contains(text(), 'Your Shopping Cart is empty!')]");
@Test
    public void ModifyItem(){

    driver.element().click(Computers);
    driver.element().click(Desktops);
    driver.element().click(AddToCart);
    driver.element().click(ShoppingCart);
    driver.element().click(IncreaseItem);
    driver.element().click(IncreaseItem);
    SubTotalCartPrice = driver.element().getText(SubTotalPriceList);
    driver.assertThat().element(TotalPrice).text().isEqualTo(SubTotalCartPrice);
    driver.element().click(DecreaseItem);
    SubTotalCartPrice = driver.element().getText(SubTotalPriceList);
    driver.assertThat().element(TotalPrice).text().isEqualTo(SubTotalCartPrice);
    driver.element().click(RemoveItem);
    driver.verifyThat().element(EmptyShoppingCart).exists().perform();



}
    @BeforeMethod
    public void RunThisFirst(){
        // Extract user information
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
