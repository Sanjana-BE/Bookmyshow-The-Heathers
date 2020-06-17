package excel;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.remote.RemoteWebDriver;
import setUp.BaseClass;

public class TestData extends BaseClass {
	
	//get pagetitle from excel before signin
	
	public String getGeneralTitle() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("General Title");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get city from excel class
	
	public String getCity() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Location");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get popup from excel class
	
	public String getPopup() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Pop-up");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get signinbutton from excel class
	
	public String getSigninButton() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("First Button");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get continueviagooglebutton from excel class
	
	public String getContinueViaGoogleButton() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Second Button");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get emailField from excel class
	
	public String getEmailField() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Text Box");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get username from excel class
	
	public String getUsername() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("Username");
		String Username=(String) data.get(1);
		return Username;
	}
	
	public String getInvalidUsername() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("Invalid UserName");
		String Username=(String) data.get(1);
		return Username;
	}
	
	public String getvalidUsername() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("InvalidTest Password");
		String Username=(String) data.get(1);
		return Username;
	}
	
	public String getValidUsernameForBlankPassword() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("BlankTest Password");
		String Username=(String) data.get(1);
		return Username;
	}
	
	public String getBlankUsername() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("Blank UserName");
		String Username=(String) data.get(1);
		String value = Username;
		properties = fromPropertiesFile();
		String username = properties.getProperty(value);
		return username;
	}
	
	public String getBlankPassword() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("Blank Password");
		String Password=(String) data.get(1);
		properties = fromPropertiesFile();
		String value = Password;
		String password = properties.getProperty(value);
		return password;
	}
	
	//get emailNext from excel class
	
	public String getEmailNext() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Next Button");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get passwordField from excel class
	
	public String getPasswordField() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Masked Text Box");
		String Password=(String) data1.get(1);
		return Password;
	}
	
	//get password from excel class
	
	public String getPassword() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Password");
		String Password=(String) data1.get(1);
		return Password;
	}
	
	public String getInvalidPassword() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data=d.getdata("Invalid Password");
		String password=(String) data.get(1);
		return password;
	}
	
	//get password from excel class
	
	public String getPasswordNext() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Submit Button");
		String Password=(String) data1.get(1);
		return Password;
	}
	
	//get sports from excel class
	
	public String getSports() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Menu Item");
		String data=(String) data1.get(1);
		return data;
	}
	
	//get sportsdisplay from excel class
	
	public String getDisplay() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Display Button");
		String data=(String) data1.get(1);
		return data;
	}
	
	//get sportsdisplay from excel class
	
	public String getWeekend() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Check Box");
		String data=(String) data1.get(1);
		return data;
	}
	
	//get sportsrange from excel class
	
	public String getPriceRange() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Drop down");
		String data=(String) data1.get(1);
		return data;
	}
	
	//get mindisplay from excel class
	
	public String getMinimumRange() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Select Value");
		String data=(String) data1.get(1);
		return data;
	}
	
	// get title from excel class
	
	public String getTitle() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Title");
		String Title=(String) data1.get(1);
		return Title;
	}
	
	//get sports name from excel class
	
	public String getSportsName1() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Sports Name");
		String SportsName=(String) data1.get(1);
		return SportsName;		
	}
	
	//get event name from excel class
	
	public String getSportsName3() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Sport Name");
		String SportsName=(String) data1.get(1);
		return SportsName;		
	}
	
	//get window from excel class
	
	public String getWindow() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Navigate To");
		String data=(String) data1.get(1);
		return data;		
	}
	
	//get moviedisplay from excel class
	
	public String getMovieDisplay() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Display Section");
		String data=(String) data1.get(1);
		return data;		
	}
	
	//get month from excel class
	
	public String getMoonth() throws IOException
	{
		//the value returned by importfromexcel class is added in arraylist and it is sent to the main class where it is called.
		ImportFromExcel d= new ImportFromExcel();
		ArrayList data1=d.getdata("Select Month");
		String data=(String) data1.get(1);
		return data;		
	}
	
}