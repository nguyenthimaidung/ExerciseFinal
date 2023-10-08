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
    public void verifyPaymentMethodDisplayed(){
        elementIsVisible(driver,DigitalDownloadUI.PAYMENT_METHOD_BTN_CONTINUE);
        checkToDefaultCheckboxOrDefaultRadio(driver,DigitalDownloadUI.PAYMENT_METHOD_OPTION_DEFAULT);
    }
    public void clickBtnContinuePayment(){
        clickElement(driver,DigitalDownloadUI.PAYMENT_METHOD_BTN_CONTINUE);
    }
    public void verifyPaymentInfoDisplayed(){
        elementIsVisible(driver,DigitalDownloadUI.PAYMENT_INFO_BTN_CONTINUE);
        elementIsVisible(driver,DigitalDownloadUI.PAYMENT_INFO_MESSAGE);
    }
    public void clickBtnContinuePaymentInfo(){
        clickElement(driver,DigitalDownloadUI.PAYMENT_INFO_BTN_CONTINUE);
    }
    public void verifyBillingAddress_Name(String nameInput){
        String getName = getTextElement(driver,DigitalDownloadUI.CONFIRM_NAME);
        Assert.assertTrue(getName.contains(nameInput));
    }
    public void verifyBillingAddress_Email(String emailInput){
        String getEmail = getTextElement(driver,DigitalDownloadUI.CONFIRM_EMAIL);
        Assert.assertTrue(getEmail.contains(emailInput));
    }
    public void verifyBillingAddress_Phone(String phoneInput){
        String getEmail = getTextElement(driver,DigitalDownloadUI.CONFIRM_PHONE);
        Assert.assertTrue(getEmail.contains(phoneInput));
    }
    public void verifyBillingAddress_Address(String addressInput){
        String getEmail = getTextElement(driver,DigitalDownloadUI.CONFIRM_ADDRESS);
        Assert.assertTrue(getEmail.contains(addressInput));
    }
    public void verifyBillingAddress_CityZipCode(String cityZipCodeInput){
        String getEmail = getTextElement(driver,DigitalDownloadUI.CONFIRM_CITYZIPCODE);
        Assert.assertTrue(getEmail.contains(cityZipCodeInput));
    }
    public void verifyBillingAddress_Country(String country){
        String getEmail = getTextElement(driver,DigitalDownloadUI.CONFIRM_COUNTRY);
        Assert.assertTrue(getEmail.contains(country));
    }
    public void verifyDataDisplayedPaymentMethod(){
        String getTextOfPaymentMethod = getTextElement(driver,DigitalDownloadUI.CONFIRM_PAYMENT);
        String getTextPaymentMethodInput = getTextElement(driver,DigitalDownloadUI.PAYMENT_METHOD_OPTION_DEFAULT);
        Assert.assertTrue(getTextPaymentMethodInput.contains(getTextOfPaymentMethod));
    }
    public void verifyTotal(){
        int sub_Total = Integer.parseInt(getTextElement(driver,DigitalDownloadUI.SUBTOTAL));
        int payment_Fee = Integer.parseInt(getTextElement(driver,DigitalDownloadUI.PAYMENT_FREE));
        int Total = Integer.sum(sub_Total,payment_Fee);
        String total = String.valueOf(Total);
        String getTextTotal = getTextElement(driver,DigitalDownloadUI.TOTAL_FREE);
        Assert.assertEquals(total,getTextTotal);
    }
    public void clickBtnConfirm(){
        clickElement(driver,DigitalDownloadUI.BTN_CONFIRM);
    }
    public void verifyMessageCompleted(){
        elementIsVisible(driver,DigitalDownloadUI.MESSAGE_COMPLETED);
    }
    public void clickBtnContinueCompleted(){
        clickElement(driver,DigitalDownloadUI.BTN_CONTINUE_COMPLETED);
    }


}
