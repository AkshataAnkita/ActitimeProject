package com.Actitime.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readDatafromPropertyFile {
	public String readdatafromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./TestData/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
		}

}
