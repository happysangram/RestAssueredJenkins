package RestAPIs;


import com.beust.jcommander.internal.Nullable;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class RestResource {

    private static Response response;
    public static Response POST(String body, @Nullable Map<String, ?> headers, HashMap<String,String> queryParam, String path){

         return  response =
                 given(Specifications.requestSpec())
                 .body(body)
                 .queryParams(queryParam)
                .when()
                 .post(path)
                .then()
                 .spec(Specifications.responseSpec())
                .extract().response();
    }
}
