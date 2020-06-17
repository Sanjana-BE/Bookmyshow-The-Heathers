package pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import excel.TestData;
import setUp.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

		/**
		 * All WebElements are identified by property file
		 */
		
		public WebDriver driver;
		public WebDriverWait wait;
		
		static TestData d = new TestData();
		
		private static String selectcity, notnow, signinbutton, click, warningmessage, errormessage, clickSports, clickall, enter, enterPassword, next, passwordNext;
		
		//initialize the elements of the Page Object or instantiate the Page Objects
		public HomePage(WebDriver driver){
			this.driver=driver;
			this.wait = new WebDriverWait(driver,30);
			PageFactory.initElements(driver, this);
		}
		
		//clicking the required location. xpath is taken from the properties file.
		public void selectArea() throws IOException
		{
			property = invokeWebelementsPropertiesFile();
			selectcity = d.getCity();
			String city = property.getProperty(selectcity);
			WebElement location = driver.findElement(By.linkText(city));
			wait.until(ExpectedConditions.visibilityOf(location));
			location.click();
		}
		
		//clicking "not now" in the popup. xpath is taken from the properties file.
		public void popup() throws IOException
		{
			property = invokeWebelementsPropertiesFile();
			notnow = d.getPopup();
			String popup = property.getProperty(notnow);
			WebElement element = driver.findElement(By.xpath(popup));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}
		
		//clicking the signin button. xpath is taken from the properties file.
		public void signinButton() throws IOException
		{
			property = invokeWebelementsPropertiesFile();
			signinbutton = d.getSigninButton();
			String signin = property.getProperty(signinbutton);
			WebElement element = driver.findElement(By.linkText(signin));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element.click();
		}
		
		//clicking the continue-via-google button. xpath is taken from the properties file.
		public void selectContinueViaGoogle() throws IOException
		{
			property = invokeWebelementsPropertiesFile();
			click = d.getContinueViaGoogleButton();
			String clickElement = property.getProperty(click);
			WebElement element = driver.findElement(By.xpath(clickElement));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element.click();
		}
		
		//signing in to bookmyshow by handling the windows
		public void validsignin(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{
			
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> itr=ids.iterator();
			String main=itr.next();
			String join=itr.next();
			driver.switchTo().window(join);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	
			
			this.setUserName(strUserName);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.clicknext();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.setPassword(strPassword);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.clickPasswordNext();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.switchTo().window(main);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		
		public void invalidsignin(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{
			
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> itr=ids.iterator();
			String main=itr.next();
			String join=itr.next();
			driver.switchTo().window(join);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	
			
			this.setUserName(strUserName);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.clicknext();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.setPassword(strPassword);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.clickPasswordNext();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			properties = fromPropertiesFile();
			
			warningmessage = properties.getProperty("warningmessage");
			
			WebElement element = driver.findElement(By.xpath(warningmessage));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String errormessage = element.getText();
			
			System.out.println(errormessage);
			System.out.println("********************************************************************");
			
			driver.close();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(main);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		
		public void invalidUserName(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{
			
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> itr=ids.iterator();
			String main=itr.next();
			String join=itr.next();
			driver.switchTo().window(join);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	
			
			this.setUserName(strUserName);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			this.clicknext();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			properties = fromPropertiesFile();
			
			errormessage = properties.getProperty("errormessage");
			
			WebElement element = driver.findElement(By.xpath(errormessage));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String errormessage = element.getText();
			
			System.out.println(errormessage);
			System.out.println("********************************************************************");
			
			driver.close();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().window(main);
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		}
		
		public void click_Sports() throws InterruptedException, IOException 
		{
			property = invokeWebelementsPropertiesFile();
			
			clickSports = d.getSports();
			
			WebElement element = driver.findElement(By.xpath(property.getProperty(clickSports)));
			
			//Creating the JavascriptExecutor interface object by Type casting
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			
			//Perform Click on Sports button using JavascriptExecutor
			executor.executeScript("arguments[0].click();", element);
			
			//navigate to all
			
			clickall = d.getDisplay();
			
			String clickAll = property.getProperty(clickall);
			
			WebElement elementToClick = driver.findElement(By.xpath(clickAll));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			elementToClick.click();

			//Perform scrolling down using JavascriptExecutor
			executor.executeScript("window.scrollBy(0,500)");
			
		}
		
		//entering the username using sendkeys. xpath is taken from the properties file.
		public void setUserName(String strUserName) throws IOException{
			property = invokeWebelementsPropertiesFile();
			enter = d.getEmailField();
			String element = property.getProperty(enter);
			WebElement emailid = driver.findElement(By.xpath(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			emailid.clear();
			emailid.sendKeys(strUserName);
		}
		
		//entering the password using sendkeys. xpath is taken from the properties file.
		public void setPassword(String strPassword) throws IOException {
			property = invokeWebelementsPropertiesFile();
			enterPassword = d.getPasswordField();
			String element = property.getProperty(enterPassword);
			WebElement password = driver.findElement(By.name(element));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			password.clear();
			password.sendKeys(strPassword);
		}
		
		//clicking next after entering the username. xpath is taken from the properties file.
		public void clicknext() throws IOException{
			property = invokeWebelementsPropertiesFile();
			next = d.getEmailNext();
			String emailNext = property.getProperty(next);
			WebElement element = driver.findElement(By.xpath(emailNext));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element.click();
		}
		
		//clicking next after entering the password. xpath is taken from the properties file.
		public void clickPasswordNext() throws IOException {
			property = invokeWebelementsPropertiesFile();
			passwordNext = d.getPasswordNext();
			String passwordnext = property.getProperty(passwordNext);
			WebElement element = driver.findElement(By.xpath(passwordnext));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			element.click();
		}
		
}