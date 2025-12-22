import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectAndScreenshot {

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemar\\eclipse-workspace\\SeleniumJava_Anudip\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.anudip.org/login/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement usernameTextField= driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameTextField.sendKeys("AF05038522");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordTextField.sendKeys("hem123");
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginButton.click();
		WebElement calendarIcon = driver.findElement(By.xpath("//li[@data-key='calendar']"));
		Actions a = new Actions(driver);	
		Thread.sleep(3000);
		a.moveToElement(calendarIcon).click().perform();
		WebElement selectCourse= driver.findElement(By.id("course"));
		Select sl = new Select(selectCourse);
		sl.selectByContainsVisibleText("Aptitude Prep");
		Thread.sleep(2000);
		WebElement createNewEvent = driver.findElement(By.xpath("//button[contains(text(),'New')]"));
		a.moveToElement(createNewEvent).click().perform();
		WebElement nameOftheEvent = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		nameOftheEvent.sendKeys("Problems on trains MCQ");
		Thread.sleep(1000);
		WebElement startDay = driver.findElement(By.xpath("//select[@id='id_timestart_day']"));
		Select sd = new Select(startDay);
		sd.selectByValue("17");
		WebElement month = driver.findElement(By.xpath("//select[@id='id_timestart_month']"));
		Select sm = new Select(month);
		sm.selectByContainsVisibleText("Jan");
		WebElement year = driver.findElement(By.xpath("//select[@name='timestart[year]']"));
		Select sy = new Select(year);
		sy.selectByVisibleText("2026");
		TakesScreenshot tk = (TakesScreenshot)driver;
		WebElement hours = driver.findElement(By.id("id_timestart_hour"));
		Select h = new Select(hours);
		h.selectByValue("12");
		WebElement min = driver.findElement(By.name("timestart[minute]"));
		Select m = new Select(min);
		m.selectByVisibleText("00");
		for(int i=0;i<2;i++) {
			Thread.sleep(3000);
			File src = tk.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\hemar\\eclipse-workspace\\SeleniumJava_Anudip\\Screenshots\\"+i+".png");
			FileUtils.copyFile(src, dest);
			if(i==1) {
				break;
			}
			else {
				driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			Thread.sleep(2000);
			WebElement nextMonth = driver.findElement(By.xpath("//span[text()='January 2026']"));
			a.moveToElement(nextMonth).click().perform();
			
			}
		}
	}
}

