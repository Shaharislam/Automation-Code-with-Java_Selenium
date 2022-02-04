import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Sales_Order extends LogIn {

    @Test
    public void salesOrder() {
        logIn();
        //
        // WebElement sales = driver.findElement(By.linkText("SALES"));
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

        for (int i = 0; i < id.size(); i++) {
            System.out.println("Pending Order:=" + i);
            String text = id.get(i).getText();
            String st = status.get(i).getText();
            System.out.println("Order:= " + i + "  ID:= " + text + "     Status:= " + st);
             //action.get(i).click();
        }
//        //paging
//        WebElement rightButton = driver.findElement(By.xpath("//i[@class='icon angle-right-icon']"));
//        List<WebElement> nextPage = driver.findElements(By.xpath("//a[@class='page-item as']"));
//        List<WebElement> pageNumber = driver.findElements(By.xpath("//a[@class='page-item as']"));
//        WebElement next=driver.findElement(By.xpath("//a[@id='next']"));
//        //WebElement cross=driver.findElement(By.xpath("//div[@class='filtered-tags']//span[@class='icon cross-icon']"));
//        System.out.println("NextPage_Size:= " + nextPage.size());
//        System.out.println("PageNumber_Size:= " + pageNumber.size());
//

        List<WebElement> page = driver.findElements(By.xpath("//div[@class='pagination shop mt-50']/a[@class='page-item as']"));

//        WebElement active2 = driver.findElement(By.xpath("//div[@class='pagination shop mt-50']/a[@class='page-item active']"));
//        System.out.println("Second_Active:= "+active2.getText());

//        for (int i = number+1; i <=2; i++) {
//            sleep(1);
//            page.get(i).click();
//            System.out.println("Click_Page_Number:= " + i);
//            sleep(20);
//            for (int j = 0; j < id.size(); j++) {
//            //System.out.println("Pending Order:=" + i);
//            // pending.get(i).findElement(By.xpath("//td[@data-value='Actions']/div/a")).click();
//            // action.get(i).click();
//            //sleep(1);
//            String text = id.get(j).getText();
//            String st = status.get(j).getText();
//            System.out.println("Order:= " + j + "  ID:= " + text + "     Status:= " + st);
//            // action.get(i).click();
//            // break;
////                action.get(i).click();
////                System.out.println("Action:= "+ action +"Pending:= "+ pending);


//        }
//        }

        WebElement next_Id=driver.findElement(By.xpath("//a[@id='next']"));
        //List<WebElement> link=driver.findElements(By.linkText());
        for (int i = 0; i <3; i++) {
            driver.findElement(By.xpath("//a[@id='next']")).click();
            sleep(2);
        }
        for (int i = 3; i >0; i--) {
            driver.findElement(By.xpath("//a[@id='previous']")).click();
            sleep(2);
        }
    }

}

