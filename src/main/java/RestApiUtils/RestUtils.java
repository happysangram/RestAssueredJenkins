package RestApiUtils;

import BaseData.BaseTest1;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils extends BaseTest1 {

    public static Response POST(String endpoint,String basepath, Object payload, Map<String,Object> header){

        return RestAssured.given()
                .spec(RestSpecifications.requestSpecification())
                .basePath(basepath)
                .filter(BaseTest1.restAssuredFilter)
                .body(payload)
                .headers(header)
                .when()
                .post(endpoint)
                .then()
                .spec(RestSpecifications.responseSpecification())
                .log().all()
                .extract().response();
    }
}
