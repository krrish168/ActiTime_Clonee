package com.actitime.excelsheets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet2 {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
	//create and read the file
		File file=new File("./data/Excel1.xlsx");
		FileInputStream fis=new FileInputStream(file);
	//create workBook
		Workbook wb = WorkbookFactory.create(fis);
	//get the sheet
		
		Sheet sh = wb.getSheet("Sheet2");
		
		//get the row
		Row r = sh.getRow(0);
			
		//get the cell
		Cell c = r.getCell(4);
		//get the cell count
		int cn = r.getLastCellNum();
		System.out.println(cn);
	}

}
