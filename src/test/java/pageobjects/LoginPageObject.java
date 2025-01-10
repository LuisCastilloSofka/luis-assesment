package pageobjects;

import org.openqa.selenium.By;

public class LoginPageObject {

    public static final By.ById USERNAME_INPUT = new By.ById("user-name");
    public static final By.ById PASSWORD_INPUT = new By.ById("password");
    public static final By.ById LOGIN_BUTTON = new By.ById("login-button");
    public static final By.ByCssSelector ERROR_MESSAGE_LOGIN = new By.ByCssSelector(".error-message-container > h3");
    public static final By.ById MENU_BUTTON = new By.ById("react-burger-menu-btn");
    public static final By.ById LOGOUT_BUTTON = new By.ById("logout_sidebar_link");
    public static final By.ByClassName LOGIN_LOGO = new By.ByClassName("login_logo");
}
