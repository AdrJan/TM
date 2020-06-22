package pop.filtering;

import org.openqa.selenium.By;
import setup.TestBase;

public class FilteringBox extends TestBase {

    public void selectState(String state) {
        String XPATH = "//div[@class = 'opbox-listing-filters']" +
                "//span[contains(text(), 'Stan')]/../..//label[contains(., '%s')]";
        driver.findElement(By.xpath(String.format(XPATH, state))).click();
        sleep(2000);
    }
}
