package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends AbstractPage{

    private final By searchResultLinks = By.cssSelector("h3>a");
    private final By searchResultDescriptions = By.cssSelector("[class='search-item']>p:not([class='search-date'])");

    public SearchResultPage(WebDriver driver) {

        super(driver);
    }

    public List<WebElement> getSearchResultLinks(){
        return
                getElements(searchResultLinks);
    }

    public List<WebElement> getSearchResultDescriptions(){
        return
                getElements(searchResultDescriptions);
    }

    public boolean searchContains(List<WebElement> searchResultLinks, List<WebElement> searchResultDescriptions){
        List<String> searchResultText =searchResultLinks.stream().map(searchResultLink -> searchResultLink.getText()).toList();
        List<String> searchResultDescText = searchResultDescriptions.stream().map(searchResultDescription -> searchResultDescription.getText()).toList();

        List<String> concatinated = new ArrayList<>();
        for (int i = 0; i < searchResultText.size();){
            for (int j = 0; j < searchResultDescText.size();){
                concatinated.add(searchResultText.get(i) + searchResultDescText.get(j));
                i++;
                j++;
            }
        }
        return concatinated.stream().allMatch(element -> element.contains("test"));
    }


}
