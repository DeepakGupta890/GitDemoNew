package MavenProject.resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;


import MavenProject.pageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	Properties prop;
	public LoginPage lp;
	JavascriptExecutor jvsrpt= (JavascriptExecutor)driver;
	
	
	public WebDriver InitializeDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\MavenProject\\resources\\GlobalData.properties");
		prop.load(fs);
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
		
	}
	@BeforeMethod(alwaysRun=true)
	public LoginPage launchApplication() throws IOException
	{
		driver=InitializeDriver();
		 lp= new LoginPage(driver);
		 lp.goTo();
		 return lp;
		
	}
	
	@AfterTest(alwaysRun=true)
	
	public void tearDown() 
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//Screenshot//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//Screenshot//" + testCaseName + ".png";
	}
	
	/*public String url() throws IOException
	{
		prop= new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\GlobalData.properties");
		prop.load(fs);
		String urlName=prop.getProperty("url");
		return urlName;
	}
	
	
	
	
	
	public void  scrollhightDown(WebDriver driver)
	{
		
		jvsrpt.executeScript("Window.scrollTo(0,document.body.scrollHeight)");
	}
	public void  scrollhightUp(WebDriver driver)
	{
		
		jvsrpt.executeScript("Window.scrollTo(0,-document.body.scrollHeight)");
	}
	public void  scrollhightPixel(WebDriver driver, int pixel)
	{
		
		jvsrpt.executeScript("Window.scrollTo(0,pixel)");
	}
	public void DropDownHandle(WebElement element, String text)
	{
		Select sal= new Select(element);
		sal.selectByVisibleText(text);
	}*/
	
	
	
	

}
