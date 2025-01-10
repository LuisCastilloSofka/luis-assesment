package pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.CheckoutPageObject;
import pageobjects.ProductsPageObject;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage{

    private ProductsPage productsPage;

    public CheckoutPage() {
        super();
        this.productsPage = new ProductsPage();
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

    public void AddFixedProductsToTheCart(DataTable dataTable){
        List<Map<String,String>> products = dataTable.asMaps(String.class, String.class);

        for(Map<String,String> product : products){
            String productName = product.get("Product Name");
            String price = product.get("Price");
            productsPage.AddProductToTheCart(productName);
        }

    }

    public boolean isItemTotalCorrect(String expectedTotal){
        WebElement totalElement = driver.findElement(CheckoutPageObject.ITEM_TOTAL);
        String actualTotal = totalElement.getText().replace("Item total: ","");
        return actualTotal.equals(expectedTotal);
    }

    public boolean isConfirmationPageDisplayed(){
        WebElement header = driver.findElement(ProductsPageObject.PRODUCTS_TITLE);
        return header.isDisplayed() && header.getText().equalsIgnoreCase("Checkout: Complete!");
    }

    public boolean isMessageDisplayed(String expectedMessage){
        explicitWait(CheckoutPageObject.ORDER_CONFIRMATION);
        return verifyVisibleText(CheckoutPageObject.ORDER_CONFIRMATION,expectedMessage);
    }

}
