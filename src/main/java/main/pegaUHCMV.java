package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class pegaUHCMV {
	WebDriver driver;
	@FindBy(how = How.ID_OR_NAME,using = "USER")
	WebElement UserId;
	@FindBy(how = How.ID_OR_NAME,using = "PASSWORD")
	WebElement Password;
	@FindBy(how = How.XPATH,using = "//input[@value = 'Login']")
	WebElement LoginButton;
	
	public pegaUHCMV(WebDriver driver,String strUrl)
	{
		this.driver = driver;
		driver.get(strUrl);
		Reporter.log("user is navigated to "+strUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, pegaUHCMV.this);
		
	}
	
	public void LoginPega(String strUserName, String strPassword)
	{
		try
		{
			UserId.sendKeys(strUserName);
			System.out.println("username entered");
			Reporter.log("username entered");
		}catch(NoSuchElementException e)
		{
			System.out.println("username field not found");
			Reporter.log("username field not found");
		}
		
		try
		{
			Password.sendKeys(strPassword);
			System.out.println("Password entered");
			Reporter.log("Password entered");
		}catch(NoSuchElementException e)
		{
			System.out.println("Password field not found");
			Reporter.log("Password field not found");
		}
		try
		{
			LoginButton.click();;
			System.out.println("Login button clicked");
			Reporter.log("Login button clicked");
		}catch(NoSuchElementException e)
		{
			System.out.println("Login button not found");
			Reporter.log("Login button not found");
			
		}
		
		
	}
	
	
	

}
