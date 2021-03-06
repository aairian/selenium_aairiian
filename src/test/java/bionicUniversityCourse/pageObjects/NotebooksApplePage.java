package bionicUniversityCourse.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

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

    public List<WebElement> filterList () throws InterruptedException {
        WebElement filterView = driver.findElement(By.name("drop_link"));
        filterView.click();
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String sortListPopWindow : allWindows) {
                if (driver.switchTo().window(sortListPopWindow).getTitle().equals("по рейтингу")) {
                }
            }
        }
        WebElement filterDropMenu = driver.findElement(By.name("drop_menu"));
        List<WebElement> filterList = filterDropMenu.findElements(By.tagName("a"));
        return filterList;
    }


    public AppleExpensiveFilterPage setFilter(String filterText) throws InterruptedException {
        for(WebElement filter : filterList()){
        if (filter.getText().equals(filterText)){
            filter.click();
            break;
        }
    }
        return new AppleExpensiveFilterPage(driver);
    }



}



