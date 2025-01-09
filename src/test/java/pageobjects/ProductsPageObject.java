package pageobjects;

import org.openqa.selenium.By;

public class ProductsPageObject {
    public static final By.ByCssSelector PRODUCTS_TITLE = new By.ByCssSelector(".title");
    public static final By.ById SAUCE_LABS_ONESIE_PRODUCT_ADD_TO_CART_BUTTON = new By.ById("add-to-cart-sauce-labs-onesie");
    public static final By.ById SAUCE_LABS_BACKPACK_PRODUCT_ADD_TO_CART_BUTTON = new By.ById("add-to-cart-sauce-labs-backpack");
    public static final By.ByCssSelector CART_BUTTON = new By.ByCssSelector(".shopping_cart_link");
    public static final By.ByCssSelector CART_ITEM = new By.ByCssSelector(".inventory_item_name");
    public static final By.ById SAUCE_LABS_ONESIE_PRODUCT_REMOVE_FROM_THE_CART_BUTTON = new By.ById("remove-sauce-labs-onesie");
    public static final By.ById SAUCE_LABS_BACKPACK_PRODUCT_REMOVE_FROM_THE_CART_BUTTON = new By.ById("remove-sauce-labs-backpack");
}
