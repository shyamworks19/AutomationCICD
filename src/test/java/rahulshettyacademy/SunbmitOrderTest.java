package rahulshettyacademy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobject.CartProducts;
import rahulshettyacademy.pageobject.CheckoutPage;
import rahulshettyacademy.pageobject.ConfirmationPage;

import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;

public class SunbmitOrderTest extends BaseTest{

	
		// TODO Auto-generated method stub

	String productName = "ZARA COAT 3";
		@Test(dataProvider = "getData",groups= {"Purchase"})
		public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
		{
		
		
			ProductCatalogue productCatalogue = landingpage.Applicationlogin(input.get("email"),input.get("password"));
		
		
		
		List<WebElement> products = productCatalogue.getProductList();
		
		productCatalogue.addProductToCart(input.get("product"));
		CartProducts cartproducts = productCatalogue.goToCartButton();

		Boolean match = cartproducts.getProductByName(input.get("product"));
		
		Assert.assertTrue(match);
		
		
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutpage.submitOrder();
		String confirmMessage= confirmationPage.VerifyConfimrationmessage();
		
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		

	}
		@Test(dependsOnMethods= {"SubmitOrder"})
		public void OrderHistoryTest()
		{
			//"ZARA COAT 3";
			landingpage.Applicationlogin("samrathod@gmail.com","Messi@123");
		
			ProductCatalogue productcatalogue = new ProductCatalogue(driver);
			
			OrderPage ordersPage = productcatalogue.goToOrdersPage();
			Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
			
	}
		@DataProvider
		public Object[][] getData() throws IOException
		{
			
			List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
			
		}
		
		//HashMap <String,String> map = new HashMap();
		//map.put("email","samrathod@gmail.com" );
		//map.put("password", "Messi@123");
		//map.put("product","ZARA COAT 3");
		
		//HashMap <String,String> map1 = new HashMap();
		//map1.put("email","shetty@gmail.com" );
		//map1.put("password","Iamking@000");
		//map1.put("product","ADIDAS ORIGINAL");

}