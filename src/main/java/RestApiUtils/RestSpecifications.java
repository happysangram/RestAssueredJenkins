package RestApiUtils;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

public class RestSpecifications  {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;



    public static RequestSpecification requestSpecification(Object body,  Map<String,Object> header){
        return requestSpec= RestAssured
                .given()
                .baseUri("https://api.instantwebtools.net")
                .contentType(ContentType.JSON)
                .body(body)
                .headers(header)
                .log().all();
    }

    public static ResponseSpecification responseSpecification() {
        return responseSpec=new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
