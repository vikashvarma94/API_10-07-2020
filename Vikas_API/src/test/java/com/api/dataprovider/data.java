package com.api.dataprovider;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class data {

  @DataProvider(name ="input")
  public Object[][] dp() throws IOException {
	  
	 
    
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Test data\\API data.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sh = wb.getSheetAt(0);
    
    
  //  Object[][] d = new Object[sh.getLastRowNum()][2];
    Object[][] d = new Object[1][4];
    
    for(int i =4;i<=4;i++) {
    	  for(int j =4;j<=7;j++) {
    		  
    		  d[i-4][j-4] = sh.getRow(i).getCell(j).getStringCellValue();
    	    	   	
    	  }}
	return d;
    }
}
  


