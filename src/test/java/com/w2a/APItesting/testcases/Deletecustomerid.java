package com.w2a.APItesting.testcases;

import Utilities.DataUtil;
import Utilities.TestUtils;
import baseSetup.BaseSetup;
import customerAPI.customerAPI;
import customerAPI.deleteCustomerAPI;
import io.restassured.response.Response;
import listenerReport.ExtentListeners;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Deletecustomerid extends BaseSetup {

    @Test(dataProviderClass = DataUtil.class, dataProvider = "data")
    public void Deleterequest(Hashtable<String,String> data)
    {

        Response response= deleteCustomerAPI.sendDeleterequestwithValidKey(data);
        ExtentListeners.testReport.get().info(data.toString());
        response.prettyPrint();
        System.out.println(response.statusCode());
        String actualid=response.jsonPath().getString("id");
        Assert.assertEquals(actualid,data.get("id"));
//        JSONObject jsonObject=new JSONObject(response.asString());
//        System.out.println(jsonObject.has("id"));
        Boolean objectkeyPresent= TestUtils.hasObjectKey(response.asString(),"id");
        Assert.assertTrue(objectkeyPresent,"ID is matched");
        String actualid2= TestUtils.getObjectValue(response.asString(),"id");
        Assert.assertEquals(actualid2,data.get("id"));


    }

}
