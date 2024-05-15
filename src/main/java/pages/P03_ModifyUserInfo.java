package pages;

import coreElements.Button;

import static Locators.L03_ModifyUserAccountInfo.closeNotification;
import static Locators.L03_ModifyUserAccountInfo.saveButton;

public class P03_ModifyUserInfo {
    public static Button closeNotificationButton = new Button(closeNotification);
    public static Button saveModifiedInfo = new Button(saveButton);
}
