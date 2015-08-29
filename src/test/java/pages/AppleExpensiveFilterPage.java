package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by anny on 25.08.15.
 */
public class AppleExpensiveFilterPage {
    private WebDriver driver;
    private WebElement toComparison;

    public AppleExpensiveFilterPage (WebDriver driver){this.driver=driver;}

    public WebElement findItem (String itemName){
        List<WebElement> listOfItems = driver.findElements(By.xpath("//*[@class='g-i-tile-i-title clearfix']/a"));
        for(WebElement item : listOfItems){
            if (item.getText().contains(itemName)){
                return item;
            }
        }
        return findItem(itemName);
    }

    public AppleExpensiveFilterPage addToCompare(String itemName){
        toComparison = findItem(itemName).findElement(By.xpath("../following-sibling::div[@class='g-tools-container clearfix']/ul/li[@class='g-tools-i g-tools-delimiter']/div/label"));
        toComparison.click();
        return new AppleExpensiveFilterPage(driver);
    }
    public WebElement comparisonBlock (){
        WebElement comparisonBlock = driver.findElement(By.id("catalog-comparison"));
        comparisonBlock.isEnabled();
        assertTrue(comparisonBlock.findElement(By.tagName("h3")).getText().contains("Cписок сравнения"));
        return comparisonBlock;
    }

    public WebElement findItemInCompareList(String itemName){
        List<WebElement> compareItems = comparisonBlock().findElements(By.tagName("a"));
        for (WebElement compareItem : compareItems){
            if (compareItem.getText().contains(itemName)) {
                return compareItem;
            }
        }
        return findItemInCompareList(itemName);
    }
}



