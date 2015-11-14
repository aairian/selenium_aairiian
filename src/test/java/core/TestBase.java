package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by selenium on 29.07.2015.
 */
    public class TestBase extends BrowserFactory{


    public WebDriver driver;

    protected String login = "funic89@gmail.com";
    protected String password = "*********";
    protected String userName = "Эмилия Деклик";
    protected String personalDataText = "Личные данные";
    protected String computersNotebooksTitleText = "Компьютеры и ноутбуки";
    protected String appleManufacture = "Apple";
    protected String appleNotebooksPageTitleText = "Ноутбуки Apple";
    protected String expensivefilter = "от дорогих к дешевым";
    protected String appleMacBookProRetinaZ0QP000X6 = "Apple MacBook Pro Retina 13\" (Z0QP000X6)";
    protected String appleMacBookProRetinaMGXA2UA = "Apple MacBook Pro Retina 15\" (MGXA2UA/A)";
    protected String comparisonPageHeaderText = "Сравниваем ноутбуки";

    @BeforeTest
    public void setUp (){
        driver = BrowserFactory.getBrowser("Chrome");
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("http://rozetka.com.ua/", driver.getCurrentUrl());
    }

}
