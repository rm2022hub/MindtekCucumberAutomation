package pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRAppHomePage {

    public HRAppHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Employee ID..']")
    public WebElement searchBox;

    @FindBy(id = "searchButton")
    public WebElement searchBtn;
    @FindBy(id = "department")
    public WebElement departments;

}
