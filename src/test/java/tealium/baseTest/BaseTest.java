package tealium.baseTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tealium.AbstractComponent.AbstractComponent;

public class BaseTest {

	public WebDriver driver; 
	public AbstractComponent abComp;
	@BeforeClass
	public void setup() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		abComp = new AbstractComponent(driver);
		driver.get(abComp.getConfigurationProperties().getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
