package demowebshop.features.digitaldownload;

import demowebshop.common.BaseTest;
import demowebshop.pageobject.CartPageObject;
import demowebshop.pageobject.DigitalDownloadObject;
import demowebshop.pageobject.PageGenerator;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BuyProductSuccess extends BaseTest {
    WebDriver driver;
    DigitalDownloadObject digital;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        digital = PageGenerator.getDigitalDownloadPageObject(driver);
    }

    String FirstName = "Dung ";
    String LastName = "Nguyen Thi Mai";
    String Email = generateEmail();
    String Country = "Viet Nam";
    String City = "Ha Noi";
    String Address1 = "18 Ton That Thuyet";
    String ZipCode = "1111";
    String Phone = randomphone();

    @Test()
    public void TCO4_BuyProductSuccess() {
        digital.gotoURL("https://demowebshop.tricentis.com/");
        digital.verifyTitle("Demo Web Shop");
        digital.clickDigitalDownload();
        digital.verifyTitle("Demo Web Shop. Digital downloads");
        digital.clickBtnAddToCart();
        digital.verifyAfterAddToCart("1");
        digital.clickShoppingCart();
        digital.verifyTitle("Demo Web Shop. Shopping Cart");
        digital.clickCheckBoxTermOfService();
        digital.verifyCheckBoxChecked();
        digital.clickBtnCheckOut();
        digital.verifyPageDisplayed("https://demowebshop.tricentis.com/login/checkoutasguest?returnUrl=%2Fcart");
        digital.clickCheckoutAsGuest();
        digital.verifyPageDisplayed("https://demowebshop.tricentis.com/onepagecheckout");
        digital.fillInfoBillingAddress(FirstName, LastName, Email, Country, City, Address1, ZipCode, Phone);
        digital.clickBtnContinue();
        digital.verifyPaymentMethodDisplayed();
        digital.clickBtnContinuePayment();
        digital.verifyPaymentInfoDisplayed();
        digital.clickBtnContinuePaymentInfo();
        digital.verifyBillingAddress_Name(FirstName.concat(LastName));
        digital.verifyBillingAddress_Email(Email);
        digital.verifyBillingAddress_Phone(Phone);
        digital.verifyBillingAddress_Address(Address1);
        String cityZipCodeInput = City + ' '+ ','+' '+ ZipCode;
        digital.verifyBillingAddress_CityZipCode(cityZipCodeInput);
        digital.verifyBillingAddress_Country(Country);
        digital.verifyDataDisplayedPaymentMethod();
        digital.verifyTotal();
        digital.clickBtnConfirm();
        digital.verifyMessageCompleted();
        digital.verifyPageDisplayed("https://demowebshop.tricentis.com/checkout/completed/");
        digital.clickBtnContinueCompleted();
        digital.verifyPageDisplayed("https://demowebshop.tricentis.com/");


    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanBrowserAndDriver();
    }
}
