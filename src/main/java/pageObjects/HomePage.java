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
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", location);
		}
		
		//clicking "not now" in the popup. xpath is taken from the properties file.
		public void popup() throws IOException, InterruptedException
		{
			property = invokeWebelementsPropertiesFile();
			notnow = d.getPopup();
			String popup = property.getProperty(notnow);
			WebElement element = driver.findElement(By.xpath(popup));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(5000);
		}
		
		//clicking the signin button. xpath is taken from the properties file.
		public void signinButton() throws IOException, InterruptedException
		{
			property = invokeWebelementsPropertiesFile();
			signinbutton = d.getSigninButton();
			String signin = property.getProperty(signinbutton);
			WebElement element = driver.findElement(By.linkText(signin));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(3000);
		}
		
		//clicking the continue-via-google button. xpath is taken from the properties file.
		public void selectContinueViaGoogle() throws IOException, InterruptedException
		{
			property = invokeWebelementsPropertiesFile();
			click = d.getContinueViaGoogleButton();
			String clickElement = property.getProperty(click);
			WebElement element = driver.findElement(By.xpath(clickElement));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			Thread.sleep(3000);
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
			Thread.sleep(2000);
			
			this.clicknext();
			Thread.sleep(2000);
			
			this.setPassword(strPassword);
			Thread.sleep(2000);
			
			this.clickPasswordNext();
			Thread.sleep(2000);
			
			driver.switchTo().window(main);
			Thread.sleep(2000);
		}
		
		public void invalidsignin(WebDriver driver, String strUserName, String strPassword) throws IOException, InterruptedException{
			
			Set<String> ids=driver.getWindowHandles();
			Iterator<String> itr=ids.iterator();
			String main=itr.next();
			String join=itr.next();
			driver.switchTo().window(join);
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;	
			
			this.setUserNameForInvalidTest(strUserName);
			Thread.sleep(2000);
			
			this.clickNext();
			Thread.sleep(2000);
			
			this.setInvalidPassword(strPassword);
			Thread.sleep(2000);
			
			this.clickSubmit();
			Thread.sleep(2000);
			
			properties = fromPropertiesFile();
			
			warningmessage = properties.getProperty("warningmessage");
			
			WebElement element = driver.findElement(By.xpath(warningmessage));
			Thread.sleep(2000);
			String errormessage = element.getText();
			
			System.out.println(errormessage);
			System.out.println("********************************************************************");
			
			driver.close();
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			
			this.clicknext();
			Thread.sleep(2000);
			
			properties = fromPropertiesFile();
			
			errormessage = properties.getProperty("errormessage");
			
			WebElement element = driver.findElement(By.xpath(errormessage));
			Thread.sleep(2000);
			String errormessage = element.getText();
			
			System.out.println(errormessage);
			System.out.println("********************************************************************");
			
			driver.close();
			Thread.sleep(2000);
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
		public void setUserName(String strUserName) throws IOException, InterruptedException{
			property = invokeWebelementsPropertiesFile();
			enter = d.getEmailField();
			String element = property.getProperty(enter);
			WebElement emailid = driver.findElement(By.xpath(element));
			wait.until(ExpectedConditions.elementToBeClickable(emailid));
			emailid.clear();
			Thread.sleep(2000);
			emailid.sendKeys(strUserName);
			Thread.sleep(2000);
		}
		
		//entering the password using sendkeys. xpath is taken from the properties file.
		public void setPassword(String strPassword) throws IOException, InterruptedException {
			property = invokeWebelementsPropertiesFile();
			enterPassword = d.getPasswordField();
			String element = property.getProperty(enterPassword);
			WebElement password = driver.findElement(By.name(element));
			wait.until(ExpectedConditions.elementToBeClickable(password));
			password.clear();
			Thread.sleep(2000);
			password.sendKeys(strPassword);
			Thread.sleep(2000);
		}
		
		//clicking next after entering the username. xpath is taken from the properties file.
		public void clicknext() throws IOException, InterruptedException{
			property = invokeWebelementsPropertiesFile();
			next = d.getEmailNext();
			String emailNext = property.getProperty(next);
			WebElement element = driver.findElement(By.xpath(emailNext));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		}
		
		//clicking next after entering the password. xpath is taken from the properties file.
		public void clickPasswordNext() throws IOException, InterruptedException {
			property = invokeWebelementsPropertiesFile();
			passwordNext = d.getPasswordNext();
			String passwordnext = property.getProperty(passwordNext);
			WebElement element = driver.findElement(By.xpath(passwordnext));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		}
		
		//entering the username using sendkeys. xpath is taken from the properties file.
		public void setUserNameForInvalidTest(String strUserName) throws IOException, InterruptedException{
			property = invokeWebelementsPropertiesFile();
			enter = d.getEmailField();
			String element = property.getProperty(enter);
			WebElement emailid = driver.findElement(By.xpath(element));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(emailid));
			Thread.sleep(2000);
			emailid.clear();
			Thread.sleep(2000);
			emailid.sendKeys(strUserName);
			Thread.sleep(2000);
		}
				
		//entering the password using sendkeys. xpath is taken from the properties file.
		public void setInvalidPassword(String strPassword) throws IOException, InterruptedException {
			property = invokeWebelementsPropertiesFile();
			enterPassword = d.getPasswordTextBox();
			String element = property.getProperty(enterPassword);
			WebElement password = driver.findElement(By.xpath(element));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(password));
			Thread.sleep(2000);
			password.clear();
			Thread.sleep(2000);
			password.sendKeys(strPassword);
			Thread.sleep(2000);
		}
				
		//clicking next after entering the username. xpath is taken from the properties file.
		public void clickNext() throws IOException, InterruptedException{
			property = invokeWebelementsPropertiesFile();
			next = d.getEmailNext();
			String emailNext = property.getProperty(next);
			WebElement element = driver.findElement(By.xpath(emailNext));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		}
				
		//clicking next after entering the password. xpath is taken from the properties file.
		public void clickSubmit() throws IOException, InterruptedException {
			property = invokeWebelementsPropertiesFile();
			passwordNext = d.getSubmit();
			String passwordnext = property.getProperty(passwordNext);
			WebElement element = driver.findElement(By.xpath(passwordnext));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Thread.sleep(2000);
			element.click();
			Thread.sleep(2000);
		}
}
