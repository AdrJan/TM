package pop.searching;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.TestBase;

public class SearchBar extends TestBase {

    public void typeSearchFor(String productName) {
        WebElement searchField = driver.findElement(By.xpath("//input[@type = 'search']"));
        searchField.sendKeys(productName);
    }

    public void search() {
        driver.findElement(By.xpath("//button[@data-role = 'search-button']")).click();
    }
}
