package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;


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

    @Given("User is logged and is on the Products page of Sauce Labs application")
    public void loginWithFixedUser(){loginPage.loginWithUserAndPassword("standard_user","secret_sauce");}

    @When("User clicks on the logout option in the menu")
    public void userClicksOnTheLogoutOptionInTheMenu(){
        loginPage.openMenu();
        loginPage.clickLogout();
    }
    @Then("User should be redirected to the login page")
    public void userShouldBeRedirectedToTheLoginPage(){
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
    @Then("The login button should be visible")
    public void theLoginButtonShouldBeVisible() {
        Assert.assertTrue(loginPage.isLoginButtonVisible());
    }



}
