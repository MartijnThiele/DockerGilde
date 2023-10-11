package lib;

import helpers.UrlHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public enum Browser {
        CHROME,
        EDGE,
        FIREFOX,
        INTERNET_EXPLORER,
        GRID_CHROME,
    }

    public static WebDriver createBrowser(Browser browser) {
        System.out.println("Creating browser: " + browser);
        return switch (browser) {
            case FIREFOX -> createFireFoxBrowser();
            case EDGE -> createEdgeBrowser();
            case INTERNET_EXPLORER -> createIEBrowser();
            case GRID_CHROME -> createGridChromeBrowser();
            default -> createChromeBrowser();
        };
    }

    private static WebDriver createGridChromeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");

        if(System.getenv("CICD") != null){
            //In docker tegen grid
            return new RemoteWebDriver(UrlHelper.createURL("http://selenium-hub:4444"), options);
        }else{
            //Lokaal tegen grid
            return new RemoteWebDriver(UrlHelper.createURL("http://localhost:4444"), options);
        }
    }

    private static WebDriver createChromeBrowser() {

        //The sandbox option is introduced to prevent issues when running chrome on windows server
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");

        //Run headless if in CICD env
        if(System.getenv("CICD") != null){
            options.addArguments("--headless");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeBrowser() {
        return new EdgeDriver();
    }

    private static WebDriver createFireFoxBrowser() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    private static WebDriver createIEBrowser() {
        return new InternetExplorerDriver();
    }

}