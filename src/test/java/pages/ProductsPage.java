package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.LoginPageObject;
import pageobjects.ProductsPageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage() {
        super();
    }


    public void AddProductToTheCart(String product) {
        switch (product) {
            case "Sauce Labs Onesie":
                click(ProductsPageObject.SAUCE_LABS_ONESIE_PRODUCT_ADD_TO_CART_BUTTON);
                break;

            case "Sauce Labs Backpack":
                click(ProductsPageObject.SAUCE_LABS_BACKPACK_PRODUCT_ADD_TO_CART_BUTTON);
                break;
            case "Sauce Labs Bolt T-Shirt":
                click(ProductsPageObject.SAUCE_LABS_BOLT_TSHIRT_PRODUCT_ADD_TO_CART_BUTTON);
        }
    }

    public boolean verifyProductIsInTheCart(String product) {

        explicitWait(ProductsPageObject.CART_BUTTON);
        click(ProductsPageObject.CART_BUTTON);
        explicitWait(ProductsPageObject.PRODUCTS_TITLE);
        return verifyVisibleText(ProductsPageObject.CART_ITEM, product);

    }

    public void removesProductFromTheCart(String product) {
        switch (product) {
            case "Sauce Labs Onesie":
                click(ProductsPageObject.SAUCE_LABS_ONESIE_PRODUCT_REMOVE_FROM_THE_CART_BUTTON);
                break;

            case "Sauce Labs Backpack":
                click(ProductsPageObject.SAUCE_LABS_BACKPACK_PRODUCT_REMOVE_FROM_THE_CART_BUTTON);
                break;
        }
    }

    public boolean verifyProductIsNotInTheCart(String product) {
        return verifyProductbyXpathIsNotInTheCart(product);
    }

    public void sortPrductsBy(String sort) {
        explicitWait(ProductsPageObject.SORT_DROPDOWN);
        Select select = new Select(getWebElementByBy(ProductsPageObject.SORT_DROPDOWN));
        select.selectByVisibleText(sort);
    }

    public boolean verifyProductsAreSorted(String sortType, boolean ascending) {

        if (sortType.equalsIgnoreCase("alphabetically")) {
            List<String> actualOrder = new ArrayList<>();
            List<WebElement> productNames = driver.findElements(ProductsPageObject.PRODUCT_NAMES);
            for (WebElement product : productNames) {
                actualOrder.add(product.getText());
            }
            List<String> expectedOrder = new ArrayList<>(actualOrder);
            if (ascending) {
                Collections.sort(expectedOrder);
            } else {
                Collections.sort(expectedOrder, Collections.reverseOrder());
            }
            return actualOrder.equals(expectedOrder);

        } else if (sortType.equalsIgnoreCase("price")) {
            List<Double> actualOrder = new ArrayList<>();
            List<WebElement> productPrices = driver.findElements(ProductsPageObject.PRODUCT_PRICES);
            for (WebElement price : productPrices) {
                actualOrder.add(Double.parseDouble(price.getText().replace("$", "")));
            }
            List<Double> expectedOrder = new ArrayList<>(actualOrder);
            if (ascending) {
                Collections.sort(expectedOrder);
            } else {
                Collections.sort(expectedOrder, Collections.reverseOrder());
            }
            return actualOrder.equals(expectedOrder);
        } else {
            throw new IllegalArgumentException("Invalid sort type: " + sortType);
        }

    }

    public void clickOnTheProductElement(String element,String productName) {

        if(element.equalsIgnoreCase("name")){
            clickProductName(productName);
        } else if(element.equalsIgnoreCase("image")){
            clickProductImage(productName);
        } else{
            throw new IllegalArgumentException("Invalid element type" + element);
        }
    }

    public boolean verifyProductDetailPageisDisplayed(String productName){
        explicitWait(ProductsPageObject.DETAIL_PAGE_TITLE);
        return verifyVisibleText(ProductsPageObject.DETAIL_PAGE_TITLE,productName);
    }

    public void removesProductFromTheCartProductPage(String product) {
        explicitWait(ProductsPageObject.REMOVE_CART_ITEM_PRODUCT_PAGE);
        click(ProductsPageObject.REMOVE_CART_ITEM_PRODUCT_PAGE);
    }

    public boolean isCartIconUpdatedAfterRemoval(){
        try {
            WebElement cartBadge = driver.findElement(ProductsPageObject.CART_ICON_BADGE);
            String cartCount = cartBadge.getText();
            return Integer.parseInt(cartCount) == 0;
        } catch (NoSuchElementException e){
            return true;
        }
    }

}
