package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.FileConstants;
public class ExcelUtils {
	public static void main(String[] args) throws InvalidFormatException, IOException {
		Object[][] obj1=readExcelFile("username","password");
		for(int i=0;i<obj1.length;i++)
		{
			for(int j=0;j<obj1[i].length;j++) {
				System.out.print(obj1[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static Object[][] readExcelFile(String username,String password) throws InvalidFormatException, IOException
	{
		XSSFWorkbook workBook = new XSSFWorkbook(new File(FileConstants.LOGIN_TESTDATA_FILE_PATH));
		XSSFSheet workSheet=workBook.getSheet("UserCredentials");
		int numOfRows=workSheet.getLastRowNum()+1;
		
		int userNameColumn=0;
				
		Iterator<Row> rows=workSheet.rowIterator();
		
		Row row=rows.next();
		Cell cell;
		Iterator<Cell> cells=row.cellIterator();
		int k=1;
		while(cells.hasNext())
		{
		cell=cells.next();
		
			if(cell.getStringCellValue().contains("Username")) {
				userNameColumn=k;
				System.out.println(userNameColumn);
				
			}
			k++;
		}
		int numOfCols=k-1;
System.out.println(k);
		Object[][] obj=new Object[numOfRows][numOfCols];
		XSSFRow row1;
		for(int i=1;i<numOfRows;i++)
		{
			row1=workSheet.getRow(i);
			
		for(int j=1;j<numOfCols;j++)
				{
		
	             obj[i][j]=row1.getCell(j).getStringCellValue();
	System.out.print(obj[i][j]+" ");
		         }
		System.out.println();
		}
	return	obj;
		
	}
}
