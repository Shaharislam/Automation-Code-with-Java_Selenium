import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageUpload {
    public class UploadImageTest extends AllDriver {
        @Test
        public void imageUploadTest() {
          //  String base_url = "http://demo.guru99.com/test/upload/";
            String expectedText = "1 file\nhas been successfully uploaded.";
            String actualText;

        //    driver.get(base_url);
            WebElement uploadField = driver.findElement(By.id("uploadfile_0"));
            WebElement termsBtn = driver.findElement(By.id("terms"));
            WebElement sendBtn = driver.findElement(By.name("send"));
            WebElement successMSG = driver.findElement(By.xpath("//h3[@id='res']"));

            uploadField.sendKeys("G:\\Rakib SellNoir\\Random Images\\a1");
            termsBtn.click();
            sendBtn.click();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            actualText = successMSG.getText();
            Assert.assertEquals(actualText, expectedText);
        }
    }
}
