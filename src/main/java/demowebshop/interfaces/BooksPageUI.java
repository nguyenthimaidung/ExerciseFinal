package demowebshop.interfaces;

public class BooksPageUI {
    public static String TAGBOOKS = "//li[@class='inactive']//a[contains(text(),'Books')]";
    public static String LISTRATING ="//div[@class='rating']//div";
    public static String BTNADDTOCART = "//div[contains(@style,'text') ]/ancestor::div[@class='product-rating-box']/following-sibling::div[@class='add-info']//input[@value='Add to cart']";

    public static String SHOPPINGCART = "//span[text()='Shopping cart']";
    public static String NUMBERITEM = "//a[@class='ico-cart']//span[text()='(number)']";
    public static String MESSAGE = "//p[contains(text(),'The product has been added to your')]";
    public static String TITLEBOOK = "//div[contains(@style,'text') ]/ancestor::div[@class='product-rating-box']/preceding-sibling::h2[@class='product-title']//a";
    public static String CART_NAMEBOO1 = "(//div[@id ='flyout-cart']//div[@class='name']//a)[1]";
    public static String CART_NAMEBOO2 = "(//div[@id ='flyout-cart']//div[@class='name']//a)[2]";
    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }



}
