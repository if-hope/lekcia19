package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPage {

    protected WebDriver driver;

    private final static int TIME_TO_WAIT_DEFAULT = 5;

    private final By searchButton = By.cssSelector("[class='quick-search__icon']:nth-of-type(1)");
    private final By searchField = By.cssSelector("[class='quick-search__field']");
    private final By searchSubmit = By.cssSelector("button>[class='quick-search__icon']");

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPage openMainPage(){
        driver.get("https://hire-tester.com/");
        return this;
    }
//WebDriverWait wait = new WebDriverWait(driver,30);
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


    public SearchResultPage search(String searchRequest){
        driver.findElement(searchButton).click();
        driver.findElement(searchField).sendKeys(searchRequest);
        driver.findElement(searchSubmit).click();
        return new SearchResultPage(driver);
    }
}
