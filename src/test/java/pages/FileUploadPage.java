package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    // Locators
    private By fileUploadButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    // Constructor
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void navigateToFileUploadPage() {

        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String filePath) {
        driver.findElement(fileUploadButton).sendKeys(filePath);
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFileName() {

        return driver.findElement(uploadedFiles).getText();
    }
}
