package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 26.07.15.
 */
public class StylusIPhone6Test {
    private WebDriver driver;
    private WebElement navAppleStore;
    private WebElement subIPhone;
    private WebElement itemIPhone6;
    private WebElement isIphone6Present;
    private WebElement prcMinFilter;
    private WebElement prcMaxFilter;
    private WebElement filterSubmitButt;
    private WebElement filtResultItem;
    private WebElement logo;
    private String prcMinFilterValue = "20000";
    private String prcMaxFilterValue = "30000";
    WebDriverWait wait;


    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://stylus.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logo  = driver.findElement(By.cssSelector(".logo>a[href*='http://stylus.com.ua']"));
        assertEquals("http://stylus.com.ua/", logo.getAttribute("href"));
    }

    @Test
    public void searchItem() {
        navAppleStore = driver.findElement(By.cssSelector("a[href*='apple_store']"));
        Actions action = new Actions(driver);
        action.moveToElement(navAppleStore).perform();

        subIPhone = driver.findElement(By.xpath("//a[@class='active' and text()='iPhone']"));
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(subIPhone));
        action.moveToElement(subIPhone).perform();

        itemIPhone6 = driver.findElement(By.xpath(".//*[@id='tab-1-25']/ul/li[6]/div/a/span"));
        wait.until(ExpectedConditions.elementToBeClickable(itemIPhone6));
        action.moveToElement(itemIPhone6);
        action.click();
        action.perform();
        isIphone6Present = driver.findElement(By.xpath(".//*[@id='content']/h1"));
        assertEquals("Apple iPhone 6", isIphone6Present.getText());


        prcMinFilter = driver.findElement(By.name("price_f"));
        prcMinFilter.clear();
        prcMinFilter.sendKeys(prcMinFilterValue);
        prcMaxFilter = driver.findElement(By.name("price_t"));
        prcMaxFilter.clear();
        prcMaxFilter.sendKeys(prcMaxFilterValue);

        filterSubmitButt = driver.findElement(By.xpath("//input[@type='submit' and @value='OK']"));
        filterSubmitButt.click();
        filtResultItem = driver.findElement(By.xpath("//h1[.='Смартфон Apple iPhone 6 128GB Space Gray']"));
        assertEquals("Смартфон Apple iPhone 6 128GB Space Gray", filtResultItem.getText());

    }


    @AfterTest
    public void tearDown()

    {
        driver.quit();
    }
}
