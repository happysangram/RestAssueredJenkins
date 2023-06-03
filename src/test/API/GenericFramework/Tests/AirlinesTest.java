package GenericFramework.Tests;

import GenericFramework.APIs.AirlineAPIs;
import Utils.JsonReaderUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class AirlinesTest extends AirlineAPIs {

    String Env;

    @BeforeClass
    public void beforeClass(){
        Env=System.getProperty("env")==null?"Test":System.getProperty("env");
    }

    @Test
    public void createAirLine() throws IOException {
        String payload= JsonReaderUtils.jsonReaderAsString("/Airlines/"+Env+"/AirlinePayload.json");
        Response response=createAirline(payload);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createAirLineAsMapPayload() throws IOException {
        Map<String,Object> payload= JsonReaderUtils.jsonReaderAsMap("/Airlines/"+Env+"/AirlinePayload.json");
        Response response=createAirline(payload);
        Assert.assertEquals(response.statusCode(),200);

    }
}
