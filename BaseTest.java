import org.openqa.selenium.By;

public class BaseTest extends AllDriver {
    By emailField = By.id("email");
    By passField = By.id("password");
    By loginBtn = By.xpath("//button[text()='Enter your shop']");

    String emailAddress = "dainarojtest@yopmail.com";
    String password = "dainarojtest@yopmail.com";

    public void loginAccount(String email, String pass) {
        driver.get(baseUrl);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passField).sendKeys(pass);
        driver.findElement(loginBtn).click();
//        Assert.assertEquals("", "");
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
