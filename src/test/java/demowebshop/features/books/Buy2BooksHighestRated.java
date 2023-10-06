package demowebshop.features.books;

import demowebshop.common.BaseTest;
import demowebshop.pageobject.BooksPageObject;
import demowebshop.pageobject.LoginPageObject;
import demowebshop.pageobject.PageGenerator;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("demowebshop")
@Feature("BooksPageObject")
@Story("Buy2BooksHighestRated")

public class Buy2BooksHighestRated extends BaseTest {
    WebDriver driver;
    BooksPageObject books;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        books = PageGenerator.getBookPageObject(driver);
    }
    @Test()
    public void TCO2_BuyBook () {
        books.gotoURL("https://demowebshop.tricentis.com/");
        books.verifyTitle("Demo Web Shop");
        books.clickTagBooks();
        books.addToCart();

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanBrowserAndDriver();
    }

}
