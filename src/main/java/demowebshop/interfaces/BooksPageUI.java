package demowebshop.interfaces;

public class BooksPageUI {
    public static String TAGBOOKS = "//li[@class='inactive']//a[contains(text(),'Books')]";
    public static String LISTRATING ="//div[@class='rating']//div";
    public static String BTNADDTOCART = "//div[@style='text']/ancestor::div[@class='product-rating-box']/following-sibling::div[@class='add-info']//input[@value='Add to cart']";

    public static String SHOPPINGCART = "//span[text()='Shopping cart']";

    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }



}
