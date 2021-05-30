package com_actitime_Generic;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData implements AutoConstant {

	public static String getData(String filepath,String sheet_name,int rn,int cn)

	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			String data = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getCell(cn).getStringCellValue();
			return data;
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	public static int getRowCount(String filepath,String sheet_name)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			int rc = WorkbookFactory.create(fis).getSheet(sheet_name).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
			return 0;
		}

	}

	public static int getCellCount(String filepath, String sheet_name, int rn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			int cc = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getLastCellNum();;
			return cc ;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	
	//	public static int getrandom(String filepath, String sheet_name, int rn, int cn)
	//	{
	//		try
	//		{
	//			FileInputStream fis = new FileInputStream(new File(filepath));
	//			int random = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getCell(cn);
	//			return random ;
	//		}
	//		catch (Exception e) 
	//		{
	//			return 0;
	//		}
	//	}
}