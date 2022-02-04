import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class attribute extends LogIn{
   @Test
       public void attribute_test() {
       driver.get("https://duckduckgo.com/");

       WebElement searchTextBox = driver.findElement(By.id("search_form_input_homepage"));

// retrieving html attribute value using getAttribute() method
       String typeValue = searchTextBox.getAttribute("value");
       System.out.println("Value of type attribute: " + typeValue);

       String autocompleteValue = searchTextBox.getAttribute("type");
       System.out.println("Value of autocomplete attribute: " + autocompleteValue);

// Retrieving value of attribute which does not exist
       String nonExistingAttributeValue = searchTextBox.getAttribute("nonExistingAttribute");
       System.out.println("Value of nonExistingAttribute attribute: " + nonExistingAttributeValue);

       String page = driver.getPageSource();
       // System.out.println("Page Source:= "+page);
       String url = driver.getCurrentUrl();
       System.out.println("Page URL:= " + url);
       String parent = driver.getWindowHandle();

       Set<String> s = driver.getWindowHandles();

// Now iterate using Iterator
       Iterator<String> I1 = s.iterator();

       while (I1.hasNext()) {

           String child_window = I1.next();


           if (!parent.equals(child_window)) {
               driver.switchTo().window(child_window);

               System.out.println(driver.switchTo().window(child_window).getTitle());

               // driver.close();
           }

       }
//switch to the parent window
//       driver.switchTo().window(parent);
//        }
   }
   }
