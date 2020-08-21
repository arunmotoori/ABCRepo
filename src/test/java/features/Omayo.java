package features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Omayo {
	
	WebDriver driver;
	
	@Given("^I navigate to application URL$")
	public void I_navigate_to_application_URL() {
		System.out.println("Updated for first time");
		System.out.println("Second commit purpose");
		System.out.println("Third line added");
		System.out.println("Fourth line");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		
	}
	
	@When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\" into the fields$")
	public void I_enter_Username_as_someusername_and_Password_as_somepassword_into_the_fields(String username,String password) {
		
		driver.findElement(By.name("userid")).sendKeys(username);
		driver.findElement(By.name("pswrd")).sendKeys(password);
		
	}
	
	 @And("^I click on Login button$")
	 public void i_click_on_login_button(){
		 
		 driver.findElement(By.cssSelector("input[value='Login']")).click();
	        
	 }
	 
	 @Then("^User should be able to login based on \"([^\"]*)\" login status$")
	 public void User_should_be_able_to_login_based_on_expected_login_status(String expectedResult) {
		 
		 String actualResult = null;
		 
		try {
		Alert alert = driver.switchTo().alert();
		
		 
		 if(alert.getText().contains("Error Password or Username")) {
			 
			 actualResult = "failure";
		 }
		 
		}catch(Exception e) {
			
			actualResult = "success";
			
		}
		
		
		 Assert.assertEquals(expectedResult,actualResult);
		 
		 driver.quit();
		
	 }

}
