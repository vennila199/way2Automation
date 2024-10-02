package baseSetup;

import Utilities.ExcelReader;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseSetup {
    public static Properties prop;
    private FileInputStream fis;
    public static ExcelReader excell=new ExcelReader(".//src//test//resources//testData//testData.xlsx");
    @BeforeSuite
    public void setup() throws IOException {
        prop=new Properties();
        fis=new FileInputStream(".//src//test//resources//properties//config.properties");
        prop.load(fis);
        RestAssured.baseURI=prop.getProperty("baseURI");
        RestAssured.basePath=prop.getProperty("basePath");
    }

    @AfterSuite
    public void teardown()
    {
        System.out.println("-------TearDown method---------");
    }
}