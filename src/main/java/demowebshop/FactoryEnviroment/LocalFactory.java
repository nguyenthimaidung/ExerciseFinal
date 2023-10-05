package demowebshop.FactoryEnviroment;

import demowebshop.factoryBrowser.BrowserNotSupportedException;
import demowebshop.factoryBrowser.ChromeDriverManager;
import demowebshop.factoryBrowser.ChromeHeadlessDriverManager;
import demowebshop.factoryBrowser.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;


public class LocalFactory {
    WebDriver driver;
    public WebDriver createDrive(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case "H-CHROME":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }

        return driver;
    }
}
