package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver; // declare variable private static in driver class.

    /**
     * This method sets up WebDriver type based on
     * provided browser type in Configuration.properties file.
     * @return webDriver
     */
    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        if(driver==null || ((RemoteWebDriver) driver).getSessionId()==null){
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optionsChrome=new ChromeOptions();
                    optionsChrome.setHeadless(false);   // if you want to run headless(true)
                    driver=new ChromeDriver(optionsChrome);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions optionsFF = new FirefoxOptions();
                    optionsFF.setHeadless(false);
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
            }
        }else{
            return driver;
        }
        return driver;
    }
}
