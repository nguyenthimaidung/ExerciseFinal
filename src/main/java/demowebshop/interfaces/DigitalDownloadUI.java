package demowebshop.interfaces;

public class DigitalDownloadUI {
    public static String TAG_DIGITAL = "//ul[@class='top-menu']//a[contains(text(),'Digital downloads')]";
    public static String BTN_ADDCART ="//div[@class = 'buttons']//input[@value ='Add to cart']";
    public static String NUMBERITEM = "//a[@class='ico-cart']//span[text()='(number)']";
    public static String MESSAGE = "//p[contains(text(),'The product has been added to your')]";
    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }
    public static String SHOPPINGCART = "//span[text()='Shopping cart']";
    public static String CHECKBOXTERMSORFSERVICE ="//input[@id='termsofservice']";
    public static String BTN_CHECKOUT = "//button[@id='checkout']";
    public static String BTN_CHECKOUTASGUEST = "//input[@value='Checkout as Guest']";
    public static String TXT_FIRSTNAME = "//input[@id='BillingNewAddress_FirstName']";
    public static String TXT_LASTNAME = "//input[@id='BillingNewAddress_LastName']";
    public static String TXT_EMAIL = "//input[@id='BillingNewAddress_Email']";
    public static String COUNTRY = "//select[@id='BillingNewAddress_CountryId']";
    public static String TXT_CITY = "//input[@id='BillingNewAddress_City']";
    public static String TXT_ADDRESS = "//input[@id='BillingNewAddress.Address1']";
    public static String TXT_ZIPCODE = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static String TXT_PHONE = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static String BTN_CONTINUE = "//input[@class='button-1 new-address-next-step-button']";
    public static String TITLE_PAYMENT_METHOD = "//li[@id='opc-payment_method']//h2";
    public static String PAYMENT_OPTION_DEFAULF = "//label[contains(text(),'Cash On Delivery (COD) (7.00)')]";

}
