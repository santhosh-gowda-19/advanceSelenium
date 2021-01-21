package test_scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProvider 
{
	public static Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream("./excel/frame1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rc = sh.getLastRowNum();
		Row r = sh.getRow(0);
		short cc = r.getLastCellNum();
		Object data[][]=new Object[rc+1][cc];
		for(int i=0;i<rc+1;i++)
		{
			Row row = sh.getRow(i);
			for(int j=0;j<cc;j++)
			{
				Cell cell = row.getCell(j);
				data[i][j]=cell.getStringCellValue();
			}
		}
		return data;
	}
}
