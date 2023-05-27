package RestAPIs;


import com.beust.jcommander.internal.Nullable;
import io.restassured.config.EncoderConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestResource {

    private static Response response;
    static PrintStream printStream;

    static {
        try {
            printStream = new PrintStream(new File("restAssured.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public RestResource() throws FileNotFoundException {
    }

    public static Response POST(String body, @Nullable Map<String, ?> headers, HashMap<String,String> queryParam, String path){

         return  response =
                 given(Specifications.requestSpec())
                 .body(body)
//                         .filter(new RequestLoggingFilter(printStream))
//                         .filter(new ResponseLoggingFilter(printStream))
                         .config(config().encoderConfig(EncoderConfig.encoderConfig()
                                 .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                 .queryParams(queryParam)
                .when()
                 .post(path)
                .then()
                 .spec(Specifications.responseSpec())
                         .extract().response();
    }

    public static void POSTSchema(String body, @Nullable Map<String, ?> headers, HashMap<String,String> queryParam, String path) throws FileNotFoundException {

                        given(Specifications.requestSpec())
                        .body(body)
                                .filter(new RequestLoggingFilter(printStream))
                                .filter(new ResponseLoggingFilter(printStream))
                        .config(config().encoderConfig(EncoderConfig.encoderConfig()
                                .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                        .queryParams(queryParam)
                        .when()
                        .post(path)
                        .then()
                        .spec(Specifications.responseSpec())
                        .body(matchesJsonSchemaInClasspath("MaxPanelSchema.json"));

    }
}
