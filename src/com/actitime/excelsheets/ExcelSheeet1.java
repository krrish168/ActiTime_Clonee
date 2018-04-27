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

public class ExcelSheeet1
{
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
	//create and read the file
	File file=new File("./data/input.xlsx");
	//declaration of FileInputStream class to read the data from Excel
	FileInputStream fis=new FileInputStream(file);
	//create workbook
	Workbook wb=WorkbookFactory.create(fis);
	//get the sheet
	Sheet sh=wb.getSheet("sheet1");
	//get the rows
	Row r=sh.getRow(0);
	//get the cell
	Cell c=r.getCell(0);
	//get the data
	String data=c.getStringCellValue();
	//String data=c.toString();
	System.out.println(data);
	}
}