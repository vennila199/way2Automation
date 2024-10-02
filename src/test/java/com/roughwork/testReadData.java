package com.roughwork;

import Utilities.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class testReadData {

    @Test(dataProvider = "printData")
    public  void printData(Hashtable<String,String> data)
    {
        System.out.println(data.get("RunMode")+data.get("userName")+data.get("Password"));
    }

    @DataProvider(name = "printData")
    public Object[][] getdata()
    {

        ExcelReader excel=new ExcelReader(".//src//test//resources//testData//BulkData.xlsx");
        String sheetName="TestData";
        String TestcaseName="AddBankDetails";
        int rows=excel.getRowCount(sheetName);
        //Find the Testcase Name
        int testCaseRowNum=1;

        for( testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++)
        {
            if(excel.getCellData(sheetName,0,testCaseRowNum).equalsIgnoreCase(TestcaseName)) {
                break;
            }
        }
        System.out.println("Testcase starts from row num---- "+testCaseRowNum);
        //Find Total Number of Rows
        int dataStartRowNum=testCaseRowNum+2;
        int testrows=0;
        while(!excel.getCellData(sheetName,0,dataStartRowNum+testrows).equalsIgnoreCase(""))
        {
            testrows++;
        }
        System.out.println("Total number of data rows are  "+testrows);
        int testCols=0;
        while(!excel.getCellData(sheetName,testCols,testCaseRowNum+1).equalsIgnoreCase(""))
        {
            testCols++;
        }
        System.out.println("Total number of data colmns are "+testCols);

        Object[][] data=new Object[testrows][1];
        int i=0;
        for(int rNum=dataStartRowNum;rNum<dataStartRowNum+testrows;rNum++)
        {
            Hashtable<String,String> table=new Hashtable<String,String>();
            for(int colNum=0;colNum<testCols;colNum++)
            {
              String testData=excel.getCellData(sheetName,colNum,rNum);
              String colName=excel.getCellData(sheetName,colNum,testCaseRowNum+1);
              table.put(colName,testData);
            }

            data[i][0]=table;
            System.out.println(data[i][0]);
            i++;
        }


      return data;

    }
}
