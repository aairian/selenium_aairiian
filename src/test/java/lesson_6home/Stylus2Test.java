package lesson_6home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Created by anny on 28.07.15.
 */
public class Stylus2Test {
    private WebDriver driver;
    private WebElement firstTabItem;
    private WebElement firstLinkItem;
    private WebElement firstLinkItem2;
    private WebElement buyButton;
    private WebElement continShop;
    private WebElement basketCount;
}
    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://stylus.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void addItemToBasketTest() {
        firstTabItem = driver.findElement(By.name("q"));
        firstLinkItem = driver.findElement
        driver.findElement(By.cssSelector("input[type='submit'][value='Найти']")).click();
        searchLink = driver.findElement(By.xpath("//img[@title='Sony Xperia Z2 Black']"));
        assertTrue(searchLink.getText().contains(searchText));
    }


