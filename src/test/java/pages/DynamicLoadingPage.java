package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;

    // Locators
    private By example2Link = By.linkText("Example 2: Element rendered after the fact");
    private By startButton = By.cssSelector("#start button");
    private By helloWorldText = By.id("finish");

    // Constructor
    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void navigateToDynamicLoadingPage() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
    }

    public void clickOnExample2() {

        driver.findElement(example2Link).click();
    }

    public void clickStartButton() {

        driver.findElement(startButton).click();
    }

    public String getHelloWorldText() {

        return driver.findElement(helloWorldText).getText();
    }
}
