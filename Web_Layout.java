import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Web_Layout extends LogIn {
    public static final String ROOT_DIR=System.getProperty("user.dir");
    public static final String IMAGE_DIR=ROOT_DIR+ File.separator+"All_Image";
    public static List<String> imageList = new ArrayList<>();

    @Test
    public void wbLayout() {
        logIn();
        WebElement website = driver.findElement(By.linkText("WEBSITE"));
        website.click();

        //Layout
        WebElement layout = driver.findElement(By.partialLinkText("Layout"));
        layout.click();
        WebElement toggle = driver.findElement(By.xpath("//*[@class='switch']"));
        WebElement activeSlider = toggle.findElement(By.xpath(".//input[@type='checkbox']"));
        if (!activeSlider.isSelected()){
            toggle.click();
            System.out.println("Toggle On Now");
        }

        WebElement sideBar=driver.findElement(By.xpath("//input[@id='sidebar_category_count']"));
        sideBar.clear();
        sideBar.sendKeys("20");
        //Header
        WebElement headeNumber=driver.findElement(By.xpath("//input[@id='header_content_count']"));
        headeNumber.clear();
        headeNumber.sendKeys("30");
        //New Product
        WebElement newProduct=driver.findElement(By.xpath("//input[@id='new_products_count']"));
        newProduct.clear();
        newProduct.sendKeys("30");

        //Image
        WebElement image = driver.findElement(By.xpath("//div[text()='Images']"));
        image.click();
        List<WebElement> removeImage = driver.findElements(By.xpath("//label[@class='remove-image']"));
        List<WebElement> first3Image = driver.findElements(By.xpath("//label[@class='btn btn-lg btn-primary'] "));
        //Remove Image
        for (int i = 0; i < removeImage.size(); i++) {
            removeImage.get(i).click();
            //sleep(1);
        }
       //Add Image
        for (int j = 0; j < 3; j++) {
            if (j == 0) {
                for (int i = 0; i < 3; i++) {
                    first3Image.get(0).click();
                }
                sleep(1);
            }
            if (j == 1) {
                for (int i = 0; i < 3; i++) {
                    first3Image.get(1).click();
                }
                sleep(1);
            }
            if (j == 2) {
                for (int i = 0; i < 3; i++) {
                    first3Image.get(2).click();
                }
                sleep(1);
            }

        }
        //Upload Image
//
        for (File name: Objects.requireNonNull(new File(IMAGE_DIR).listFiles())){
            imageList.add(IMAGE_DIR+File.separator+name.getName());
        }
       List<WebElement> image_Upload= driver.findElements(By.xpath("//input[@type='file']"));
        for (int i=0;i<9;i++){
            String image_Path = imageList.get(new Faker().random().nextInt(0, imageList.size())-1);
            image_Upload.get(i).sendKeys(image_Path);
        }
        //Random Image Upload Faizul
//        for (File name : Objects.requireNonNull(new File(IMAGE_DIR).listFiles())) {
////            imageList.add(IMAGE_DIR + File.separator + name.getName());
////           // System.out.println(imageList);
////        }
//       // for (int i = 0; i < imageList.size(); i++) {
//            List<WebElement> imageUpload1 = driver.findElements(By.xpath("//input[@type='file']"));
//            for (int i = 0; i <9; i++) {
//            String imagePath = imageList.get(new Faker().random().nextInt(0, imageList.size() - 1));
//             System.out.println(imagePath);
//            imageUpload1.get(i).sendKeys(imagePath);
 //       }
//        //Upload Image Own policy
//        List<WebElement> imageUpload1 = driver.findElements(By.xpath("//input[@type='file']"));
//        for (int i = 0; i <imageUpload1.size() ; i++) {
//            imageUpload1.get(i).sendKeys(System.getProperty("user.dir")+"\\All_Image\\a"+i+".jpg");
//        }
         //System.getProperty("user.dir");
        //Update Meta Data
        WebElement upDateMetaData=driver.findElement(By.xpath("//button[@type='submit']"));
        upDateMetaData.submit();

        WebElement dashBoard=driver.findElement(By.linkText("DASHBOARD"));
        dashBoard.click();

    }
}
