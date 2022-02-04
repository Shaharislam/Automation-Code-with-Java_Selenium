import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SubscriptionPlan extends BaseTest{
    @Test
    public void Subscriptipon(){
        loginAccount(emailAddress,password);
       driver.findElement(By.xpath("//*[text()='Administrator']")).click();
        //driver.findElement(By.xpath("//*[text()='SUBSCRIPTION']")).click();
//        WebElement testDropDown = driver.findElement(By.xpath("//*[text()='Administrator']"));
//        Select dropdown = new Select(testDropDown);
//        dropdown.selectByVisibleText("Subscription");
        driver.findElement(By.linkText("Subscription")).click();
        WebElement Plan= driver.findElement(By.linkText("Plans"));
        Plan.click();

    }
}
