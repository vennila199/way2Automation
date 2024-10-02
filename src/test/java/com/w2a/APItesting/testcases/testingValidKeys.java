package com.w2a.APItesting.testcases;

import Utilities.DataUtil;
import baseSetup.BaseSetup;
import customerAPI.customerAPI;
import customerAPI.deleteCustomerAPI;
import io.restassured.response.Response;
import listenerReport.ExtentListeners;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static io.restassured.RestAssured.given;

public class testingValidKeys extends BaseSetup {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void testValidKey(Hashtable<String,String> data)
    {


        Response response= customerAPI.sendpostrequestwithValidKey(data);
        ExtentListeners.testReport.get().info(data.toString());
        response.prettyPrint();
        System.out.println(response.statusCode());

    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void testInValidKey(Hashtable<String,String> data)
    {

        Response response= customerAPI.sendpostrequestwithInValidKey(data);
        ExtentListeners.testReport.get().info(data.toString());
        response.prettyPrint();
        System.out.println(response.statusCode());

    }


}
