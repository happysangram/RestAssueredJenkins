package TestCases;

import Base.BaseTest;
import Listeners.RetryAnalyzer;
import Payloads.MaxPanelPayload;
import Pojo.Maxpanel;
import Pojo.ResponsePojo.Layout;
import Pojo.ResponsePojo.ResponseMaxpanel;
import RestAPIs.Constants;
import RestAPIs.RestResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class MaxPanelAPI extends BaseTest {
    private Maxpanel maxpanel;
    Gson gson=new Gson();

    @BeforeClass
    public void beforeClass(){
         maxpanel= MaxPanelPayload.maxpanelPayload();
    }

    @Test
    public void validateMaxPanel() throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        String objectPojo1=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(maxpanel);

        System.out.println(objectPojo1);

        File payload= new File("/Users/sangram.das/GIT/RestAssueredAutomationJenkins/src/test/resources/JsonFiles/maxpanel.json");
        String payloadFile=FileUtils.readFileToString(payload, StandardCharsets.UTF_8);


        Maxpanel jsonfile= objectMapper.readValue(payloadFile,Maxpanel.class);
        String objectPojo2=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonfile);
        System.out.println(objectPojo2);

        Assert.assertEquals(objectPojo1,objectPojo2,"both are same");
        System.out.println(jsonfile.getOffsets().getEave());

        HashMap<String,String> queryParam=new HashMap<>();
        queryParam.put("reportid","44842266");

        Response response=RestResource.POST(objectPojo1,null,queryParam, Constants.maxpanelPath);
      //  response.body(matchesJsonSchemaInClasspath(""));
        System.out.println(response.asString());

        ObjectMapper objectMapperdeserial=new ObjectMapper();

        Object objectValue=objectMapperdeserial.readValue(response.asString(),Object.class);
        String responseObjectString=objectMapperdeserial.writerWithDefaultPrettyPrinter().writeValueAsString(objectValue);
        System.out.println(responseObjectString);

        ResponseMaxpanel responseMaxpanel=new ResponseMaxpanel();
        responseMaxpanel=gson.fromJson(response.asString(),ResponseMaxpanel.class);
        List<Layout> layouts=new ArrayList<>();
        layouts=responseMaxpanel.getLayout();
        for(Layout layouts1:layouts){

            if(layouts1.getActivepanels().equals(77)){
                Assert.assertEquals(layouts1.getDesignator(),"D");
            }

        }
        System.out.println("Test Failed");

        //JsonPath jsonPath= response.getBody().jsonPath();
    }

    @Test
    public void maxpanelSchemaValidation() throws JsonProcessingException, FileNotFoundException {

        ObjectMapper objectMapper=new ObjectMapper();
        String objectPojo1=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(maxpanel);

        HashMap<String,String> queryParam=new HashMap<>();
        queryParam.put("reportid","44842266");
        RestResource.POSTSchema(objectPojo1,null,queryParam, Constants.maxpanelPath);

    }
}
