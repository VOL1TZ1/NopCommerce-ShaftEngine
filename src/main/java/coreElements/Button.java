package coreElements;

import org.openqa.selenium.By;

public class Button extends Icon {
    public Button(By locator) {
        super(locator);
    }
    public void getText(){
        driver.element().getText(elementLocator);
    }
}
