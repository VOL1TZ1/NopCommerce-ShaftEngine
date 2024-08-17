package coreElements;

import org.openqa.selenium.By;

import java.util.Locale;

public class CheckBox extends Element{
    public CheckBox(By locator) {
        super(locator);
    }
    public void check(){
        if(driver.element().getAttribute(elementLocator, "checked").contains("false")){
            driver.element().click(elementLocator);
        }
    }
    public void unCheck(){
        if(driver.element().getAttribute(elementLocator, "checked").contains("true")){
            driver.element().click(elementLocator);
        }
    }
    public void validateCriticalCheckboxIsChecked(){
        driver.assertThat().element(elementLocator)
                .attribute("checked")
                .isEqualTo("true").perform();
    }
    public void validateNonCriticalCheckboxIsChecked(){
        driver.verifyThat().element(elementLocator)
                .attribute("checked")
                .isEqualTo("true").perform();
    }
    public void validateCriticalCheckboxIsUnChecked(){
        driver.assertThat().element(elementLocator)
                .attribute("checked")
                .isEqualTo("false").perform();
    }
    public void validateNonCriticalCheckboxIsUnChecked(){
        driver.verifyThat().element(elementLocator)
                .attribute("checked")
                .isEqualTo("false").perform();
    }
}
