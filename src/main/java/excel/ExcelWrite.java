package excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
 
public class ExcelWrite
{
	//Create an object of FileInputStream class to read excel file
    public FileInputStream readfile = null;
    
    //Create an object of FileOtputStream class to write data into excel file
    public FileOutputStream writefile = null;
    
    //XSSFWorkbook - class represents XLSX file (object name - workbook)
    public XSSFWorkbook workbook = null;
    
    //XSSFSheet - class represents a sheet in a XLSX file (object name - sheet)
    public XSSFSheet sheet = null;
    
    //XSSFRow - class represents a row in a sheet of XLSX file (object name - row)
    public XSSFRow row = null;
    
    //XSSFCell - class represents a cell in a row of XLSX file (object name - cell)
    public XSSFCell cell = null;
    String xlFilePath;
 
    
    //getting path of excel sheet
    
    public ExcelWrite(String xlFilePath) throws Exception
    {
        this.xlFilePath = xlFilePath;
        readfile = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(readfile);
        readfile.close();
    }
    
    //setting the data in cell by getting the sheet name, column name, rownumber, and what value has to be wrriten.
 
    public boolean setCellData(String sheetName, String colName, int rowNum, String value)
    {
        try
        {
        	//setting the column number as -1 for proper iteration
            int col_Num = -1;
            
            //call the getSheet() method of Workbook and pass the Sheet Name here.
            sheet = workbook.getSheet(sheetName);
            
            //Get the first row from the sheet
            row = sheet.getRow(0);
            
            //setting the column number by using column name
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                {
                    col_Num = i;
                }
            }
            
            //adjusting the column-size
            sheet.autoSizeColumn(col_Num);
            
            //call the getRow() method of sheet and set the row.
            row = sheet.getRow(rowNum - 1);
            
            //Create a new row and append it at the sheet
            if(row==null)
                row = sheet.createRow(rowNum - 1);
            
            //get the cell from the row
            cell = row.getCell(col_Num);
            
            //create a new cell in a row
            if(cell == null)
                cell = row.createCell(col_Num);
 
            //Fill data in the cell
            cell.setCellValue(value);
 
            //Create an object of FileOutputStream class to create write data in excel file
            writefile = new FileOutputStream(xlFilePath);
            
            //write data in the excel file
            workbook.write(writefile);
            
            //close output stream
            writefile.close();
        }
        catch (Exception e)
        {
        	//trace the exception.
            e.printStackTrace();
            return  false;
        }
        return true;
    }
}