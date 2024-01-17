package testcase.avartech.admin;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.LoginPageObject;
import admin.pageobjects.ProjectDetailPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import admin.pageobjects.UserManagementPageObject;
import common.BaseTest;
import org.openqa.selenium.By;
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

    }

    @Test
    public void tc02_editProject(){
        projectManagementPage = userManagementPage.clickToProjectManagementTab();
        //driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
       /* projectDetailPage =*/ projectManagementPage.clickToFirstProject();

        projectManagementPage.clickToEditButton();
        sleepInSection(5);

        projectManagementPage.inputNewProjectName(projectName);
        sleepInSection(5);

        projectManagementPage.clickToConfirmButton();

        //Assert.assertEquals(projectDetailPage.getNewProjectName(), projectName);

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
