package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anny on 25.08.15.
 */
public class AppleExpensiveFilterPage {
    private WebDriver driver;

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

//
//    public void addToCompare(){
//        driver.findElement(B)
//    }
}



