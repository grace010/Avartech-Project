package admin.pageobjects;

import admin.pageuis.ProjectManagementPageUI;
import common.BasePage;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectManagementPageObject extends BasePage {
    private WebDriver driver;
    public ProjectManagementPageObject(WebDriver driver){
        this.driver = driver;

    }

    public ProjectDetailPageObject clickToFirstProject() {
        waitForElementClickable(driver, ProjectManagementPageUI.ROW_TABLE);
        clickToElement(driver,ProjectManagementPageUI.ROW_TABLE);
        return new ProjectDetailPageObject(driver);
    }
}
