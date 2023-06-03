package RestApiUtils;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestSpecifications  {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;



    public static RequestSpecification requestSpecification(){
        return requestSpec= RestAssured
                .given()
                .baseUri("https://api.instantwebtools.net")
                .contentType(ContentType.JSON)
                .log().all();
    }

    public static ResponseSpecification responseSpecification() {
        return responseSpec=new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
