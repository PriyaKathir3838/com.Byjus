package stepdifinition;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import base.baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import pojo.pojoclass;

public class stepdifinitionclass extends baseclass {
	baseclass base = new baseclass();
	public static WebDriver driver ;
	pojoclass locator = new pojoclass();
	
		@Given("User Launches the application")
		public void user_Launches_the_application() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://byjus.com/");
		   
		}

		@When("User mouseover Study material dropdown")
		public void user_mouseover_Study_material_dropdown() throws InterruptedException {
			WebElement study = driver.findElement(By.xpath("//a[@class = 'dropdown-toggle' and text() = 'Study Materials'] "));
			Actions ac = new Actions(driver);
			Thread.sleep(2000);
			ac.moveToElement(study);
			ac.click(study);
			
		   
		}

		@When("User selects NEET from dropdown")
		public void user_selects_NEET_from_dropdown() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 WebElement neet = driver.findElement(By.xpath("//a[text() = 'NEET']"));
			js.executeScript("arguments[0].click()",neet);
			
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   //neet.click();
		}

		@Then("User validates the NEET content")
		public void user_validates_the_NEET_content() throws MalformedURLException, IOException {
			//JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement link = driver.findElement(By.xpath("//a[text() = 'NEET']"));
			
			String neetlink = link.getAttribute("href");
			if((neetlink == null)||(neetlink.isEmpty())) {
				System.out.println("Given link is empty");
			}
			else 
				
				if(!neetlink.startsWith("https://byjus.com/")) {
					System.out.println("Given link is not revelent link");
				}
				else {
					HttpURLConnection http = (HttpURLConnection)(new URL(neetlink).openConnection());
					http.setRequestMethod("HEAD");
					http.connect();
					if(http.getResponseCode()==200) {
						System.out.println("Given link is not broken link");
					}
					else {
						System.out.println("Given link is broken link");
					}
				}
			if(neetlink.equals("https://byjus.com/neet/")) {
				System.out.println("link show revelent neet content");
			}
			else {
				System.out.println("link does not show revelent neet content");
			}
		    
		}

		@When("User selects JEE from dropdown")
		public void user_selects_JEE_from_dropdown() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 WebElement jee = driver.findElement(By.xpath("//a[text() = 'JEE']"));
			js.executeScript("arguments[0].click()",jee);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		  
		}

		@Then("User validates the JEE content")
		public void user_validates_the_JEE_content() throws MalformedURLException, IOException {
			WebElement link1 = driver.findElement(By.xpath("//a[text()= 'JEE']"));
			
			String jeelink = link1.getAttribute("href");
			if((jeelink == null)||(jeelink.isEmpty())) {
				System.out.println("Given link is empty");
			}
			else 
				
				if(!jeelink.startsWith("https://byjus.com/")) {
					System.out.println("Given link is not revelent link");
				}
				else {
					HttpURLConnection http = (HttpURLConnection)(new URL(jeelink).openConnection());
					http.setRequestMethod("HEAD");
					http.connect();
					if(http.getResponseCode()==200) {
						System.out.println("Given link is not broken link");
					}
					else {
						System.out.println("Given link is broken link");
					}
				}
			if(jeelink.equals("https://byjus.com/jee/")) {
				System.out.println("link show revelent jee content");
			}
			else {
				System.out.println("link does not show revelent jee content");
			}
		    
		    
		}

		@When("User selects commerce from dropdown")
		public void user_selects_commerce_from_dropdown() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 WebElement com = driver.findElement(By.xpath("//a[text() = 'Commerce']"));
			js.executeScript("arguments[0].click()",com);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		   
		}

		@Then("User validates the commerce content")
		public void user_validates_the_commerce_content() throws MalformedURLException, IOException {
			WebElement link2 = driver.findElement(By.xpath("//a[text()= 'Commerce']"));
			String comlink = link2.getAttribute("href");
			if((comlink == null)||(comlink.isEmpty())) {
				System.out.println("Given link is empty");
			}
			else 
				
				if(!comlink.startsWith("https://byjus.com/")) {
					System.out.println("Given link is not revelent link");
				}
				else {
					HttpURLConnection http = (HttpURLConnection)(new URL(comlink).openConnection());
					http.setRequestMethod("HEAD");
					http.connect();
					if(http.getResponseCode()==200) {
						System.out.println("Given link is not broken link");
					}
					else {
						System.out.println("Given link is broken link");
					}
				}
			if(comlink.equals("https://byjus.com/commerce/")) {
				System.out.println("link show revelent commerce content");
			}
			else {
				System.out.println("link does not show revelent commerce content");
			}
		    
		   
		}


	}



