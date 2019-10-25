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

public class LoginTest {

	private static String URL;
	private static WebDriver driver;
	
	@Before
	public void init() {		
		URL = "https://anahuac.blackboard.com/webapps/login/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Igniter\\Desktop\\7mo Semestre\\Calidad y Pruebas de Software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//Prueba 1, que el ID y la contraseña sean correctos en el login
	@Test
	/*public void test() throws Exception {
		driver.get(URL);
		WebElement  user = driver.findElement(By.id("user_id"));
		user.sendKeys("00287684");
		
		//verificamos que se haya escrito la contraseña
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Likemike");
		
		//verificamos que se haya apretado enter
		pwd.sendKeys(Keys.ENTER);
		
		WebElement name = driver.findElement(By.id("global-nav-link"));
		pause(6000);
		
		//verificamos que el nombre sea William Balan Hernandez
		assertThat(name.getText(), is(equalTo("William Balan Hernandez")));
		
		driver.close();
		
		//paso prueba
	}*/
	
	//Prueba 2, en el caso de que la contraseña este erronea
	/*public void test() throws Exception{
		driver.get(URL);
		WebElement user = driver.findElement(By.id("user_id"));
		user.sendKeys("00287684");
		
		//verificamos que se haya escrito la contraseña
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("1");
		
		//verificamos que se haya apretado enter
		pwd.sendKeys(Keys.ENTER);
		
		WebElement error = driver.findElement(By.id("loginErrorMessage"));
		pause(6000);
		
		assertThat(error.getText(), is(equalTo("El nombre de usuario o contraseña que ha introducido no son correctos. "
				+ "Inténtelo de nuevo. Si aún no puede iniciar sesión, comuníquese con su administrador del sistema.")));
		
		driver.close();
	}*/
	
	//Prueba 3, ID erronea, contraseña correcta
	/*public void test() throws Exception{
		driver.get(URL);
		WebElement user = driver.findElement(By.id("user_id"));
		user.sendKeys("00287685");
		
		//verificamos que se haya escrito la contraseña
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Likemike");
		
		//verificamos que se haya apretado enter
		pwd.sendKeys(Keys.ENTER);
		
		WebElement error = driver.findElement(By.id("loginErrorMessage"));
		pause(6000);
		
		assertThat(error.getText(), is(equalTo("El nombre de usuario o contraseña que ha introducido no son correctos. "
				+ "Inténtelo de nuevo. Si aún no puede iniciar sesión, comuníquese con su administrador del sistema.")));
		
		driver.close();
	}*/
	
	//Prueba 4, dejar vacio el ID y la contraseña
	public void Test() throws Exception {
		driver.get(URL);
		WebElement user = driver.findElement(By.id("entry-login"));
		
		user.submit();
		
		pause(6000);
		
		String alert = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		assertEquals("Introduzca un nombre de usuario y una contraseña.", alert);
		
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
