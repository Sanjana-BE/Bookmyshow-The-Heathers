package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ActualValues {

	public static WebDriver driver;
	
	//initialize the elements of the Page Object or instantiate the Page Objects

	public ActualValues(WebDriver driver){

		this.driver=driver;

		PageFactory.initElements(driver, this);

	}

	//getting the title and storing in a string

	public String getMainPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String mainPageTitle=driver.getTitle();

		System.out.println("********************************************************************");

		System.out.println(driver.getTitle());

		System.out.println("********************************************************************");

		return mainPageTitle;

	}

	//getting the titile of Sports page and storing in a string

	public String getSportsPage() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String sportsPageTitle=driver.getTitle();

		System.out.println("********************************************************************");

		System.out.println(driver.getTitle());

		System.out.println("********************************************************************");

		return sportsPageTitle;

	}

}