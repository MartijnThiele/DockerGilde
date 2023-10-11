package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import lib.DriverFactory;

//Main scenario outline for every testshop test
public class TestShopScenario {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getId());

        // Create a new instance of the Chrome driver, grid or local is based on the env var
        if(System.getenv("GRID") != null) {
            driver = DriverFactory.createBrowser(DriverFactory.Browser.GRID_CHROME);
        }else{
            driver = DriverFactory.createBrowser(DriverFactory.Browser.CHROME);
        }

        //Maximize the window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://testshop.polteq-testing.com/");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
