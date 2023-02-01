package steps;

import Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.RedShelfAppHomePage;

public class RedShelfAppSteps {

    WebDriver driver= Driver.getDriver();
    RedShelfAppHomePage redShelfAppHomePage= new RedShelfAppHomePage();

    @When("user searches {string} book")
    public void userSearchesBook(String text) {
        redShelfAppHomePage.searchBox.sendKeys(text + Keys.ENTER);
    }

    @Then("user validates {string} error message.")
    public void userValidatesErrorMessage(String expectedErrorMessage) {
        String actualMessage= "Check your spelling or try a different search.";
        Assert.assertEquals(expectedErrorMessage,actualMessage);
    }
    @When("user searches for book name that has more than {int} characters")
    public void user_searches_for_book_name_that_has_more_than_characters(Integer num) throws InterruptedException {
        String str ="a";
        String repeated = str.repeat(num+1); // 100000
        redShelfAppHomePage.searchBox.sendKeys(repeated);
        Thread.sleep(2000);

    }

    @Then("user validates that search box doesn't accept more than {int} characters.")
    public void user_validates_that_search_box_doesn_t_accept_more_than_characters(Integer num) {


    }

}
