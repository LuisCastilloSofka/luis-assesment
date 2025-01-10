package pages;


import pageobjects.LoginPageObject;
import pageobjects.ProductsPageObject;

public class LoginPage extends BasePage{


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

   public boolean verifyAccessIsDenied(String reason){
       String message = "";
       switch (reason){
           case "invalid_credentials":
                message = "Epic sadface: Username and password do not match any user in this service";
               return verifyVisibleText(LoginPageObject.ERROR_MESSAGE_LOGIN,message);

           case "password_missing":
                message = "Epic sadface: Password is required";
               return verifyVisibleText(LoginPageObject.ERROR_MESSAGE_LOGIN,message);

           case "user_missing":
               message = "Epic sadface: Username is required";
               return verifyVisibleText(LoginPageObject.ERROR_MESSAGE_LOGIN,message);

       }
       return false;
   }

    public boolean isLoginPageDisplayed() {
       return isDisplayed(LoginPageObject.LOGIN_LOGO);
    }

    public boolean isLoginButtonVisible() {
        return isDisplayed(LoginPageObject.LOGIN_BUTTON);
    }







}
