package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    /*
    Driver classindan driveri getDriver methodu ile kullaniyoruz
    Sonradan projeye katilan insanlarin Driver classindan obje olusturarak
    driver kullanmaya calismalarini engellemek icin

    Driver classini SINGLETON PATERN ile duzenleyebiliriz

    Bunun icin Driver clasiinin parametresiz constructor ini olusturup
    access modifier ini PRIVATE yapmamaiz yeterli olur
     */

    private Driver(){
    }
    static WebDriver driver;
    static ChromeOptions ops = new ChromeOptions();

    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");
        if (driver==null) {

            switch (browser) {
                case "chrome" :
                    ops.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
                    break;

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();

                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }
         //   driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        return driver;
    }
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }

}

