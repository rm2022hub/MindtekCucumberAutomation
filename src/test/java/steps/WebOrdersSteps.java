package steps;

import Utilities.BrowserUtils;
import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderModule;

/**
 * As we have learned in the cucumber testing, feature files
 * are created with the executable test scripts.The language, in which these executable test scripts are written,is known as Gherkin language.
 * Basically, Gherkin is a plain English text language used to interpret and execute the test scripts.
 * Given-This keyword refers to the pre-condition of the test
 * When-It usually refers to the actions of a user that is to be executed.
 * Then-This keyword refers to the outcome of the previous step or upcoming action.
 * But-This keyword is used to add negative conditions.
 * And-This keyword is used to add more conditions into your steps.
 * Background-keyword is used to define the steps that are common to all tests in the feature file.
 * For example, Navigation to Home Page, Click on the Login, Enter UserName and Password,
 * Click on Submit button are the common steps in almost all web applications.
 * The keyword "Feature" represents a feature under the test in Gherkin language.
 * Feature-A feature is a functionality or standalone unit of a software application.
 * In other words, the feature is a parameter which is used to test the requirements of the customer from the software product.
 * There can be numerous features of a software product.
 * Hence, for the better management of features, we should create a separate feature file for each feature.
 * The keyword "Scenario" represents a scenario in Gherkin language.
 * One feature can have multiple scenarios, and each scenario consists of one or more steps.
 * The scenario is one of the core structures of the Gherkin language. Scenario includes all the possible circumstances of the feature
 * and test scripts for these circumstances.
 */
public class WebOrdersSteps {

    WebDriver driver= Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage=new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage=new WebOrdersHomePage();
    WebOrdersOrderModule webOrdersOrderModule=new WebOrdersOrderModule();


    @When("user enters username {string} and password {string} and clicks on login button")
    public void user_enters_username_and_password_and_clicks_on_login_button(String username, String password) {
        webOrdersLoginPage.username.sendKeys(username);
        webOrdersLoginPage.password.sendKeys(password);
        webOrdersLoginPage.loginBtn.click();

    }
    @Then("user validates application is logged in")
    public void user_validates_application_is_logged_in() {

    String expectedTitle= "Web Orders";
    String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);// opposite of testNG(actualTitle,expectedTitle)

    }

    @Then("user validates an error message {string}")
    public void userValidatesAnErrorMessage(String errorMessage) {
        String expectedErrorMessage="Invalid Login or Password.";
        String actualErrorMessage=webOrdersLoginPage.errorMessage.getText();
        Assert.assertEquals(errorMessage,actualErrorMessage);

    }
    @When("user clicks on Order module")
    public void user_clicks_on_order_module() {
    webOrdersHomePage.orderModule.click();
    }

    @When("user selects {string} with {int}")
    public void user_selects_with_quantity(String product, int quantity) {
        BrowserUtils.selectDropdownByValue(webOrdersOrderModule.productDropdown,product);
        webOrdersOrderModule.quantityBox.sendKeys(Keys.CONTROL+"A");
        webOrdersOrderModule.quantityBox.sendKeys(Keys.BACK_SPACE);
        webOrdersOrderModule.quantityBox.sendKeys(quantity+""+Keys.ENTER);


    }
    @Then("user validates total is calculated properly for {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(int quantity) {
     int expectedTotal=0;
     String pricePerUnit= webOrdersOrderModule.priceBox.getAttribute("value");  // "80"
     String discountAmount= webOrdersOrderModule.discountBox.getAttribute("value"); // "0"
        // quantity < 10 = no discount, discount =0
      int pricePerUnitInt = Integer.parseInt(pricePerUnit);
      int discountAmountInt = Integer.parseInt(discountAmount);

      if(discountAmountInt==0){
          expectedTotal = quantity * pricePerUnitInt;
      }else{
          expectedTotal = quantity* pricePerUnitInt;
          expectedTotal = expectedTotal -expectedTotal * discountAmountInt/100; // calculating the discount and minus from total.

      }
        System.out.println(expectedTotal);
       String actualTotal =webOrdersOrderModule.totalBox.getAttribute("value");
       int actualTotalInt = Integer.parseInt(actualTotal);
       Assert.assertEquals(expectedTotal,actualTotalInt);

    }


}
