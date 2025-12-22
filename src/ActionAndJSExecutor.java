import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionAndJSExecutor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemar\\eclipse-workspace\\SeleniumJava_Anudip\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.anudip.org/login/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement usernameTextField= driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameTextField.sendKeys("AF05038522");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordTextField.sendKeys("hem123");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginButton.click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("(//span[contains(text(),'Core Java')])[1]"));
		Actions a = new Actions(driver);
		a.moveToElement(element1).click().perform();
		WebElement element2 = driver.findElement(By.xpath("(//span[@role='button'])[2]"));
		a.moveToElement(element2).click().perform();
		JavascriptExecutor ref = (JavascriptExecutor)driver;
		WebElement element3 = driver.findElement(By.xpath("//h3[contains(text(),'Flow ')]"));
		ref.executeScript("arguments[0].scrollIntoView(false)", element3);
		Thread.sleep(3000);
		if(element3.isSelected()) {
			element3.clear();
			System.exit(0);
		}
		else {
			ref.executeScript("arguments[0].click()", element3);
			driver.findElement(By.xpath("//span[text()='Day 4- FG (Flow Control)']")).click();
			
		}
			
	}
}
