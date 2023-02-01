package pages;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedShelfAppHomePage {

    public RedShelfAppHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search-catalog-navbar")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='search-page-empty__text-content mdc-typography--body1']")
    public WebElement errorMessage;


}
