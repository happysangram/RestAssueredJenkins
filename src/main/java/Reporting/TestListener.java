package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports;
    static ThreadLocal<ExtentTest> extentTestThreadLocal=new ThreadLocal<>();


    public void onStart(ITestContext context) {

        System.out.println("---------------------------------------------------------");
        String testName=ExtentReportManager.getTestNameWithTimeStamp();
        String file=System.getProperty("user.dir")+"/Reports/ExtentReporting_"+testName;
        extentReports=ExtentReportManager.createExtentInstance(file,"Extent Report","Reporting");
    }

    public void onFinish(ITestContext context) {

    }

    public void onTestStart(ITestResult result) {
        ExtentTest test= extentReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        if(extentReports!=null){

            ExtentReportManager.logPassDetails("Info","Bye");
            extentReports.flush();
        }


    }



}
