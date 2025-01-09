package pages;

import hooks.TestHooks;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private TestHooks hooks;

   public LoginPage(WebDriver driver){
      this.driver= driver;
   }
}
