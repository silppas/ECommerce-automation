package tealium.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tealium.AbstractComponent.AbstractComponent;

public class HomePage extends AbstractComponent {
	
	WebDriver driver ;
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//li[@class='level0 nav-1 first parent']//*[text()=\"Women\"]")
	WebElement womenMenu;
	
	@FindBy(xpath="//*[@title=\"Grid\"]") 
	WebElement gridView;
	
	public void clickWomenMenu()
	{
		womenMenu.click();
		visisbilityofElementLocated(gridView);
	}
	

}
