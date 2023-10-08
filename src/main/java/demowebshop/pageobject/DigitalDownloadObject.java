package demowebshop.pageobject;

import demowebshop.common.BaseTest;
import demowebshop.helper.Log;
import demowebshop.interfaces.DigitalDownloadUI;
import org.apache.commons.compress.compressors.pack200.Pack200Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DigitalDownloadObject extends BaseTest {

    WebDriver driver;
    public DigitalDownloadObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }
    public void clickDigitalDownload(){
        clickElement(driver, DigitalDownloadUI.TAG_DIGITAL);
    }
    public void clickBtnAddToCart(){
        clickElement(driver,DigitalDownloadUI.BTN_ADDCART);
    }
    public void verifyAfterAddToCart(String numberProduct){
        elementIsVisible(driver,DigitalDownloadUI.MESSAGE);
        elementIsVisible(driver,DigitalDownloadUI.CHANGEXPATH(DigitalDownloadUI.NUMBERITEM,"number",numberProduct));
    }
    public void clickShoppingCart(){
        clickElement(driver,DigitalDownloadUI.SHOPPINGCART);
    }
    public void clickCheckBoxTermOfService(){
        clickElement(driver,DigitalDownloadUI.CHECKBOXTERMSORFSERVICE);
    }
    public void verifyCheckBoxChecked(){
        WebElement checkBox = driver.findElement(By.xpath(DigitalDownloadUI.CHECKBOXTERMSORFSERVICE));
        Assert.assertTrue(checkBox.isSelected());
    }
    public void clickBtnCheckOut(){
        clickElement(driver,DigitalDownloadUI.BTN_CHECKOUT);
    }
    public void verifyPageDisplayed(String linkUrl){
        Assert.assertEquals(getCurrentUrl(driver),linkUrl);
    }
    public void clickCheckoutAsGuest(){
        clickElement(driver,DigitalDownloadUI.BTN_CHECKOUTASGUEST);
    }
    public void fillInfoBillingAddress(String FirstName,String LastName,String Email,String Country,String City
        ,String Address1,String ZipCode,String Phone){
        sendKeyToElement(driver,DigitalDownloadUI.TXT_FIRSTNAME,FirstName);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_LASTNAME,LastName);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_EMAIL,Email);
        selectOption(driver,DigitalDownloadUI.COUNTRY,Country);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_CITY,City);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_ADDRESS,Address1);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_ZIPCODE,ZipCode);
        sendKeyToElement(driver,DigitalDownloadUI.TXT_PHONE,Phone);
    }
    public void clickBtnContinue(){
        clickElement(driver,DigitalDownloadUI.BTN_CONTINUE);
    }
    public void verifyPaymentMethod(){

    }
}
