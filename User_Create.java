import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class User_Create extends LogIn {
    Faker faker = new Faker();
    String lastName = faker.name().lastName().toLowerCase();
    String Full_Name = faker.name().fullName();

    public String getRandomEmail() {
        // int random_int = (int)Math.floor(Math.random());
        String email = lastName + "@yopmail.com";
        return email;
    }

    @Test
    public void user() {
        logIn();

        WebElement businessOperation = driver.findElement(By.linkText("BUSINESS OPERATION"));
        businessOperation.click();

        WebElement user = driver.findElement(By.partialLinkText("Users"));
        user.click();

        WebElement role = driver.findElement(By.partialLinkText("Roles"));
        role.click();
        //Add Role
        WebElement add_role = driver.findElement(By.partialLinkText("Add Role"));
        add_role.click();

        //Name
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.clear();
        name.sendKeys(lastName);

        //Description
        WebElement description = driver.findElement(By.xpath("//textarea[@id='description']"));
        description.clear();
        description.sendKeys("Welcome to new Role");

        Select permission = new Select(driver.findElement(By.xpath("//select[@name='permission_type']")));
        permission.selectByValue("custom");

        WebElement dashboard_permission = driver.findElement(By.xpath("//input[@id='dashboard']"));
        dashboard_permission.click();

        WebElement catalog_edit = driver.findElement(By.xpath("//input[@id='catalog.products.edit']"));
        catalog_edit.click();

        WebElement categories_edit = driver.findElement(By.xpath("//input[@id='catalog.categories.edit']"));
        categories_edit.click();

        WebElement prpmotion_edit = driver.findElement(By.xpath("//input[@id='promotions.cart-rules.edit']"));
        prpmotion_edit.click();


        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();
        sleep(10);
        String id = driver.findElement(By.xpath("//td[@data-value='ID']")).getText();

        WebElement users = driver.findElement(By.partialLinkText("Users"));
        users.click();

        //Add User
        WebElement add_user = driver.findElement(By.partialLinkText("Add User"));
        add_user.click();

        //Name
        WebElement user_name = driver.findElement(By.xpath("//input[@id='name']"));
        user_name.clear();
        user_name.sendKeys(lastName);

        //email
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        //description.clear();
        email.sendKeys(getRandomEmail());

        //Password
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        // pass.clear();
        pass.sendKeys("123456");

        //Confirm_Password
        WebElement confirm_pass = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
        //confirm_pass.clear();
        confirm_pass.sendKeys("123456");

        //Role
        Select role_setting = new Select(driver.findElement(By.xpath("//select[@name='role_id']")));
        role_setting.selectByValue(id);
        sleep(5);

        WebElement active= driver.findElement(By.xpath("//label[@class='switch']"));
        active.click();
        WebElement submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
        submit2.submit();


    }

}
