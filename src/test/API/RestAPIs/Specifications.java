package RestAPIs;

import Base1.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications extends BaseTest {


    public static RequestSpecification requestSpec(){
        RequestSpecification requestSpecification;
        return requestSpecification =RestAssured
                .given()
                .baseUri("https://api.cmh.platform-test2.evinternal.net/")
                .basePath(BasePath.maxpanel)
                .contentType(ContentType.JSON)
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
