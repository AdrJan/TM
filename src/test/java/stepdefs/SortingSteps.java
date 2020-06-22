package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pop.sorting.SortingBox;
import pop.sorting.SortingType;
import setup.TestBase;

public class SortingSteps extends TestBase {

    SortingBox sortingBox = new SortingBox();

    @When("user select sorting by {string}")
    public void user_select_sorting_by(String sortedBy) {
        sortingBox.selectSortingType(sortedBy);
    }

    @Then("products are sorted by {string}")
    public void products_are_sorted_by(String sortingName) {
        String XPATH = "&order=%s";
        Assert.assertTrue(
                driver
                        .getCurrentUrl()
                        .contains(String.format(XPATH, SortingType.getSortingByName(sortingName).getUrlQuery())),
                "No query in URL. Products are not sorted."
        );
    }
}
