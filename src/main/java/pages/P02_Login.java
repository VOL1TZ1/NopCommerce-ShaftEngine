package pages;

import coreElements.*;

import static Locators.L02_Login.*;
public class P02_Login {
    public static Link Login = new Link(loginLink);
    public static Button login = new Button(loginButton);
    public static Message loginError = new Message(validationError);
}
