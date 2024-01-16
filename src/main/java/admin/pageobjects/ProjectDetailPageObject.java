package admin.pageobjects;

import admin.pageuis.ProjectDetailPageUI;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectDetailPageObject extends BasePage {
    private WebDriver driver;

    public ProjectDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToEditButton() {
        waitForElementClickable(driver, ProjectDetailPageUI.EDIT_BUTTON);
        clickToElement(driver, ProjectDetailPageUI.EDIT_BUTTON);
    }

    public void inputNewProjectName(String projectName) {
        WebElement shadowHost = driver.findElement(By.xpath(ProjectDetailPageUI.SHADOW_ROOT_PROJECT_NAME_TEXT_BOX));
        SearchContext shadow = shadowHost.getShadowRoot();
        WebElement accept = shadow.findElement(By.xpath(ProjectDetailPageUI.PROJECT_NAME_TEXT_BOX));
        accept.clear();
        accept.sendKeys(projectName);
    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, ProjectDetailPageUI.CONFIRM_BUTTON);
        clickToElement(driver,ProjectDetailPageUI.CONFIRM_BUTTON);
    }

    public String getNewProjectName() {
        return "";
    }
}
