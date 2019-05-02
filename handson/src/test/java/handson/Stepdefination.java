package handson;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Stepdefination
{
 WebDriver driver;
 
 @Given("user in the home page")
 public void user_in_the_home_page()
 {
	 System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.get("http://10.232.237.143:443/TestMeApp");
	 driver.manage().window().maximize();
	  
	 String title=driver.getTitle();
	
		 System.out.println(title);
	 
 }

 @When("user enter username and password and click Login")
 public void user_enter_username_and_password_and_click_Login(io.cucumber.datatable.DataTable dataTable)
 {
	 List<Map<String,String>> list=dataTable.asMaps(String.class,String.class);
     String username=list.get(0).get("username");
     String password=list.get(0).get("password");
     
     driver.findElement(By.linkText("SignIn")).click();
     driver.findElement(By.name("userName")).sendKeys(username);
     driver.findElement(By.name("password")).sendKeys(password);
     driver.findElement(By.name("Login")).click();
 }
 
 
	@Then("user should be logged in and verified")
	public void user_should_be_logged_in_and_verified()
	{
		System.out.println("verified");
	}
	
	
	@Given("user navigate to all categories, electronics and head phone")
	public void user_navigate_to_all_categories_electronics_and_head_phones()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//WebElement menu=driver.findElement(By.xpath("//*[@id=\'menu3']/li[2]/a/span"));
		//menu.click();
		//Actions act=new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Home Appliance')]"))).click().build().perform();
		//act.moveToElement(driver.findElement(By.name("//span[contains(text(),'Fridge')]"))).click().build().perform();
		 driver.findElement(By.name("products")).sendKeys("Headphone");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@Given("add product into shopping cart")
	public void cart()
	{
		driver.findElement(By.linkText("Add to cart")).click();
	}
	
	@When("proceed to checkout")
	public void checkout()
	{
		driver.findElement(By.partialLinkText("Cart")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Checkout")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("select bank and credentials")
	public void bank(io.cucumber.datatable.DataTable dt)
	{
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<Map<String, String>> list=dt.asMaps(String.class,String.class);
		String username=list.get(0).get("username");
		String password=list.get(0).get("password");
		//List<Map<String,String>> list1=dt.asMaps(String.class,null);
		//String trans=list1.get(0).get("transactionid");
		 
		driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//label[contains(text(), 'Andhra Bank')]")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.linkText("CONTINUE")).click();
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
		
		driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	}
	
	@Then("redirected to the thank you page")
	public void thankyou()
	{
		driver.findElement(By.linkText("SignOut")).click();
	 driver.close();
	}
}
