package com.roughwork;

import Utilities.ExcelReader;

public class readData {
    public static void main(String[] args)
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

        for(int rNum=dataStartRowNum;rNum<=dataStartRowNum+testrows;rNum++)
        {
            for(int colNum=0;colNum<testCols;colNum++)
            {
                System.out.println(excel.getCellData(sheetName,colNum,rNum));
            }
        }

    }
}
