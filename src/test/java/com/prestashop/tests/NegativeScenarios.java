package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cybertek.driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegativeScenarios {
	WebDriver driver;

	@BeforeClass
	public void setUpClass() {

	}

	@BeforeMethod
	public void setUpMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("goes to websait");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Test
	public void AuthenticationFailed() {
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println("Goes to log in functionality");
        driver.findElement(By.name("email")).sendKeys("mn@mail.com");
		driver.findElement(By.name("passwd")).sendKeys("12435");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		String a = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertEquals(a, "Authentication failed.");
	    System.out.println("passed");
	}

	@Test
	public void invalidEmailTest() {
 
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println("Goes to log in functionality");
        driver.findElement(By.name("email")).sendKeys("mnmail.com");
		driver.findElement(By.name("passwd")).sendKeys("12435");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		String a = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		
	    Assert.assertEquals(a, "Invalid email address.");
	    System.out.println("passed");
	
	}
	@Test
	public void blankEmailTest() {

		System.out.println("goes to websait");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println("Goes to log in functionality");
        driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("passwd")).sendKeys("12435");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		String a = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		
	    Assert.assertEquals(a, "An email address required.");
	    System.out.println("passed");
	}
	@Test
	public void blankPasswordTest() {

		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		System.out.println("Goes to log in functionality");
        driver.findElement(By.name("email")).sendKeys("Tomlin@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		String a = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		
	    Assert.assertEquals(a, "Password is required.");
	    System.out.println("passed");
	}
	@AfterMethod
	public void runonceeveryMethod() {
		driver.close();
		System.out.println("Runs once after class");
		System.out.println("Run after every method");
	}

	@AfterClass
	void tearDownClass() {
		System.out.println("Runs once after class");
	}
}
