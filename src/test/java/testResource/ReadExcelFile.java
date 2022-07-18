package testResource;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.FileAlreadyExistsException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public XSSFWorkbook workbook;
	public XSSFSheet sheet;

	public ReadExcelFile(String excelpath) throws FileAlreadyExistsException {

		try {
			File src = new File(excelpath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getdata(int sheetnumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetindex) {
		int row = workbook.getSheetAt(sheetindex).getLastRowNum();
		row = row + 1;
		return row;
	}

}
