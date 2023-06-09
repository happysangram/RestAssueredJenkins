package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

    public static ExtentReports extentReports;
    private static ExtentReportManager extentReport_instance;

    public static ExtentReportManager getInstance() {
        if (extentReport_instance == null)
            extentReport_instance = new ExtentReportManager();
        return extentReport_instance;
    }

    public static ExtentReports createExtentInstance(String file, String reportName, String DocumentTitle){
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(file);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(DocumentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getTestNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime localDateTime=LocalDateTime.now();
        String timeStamp=dateTimeFormatter.format(localDateTime);
        String TestName="Test_Report_"+timeStamp+".html";
        return TestName;
    }

    public static void logPassDetails(String log,String s){
        TestListener.extentTestThreadLocal.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailDetails(String log){
        TestListener.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(log,ExtentColor.WHITE));
       // TestListener.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfoDetails(String log){
        TestListener.extentTestThreadLocal.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log,String s){
        TestListener.extentTestThreadLocal.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
    public static void logSkipDetails(String log,String s){
        TestListener.extentTestThreadLocal.get().skip(MarkupHelper.createLabel(log, ExtentColor.BLUE));
    }
    public static void logJsonDetails(String json){
        TestListener.extentTestThreadLocal.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logHeaderDetails(List<Header> headerList){

        String[][] sample=headerList.stream().map(header -> new String[] {header.getName(),header.getValue()}).toArray(String[][]::new);
       // Object[][] sample1=headerList.stream().map(header -> new String[] {header.getName(),header.getValue()}).toArray((v1,v2)->new String[][]);

        TestListener.extentTestThreadLocal.get().info(MarkupHelper.createTable(sample));
    }
}
