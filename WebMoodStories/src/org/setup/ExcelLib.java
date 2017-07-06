package org.setup;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelLib {
	Workbook wrkBook = null;

	public ExcelLib(String path) throws BiffException, IOException {
		// Initialize
		wrkbook = Workbook.getWorkbook(new File(path));

		wrksheet = wrkbook.getSheet("Admin");
	}

	public String GetCellValue(int colnumber, int rownumber) {
		return wrkBook.getSheet(0).getCell(colnumber, rownumber).getContents();
	}

	static Sheet wrksheet;
	static Workbook wrkbook = null;
	static Hashtable dict = new Hashtable();
	// Create a Constructor

	// Returns the Number of Rows
	public static int RowCount() {
		return wrksheet.getRows();
	}

	// Returns the Cell value by taking row and Column values as argument
	public static String ReadCell(int column, int row) {
		return wrksheet.getCell(column, row).getContents();
	}

	// Create Column Dictionary to hold all the Column Names
	public static void ColumnDictionary() {
		// Iterate through all the columns in the Excel sheet and store the
		// value in Hashtable
		for (int col = 0; col < wrksheet.getColumns(); col++) {
			dict.put(ReadCell(col, 0), col);
		}
	}

	// Read Column Names
	public static int GetCell(String colName) {
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);

		}
	}
}
