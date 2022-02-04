import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Sales_Order_Delivery extends LogIn{

    @Test
    public void delivery(){

        logIn();
        WebElement sales = driver.findElement(By.xpath("//span[@class='icon sales-icon']"));
        sales.click();

        //Order
        WebElement order = driver.findElement(By.linkText("Orders"));
        order.click();
        List<WebElement> id = driver.findElements(By.xpath("//td[@data-value='ID']"));
        List<WebElement> pending = driver.findElements(By.xpath("//td[@data-value='Status']//span[text()='Pending']"));
        List<WebElement> processing = driver.findElements(By.xpath("//td[@data-value='Status']//span[text()='Processing']"));
        List<WebElement> action = driver.findElements(By.xpath("//td[@data-value='Actions']/div/a"));
        List<WebElement> status = driver.findElements(By.xpath("//td[@data-value='Status']"));
        String expected = "Panding";
        //For Next Page
//        Select item=new Select(driver.findElement(By.xpath("//select[@name='perPage']")));
//        item.selectByVisibleText("50");

        for (int i = 0; i < pending.size(); i++) {
          //  System.out.println("Pending Order:=" + i);
                String text= pending.get(i).getText();
               // pending.get(i).findElement(By.xpath("//td[@data-value='Actions']/div/a")).click();
                System.out.println("Order:= " + i + "     Status:= " + text);
            //action.get(i).click();

       }
        pending.get(1).findElement(By.xpath("//td[@data-value='Actions']/div/a")).click();
        WebElement productOrders=driver.findElement(By.xpath("//div[text()='Products Ordered']"));
        productOrders.click();
        WebElement write_Text=driver.findElement(By.xpath("//textarea[@id='comment']"));
        write_Text.sendKeys("Welcome to our Selnoir site");
        WebElement notify=driver.findElement(By.xpath("//input[@type='checkbox']"));
        notify.click();
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();
        sleep(2);

        WebElement invoice=driver.findElement(By.linkText("Invoice"));
        WebElement ship=driver.findElement(By.linkText("Ship"));

        if(invoice.isDisplayed()){
            invoice.click();
            WebElement save_submit=driver.findElement(By.xpath("//button[@type='submit']"));
            save_submit.submit();
        }
        if(ship.isDisplayed()){
        ship.click();

        }

    }
}
