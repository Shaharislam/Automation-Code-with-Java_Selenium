import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Web_Slider extends LogIn {

    Faker faker=new Faker();
    String fullName= faker.name().fullName();
    @Test
    public void slider(){
        logIn();
        WebElement website = driver.findElement(By.linkText("WEBSITE"));
        website.click();

        WebElement slide = driver.findElement(By.partialLinkText("Sliders"));
        slide.click();
        //Create Slider
        WebElement create_slide = driver.findElement(By.partialLinkText("Create Slider"));
        create_slide.click();

        WebElement name=driver.findElement(By.xpath("//input[@name='title']"));
        name.clear();
        name.sendKeys(fullName);
        //Image
        WebElement image = driver.findElement(By.xpath("//input[@type='file']"));
        //image.click();
        image.sendKeys("G:\\Rakib SellNoir\\Random Images\\a7.jpg");

        String winHandlebefor = driver.getWindowHandle();
        driver.switchTo().frame("tiny_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Demo Data  Sort Description");
        driver.switchTo().window(winHandlebefor);
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();

    }

}
