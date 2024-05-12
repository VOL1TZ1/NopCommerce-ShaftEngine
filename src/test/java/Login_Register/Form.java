package Login_Register;


import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import com.shaft.driver.SHAFT.GUI.WebDriver;
import org.openqa.selenium.Keys;

import java.util.Objects;

import static Login_Register.Locators.*;

public class Form {
    WebDriver driver;
    public Form(WebDriver driver){
        this.driver = driver;
    }
    public void writeToFieldAndPressEnter(String word, By locator){
        // Perform the action
        driver.element().type(locator,word)
                .keyPress(locator, Keys.ENTER);
        // Validate the action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(word).perform();
    }

    public void writeToFieldOnly(String word, By locator){
        // Perform the action
        driver.element().type(locator,word);
        // Validate the action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(word).perform();
    }

    public void checkNonCriticalFieldHasTheSameValueAs(String word, By locator){
        driver.verifyThat().element(locator).text()
                .isEqualTo(word).perform();
    }
    public void checkCriticalFieldHasTheSameValueAs(String word, By locator){
        driver.assertThat().element(locator).text()
                .isEqualTo(word).perform();
    }
    public void chooseFromList(String optionName, By locator){
        // Perform the action
        driver.element().select(locator, optionName).click(locator);
        // Validate action result
        driver.assertThat().element(locator)
                .attribute("value").isEqualTo(optionName).perform();
    }
    public void chooseGenderRadioButton(String gender, SHAFT.GUI.WebDriver driver){
        if(Objects.equals(gender, "Male")){
            driver.element().click(genderMale);
        } else if (Objects.equals(gender, "Female")) {
            driver.element().click(genderFemale);
        } else {
            SHAFT.Report.report("The gender entered is invalid!!");
        }
    }
    public void chooseFromPoll(String choice, SHAFT.GUI.WebDriver driver){
        switch(choice){
            case "Excellent":
                driver.element().scrollToElement(elementLocator);
                driver.element().click(pollOptionExcellent);
                break;
            case "Good":
                driver.element().scrollToElement(elementLocator);
                driver.element().click(pollOptionGood);
                break;
            case "Poor":
                driver.element().scrollToElement(elementLocator);
                driver.element().click(pollOptionPoor);
                break;
            case "Very bad":
                driver.element().scrollToElement(elementLocator);
                driver.element().click(pollOptionVeryBad);
                break;
            default:
                SHAFT.Report.report("Entered poll option is invalid");
                break;
        }
    }
}
