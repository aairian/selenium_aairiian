package automationFramework;

import core.TestBase;
import org.testng.annotations.Test;
import pageObjects.GoogleSearchPages;

import static org.testng.Assert.assertTrue;

/**
 * Created by selenium on 22.07.2015.
 */
public class GoogleSearchTest extends TestBase {

    private String googleWebSite = "https://www.google.com";
    private String searchText = "Selenium";

    @Test
    public void seleniumSearchTest() {
        GoogleSearchPages onGoogleSearchPages = new GoogleSearchPages(driver);
        onGoogleSearchPages.open(googleWebSite);
        onGoogleSearchPages.searchText(searchText);
        assertTrue(onGoogleSearchPages.findURL().getText().contains(searchText));
    }
}
