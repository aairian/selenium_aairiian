package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalDataPage;
import pages.VKLoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by anny on 09.08.15.
 */
public class RozetkaTests {
    private WebDriver driver;
    private String login = "funic89@gmail.com";
    private String password = "hayriyan89";
    private String userName = "Эмилия Деклик";
    private String personalDataText = "Личные данные";

    @BeforeTest
    public void setUp (){
        driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("http://rozetka.com.ua/", driver.getCurrentUrl());    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }


    @Test
    public void loginWithVKAccountTest () throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.openLoginPopWindow();
        VKLoginPage vkLoginPage = loginPage.openVKLoginWindow();
        HomePage user = vkLoginPage.entranceWithValidCredentials(login, password);
        assertTrue(user.findUserName().getText().contains(userName));
        PersonalDataPage myPersonalData = user.openPersonalData();
        assertTrue(myPersonalData.findTitle().getText().contains(personalDataText));

    }

//    @Test
//    public void finalTask


}
