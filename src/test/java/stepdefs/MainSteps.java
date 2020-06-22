package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import setup.TestSetup;

public class MainSteps extends TestSetup {

    private final static String PAGE_URL = "https://allegro.pl";

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
        String XPATH = "//h2[contains(., 'Oferty promowane')]/..//article[%d]//h2/a";

        WebElement webElement = driver.findElement(By.xpath(String.format(XPATH, productIndex)));
        productName = webElement.getText();
        webElement.click();
    }

    @Then("product info is correct")
    public void product_info_is_correct() {
        Assert.assertTrue(
                driver.findElements(By.xpath(String.format("//h1[contains(text(), '%s')]", productName))).size() > 0,
                "Selected product is not correct"
        );
    }
}
