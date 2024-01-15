package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
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

    private WebElement getWebElement(WebDriver driver, String xpathLocator){
        return driver.findElement(getByXpath(xpathLocator));
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator, String...restParaValue){
        return driver.findElement(getByXpath(xpathLocator, restParaValue));
    }
    private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator){
        return driver.findElements(getByXpath(xpathLocator));
    }

    private By getByXpath(String xpathLocator){
        return By.xpath(xpathLocator);
    }
    private By getByXpath(String xpathLocator, String...restParaValue){
        xpathLocator = String.format(xpathLocator, (Object[]) restParaValue);
        return By.xpath(xpathLocator);
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver,xpathLocator).click();
    }

    public void clickToElement(WebDriver driver, String xpathLocator, String... restParaValue){
        getWebElement(driver,xpathLocator, restParaValue).click();
    }



    public void sendKeyToElement(WebDriver driver, String xpathLocator, String inputtedText){
        WebElement webElement = getWebElement(driver,xpathLocator) ;
        webElement.clear();
        webElement.sendKeys(inputtedText);
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
    public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName){
        return getWebElement(driver,xpathLocator).getCssValue(propertyName);
    }

    public String getHexColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator){
        return getListWebElement(driver, xpathLocator).size();
    }

    public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator){
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }


    public boolean isElementEnable(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    public void switchToFrameOrIframe(WebDriver driver, String xpathLocator) {
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
        Actions action = new Actions(driver);
        action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    public void scrollToBottomPage(WebDriver driver) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                "border: 2px solid red; border-style: dashed;");
        sleepInSection(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
                originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    public void scrollToElement(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
                getWebElement(driver, xpathLocator));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
                getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(driver, xpathLocator));
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    public void waitForElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator, String... restParaValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator, restParaValue)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator, String... restParaValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator, restParaValue)));
    }

    public void waitForElementInVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForElementInVisible(WebDriver driver, String xpathLocator, String... restParaValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator, restParaValue)));
    }

    public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator, String... restParaValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator,restParaValue)));
    }

    private long shortTimeout = 10;
    private long longTimeout = 10;




}
