import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemar\\eclipse-workspace\\SeleniumJava_Anudip\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/popups/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement simpleAlert = driver.findElement(By.xpath("//button[@id='alert']"));
		simpleAlert.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		for(int i=1;i<=2;i++) {
			if(i==1) {
				WebElement confirmAlert = driver.findElement(By.xpath("//button[@id='confirm']"));
				confirmAlert.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
			}
			else {
				Thread.sleep(2000);
				WebElement confirmAlert = driver.findElement(By.xpath("//button[@id='confirm']"));
				confirmAlert.click();
				Thread.sleep(2000);
				driver.switchTo().alert().dismiss();
			}
		}
		for(int i=0;i<2;i++) {
			if(i==0) {
				Thread.sleep(2000);
				WebElement promptAlert = driver.findElement(By.xpath("//button[@id='prompt']"));
				promptAlert.click();
				Alert ref = driver.switchTo().alert();
				ref.sendKeys("Hema");
				Thread.sleep(5000);
				ref.accept();
				
			}
			else {
				Thread.sleep(5000);
				WebElement promptAlert = driver.findElement(By.xpath("//button[@id='prompt']"));
				promptAlert.click();
				Alert ref= driver.switchTo().alert();
				Thread.sleep(5000);
				ref.dismiss();
			}
		}
	}
}
