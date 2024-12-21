package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");
    private By resultText = By.xpath("(//h3)[3]");

    // Constructor
    public GoogleSearchPage(WebDriver driver) {

        this.driver = driver;
    }

    // Methods
    public void navigateToGoogle() {

        driver.get("https://www.google.com/ncr");
    }
    // search
    public void searchFor(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchButton).click();
    }

    public String getThirdResultText() {


        return driver.findElement(resultText).getText();
    }
}
