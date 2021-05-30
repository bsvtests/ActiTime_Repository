package com_actitime_Test;

import com_actitime_Generic.AutoConstant;
import com_actitime_Generic.ExcelData;

public class ExcelData_SampleCodeTest implements AutoConstant{
	
	public static void main(String[] args) throws Exception {
		//public void DemoA() throws Exception {
			
		int rowdata = ExcelData.getRowCount(filepath, "Sheet1");
		System.out.println("Value of the rowcount is = "+ rowdata);
		
		int celldata = ExcelData.getCellCount(filepath, "Sheet1", 0);
		System.out.println("Value of the cellcount is = "+ celldata);
		
		String data = ExcelData.getData(filepath, filepath, 1, 3);
		System.out.println("Value of the data is = "+ data);
	}
	
}