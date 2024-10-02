package Utilities;

import listenerReport.ExtentListeners;
import org.json.JSONObject;

public class TestUtils {

    public static boolean hasObjectKey(String data,String attr)
    {
        JSONObject jsonObject=new JSONObject(data);
        ExtentListeners.testReport.get().info("Checking if Key is "+attr+" is Present-----");
        return  jsonObject.has(attr);
    }

    public static String getObjectValue(String data,String attr)
    {
        JSONObject jsonObject=new JSONObject(data);
        ExtentListeners.testReport.get().info("getting ObjectValue of "+attr+" -----");
        String actualid2= jsonObject.get(attr).toString();
        return actualid2;
    }
}
