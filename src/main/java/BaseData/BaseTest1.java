package BaseData;

import Filter.RestAssuredFilter;
import Reporting.ExtentReport;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest1 {

    public static RestAssuredFilter restAssuredFilter;
    protected ExtentReport report;

    public BaseTest1(){
        report = ExtentReport.getInstance();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        restAssuredFilter=new RestAssuredFilter();
    }
    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite(){
        report.configBeforeTest();
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClassConfig() {
        String testName = this.getClass().getSimpleName();
        report.beforeClassReport(testName);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        report.setUpReport(method);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        report.afterSetUpReport(method);
    }

}
