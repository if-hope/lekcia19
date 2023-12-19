package hiretestertests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AbstractPage;
import org.testng.Assert;

import java.util.List;

public class SearchResultTest extends AbstractTest{

@Test
    public void searchContainsTextTest(){
    List<WebElement> linkTitles = new AbstractPage(driver)
            .openMainPage()
            .search("test")
            .getLinksText();

    List<String> linksText = linkTitles.stream().map(linkTitle -> linkTitle.getText().toLowerCase()).toList();
    boolean isTest = linksText.stream().anyMatch(text-> linksText.contains("test"));
    Assert.assertTrue(isTest);

}
}
