package steps;

import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable; // part of cucumber library data table.
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;

import java.util.Map;

public class PizzaAppSteps {

   WebDriver driver= Driver.getDriver();
   PizzaAppPage pizzaAppPage= new PizzaAppPage();


    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) {

        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for(String object: data.values()){
            System.out.println(object);
        }
        // selecting value from pizza dropdown
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropDown,data.get("Pizza"));
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropDown,data.get("Topping1")); // Mushrooms
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropDown,data.get("Topping2")); // Extra Cheese
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity")); // 1
        pizzaAppPage.nameBox.sendKeys(data.get("Name")); // Patel Harsh
        pizzaAppPage.nameBox.sendKeys(data.get("Email")); // patel@gmail.com
        pizzaAppPage.nameBox.sendKeys(data.get("Phone")); // 123456789
        pizzaAppPage.cashRadioButton.click();
        pizzaAppPage.placeOrderButton.click();


    }

    @Then("user validates order is created with message {string}")
    public void user_validates_order_is_created_with_message(String expectedMessage) {
    String actualMessage=pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
// expected message is coming from feature file.