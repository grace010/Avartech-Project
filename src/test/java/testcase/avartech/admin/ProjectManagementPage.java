package testcase.avartech.admin;

import admin.pageobjects.ProjectManagementPageObject;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectManagementPage extends BaseTest {
    private ProjectManagementPageObject projectManagementPage;
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        getBrowserDriver(browserName);
        projectManagementPage = new ProjectManagementPageObject(driver);

    }
    public void tc01_editProject(){
        projectManagementPage.clickToFirstProject();

    }
}
