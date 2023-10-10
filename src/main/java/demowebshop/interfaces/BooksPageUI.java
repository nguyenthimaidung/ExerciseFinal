package demowebshop.interfaces;

public class BooksPageUI {
    public static String TAGBOOKS = "//ul[@class='top-menu']//a[contains(text(),'Books')]";
    public static String LISTRATING ="//div[@class='rating']//div";
    public static String BTNADDTOCART = "//div[contains(@style,'text') ]/ancestor::div[@class='product-rating-box']/following-sibling::div[@class='add-info']//input[@value='Add to cart']";

    public static String SHOPPINGCART = "//span[text()='Shopping cart']";
    public static String NUMBERITEM = "//a[@class='ico-cart']//span[text()='(number)']";
    public static String MESSAGE = "//p[contains(text(),'The product has been added to your')]";
    public static String TITLEBOOK = "//div[contains(@style,'text') ]/ancestor::div[@class='product-rating-box']/preceding-sibling::h2[@class='product-title']//a";
    public static String CART_NAMEBOOK1 = "(//div[@id ='flyout-cart']//div[@class='name']//a)[1]";
    public static String CART_NAMEBOOK2 = "(//div[@id ='flyout-cart']//div[@class='name']//a)[2]";
    public static String CART_NAMEBOOK = "//div[@id ='flyout-cart']//div[@class='name']//a";
    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }
    public static String CART_QUANTITY = "//a[@class='ico-cart']//span[@class ='cart-qty']";





}
