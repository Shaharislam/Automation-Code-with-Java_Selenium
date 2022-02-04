import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Add_Parent_Categories extends LogIn{
    public String name(){
        Faker faker= new Faker();
        String fisrtName=faker.name().firstName();
        return fisrtName;
    }
    @Test
    public void Add_Categories(){

        logIn();
        WebElement Catalog = driver.findElement(By.linkText("CATALOG"));
        Catalog.click();
        //Categories
        WebElement Categories = driver.findElement(By.partialLinkText("Categories"));
        Categories.click();

        //Add Categories
        WebElement Add_Categories = driver.findElement(By.xpath("//div[@class='page-action']"));
        Add_Categories.click();

        WebElement categoriesName= driver.findElement(By.xpath("//input[@id='name']"));
        categoriesName.sendKeys(name());

        Select Status=new Select(driver.findElement(By.xpath("//select[@id='status']")));
        Status.selectByVisibleText("Yes");

        Random rand = new Random();
        int n= 1 + rand.nextInt(30);
        String value= String.valueOf(n);

        WebElement position= driver.findElement(By.xpath("//input[@id='position']"));
        position.sendKeys(value);

        Select display_mode=new Select(driver.findElement(By.xpath("//select[@id='display_mode']")));
        display_mode.selectByValue("products_and_description");
        //  Description
        String winHandlebefor = driver.getWindowHandle();
        driver.switchTo().frame("description_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Demo Data  Sort Description");
        driver.switchTo().window(winHandlebefor);

    //    Image
        driver.findElement(By.xpath("//input[@id='9' ]")).sendKeys("G:\\Rakib SellNoir\\Random Images\\a6.jpg");
        driver.findElement(By.xpath("//input[@id='11' ]")).sendKeys("G:\\Rakib SellNoir\\Random Images\\logo.jpg");

       // Parent

        driver.findElement(By.xpath("//input[@id='6533' ]")).click();

        //attribute
        Select Attribute_List= new Select(driver.findElement(By.xpath("//select[@multiple='multiple' ]")));
        List<WebElement> selectAllptions = Attribute_List.getOptions();

        for (WebElement option : selectAllptions) {
            Attribute_List.selectByVisibleText(option.getText());
        }

        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit' ]"));
        Submit.submit();


    }
}
