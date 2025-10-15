package common;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility   {



	public static String getCellValue(String sheetName, int rowNumber, int columnNumber) throws Exception {
		File file = new File(".\\InputData\\TestData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);

		Sheet sheet = workbook.getSheet(sheetName);

		Row row = sheet.getRow(rowNumber);

		System.out.println(row.getCell(columnNumber).getStringCellValue());
		return row.getCell(columnNumber).getStringCellValue();
	}
	
	}


