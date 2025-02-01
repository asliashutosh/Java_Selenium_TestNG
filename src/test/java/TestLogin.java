import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.homePage;
import testBase.basePage;
import utils.ExtentReportManager;
import utils.ConfigReader;

public class TestLogin {

    private homePage homePage;
    private basePage basePage;

    @BeforeClass
    public void setUp() {
        // Initialize ExtentReports
        ExtentReportManager.getInstance();

        // Initialize the basePage object
        basePage = new basePage();

        // Launch the browser and navigate to the URL
        basePage.launchBrowserAndNavigate();

        // Initialize the homePage object
        homePage = new homePage();
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        // Create a test in the report
        ExtentReportManager.createTest("testLogin");

        // Enter username and password from config.properties
        homePage.sendUsername(ConfigReader.getProperty("username"));
        homePage.sendPassword(ConfigReader.getProperty("password"));

        // Click the login button
        homePage.clickLogin();

        // Verify the page title after login
        String actualTitle = homePage.getPageTitle();
        String expectedTitle = "Error!"; // Update this based on the actual title

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            // Capture screenshot and save in /screenshots
            basePage.takeScreenshot(result.getName());

            // Capture screenshot as Base64 string
            String screenshotBase64 = basePage.takeScreenshotAsBase64();

            // Attach the screenshot to the report
            ExtentReportManager.test.log(Status.FAIL, "Test failed: " + result.getThrowable(),
                    ExtentReportManager.test.addScreenCaptureFromBase64String(screenshotBase64).getModel().getMedia().get(0));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReportManager.test.log(Status.PASS, "Test passed.");
        } else {
            ExtentReportManager.test.log(Status.SKIP, "Test skipped.");
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        basePage.quitBrowser();

        // Flush the ExtentReports instance
        ExtentReportManager.extent.flush();
    }
}