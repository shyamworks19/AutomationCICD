package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartProducts extends AbstractComponent{
	
	WebDriver driver;

	public CartProducts(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
		// TODO Auto-generated method stub
		
		
		//WebElement userEmail = driver.findElement(By.id("userEmail"));
		@FindBy(css= ".cartSection h3")
		List<WebElement> cartProducts;
		
		@FindBy(css = ".totalRow button")
		WebElement clickButton;
		
		
		
		
		
		
	
	
		public Boolean getProductByName(String productName)
		{
			Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
			clickButton.click();			
			return match;
			
		}
		
		public CheckoutPage goToCheckout() {
			clickButton.click();
			return new CheckoutPage(driver);
		
		
		
		

	}

}
