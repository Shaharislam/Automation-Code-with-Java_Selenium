import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Web_Footer extends LogIn{
    @Test
    public void web_Footer(){
        logIn();
        WebElement website = driver.findElement(By.linkText("WEBSITE"));
        website.click();

        WebElement footer = driver.findElement(By.partialLinkText("Footer"));
        footer.click();

        String winHandlebefor = driver.getWindowHandle();
        driver.switchTo().frame("subscription_bar_content_ifr");
        driver.findElement(By.id("tinymce")).sendKeys("Demo Data  Sort Description");
        driver.switchTo().window(winHandlebefor);

        driver.switchTo().frame("footer_left_content_ifr");
        WebElement description=driver.findElement(By.id("tinymce"));
        description.clear();
        description.sendKeys("Demo Data  Sort Description");
        driver.switchTo().window(winHandlebefor);
         //Add Image

//        WebElement addImage=driver.findElement(By.partialLinkText("Add Image"));
//        addImage.click();

        WebElement uploadImage = driver.findElement(By.xpath("//input[@type='file']"));
        uploadImage.sendKeys("G:\\Rakib SellNoir\\Random Images\\a6.jpg");
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();

        WebElement dashboard=driver.findElement(By.linkText("DASHBOARD"));
        dashboard.click();

    }
}
