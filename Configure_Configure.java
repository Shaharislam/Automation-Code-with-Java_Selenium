import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Configure_Configure  extends LogIn{



        @Test
        public void Configure_Shop(){
            logIn();
            WebElement Config = driver.findElement(By.linkText("CONFIGURE"));
            Config.click();
            //Categories
            WebElement Configure = driver.findElement(By.partialLinkText("Configure"));
            Configure.click();

            Select Weight_Unit = new Select(driver.findElement(By.xpath("//select[@id='general[general][locale_options][weight_unit]']")));
            Weight_Unit.selectByValue("kgs");

            WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
            Submit.submit();

            //  Content
            WebElement Content = driver.findElement(By.linkText("Content"));
            Content.click();

            //Footer
            WebElement footer=driver.findElement(By.xpath("//div[text()='Footer']"));
            footer.click();

            //problem
            List<WebElement> Toggle = driver.findElements(By.xpath("//*[@class='switch']"));
            for (int i = 0; i < Toggle.size(); i++) {
                WebElement checkBtn = Toggle.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
                if (!checkBtn.isSelected())
                    Toggle.get(i).click();
              //  System.out.println("Toggle"+ i);

            }
            WebElement Submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
            Submit2.submit();
            // Design
            WebElement design = driver.findElement(By.linkText("Design"));
            design.click();

            Select Admin_color=new Select(driver.findElement(By.xpath("//select[@id='general[design][admin-theme][theme-color]']")));
            Admin_color.selectByValue("violet");

            WebElement admin_logo = driver.findElement(By.xpath("//div[text()='Admin Logo']"));
            admin_logo.click();

            // Design Image
            driver.findElement(By.xpath("//input[@id='general[design][admin_logo][logo_image]']")).sendKeys("G:\\Rakib SellNoir\\Random Images\\logo.jpg");
            driver.findElement(By.xpath("//input[@id='general[design][admin_logo][favicon]']")).sendKeys("G:\\Rakib SellNoir\\Random Images\\logo.jpg");


            WebElement Submit3 = driver.findElement(By.xpath("//button[@type='submit']"));
            Submit3.submit();

        }
    }


