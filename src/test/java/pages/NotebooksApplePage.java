package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertFalse;

/**
 * Created by anny on 23.08.15.
 */
public class NotebooksApplePage {
    private WebDriver driver;
    private WebElement pageTitle;

    public NotebooksApplePage (WebDriver driver){this.driver=driver;}

    public WebElement findPageTitle(){
        pageTitle = driver.findElement(By.cssSelector(".c-cols-inner-l>h1"));
        return pageTitle;
    }

    public AppleExpensiveFilterPage setExpensiveFilter(){
        Select expensiveFilter = new Select(driver.findElement(By.name("drop_menu")));
        assertFalse(expensiveFilter.isMultiple());
        expensiveFilter.selectByVisibleText("от дорогих к дешевым");
        return new AppleExpensiveFilterPage(driver);
    }



}
