package coreElements;

import org.openqa.selenium.By;

import static Locators.L01_Register.emailField;

public class FormField extends Element{

    public FormField(By locator) {
        super(locator);
    }

    public void enterText(String text){
        driver.element().type(elementLocator, text);
    }
    public String getText(){
        return driver.element().getText(elementLocator);
    }
    public void validateCriticalField(String expectedValue){
        driver.assertThat().element(elementLocator).text()
                .isEqualTo(expectedValue).perform();
    }
    public void validateNonCriticalField(String expectedValue){
        driver.verifyThat().element(elementLocator).text()
                .isEqualTo(expectedValue).perform();
    }
}
