package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement loginbtn;
	
	public void clickRigister()
	{
		linkRegister.click();
	}
	public void setUsername(String un)
	{
		username.sendKeys(un);;
	}
	public void setpassword(String pwd)
	{
		password.sendKeys(pwd);;
	}
	public void clicklogin()
	{
		loginbtn.click();
	}

}
