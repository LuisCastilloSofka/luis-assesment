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
    public static final By.ByCssSelector SORT_DROPDOWN = new By.ByCssSelector(".product_sort_container");
    public static final By.ByClassName PRODUCT_NAMES = new By.ByClassName("inventory_item_name");
    public static final By.ByClassName PRODUCT_PRICES = new By.ByClassName("inventory_item_price");
    public static final By.ByCssSelector SAUCE_LABS_BIKE_LIGHT_NAME = new By.ByCssSelector("#item_0_title_link > div");
    public static final By.ByCssSelector SAUCE_LABS_FLEECE_JACKET_NAME = new By.ByCssSelector("#item_5_title_link > div");
    public static final By.ById SAUCE_LABS_BIKE_LIGHT_IMAGE = new By.ById("item_0_img_link");
    public static final By.ById SAUCE_LABS_FLEECE_JACKET_IMAGE = new By.ById("item_5_img_link");
    public static final By.ByCssSelector DETAIL_PAGE_TITLE = new By.ByCssSelector(".inventory_details_name");
}
