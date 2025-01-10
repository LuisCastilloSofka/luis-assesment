package pageobjects;

import org.openqa.selenium.By;

public class CheckoutPageObject {

    public static final By.ById CONTINUE_BUTTON = new By.ById("continue");
    public static final By.ById CHECKOUT_BUTTON = new By.ById("checkout");
    public static final By.ByCssSelector ERROR_MESSAGE_FIELD = new By.ByCssSelector(".error-message-container > h3");
    public static final By.ById FIRST_NAME_INPUT = new By.ById("first-name");
    public static final By.ById LAST_NAME_INPUT = new By.ById("last-name");
    public static final By.ById POSTAL_CODE_INPUT = new By.ById("postal-code");
    public static final By.ByClassName ITEM_TOTAL = new By.ByClassName("summary_subtotal_label");
}
