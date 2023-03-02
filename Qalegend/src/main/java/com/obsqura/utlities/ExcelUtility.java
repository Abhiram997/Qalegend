package com.obsqura.utlities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.obsqura.constants.Constants;

public class ExcelUtility {

	XSSFSheet sheet;
	XSSFWorkbook workbook;
	XSSFRow row;
	XSSFCell cell;

	public void selectExcelFile(String workBookName, String sheetName) {
		try {
			String path = Constants.EXCEL_FILE_PATH + workBookName + ".xlsx";
			File src = new File(path);
			FileInputStream fi = new FileInputStream(src);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {

		}

	}

	public String getCellData(int rowno, int columnno) {
		row = sheet.getRow(rowno);
		cell = row.getCell(columnno);

		switch (cell.getCellType()) {
		case STRING: {
			String x;
			x = cell.getStringCellValue();
			return x;
		}


	case NUMERIC: {
		long d = (long) cell.getNumericCellValue();
		return String.valueOf(d);

	}

	default:
		return null;
	}
}

}
	