package com.api.dataprovider;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class jsonbody_input {

  @DataProvider(name ="put")
  public Object[][] p() throws IOException {
	  
	 
    
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\Test data\\API data.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sh = wb.getSheetAt(1);
    
  //  Object[][] d = new Object[sh.getLastRowNum()][2];
    Object[][] d = new Object[1][5];
    
    for(int i =1;i<=1;i++) {
    	  for(int j =1;j<=5;j++) {
    		  
    		  d[i-1][j-1] = sh.getRow(i).getCell(j).getStringCellValue();
    	    	   	
    	  }}
	return d;
    }}