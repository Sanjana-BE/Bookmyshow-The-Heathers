package excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ImportFromExcel {

	public ArrayList<String> getdata(String testcaseName) throws IOException {
		
		ArrayList<String> a=new ArrayList<String>();
		
		//Create an object of FileInputStream class to read excel file
		FileInputStream readfile=new FileInputStream(System.getProperty("user.dir")+"\\ExcelSheet\\BookMyShow.xlsx");
		
		//XSSFWorkbook - class represents XLSX file (object name - workbook)
		XSSFWorkbook workbook = new XSSFWorkbook(readfile);
		
		//getting number of sheets from workbook
		int sheets = workbook.getNumberOfSheets();
		
		//creating a loop to read the cell value 
		for(int i=0;i<sheets;i++)
		{
			//checking whether if it is in the required sheet
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
			{		
				//Read sheet inside the workbook
				XSSFSheet sheet=workbook.getSheetAt(i);
				
				//traverse the row one by one in the sheet
				Iterator<Row> rows= sheet.iterator();
				Row firstrow=rows.next();
				
				//traverse the cell one by one in the row
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column = 0;
				
				//setting the required column
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
					{
						column=k;
					}
					k++;
				}
				//System.out.println(column);
				
				//checking the required row one by one
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						//once the required row is found, traverse the cell one by one, read and return the cell value
						Iterator<Cell> cd=r.cellIterator();
						while(cd.hasNext())
						{
							Cell c=cd.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
							a.add(c.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}
		return a;
	}
}
