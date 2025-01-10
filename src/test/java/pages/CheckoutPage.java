package pages;

import org.openqa.selenium.By;
import pageobjects.CheckoutPageObject;

public class CheckoutPage extends BasePage{

    public CheckoutPage() {
        super();
    }

    public boolean isErrorMessageDisplayed(String expectedMessage){
        explicitWait(CheckoutPageObject.ERROR_MESSAGE_FIELD);
        return verifyVisibleText(CheckoutPageObject.ERROR_MESSAGE_FIELD,expectedMessage);
    }

    public void fillField(String fieldName, String value) {
        By fieldLocator;
        switch (fieldName.toLowerCase()) {
            case "first name":
                fieldLocator = CheckoutPageObject.FIRST_NAME_INPUT;
                break;
            case "last name":
                fieldLocator = CheckoutPageObject.LAST_NAME_INPUT;
                break;
            case "postal code":
                fieldLocator = CheckoutPageObject.POSTAL_CODE_INPUT;
                break;
            default:
                throw new IllegalArgumentException("Field not recognized: " + fieldName);
        }
        explicitWait(fieldLocator);
        write(fieldLocator,value);

    }

}
