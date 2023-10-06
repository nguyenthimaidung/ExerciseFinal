package demowebshop.pageobject;

import demowebshop.common.BaseTest;
import demowebshop.helper.Log;
import demowebshop.interfaces.BooksPageUI;
import demowebshop.interfaces.LoginPageUI;
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
    public void clickLogin(){
        clickElement(driver, LoginPageUI.LOGIN);

    }

    public void clickTagBooks(){
        clickElement(driver,BooksPageUI.TAGBOOKS);
    }
    public void addToCart(){
        List<WebElement> listRating = driver.findElements((By.xpath(BooksPageUI.LISTRATING)));
        List<Double> listTextRaitings = new ArrayList<>();
        for (WebElement rating : listRating) {
            listTextRaitings.add(Double.parseDouble(rating.getText().substring(5,8)));
        }
        Collections.sort(listTextRaitings);
        for (Double listText : listTextRaitings) {
            System.out.println(listText);
        }
        clickElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.BTNADDTOCART,"text",Double.toString(listTextRaitings.get(0))));
        clickElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.BTNADDTOCART,"text",Double.toString(listTextRaitings.get(1))));
        clickElement(driver,BooksPageUI.CHANGEXPATH(BooksPageUI.BTNADDTOCART,"text",Double.toString(listTextRaitings.get(2))));

    }



}
