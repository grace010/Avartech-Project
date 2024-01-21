package admin.pageobjects;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageuis.ProjectManagementPageUI;
import common.BasePage;
import org.openqa.selenium.WebDriver;

public class ProjectManagementPageObject extends BasePage {
    private WebDriver driver;
    public ProjectManagementPageObject(WebDriver driver){
        this.driver = driver;

    }

    public void clickToFirstProject(String ColumnName, String RowIndex) {
        int columnIndex = getElementSize(driver, ProjectManagementPageUI.COLUMN_INDEX_BY_NAME, ColumnName) + 1;
        waitForElementVisible(driver, ProjectManagementPageUI.COLUMN_ROW_INDEX_TEXT_BOX, RowIndex,String.valueOf(columnIndex));
        clickToElement(driver, ProjectManagementPageUI.COLUMN_ROW_INDEX_TEXT_BOX, RowIndex,String.valueOf(columnIndex));
    }
    public ProjectManagementPageObject clickToEditButton() {
        //areJQueryAndJSLoadedSuccess(driver);
        sleepInSection(4);
        //waitForPageLoad(driver);
        scrollToBottomPage(driver);
        waitForElementClickable(driver, ProjectManagementPageUI.EDIT_BUTTON);
        clickToElement(driver, ProjectManagementPageUI.EDIT_BUTTON);
        return PageGenerator.getProjectManagementPage(driver);
    }

    public void inputNewProjectName(String projectName) {
        waitForElementVisible(driver, ProjectManagementPageUI.PROJECT_NAME_TEXT_BOX);
        sendKeyToElement(driver, ProjectManagementPageUI.PROJECT_NAME_TEXT_BOX, projectName);
    }

    public void clickToConfirmButton() {
        scrollToBottomPage(driver);
        waitForElementClickable(driver, ProjectManagementPageUI.CONFIRM_BUTTON);
        clickToElement(driver, ProjectManagementPageUI.CONFIRM_BUTTON);
    }


    public String getNewProjectName() {
        waitForElementVisible(driver, ProjectManagementPageUI.PROJECT_NAME);
        return getElementText(driver, ProjectManagementPageUI.PROJECT_NAME);

    }

}