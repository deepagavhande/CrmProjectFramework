package crmTestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crm.base.testbase;
import crm.pages.loginpage;
import crm.pages.homePage;

public class loginTest extends testbase {
	
	loginpage login;
	homePage homePage;
	
	public loginTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		initialation();
		login = new loginpage();
	
	}
	
  @Test
  public void loginpageTest() {
	  String pageTitle=login.validateloginPage();
	 
	 Assert.assertEquals(pageTitle, "ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site");
  }
  
  /*@Test
  public void logipageUrlTest(){
	  String url=login.loginPageUrl();
	  Assert.assertEquals(url, "http://shop.demoqa.com/my-account/");
  }*/
  
  
  @Test

  public void loginTest(){
	homePage=login.login(prop.getProperty("username"), prop.getProperty("password"));
	  
  }
  @AfterMethod
  public void tearDown(){
	  driver.quit();
  }
}
