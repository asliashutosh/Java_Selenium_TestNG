package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class basePage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    // Method to launch the browser and navigate to the URL
    public void launchBrowserAndNavigate() {
        // Use WebDriverManager to set up the ChromeDriver
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the URL from config.properties
        driver.get(ConfigReader.getProperty("url"));

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("timeout"))));
    }

    // Method to capture screenshot
//    public void takeScreenshot(String fileName) {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile, new File("screenshots/" + fileName + ".png"));
//            System.out.println("Screenshot saved: " + fileName + ".png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    // Method to capture screenshot and return file path
    public String takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "screenshots/" + fileName + ".png";  // Save inside test-output

        try {
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;  // Return file path
    }

    // Method to capture screenshot as Base64 string
    public String takeScreenshotAsBase64() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }


    // Method to close the browser
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}