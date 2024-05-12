package Navigate;

import Login_Register.Hooks;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;


public class NavigateToCategory extends Hooks {
    String computersURL="https://demo.nopcommerce.com/computers";
    String desktopURL="https://demo.nopcommerce.com/desktops";

    @Test(priority = 4)
    public void category(){
        // Click on the Computer Category
        driver.element().click(Computers);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(computersURL).perform();
        // Click on the Desktop Subcategory
        driver.element().click(desktopSub);
        // To ensure that the page is loaded and there is no problem in the connection
        //driver.verifyThat().browser().title().isEqualTo(desktopURL).perform();
        driver.element().click(itemCat);



    }
}
