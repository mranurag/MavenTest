package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import main.PegaBPM_HomePage;
import main.frontierTest;
import main.pegaUHCMV;

public class FirstTest
{
	static final Logger logger = Logger.getLogger(FirstTest.class);
    WebDriver driver; 
	String appURL = "http://google.com";
	pegaUHCMV pega;
	PegaBPM_HomePage pegaBPM;
@Parameters("browserType")
@BeforeMethod
public void testSetUp(String browserType) {
	browserType  =browserType;
	if(browserType.equalsIgnoreCase("IE"))
	{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	System.setProperty("webdriver.ie.driver", "C:/Users/adubey15/Desktop/Eclipse/IEDriverServer.exe");
	//System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
	 driver = new InternetExplorerDriver(cap);
	 Reporter.log("Test is being run on Internet explorer");
	}
	else if (browserType.equalsIgnoreCase("CHROME")) 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/adubey15/Desktop/Eclipse/chromedriver.exe");
		driver = new ChromeDriver(); 
		 Reporter.log("Test is being run on Google chrome");
	}
	else
	{
		driver = new FirefoxDriver();
		 Reporter.log("Test is being run on Firefox");
	}
	
	

	
}

@Test(priority = 1)
public void checkLogo()
{
	frontierTest ft = new frontierTest(driver,"http://frontier.uhg.com/Pages/Home.aspx");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	String logoContent = ft.checkLogoContent();
	System.out.println("content is "+logoContent);
	Reporter.log("content is "+logoContent);
	
}
@Test(priority  =2)
public void CheckSucceefulLoginPega()
{
	pega = new pegaUHCMV(driver, "http://apsrt0397.uhc.com:18080/prweb/PRServletCustom/gMVid57gBjakhHQ70L5bPe4L8Es5cI8B*/!STANDARD?");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	pega.LoginPega("adubey15", "_Welcome9");
	pegaBPM  =new PegaBPM_HomePage(driver);
	String chkText = pegaBPM.checkLogOutButton();
	System.out.println(chkText);
}

@AfterMethod
public void kill()
{
	
	driver.quit();
	
}

	
}
