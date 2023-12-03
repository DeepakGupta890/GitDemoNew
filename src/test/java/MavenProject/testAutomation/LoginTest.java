package MavenProject.testAutomation;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import MavenProject.resources.BaseTest;

public class LoginTest extends BaseTest {
	WebDriver driver;
	String name="Test User";
	String email="test@gmail.com";
	String cuAddress="nclkdsfg;";
	String perAddress="fjljg";
	
	
	
	@Test
	public void ElementsHandleFormFillUp() throws InterruptedException 
	{
		
		
		
		//LoginPage lp= new LoginPage(driver);
		lp.getElementsPanelFill(name, email, cuAddress, perAddress);
		
	}
}
