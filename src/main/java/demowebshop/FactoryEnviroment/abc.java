package demowebshop.FactoryEnviroment;

public class abc {
    public static void main(String[] args) {
        String xpathgoc = "//li[text()='textCanThay']";
        System.out.printf(changeXpath(xpathgoc, "textCanThay", "The credentials provided are incorrect"));
    }

    static String changeXpath(String xpath, String textcanchuyen, String textThay) {
      return xpath.replace(textcanchuyen, textThay);
    }
}
