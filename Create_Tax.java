//import com.github.javafaker.Faker;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.Test;
//
//public class Create_Tax extends AllDriver {
//
//   // Faker faker = new Faker();
//
//    @Test
//    public void logIn() {
//        driver.get("https://waltonwalcartshop.buynoir.co/admin/login");
//        driver.findElement(By.id("email")).sendKeys("walton@yopmail.com");
//        driver.findElement(By.id("password")).sendKeys("123456");
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div/div[3]/form/div[4]/button")).click();
//        //Business Operation
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[9]/a/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[9]/ul/li[6]/a")).click();
//
//        //tax Rate
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/ul/li[2]/a")).click();
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[1]/div[2]/a")).click();
//
//        driver.findElement(By.xpath("//input[@id='identifier']")).sendKeys("Bd-Tax");
//        Select country = new Select(driver.findElement(By.id("country")));
//        country.selectByValue("BD");
//        driver.findElement(By.xpath("//span[@class='slider round']")).click();
//
//        driver.findElement(By.xpath("//input[@name='zip_from']")).sendKeys("100");
//        driver.findElement(By.xpath("//input[@name='zip_to']")).sendKeys("999990");
//
//        driver.findElement(By.xpath("//input[@name='tax_rate']")).sendKeys("15");
//
//        driver.findElement(By.xpath(" //button[@type='submit']")).submit();
//
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/ul/li[1]/a")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[1]/div[2]/a")).click();
//
//        driver.findElement(By.xpath("//input[@id='code']")).sendKeys("BD-tax");
//        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("BD-Tax");
//        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("BD-tax");
//
//        Select channel = new Select(driver.findElement(By.xpath("//select[@id='taxrates']")));
//        channel.selectByValue("32");
//
//        driver.findElement(By.xpath("//button[@type='submit']")).submit();
//
//    }
//}
//

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Create_Tax extends LogIn {
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");
//    WebElement businessOperation = By.xpath("");

    @Test(description = "Create new tax and verify.")
    public void taxCreateTest() {
        logIn();
        String tax_name = new Faker().funnyName().name();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[9]/a/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[9]/ul/li[6]/a")).click();

        //tax Rate
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[1]/div[2]/a")).click();

        driver.findElement(By.xpath("//input[@id='identifier']")).sendKeys(tax_name);
        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByValue("BD");
        driver.findElement(By.xpath("//span[@class='slider round']")).click();

        driver.findElement(By.xpath("//input[@name='zip_from']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@name='zip_to']")).sendKeys("999990");

        driver.findElement(By.xpath("//input[@name='tax_rate']")).sendKeys("15");

        driver.findElement(By.xpath(" //button[@type='submit']")).submit();

        String id = driver.findElement(By.xpath("//td[@data-value='ID']")).getText();
        System.out.println(id);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]/ul/li[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[1]/div[2]/a")).click();

        driver.findElement(By.xpath("//input[@id='code']")).sendKeys(tax_name);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(tax_name);
        driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(tax_name);

        Select channel = new Select(driver.findElement(By.xpath("//select[@id='taxrates']")));
//        channel.selectByValue(id);
        channel.selectByVisibleText(tax_name);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }
}
