package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage  {
	
	public OverviewPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//h1[normalize-space()='Accounts Overview']") WebElement accountqverview;
@FindBy(xpath="//a[normalize-space()='Log Out']") WebElement logout;

 public String validateAccountOverView() 
 {
	  String aacview=accountqverview.getText();
	  return aacview;
 }
 public boolean isAccountOverViewExists() 
 {
	 try{
		 return (accountqverview.isDisplayed());
	 }catch(Exception p) {return false;}
 }
 public void click_Logout() 
 {
	 try{
		 logout.click();
	 }catch(Exception p) {}
 }
 
}
