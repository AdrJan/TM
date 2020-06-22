package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import setup.TestSetup;

public class SortingSteps extends TestSetup {

    @When("user select sorting by {string}")
    public void user_select_sorting_by(String sortedBy) {
        driver.findElement(By.xpath("//div[@data-box-name = 'sorting']")).click();
        driver.findElement(By.xpath(String.format("//option[contains(text(), '%s')]", sortedBy))).click();
        sleep(2000);
    }

    @Then("products are sorted by {string}")
    public void products_are_sorted_by(String sortingName) {
        String XPATH = "&order=%s";
        Assert.assertTrue(
                driver.getCurrentUrl().contains(
                        String.format(XPATH, SORTING_TYPE.getSortingByName(sortingName).urlQuery)
                ),
                "No query in URL. Products are not sorted."
        );
    }
}

enum SORTING_TYPE {
    PRICE_DEC("cena: od najwyższej", "pd"),
    NONE("brak", "");

    String urlQuery;
    String sortingName;

    SORTING_TYPE(String sortingName, String urlQuery) {
        this.urlQuery = urlQuery;
        this.sortingName = sortingName;
    }

    static SORTING_TYPE getSortingByName(String sortingName) {
        for(SORTING_TYPE sorting_type : SORTING_TYPE.values()) {
            if(sorting_type.sortingName.equals(sortingName))
                return sorting_type;
        }
        return NONE;
    }
}
