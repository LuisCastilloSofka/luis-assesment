package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPageObject;

public class LoginPage extends BasePage{

    private WebDriver driver;

   public LoginPage(){
    super();
   }

   public void loginWithUserAndPassword(String username, String password){
       explicitWait(LoginPageObject.USERNAME_INPUT);
       write(LoginPageObject.USERNAME_INPUT,username);
       write(LoginPageObject.PASSWORD_INPUT,password);
       click(LoginPageObject.LOGIN_BUTTON);

   }

   public boolean isRedirectedToInventoryPage(){
       return isRedirected("inventory");

   }





}
