package com.actitime.excelsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet1 {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		//create and read the file
		File file=new File("./data/Excel1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		//create workbook
		Workbook wb = WorkbookFactory.create(fis);
		//get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//get the row count
		int rc = sh.getLastRowNum();
		//print the row num
		System.out.println(rc);
	}

}
