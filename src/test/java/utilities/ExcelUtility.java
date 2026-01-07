package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	
	
		public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook wb;
		public XSSFSheet ws;
		public XSSFRow row;
		public XSSFCell cell;
		public CellStyle style;
		String path;
		
		public ExcelUtility(String path) {
			this.path= path;
		}
		
		public  int getRowCount(String sheetName) throws IOException {
				fi = new FileInputStream(path);
				wb = new XSSFWorkbook(fi);
				ws = wb.getSheet(sheetName);
				int rowCount = ws.getLastRowNum() + 1;
				wb.close();
				fi.close();
				return rowCount;
		}
		
		public  int getCelCount(String sheetName, int rowNum) throws IOException {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rowNum);
			int cellCount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellCount;
		}
		
		public  String getCellData(String sheetName, int rownum, int cellnum) throws IOException {
			
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			cell = row.getCell(cellnum);
			
			String data;
			//data = cell.toString();  --- this toString will throw exception when got empty cell
			// so using DataFormatter class from APchePOI library
			try {
				
			
			DataFormatter df = new DataFormatter();
			data = df.formatCellValue(cell);
			}
			catch(Exception e){
				data="";
			}
			wb.close();
			fi.close();
			
			
			return data;
		}
		
		public  void setCellData(String sheetName, int rownum, int column, String data) throws IOException {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			
			cell= row.createCell(column);
			cell.setCellValue(data);
			fo = new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
	

	
}
