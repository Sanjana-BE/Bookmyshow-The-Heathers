package extentReport;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports report;
	public static ExtentReports getReportInstance(){
   
		if(report == null){
			String reportName =DateUtils.getTimestamp()+".html"; 
			
			//setting report path
			ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Report\\test-output"+reportName);
			report  = new ExtentReports();
			report.attachReporter(htmlReporter);
			// to generate what we are using
			report.setSystemInfo("OS", "windos10");
			
			//setting report configurations
			
			//setting the document title
			htmlReporter.config().setDocumentTitle("BookMyShow Automation");
			
			//setting reportname
			htmlReporter.config().setReportName("The Heathers");
			
			//setting the date and time format
			htmlReporter.config().setTimeStampFormat("MM dd,yyyy HH:mm:ss");
			
			//setting theme
			htmlReporter.config().setTheme(Theme.DARK);
		}
	 return report;
	//this will define in base class
	}
}