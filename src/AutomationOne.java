import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class AutomationOne {


	
	public static void main(String[] args) throws InterruptedException {
		
		PositiveLoginTC();
		NegativeUsernameTC();
		NegativePasswordTC();
		
	}
	
	public static void PositiveLoginTC() {
		java.lang.System.setProperty("webdriver.chrome.driver","C:\\Users\\Islah\\Desktop\\SELENIUM STUFF\\BROWSERDRIVER\\NEW DRIVERS\\chromedriver.exe");
		ChromeDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize(); //maximize window
		
		
		//access website and wait for everything to load
		driver1.get("https://practicetestautomation.com/practice-test-login/"); 
		//wait to verify the next page
		WebDriverWait wait = new WebDriverWait(driver1, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = \"login\"]")));
		
		//tap and input CORRECT detail in username field
		driver1.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//tap and input CORRECT detail in password field
		driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//tap on Submit button
		driver1.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		
		//ASSERT that user is redirected to correct webpage
		String newURL= driver1.getCurrentUrl();
		System.out.println("current URL = "+newURL);
		assertEquals("https://practicetestautomation.com/logged-in-successfully/" , newURL);
		System.out.println("Assert 1 Passed");
		
		//ASSERT that there is congratulations text
		String congratulationsText = driver1.findElement(By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong")).getText();
		System.out.println("congratulations text = '"+ congratulationsText+"'");
		assertEquals ("Congratulations student. You successfully logged in!", congratulationsText);
		System.out.println("assert 2 Passed");
		
		//ASSERT that there is logout button
		Boolean logoutbutton=driver1.findElement(By.xpath("//a[@class = 'wp-block-button__link has-text-color has-background has-very-dark-gray-background-color']")).isDisplayed();
		if (logoutbutton == true){
			System.out.println("Logout button is shown");}
		else {
			System.out.println("Logout button is NOT shown");}
		assertTrue(logoutbutton);
		System.out.println("Assert 3 Passed");
		
		
		System.out.println("test case 1 passed!");
		
		
		driver1.quit();
		
	}
	
	
	public static void NegativeUsernameTC() {
		
		java.lang.System.setProperty("webdriver.chrome.driver","C:\\Users\\Islah\\Desktop\\SELENIUM STUFF\\BROWSERDRIVER\\NEW DRIVERS\\chromedriver.exe");
		ChromeDriver driver1 = new ChromeDriver();

		
		driver1.manage().window().maximize(); //maximize window
		
		
		//access website and wait for everything to load
		driver1.get("https://practicetestautomation.com/practice-test-login/"); 
		//wait to verify the next page
		WebDriverWait wait = new WebDriverWait(driver1, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = \"login\"]")));
		
		//tap and input INCORRECT detail in username field
		driver1.findElement(By.xpath("//input[@id='username']")).sendKeys("IncorrectUser");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//tap and input CORRECT detail in password field
		driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//tap on Submit button
		driver1.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		//ASSERT that there is Error Message is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"error\" and @class=\"show\"]")));
		boolean errorPromptdisplayed = driver1.findElement(By.xpath("//div[@id=\"error\" and @class=\"show\"]")).isDisplayed();
		if (errorPromptdisplayed == true){
			System.out.println("error message prompt is displayed");
		}
		else {
			System.out.println("error message prompt is NOT displayed");
		}
		assertTrue(errorPromptdisplayed);
		System.out.println("assert 1 pass");
		
		//ASSERT the content of the Error Message
		String errorMessagecontent = driver1.findElement(By.xpath("//div[@id=\"error\" and @class=\"show\"]")).getText();
		System.out.println("error message content is : '"+errorMessagecontent+"'");
		assertEquals("Your username is invalid!", errorMessagecontent);
		System.out.println("assert 2 pass");
		
		System.out.println("test case 2 passed!");
		driver1.quit();
	}
	
	public static void NegativePasswordTC() {
		java.lang.System.setProperty("webdriver.chrome.driver","C:\\Users\\Islah\\Desktop\\SELENIUM STUFF\\BROWSERDRIVER\\NEW DRIVERS\\chromedriver.exe");
		ChromeDriver driver1 = new ChromeDriver();

		
		driver1.manage().window().maximize(); //maximize window
		
		
		//access website and wait for everything to load
		driver1.get("https://practicetestautomation.com/practice-test-login/"); 
		//wait to verify the next page
		WebDriverWait wait = new WebDriverWait(driver1, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id = \"login\"]")));
		
		//tap and input CORRECT detail in username field
		driver1.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//tap and input INCORRECT detail in password field
		driver1.findElement(By.xpath("//input[@id='password']")).sendKeys("incorrectPassword");
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//tap on Submit button
		driver1.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		//ASSERT that there is Error Message is displayed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"error\" and @class=\"show\"]")));
		boolean errorPromptdisplayed = driver1.findElement(By.xpath("//div[@id=\"error\" and @class=\"show\"]")).isDisplayed();
		if (errorPromptdisplayed == true){
			System.out.println("error message prompt is displayed");
		}
		else {
			System.out.println("error message prompt is NOT displayed");
		}
		assertTrue(errorPromptdisplayed);
		System.out.println("assert 1 pass");
		
		//ASSERT the content of the Error Message
		String errorMessagecontent = driver1.findElement(By.xpath("//div[@id=\"error\" and @class=\"show\"]")).getText();
		System.out.println("error message content is : '"+errorMessagecontent+"'");
		assertEquals("Your password is invalid!", errorMessagecontent);
		System.out.println("assert 2 pass");
		
		System.out.println("test case 3 passed!");
		driver1.quit();
		
	}
	
	
	public static void StupidYapCode () throws InterruptedException
	{
		java.lang.System.setProperty("webdriver.chrome.driver","C:\\Users\\Islah\\Desktop\\SELENIUM STUFF\\BROWSERDRIVER\\NEW DRIVERS\\chromedriver.exe");
	        WebDriver Browser = new ChromeDriver();

	        //Launch and maximize launched browsers and website
	        System.out.println("\nExecution is starting Please wait....");
	        Browser.get("https://practicetestautomation.com/practice-test-login/");
	        Browser.manage().window().maximize();
	        JavascriptExecutor js = (JavascriptExecutor) Browser;


	        WebDriverWait wait_object = new WebDriverWait(Browser, 10);

	        //Wait for the Input Box to appear before proceeding to execute the next steps

	        //you can declare variables and wait at the same time without declaring the objects to interact with it
	        WebElement usernameInputField = wait_object.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
	        usernameInputField.sendKeys("test123");

	        //Enter the passowrd input field
	        WebElement passwordInputField = Browser.findElement(By.xpath("//input[@id='password']"));
	        passwordInputField.sendKeys("Password0980");


	        //Clicks the Submit Button to proceed
	        WebElement submitBtn = Browser.findElement(By.xpath("//button[@id='submit']"));
	        submitBtn.click();


	        js.executeScript("window.scrollBy(0, 200)");

	        Thread.sleep(1000);
	        Browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	        //wait for the invalid username to appear
	        wait_object.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Your username is invalid!']")));



	        WebElement UsernameErrMessage = Browser.findElement(By.xpath("//div[text()='Your username is invalid!']"));
	        String ErrMessage = UsernameErrMessage.getText();
	        Assert.assertEquals(ErrMessage, "Your username is invalid!");


	        try
	        {
	            WebElement loginBtn = Browser.findElement(By.xpath("//button[@id='submit']"));
	            Assert.assertTrue(loginBtn.isDisplayed());
	            System.out.println("\nNegative Testing Passed, Able to detect error message for invalid username");
	        }
	        
	        catch (AssertionError error){
	            Assert.fail("Assertion Fail");
	       }
	        Browser.quit();
	        
	}




	}
	
		
	
	


