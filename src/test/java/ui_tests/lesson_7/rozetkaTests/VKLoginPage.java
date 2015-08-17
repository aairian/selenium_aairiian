package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by anny on 13.08.15.
 */
public class VKLoginPage {
    private WebDriver driver;
    private WebElement loginField;
    private WebElement passwordField;


    public VKLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage entranceWithValidCredentials(String login, String password) {
        loginField = driver.findElement(By.name("email"));
        loginField.sendKeys(login);
        passwordField = driver.findElement(By.name("pass"));
        passwordField.sendKeys(password);
        driver.findElement(By.id("install_allow")).click();



        {return new HomePage(driver);}


    }

    }




