package com.evs.vtiger.exceldata;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ExcelDataUtil {

	public static void main(String[] args) throws IOException {
		// getTestCaseData("TestCaseData\\TestCase.xlsx","VT001");

	}

	// we want get data of column from workBook,then first of we create method of
	// get colum number
	// and this method we pass two argument, in first argument we pass reference
	// variable of sheet andq in
//	 second we will pass column name in string 
	public int getColumnNumber(Sheet sheetObj, String colomnName) throws IOException {

		Row rowObj = sheetObj.getRow(0);
		int columnNumber = -1;
		int currentCellNumber = rowObj.getLastCellNum();
		for (int j = 0; j <= currentCellNumber - 1; j++) {
			Cell cellObj = rowObj.getCell(j);
			String columnData = cellObj.getStringCellValue();
			if (columnData.equalsIgnoreCase(colomnName)) {
				columnNumber = j;
//			break;
			}
		}
		return columnNumber;
	}

	public List<Map<String, String>> getTestCaseData(String xlsFilePath, String testcaseId) throws IOException {

		List<String> columnHeader = new ArrayList<String>();

		InputStream files = new FileInputStream(xlsFilePath);
		// when we read excel data then we create FileInputStream
		String[] arrPath = xlsFilePath.split("\\.");
		// in which we call split() method split method return String type array
		Workbook wBook = null;
		// Here we want use this variable in the whole method.then our workbook
		// is null then we are not use it
		String fileExcetension = arrPath[1];
		// then it's work only one extension so it is depend on split method

		if (fileExcetension.equalsIgnoreCase("xlsx")) {
			wBook = new XSSFWorkbook(files);
		} else if (fileExcetension.equalsIgnoreCase("xls")) {
			wBook = new HSSFWorkbook(files);
		} else {
			System.out.println("File Extension name is wrong Please check it ");

			// In which we pass the if condition and this condition is match
			// then we create XSSFWorkBook object when if condition is not match
			// then it's go on else if condition and this condition is match
			// then we create HSSFWorkBook object when else if condition is not match
			// then it's go on else condition and print this File Extension name is wrong
			// Please check it
		}
		Sheet sheetObj = wBook.getSheet("TestData");
		List<Integer> rowNumberList = getRowNumbers(sheetObj, testcaseId);

		List<Map<String, String>> completeDataMapList = new ArrayList<Map<String, String>>();

		for (int j = 0; j <= rowNumberList.size() - 1; j++) {
			Map<String, String> testCaseDataMap = new HashMap<String, String>();
			int rowNumber = rowNumberList.get(j);
			Row rowObj = sheetObj.getRow(rowNumber);

			int dataColumnNumber = getColumnNumber(sheetObj, "DataName1");
			int cellCount = rowObj.getLastCellNum();
			for (int i = dataColumnNumber; i <= cellCount - 1; i = i + 2) {
				Cell cellDataNameObj = rowObj.getCell(i);
				Cell cellDataValueObj = rowObj.getCell(i + 1);
				String cellDataName = cellDataNameObj.getStringCellValue();
				String cellDataValue = cellDataValueObj.getStringCellValue();
				testCaseDataMap.put(cellDataName, cellDataValue);
			}
			completeDataMapList.add(testCaseDataMap);
		}
		return completeDataMapList;
	}

	public List<Integer> getRowNumbers(Sheet sheetObj, String testcaseId) throws IOException {

		int columnnum = getColumnNumber(sheetObj, "TcId");
		int countRow = sheetObj.getLastRowNum();

		List<Integer> rowNumbers = new ArrayList<Integer>();
		for (int i = 0; i <= countRow; i++) {
			Row rowObj = sheetObj.getRow(i);
			Cell cellData = rowObj.getCell(columnnum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			if (cellData.getStringCellValue().equalsIgnoreCase(testcaseId)) {
				rowNumbers.add(i);
			}
		}

		return rowNumbers;
	}

	public String get1(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
