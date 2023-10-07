package demowebshop.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static BooksPageObject getBookPageObject(WebDriver driver){
        return new BooksPageObject(driver);
    }
    public static CartPageObject getCartPageObject(WebDriver driver){
        return new CartPageObject(driver);
    }

}
