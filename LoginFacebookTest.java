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

public class LoginFacebookTest {
	
	private static String URL;
	private static WebDriver driver;

	@Before
	//init facebook
	public void init() {
		URL = "https://www.facebook.com/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Igniter\\Desktop\\7mo Semestre\\Calidad y Pruebas de Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		//URL facebook
		driver.get(URL);
		
		//ingresamos con correo y contraseña erronea
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("william_chuy@live.com.mx");
		
		WebElement pass = driver.findElement(By.name("pass"));
		pass.sendKeys("0FL7NnLZiM");
		
		//damos en entrar
		pass.sendKeys(Keys.ENTER);
		
		//cuando la contraseña es incorrecta y si agarra el mensaje popup mediante el xpath
		String noPass = driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText();
		assertTrue(noPass.contains("La contraseña que ingresaste es incorrecta. "));
		
		//si funciona pero no agarra el mensaje popup
		//String str2 = driver.findElement(By.name("login")).getText();
		//assertTrue(str2.contains("Iniciar Sesión"));
		
		//String buttonLogin = driver.findElement(By.id("loginbutton")).getText();
		//assertTrue(buttonLogin.contains("Iniciar sesión"));
		
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
