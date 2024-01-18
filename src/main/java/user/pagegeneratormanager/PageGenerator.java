package user.pagegeneratormanager;
import org.openqa.selenium.WebDriver;
import user.pageobjects.HomePageObject;
import user.pageobjects.LoginPageObject;
import user.pageobjects.MarketPlaceSoilRestorationPageObject;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static MarketPlaceSoilRestorationPageObject getMarketPlaceSoilRestorationPage(WebDriver driver) {
        return new MarketPlaceSoilRestorationPageObject(driver);
    }
}

