package admin.pageobjects;

import admin.pageuis.ProjectDetailPageUI;
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

    public void clickToFirstProject() {
        waitForElementClickable(driver, ProjectManagementPageUI.ROW_TABLE);
        clickToElement(driver,ProjectManagementPageUI.ROW_TABLE);
        //return new ProjectDetailPageObject(driver);
    }

    public void clickToFirstProject(String ColumnName, String RowIndex) {
        int columnIndex = getElementSize(driver, ProjectManagementPageUI.COLUMN_INDEX, ColumnName) + 1;
        waitForAllElementVisible(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, RowIndex,String.valueOf(columnIndex));
        sendkeyToElement(driver, HomePageUI.COLUMN_ROW_INDEX_TEXTBOX, valueIntoTextBox, RowIndex,String.valueOf(columnIndex));
    }
    public void clickToEditButton() {
        waitForElementClickable(driver, ProjectDetailPageUI.EDIT_BUTTON);
        clickToElement(driver, ProjectDetailPageUI.EDIT_BUTTON);
    }

    public void inputNewProjectName(String projectName) {
        //WebElement shadowHost = driver.findElement(By.xpath(ProjectDetailPageUI.SHADOW_ROOT_PROJECT_NAME_TEXT_BOX));
        //SearchContext shadow = shadowHost.getShadowRoot();
        // WebElement accept = shadow.findElement(By.xpath(ProjectDetailPageUI.PROJECT_NAME_TEXT_BOX));
        // accept.clear();
        // accept.sendKeys(projectName);
        waitForElementVisible(driver,ProjectDetailPageUI.PROJECT_NAME_TEXT_BOX);
        sendKeyToElement(driver, ProjectDetailPageUI.PROJECT_NAME_TEXT_BOX,projectName );
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, ProjectDetailPageUI.CONFIRM_BUTTON);
        clickToElement(driver,ProjectDetailPageUI.CONFIRM_BUTTON);
    }
}
