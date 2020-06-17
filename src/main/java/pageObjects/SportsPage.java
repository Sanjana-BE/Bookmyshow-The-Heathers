package pageObjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import excel.TestData;
import setUp.BaseClass;
import org.openqa.selenium.By;

public class SportsPage extends BaseClass {
	public WebDriver driver;
	public WebDriverWait wait;
	
	private static String elementWeekend, elementPriceRange, elementMinimumRange;
	
	TestData d = new TestData();
	
	//initialize the elements of the Page Object or instantiate the Page Objects
	public SportsPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver,15);
		PageFactory.initElements(driver, this);
	}
	
	//select weekend and the required xpath is taken from the properties file.
	public void selectWeekend() throws IOException {
		property = invokeWebelementsPropertiesFile();
		elementWeekend = d.getWeekend();
		String data = property.getProperty(elementWeekend);
		WebElement element = driver.findElement(By.xpath(data));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//click price-range dropdown box. the required xpath is taken from the properties file.
	public void clickPriceRange() throws IOException {
		property = invokeWebelementsPropertiesFile();
		elementPriceRange = d.getPriceRange();
		String data = property.getProperty(elementPriceRange);
		WebElement element = driver.findElement(By.xpath(data));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//select minimu range from the dropdown box. the required xpath is taken from the properties file.
	public void clickMinimumRange() throws IOException {
		property = invokeWebelementsPropertiesFile();
		elementMinimumRange = d.getMinimumRange();
		String data = property.getProperty(elementMinimumRange);
		WebElement element = driver.findElement(By.xpath(data));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element.click();
	}
	
	//getting the name of the sports activity displayed. the required xpath is taken from the properties file.
	public String gettitle1() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		String sports;
		String title1 = property.getProperty("title1");
		WebElement element =  driver.findElement(By.xpath(title1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean sportsDisplay = element.isDisplayed();
		if(sportsDisplay.equals(true))
		{
			sports="Displayed";
		}
		else
			sports="Not_Displayed";
		return sports;
	}
	
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle2() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		String title2 = property.getProperty("title2");
		WebElement element =  driver.findElement(By.xpath(title2));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return element.getText();
	}
	
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle3() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		String sports;
		String title = property.getProperty("title3");
		WebElement element = driver.findElement(By.xpath(title));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean sportsDisplay = element.isDisplayed();
		if(sportsDisplay.equals(true))
		{
			sports="Displayed";
		}
		else
			sports="Not_Displayed";
		return sports;
	}
	
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle4() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		String title = property.getProperty("title4");
		WebElement element =  driver.findElement(By.xpath(title));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return element.getText();
	}
	
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle5() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		String title = property.getProperty("title5");
		WebElement element =  driver.findElement(By.xpath(title));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	/*	
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle6() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		WebElement element =  driver.findElement(By.xpath(property.getProperty("title6")));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
		
	//getting the name of the sports activities displayed after applying the filters. the required xpath is taken from the properties file.
	public String gettitle7() throws IOException, InterruptedException {
		property = invokeWebelementsPropertiesFile();
		WebElement element =  driver.findElement(By.xpath(property.getProperty("title7")));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}*/
}