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
    public static String TXT_ADDRESS = "//input[@id='BillingNewAddress_Address1']";
    public static String TXT_ZIPCODE = "//input[@id='BillingNewAddress_ZipPostalCode']";
    public static String TXT_PHONE = "//input[@id='BillingNewAddress_PhoneNumber']";
    public static String BTN_CONTINUE = "//input[@class='button-1 new-address-next-step-button']";
    public static String PAYMENT_METHOD_OPTION_DEFAULT = "//input[@value='Payments.CashOnDelivery']";
    public static String GETTEXT_PAYMENT_METHOD_OPTION = "//input[@value='Payments.CashOnDelivery']/following-sibling::label";
    public static String PAYMENT_METHOD_BTN_CONTINUE = "//div[@id ='checkout-step-payment-method']//input[@value='Continue']";
    public static String PAYMENT_INFO_MESSAGE = "//div[@class='section payment-info']//p";
    public static String PAYMENT_INFO_BTN_CONTINUE = "//div[@id ='checkout-step-payment-info']//input[@value='Continue']";
    public static String CONFIRM_NAME = "//li[@id='opc-confirm_order']//li[@class ='name']";
    public static String CONFIRM_EMAIL = "//li[@id='opc-confirm_order']//li[@class ='email']";
    public static String CONFIRM_PHONE = "//li[@id='opc-confirm_order']//li[@class ='phone']";
    public static String CONFIRM_ADDRESS = "//li[@id='opc-confirm_order']//li[@class ='address1']";
    public static String CONFIRM_CITYZIPCODE = "//li[@id='opc-confirm_order']//li[@class ='city-state-zip']";
    public static String CONFIRM_COUNTRY = "//li[@id='opc-confirm_order']//li[@class ='country']";
    public static String CONFIRM_PAYMENT = "//li[@id='opc-confirm_order']//li[@class ='payment-method']";
    public static String SUBTOTAL = "//span[contains(text(),'Sub-Total:')]//ancestor::tr//span[@class='product-price']";
    public static String PAYMENT_FREE = "an[contains(text(),'Payment method additional fee:')]//ancestor::tr//span[@class='product-price']";
    public static String TOTAL_FREE = "//span[contains(text(),'Total:')]//ancestor::tr//span[@class='product-price order-total']/strong";
    public static String BTN_CONFIRM = "//input[@class='button-1 confirm-order-next-step-button']";
    public static String MESSAGE_COMPLETED = "//div[@class='section order-completed']//strong";
    public static String BTN_CONTINUE_COMPLETED = "//input[@class='button-2 order-completed-continue-button']";




}
