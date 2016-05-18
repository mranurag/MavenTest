package main;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PegaBPM_HomePage {
	public WebDriver driver;
	//@FindBy(how = How.XPATH,using ="//a[@title ='Exit PRPC'")
	@FindBy(how = How.LINK_TEXT,using = "Logout")
	WebElement logOutBtn;
	public PegaBPM_HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, PegaBPM_HomePage.this);
	}
	
	public String checkLogOutButton()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
			return logOutBtn.getText();
			
		}catch(NoSuchElementException e)
		{
			return "Logout button is not found";
		}
	}

}
