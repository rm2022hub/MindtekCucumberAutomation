package pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRAppLoginPage {

   public HRAppLoginPage(){
       WebDriver driver= Driver.getDriver();
       PageFactory.initElements(driver,this);
   }
   @FindBy(name = "username")
    public WebElement username;

   @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button")
    public WebElement loginButton;


}
