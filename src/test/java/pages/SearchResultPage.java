package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends AbstractPage{

    private final By linksText = By.cssSelector("h3>a");
    //private final By linksText = By.cssSelector("[class='search-item']>p:not([class='search-date'])");
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement>getLinksText(){
        return getElements(linksText);
    }
}
