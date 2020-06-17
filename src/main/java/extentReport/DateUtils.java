package extentReport;

import java.util.Date;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DateUtils {
	//returns date and time to extent report
	public static String  getTimestamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "-").replaceAll(" ", "_");		
	}
}