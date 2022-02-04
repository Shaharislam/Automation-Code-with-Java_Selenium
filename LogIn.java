import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LogIn extends BaseTest {
        public void logIn () {
                loginAccount(emailAddress,password);

    }
}
