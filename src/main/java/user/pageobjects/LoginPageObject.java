package user.pageobjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import user.pagegeneratormanager.PageGenerator;
import user.pageuis.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputEmail(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, email);
    }

    public void inputPassWord(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
    }

    public void clickToCapChaCheckBox() {
        waitForElementClickable(driver,LoginPageUI.CAP_CHA_CHECKBOX_BOX);
        clickToElement(driver, LoginPageUI.CAP_CHA_CHECKBOX_BOX);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }

    public void refeshPage() {
        freshCurrentPage(driver);

    }
}
