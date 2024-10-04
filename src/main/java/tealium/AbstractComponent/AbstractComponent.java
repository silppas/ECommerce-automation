package tealium.AbstractComponent;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver ;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public Properties getConfigurationProperties() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\tealium\\Resource\\Configuration.Properties");
		prop.load(file);
		return prop;
	}
	
	public List<HashMap<String, String>> getJsonTestData() throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\java\\tealium\\TestData\\TestData.json");
		String jsonData = FileUtils.readFileToString(file , StandardCharsets.UTF_8); //json to string
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>() {});
		return data;
		
	}
	
	public void visisbilityofElementLocated(WebElement gridView)
	{
		wait.until(ExpectedConditions.visibilityOf(gridView));
		
	}
	
	public void scrollWindow(int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");

	}
	
	public void selectByIndex(int x , WebElement webelement)
	{
		Select s = new Select(webelement);
		s.selectByIndex(x);
	}
	
	public void getScreenShot()
	{
		
	}
}