package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;


public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(){
        this.loginPage = new LoginPage();
    }

    @Given("User navigates to the login page")
    public void userNavigatesToTheLoginPage() throws InterruptedException {
        loginPage.navigateToLoginPage();
    }

    @When("The user login with username {string} and password {string}")
    public void theUserLoginWithUsernameAndPassword(String username,String password){
        loginPage.loginWithUserAndPassword(username,password);
    }

    @Then("The user should be redirected to the products page")
    public void theuserShouldBeRedirectedToTheProductsPage(){
        Assert.assertTrue(loginPage.isRedirectedToInventoryPage(),"User was not redirected to the products page.");
    }

    @Given("^User try to login with (.*) and password (.*)$")
    public void userTryToLoginWithInvalidCredentials(String username,String password){
        loginPage.loginWithUserAndPassword(username,password);

        }
    @Then("^Access is expected to be denied with (.*)$")
    public void verifyAccesIsDenied(String reason){
        Assert.assertTrue(loginPage.verifyAccessIsDenied(reason));
    }

}
