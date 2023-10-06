package demowebshop.interfaces;

public class LoginPageUI {
    public static String LOGIN = "//a[@class ='ico-login']";
    public static String TXT_EMAIL = "//input[@class ='email']";
    public static String TXT_PASSWORD = "//input[@id = 'Password']";
    public static String BTN_LOGIN = "//input[@class = 'button-1 login-button']";
    public static String XPATHGOC = "//li[text()='textCanThay']";
    public static String XPATHGOC2 = "//span[text()='textCanThay']";
    public static String CHANGEXPATH(String xpath, String textCanChuyen, String textThay) {
        return xpath.replace(textCanChuyen, textThay);
    }
    public static String LOGOUT = "//a[@class ='ico-logout']";
}
