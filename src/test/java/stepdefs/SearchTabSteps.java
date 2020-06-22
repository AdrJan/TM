package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import setup.TestSetup;

public class SearchTabSteps extends TestSetup {

    @When("user enters {string} in search field")
    public void user_enters_in_search_field(String string) {
        WebElement searchField = driver.findElement(By.xpath("//input[@type = 'search']"));
        searchField.sendKeys(string);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.xpath("//button[@data-role = 'search-button']")).click();
    }

    @Then("search result page is displayed")
    public void search_result_page_is_displayed() {
        Assert.assertTrue(
                driver.findElements(By.xpath("//div[@data-box-name = 'Items Container']")).size() > 0,
                "Result page is not displayed"
        );
    }
}
