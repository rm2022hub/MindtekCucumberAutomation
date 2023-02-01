package steps;

import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchResultPage;
import pages.EtsyTitlePages;
import java.util.List;
//In Cucumber, a step definition is the actual code implementation of the feature mentioned in the feature file.
public class EtsyAppSteps {

    WebDriver driver= Driver.getDriver();
 EtsyAppHomePage etsyAppHomePage=new EtsyAppHomePage();
 EtsyAppSearchResultPage etsyAppSearchResultPage=new EtsyAppSearchResultPage();
 EtsyTitlePages etsyTitlePages=new EtsyTitlePages();

    @When("user searches for {string}")
    public void user_searches_for(String item) {
     etsyAppHomePage.searchBox.sendKeys(item + Keys.ENTER);// used enter key instead of the search button.

    }

    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_contains_keyword(String keyword) {
        // getting list of all the search results for the keyword sofa,store them in a list, use foreach loop and printing.
        List<WebElement> myItemList=etsyAppSearchResultPage.listOfItemsTitles;
        for(WebElement element: myItemList){
            if(element.getText().contains(keyword)){
            System.out.println(element.getText());
            if(element.getText().contains(keyword)){
                Assert.assertTrue("Item doesn't contain sofa keyword" + element.getText(),
                        element.getText().toLowerCase().contains(keyword));

            }
        }

    }

}

    @And("user applies price filter {string} dollars")
    public void userAppliesPriceFilterOverDollars(String filterRange) {
        etsyAppSearchResultPage.filterButton.click();
        if (filterRange.equals("over 1500")) {
            etsyAppSearchResultPage.filterRadioButtonOver1500.click();
        } else if (filterRange.equals("under 250")) {
            etsyAppSearchResultPage.filterRadioButtonUnder250.click();

        } else if (filterRange.equals("250 to 750")) {
            etsyAppSearchResultPage.filterRadioButton250to750.click();

        } else if (filterRange.equals("500 to 1000")) {
            etsyAppSearchResultPage.filterRadioButton500to1000.click();
        }
        etsyAppSearchResultPage.applyButton.click();
    }
    

    @Then("user validates that item prices are {string} dollars")
    public void userValidatesThatItemPricesAreOverDollars(String filterRange) throws InterruptedException {
        if (filterRange.equals("over 1500")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultPage.listOfItemPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,999.00" --> double =2999.00
                String priceStr = element.getText().replace(",", ""); //"1920.00" getting rid of coma.
                double actualPriceDbl = Double.parseDouble(priceStr); // 1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);

                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl);  // 1920.00 >= 1500.00
            }
        } else if (filterRange.equals("under 250")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultPage.listOfItemPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,999.00" --> double =2999.00
                String priceStr = element.getText().replace(",", ""); //"1920.00" getting rid of coma.
                double actualPriceDbl = Double.parseDouble(priceStr); // 1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);

                Assert.assertTrue(actualPriceDbl < expectedPriceDbl);  // 1920.00 >= 1500.00

            }
        } else if (filterRange.equals("250 to 750")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultPage.listOfItemPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,999.00" --> double =2999.00
                String priceStr = element.getText().replace(",", "");
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1);
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);
                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl1 && actualPriceDbl <= expectedPriceDbl2);

            }
        } else if (filterRange.equals("500 to 1000")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultPage.listOfItemPrices;

            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,999.00" --> double =2999.00
                String priceStr = element.getText().replace(",", "");
                double actualPriceDbl = Double.parseDouble(priceStr);
                System.out.println(actualPriceDbl);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1);
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);
                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl1 && actualPriceDbl <= expectedPriceDbl2);

            }

        }
    }

    @When("user clicks on {string} section")
    public void user_clicks_on_section(String section) {
        if (section.equals("Jewelry & Accessories")) {
            etsyAppHomePage.jewelryAndAccessories.click();
        } else if (section.equals("Clothing & Shoes")) {
            etsyAppHomePage.clothingAndShoes.click();
        } else if (section.equals("Home & Living")) {
            etsyAppHomePage.homeAndLiving.click();
        } else if (section.equals("Wedding & Party")) {
            etsyAppHomePage.weddingAndParty.click();
        } else if (section.equals("Toys & Entertainment")) {
            etsyAppHomePage.toysAndEnt.click();
        } else if (section.equals("Art & Collectibles")) {
            etsyAppHomePage.artAndColl.click();
        }else if(section.equals("Craft Supplies")){
            etsyAppHomePage.craftAndSupp.click();
        }else if (section.equals("Gifts & Gift Cards")){
            etsyAppHomePage.giftsAndCards.click();
        }

    }


    @Then("user validates the title is {string} and the header is {string}")
    public void user_validates_the_title_is_and_the_header_is(String title, String header) {
        // creating variables and validating actual header to expected and actual title to expected title.
        String actualHeader = "";
        String actualTitle = "";
        if (header.equals("Jewelry & Accessories")){
            actualHeader = etsyTitlePages.jaHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Clothing & Shoes")){
            actualHeader = etsyTitlePages.csHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Home & Living")){
            actualHeader = etsyTitlePages.hlHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Wedding & Party")){
            actualHeader = etsyTitlePages.wpHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Toys & Entertainment")){
            actualHeader = etsyTitlePages.teHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Art & Collectibles")){
            actualHeader = etsyTitlePages.acHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Craft Supplies & Tools")){
            actualHeader = etsyTitlePages.cstHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("The Etsy Gift Guide")){
            actualHeader = etsyTitlePages.ggHeader.getText();
            actualTitle = driver.getTitle();
        }

        Assert.assertEquals(title,actualTitle);
        Assert.assertEquals(header,actualHeader);

    }

}
