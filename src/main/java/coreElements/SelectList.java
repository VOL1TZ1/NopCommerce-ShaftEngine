package coreElements;

import org.openqa.selenium.By;

public class SelectList extends Element {
    public SelectList(By locator) {
        super(locator);
    }
    public void selectOption(String option){
        driver.element().select(elementLocator, option).click(elementLocator);
    }
}
