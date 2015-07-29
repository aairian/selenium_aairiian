package ui_tests.lesson_7;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPages;

import java.util.concurrent.TimeUnit;

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
