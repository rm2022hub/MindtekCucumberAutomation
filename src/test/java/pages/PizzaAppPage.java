package pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaAppPage {
    public PizzaAppPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

  @FindBy (id = "pizza1Pizza")
    public WebElement pizzaDropDown;

  @FindBy(css = ".toppings1")
    public WebElement toppings1DropDown;

  @FindBy(css = ".toppings2")
    public WebElement toppings2DropDown;

    @FindBy(id = "pizza1Qty")
    public WebElement pizzaQtyBox;

    @FindBy(id = "pizza1Cost")
    public WebElement pizzaCostBox;

    @FindBy(id = "name")
    public WebElement nameBox;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "phone")
    public WebElement phoneBox;

    @FindBy(id = "cashpayment")
    public WebElement cashRadioButton;

    @FindBy(id = "placeOrder")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//p")
    public WebElement successMessage;

    @FindBy(id = "dialog")
    public WebElement dialogWindow;


}
