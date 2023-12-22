package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    protected WebDriver driver;

    private final static int TIME_TO_WAIT_DEFAULT = 5;

    private final By searchIcon = By.cssSelector("div>[class='quick-search__icon']");
    private final By searchField = By.cssSelector("[class='quick-search__field']");
    private final By searchSubmit = By.cssSelector("button>[class='quick-search__icon']");


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPage openMainPage(){
        driver.get("https://hire-tester.com/");
        return this;
    }
    public WebElement getElement(By by, int waitSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getElements(By by, int waitSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> getElements(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitTillAppear(By by, int secWait){
        new WebDriverWait(driver, Duration.ofSeconds(secWait))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillDisappear(By by, int secWait){
        new WebDriverWait(driver, Duration.ofSeconds(secWait))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

   public SearchResultPage search(String searchText){
        driver.findElement(searchIcon).click();
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(searchSubmit).click();
        return new SearchResultPage(driver);
   }

   public void clickJS(By by){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", getElement(by));
   }







}
