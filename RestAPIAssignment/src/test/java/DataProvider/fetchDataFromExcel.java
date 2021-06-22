package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class fetchDataFromExcel {
	
	public static Object[][] gettestdata() throws IOException
//	public static void main(String args[]) throws IOException
	{
		String path = "C:\\SDETTraining\\Assingment1.xlsx";
		
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheetAt(0);
		
		int totalRows = sheet.getLastRowNum();
		totalRows = totalRows+1;
		Row row = sheet.getRow(1);
		int columnCount = row.getLastCellNum();
		
		System.out.println("Total Rows = "+totalRows);
		System.out.println("Total Columns = "+columnCount);
		
		Object data[][] = new Object[totalRows][columnCount];
		
		for(int i=0;i<totalRows;i++)
		{
			for(int j=0;j<columnCount;j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		
		workbook.close();
		return data;
		
		}
		
}
	
	
