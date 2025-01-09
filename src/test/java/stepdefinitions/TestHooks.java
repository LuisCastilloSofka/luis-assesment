package stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestHooks {

    protected WebDriver driver;
    public static WebDriverWait wait;

    /**
     * Initial Config: Run before every test suite.
     * Allow to select browser from TestNG parameters.
     *
     * @param browser Browser type: chrome, firefox, edge
     */
    @BeforeClass
    @Parameters({"browser","headless"})
    public void setDriver(String browser, boolean headless){

        if(browser == null){
            throw new IllegalArgumentException("The parameter 'browser' can't be null");
        }

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless){
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless){
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                if (headless){
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Browser is not allowed" + browser);
        }

        //Basic Config of browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    /**
     * Final Clean: Run after every test suite.
     * Close the browser and delete Webdriver instance.
     */
    @AfterClass
    public void tearDown(){
        if (driver != null){
            driver.quit();
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
