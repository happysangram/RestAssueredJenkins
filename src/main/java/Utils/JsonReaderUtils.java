package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonReaderUtils {

private  static ObjectMapper objectMapper;
    public static String jsonReaderAsString(String fileName) throws IOException {

        String path=System.getProperty("user.dir")+"/src/test/API/GenericFramework/Resource"+fileName;
         objectMapper=new ObjectMapper();

        Object jsonAsString=objectMapper.readValue(new File(path),Object.class);
        String JsonValueAsString=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonAsString);

        return JsonValueAsString;

    }

    public static Map<String,Object> jsonReaderAsMap(String fileName) throws IOException {

        String path=System.getProperty("user.dir")+"/src/test/API/GenericFramework/Resource"+fileName;
        objectMapper=new ObjectMapper();
        Map<String,Object> jsonAsMap= objectMapper.readValue(new File(path), new TypeReference<>() {});
        return jsonAsMap;

        ///Users/sangram.das/GIT/RestAssueredAutomationJenkins/src/test/API/GenericFramework/Resource/Airlines/Test/AirlinePayload.json

    }
}
