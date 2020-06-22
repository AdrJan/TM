package pop.products;

import org.openqa.selenium.By;
import setup.TestBase;

public class ProductsList extends TestBase {

    String XPATH = "//h2[contains(., 'Oferty promowane')]/..//article[%d]//h2/a";

    public void selectPromotedProduct(int productIndex) {
        driver.findElement(By.xpath(String.format(XPATH, productIndex))).click();
    }

    public String getPromotedProductName(int productIndex) {
        return driver.findElement(By.xpath(String.format(XPATH, productIndex))).getText();
    }
}
