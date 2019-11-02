package crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import crm.base.testbase;

public class loginpage extends testbase {
	
	
   @FindBy(xpath="//a[text()='My Account']")
    WebElement myAccountlink;

	@FindBy(id="username")
	WebElement user_login;
	
	@FindBy(id="password")
	WebElement user_pass;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	
	
	public loginpage(){
		PageFactory.initElements(driver, this);
	}

	
	public String validateloginPage(){
		return driver.getTitle();
	}
	
	public String loginPageUrl(){
		return driver.getCurrentUrl();
		
	}
	
	public homePage login(String un,String ps){
		myAccountlink.click();
		user_login.sendKeys(un);
		user_pass.sendKeys(ps);
		loginbtn.click();
		
		return new homePage();
		
	}
	 
		
	
}
