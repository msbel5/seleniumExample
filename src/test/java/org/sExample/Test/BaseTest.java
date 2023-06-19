package org.sExample.Test;


import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.sExample.Pages.BasePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    BasePage basePage;


    @BeforeMethod
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage.setDriver(driver);
        driver.get("https://www.beymen.com/");

    }

    @Test
    public void testHomePage() {
        driver();
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        basePage.acceptCookies();
    }

    @Test
    public void chooseGender() {
        driver();
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        basePage.acceptCookies();
        basePage.chooseGender();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
