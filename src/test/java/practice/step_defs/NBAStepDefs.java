package practice.step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import practice.pages.NBABasePage;
import practice.utilities.ConfigurationReader;
import practice.utilities.Driver;

import java.util.List;

public class NBAStepDefs {

    NBABasePage nbaBasePage = new NBABasePage();

    @Given("user is on NBA page")
    public void user_is_on_nba_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("nba.url"));
    }



    @Then("user validates these items")
    public void user_validates_these_items(List<String> navigationItems) {
        System.out.println(navigationItems);
        nbaBasePage.getNavItems();

    }
}
