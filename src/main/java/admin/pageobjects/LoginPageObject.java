package admin.pageobjects;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageuis.LoginPageUI;
import common.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputUserName(String userName) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.USER_NAME_TEXTBOX,userName);
    }

    public void inputPassWord(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public UserManagementPageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserManagementPage(driver);
    }
}
