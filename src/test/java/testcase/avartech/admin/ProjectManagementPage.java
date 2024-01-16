package testcase.avartech.admin;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectDetailPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectManagementPage extends BaseTest {
    String userName = "root";
    String password = "admin@1234";
    private LoginPageObject loginPage;
    private ProjectManagementPageObject projectManagementPage;
    private ProjectDetailPageObject projectDetailPage;
    private UserManagementPageObject userManagementPage;
    String projectName = "new Project";
    String rowNumber = "1";
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriver(browserName);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserName(userName);
        loginPage.inputPassWord(password);
        userManagementPage = loginPage.clickToLoginButton();
        projectManagementPage = userManagementPage.clickToProjectManagementTab();
        //projectManagementPage = PageGenerator.getProjectManagementPage(driver);
    }

    @Test
    public void tc02_editProject(){

        projectDetailPage = projectManagementPage.clickToFirstProject();

        projectDetailPage.clickToEditButton();

        projectDetailPage.inputNewProjectName(projectName);

        projectDetailPage.clickToConfirmButton();

        //Assert.assertEquals(projectDetailPage.getNewProjectName(), projectName);

    }
}
