package RestAPIs;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Properties;

public class Specifications extends BaseTest {


    public static RequestSpecification requestSpec(){
        RequestSpecification requestSpecification;
        return requestSpecification =RestAssured
                .given()
                .baseUri(properties.getProperty("BaseUrl"))
                .basePath(BasePath.maxpanel)
                .contentType(ContentType.JSON)
                .filter(restAssuredFilter)
                .log().all();
    }
    public static ResponseSpecification responseSpec(){
        ResponseSpecification responseSpecification;
        return responseSpecification =new ResponseSpecBuilder()
                .expectStatusCode(StatusCode.OK)
                .expectContentType(ContentType.JSON)
                .expectStatusLine(Constants.statusLine)
                .build();
    }
}
