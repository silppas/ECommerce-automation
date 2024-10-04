package tealium.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tealium.AbstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[title=\"View Details\"]")
	List<WebElement> products;
	
	@FindBy(xpath="//*[@class=\"product-info\"]//*[@class=\"product-name\"]")
	List<WebElement> productName;	
	
	@FindBy(xpath="//*[@class=\"product-info\"]//*[@class=\"regular-price\" or @class = \"special-price\"]")
	List<WebElement> price;	
	
	@FindBy(xpath="//*[@class=\"product-info\"]//*[@title=\"View Details\"]")
	List<WebElement> viewDetailsbtn;	
	
	@FindBy(xpath="//*[@class=\"link-wishlist\"]")
	List<WebElement> addToWishListBtn;	
	
	@FindBy(xpath="//*[@class=\"link-compare\"]")
	List<WebElement> addToCompareBtn;	
	
	@FindBy(css=".add-to-cart-buttons")
	WebElement addToCartBtn ;
	
	
	public int getProductCount()
	{
		return products.size();
	}
	

	public Boolean productInformationDisplay()
	{
		for( int i = 0 ; i < products.size() ; i++)
		{
			Boolean hasProductName = productName.get(i).isDisplayed() && !productName.get(i).getText().isEmpty();
			Boolean hasProductPrice = price.get(i).isDisplayed() && !price.get(i).getText().isEmpty();
			Boolean hasViewBtn = productName.get(i).isDisplayed() ;
			Boolean hasWishlistBtn = productName.get(i).isDisplayed() ;
			Boolean hasCompareBtn = productName.get(i).isDisplayed() ;
			
			if(hasProductName ||  hasProductPrice || hasViewBtn || hasWishlistBtn || hasCompareBtn == false)
			{
				return false;
				
			}
		}
		return true;
		
	}
	
	public void clickViewDetails() throws IOException
	{
		String productname = getJsonTestData().get(0).get("ExpectedProductName");
		for( int i = 0 ; i < products.size() ; i++)
		{
			if (productName.get(i).getText().equalsIgnoreCase(productname))
			{
				scrollWindow(0,300);
				products.get(i).click();
				break;
			}
		}
		visisbilityofElementLocated(addToCartBtn);
	}
}
