package bionicUniversityCourse.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Created by anny on 12.08.15.
 */
public class HomePage {
    private WebElement user;
    public WebDriver driver;

    public HomePage(WebDriver driver) {this.driver = driver;}

    public LoginPage openLoginPopWindow() {
        WebElement openPopUpWindowButton = driver.findElement(By.name("signin"));
        openPopUpWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                if (driver.switchTo().window(windowId).getTitle().equals("Вход в интернет-магазин")) ;
            }
        }
        return new LoginPage(driver);
    }


    public WebElement findUserName() {
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                driver.switchTo().window(windowId);
                if (driver.getCurrentUrl().equals("http://rozetka.com.ua/"));
                }
        }
        user = driver.findElement(By.name("profile"));
        return user;
    }

    public PersonalDataPage openPersonalData(){
       user.click();
        return new PersonalDataPage(driver);
    }

    public ComputersNotebooksPage openComputersNotebooks(){
        driver.findElement(By.xpath("//a[@name='fat_menu_link' and contains(text(), 'Ноутбуки, планшеты и компьютеры')]")).click();
        return new ComputersNotebooksPage(driver);
    }



}

