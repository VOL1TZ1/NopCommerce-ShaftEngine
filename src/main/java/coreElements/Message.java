package coreElements;

import com.shaft.driver.SHAFT;
import lombok.Setter;
import org.openqa.selenium.By;

public class Message {
    @Setter
    static SHAFT.GUI.WebDriver driver;
    By elementLocator;
    public Message(By locator) {
        elementLocator = locator;
    }
    public void validateCriticalMessageExists(){
        driver.assertThat().element(elementLocator).exists().perform();
    }
    public void validateNonCriticalMessageExists(){
        driver.verifyThat().element(elementLocator).exists().perform();
    }
}
