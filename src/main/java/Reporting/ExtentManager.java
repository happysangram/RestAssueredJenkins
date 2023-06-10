package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extentReports;
    public static ExtentReports createExtentInstance(String file, String reportName, String DocumentTitle){
            ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
//            extentSparkReporter.config().setReportName(reportName);
//            extentSparkReporter.config().setDocumentTitle(DocumentTitle);
//            extentSparkReporter.config().setTheme(Theme.DARK);
//            extentSparkReporter.config().setEncoding("utf-8");

            extentReports=new ExtentReports();
            extentReports.attachReporter(extentSparkReporter);
            return extentReports;
    }
}
