package pageobjects;

import org.openqa.selenium.By;

public class LoginPageObject {

    public static final By.ById USERNAME_INPUT = new By.ById("user-name");
    public static final By.ById PASSWORD_INPUT = new By.ById("password");
    public static final By.ById LOGIN_BUTTON = new By.ById("login-button");
    public static final By.ByCssSelector ERROR_MESSAGE_LOGIN = new By.ByCssSelector(".error-message-container > h3");
}
