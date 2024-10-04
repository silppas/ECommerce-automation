package tealium.Tests;

import java.io.IOException;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import tealium.PageObjects.CheckoutPage;
import tealium.PageObjects.HomePage;
import tealium.PageObjects.ProductDetailsPage;
import tealium.PageObjects.ProductPage;
import tealium.baseTest.BaseTest;

public class GuestUserOrderCreation extends BaseTest{
	
	HomePage homepage ;
	ProductPage productPage ;
	ProductDetailsPage productDetailsPage;
	CheckoutPage checkoutPage ;
	
	@Test(priority=1 , testName = "Verfy Page is navigation on Women Category Selection")
	public void verifyWomenMenuSelection() throws IOException
	{
		homepage = new HomePage(driver);
		homepage.clickWomenMenu();
		String actualUrl = driver.getCurrentUrl();
		String ExpectedUrl = abComp.getJsonTestData().get(0).get("Expectedwomenurl");
		Assert.assertEquals(actualUrl, ExpectedUrl);
	}
	
	@Test(priority = 2, testName = "Verify products are listing")
	public void VerifyProductList()
	{
		productPage = new ProductPage(driver);
		int productcount = productPage.getProductCount();
		Assert.assertTrue(productcount > 0);
	}
	
	@Test(priority = 3 , testName = "Verify product information is displayed for listed products")
	public void verifyIsProductInformationDisplayed()
	{
		Boolean isDisplayed = productPage.productInformationDisplay();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(priority = 4 , testName = " Verify product details navigation on view button click")
	public void verifyProductDetailsNavigation() throws IOException
	{
		productPage.clickViewDetails();
		String expectedUrl = abComp.getJsonTestData().get(0).get("ExpectedProductDetailsurl");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
	}
	
	@Test(priority = 5 , testName = "Verify product add to cart")
	public void verifyAddToCart()
	{
		productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addtoCart();
	}

	@Test(priority = 6 , testName = "Verify correct product in cart")
	public void verifyCartProduct() throws IOException {
		checkoutPage = new CheckoutPage(driver);
		Assert.assertTrue(checkoutPage.checkCartProduct());
	}
	
	@Test(priority = 7 , testName = "Verify order creation")
	public void verifyOrderCreate() throws IOException
	{
		checkoutPage.proceedToCheckout();
		checkoutPage.sendGuestUserDetails();
	}
}
