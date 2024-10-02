package customerAPI;

import baseSetup.BaseSetup;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class customerAPI extends BaseSetup {

    public static Response sendpostrequestwithValidKey(Hashtable<String,String> data)
    {
        Response response= given().auth().basic(prop.getProperty("validSecretkey"), "")
                .formParam("email",data.get("email")).formParam("name",data.get("name"))
                .formParam("description",data.get("description")).post(prop.getProperty("CustomerAPIEndpoint"));

        return response;
    }

    public static Response sendpostrequestwithInValidKey(Hashtable<String,String> data)
    {
        Response response= given().auth().basic(prop.getProperty("invalidSecretKey"),"")
                .formParam("email",data.get("email")).formParam("name",data.get("name"))
                .formParam("description",data.get("description")).post(prop.getProperty("CustomerAPIEndpoint"));
        return response;
    }
}
