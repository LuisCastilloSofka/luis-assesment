package pages;

import pageobjects.ProductsPageObject;

public class ProductsPage extends BasePage{

    public ProductsPage(){
        super();
    }


    public void AddProductToTheCart(String product){
        switch (product){
            case "Sauce Labs Onesie" :
            click(ProductsPageObject.SAUCE_LABS_ONESIE_PRODUCT_ADD_TO_CART_BUTTON);
            break;

            case"Sauce Labs Backpack":
            click(ProductsPageObject.SAUCE_LABS_BACKPACK_PRODUCT_ADD_TO_CART_BUTTON);
            break;
        }
    }

    public boolean verifyProductIsInTheCart(String product) {

        explicitWait(ProductsPageObject.CART_BUTTON);
        click(ProductsPageObject.CART_BUTTON);
        explicitWait(ProductsPageObject.PRODUCTS_TITLE);
        return verifyVisibleText(ProductsPageObject.CART_ITEM,product);

    }

    public void removesProductFromTheCart(String product){
        switch (product){
            case "Sauce Labs Onesie" :
                click(ProductsPageObject.SAUCE_LABS_ONESIE_PRODUCT_REMOVE_FROM_THE_CART_BUTTON);
                break;

            case"Sauce Labs Backpack":
                click(ProductsPageObject.SAUCE_LABS_BACKPACK_PRODUCT_REMOVE_FROM_THE_CART_BUTTON);
                break;
        }
    }
    public boolean verifyProductIsNotInTheCart(String product){
        return verifyProductbyXpathIsNotInTheCart(product);
    }


}
