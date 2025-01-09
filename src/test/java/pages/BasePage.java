package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.TestHooks;
import org.slf4j.Logger;


import java.time.Duration;

public class BasePage{

    protected  WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public BasePage(){
        driver = TestHooks.driver;
        wait = TestHooks.wait;
        logger = TestHooks.logger;
        PageFactory.initElements(driver,this);
    }


    public void write(By locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    private WebElement Find(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void navigateToLoginPage (){
        driver.get("https://www.saucedemo.com/");
    }

    public void explicitWait(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click (By locator) {driver.findElement(locator).click();}

    public boolean isRedirected(String place){
        if(place.equals("inventory")) {
            return driver.getCurrentUrl().contains(place);
        }
        return false;
    }

}