package demowebshop.features.cart;

import demowebshop.common.BaseTest;
import demowebshop.pageobject.BooksPageObject;
import demowebshop.pageobject.CartPageObject;
import demowebshop.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class RemoveItemOutOfShoppingCart extends BaseTest {
    WebDriver driver;
    CartPageObject shoppingcart;
    String nameProduct_1 = "14.1-inch Laptop";
    String nameProduct_2 = "Build your own cheap computer";
    String nameProduct_3 = "Simple Computer";
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        shoppingcart = PageGenerator.getCartPageObject(driver);
    }
    @Test()
    public void TCO3_RemoveBookOutOfCart ()  {
        shoppingcart.gotoURL("https://demowebshop.tricentis.com/");
        shoppingcart.verifyTitle("Demo Web Shop");
        shoppingcart.addBookToCartAndVerify(nameProduct_1,"1");
        shoppingcart.addBookToCartAndVerify(nameProduct_2,"2");
        shoppingcart.addBookToCartAndVerify(nameProduct_3,"3");
        shoppingcart.openShoppingCart();
        shoppingcart.selectProductRemove(nameProduct_1);
        shoppingcart.verifyProductSelected(nameProduct_1);
        shoppingcart.clickBtnUpdateCart();
        shoppingcart.productAfterRemove("1","2",nameProduct_2,nameProduct_3,"2");

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanBrowserAndDriver();
    }
}
