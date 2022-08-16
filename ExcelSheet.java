package week6.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	
	public static String[][] excelsheet(String name) throws IOException 
	{
		XSSFWorkbook workbook = new XSSFWorkbook("data/"+name+".xlsx");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		
		for(int i=1; i<=rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			for(int j=0; j< colCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j] = cell.getStringCellValue();
			}
		}
		workbook.close();
		return data;
		
		
		
	}

}
