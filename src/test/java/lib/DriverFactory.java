package lib;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public enum Browser {
        CHROME,
        EDGE,
        FIREFOX,
        INTERNET_EXPLORER
    }

    public static WebDriver createBrowser(Browser browser) {
        switch (browser) {
            case FIREFOX:
                return createFireFoxBrowser();
            case EDGE:
                return createEdgeBrowser();
            case INTERNET_EXPLORER:
                return createIEBrowser();
            case CHROME:
            default:
                return createChromeBrowser();
        }
    }

    private static WebDriver createChromeBrowser() {
        WebDriverManager.chromedriver().setup();

        //The sandbox option is introduced to prevent issues when running chrome on windows server
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeBrowser() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }

    private static WebDriver createFireFoxBrowser() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createIEBrowser() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

}