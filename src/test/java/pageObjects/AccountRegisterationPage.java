package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterationPage extends BasePage {
	
	public AccountRegisterationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="customer.username") WebElement Username;
	
	@FindBy(id="customer.firstName") WebElement FirstName;
	
	@FindBy(id="customer.lastName") WebElement LastName;
	
	@FindBy(id="customer.address.street") WebElement Address;
	
	@FindBy(id="customer.address.city") WebElement City;
	
	@FindBy(id="customer.address.state") WebElement State;
	
	@FindBy(id="customer.address.zipCode") WebElement ZipCode;
	
	@FindBy(id="customer.phoneNumber") 	WebElement SSN; 	
	
	@FindBy(id="customer.ssn") WebElement Phone ;
	 	
	@FindBy(id="customer.password") WebElement Password;
	
	@FindBy(id="repeatedPassword") WebElement ConfirmPassword;
	
	@FindBy(xpath="//input[@value='Register']") WebElement registerbtn;
	
	@FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]") WebElement confirmationmsg;


	
	public void setUserName(String user_name)
	{
		Username.sendKeys(user_name);
	}
	
	public void setFirstName(String first_name)
	{
			FirstName.sendKeys(first_name);
	}
	
	public void setAddress(String Address1)
	{
		Address.sendKeys(Address1);
	}
	
	public void setLastName(String Last_Name)
	{
		LastName.sendKeys(Last_Name);
	}
	
	public void setCity(String new_city)
	{
		City.sendKeys(new_city);
	}
	public void setState(String new_state)
	{
			State.sendKeys(new_state);
	}
	
	public void setZipCode(String Zip_Code)
	{
		ZipCode.sendKeys(Zip_Code);
	}
	
	public void setSSN(String SSN1)
	{
		SSN.sendKeys(SSN1);
	}
	public void setPhone(String Phone_no)
	{
		Phone.sendKeys(Phone_no);
	}
	public void setPassword(String Pass_word)
	{
		Password.sendKeys(Pass_word);
	}
	public void setConfirmPassword(String Confirm_Password)
	{
		ConfirmPassword.sendKeys(Confirm_Password);
	}
	public void clickRegisterbtn()
	{
		registerbtn.click();
	}
	public String getconfirmationmsg()
	{
		try {
			return (confirmationmsg.getText());
		}catch(Exception e)
		{
			return (e.getMessage());
		}

		
	
	}

}
