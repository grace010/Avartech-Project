package admin.pagegeneratormanager;

import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectDetailPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static UserManagementPageObject getUserManagementPage(WebDriver driver){
        return new UserManagementPageObject(driver);
    }
    public static ProjectManagementPageObject getProjectManagementPage(WebDriver driver){
        return new ProjectManagementPageObject(driver);
    }
    public static ProjectDetailPageObject getProjectDetailPage(WebDriver driver){
        return new ProjectDetailPageObject(driver);
    }
}
