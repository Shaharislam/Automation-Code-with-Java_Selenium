import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Configure_Catalog extends LogIn {
    @Test
    public void Configure_Shop() {
        logIn();
        WebElement Config = driver.findElement(By.linkText("CONFIGURE"));
        Config.click();
        //Catalog
        WebElement catalog = driver.findElement(By.partialLinkText("Catalog"));
        catalog.click();
       //Inventory(page-1)
        WebElement inventory = driver.findElement(By.partialLinkText("Inventory"));
        inventory.click();
        WebElement inventoryPage = driver.findElement(By.xpath("//label[@class='switch']"));
            WebElement inventoryCheckbox = inventoryPage.findElement(By.xpath(".//input[@type='checkbox']"));
            if (!inventoryCheckbox.isSelected()) {
                inventoryPage.click();
                sleep(1);
            }
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.submit();
       //Catalog-Products(page-2)
        WebElement product = driver.findElement(By.partialLinkText("Products"));
        product.click();
        WebElement home = driver.findElement(By.xpath("//div[text()='Homepage configuration']"));
        home.click();
        WebElement allow = driver.findElement(By.xpath("//input[@id='catalog[products][homepage][no_of_new_product_homepage]']"));
        allow.clear();allow.sendKeys("50");
        WebElement allow2 = driver.findElement(By.xpath("//input[@id='catalog[products][homepage][no_of_featured_product_homepage]']"));
        allow2.clear();
        allow2.sendKeys("50");
        WebElement store = driver.findElement(By.xpath("//div[text()='Storefront']"));
        store.click();
        Select mode = new Select(driver.findElement(By.xpath("//select[@id='catalog[products][storefront][mode]']")));
        mode.selectByVisibleText("List");
        WebElement view_product_per_page = driver.findElement(By.xpath("//input[@id='catalog[products][storefront][products_per_page]']"));
        view_product_per_page.clear();
        view_product_per_page.sendKeys("10,20,30,40,50");
        Select sort = new Select(driver.findElement(By.xpath("//select[@id='catalog[products][storefront][sort_by]']")));
        sort.selectByValue("created_at-desc");
        //Social Share
        WebElement social_share = driver.findElement(By.xpath("//div[text()='Social Share']"));
        social_share.click();
        List<WebElement> catalogProducts = driver.findElements(By.xpath("//label[@class='switch']"));
        for (int i = 0; i < catalogProducts.size(); i++) {
            WebElement checkbox = catalogProducts.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
            if (i==1){
                //Review
                WebElement guest_review = driver.findElement(By.xpath("//div[text()='Review']"));
                guest_review.click();
                sleep(1);
                if (!checkbox.isSelected()) {
                    catalogProducts.get(i).click();
                    sleep(1);
                }

            }
            if(i>=2) {
                if (!checkbox.isSelected()) {
                    catalogProducts.get(i).click();
                    sleep(1);
                }
            }
        }
        WebElement message = driver.findElement(By.xpath("//input[@id='catalog[products][social_share][share_message]']"));
        message.clear();
        message.sendKeys("Welcome to Our Shop");
        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
        save.submit();
        //Rich Snippets(page-03)
        WebElement rich_snippets = driver.findElement(By.partialLinkText("Rich Snippets"));
        rich_snippets.click();
        List<WebElement> richSnippistToggle = driver.findElements(By.xpath("//label[@class='switch']"));
        for (int i = 0; i < richSnippistToggle.size(); i++) {
            WebElement checkbox = richSnippistToggle.get(i).findElement(By.xpath(".//input[@type='checkbox']"));
            if (i <= 7) {
                if (!checkbox.isSelected()) {
                    richSnippistToggle.get(i).click();
                    sleep(1);
                }
            }
            if (i == 8) {
                // Rich Snippets>>Categories
                WebElement categorie = driver.findElement(By.xpath("//div[text()='Categories']"));
                categorie.click();
                sleep(1);
            }
            if (i >= 8) {
                if (!checkbox.isSelected()) {
                    richSnippistToggle.get(i).click();
                    sleep(1);
                }
            }

        }
        WebElement Submit2 = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit2.submit();
    }
}
