package GenericFramework.APIs;

import RestApiUtils.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;

public class AirlineAPIs extends Base {

    public Response createAirline(Object payload){
        String airLineEndpoint= (String) Base.payload.get("AirLineEndpoint");
        String airLineBasePath= (String) Base.payload.get("AirLineBasePath");
        Response response= RestUtils.POST(airLineEndpoint, airLineBasePath, payload, new HashMap<>());
        return response;

    }

}
