package GenericFramework.APIs;

import Utils.JsonReaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Base {

    static Map<String,Object> payload=new HashMap<>();

    static {

        String Env=System.getProperty("env")==null?"Test":System.getProperty("env");
        try {
            payload= JsonReaderUtils.jsonReaderAsMap("/Airlines/"+Env+"/Environment.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
