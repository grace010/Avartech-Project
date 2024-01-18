package testcase.avartech.user;

import common.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import user.pagegeneratormanager.PageGenerator;
import user.pageobjects.HomePageObject;
import user.pageobjects.LoginPageObject;

public class MarketPlaceSoilRestorationPageTCs extends BaseTest {
    private String email = "yen.tran+1@sotatek.com";
    private String password = "Yen12345!";
    private LoginPageObject loginPage;
    private HomePageObject homePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriverUserSite(browserName);
        homePage = PageGenerator.getHomePage(driver);
        loginPage = homePage.clickToLoginButton();
        //sleepInSection(2);
        //loginPage.refeshPage();
        sleepInSection(8);
        loginPage.inputEmail(email);
        loginPage.inputPassWord(password);
        sleepInSection(3);
        loginPage.clickToCapChaCheckBox();
        homePage = loginPage.clickToLoginButton();
    }

    @Test
    public void tc01_CheckProjectName(){

    }

    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {
            // TODO: handle exceptVerify_Default_Dropdown2.javaion
            e.printStackTrace();
        }
    }

}
