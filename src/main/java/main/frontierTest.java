package main;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class frontierTest {
WebDriver driver;
@FindBy(how = How.CSS, using ="img[alt^='UnitedHealth']")
static WebElement companyLogo;
@FindBy(how = How.XPATH , using ="//input[@value = 'Search']" )
static WebElement searchButton;
@FindBy (how = How.ID,using = "frontier_search_input")
static WebElement searchField;
public frontierTest()
{
	
}
public frontierTest(WebDriver driver,String url)
{
	
	this.driver = driver;
	driver.get(url);
	Reporter.log("user is navigated to "+url);
	PageFactory.initElements(driver, frontierTest.class);
}

public String checkLogoContent()
{
	try 
	{
	//WebElement companyLogo = driver.findElement(By.cssSelector("img[alt^='UnitedHealth']"));
	String appearingText = companyLogo.getAttribute("alt");
	return appearingText;
	}catch(NoSuchElementException e)
	{
		return "element not found";
	}
	
}


}
