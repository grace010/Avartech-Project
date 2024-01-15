package testcase.avartech.admin;
import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.LoginPageObject;
import common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {
    String userName = "root";
    String password = "admin@1234";
    private LoginPageObject loginPage;
    @Parameters("browser")
    @BeforeClass ()
    public void beforeClass(String browserName){
    getBrowserDriver(browserName);
    loginPage = PageGenerator.getLoginPage(driver);

    }
    @Test
    public void tc01_login(){
        loginPage.inputUserName(userName);
        loginPage.inputPassWord(password);
        loginPage.clickToLoginButton();

    }

}
