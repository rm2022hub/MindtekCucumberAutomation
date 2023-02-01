package steps;

import Utilities.BrowserUtils;
import Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable; // part of cucumber library data table.
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.PizzaAppPage;

import java.util.Map;

public class PizzaAppSteps {
    String costValue;

   WebDriver driver= Driver.getDriver();  // got the driver from driver utility class
   PizzaAppPage pizzaAppPage= new PizzaAppPage();  // created an object of the page to access all the web elements.
    // step gor given user navigates to pizza app is in the hooks class.


    @When("user creates pizza order with data")
    public void user_creates_pizza_order_with_data(DataTable dataTable) throws InterruptedException {

        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        // converting data table to Map and looping through to get the values
        // all the keys are in String form. Values are in object form.(Object can take any type of data)
        // interface is a contract
        Map<String,String> data = dataTable.asMap(String.class,String.class);
        for(String value: data.values()){
            System.out.println(value); // prints all the values. If you put in data.keySet then it prints all the keys.
        }

        // selecting value from pizza dropdown(have selecting drop down methods in browser utils class)
        BrowserUtils.selectDropdownByValue(pizzaAppPage.pizzaDropDown,data.get("Pizza"));  // passing the key Pizza to get value.
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings1DropDown,data.get("Topping1")); // "Mushrooms"
        BrowserUtils.selectDropdownByValue(pizzaAppPage.toppings2DropDown,data.get("Topping2")); // "Extra Cheese"
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.CONTROL+"A"); // clearing the quantity box by sending keys.
        pizzaAppPage.pizzaQtyBox.sendKeys(Keys.BACK_SPACE);
        pizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity")); // "1"
        pizzaAppPage.nameBox.sendKeys(data.get("Name")); // 'Patel Harsh'
        pizzaAppPage.emailBox.sendKeys(data.get("Email")); // "patel@gmail.com"
        pizzaAppPage.phoneBox.sendKeys(data.get("Phone")); // "123456789"
        costValue = pizzaAppPage.pizzaCostBox.getAttribute("value"); // string costValue = "6.75"
        if(data.get("Payment").equals("Cash on Pickup")){
            pizzaAppPage.cashRadioButton.click();
        }else{
            pizzaAppPage.creditCardRadioButton.click();
        }
        pizzaAppPage.placeOrderButton.click();

    }

    @Then("user validates that order is created with message {string} {string} {string}")
    public void userValidatesThatOrderIsCreatedWithMessage(String success, String quantity, String pizza) {
        String expectedMessage= success+costValue+" "+pizza;
        String actualMessage=pizzaAppPage.dialogWindow.getText();
        System.out.println(actualMessage);//Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
// expected message is coming from feature file. It is a variable we named.
// actual message if from the web element text.