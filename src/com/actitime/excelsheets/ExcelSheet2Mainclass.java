package com.actitime.excelsheets;

import com.actitime.generic.ExcelData;

public class ExcelSheet2Mainclass
{
	public static void main(String[] args) 
	{
		String data = ExcelData.getData("./data/Excel1.xlsx", "sheet2", 0, 0);
		System.out.println(data);
		int rc=ExcelData.getRowCount("./data/Excel1.xlsx","sheet2");
		System.out.println(rc);
		int cc = ExcelData.getCellCount("./data/Excel1.xlsx", "sheet2", 0);
		System.out.println(cc);
		
	}

}
