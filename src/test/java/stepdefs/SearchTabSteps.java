package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pop.searching.SearchBar;
import setup.TestBase;

public class SearchTabSteps extends TestBase {

    SearchBar searchBar = new SearchBar();

    @When("user enters {string} in search field")
    public void user_enters_in_search_field(String productName) {
        searchBar.typeSearchFor(productName);
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        searchBar.search();
    }

    @Then("search result page is displayed")
    public void search_result_page_is_displayed() {
        assertXpath(
                "//div[@data-box-name = 'Items Container']",
                "Search result page is not displayed"
        );
    }
}
