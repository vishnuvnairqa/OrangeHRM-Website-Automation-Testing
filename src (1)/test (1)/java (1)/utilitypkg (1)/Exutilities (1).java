package utilitypkg;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exutilities {
public static String getCellValue ( String xl , String Sheet , int r , int c ) {
		
		try {
			FileInputStream f1 = new FileInputStream(xl);
		
		
		XSSFWorkbook wb = new XSSFWorkbook(f1);
		XSSFCell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
		
		if (cell.getCellType()== CellType.STRING ) {
			return cell.getStringCellValue();
		
		} else {
			
			return cell.getRawValue();
			
		}
		
	}catch (Exception e) {
		return ""; }

	}
	
	public static int getRowCount(String xl ,String Sheet ) {
		
		try {
			FileInputStream f1 =new FileInputStream(xl);
			XSSFWorkbook wb =  new XSSFWorkbook(f1);
			return wb.getSheet(Sheet).getLastRowNum();
			
			
			
			
		}catch(Exception e){
			
			return 0;		
		}
     }
		

		
		public static int getCellCount(String xl ,String Sheet , int r) {
			
			try {
				FileInputStream f1 =new FileInputStream(xl);
				XSSFWorkbook wb =  new XSSFWorkbook(f1);
				return wb.getSheet(Sheet).getRow(r).getLastCellNum();
				
		
			}catch(Exception e){
				
				return 0;
				
				
			}
			
		}
		
		
			
			
			

}
