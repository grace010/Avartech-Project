package testcase.avartech.admin;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;

public class ProjectManagementPageTCs extends BaseTest {
    private String userName = "root";
    private String password = "admin@1234";
    private LoginPageObject loginPage;
    private ProjectManagementPageObject projectManagementPage;
    private UserManagementPageObject userManagementPage;
    public static String projectName = "New Project" + randomInt();
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriverAdminSite(browserName);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserName(userName);
        loginPage.inputPassWord(password);
        userManagementPage = loginPage.clickToLoginButton();
    }

    @Test
    public void tc01_editProjectName(){
        projectManagementPage = userManagementPage.clickToProjectManagementTab();
        projectManagementPage.clickToFirstProject("Location", "1");
        projectManagementPage.clickToEditButton();
        projectManagementPage.inputNewProjectName(projectName);
        projectManagementPage.clickToConfirmButton();
        Assert.assertEquals(projectManagementPage.getNewProjectName(), projectName);
    }

    @Test
    public void tc02_editNumberPictureOfProject(){

    }

    public static int randomInt(){
        Random random = new Random();
        return random.nextInt(9999);
    }

    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {
            // TODO: handle exceptVerify_Default_Dropdown2.javaion
            e.printStackTrace();
        }
    }
}
