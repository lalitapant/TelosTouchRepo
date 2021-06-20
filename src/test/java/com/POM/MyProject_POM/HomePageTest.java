package com.POM.MyProject_POM;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.POM.qa.base.TestBase;
import com.POM.qa.pages.ContactsPage;
import com.POM.qa.pages.HomePage;
import com.POM.qa.pages.LoginPage;
import com.POM.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before class -- launch the browser and login
	//@test -- execute test case
	//after class-- close the browser
	
	@BeforeClass
	public void setUp() {
		initialization();
		
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		//testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
