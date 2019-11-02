package crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import crm.util.testUtil;

public class testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public testbase(){
		try{
			prop= new Properties();
		
			FileInputStream ip= new FileInputStream("D:\\Softwares\\JAVA\\NOTES\\crmFramework\\src\\main\\java\\crm\\config\\Config1.properties");
			prop.load(ip);
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void initialation() throws InterruptedException{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Softwares\\JAVA\\drivers\\chromedriver_win32_77ver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ff")){
			
			System.setProperty("webdriver.geko.driver","D:\\Softwares\\JAVA\\drivers\\gekodriver_win32_77ver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.page_load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
      //  Thread.sleep(3000);
        //driver.findElement(By.linkText("//shop.demoqa.com/my-account/")).click();
        
		
		
	}
	

}
