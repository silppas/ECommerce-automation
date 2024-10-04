package tealium.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tealium.AbstractComponent.AbstractComponent;

public class ProductDetailsPage extends AbstractComponent {

	WebDriver driver ;
	public ProductDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".add-to-cart-buttons")
	WebElement addToCartBtn ;
	
	@FindBy(css ="#configurable_swatch_color  a")
	List<WebElement> avalColor ;
	
	@FindBy(css ="#configurable_swatch_size  a")
	List<WebElement> avalSize ;
	
	
	public void addtoCart()
	{
		scrollWindow(0,200);
		for(WebElement webelement : avalColor)
		{
			if(webelement.isEnabled())
			{
				webelement.click();
				break;
			}
		}
		for(WebElement webelement : avalSize)
		{
			if(webelement.isEnabled())
			{
				webelement.click();
				break;
			}
		}
		addToCartBtn.click();
	}
}

