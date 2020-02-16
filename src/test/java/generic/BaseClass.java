package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public abstract class BaseClass {
	public void ReadFromExcel() {
		String currentPath = System.getProperty("user.dir");
		
		currentPath = currentPath + "\\src\\test\\java\\data\\";
		
		File file = new File(currentPath+ "xyz.xls");
		
		try {
			
			FileInputStream fis = new FileInputStream(file);
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheet("Sample");
			HSSFRow row = sheet.getRow(0);
			HSSFCell cell = row.getCell(0);
			System.out.println(cell.getStringCellValue());
			wb.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void WriteFromExcel(String SheetName, String FileName) {
	
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet Sheet = wb.createSheet(SheetName);
		for (int i=0; i<10;i++) {
		HSSFRow Row = Sheet.createRow(i);
		HSSFCell Cell = Row.createCell(0);
		Cell.setCellValue("SufiyaMulla");
		}
		String currentPath = System.getProperty("user.dir");
		
		currentPath = currentPath + "\\src\\test\\java\\data\\";
		
		File file = new File(currentPath+FileName);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
			wb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
