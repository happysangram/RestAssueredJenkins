package GenericFramework.Tests.Testcases;

import GenericFramework.APIs.AirlineAPIs;
import GenericFramework.Resource.Airlines.POJOs.AirLinePojo;
import GenericFramework.Resource.Airlines.POJOs.AirLineResponsePojo;
import Utils.ExcelUtils;
import Utils.JsonReaderUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class AirlinesTest extends AirlineAPIs {

    String Env;

    @BeforeClass
    public void beforeClass(){
        Env=System.getProperty("env")==null?"Test":System.getProperty("env");
    }

    @Test
    public void createAirLine() throws IOException {
        //String payload= JsonReaderUtils.jsonReaderAsString("/Airlines/"+Env+"/AirlinePayload.json");
        Faker faker=new Faker();
//        AirLinePojo airLinePojo=new AirLinePojo();
//        airLinePojo.setCountry(faker.country().name());
//        airLinePojo.setId(faker.number().numberBetween(111111,9999999));
//        airLinePojo.setName(faker.name().name());
//        airLinePojo.setLogo("https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png");
//        airLinePojo.setSlogan(faker.name().name());
//        airLinePojo.setHeadQuaters(faker.name().name());
//        airLinePojo.setWebsite(faker.name().name());
//        airLinePojo.setEstablished(faker.number().digit());

//        AirLinePojo airLinePojo=AirLinePojo.builder()
//                .country(faker.country().name())
//                .id(faker.number().numberBetween(111111,9999999))
//                .name(faker.name().name())
//                .logo("https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png")
//                .slogan(faker.name().name())
//                .headQuaters(faker.name().name())
//                .website(faker.name().name())
//                .established(faker.number().digit())
//                 .build();
        
     //   AirLinePojo airLinePojo=new AirLinePojo();

        AirLinePojo airLinePojo=new AirLinePojo().toBuilder()
                .country(faker.country().name())
                .build();

        ObjectMapper objectMapper=new ObjectMapper();
        String pojo=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(airLinePojo);

        Response response=createAirline(pojo);

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
         Optional opt=  Optional.ofNullable(response.jsonPath().get("website1"));
         if(opt.isPresent()){
             System.out.println("website is : " + opt);
         }
         else
         {
             System.out.println(opt + "Key is not present");
         }
        System.out.println(Optional.ofNullable(response.jsonPath().get("website")));
        Assert.assertEquals(response.statusCode(),200);
        ObjectMapper oo=new ObjectMapper();
        AirLineResponsePojo ss= oo.readValue(response.asString(), AirLineResponsePojo.class);
        System.out.println(ss.getId1());

    }

    @Test
    public void createAirLineAsMapPayload() throws IOException {
        Faker faker=new Faker();
        Map<String,Object> payload= JsonReaderUtils.jsonReaderAsMap("/Airlines/"+Env+"/AirlinePayload.json");
        payload.put("id",faker.number().numberBetween(100000,9999999));
        Response response=createAirline(payload);
        Assert.assertEquals(response.statusCode(),200);

    }

    @Test
    public void createAirLineWithPojoResponse() throws IOException {

        AirLinePojo airLinePojo=new AirLinePojo();

        Response response=createAirline(airLinePojo);

        Assert.assertEquals(response.statusCode(),200);
        ObjectMapper oo=new ObjectMapper();
        AirLinePojo airLinePojoResponse= oo.readValue(response.getBody().asString(), AirLinePojo.class);
        Assert.assertEquals(airLinePojoResponse,airLinePojo);

    }

    @Test
    public void createAirLineFailedCase() throws IOException {

        AirLinePojo airLinePojo=new AirLinePojo();
        Response response=createAirline(airLinePojo);
        airLinePojo.setSlogan("hi");



        ObjectMapper oo=new ObjectMapper();
        AirLinePojo airLinePojoResponse= oo.readValue(response.getBody().asString(), AirLinePojo.class);
        Javers javers= JaversBuilder.javers().build();
        Diff diff= javers.compare(airLinePojo,airLinePojoResponse);
        System.out.println(diff.prettyPrint());

        Assert.assertEquals(airLinePojoResponse,airLinePojo);

    }

    @Test(dataProvider ="AirLineData")
    public void createAirLineWithDataProvider(AirLinePojo airLinePojo) throws IOException {

        Response response=createAirline(airLinePojo);

        Assert.assertEquals(response.statusCode(),200);
        ObjectMapper oo=new ObjectMapper();
        AirLinePojo airLinePojoResponse= oo.readValue(response.getBody().asString(), AirLinePojo.class);
        Assert.assertEquals(airLinePojoResponse,airLinePojo);

    }

    @DataProvider(name = "AirLineData")
    public Iterator<AirLinePojo> getAirLineData() throws IOException {
        List<HashMap<String, String>>  dataMap = ExcelUtils.ReadFromExcelItems("AirLine1", "Sheet1");
        List<AirLinePojo> airLinePojos=new ArrayList<>();
        for(HashMap<String,String> data: dataMap){
            AirLinePojo airLinePojo=new AirLinePojo().toBuilder()
                    .id(Integer.parseInt(data.get("id")))
                    .name(data.get("name"))
                    .country(data.get("country"))
                    .logo(data.get("logo"))
                    .slogan(data.get("slogan"))
                    .headQuaters(data.get("head_quaters"))
                    .website(data.get("website"))
                    .established(data.get("established"))
                    .build();
            airLinePojos.add(airLinePojo);
        }

        return airLinePojos.listIterator();
    }
}
