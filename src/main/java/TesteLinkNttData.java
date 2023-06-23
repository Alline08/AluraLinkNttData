import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TesteLinkNttData {
	
	@Test
	public void teste() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:/Users/afreitad/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		assertEquals("Google", driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("nttdata");
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/div[1]/div/a/h3")).click();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement careers = driver.findElement(By.xpath("//*[@id=\"navbarLevel0Collapse\"]/div[2]/ul/li[2]/a"));
		new Actions(driver)
		.moveToElement(careers)
		.perform();
				
		driver.findElement(By.xpath("//*[@id=\"collapseRight1\"]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("#sGlobal")).sendKeys("PESSOA ENGENHEIRA DE DADOS");
		driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div/div/div[3]/div/div/div[1]/div[1]/div/div/button")).sendKeys(Keys.ENTER);

	}
}
