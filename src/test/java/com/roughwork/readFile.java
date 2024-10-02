package com.roughwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readFile {
    public static void main (String[] args) throws IOException {
        Properties prop=new Properties();

        FileInputStream fis=new FileInputStream(".//src//test//resources//properties//config.properties");

        prop.load(fis);

        prop.get("baseURI");

    }
}