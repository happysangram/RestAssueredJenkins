package Filter;

import Reporting.ExtentReportManager;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext)
    {
        Response response= filterContext.next(filterableRequestSpecification,filterableResponseSpecification);

        String requestType=filterableRequestSpecification.getMethod();
//        ExtentReportManager.logInfoDetails("Info",requestType +"_APICall URI :: "+filterableRequestSpecification.getURI());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Status Code :: "+response.getStatusCode());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Status Line :: "+response.getStatusLine());
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Time In Milli Seconds :: "+response.timeIn(TimeUnit.MILLISECONDS));
//        ExtentReportManager.logInfoDetails("Info",requestType+"_APICall Response Body :: "+response.body().prettyPrint());
        ExtentReportManager.logInfoDetails("Info","Hi");
        return response;
    }
}
