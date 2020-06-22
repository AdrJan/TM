package pop.sorting;

import org.openqa.selenium.By;
import setup.TestBase;

public class SortingBox extends TestBase {

    public void selectSortingType(String sortingType) {
        driver.findElement(By.xpath("//div[@data-box-name = 'sorting']")).click();
        driver.findElement(By.xpath(String.format("//option[contains(text(), '%s')]", sortingType))).click();
        sleep(2000);
    }
}
