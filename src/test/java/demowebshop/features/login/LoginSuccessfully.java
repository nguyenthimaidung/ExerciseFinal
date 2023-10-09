package demowebshop.features.login;


import demowebshop.common.BaseTest;
import demowebshop.pageobject.LoginPageObject;
import demowebshop.pageobject.PageGenerator;
import demowebshop.utils.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;


@Epic("demowebshop")
@Feature("LoginPageObject")
@Story("LoginSuccessfully")

public class LoginSuccessfully extends BaseTest {
    WebDriver driver;
    private LoginPageObject login;

    ExcelUtil excelUtil = new ExcelUtil();

    @DataProvider(name = "dataLogin")
    public String[][] dataTest() throws IOException {
        return excelUtil.data("Test data");
    }
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        login = PageGenerator.getLoginPageObject(driver);
    }
    @Test(dataProvider = "dataLogin")
    public void Login_01_loginSuccessfully (String STT, String UserName, String PassWord,String ExpectedMessage) {
        login.gotoURL("https://demowebshop.tricentis.com/");
        login.verifyTitle("Demo Web Shop");
        login.clickLogin();
        login.verifyTitle("Demo Web Shop. Login");
        login.inputEmail(UserName);
        login.inputPassWord(PassWord);
        login.clickBtnLogin();
        login.expectedMessage("message",ExpectedMessage);

//        if(UserName.equals("hihaha@abc.def") && PassWord.equals("Abcd@1234")){
//            login.verifyLoginSuccessfully();
//        }
//        else if (UserName.equals("123456")) {
//                login.verifyMessage1("textCanThay", ExpectedMessage);
//        }else {
//            login.verifyMessage("textCanThay",ExpectedMessage);
//        }
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanBrowserAndDriver();
    }
}
