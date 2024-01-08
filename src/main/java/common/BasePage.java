package common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    public String getTitle(WebDriver driver){
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getSource(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void freshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(WebDriver driver) {
        Alert alert = waitForAlertPresence(driver);
        alert.accept();
    }

    public void cancelAlert(WebDriver driver) {
        Alert alert = waitForAlertPresence(driver);
        alert.dismiss();
    }

    public String getAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    public void sendKeyToAlert(WebDriver driver, String alertValue){
        waitForAlertPresence(driver).sendKeys(alertValue);
    }

    public void switchToWindowById(WebDriver driver, String WindowID) {
        Set<String> allWindowId = driver.getWindowHandles();
        for (String id : allWindowId) {
            if (!id.equals(WindowID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> windowID = driver.getWindowHandles();
        for (String id : windowID) {
            driver.switchTo().window(id);
            String title = driver.getTitle();
            if (title.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
        Set<String> windowID = driver.getWindowHandles();
        for (String id : windowID) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator){
        return driver.findElement(getByXpath(xpathLocator));
    }

    public By getByXpath(String xpathLocator){
        return By.xpath(xpathLocator);
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver,xpathLocator).click();
    }

    public void sendKeyToElement(WebDriver driver, String xpathLocator){
        WebElement webElement = getWebElement(driver,xpathLocator) ;
        webElement.clear();
        webElement.sendKeys();
    }

    public  void selectItemDefaultDropDown(WebDriver driver, String xpathLocator,String textItem){
        Select select = new Select(getWebElement(driver, xpathLocator));
        select.selectByVisibleText(textItem);
    }

    public String getFirstSelectedItem(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(WebDriver driver, String xpathLocator ){
        Select select = new Select(getWebElement(driver, xpathLocator));
        return select.isMultiple();
    }

    public void customDropDown(WebDriver driver, String parentNode, String childNode, String selectedItem) {
        getWebElement(driver, parentNode).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childNode)));
        sleepInSection(2);
        List<WebElement> allItems = driver.findElements(getByXpath(childNode));

        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.trim().equals(selectedItem)) {
                JavascriptExecutor jsExecutor;
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
                item.click();
                break;
            }
        }
    }
    public void sleepInSection(long timeInSection) {
        try {
            Thread.sleep(timeInSection * 1000);
        } catch (Exception e) {
            // TODO: handle exceptVerify_Default_Dropdown2.javaion
            e.printStackTrace();
        }
    }

    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName){
        return getWebElement(driver,xpathLocator).getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String xpathLocator){
        WebElement webElement = getWebElement(driver,xpathLocator) ;
        return webElement.getText();
    }

    private long longTimeout = 10;


























}
