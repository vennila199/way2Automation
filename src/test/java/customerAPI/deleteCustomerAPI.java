package customerAPI;

import baseSetup.BaseSetup;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class deleteCustomerAPI extends BaseSetup {

    public static Response sendDeleterequestwithValidKey(Hashtable<String,String> data)
    {
        Response response= given().auth().basic(prop.getProperty("validSecretkey"), "")
                .formParam("email",data.get("email")).formParam("name",data.get("name"))
                .formParam("description",data.get("description")).post(prop.getProperty("CustomerAPIEndpoint")+"/"+data.get("id"));

        return response;
    }
}
