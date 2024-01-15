package admin.pagegeneratormanager;

import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static UserManagementPageObject getUserManagerment(WebDriver driver){
        return new UserManagementPageObject(driver);
    }
    public static ProjectManagementPageObject getProjectManagement(WebDriver driver){
        return new ProjectManagementPageObject(driver);
    }
}
