package bionicUniversityCourse.pageObjects;

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


    public AppleExpensiveFilterPage (WebDriver driver){this.driver=driver;}


    public WebElement findItem (String itemName){
        List<WebElement> goodsBox = driver.findElements(By.className("g-i-tile-i-box"));
        for(WebElement item : goodsBox){
            if (item.getText().contains(itemName)){
                return item;
            }
        }
        return findItem(itemName);
    }

    public AppleExpensiveFilterPage addToCompare(String itemName){
        List<WebElement> compareImgs = findItem(itemName).findElements(By.tagName("img"));
        for (WebElement compareImg : compareImgs){
            if (compareImg.getAttribute("title").contains("Добавить к сравнению")){
                compareImg.click();
            }
        }
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

    public NotebooksComparisonPage compareItems (){
        WebElement comparisonButton = comparisonBlock().findElement(By.tagName("span"));
        if (comparisonButton.getText().contains("Сравнить")){
            comparisonButton.click();
        }
        return new NotebooksComparisonPage(driver);
    }
}



