package testcase.avartech.admin;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminManagementPageTCs {
    public WebDriver driver;
    public WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tc01(){
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");
        String originalWindow  = driver.getWindowHandle();
        scrollToElement();
        sleepInSection(3);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='new window']")));
        driver.findElement(By.xpath("//a[text()='new window']")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        System.out.println(driver.getTitle());

    }

    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {
            // TODO: handle exceptVerify_Default_Dropdown2.javaion
            e.printStackTrace();
        }
    }

    public void scrollToElement() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h3[text()='Get window handle']")));
    }


}
