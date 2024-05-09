package Login_Register;


import org.openqa.selenium.By;
import com.shaft.driver.SHAFT.GUI.WebDriver;
import org.openqa.selenium.Keys;

import static java.lang.StringTemplate.STR;

public class Form {
    WebDriver driver;
    public Form(WebDriver driver){
        this.driver = driver;
    }
    public void writeToFieldAndPressEnter(String word, By locator){
        // Perform the action
        if(!driver.element().getText(locator).isEmpty()){
            driver.element().clear(locator).type(locator,word)
                    .keyPress(locator, Keys.ENTER);
        } else {
            driver.element().type(locator,word)
                    .keyPress(locator, Keys.ENTER);
        }
        // Validate the action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(word).perform();
    }

    public void writeToFieldOnly(String word, By locator){
        // Perform the action
        if(!driver.element().getText(locator).isEmpty()){
            driver.element().clear(locator).type(locator,word);
        } else {
            driver.element().type(locator,word);
        }
        // Validate the action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(word).perform();
    }

    public void checkNonCriticalFieldHasTheSameValueAs(String word, By locator){
        driver.assertThat().element(locator).text()
                .isEqualTo(word).perform();
    }
    public void checkCriticalFieldHasTheSameValueAs(String word, By locator){
        driver.verifyThat().element(locator).text()
                .isEqualTo(word).perform();
    }
    public void chooseFromList(String optionName, By locator){
        // Perform the action
        driver.element().select(locator, optionName).click(locator);
        // Validate action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(optionName).perform();
    }
}
