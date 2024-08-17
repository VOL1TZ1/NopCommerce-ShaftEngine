package Navigate;

import Login_Register.Hooks;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class NavigateBySearch extends Hooks {
    String searchItem="Apple MacBook Pro 13-inch";
    String searchURL="https://demo.nopcommerce.com/search?q=Apple+MacBook+Pro+13-inch";
    String itemURL="https://demo.nopcommerce.com/apple-macbook-pro-13-inch";

   @Test
   public void itemSearch(){
      // Type the item in the Search bar
      driver.element().type(searchBox,searchItem);
      driver.element().click(searchButton);
      // To ensure that the page is loaded and there is no problem in the connection
      driver.verifyThat().browser().url().isEqualTo(searchURL).perform();
      // Click on the item
      driver.element().click(item);
      // To ensure that the page is loaded and there is no problem in the connection
      driver.verifyThat().browser().url().isEqualTo(itemURL).perform();
   }
}
