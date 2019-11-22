package com.mayab.calidad.funcionales;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ISelect;

public class MERNCRUDTest {
	
	private static String URL;
	private static WebDriver driver;
	
	@Before
	public void init() {
		URL = "https://mern-crud.herokuapp.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LAPTOP-ALAN\\Desktop\\Tareas\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	//prueba para poder agregar una persona prueba de exito
	@Test
	public void addSuccessTest() {
		driver.get(URL);
		
		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button"));
		buttonAdd.sendKeys(Keys.ENTER);
		
		WebElement enterName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/input"));
		enterName.sendKeys("WILLIAM TEST ADD");
		
		WebElement enterEmail = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input"));
		enterEmail.sendKeys("byfiqannoh-7907@yopmail.com");
		
		WebElement enterAge = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[1]/div/input"));
		enterAge.sendKeys("20");
		
		WebElement enterSex = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
		enterSex.sendKeys(Keys.ENTER);
		
		WebElement add = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		add.sendKeys(Keys.ENTER);
		
		pause(1000);
		
		String addedSuccessfully = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		assertTrue(addedSuccessfully.contains("Successfully added!"));
		
		pause(6000);
		
		driver.close();
	}
	
	@Test
	public void addFailTest() {
		driver.get(URL);
		
		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/button"));
		buttonAdd.sendKeys(Keys.ENTER);
		
		WebElement enterName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/input"));
		enterName.sendKeys("WILLIAM TEST ADD");
		
		WebElement enterEmail = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input"));
		enterEmail.sendKeys("byfiqannoh-7907@yopmail.com");
		
		WebElement enterAge = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[1]/div/input"));
		enterAge.sendKeys("20");
		
		WebElement enterSex = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[3]/div[2]/div"));
		enterSex.sendKeys(Keys.ENTER);
		
		WebElement add = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		add.sendKeys(Keys.ENTER);
		
		pause(1000);
		
		String addedFail = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
		assertTrue(addedFail.contains("That email is already taken."));
		
		pause(6000);
		
		driver.close();
	}
	
	//prueba de exito editar
	@Test
	public void editSuccessTest() {
		driver.get(URL);
		
		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[5]/button[1]"));
		buttonAdd.sendKeys(Keys.ENTER);
		
		WebElement enterName = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[1]/div/input"));
		enterName.sendKeys("WILLIAM TEST EDIT");
		
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		saveButton.sendKeys(Keys.ENTER);
		
		pause(1000);
		
		String updateSuccess = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[4]/div/p")).getText();
		assertTrue(updateSuccess.contains("Successfully updated!"));
		
		pause(6000);
		
		driver.close();
	}

	//prueba de fracaso editar
	
	@Test
	public void editFailTest() {
		driver.get(URL);
		
		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[5]/button[1]"));
		buttonAdd.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input")).clear();
		WebElement enterEmail = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[2]/div/input"));
		enterEmail.sendKeys("byfiqannoh-7907@yopmail");
		
		WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button"));
		saveButton.sendKeys(Keys.ENTER);
		
		pause(1000);
		
		String updateSuccess = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p")).getText();
		assertTrue(updateSuccess.contains("Email must be valid."));
		
		pause(6000);
		
		driver.close();
	}
	
	@Test
	public void deleteTest() {
		driver.get(URL);
		
		WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/table/tbody/tr[1]/td[5]/button[2]"));
		deleteButton.sendKeys(Keys.ENTER);
		
		String verifyDelete = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/p")).getText();
		assertTrue(verifyDelete.contains("Are you sure you want to delete "));
		
		WebElement yesButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]"));
		yesButton.sendKeys(Keys.ENTER);
		
		pause(6000);
		
		driver.close();
	}
	
	@After
	public void tearDown() {
		pause(6000);
		driver.quit();
	}
	
	public void pause(long mils) {
		try {
			Thread.sleep(mils);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
