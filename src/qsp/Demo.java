package qsp;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream("./data/Book.xlsx");
		Workbook w=WorkbookFactory.create(fis);
		//Go to sheet1 --> 1st row --> 1st cell
		Cell c = w.getSheet("sheet1").getRow(0).getCell(0);
		String v = c.getStringCellValue();
		System.out.println(v);
		

	}

}
