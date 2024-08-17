package SocialMedia_CommentSection;


import Login_Register.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Login_Register.Locators.*;
public class Wish_List extends Hooks {
    @Test(priority = 6)
    public void check_wish_list(){
        //scroll down
        driver.element().scrollToElement(scrollDown);
        //click to add to wish list
        driver.element().click(wishListIconInItem);
        // return title for item
        String expectedTitle =driver.element().getText(titleForItem);
        System.out.println(expectedTitle);
        //scroll up
        driver.element().scrollToElement(scrollUp);
        //close the bar that refer to added item successfully
        driver.element().click(barClose);
        //go to wish list page
        driver.element().click(wishListButton);
        //get actual title from wish list page
        String actualTitle = driver.element().getText(itemTitle);
        System.out.println(actualTitle);
        //to verify the item added successfully
        Assert.assertTrue(expectedTitle.contains(actualTitle));
    }
}
