import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Configure_Sales extends LogIn{
    @Test
    public void Configure_Shop(){
        logIn();
        //Configure
        WebElement configure = driver.findElement(By.linkText("CONFIGURE"));
        configure.click();
        //Sales
        WebElement sales = driver.findElement(By.partialLinkText("Sales"));
        sales.click();

        //Shipping
//        Select country= new Select(driver.findElement(By.xpath("//select[@id='sales[shipping][origin][country]']")));
//        country.selectByValue("BD");
//
//         WebElement state=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][state]']"));
//         state.clear();
//         state.sendKeys("Dhaka");
//
//         WebElement city=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][city]']"));
//         city.clear();
//         city.sendKeys("Dhaka");
//
//
//        WebElement street_address=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][address1]']"));
//        street_address.clear();
//        street_address.sendKeys("Dhaka,Mirpur");
//
//        WebElement zip=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][zipcode]']"));
//        zip.clear();
//        zip.sendKeys("1234");
//
//        WebElement store_name=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][store_name]']"));
//        store_name.clear();
//        store_name.sendKeys("Waltop Shop");
//
//        WebElement contact_number=driver.findElement(By.xpath("//input[@id='sales[shipping][origin][contact]']"));
//        contact_number.clear();
//        contact_number.sendKeys("098765678");
//
//        WebElement text=driver.findElement(By.xpath("//textarea[@id='sales[shipping][origin][bank_details]']"));
//        text.clear();
//        text.sendKeys("Welcome to dear customer. please visit our shop again");
//
//        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
//        Submit.submit();

          //Shipping Methods
//        WebElement shipping_methods = driver.findElement(By.linkText("Shipping Methods"));
//        shipping_methods.click();
//
//        WebElement free_shipping=driver.findElement(By.xpath("//input[@id='sales[carriers][free][title]']"));
//        free_shipping.clear();
//        free_shipping.sendKeys("Welcome to free Shipping Service");
//
//        WebElement free_drscription=driver.findElement(By.xpath("//textarea[@id='sales[carriers][free][description]']"));
//        free_drscription.clear();
//        free_drscription.sendKeys("Welcome to free Shipping Service");
//
//        //WebElement checkout= driver.findElement(By.xpath("(//span[@class='slider round'])[1]"));
//
//        WebElement status= driver.findElement(By.xpath("(//span[@class='slider round'])[1]"));
//        if (!status.isSelected()) {
//            status.click();
//        }
//        //Flat Rate Shipping
//        WebElement flat_rate_shipping = driver.findElement(By.xpath("//div[text()='Flat Rate Shipping']"));
//        flat_rate_shipping.click();
//
//        WebElement flat_shipping=driver.findElement(By.xpath("//input[@id='sales[carriers][flatrate][title]']"));
//        flat_shipping.clear();
//        flat_shipping.sendKeys("Welcome to Flat Shipping Service");
//
//        WebElement flat_drscription=driver.findElement(By.xpath("//textarea[@id='sales[carriers][flatrate][description]']"));
//        flat_drscription.clear();
//        flat_drscription.sendKeys("Welcome to Flat Shipping Service");
//
//        WebElement rate=driver.findElement(By.xpath("//input[@id='sales[carriers][flatrate][default_rate]']"));
//        rate.clear();
//        rate.sendKeys("20");
//
//        Select type=new Select(driver.findElement(By.xpath("//select[@id='sales[carriers][flatrate][type]']")));
//        type.selectByValue("per_order");
//
//
//        WebElement status2= driver.findElement(By.xpath("(//span[@class='slider round'])[2]"));
//        if (!status2.isSelected()) {
//            status2.click();
//        }
//
//        WebElement Submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
//        Submit2.submit();

        //Order Setting
        WebElement order_settings = driver.findElement(By.linkText("Order Settings"));
        order_settings.click();

        //prefix
        WebElement prefix=driver.findElement(By.xpath("//input[@id='sales[orderSettings][order_number][order_number_prefix]']"));
        prefix.clear();
        prefix.sendKeys("20");

        WebElement order_length=driver.findElement(By.xpath("//input[@id='sales[orderSettings][order_number][order_number_length]']"));
        order_length.clear();
        order_length.sendKeys("12");

        WebElement suffix=driver.findElement(By.xpath("//input[@id='sales[orderSettings][order_number][order_number_suffix]']"));
        suffix.clear();
        suffix.sendKeys("40");

        WebElement number_generator=driver.findElement(By.xpath("//input[@id='sales[orderSettings][order_number][order_number_generator-class]']"));
        number_generator.clear();
        number_generator.sendKeys("50");

        WebElement invoice= driver.findElement(By.xpath("//div[text()='Invoice Slip Design']"));
        invoice.click();
         // order logo
        WebElement logo_image = driver.findElement(By.xpath("//input[@type='file']"));
        logo_image.sendKeys("G:\\Rakib SellNoir\\Random Images\\logo.jpg");

        WebElement Submit3 = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit3.submit();

        WebElement dashboard = driver.findElement(By.linkText("DASHBOARD"));
        dashboard.click();

    }
}


