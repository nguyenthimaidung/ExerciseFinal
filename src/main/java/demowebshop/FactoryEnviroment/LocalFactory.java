package demowebshop.FactoryEnviroment;

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
                throw new mai(browser);
        }

        return driver;
    }
}
