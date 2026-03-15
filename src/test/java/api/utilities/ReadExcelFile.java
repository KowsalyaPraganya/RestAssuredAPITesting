package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
   public static FileInputStream inputStream;
   public static XSSFWorkbook workbook; 
   public static XSSFSheet excelsheet; 
   public static XSSFRow row;
   public static XSSFCell cell;
   
   public ReadExcelFile()  {
	   try {
		inputStream = new FileInputStream("C:\\Users\\Kutty Karadi\\eclipse-workspace\\RestAssuredAPITesting\\TestData\\TestData.xlsx");
	   } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   try {
		workbook = new XSSFWorkbook(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	excelsheet = workbook.getSheet("Sheet1");
	
   }
   
   public  String ReadExcelData(int rowNum, int colNum) throws IOException {
	  cell = excelsheet.getRow(rowNum).getCell(colNum);
	  DataFormatter formatter = new DataFormatter();
	  workbook.close();
	  System.out.println(formatter.formatCellValue(cell));
	  return formatter.formatCellValue(cell);
	//return cell.getStringCellValue(); //Error Faced : Cannot get a STRING value from a NUMERIC cell

   }
  
   public int findRowCount() {
	//int totalNumberOfRows = excelsheet.getPhysicalNumberOfRows(); //Number of rows
	   int totalNumberOfRows = excelsheet.getLastRowNum(); //Number of rows
	return totalNumberOfRows;
   }

   public int findColumnCount() {
	   row = excelsheet.getRow(0);
	   //int totalNumberOfColumns = row.getPhysicalNumberOfCells();
	   int totalNumberOfColumns = row.getLastCellNum();
	   return totalNumberOfColumns;
   }
}
