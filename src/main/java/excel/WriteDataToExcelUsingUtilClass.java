package excel;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WriteDataToExcelUsingUtilClass
{
	//Writing data to excel using util class
	
    public static void pass(int row_num, String testtype) throws Exception
    {
    	//passing the path, sheet-name, column-name, row-number, and the results to ExcelWrite class
    	
        ExcelWrite writedata = new ExcelWrite(System.getProperty("user.dir")+"\\ExcelSheet\\BookMyShow Test Results.xlsx");
        writedata.setCellData("Sheet1","Test Results",row_num,"PASS");
        
        //passing the smoke test results to ExcelWrite class
        
        if(testtype.contentEquals("SMOKE"))
        	writedata.setCellData("Sheet1","Smoke Tests Results",row_num,"PASS");
    }
    
    public static void fail(int row_num, String testtype) throws Exception
    {
    	//passing the path, sheet-name, column-name, row-number, and the results to ExcelWrite class
    	
        ExcelWrite writedata = new ExcelWrite(System.getProperty("user.dir")+"\\ExcelSheet\\BookMyShow Test Results.xlsx");
        writedata.setCellData("Sheet1","Test Results",row_num,"FAIL");
        
        //passing the smoke test results to ExcelWrite class
        
        if(testtype.contentEquals("SMOKE"))
        	writedata.setCellData("Sheet1","Smoke Tests Results",row_num,"FAIL");
    }
    
}