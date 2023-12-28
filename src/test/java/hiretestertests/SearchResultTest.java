package hiretestertests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AbstractPage;
import org.testng.Assert;
import pages.SearchResultPage;
import java.util.List;

public class SearchResultTest extends AbstractTest{

   @Test
    public void searchTest(){
       List<WebElement> searchResultLinks = new AbstractPage(driver).openMainPage()
               .search("test")
               .getSearchResultLinks();

       SearchResultPage searchResultPage = new SearchResultPage(driver);

       List<WebElement> searchResultDescriptions = searchResultPage
               .getSearchResultDescriptions();

       Assert.assertTrue(searchResultPage.searchContains(searchResultLinks, searchResultDescriptions));

   }

}
