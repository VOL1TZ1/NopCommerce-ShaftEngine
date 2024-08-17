package coreElements;

import com.shaft.driver.SHAFT;
import lombok.Setter;
import org.openqa.selenium.By;

public class Element {
    @Setter
    static SHAFT.GUI.WebDriver driver;
    By elementLocator;
    public Element(By locator) {
        elementLocator = locator;
    }
    public void click(){
        driver.element().click(elementLocator);
    }
}
