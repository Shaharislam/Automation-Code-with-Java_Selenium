//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//
//import java.util.concurrent.TimeUnit;
//
//public class AllDriver {
//    public static WebDriver driver;
//
//    @BeforeTest
//    public void startDriver() {
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        //options.setHeadless(true);
//
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//
//    }
//
//    public static void sleep(int seconds) {
//        try {
//            Thread.sleep(2000L * seconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//   // @AfterTest
////    public void stopDriver() {
////       driver.quit();
////    }
//
//
//}
//
//

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class AllDriver {
    public static WebDriver driver;
    String baseUrl = "https://dainarojetest.sellnoir.com/admin/login";

    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void stopDriver() {
        driver.quit();
    }
}

