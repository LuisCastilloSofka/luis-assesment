package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@detail"
)

public class TestRunner extends AbstractTestNGCucumberTests {
    public final static ThreadLocal<String> BROWSER = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void defineBrowser(String browser) {TestRunner.BROWSER.set(browser);};

}
