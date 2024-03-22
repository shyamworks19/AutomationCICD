package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
		// TODO Auto-generated method stub
	
	@FindBy(css=".hero-primary")
	WebElement confirmationmessage;
		
	
		
	public String VerifyConfimrationmessage()
	{
		CheckoutPage cp = new CheckoutPage(driver);	
		return confirmationmessage.getText();
		
	}
		
		
		
		
		
		 
		
		
		
		
		

	}


