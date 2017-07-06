package org.action;

import org.setup.ExcelReader;

public class ExcelDemo {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+"\\UserAdmin.xlsx";
		//String pathSaveAs = System.getProperty("user.dir")+"\\UserAAAdmin.xlsx";
		ExcelReader excelReader = new ExcelReader(path);
		
		try {
			excelReader.open();
			excelReader.getSheet("Nguyenhandsome");
			//excelReader.addSheet("Nguyenhandsome");
			//excelReader.removeSheet(1);
			//excelReader.removeSheet("Nguyenhandsome");
			//excelReader.addColumn("Nguyenhandsome","abcd");
			//excelReader.removeColumn("Nguyenhandsome", 0);
			//excelReader.removeColumn("Nguyenhandsome", 1);
			excelReader.setCell("Nguyenhandsome", 2, 1, "Hello guy");
			excelReader.save();
			//excelReader.saveAs(pathSaveAs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
