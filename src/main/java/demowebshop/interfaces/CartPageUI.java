package demowebshop.interfaces;

public class CartPageUI {
    public static String SHOPPINGCART = "//span[text()='Shopping cart']";
    public static String NUMBERITEM = "//a[@class='ico-cart']//span[text()='(number)']";
    public static String MESSAGE = "//p[contains(text(),'The product has been added to your')]";
    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }
    public static String BTN_ADDTOCART = "//a[text()='titleProduct']/ancestor::div[@class='details']//div//input[@value='Add to cart']";
    public static String CHECKBOX_REMOVE = "//a[contains(text(),'nameProduct')]/ancestor::td/preceding-sibling::td//input[@type='checkbox']";
    public static String SELECT_CONDITION = "//label[contains(text(),'Slow ')]";
    public static String GOHOME = "//img[@alt='Tricentis Demo Web Shop']";
    public static String BTNADD_DETAIL = "//input[@class='button-1 add-to-cart-button']";
    public static String ICON_LOADING = "//div[@class='loading-image']";
    public static String BTN_UPDATECART = "//input[@name='updatecart']";
    public static String PRODUCT_NOTREMOVED = "(//td[@class='product']//a[@class='product-name'])[index]";


}
