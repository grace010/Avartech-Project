package testcase.avartech.admin;

import admin.pagegeneratormanager.PageGenerator;
import admin.pageobjects.ProjectDetailPageObject;
import admin.pageobjects.ProjectManagementPageObject;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectManagementPage extends BaseTest {
    private ProjectManagementPageObject projectManagementPage;
    private ProjectDetailPageObject projectDetailPage;
    String projectName = "123";
    String rowNumber = "1";
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriver(browserName);
        projectManagementPage = PageGenerator.getProjectManagementPage(driver);
    }
    @Test
    public void tc01_editProject(){
        projectDetailPage = projectManagementPage.clickToFirstProject(rowNumber);

        projectDetailPage.clickToEditButton();

        projectDetailPage.inputNewProjectName(projectName);

        projectDetailPage.clickToConfirmButton();

        Assert.assertEquals(projectDetailPage.getNewProjectName(), projectName);

    }
}
