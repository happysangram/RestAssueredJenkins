package RestApiUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private  static Properties prop;
    public static Properties readProperties(String filePath) throws IOException {
       prop =new Properties();
        try {
            prop.load(new FileInputStream(filePath));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }
}
