package steps;

import Utilities.ConfigReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Hooks can be defined only in the step definition file.
 * In Cucumber, the hook is the block of code which can be defined with each scenario in step definition file
 * by using the annotation @Before and @After.
 * These @Before and @After annotations create a block in which we can write the code.
 *
 * Consider the following prerequisite to understand the kind of prerequisites which may encounter at the time of testing:
 * To Start a web driver
 * Set up of Data Base connections
 * Set up of test data
 * Set up of browser cookies
 * Navigation to a certain page
 *
 * Similarly, there are always some prerequisite steps which may encounter after testing:
 * To stop the web driver
 * To Close DB connections
 * To Clear the test data
 * To Clear browser cookies
 * To Log out from the application
 * Printing reports or logs
 * Taking the screenshots of error
 * Tagged Hooks
 * @ Before ('@RegressionTest, @SmokeTest)
 * @ After ('@RegressionTest, @SmokeTest)
 */

public class Hooks {

   WebDriver driver= Driver.getDriver();
   @Given("user navigates to {string} application")
   public void user_navigates_to_web_orders_application(String webAPP) {
      if(webAPP.equals("WebOrders")) {
         driver.get(ConfigReader.getProperty("WebOrdersURL"));
      } else if (webAPP.equals("Etsy")) {
         driver.get(ConfigReader.getProperty("EtsyAppURL"));
      } else if (webAPP.equals("PizzaApp")) {
         driver.get(ConfigReader.getProperty("PizzaAppURL"));

      }
   }


   @Before
    public  void setUp(){
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().deleteAllCookies();
       System.out.println("Method runs before scenario");

   }
   @After
    public void tearDown(){
       driver.quit();
       System.out.println("Method runs after scenario");
   }

}
