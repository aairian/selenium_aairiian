package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by anny on 16.08.15.
 */
public class PersonalDataPage {
    private WebDriver driver;

    public PersonalDataPage (WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findTitle(){
        WebElement personalDataTitle = driver.findElement(By.xpath("//*[@id='personal_information']/header/h1"));
        return personalDataTitle;
    }
}
