
import com.github.javafaker.Faker;
        import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.testng.annotations.Test;

        import java.util.List;

public class Theme_Setting extends BaseTest {
    @Test
    public void theme_setting() {
        loginAccount(emailAddress,password);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[6]/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[6]/ul/li[1]/a")).click();
        //select
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//      //customize
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[2]/ul/li[2]/a")).click();
//        Select select = new Select(driver.findElement(By.xpath("//select[@id='theme_color']")));
//        select.selectByValue("violet");
//        //submit
//          driver.findElement(By.xpath("//button[@type='submit']")).submit();
////
//          By.id("email");
//          By.name("email");
//          By.className("");
//          By.cssSelector("input[name='email']");
//          By.linkText("Log In");
//          By.partialLinkText("Log");
//          By.tagName("input");
//          By.xpath("//input[@name='email' and @id='email']");

        List<WebElement> selectBtn = driver.findElements(By.linkText("SELECT"));
        selectBtn.get(new Faker().random().nextInt(0, selectBtn.size())).click();
        //pop-up
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.linkText("CUSTOMIZE")).click();
        sleep(5);
    }
}
