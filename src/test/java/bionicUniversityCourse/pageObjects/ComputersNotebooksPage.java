package bionicUniversityCourse.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 22.08.15.
 */
public class ComputersNotebooksPage {
    public WebDriver driver;
    private WebElement computersNotebooksTitle;

    public ComputersNotebooksPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findTitle() {
        computersNotebooksTitle = driver.findElement(By.xpath("//header[@class='title-page']/h1"));
        return computersNotebooksTitle;
    }

    public NotebooksPage verifyNumberOfNotebooksVariantsAndSelectAllNotebooksLink() {
        WebElement notebooks = driver.findElement(By.xpath("//a[@class='pab-h3-link' and contains(text(), 'Ноутбуки')]/following::ul[1]"));
        List<WebElement> listOfNotebooks = notebooks.findElements(By.tagName("li"));
        assertEquals(6, listOfNotebooks.size());

        driver.findElement(By.xpath("//span[@class='arrow-link-inner' and contains(text(), 'Все ноутбуки')]")).click();
        return new NotebooksPage(driver);
    }
}

