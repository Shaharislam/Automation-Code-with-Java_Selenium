import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_Simple_Product extends LogIn {
    @Test()
    public void Add_Simple_Pro(){

        logIn();
        Faker faker = new Faker();
        driver.findElement(By.linkText("CATALOG")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/ul/li[3]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/div[1]/div[2]/a")).click();
        Select type = new Select(driver.findElement(By.name("type")));
        type.selectByValue("simple");
        Select attribute = new Select(driver.findElement(By.id("attribute_family_id")));
        attribute.selectByValue("573");
        driver.findElement(By.id("sku")).sendKeys(faker.name().firstName().toLowerCase());
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[1]/div[2]/button")).click();
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        //tax
        Select tax = new Select(driver.findElement(By.xpath("//select[@id='tax_category_id']")));
        tax.selectByValue("39");
        driver.findElement(By.xpath("(//span[@class='slider round'])[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[1]/div[2]/div/div[6]/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[1]/div[2]/div/div[7]/label[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[1]/div[2]/div/div[8]/label[1]")).click();
        //color
        Select color = new Select(driver.findElement(By.xpath("//select[@id='color']")));
        color.selectByValue("4671");
        //size
        Select size = new Select(driver.findElement(By.xpath("//select[@id='size']")));
        size.selectByValue("4675");
        //brand
        Select brand = new Select(driver.findElement(By.xpath("//select[@id='brand']")));
        brand.selectByValue("4697");

       // driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[1]/div[2]/div/div[12]/label[1]")).click();

        //Guest Check Out
         WebElement guest=driver.findElement(By.xpath("//label[@for='guest_checkout']"));
         guest.click();

        //description
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[2]/div[1]/div")).click();
        //sort description
        String winHandlebefor = driver.getWindowHandle();
        driver.switchTo().frame("short_description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Demo Data  Sort Description");
        driver.switchTo().window(winHandlebefor);
        //description
        driver.switchTo().frame("description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Demo Data Unlimited Description");
        driver.switchTo().window(winHandlebefor);
        //Meta
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[3]/div[1]/div")).click();
        driver.findElement(By.xpath("//textarea[@id='meta_title']")).sendKeys("Mata Data-01");
        driver.findElement(By.xpath("//textarea[@id='meta_keywords']")).sendKeys("Mata Key_Word");
        driver.findElement(By.xpath("//textarea[@id='meta_description']")).sendKeys("Meta Description-01");
        //price
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[4]/div[1]/div")).click();
        driver.findElement(By.xpath("//input[@id='price']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@id='cost']")).sendKeys("87");
        driver.findElement(By.xpath("//input[@id='special_price']")).sendKeys("95");
        //price_special//date
        driver.findElement(By.xpath("//input[@name='special_price_from']")).sendKeys("202217");
        driver.findElement(By.xpath("//input[@name='special_price_to']")).sendKeys("2022127");
        //shipping
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[5]/div[1]/div")).click();
        driver.findElement(By.name("width")).sendKeys("12");
        driver.findElement(By.name("height")).sendKeys("12");
        driver.findElement(By.name("depth")).sendKeys("12");
        driver.findElement(By.name("weight")).sendKeys("2");
        //inventory
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[6]/div[1]/div")).click();
        WebElement inventory = driver.findElement(By.name("inventories[578]"));
        inventory.clear();
        inventory.sendKeys("120");

        WebElement inventory2 =  driver.findElement(By.name("inventories[579]"));
        inventory2.clear();
        inventory2.sendKeys("120");

        //Image Upload Section
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[7]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[7]/div[2]/div/div/div/label")).click();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("G:\\Rakib SellNoir\\Random Images\\a3.jpg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("G:\\Rakib SellNoir\\Random Images\\a5.jpg");
        //categories
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[8]/div[1]/div")).click();
        driver.findElement(By.xpath("//input[@id='6533']")).click();
        driver.findElement(By.xpath("//input[@id='6537']")).click();
        driver.findElement(By.xpath("//input[@id='6536']")).click();
        driver.findElement(By.xpath("//input[@id='6538']")).click();
        //driver.findElement(By.xpath("//input[@id='254']")).click();
        //channels
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[2]/form/div[2]/div[9]/div[1]/div")).click();
        Select channel = new Select(driver.findElement(By.xpath("//select[@name='channels[]']")));
        channel.selectByValue("536");
        //link-products

        //final click to save
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
    }
}
