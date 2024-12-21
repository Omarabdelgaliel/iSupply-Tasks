package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;
import pages.FileUploadPage;
import pages.DynamicLoadingPage;

import java.time.Duration;

public class WebGuiTests {
    public static void main(String[] args) {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Test 1: Google Search
            GoogleSearchPage googlePage = new GoogleSearchPage(driver);
            googlePage.navigateToGoogle();
            googlePage.searchFor("selenium webdriver");
            String thirdResult = googlePage.getThirdResultText();
            assert thirdResult.contains("What is Selenium WebDriver?") : "Test Failed: Third result does not match.";

            // Test 2: File Upload
            FileUploadPage fileUploadPage = new FileUploadPage(driver);
            fileUploadPage.navigateToFileUploadPage();
            fileUploadPage.uploadFile("path/to/your/test/file.txt");
            String uploadedFileName = fileUploadPage.getUploadedFileName();
            assert !uploadedFileName.isEmpty() : "Test Failed: File upload failed.";

            // Test 3: Dynamic Loading
            DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);
            dynamicLoadingPage.navigateToDynamicLoadingPage();
            dynamicLoadingPage.clickOnExample2();
            dynamicLoadingPage.clickStartButton();
            String helloWorldText = dynamicLoadingPage.getHelloWorldText();
            assert helloWorldText.equals("Hello World!") : "Test Failed: Text does not match.";

            System.out.println("All tests passed successfully!");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
