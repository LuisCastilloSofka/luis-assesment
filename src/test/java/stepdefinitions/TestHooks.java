package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.slf4j.Logger;
import pages.BasePage;

import runners.TestRunner;
import utils.DriverManager;

import java.time.Duration;


public class TestHooks {

    public static final Logger logger = LoggerFactory.getLogger(TestHooks.class);
    public static WebDriver driver;
    public static WebDriverWait wait;
    private BasePage basePage;


    @Before
    public void setupDriver(Scenario scenario){
        String browser = TestRunner.BROWSER.get();
        if(browser == null){
            throw new IllegalArgumentException("The parameter 'browser' can't be null");
        }
        logger.info("Starting WebDriver on the browser: {}",browser);

        switch (browser.toLowerCase()){
            case "chrome":
                logger.debug("Setting up ChromeDriver...");
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                    //chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                logger.debug("Setting up FirefoxDriver...");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--headless");

                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                logger.debug("Setting up EdgeDriver...");
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                    //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                logger.error("Browser is not allowed {}",browser);
                throw new IllegalArgumentException("Browser is not allowed" + browser);
        }

        //Basic Config of browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        logger.info("Web driver initialized correctly for {}",browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        DriverManager.setDriver(driver);


    }

    /**
     * Final Clean: Run after every test suite.
     * Close the browser and delete Webdriver instance.
     */
    @After
    public void tearDown(){
        if (driver != null){
            logger.info("Closing Webdriver...");
            driver.quit();
            logger.info("Webdriver closed successfully");
        }
    }
    /**
     * Method to get WebDriver instance.
     *
     * @return WebDriver actual
     */

    public WebDriver getDriver() {
        return driver;
    }

}
