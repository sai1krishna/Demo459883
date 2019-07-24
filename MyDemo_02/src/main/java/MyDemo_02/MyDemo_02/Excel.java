package MyDemo_02.MyDemo_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excel{
  @Test
public void createExcel() throws IOException {
	  File src= new File("C:\\Users\\training_d2.03.07\\Desktop\\Test_Automation_Stream_Traning\\Book1.xlsx");
	  FileInputStream fis= new FileInputStream(src);
	  XSSFWorkbook wb = new XSSFWorkbook(fis);
	  XSSFSheet sh1 = wb.getSheetAt(0);
	  int rowCount = sh1.getLastRowNum();
	  System.out.println("Total no.of: "+rowCount);
	  for(int i=0;i<=rowCount;i++)
	  {
		 String data= sh1.getRow(i).getCell(0).getStringCellValue();
		 System.out.println("Data from excel sheet is : "+data);
		 String data1= sh1.getRow(i).getCell(1).getStringCellValue();
		 System.out.println("Data from excel sheet is : "+data1);
		 sh1.getRow(i).createCell(2).setCellValue(i+" "+data+ " "+i);
  }
	  FileOutputStream fout = new FileOutputStream( new File("C:\\Users\\training_d2.03.07\\Desktop\\Test_Automation_Stream_Traning\\ExcelOutput.xlsx"));
	  wb.write(fout);
	  fout.close();
  
  }
}
