
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Inventory_Setting extends BaseTest {
    Faker faker = new Faker();
    String lastName = faker.name().lastName();
    String Full_Name = faker.name().fullName();

    @Test
    public void inventory() {

        loginAccount(emailAddress, password);
        WebElement businessOperation = driver.findElement(By.linkText("BUSINESS OPERATION"));
        businessOperation.click();
        WebElement Inventory = driver.findElement(By.partialLinkText("Inventory"));
        Inventory.click();

        WebElement Add_Inventory = driver.findElement(By.linkText("Add Inventory Source"));
        Add_Inventory.click();
        WebElement Code = driver.findElement(By.xpath("//input[@id='code']"));
        Code.clear();
        Code.sendKeys(lastName);
        WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
        Name.clear();
        Name.sendKeys(Full_Name);
        WebElement Description = driver.findElement(By.xpath("//textarea[@id='description']"));
        Description.clear();
        Description.sendKeys(Full_Name);
        WebElement Priority = driver.findElement(By.xpath("//input[@id='priority']"));
        Priority.clear();
        Priority.sendKeys("5");
        WebElement Status = driver.findElement(By.xpath("//label[@for='status']"));
        Status.click();
        WebElement Contact_Name = driver.findElement(By.xpath("//input[@id='contact_name']"));
        Contact_Name.clear();
        Contact_Name.sendKeys(Full_Name);
        WebElement Email = driver.findElement(By.xpath("//input[@id='contact_email']"));
        Email.clear();
        Email.sendKeys(lastName + "@yopmail.com");
        WebElement Contact_Number = driver.findElement(By.xpath("//input[@id='contact_number']"));
        Contact_Number.clear();
        Contact_Number.sendKeys("09876543567");


        Select Country = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        Country.selectByValue("BD");

        WebElement State = driver.findElement(By.xpath("//input[@id='state']"));
        State.clear();
        State.sendKeys("Dhaka");

        WebElement City = driver.findElement(By.xpath("//input[@id='city']"));
        City.clear();
        City.sendKeys("Dhaka");

        WebElement Street = driver.findElement(By.xpath("//input[@id='street']"));
        Street.clear();
        Street.sendKeys("Dhaka");


        WebElement PostCode = driver.findElement(By.xpath("//input[@id='postcode']"));
        PostCode.clear();
        PostCode.sendKeys("1212");

        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.submit();

        WebElement MyShop = driver.findElement(By.linkText("MY SHOP"));
        MyShop.click();
        WebElement Channel = driver.findElement(By.partialLinkText("Channel"));
        Channel.click();

        Select Inventory_List= new Select(driver.findElement(By.xpath("//select[@id='inventory_sources']")));
//        Inventory_List.selectByVisibleText(Full_Name);
//        Inventory_List.selectByVisibleText("Default");
//        Inventory_List.getAllSelectedOptions().




        List<WebElement> selectAllptions = Inventory_List.getOptions();

        for (WebElement option : selectAllptions) {
            Inventory_List.selectByVisibleText(option.getText());
        }

        WebElement Submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
       Submit2.submit();

       WebElement Dashboard=driver.findElement(By.xpath("//span[text()='Dashboard']"));
       Dashboard.click();
    }
}
