package user.pageobjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import user.pagegeneratormanager.PageGenerator;
import user.pageuis.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public LoginPageObject clickToLoginButton() {
        waitForElementClickable(driver, HomePageUI.LOG_IN_LINK_ON_HEADER);
        clickToElement(driver, HomePageUI.LOG_IN_LINK_ON_HEADER);
        return PageGenerator.getLoginPage(driver);
    }
}
