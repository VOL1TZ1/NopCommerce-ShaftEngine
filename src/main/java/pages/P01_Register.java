package pages;

import coreElements.*;

import static Locators.L01_Register.*;

public class P01_Register {
    public static Link register = new Link(registerLink);
    public static Link myAccount = new Link(myAccountLink);
    public static Link  Logout = new Link(logoutLink);
    public static RadioButton male = new RadioButton(genderMale);
    public static RadioButton female = new RadioButton(genderFemale);
    public static FormField firstName = new FormField(firstNameField);
    public static FormField lastName = new FormField(lastNameField);
    public static SelectList birthDay = new SelectList(dobDayField);
    public static SelectList birthMonth = new SelectList(dobMonthField);
    public static SelectList birthYear = new SelectList(dobYearField);
    public static FormField email = new FormField(emailField);
    public static FormField companyName = new FormField(companyNameField);
    public static CheckBox newsletter = new CheckBox(newsletterBox);
    public static FormField password = new FormField(passwordField);
    public static FormField confirmPassword = new FormField(confirmPasswordField);
    public static Button save = new Button(registerButton);
    public static Button Continue = new Button(continueButton);
}