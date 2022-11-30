package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Driver {

    private Driver(){};

    static WebDriver driver;

    public static WebDriver  getDriver(){

        if(driver==null) {
            switch (ConfigReader.getProperties("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.close();
            driver=null;
        }
    }

    public static void closeDriver_1(){

        driver.close();
    }


    public static void quitDriver(){
        if(driver!=null) {
            driver.quit();
            driver=null;
        }
    }

    public static void quitDriver_1(){
        driver.quit();
    }

}
