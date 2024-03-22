package rahulshettyacademy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobject.CartProducts;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.TestComponents.Retry;
public class ErrorValidations extends BaseTest{

	
		// TODO Auto-generated method stub
		
		@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
		public void LoginErrorvalidations() throws IOException
		{
		
		
		
		
		landingpage.Applicationlogin("@gmail.com", "Iamki0001");
		
		
		
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());

		
		
		

	}
		@Test
		public void ProductErrorValidation() throws IOException, InterruptedException
		{

			String productName = "ZARA COAT 3";
			landingpage.Applicationlogin("samrathod@gmail.com","Messi@123");
			
			ProductCatalogue productcatalogue = new ProductCatalogue(driver);
			
			List<WebElement> products = productcatalogue.getProductList();
			
			productcatalogue.addProductToCart(productName);
			
			productcatalogue.goToCartButton();
			
			
		
			
			//ng-animating
			CartProducts cartproducts = new CartProducts(driver);
			Boolean match = cartproducts.getProductByName("ZARA COAT 33");
			
			Assert.assertFalse(match);
			
		

		}
		

}
