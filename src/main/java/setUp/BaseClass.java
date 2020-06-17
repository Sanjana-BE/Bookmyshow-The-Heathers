package setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import excel.WriteDataToExcelUsingUtilClass;
import extentReport.DateUtils;
import extentReport.ExtentReporterNG;
import pageObjects.HomePage;
import pageObjects.MoviesPage;
import pageObjects.SportsPage;

public class BaseClass {
	
	//creating objects for each class
	public static Properties properties;
	public static Properties property;
	public static  WebDriver driver;
	public static ExtentReports report = ExtentReporterNG.getReportInstance();
	public static ExtentTest logger;
	public HomePage objHomePage;
	public SportsPage objSportsPage;
	public MoviesPage objMoviesPage;
	public WriteDataToExcelUsingUtilClass objexcelwrite;
	
	public static Properties fromPropertiesFile() throws IOException
	{
		Properties properties= new Properties();
		FileInputStream readfile=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		properties.load(readfile);
		return properties;
	}
	
	public static Properties invokeWebelementsPropertiesFile() throws IOException
	{
		Properties property= new Properties();
		FileInputStream readfile=new FileInputStream(System.getProperty("user.dir")+"\\webelements.properties");
		property.load(readfile);
		return property;
	}
	
	public static String setUp() throws IOException
	{
		properties = fromPropertiesFile();
		String browserName = properties.getProperty("browser");
		return browserName;
	}
	
	public static String setBrowser(String browser) throws IOException
	{
		String browserName = browser;
		return browserName;
	}
	
	public static WebDriver initializeParallelDriver(String browser) throws IOException, NullPointerException, InterruptedException
	{	
			properties = fromPropertiesFile();
			String grid = properties.getProperty("grid");
			String parallel = properties.getProperty("parallel");
			String parameter = properties.getProperty("parameter");

				String browserName;
				
				if(parameter.equals("on"))
					browserName = System.getProperty("browser");
				else
					if(parallel.equalsIgnoreCase("off"))
						browserName = setUp();
					else
						browserName = setBrowser(browser);
				System.out.println("********************************************************************");
				System.out.println(browserName);
				System.out.println("********************************************************************");
				
				
				try {
					
					if(grid.equals("on"))
					{
						DesiredCapabilities capabilities = null;
						if(browserName.equals("chrome"))
						{
							capabilities = DesiredCapabilities.chrome();
						}
						else if (browserName.equals("opera"))
						{
							capabilities = DesiredCapabilities.opera();
							capabilities.setBrowserName("operablink");
							capabilities.setPlatform(Platform.WINDOWS);
						}
						else if (browserName.equals("firefox"))
						{
							capabilities = DesiredCapabilities.firefox();
							capabilities.setBrowserName("firefox");
						}
						else if (browserName.equals("edge"))
						{
							capabilities = DesiredCapabilities.edge();
							capabilities.setBrowserName("MicrosoftEdge");
							capabilities.setPlatform(Platform.WINDOWS);
							capabilities.setVersion("83.0.478.44");
						}
						
						else
						{
							System.out.println("Invalid Browser");
						}
						driver=new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"), capabilities);
					}
					else
					{
						if(browserName.contains("chrome"))
						{http://192.168.0.107:4444/wd/hub
							WebDriverManager.chromedriver().setup();
							ChromeOptions options = new ChromeOptions();
							if(browserName.contains("headless"))
								options.addArguments("headless");
							driver = new ChromeDriver(options);
						}
						else if(browserName.contains("firefox"))
						{
							WebDriverManager.firefoxdriver().setup();
							FirefoxOptions options = new FirefoxOptions();
							if(browserName.contains("headless"))
								options.addArguments("headless");
							driver = new FirefoxDriver(options);
						}
						else if(browserName.contains("edge"))
						{
							WebDriverManager.edgedriver().setup();
							EdgeOptions options = new EdgeOptions();
							driver = new EdgeDriver(options);
						}
						else if(browserName.contains("opera"))
						{
							WebDriverManager.operadriver().setup();
							OperaOptions options = new OperaOptions();
							if(browserName.contains("headless"))
								options.addArguments("headless");
							driver = new OperaDriver();
						}
						else
						{
							System.out.println("Invalid Browser");
						}
					}

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				catch(Exception e) {
					logger.log(Status.FAIL, e.getMessage());
				}
				return driver;
			}
			
			public String setUrl() throws IOException, NullPointerException
			{
				
				properties = fromPropertiesFile();
				//setting url
				String url = properties.getProperty("url");
				System.out.println(url);
				System.out.println("********************************************************************");
					if(url.equalsIgnoreCase("https://bookmyshow.com/"))
					{
						System.out.println("Entering into BookMyShow");
					}
					else
					{
						System.out.println("Invalid URL");
						logger.log(Status.FAIL, "Invalid URL");
					}
				return url;
				
			}
			
			//taking screenshot
			public void takeScreenShotOnFailure() throws NullPointerException, Exception
			{
				//Convert web driver object to TakeScreenshot
				TakesScreenshot ts=(TakesScreenshot) driver;
				
				//Call getScreenshotAs method to create image file
				File source =ts.getScreenshotAs(OutputType.FILE);
				
				//Move image file to new destination
				File destinationFile = new File(System.getProperty("user.dir")+"\\Screenshots\\Screenshots" + DateUtils.getTimestamp() + ".png");
				try {
					//Move image file to new destination
					FileUtils.copyFile(source,(destinationFile));
					logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\Screenshots", DateUtils.getTimestamp() +".png");
				}
				catch(IOException e) {
					//trace the exception.
					e.printStackTrace();
				}
			}
			
			public void reportFail(String reportString, int row_num_1, String testtype) throws NullPointerException, Exception
			{
				try {
					logger.log(Status.FAIL, reportString);
				
					//Call take screenshot method
					takeScreenShotOnFailure();
				
					//send result to excel
					WriteDataToExcelUsingUtilClass.fail(row_num_1,testtype);
				}
				catch(NullPointerException e)
				{
					e.printStackTrace();
				}
			}
			
			public void reportPass(String reportString, int row_num_1, String testtype) throws NullPointerException, Exception
			{
				logger.log(Status.PASS, reportString);
				
				//send result to excel
				WriteDataToExcelUsingUtilClass.pass(row_num_1,testtype);
			}
}