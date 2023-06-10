package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;

public class ExtentReport {

    private static ExtentReport extentReport_instance = null;
    private static ExtentReports extent;
    private ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
    public ExtentTest extTestLog;


    private ExtentReport() {
    }

    public static ExtentReport getInstance() {
        if (extentReport_instance == null)
            extentReport_instance = new ExtentReport();
        return extentReport_instance;
    }
    public void configBeforeTest() {

        String testName=ExtentReportManager.getTestNameWithTimeStamp();
        String file=System.getProperty("user.dir")+"/Reports/ExtentReporting_"+testName;
        extent=ExtentReportManager.createExtentInstance(file,"Extent Report","Reporting");

        ExtentSparkReporter extentReport = new ExtentSparkReporter(file);

        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(extentReport);
        extentReport.config().setEncoding("utf-8");
        extentReport.config().setReportName("API Automation Extent Report");
        extentReport.config().setDocumentTitle("API Automation Extent Report");
    }

    public void beforeClassReport(String testName) {
        // Parent class
        ExtentTest parentClass = extent.createTest(testName);
        parentTest.set(parentClass);
        extTestLog = parentClass;
    }

    public void setUpReport(Method method) {
        try {
            // Methods of parent class
            ExtentTest childMethod = ((ExtentTest) parentTest.get()).createNode(method.getName());
            test.set(childMethod);
            extTestLog = childMethod;

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void afterSetUpReport(Method method) {
        extent.flush();
    }

    public void WriteLog(String messageType, String logMessage) {
        if (messageType.equalsIgnoreCase("Pass")) {
            extTestLog.log(Status.PASS, logMessage);
        } else if (messageType.equalsIgnoreCase("Fail")) {
            extTestLog.log(Status.FAIL, logMessage);
        } else if (messageType.equalsIgnoreCase("Skip")) {
            extTestLog.log(Status.SKIP, logMessage);
        } else {
            extTestLog.log(Status.INFO, logMessage);
        }
    }


}
