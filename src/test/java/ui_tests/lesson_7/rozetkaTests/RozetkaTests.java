package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 09.08.15.
 */
public class RozetkaTests {
    private WebDriver driver;
//    private String login;
//    private String password;

    @BeforeTest
    public void setUp (){
        driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("http://rozetka.com.ua/", driver.getCurrentUrl());    }

//    @AfterTest
//    public void tearDown(){
//        driver.close();
//    }

    @Test
    public void loginWithVKAccountTest () throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.openLoginPopWindow();
        VKLoginPage vkLoginPage = loginPage.openVKLoginWindow();
//        vkLoginPage.entranceWithValidCredentials(login, password);
//        assertTrue(home.findUserName.getText().contains(UserName));
//        assertTrue(home.openUserSettings.getText().contains(UserName));



    }


}
