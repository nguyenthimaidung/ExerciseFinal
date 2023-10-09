package demowebshop.pageobject;


import demowebshop.common.BaseTest;
import demowebshop.helper.Log;
import demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BaseTest {
    WebDriver driver;
    public LoginPageObject(WebDriver driver){
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
        clickElement(driver,LoginPageUI.LOGIN);

    }
    public void inputEmail(String value){
        sendKeyToElement(driver, LoginPageUI.TXT_EMAIL,value);
        Log.allure("Input email success");
    };
    public void inputPassWord(String value){
        sendKeyToElement(driver, LoginPageUI.TXT_PASSWORD,value);
        Log.allure("Input password success");
    };

    public void clickBtnLogin(){
        clickElement(driver, LoginPageUI.BTN_LOGIN);
        Log.allure("Login success");
    };
    public void expectedMessage(String textcanchuyen, String textThay){
        elementIsVisible(driver,LoginPageUI.CHANGEXPATH(LoginPageUI.MESSAGE,textcanchuyen,textThay));
    }
    public void verifyMessage(String textcanchuyen, String textThay){
        elementIsVisible(driver,LoginPageUI.CHANGEXPATH(LoginPageUI.XPATHGOC,textcanchuyen,textThay));
    }
    public void verifyMessage1(String textcanchuyen, String textThay){
        elementIsVisible(driver,LoginPageUI.CHANGEXPATH(LoginPageUI.XPATHGOC2,textcanchuyen,textThay));
    }

    public void verifyLoginSuccessfully(){
        elementIsVisible(driver,LoginPageUI.LOGOUT);
    }
}
