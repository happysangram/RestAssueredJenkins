package RestApiUtils;

import Filter.RestAssuredFilter;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static RestAssuredFilter restAssuredFilter =new RestAssuredFilter();

    public static Response POST(String endpoint,String basepath, Object payload, Map<String,Object> header){

        return RestAssured.given()
                .spec(RestSpecifications.requestSpecification())
                .basePath(basepath)
                .filter(restAssuredFilter)
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
