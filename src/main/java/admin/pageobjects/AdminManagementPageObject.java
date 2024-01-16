package admin.pageobjects;

import common.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminManagementPageObject extends BasePage {
    private WebDriver driver;

    public AdminManagementPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
