package Base;

import Utils.PropertiesReader;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public static Properties properties;
    @BeforeClass
    public void before() throws IOException {
        properties=PropertiesReader.readProperties("/Users/sangram.das/GIT/RestAssueredAutomationJenkins/src/test/resources/config.properties");
    }

}
