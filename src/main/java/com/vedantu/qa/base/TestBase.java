package com.vedantu.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/vedantu/qa/configs/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("use-fake-device-for-media-stream");
            options.addArguments("use-fake-ui-for-media-stream");
            driver = new ChromeDriver(options);

        }

        else if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("media.navigator.streams.fake", true);
            driver = new FirefoxDriver(options);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
