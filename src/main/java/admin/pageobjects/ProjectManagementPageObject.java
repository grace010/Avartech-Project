package admin.pageobjects;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageuis.ProjectManagementPageUI;
import admin.pageuis.UserManagementPageUI;
import common.BasePage;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

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

    public void sortGrowerByAsc() {

    }

    public ProjectManagementPageObject clickToProjectManagementTab() {
        waitForElementClickable(driver, UserManagementPageUI.PROJECT_MANAGEMENT_TAB);
        clickToElement(driver, UserManagementPageUI.PROJECT_MANAGEMENT_TAB);
        return PageGenerator.getProjectManagementPage(driver);
    }

    public void clickToGrowerSortButton() {
        waitForElementVisible(driver, ProjectManagementPageUI.GROWER_SORT_BUTTON);
        clickToElement(driver, ProjectManagementPageUI.GROWER_SORT_BUTTON);
    }

    public int getListPagingSize(){
        //waitForElementClickable(driver, ProjectManagementPageUI.LIST_PAGING);
        return getElementSize(driver, ProjectManagementPageUI.LIST_PAGING);
    }



    public boolean getGrowerByText() {
        List<String> listDataByEachPageBeforeSort = new ArrayList<String>();
        scrollToBottomPage(driver);
        sleepInSection(2);
        for (int i = 2; i <= (getListPagingSize()-1); i++) {
            clickToElement(driver, ProjectManagementPageUI.LIST_PAGING_BY_INDEX, String.valueOf(i));
            sleepInSection(2);
            List<WebElement> listWebElement = getListWebElement(driver, ProjectManagementPageUI.GROWER_LIST_BY_NAME);
            for (WebElement listItem : listWebElement) {
                String listText = listItem.getText();
                listDataByEachPageBeforeSort.add(listText);
            }
        }


        List<String> listDataByEachPageAfterSort = new ArrayList<String>();
        for (String listProduct :listDataByEachPageBeforeSort) {
            listDataByEachPageAfterSort.add(listProduct);
        }

        Collections.sort(listDataByEachPageAfterSort);
        return listDataByEachPageBeforeSort.equals(listDataByEachPageAfterSort);
    }

}