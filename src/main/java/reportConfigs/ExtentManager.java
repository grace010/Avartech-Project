package reportConfigs;

import java.io.File;

import org.openqa.selenium.Platform;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFileName = "ExtentReport.html";

    private static String extentReportPath = System.getProperty("user.dir") + File.separator + "ExtentReportV3" + File.separator + reportFileName ;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportPath);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Avartech admin report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Avartech admin report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }


}