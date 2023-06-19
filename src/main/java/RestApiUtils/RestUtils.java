package RestApiUtils;

import BaseData.BaseTest1;
import Reporting.ExtentReportManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

public class RestUtils extends BaseTest1 {

    static Response response;

    public static Response POST(String endpoint,String basepath, Object payload, Map<String,Object> header){

         response= RestAssured.given()
                .spec(RestSpecifications.requestSpecification(payload,header))
                .basePath(basepath)
                .filters(BaseTest1.restAssuredFilter)
                .when()
                .post(endpoint)
                .then()
                .spec(RestSpecifications.responseSpecification())
                .log().all()
                .extract().response();

        printRequestSpecification(RestSpecifications.requestSpecification(payload,header));
        printResponseSpecification();
        return  response;
    }

    private static void printRequestSpecification(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("BaseURI is :" + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Header is :" );
        ExtentReportManager.logHeaderDetails(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Resquest body is :" );
        ExtentReportManager.logJsonDetails(queryableRequestSpecification.getBody());
    }
    private static void printResponseSpecification(){

        ExtentReportManager.logInfoDetails("Header is :" );
        ExtentReportManager.logHeaderDetails(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Status code is :" + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response body is :" + response.getBody().prettyPrint());
        ExtentReportManager.logInfoDetails("Response message is :" + response.getStatusLine());
    }



}
