package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import excel.TestData;
import pageObjects.HomePage;
import pageObjects.MoviesPage;
import pageObjects.SportsPage;
import setUp.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.Status;

public class TestCases extends BaseClass{
	
	//object creation for main classes
	
	ActualValues objmainpage;
	HomePage objHomePage;
	SportsPage objSportsPage;
	MoviesPage objMoviesPage;
	//driver initialization
	public static WebDriver driver;
	
	private static Logger log = (Logger) LogManager.getLogger(TestCases.class.getName());
	
	@BeforeClass
	public void setup()throws IOException {
		System.out.println("********************************************************************");
		System.out.println("BOOKMYSHOW AUTOMATION");
		System.out.println("********************************************************************");
		System.out.println("THE HEATHERS");
		System.out.println("********************************************************************");
		
	}
	
	@Test(priority=0)
	@Parameters("browser")
	public void Test_Browser_And_URL_Invoked_Correctly(@Optional String browser) throws NullPointerException, Exception {
		
		//report creation
		logger = report.createTest("Test_Browser_And_URL_Invoked_Correctly");
		//row number to write the results in excel sheet
		int rownum=2;
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		try {
			
			//invoke browser
			driver=BaseClass.initializeParallelDriver(browser);
			
			log.info("Browser is invoked");
			
			//launching the site
			driver.get(setUrl());
			
			log.info("Website is launched");
			
			reportPass("Expected Result:Browser should be invoked and should enter into BookMyShow, Actual Result:Browser is invoked and entered into BookMyShow",rownum, testtype);
			Thread.sleep(4000);
			
			//maximize the browser window
			driver.manage().window().maximize();
			
			log.info("Browser window is maximized");
			
			Thread.sleep(4000);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum, testtype);
		}
	}
	
	@Test(priority=1)
	public void Test_MainPage_Title_Matches_Correctly() throws IOException, Exception
	{
		//to check whether the expected page and actual page are same,
		//check the expected page title with actual page title using assert
		
		//report creation
		logger = report.createTest("Test_MainPage_Title_Matches_Correctly");
		
		//row number to write the results in excel sheet
		int rownum=3;
		
		//test type to write the results in excel sheet
		String testtype="REGRESSION";
		
		//creating object for TestData class
		TestData d = new TestData();
		
		this.objmainpage = new ActualValues(driver);
		
		//storing the title in a string
		String pagetitle = objmainpage.getMainPage();
		
		log.info("Page Title is stored in a string");
		
		try {
			Thread.sleep(3000);
			
			//comparing the actual value with the expected value
			Assert.assertTrue(pagetitle.contains(d.getGeneralTitle()));
			
			reportPass("Actual Title :" + pagetitle + "-equals to Expected Title :" + d.getGeneralTitle(),rownum, testtype);
			logger.log(Status.INFO, "Main Page Title Matches Correctly");
		}
		catch(AssertionError e)
		{
			reportFail(e.getMessage(),rownum, testtype);
		}
	}

	@Test(priority=2)
	public void Test_City_Is_Selected_Correctly() throws IOException, Exception
	{
		//report creation
		logger = report.createTest("Test_City_Is_Selected_Correctly");
		
		//row number to write the results in excel sheet
		int rownum=4;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		this.objHomePage = new HomePage(driver);
		
		try {
			//calling the selectarea() method in HomePage class
			objHomePage.selectArea();
			
			log.info("City is selected");
			
			reportPass("Expected Result:City should be selected, Actual Result:City is selected",rownum,testtype);
		
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
		
	}
	
	@Test(priority=3)
	public void Test_Popup_Is_Ignored() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Popup_Is_Ignored");
		
		//rownum to write the results in excel sheet
		int rownum=5;
		
		//testtype to write the results in excel sheet
		String testtype="SMOKE";
		
		this.objHomePage = new HomePage(driver);
		
		try {
			//calling the popup() method in HomePage class
			objHomePage.popup();
			
			log.info("Not now is clicked");
			
			reportPass("Expected Result:Popup should be ignored, Actual Result:Popup is ignored",rownum, testtype);
		}
		catch (IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	
	}
	
	@Test(priority=4)
	public void Test_Signin_Button_Is_clicked() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Signin_Button_Is_clicked");
		
		//rownum to write the results in excel sheet
		int rownum=6;
		
		//test type to write results in excel sheet
		String testtype="SMOKE";
		
		try {
			this.objHomePage = new HomePage(driver);
			
			//calling the signinButton() method in HomePage class
			objHomePage.signinButton();
			
			log.info("Sign-in button is clicked");
				
			reportPass("Expected Result:Sign-in button should be clicked, Actual Result:Sign-in button is clicked",rownum,testtype);
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=5)
	public void Test_Continue_Via_Google_Button_Is_Clicked() throws IOException, Exception
	{
		
		//report creation
		logger = report.createTest("Test_Continue_Via_Google_Button_Is_Clicked");
		
		//rownum to write the results in excel sheet
		int rownum=7;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		this.objHomePage = new HomePage(driver);
		
		try {
			
			//calling the selectContinueViaGoogle() method in HomePage class
			objHomePage.selectContinueViaGoogle();
			
			log.info("Continue-via-google is clicked");
			
			reportPass("Expected Result:Continue-via-google should be clicked, Actual Result:Continue-via-google is clicked",rownum,testtype);
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=6)
	public void Test_Invalid_UserName() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Invalid_UserName");
		
		//rownum to write the results in excel sheet
		int rownum=8;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		TestData d = new TestData();
		
		try {
			this.objHomePage = new HomePage(driver);
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidUserName(driver, d.getInvalidUsername(), d.getInvalidPassword());
			
			log.info("Sign-in unsuccessful");
			
			reportPass("Expected Result:Sign-in should be unsuccessful, Actual Result:Sign-in unsuccessful",rownum,testtype);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=7)
	public void Test_Invalid_Password() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Invalid_Password");
		
		//rownum to write the results in excel sheet
		int rownum=9;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		TestData d = new TestData();
		
		try {
			this.objHomePage = new HomePage(driver);
			
			objHomePage.selectContinueViaGoogle();
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidsignin(driver, d.getvalidUsername(), d.getInvalidPassword());
			
			log.info("Sign-in unsuccessful");
			
			reportPass("Expected Result:Sign-in should be unsuccessful, Actual Result:Sign-in unsuccessful",rownum,testtype);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=8)
	public void Test_Blank_UserName() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Blank_UserName");
		
		//rownum to write the results in excel sheet
		int rownum=10;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		TestData d = new TestData();
		
		try {
			this.objHomePage = new HomePage(driver);
			
			objHomePage.selectContinueViaGoogle();
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidUserName(driver, d.getBlankUsername(), d.getPassword());
			
			log.info("Sign-in unsuccessful");
			
			reportPass("Expected Result:Sign-in should be unsuccessful, Actual Result:Sign-in unsuccessful",rownum,testtype);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=9)
	public void Test_Blank_Password() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Blank_Password");
		
		//rownum to write the results in excel sheet
		int rownum=11;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		TestData d = new TestData();
		
		try {
			this.objHomePage = new HomePage(driver);
			
			objHomePage.selectContinueViaGoogle();
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.invalidsignin(driver, d.getValidUsernameForBlankPassword(), d.getBlankPassword());
			
			log.info("Sign-in unsuccessful");
			
			reportPass("Expected Result:Sign-in should be unsuccessful, Actual Result:Sign-in unsuccessful",rownum,testtype);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=10)
	public void Test_Signing_In_Appears_Correctly() throws IOException, InterruptedException, Exception
	{
		//report creation
		logger = report.createTest("Test_Signing_In_Appears_Correctly");
		
		//rownum to write the results in excel sheet
		int rownum=12;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		TestData d = new TestData();
		
		try {
			this.objHomePage = new HomePage(driver);
			
			objHomePage.selectContinueViaGoogle();
			
			//getting the username and password from excel and passing as parameters to signin() method in HomePage
			objHomePage.validsignin(driver, d.getUsername(), d.getPassword());
			
			log.info("Sign-in successful");
			
			reportPass("Expected Result:Sign-in should be successful, Actual Result:Sign-in successful",rownum,testtype);
		}
		catch(IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=11)
	public void Test_Sports_Is_Clicked() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Sports_Is_Clicked");
		
		//rownum to write the results in excel sheet
		int rownum=13;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		try {
			this.objHomePage = new HomePage(driver);
			
			//calling the click_sports() method in HomePage
			objHomePage.click_Sports();
			
			log.info("Sports is clicked");
			
			Thread.sleep(3000);
			
			this.objmainpage = new ActualValues(driver);
			
			//storing the title in a string
			String pagetitle = objmainpage.getSportsPage();
			
			log.info("Page Title is stored in a string");
			
			TestData d = new TestData();
			
			//comparing the actual value with the expected value
			Assert.assertTrue(pagetitle.contains(d.getTitle()));
			Thread.sleep(5000);
			
			reportPass("Expected Result:Sports should be clicked, Actual Result:Sports is clicked",rownum,testtype);
		}
		catch(NullPointerException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=12)
	public void Test_Sports_Available_Are_Displayed() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Sports_Available_Are_Displayed");
		
		//rownum to write the results in excel sheet
		int rownum=14;
		
		//testtype to write the results in excel sheet
		String testtype="REGRESSION";
		
		TestData d = new TestData();
		
		this.objSportsPage = new SportsPage(driver);
		try {
			Thread.sleep(3000);
			
			String result = objSportsPage.gettitle1();
			if(result.equals("Displayed"))
				reportPass("Expected Result:Sports activities should be displayed, Actual Result:Sports activities are displayed",rownum,testtype);
			else
				reportPass("Expected Result:Sports activities should be changed, Actual Result:Sports activities changes",rownum,testtype);
			log.info("Expected Results matches Actual Results");
		}
		catch(NullPointerException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=13)
	public void Test_Weekend_Is_clicked() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Weekend_Is_clicked");
		
		//rownum to write the results in excel sheet
		int rownum=15;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		
		this.objSportsPage = new SportsPage(driver);
		
		try {
			
			//calling the selectweekend() method in SportsPage
			objSportsPage.selectWeekend();
			
			log.info("Weekend is clicked");
			
			Thread.sleep(3000);
			reportPass("Expected Result:Weekend should be clicked, Actual Result:Weekend is clicked",rownum,testtype);
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=14)
	public void Test_Sports_Availabe_Are_Displayed_After_Selecting_Weekend() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Sports_Availabe_Are_Displayed_After_Selecting_Weekend");
		
		//rownum to write the results in excel sheet
		int rownum=16;
		
		//testtype to write the results in excel sheet
		String testtype="REGRESSION";
		
		this.objSportsPage = new SportsPage(driver);
		try {
			TestData d = new TestData();
			Thread.sleep(3000);
			
			String result = objSportsPage.gettitle3();
			if(result.equals("Displayed"))
				reportPass("Expected Result:Upcoming sports for the weekend should be displayed, Actual Result:Upcoming sports activities for the weekend are displayed",rownum,testtype);
			else
				reportPass("Expected Result:Sports activities should be changed, Actual Result:Sports activities changes",rownum,testtype);			
			log.info("Expected Results matches Actual Results");
		} catch (Exception e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=15)
	public void Test_PriceRange_Is_clicked() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_PriceRange_Is_clicked");
		
		//rownum to write results in excel sheet
		int rownum=17;
		
		//testtype to write results in excel sheets
		String testtype="SMOKE";
		
		this.objSportsPage = new SportsPage(driver);
		Thread.sleep(3000);
		
		try {
			//calling clickPriceRange() method in SportsPage class
			objSportsPage.clickPriceRange();
			
			log.info("Price Range is clicked");
			
			reportPass("Expected Result:PriceRange should be clicked, Actual Result:PriceRange is clicked",rownum,testtype);
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=16)
	public void Test_Minimum_Is_clicked() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Minimum_Is_clicked");
		
		//rownum to write results in excel sheet
		int rownum=18;
		
		//testtype t write results in excel sheet
		String testtype="SMOKE";
		
		this.objSportsPage = new SportsPage(driver);
		
		try {
			
			Thread.sleep(3000);
			
			//calling clickMinimumRange) method in SportsPage class
			objSportsPage.clickMinimumRange();
			
			log.info("Minimum Range is clicked");
			
			reportPass("Expected Result:Minimum range should be clicked, Actual Result:Minimum range is clicked",rownum,testtype);
		}
		catch (IOException e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=17)
	public void Test_Sports_Availabe_Are_Displayed_After_Selecting_MinimumRange() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Sports_Availabe_Are_Displayed_After_Selecting_MinimumRange");
		
		//row num to write the results in excel sheet
		int rownum=19;
		
		//test type to write the results in excel sheet
		String testtype="REGRESSION";
		
		TestData d=new TestData();
		this.objSportsPage = new SportsPage(driver);
		try {
			Thread.sleep(3000);
			//printing the titile
			System.out.println(objSportsPage.gettitle2());
			System.out.println("********************************************************************");
			System.out.println(objSportsPage.gettitle4());
			System.out.println("********************************************************************");
			System.out.println(objSportsPage.gettitle5());
			System.out.println("********************************************************************");
			/*
			System.out.println(objSportsPage.gettitle6());
			System.out.println("********************************************************************");
			System.out.println(objSportsPage.gettitle7());
			System.out.println("********************************************************************");*/
			System.out.println("END OF SPORTS ACTIVITIES");
			System.out.println("********************************************************************");
			
			log.info("Sports activities are displayed");
			
			//comparing the actual value with expected value
			String sports = objSportsPage.gettitle3();
			if(sports.equalsIgnoreCase("Displayed")) {
				Thread.sleep(3000);
				reportPass("Expected Result:Upcoming weekend sports activities with the lowest price should be displayed, Actual Result:Upcoming weekend sports activities with the lowest price are displayed",rownum,testtype);
			}
		}
		catch (Exception e) {
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=18)
	public void Test_Window_Navigates_To_Movie_Page() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Window_Navigates_To_Movie_Page");
		
		//row num to write the results in excel sheet
		int rownum=20;
		
		//test type to write the results in excel sheet
		String testtype="SMOKE";
		this.objMoviesPage = new MoviesPage(driver);
		
		try {
			Thread.sleep(10000);
			
			//calling navigateToMoviesPage_and_Click_Movies() method in MoviesPage class
			objMoviesPage.navigateToMoviesPage_and_Click_Movies();
			
			log.info("Navigated to Movies Page");
			
			reportPass("Expected Result:Should be navigated to the Movies Page, Actual Result:Navigated to Movies Page",rownum,testtype);
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=19)
	public void Test_Movies_Are_Displayed() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Movies_Are_Displayed");
		
		//row num to write results in excel sheet
		int rownum=21;
		
		//test type to write results in excel sheet
		String testtype="REGRESSION";
		
		this.objMoviesPage = new MoviesPage(driver);
		try {
			//storing the value in a string by calling checkMoviesAreDisplayed() method in MoiesPage
			String result = objMoviesPage.checkMoviesAreDisplayed();
			if(result.equals("Displayed"))
			{
				log.info("Expected Results matches Actual Results");
				reportPass("Expected Result:Movies should be displayed, Actual Result:Movies are displayed",rownum,testtype);
			}
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=20)
	public void Test_Languages_Are_Extracted_And_Stored_In_List() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Languages_Are_Extracted_And_Stored_In_List");
		
		//rownum to write the results in excel sheet
		int rownum=22;
		String testtype="SMOKE";
		
		this.objMoviesPage = new MoviesPage(driver);
		
		try {
			//calling extractLanguages() method in MoviesPage class
			int size = objMoviesPage.extractLanguage();
			
			if(size==14)
			{
				log.info("Languages are extracted");
				reportPass("Expected Result:Movie languages should be extracted, Actual Result:Movie languages are extracted",rownum,testtype);
			}
			else
			{
				reportFail("Languages are not extracted", rownum, testtype);
			}
		}
		catch(IOException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@Test(priority=21)
	public void Test_Languages_Are_Displayed() throws IOException, Exception, InterruptedException
	{
		//report creation
		logger = report.createTest("Test_Languages_Are_Displayed");
		
		//rownum to write data in excel sheet
		int rownum=23;
		
		//test type to write data in excel sheet
		String testtype="REGRESSION";
		
		this.objMoviesPage = new MoviesPage(driver);
		
		try {
			
			//calling the displayLanguagesList() method in MoviesPage class
			objMoviesPage.displayLanguagesList();
			
			reportPass("Expected Result:Movie languages should be printed, Actual Result:Movie languages are printed",rownum,testtype);
			log.info("Expected Results matches Actual Results");
			
		}
		catch(NullPointerException e)
		{
			reportFail(e.getMessage(),rownum,testtype);
		}
	}
	
	@AfterClass
	public void exit() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			//trace the exception
			e.printStackTrace();
		}
		report.flush();
		driver.quit();
	}
	
}