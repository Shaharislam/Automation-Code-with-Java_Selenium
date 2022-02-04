
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateAccount extends AllDriver {

    Faker faker = new Faker();
    //String name = faker.country().name();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    public String getRandomEmail(int i) {
        // int random_int = (int)Math.floor(Math.random());
        String email = lastName + i + "@yopmail.com";
        return email;
    }

    @Test
    public void accountCreate() {


        for (int i = 0; i <=20; i++) {
            driver.get("https://buynoir.co/en");
            //driver.get("https://buynoir.co/company/register");
            if (driver.findElement(By.xpath("/html/body/div[1]/div/a")).isDisplayed() == true) {
                driver.findElement(By.xpath("/html/body/div[1]/div/a")).click();

            }
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div/nav/div/ul/li[1]/a")).click();
            driver.findElement(By.name("email")).sendKeys(getRandomEmail(i));
            driver.findElement(By.name("password")).sendKeys("123456");
            driver.findElement(By.name("password_confirmation")).sendKeys("123456");
            driver.findElement(By.xpath("//*[@id=\"buynoir-shop-registration\"]/div[2]/form[1]/div[4]/button")).click();

            driver.findElement(By.name("first_name")).sendKeys(faker.name().firstName());
            driver.findElement(By.name("last_name")).sendKeys(faker.name().firstName());
            driver.findElement(By.name("phone_no")).sendKeys("87654345678");
            driver.findElement(By.xpath("//*[@id=\"buynoir-shop-registration\"]/div[2]/form[1]/div/div[4]/button")).click();

            driver.findElement(By.name("username")).sendKeys(faker.name().firstName() + " Shop");

            Select what = new Select(driver.findElement(By.name("productcategory")));
            what.selectByValue("Clothing");
            driver.findElement(By.id("elsebusinessMoving")).click();
            driver.findElement(By.xpath("//*[@id=\"buynoir-shop-registration\"]/div[2]/form[2]/div/div[4]/button")).click();

        }
    }
}
