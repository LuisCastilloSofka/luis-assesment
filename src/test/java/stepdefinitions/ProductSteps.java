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

    @When("^User sorts products by (.*)$")
    public void UserSortsProductsBy(String sort){
        productsPage.sortPrductsBy(sort);
    }

    @Then("The product should be sort by {word} in {word}")
    public void theProductShouldBeSortByIn(String sortType,String order){
        boolean ascending = order.equalsIgnoreCase("ascending");
        Assert.assertTrue(productsPage.verifyProductsAreSorted(sortType,ascending));

    }

}
