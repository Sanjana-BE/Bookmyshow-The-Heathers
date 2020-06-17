package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import excel.TestData;
import setUp.BaseClass;

public class MoviesPage extends BaseClass {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	TestData d = new TestData();
	
	//initialize the elements of the Page Object or instantiate the Page Objects
	public MoviesPage(WebDriver driver){
		this.driver=driver;
		this.wait = new WebDriverWait(driver,30);
		PageFactory.initElements(driver, this);
	}
	
	//navigating back to movies page by handling windows.
	public void navigateToMoviesPage_and_Click_Movies() throws InterruptedException, IOException {
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String main = itr.next();
		driver.switchTo().window(main);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		property = invokeWebelementsPropertiesFile();
		
		String data = d.getWindow();
		
		WebElement element1 = driver.findElement(By.linkText(property.getProperty(data)));
		
		//Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		
		//Perform Click on Movies button using JavascriptExecutor
		executor2.executeScript("arguments[0].click();",element1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		String data1 = d.getMovieDisplay();
		
		//clicking on coming soon
		WebElement element = driver.findElement(By.linkText(property.getProperty(data1)));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
		
		//Perform scrolling down using JavascriptExecutor
		executor2.executeScript("window.scrollBy(0,500)");
		
	}
	
	//check whether the movies are displayed
	public String checkMoviesAreDisplayed() throws IOException, InterruptedException
	{
		String Movie;
		property = invokeWebelementsPropertiesFile();
		
		String data = d.getMoonth();
		
		//clicking on the month to check the visibility of movies
		driver.findElement(By.xpath(property.getProperty(data))).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//checks whether the movie is displayed
		Boolean moviedisplay = driver.findElement(By.xpath(property.getProperty("moviedisplay"))).isDisplayed();
		
		if(moviedisplay.equals(true))
			Movie="Displayed";
		else
			Movie="Not Displayed";
		
		return Movie;
	}
	
	//extracting the languages from menu items and storing in a list
	public int extractLanguage() throws IOException, InterruptedException {
		
		property = invokeWebelementsPropertiesFile();
		
		//creating object fro list
		List<String> languages = new ArrayList<String>();
		
		WebElement language1=driver.findElement(By.xpath(property.getProperty("language1")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages1 = language1.getText();
		//adding items to list
		languages.add(languages1);
		
		WebElement language2=driver.findElement(By.xpath(property.getProperty("language2")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages2 = language2.getText();
		//adding items to list
		languages.add(languages2);
		
		WebElement language3=driver.findElement(By.xpath(property.getProperty("language3")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages3 = language3.getText();
		//adding items to list
		languages.add(languages3);
		
		WebElement language4=driver.findElement(By.xpath(property.getProperty("language4")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages4 = language4.getText();
		//adding items to list
		languages.add(languages4);
		
		WebElement language5=driver.findElement(By.xpath(property.getProperty("language5")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages5 = language5.getText();
		//adding items to list
		languages.add(languages5);
		
		WebElement language6=driver.findElement(By.xpath(property.getProperty("language6")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages6 = language6.getText();
		//adding items to list
		languages.add(languages6);
		
		WebElement language7=driver.findElement(By.xpath(property.getProperty("language7")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages7 = language7.getText();
		//adding items to list
		languages.add(languages7);
		
		WebElement language8=driver.findElement(By.xpath(property.getProperty("language8")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages8 = language8.getText();
		//adding items to list
		languages.add(languages8);
		
		WebElement language9=driver.findElement(By.xpath(property.getProperty("language9")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages9 = language9.getText();
		//adding items to list
		languages.add(languages9);
		
		WebElement language10=driver.findElement(By.xpath(property.getProperty("language10")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages10 = language10.getText();
		//adding items to list
		languages.add(languages10);
		
		WebElement language11=driver.findElement(By.xpath(property.getProperty("language11")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages11 = language11.getText();
		//adding items to list
		languages.add(languages11);
		
		WebElement language12=driver.findElement(By.xpath(property.getProperty("language12")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages12 = language12.getText();
		//adding items to list
		languages.add(languages12);
		
		WebElement language13=driver.findElement(By.xpath(property.getProperty("language13")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages13 = language13.getText();
		//adding items to list
		languages.add(languages13);
		
		WebElement language14=driver.findElement(By.xpath(property.getProperty("language14")));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String languages14 = language14.getText();
		//adding items to list
		languages.add(languages14);
		
		System.out.println("********************************************************************");
		//printing the values stored in the list
		System.out.println(languages);
		
		int size = languages.size();
		return size;
		
	}
	
	public void displayLanguagesList()
	{
		System.out.println("********************************************************************");
		System.out.println("Languages Are Displayed");
		System.out.println("********************************************************************");
	}
}