package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

 public class PositiveTests {
	 @Test
	  public void firstTest() {
		 
		 System.out.println("--->Test Started");
		  /*
		  ChromeOptions chromeOpt = new ChromeOptions();
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver = new ChromeDriver(chromeOpt);
		  */
		  WebDriver driver = new ChromeDriver();

		  //driver.get("https://www.google.com/");
		  //driver.manage().window().maximize();
        	//Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
        	
        	//1.-Open browser and enter the url
        	driver.get("https://the-internet.herokuapp.com/login");
        	//2.-Maximize page
        	driver.manage().window().maximize();
        	
        	sleep(3000);
    		// IMPLICIT WAIT
    		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        	System.out.println("--->Page is opened");
        	
    		//3.-Login
        	//username: //input[@name='username']
        	//tomsmith
        	WebElement username = driver.findElement(By.name("username"));
        	username.sendKeys("tomsmith");
        	
        	//pass:	//input[@name='password']
        	//SuperSecretPassword!
        	WebElement password = driver.findElement(By.name("password"));
        	password.sendKeys("SuperSecretPassword!");
        	
        	//login button is visible: 	//*[contains(@class,'sign-in')]  ||		//*[contains(text(),' Login')]
        	WebElement loginButton = driver.findElement(By.xpath("//*[contains(@class,'sign-in')]")); 
        	loginButton.click();
        	
        	sleep(3000);
        	
        	//Logout button is visible
        	//a[contains(@href,'logout')]
        	WebElement logoutButton = driver.findElement(By.xpath("//a[contains(@href,'logout')]"));
        	Assert.assertTrue(logoutButton.isDisplayed(),"Log out button is not visible");
        	
        	//4.-validate login success

        	
        	//succes URL
    		String expectedUrl = "https://the-internet.herokuapp.com/secure";
    		String actualUrl = driver.getCurrentUrl();
    		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
        	
       
        	//    succesful login message
        	WebElement succesMessage = driver.findElement(By.cssSelector("#flash"));
        	String expectedMessage = "You logged into a secure area!";
        	String actualMessage = succesMessage.getText();
        	System.out.println("actual Message:" + actualMessage);
        	Assert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: " + actualMessage + "\nExpected MEssage: " + expectedMessage);
        	
        	driver.close();
        	driver.quit();
        	System.out.println("--->Test Finished");
        	

               	
	  }
	
	 
	 // HARD WAIT JAVA
 	private void sleep(long m) {
 		System.out.println("-->Hard Wait Time: " + m);
 		try {
 			Thread.sleep(m);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
}
