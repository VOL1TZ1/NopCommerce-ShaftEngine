package BuyProducts;

import Login_Register.Hooks;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class ModifyQuantity extends Hooks {
    // Test method to perform ModifyQuantity
    @Test
    public void ModifyItem(){
        String SubTotalCartPrice;
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
}
