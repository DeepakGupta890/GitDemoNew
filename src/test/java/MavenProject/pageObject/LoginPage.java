package MavenProject.pageObject;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		js= (JavascriptExecutor)this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h5[text()='Elements']")
	WebElement elementsPanel;
	
	@FindBy(xpath="//span[text()='Text Box'] ")
	WebElement textBox;
	
	@FindBy(xpath="//div[@id='userEmail-wrapper']//preceding-sibling::div//input")
	WebElement fullname;
	@FindBy(xpath="//div[@id='userEmail-wrapper']")
	WebElement emailId;
	
	@FindBy(xpath="//div[@id='userEmail-wrapper']/following-sibling::div//textarea[@id='currentAddress']")
	WebElement currentAddressId;
	@FindBy(xpath="//textarea[@id='permanentAddress']")
	WebElement permanentAddress;
	@FindBy(id="submit")
	WebElement submitButton;
	
	public void getElementsPanelFill(String name,String email,String CurrentAdd,String permanentAdd) throws InterruptedException 
	{
		
		
		
		js.executeScript("arguments[0].scrollIntoView(true);",elementsPanel);
		elementsPanel.click();
		
		textBox.click();
		fullname.sendKeys(name);
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		emailId.sendKeys(email);
		currentAddressId.sendKeys(CurrentAdd);
		permanentAddress.sendKeys(permanentAdd);
		submitButton.click();
		
		
		
		
	}
	public void goTo()
	{
		driver.get("https://demoqa.com/");
	}
	

}
