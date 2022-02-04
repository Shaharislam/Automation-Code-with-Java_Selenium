import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PopUp extends AllDriver {
    @Test
    public void Popup(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sellnoir.com/en");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("rootnext");
        alert.accept();
    }
}
