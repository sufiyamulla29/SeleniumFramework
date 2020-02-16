package generic;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import generic.BaseClass;
import generic.SeleniumClass.locatorType;


public abstract class SeleniumClass extends BaseClass {
	protected static WebDriver driver;
	public enum locatorType {id, name, className, tagName,css,xpath,linkText, partialLinkText};
	public WebElement element;
	
	public static String getscreenshot(){
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentPath = System.getProperty("user.dir");
		
		currentPath = currentPath + "\\src\\test\\java\\data\\";
		String dest = currentPath + getcurrrentdateandtime() + ".png"; 
		File file = new File(dest);
		
		try {
			FileUtils.copyFile(srcFile, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dest;
		
	}
	
	public static String getcurrrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");

		}catch(Exception e) {
			
		}
		return str;
	}
	public void launchBrowser(String browserName)  {
		
		String currentPath = System.getProperty("user.dir");
		
		currentPath = currentPath + "\\src\\test\\java\\utils\\";
		
		if(browserName.equalsIgnoreCase("chrome")) {	
			System.setProperty("webdriver.chrome.driver", currentPath+"chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", currentPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", currentPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void launchApplication(String url) {
		
		driver.get(url);
	}
	
	public void verifyPageByURL(String expectedURL) {
		
		String actualUrl=driver.getCurrentUrl();
		
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void performAction(WebElement elem, String actionType, String value) {
		if(actionType.equalsIgnoreCase("index") || actionType.equalsIgnoreCase("text") || actionType.equalsIgnoreCase("value")) {
			Select Sel = new Select(elem);
			if(actionType.equalsIgnoreCase("index")) {
				Sel.selectByIndex(Integer.parseInt(value));
			}
			else if(actionType.equalsIgnoreCase("text")) {
				Sel.selectByVisibleText(value);
			}
			else if(actionType.equalsIgnoreCase("value")) {
				Sel.selectByValue(value);
			}
		}
		
		else if(actionType.equalsIgnoreCase("Click")) {
			elem.click();
		}
		
		
	}
	
	public void identifyElement() {
		
	}
	
	public WebElement identifyElements(String LocatorValue, locatorType type) {
		
		WebElement element = null;
		switch(type) {
				case id : element = driver.findElement(By.id(LocatorValue));
					break;
				case name : element = driver.findElement(By.name(LocatorValue));
				        break;
				case className : element = driver.findElement(By.className(LocatorValue));
					break;
				case tagName : element = driver.findElement(By.tagName(LocatorValue));
					break;
				case css : element = driver.findElement(By.cssSelector(LocatorValue));
					break;
				case xpath : element = driver.findElement(By.xpath(LocatorValue));
					break;
				case linkText : element = driver.findElement(By.linkText(LocatorValue));
					break;
				case partialLinkText : element = driver.findElement(By.partialLinkText(LocatorValue));
					break;
			
				}
		
		return element;
		
	}
	
	public void closeApplication() {
		driver.close();
	}
}
