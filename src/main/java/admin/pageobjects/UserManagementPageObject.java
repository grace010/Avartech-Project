package admin.pageobjects;


import admin.pagegeneratormanager.PageGenerator;
import admin.pageuis.UserManagementPageUI;
import common.BasePage;
import org.openqa.selenium.WebDriver;

public class UserManagementPageObject extends BasePage {
    private WebDriver driver;
    public UserManagementPageObject(WebDriver driver){
        this.driver = driver;
    }

    public  ProjectManagementPageObject clickToProjectManagementTab() {
        waitForElementClickable(driver, UserManagementPageUI.PROJECT_MANAGEMENT_TAB);
        clickToElement(driver, UserManagementPageUI.PROJECT_MANAGEMENT_TAB);
        return PageGenerator.getProjectManagementPage(driver);
    }

}


