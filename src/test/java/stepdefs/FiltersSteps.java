package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import setup.TestSetup;
import utils.TextFormatter;

public class FiltersSteps extends TestSetup {

    @When("user select filters by state {string}")
    public void user_select_filters_by_state(String state) {
        String XPATH = "//div[@class = 'opbox-listing-filters']" +
                "//span[contains(text(), 'Stan')]/../..//label[contains(., '%s')]";
        driver.findElement(By.xpath(String.format(XPATH, state))).click();
        sleep(2000);
    }

    @Then("products are filtered by state {string}")
    public void products_are_filtered_by_state(String state) {
        String XPATH = "&stan=%s";
        Assert.assertTrue(
                TextFormatter.getFormattedUrl(driver.getCurrentUrl()).contains(String.format(XPATH, state)),
                "Products are not filtered - based on url"
        );
    }
}
