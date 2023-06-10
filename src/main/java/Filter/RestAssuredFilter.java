package Filter;

import Reporting.ExtentReport;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.concurrent.TimeUnit;

public class RestAssuredFilter implements Filter {

    private ExtentReport extentReport;

    public RestAssuredFilter() {
        extentReport =ExtentReport.getInstance();
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx)
    {
        Response response=ctx.next(requestSpec, responseSpec);

        String requestType=requestSpec.getMethod();
        if(requestType.equalsIgnoreCase("POST") || requestType.equalsIgnoreCase("PUT")) {
            extentReport.WriteLog("Info",requestType+"_APICall Request Body :: "+requestSpec.getBody());
        }
//        ExtentReportManager.logInfoDetails("Info",requestType +"_APICall URI :: "+filterableRequestSpecification.getURI());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Status Code :: "+response.getStatusCode());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Status Line :: "+response.getStatusLine());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Time In Milli Seconds :: "+response.timeIn(TimeUnit.MILLISECONDS));
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Body :: "+response.body().prettyPrint());
   //     ExtentReportManager.logInfoDetails("Info","Hi");


        extentReport.WriteLog("Info",requestType+"_APICall Response Status Code :: "+response.getStatusCode());
        extentReport.WriteLog("Info",requestType+"_APICall Response Status Line :: "+response.getStatusLine());
        extentReport.WriteLog("Info",requestType+"_APICall Response Time In Milli Seconds :: "+response.timeIn(TimeUnit.MILLISECONDS));
        extentReport.WriteLog("Info",requestType+"_APICall Response Body :: "+response.body().prettyPrint());
        return response;
    }
}
