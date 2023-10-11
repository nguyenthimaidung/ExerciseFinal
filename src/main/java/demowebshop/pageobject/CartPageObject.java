package demowebshop.pageobject;

import demowebshop.common.BaseTest;
import demowebshop.helper.Log;
import demowebshop.interfaces.BooksPageUI;
import demowebshop.interfaces.CartPageUI;
import demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPageObject extends BaseTest {
    WebDriver driver;
    public CartPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void gotoURL(String value){
        gotoURL(driver,value);
    }
    public void verifyTitle(String value){
        Assert.assertEquals(driver.getTitle(),value);
        Log.allure("Open correct page");
    }

    public void addBookToCartAndVerify(String nameProduct ,String number)  {
        clickElement(driver, CartPageUI.CHANGEXPATH(CartPageUI.BTN_ADDTOCART,"titleProduct",nameProduct));

        waitForElementUnDisplay(driver,CartPageUI.ICON_LOADING);
        String getTitle = driver.getTitle();
        if(getTitle.equals("Demo Web Shop")){
            //sleepInSecond(10);
            waitForElementUnDisplay(driver,CartPageUI.MESSAGE);
            refreshCurrentPage(driver);
        }else{
            refreshCurrentPage(driver);
            clickElement(driver,CartPageUI.SELECT_CONDITION);
            clickElement(driver,CartPageUI.BTNADD_DETAIL);
            elementIsVisible(driver, CartPageUI.MESSAGE);
            waitForElementUnDisplay(driver,CartPageUI.MESSAGE);
            clickElement(driver,CartPageUI.GOHOME);
        }

        elementIsVisible(driver,CartPageUI.CHANGEXPATH(CartPageUI.NUMBERITEM,"number",number));

    }
    public void openShoppingCart(){
        clickElement(driver,CartPageUI.SHOPPINGCART);
    }
    public void selectProductRemove(String nameProduct){
        clickElement(driver,CartPageUI.CHANGEXPATH(CartPageUI.CHECKBOX_REMOVE,"nameProduct",nameProduct));
    }
    public void verifyProductSelected(String nameProduct){
        WebElement verifySelected = driver.findElement(By.xpath(CartPageUI.CHANGEXPATH(CartPageUI.CHECKBOX_REMOVE,"nameProduct",nameProduct)));
        Assert.assertTrue(verifySelected.isSelected());
    }
    public void clickBtnUpdateCart (String index_1,String index_2,String productAdded1,String productAdded2){
        String numberBeforeRemove = getTextElement(driver,CartPageUI.CART_QUANTITY).substring(1,2);
        clickElement(driver,CartPageUI.BTN_UPDATECART);
        String product_1 = getTextElement(driver,CartPageUI.CHANGEXPATH(CartPageUI.PRODUCT_NOTREMOVED,"index",index_1));
        String product_2 = getTextElement(driver,CartPageUI.CHANGEXPATH(CartPageUI.PRODUCT_NOTREMOVED,"index",index_2));
        Assert.assertEquals(product_1,productAdded1);
        Assert.assertEquals(product_2,productAdded2);
        String numberAfterRemove = getTextElement(driver,CartPageUI.CART_QUANTITY).substring(1,2);

        String expectNumber =  String.valueOf(Integer.parseInt(numberBeforeRemove) -1);
        Assert.assertEquals(expectNumber,numberAfterRemove);
    }
//    public void productAfterRemove(String index_1,String index_2,String productAdded1,String productAdded2,String number){
//        String product_1 = getTextElement(driver,CartPageUI.CHANGEXPATH(CartPageUI.PRODUCT_NOTREMOVED,"index",index_1));
//        System.out.println("1" + product_1);
//        String product_2 = getTextElement(driver,CartPageUI.CHANGEXPATH(CartPageUI.PRODUCT_NOTREMOVED,"index",index_2));
//        System.out.println("2" + product_2);
//
//        Assert.assertEquals(product_1,productAdded1);
//        Assert.assertEquals(product_2,productAdded2);
//        elementIsVisible(driver,CartPageUI.CHANGEXPATH(CartPageUI.NUMBERITEM,"number",number));
//    }

}
