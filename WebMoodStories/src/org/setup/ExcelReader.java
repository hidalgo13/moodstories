package org.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// workBook work with excel 2010 and above
	private XSSFWorkbook _workBook;
	// private HSSFWorkBook;
	private String _filePath;

	public ExcelReader(String path) {
		_filePath = path;
	}

	public void open() throws IOException {
		File file = new File(_filePath);

		if (file.canRead()) {
			FileInputStream streamIn = new FileInputStream(file);
			_workBook = new XSSFWorkbook(streamIn);
			streamIn.close();
		}
	}

	public void save() throws IOException {
		FileOutputStream streamOut = new FileOutputStream(_filePath);
		_workBook.write(streamOut);
		streamOut.flush();
		streamOut.close();
	}

	public void saveAs(String path) throws IOException {
		FileOutputStream streamOut = new FileOutputStream(path);
		_workBook.write(streamOut);
		streamOut.flush();
		streamOut.close();
	}

	// Sheet

	public XSSFSheet getSheet(String SheetName) {

		XSSFSheet sheet = _workBook.getSheet(SheetName);
		if (!isSheet(SheetName)) {
			sheet = _workBook.createSheet(SheetName);
		}
		return sheet;
	}

	// 1 Create new sheet
	public boolean isSheet(String SheetName) {
		return _workBook.getSheetIndex(SheetName) >= 0;
		// If sheet is created return true, else return false
	}

	public void addSheet(String SheetName) {
		if (!isSheet(SheetName)) {
			_workBook.createSheet(SheetName);
		}
	}
	// 2 Remove a sheet

	public void removeSheet(String SheetName) {
		int index = _workBook.getSheetIndex(SheetName);

		_workBook.removeSheetAt(index);
	}

	public void removeSheet(int SheetIndex) {
		_workBook.removeSheetAt(SheetIndex);

	}

	// Column
	public void addColumn(String SheetName, String ColName) {

		XSSFSheet sheet = getSheet(SheetName);
		addColumn(sheet, ColName);
	}

	public void addColumn(XSSFSheet sheet, String ColName) {

		// XSSFCellStyle style = _workBook.createCellStyle();

		XSSFRow row = sheet.getRow(0);
		if (row == null) {
			row = sheet.createRow(0);
		}
		XSSFCell cell;
		if (row.getLastCellNum() == -1) {
			cell = row.createCell(0);
		} else {
			cell = row.createCell(row.getLastCellNum());
		}

		cell.setCellValue(ColName);
	}

	public void removeColumn(String SheetName, int colNum) {
		XSSFSheet sheet = getSheet(SheetName);
		int rowCount = sheet.getLastRowNum() + 1;

		XSSFRow row;
		for (int i = 0; i < rowCount; i++) {
			row = sheet.getRow(i);
			if (row != null) {
				XSSFCell cell = row.getCell(colNum);
				if (cell != null) {
					row.removeCell(cell);
				}

			}
		}
	}

	public void removeColumn(String SheetName, String colName) {
		XSSFSheet sheet = getSheet(SheetName);
		int colNum = convertColNameToColNum(sheet, colName);
		removeColumn(SheetName, colNum);

	}

	public int convertColNameToColNum(XSSFSheet sheet, String colName) {
		XSSFRow row = sheet.getRow(0);
		int cellRowNumber = row.getLastCellNum();
		int colNum = -1;
		for (int i = 0; i < cellRowNumber; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				colNum = i;
			}
		}

		return colNum;
	}

	public void setCell(XSSFSheet sheet, int rowIndex, int colIndex, String value) {

		XSSFRow row = getRow(sheet, rowIndex);
		XSSFCell cell = getCell(row, colIndex);
		cell.setCellValue(value);
	}

	public XSSFRow getRow(XSSFSheet sheet, int rowIndex) {

		XSSFRow row = sheet.getRow(rowIndex);
		if (row == null) {
			row = sheet.createRow(rowIndex);
		}
		return row;
	}

	public XSSFCell getCell(XSSFRow row, int cellIndex) {

		XSSFCell cell = row.getCell(cellIndex);
		if (cell == null) {
			cell = row.createCell(cellIndex);
		}
		return cell;
	}

	public void setCell(String sheetName, int rowIndex, int colIndex, String value) {
		XSSFSheet sheet = getSheet(sheetName);
		setCell(sheet, rowIndex, colIndex, value);
	}
}
