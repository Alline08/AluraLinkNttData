import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteLinkNttData {
	
	private WebDriver driver;
	
	@Before
	public void abrirDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@After
	public void encerrarDriver() {
		driver.quit();
	}

	@Test
	public void teste() throws InterruptedException {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		assertEquals("Google", driver.getTitle());

		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("nttdata");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement careers = driver.findElement(By.xpath("//*[@id=\"navbarLevel0Collapse\"]/div[2]/ul/li[2]/a"));
		new Actions(driver).moveToElement(careers).perform();

		driver.findElement(By.xpath("//*[@id=\"collapseRight1\"]/ul/li[2]/a")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
				
		driver.findElement(By.id("sGlobal")).sendKeys("PESSOA ENGENHEIRA DE DADOS");
		driver.findElement(
				By.xpath("/html/body/div[3]/div[5]/div/div/div/div/div[3]/div/div/div[1]/div[1]/div/div/button"))
				.sendKeys(Keys.ENTER);
		
		WebElement resultado = driver.findElement(By.xpath(
				"/html/body/div[3]/div[5]/div/div/div/div/div[3]/div/div/div[1]/div[2]/div/div/div/div[2]/div/div/div[1]/p"));
		assertTrue(resultado.getText().contains("Resultados"));
	}
}
