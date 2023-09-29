package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import lib.DriverFactory;

//Main scenario outline for every blog test
public class TestShopScenario {


    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {

        // Create a new instance of the Chrome driver
        driver = DriverFactory.createBrowser(DriverFactory.Browser.CHROME);

        //Maximize the window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://testshop.polteq-testing.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
