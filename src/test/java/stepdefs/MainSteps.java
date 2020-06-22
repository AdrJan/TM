package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pop.products.ProductsList;
import setup.TestBase;

public class MainSteps extends TestBase {

    private final static String PAGE_URL = "https://allegro.pl";

    ProductsList productsList = new ProductsList();

    private String productName;

    @Given("user is on HomePage")
    public void user_is_on_HomePage() {
        driver.get(PAGE_URL);
        sleep(2000);
        if(driver.findElements(By.xpath("//img[@alt = 'zamknij']")).size() > 0) {
            driver.findElement(By.xpath("//img[@alt = 'zamknij']")).click();
        }
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }

    @When("user clicks on {int} promoted product")
    public void user_clicks_on_promoted_product(Integer productIndex) {
        productName = productsList.getPromotedProductName(productIndex);
        productsList.selectPromotedProduct(productIndex);
    }

    @Then("product info is correct")
    public void product_info_is_correct() {
        assertXpath(
                String.format("//h1[contains(text(), '%s')]", productName),
                "Selected product is not correct"
        );
    }
}
