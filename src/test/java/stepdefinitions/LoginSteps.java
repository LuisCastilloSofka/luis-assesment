package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    private WebDriver driver = DriverManager.getDriver();

    private LoginPage loginPage = new LoginPage(driver);

    @Given("User navigates to the login page")
    public void userNavigatesToTheLoginPage(){
    }

    @When("The user login with username {string} and password {string}")
    public void theUserLoginWithUsernameAndPassword(String username,String password){

    }

    @Then("The user should be redirected to the products page")
    public void theuserShouldBeRedirectedToTheProductsPage(){

    }

}
