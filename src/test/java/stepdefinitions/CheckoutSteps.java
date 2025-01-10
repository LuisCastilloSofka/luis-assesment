package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pageobjects.ProductsPageObject;
import pages.CheckoutPage;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    public CheckoutSteps(){
        this.checkoutPage = new CheckoutPage();
    }

    @Then("An error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String errorMessage) {
       Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(errorMessage));
   }

    @And("User clicks on the {string} button")
    public void userClicksOnTheButton(String buttonName) throws InterruptedException {
        checkoutPage.clickOnButtonByName(buttonName);
    }

    @And("User fills in the {string} field with {string}")
    public void userFillsInTheFieldWith(String fieldName, String value) {
       checkoutPage.fillField(fieldName, value);
    }

    @When("User adds the following products to the cart:")
    public void userAddsTheFollowingProductsToTheCart(DataTable dataTable){
      checkoutPage.AddFixedProductsToTheCart(dataTable);
    }

    @And("User proceeds to the Checkout : Overview Page")
    public void userProceedstoTheCheckoutOverviewPage() {
        checkoutPage.click(ProductsPageObject.CART_ICON_LINK);
        checkoutPage.explicitWait(ProductsPageObject.PRODUCTS_TITLE);
        checkoutPage.clickOnButtonByName("Checkout");
        checkoutPage.fillField("first name", "Luis");
        checkoutPage.fillField("last name", "Castillo");
        checkoutPage.fillField("postal code", "2500030");
        checkoutPage.clickOnButtonByName("Continue");

    }
    @Then("The item total should be {string}")
    public void theItemTotalShouldBe(String expectedTotal){
        Assert.assertTrue(checkoutPage.isItemTotalCorrect(expectedTotal));
    }


}
