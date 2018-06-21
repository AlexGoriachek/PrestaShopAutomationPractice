package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositiveScenarios {
	/*
	 * Verify that correct first name and last name is displayed on the top right
	 */
	WebDriver driver;

	Faker faker = new Faker();
	String email = faker.name().firstName() + "@gmail.com";
	String name = faker.name().firstName();
	String lastName = faker.name().lastName();
	String password = faker.number().digits(7);
	

	@Test
	public void AuthenticationFailed() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("goes to websait");
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.id("email_create")).sendKeys(email);
		String savedEmail = email;
		System.out.println(email);
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		// Perform the click operation that opens new window
		// opens new window and open new
		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(2000);
		// Switch to new window opened
		System.out.println("Goes to create account functionality");
		// fill up personal info
		driver.findElement(By.id("customer_firstname")).sendKeys(name);
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("passwd")).click();
		driver.findElement(By.id("passwd")).sendKeys(password);
		String savedpassword = password;
		// fill up address
		driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress());
		driver.findElement(By.name("city")).sendKeys(faker.address().city());

		Select dropdown = new Select(driver.findElement(By.name("id_state")));
		dropdown.selectByIndex(faker.number().numberBetween(1, 50));
        
		driver.findElement(By.name("postcode")).sendKeys(faker.number().digits(5));
		Select dropdownCoutry = new Select(driver.findElement(By.name("id_country")));
		dropdownCoutry.selectByVisibleText("United States");
		driver.findElement(By.name("phone_mobile")).sendKeys(faker.number().digits(10));
		
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
		
		driver.findElement(By.name("email")).sendKeys(savedEmail);
		driver.findElement(By.name("passwd")).sendKeys(savedpassword);;
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		
		}
}