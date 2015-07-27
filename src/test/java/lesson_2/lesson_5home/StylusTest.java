package lesson_2.lesson_5home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by anny on 26.07.15.
 */
public class StylusTest {
    private WebDriver driver;
    private WebElement searchField;
    private WebElement searchButton;
    private String searchText;
    private WebElement searchLink;

    @BeforeTest
    public void setUp() {
        searchText = "Sony Xperia Z2 Black";
        driver = new FirefoxDriver();
        driver.get("http://stylus.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void stylusSearchTest() {
        searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchText);
        driver.findElement(By.cssSelector("input[type='submit'][value='Найти']")).click();
        searchLink = driver.findElement(By.xpath("//img[@title='Sony Xperia Z2 Black']"));
        assertTrue(searchLink.getText().contains(searchText));
    }

    @AfterTest
    public void tearDown()

    {
        driver.quit();
    }
}
