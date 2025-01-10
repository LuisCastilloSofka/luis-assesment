package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.ProductsPage;

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


}
