import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Random;

public class Web_Header extends Add_Parent_Categories {
    Faker faker=new Faker();
    String headerName= faker.name().firstName();
    @Test
    public void wbHeader(){
        logIn();
        WebElement website = driver.findElement(By.linkText("WEBSITE"));
        website.click();

        WebElement header = driver.findElement(By.partialLinkText("Header"));
        header.click();
        //Add Content
        WebElement add_contant=driver.findElement(By.partialLinkText("Add Content"));
        add_contant.click();
        //Title
        WebElement title=driver.findElement(By.xpath("//input[@id='title']"));
        title.clear();
        title.sendKeys(headerName);
        //Possition
        Random rand = new Random();
        int n= 6 + rand.nextInt(30);
        String value= String.valueOf(n);

        WebElement position=driver.findElement(By.xpath("//input[@id='position']"));
        position.clear();
        position.sendKeys(value);

        //Content_Type
        Select content=new Select(driver.findElement(By.xpath("//select[@id='content_type']")));
        content.selectByValue("category");
        sleep(1);

        //Slug
        WebElement slug=driver.findElement(By.xpath("//input[@id='page_link']"));
        slug.sendKeys("/"+name());
        //Target Link
        Select link=new Select(driver.findElement(By.xpath("//select[@id='link_target']")));
        link.selectByValue("1");
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.submit();


    }
}
