import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Configure_Email extends LogIn {



        @Test
        public void Configure_Shop() {
            logIn();
            WebElement Config = driver.findElement(By.linkText("CONFIGURE"));
            Config.click();
            //Cusommers
            WebElement customers = driver.findElement(By.partialLinkText("Emails"));
            customers.click();

            WebElement setting = driver.findElement(By.linkText("Notifications"));
            setting.click();
            //Toggle
            List<WebElement> toggle = driver.findElements(By.xpath("//*[@class='switch']"));
            for (int i = 0; i < toggle.size(); i++) {
                WebElement checkBtn = toggle.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
                if (!checkBtn.isSelected()){
                    toggle.get(i).click();
               // System.out.println("Toggle+" + i + " On Now");
            }
            //System.out.println("Toggle+" + i + " Off Now");
        }
            WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
            Submit.submit();

        }
    }


