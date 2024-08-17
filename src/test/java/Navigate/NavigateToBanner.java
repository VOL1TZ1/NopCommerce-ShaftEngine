package Navigate;

import Login_Register.Hooks;
import org.testng.annotations.Test;
import static Login_Register.Locators.*;

public class NavigateToBanner extends Hooks {
    String expectedSite ="https://demo.nopcommerce.com/cell-phones?viewmode=grid&orderby=0&pagesize=6";

    @Test(priority = 4)
    public void Banner(){
        driver.element().click(bannerImage);
        driver.verifyThat().browser().title().isEqualTo(expectedSite).perform();
    }
}
