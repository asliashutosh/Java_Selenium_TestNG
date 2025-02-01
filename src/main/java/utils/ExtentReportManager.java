package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    // Method to initialize ExtentReports
    public static ExtentReports getInstance() {
        if (extent == null) {
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportName = "Test-Report-" + timeStamp + ".html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/" + reportName);
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }

    // Method to create a test in the report
    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }
}