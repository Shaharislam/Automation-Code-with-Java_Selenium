import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Configure_Customers extends LogIn{
    @Test
    public void Configure_Shop(){
        logIn();
        WebElement Config = driver.findElement(By.linkText("CONFIGURE"));
        Config.click();
        //Custommers
        WebElement customers = driver.findElement(By.partialLinkText("Customers"));
        customers.click();

        WebElement setting = driver.findElement(By.linkText("Settings"));
        setting.click();

        WebElement address=driver.findElement(By.xpath("//input[@type='text']"));
        address.clear();
        address.sendKeys("2");

        //Newsletter
        WebElement news_letter=driver.findElement(By.xpath("//div[text()='NewsLetter Subscription']"));
        news_letter.click();

        //Email_Verify
        WebElement email_verify=driver.findElement(By.xpath("//div[text()='Email Verification']"));
        email_verify.click();

        //Social Login
        WebElement social_login=driver.findElement(By.xpath("//div[text()='Social Login']"));
        social_login.click();
         //Toggle
        List<WebElement> toggle = driver.findElements(By.xpath("//*[@class='switch']"));
        for (int i = 0; i < toggle.size(); i++) {
            WebElement checkBtn = toggle.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
            if (!checkBtn.isSelected()){
                toggle.get(i).click();
            System.out.println("Toggle+"+i+" On Now");
        }

        }
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.submit();

    }
}
