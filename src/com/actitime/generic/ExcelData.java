package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData
{
	//TO get the Data
	public static String getData(String pathname,String sheetname,int rn,int cn)
	{
		try
		{
			//create and read the file 
			//File file=new File(pathname);
			//FileInputStream fis=new FileInputStream(file)
			//or directly we can pass this as parameter
			FileInputStream fis=new FileInputStream(new File(pathname));
			//create a workbook
			Workbook wb = WorkbookFactory.create(fis);
			String data=wb.getSheet(sheetname).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch(Exception e)
		{
			return ""; //it returns empty data as string value..if null assigned -it is also becomes a data.
		}
	}
	//To get row count
	public static int getRowCount(String pathname,String sheetname)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			Workbook wb = WorkbookFactory.create(fis);
			int rc=wb.getSheet(sheetname).getLastRowNum();
			return rc;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
	//To gett cell Count
	public static int getCellCount(String pathname,String sheetname,int rn)
	{
		try
		{
			FileInputStream fis=new FileInputStream(new File(pathname));
			Workbook wb = WorkbookFactory.create(fis);
			short cc = wb.getSheet(sheetname).getRow(rn).getLastCellNum();
			return cc;
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
