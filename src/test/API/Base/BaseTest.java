package Base;

import Filter.RestAssuredFilter;
import RestApiUtils.PropertiesReader;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties properties;
    public static RestAssuredFilter restAssuredFilter;
    @BeforeClass
    public void before() throws IOException {
        properties=PropertiesReader.readProperties("/Users/sangram.das/GIT/RestAssueredAutomationJenkins/src/test/resources/config.properties");
        restAssuredFilter=new RestAssuredFilter();
    }

}
