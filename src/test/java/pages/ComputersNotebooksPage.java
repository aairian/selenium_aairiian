package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by anny on 22.08.15.
 */
public class ComputersNotebooksPage {
    private WebDriver driver;
    private WebElement computersNotebooksTitle;

    public ComputersNotebooksPage(WebDriver driver){this.driver = driver;}

    public WebElement findTitle (){
        computersNotebooksTitle = driver.findElement(By.xpath("//header[@class='title-page']/h1"));
        return computersNotebooksTitle;
    }

}
