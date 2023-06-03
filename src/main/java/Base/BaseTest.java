package Base;

import Filter.RestAssuredFilter;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static RestAssuredFilter restAssuredFilter;

    @BeforeTest(alwaysRun = true)
    public void beforeMethod(){

        System.out.println("77777999999999999999999999999");
        restAssuredFilter=new RestAssuredFilter();

    }
}
