package hiretestertests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AbstractPage;
import org.testng.Assert;
import pages.SearchResultPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SearchResultTest extends AbstractTest{

   @Test
    public void searchTest(){
       List<WebElement> searchResultLinks = new AbstractPage(driver).openMainPage()
               .search("test")
               .getSearchResultLinks();

       List<WebElement> searchResultDescriptions = new SearchResultPage(driver)
               .getSearchResultDescriptions();

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
       boolean isTest = concatinated.stream().allMatch(element -> element.contains("test"));
      Assert.assertTrue(isTest);

   }

}
