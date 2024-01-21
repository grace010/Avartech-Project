package testcase.avartech.admin;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import common.BaseTest;
import org.openqa.selenium.By;
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
    public int randomProjectName = randomInt();
    public String projectName = "New Project " + randomProjectName;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriverAdminSite(browserName);
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.inputUserName(userName);
        loginPage.inputPassWord(password);
        log.info("step 01: click to login button");
        userManagementPage = loginPage.clickToLoginButton();
    }

    @Test
    public void tc01_editProjectName(){
        log.info("step02: click to project management tab");
        projectManagementPage = userManagementPage.clickToProjectManagementTab();
        log.info("step02: click to project management tab");
        projectManagementPage.clickToFirstProject("Location", "1");
        log.info("step02: click to project management tab");
        projectManagementPage.clickToEditButton();
        log.info("step02: click to project management tab");
        projectManagementPage.inputNewProjectName(projectName);
        log.info("step02: click to project management tab");
        projectManagementPage.clickToConfirmButton();
        sleepInSection(6);
        Assert.assertEquals(projectManagementPage.getNewProjectName(), projectName);

    }

   /* @Test
    public void tc02_editNumberPictureOfProject(){

    }*/

    public int randomInt(){
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
