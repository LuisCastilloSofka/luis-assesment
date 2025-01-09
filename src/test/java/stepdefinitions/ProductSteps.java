package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;

public class ProductSteps {

    private ProductsPage productsPage;

    public ProductSteps(){
        this.productsPage = new ProductsPage();
    }

    @When("User adds the product {string} to the cart")
    public void userAddsTheProductToTheCart(String product) {
        productsPage.AddProductToTheCart(product);

    }
    @Then("The product {string} should be displayed in the cart")
    public void theProductShouldBeDisplayedInTheCart(String product){
        Assert.assertTrue(productsPage.verifyProductIsInTheCart(product));
    }

    @And("User removes the product {string} from the cart")
    public void userRemovesTheProductFromTheCart(String product){
        productsPage.removesProductFromTheCart(product);
    }

    @Then("The product {string} should not be displayed in the cart")
        public void theProductShouldNotBeDisplayedInTheCart(String product){
        Assert.assertTrue(productsPage.verifyProductIsNotInTheCart(product));
    }
}
