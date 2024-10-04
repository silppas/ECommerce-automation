package tealium.PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tealium.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver ;
	
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2[@class=\"product-name\"]")
	WebElement cartProductName ;
	@FindBy(xpath = "//*[@title = \"Proceed to Checkout\"]")
	WebElement proceedToCheckout;
	@FindBy(id = "onepage-guest-register-button")
	WebElement continuebtn;
	@FindBy(xpath="//*[@id=\"billing:firstname\"]")
	WebElement firstName;
	@FindBy(xpath="//*[@id=\"billing:lastname\"]")
	WebElement lastName;
	@FindBy(xpath="//*[@id=\"billing:email\"]")
	WebElement email;
	@FindBy(xpath="//*[@id=\"billing:street1\"]")
	WebElement address;
	@FindBy(xpath="//*[@id=\"billing:city\"]")
	WebElement city;
	@FindBy(xpath = "//*[@id=\"billing:region_id\"]")
	WebElement state;
	@FindBy(id = "billing:postcode")
	WebElement zipCode;
	@FindBy(id = "billing:telephone")
	WebElement telePhone;
	@FindBy(xpath = "//*[@onclick=\"billing.save()\"]")
	WebElement checkoutContinuebtn;
	@FindBy(xpath = "//*[@id=\"s_method_freeshipping_freeshipping\"]")
	WebElement freeShipping;
	@FindBy(xpath = "//*[@onclick=\"shippingMethod.save()\"]")
	WebElement shippingContinuebtn;
	@FindBy(xpath = "//*[@onclick=\"payment.save()\"]")
	WebElement paymentContinueBtn;
	@FindBy(xpath = "//*[@onclick=\"review.save();\"]")
	WebElement placeOrder;
	
	public Boolean checkCartProduct() throws IOException
	{
		if (cartProductName.getText().equalsIgnoreCase(getJsonTestData().get(0).get("ExpectedProductName")))
		{
			return true;
		}
		return false;
		
	}
	
	public void proceedToCheckout()
	{
		proceedToCheckout.click();
		visisbilityofElementLocated(continuebtn);
		continuebtn.click();
	}
	
	public void sendGuestUserDetails() throws IOException
	{
		firstName.sendKeys(getJsonTestData().get(0).get("firstName"));
		lastName.sendKeys(getJsonTestData().get(0).get("lastName"));
		scrollWindow(0,300);
		email.sendKeys(getJsonTestData().get(0).get("email"));
		address.sendKeys(getJsonTestData().get(0).get("address"));
		city.sendKeys(getJsonTestData().get(0).get("city"));
		scrollWindow(0,500);
		selectByIndex(1,state);
		zipCode.sendKeys(getJsonTestData().get(0).get("zipcode"));
		telePhone.sendKeys(getJsonTestData().get(0).get("telephone"));
		checkoutContinuebtn.click();
		freeShipping.click();
		shippingContinuebtn.click();
		paymentContinueBtn.click();
		placeOrder.click();
	}
}
