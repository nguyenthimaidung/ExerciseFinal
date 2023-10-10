package demowebshop.pageobject;

import demowebshop.common.BaseTest;
import demowebshop.helper.Log;
import demowebshop.interfaces.BooksPageUI;
import demowebshop.interfaces.LoginPageUI;
import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksPageObject extends BaseTest {
    WebDriver driver;
    public BooksPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }

    public void clickTagBooks(){
        clickElement(driver,BooksPageUI.TAGBOOKS);
    }
    public void addToCartAndVerifyAmount(){
        List<WebElement> listRating = driver.findElements((By.xpath(BooksPageUI.LISTRATING)));
        List<Integer> listTextRaitings = new ArrayList<>();
        for (WebElement rating : listRating) {
            listTextRaitings.add(Integer.parseInt(rating.getAttribute("style").substring(7,9)));
        }
        Collections.sort(listTextRaitings,Collections.reverseOrder());
        for (Integer listText : listTextRaitings) {
            System.out.println(listText);
        }
        for (int i=1; i < 3; i++){
        clickElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.BTNADDTOCART,"text",Integer.toString(listTextRaitings.get(i))));
        elementIsVisible(driver,BooksPageUI.MESSAGE);
        elementIsVisible(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.NUMBERITEM,"number",String.valueOf(i)));
//        clickElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.BTNADDTOCART,"text",Integer.toString(listTextRaitings.get(i))));
//        elementIsVisible(driver,BooksPageUI.MESSAGE);
//        elementIsVisible(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.NUMBERITEM,"number","2"));

    }}
    public void hoverOnShoppingCart(){
        hoverMouseToElement(driver,BooksPageUI.SHOPPINGCART);
    }
    public void verifyBooksOnShoppingCart(){
        List<WebElement> listRating = driver.findElements((By.xpath(BooksPageUI.LISTRATING)));
        List<Integer> listTextRaitings = new ArrayList<>();
        for (WebElement rating : listRating) {
            listTextRaitings.add(Integer.parseInt(rating.getAttribute("style").substring(7,9)));
        }
        Collections.sort(listTextRaitings);
        String Book1 = getTextElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.TITLEBOOK,"text",Integer.toString(listTextRaitings.get(4))));
        String Book2 =getTextElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.TITLEBOOK,"text",Integer.toString(listTextRaitings.get(3))));
        String listBook = Book1 + ',' + Book2;
        System.out.println("listbook = " + listBook);

        List<WebElement> listBookOnCart = driver.findElements((By.xpath(BooksPageUI.CART_NAMEBOOK)));
        for (WebElement books : listBookOnCart) {
            String nameBookOnCart = books.getText();
            nameBookOnCart.contains(listBook);
            System.out.println("A=" + nameBookOnCart);
        }
//
//        String cartNameBook1 = getTextElement(driver,BooksPageUI.CART_NAMEBOOK1);
//        String cartNameBook2 = getTextElement(driver,BooksPageUI.CART_NAMEBOOK2);
//
//        Assert.assertEquals(Book2,cartNameBook1);
//        Assert.assertEquals(Book1,cartNameBook2);

    }




}
