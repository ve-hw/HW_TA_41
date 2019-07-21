package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.*;
import org.openqa.selenium.support.ui.*;

public class Safari {
	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);

		WebDriver driver;
		driver = new SafariDriver();
		driver.manage().window().maximize();

		System.out.println("Browser is: Safari");
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Title: " + driver.getTitle());
		String copyright = driver.findElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span")).getText();
		System.out.println("Copyright: " + copyright);
		driver.findElement(By.id("email")).sendKeys("vladimir.hfs@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("********");
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\'u_0_a\']/div[1]/div[1]/div/a")).click();
		Thread.sleep(7000);
		String friends = driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getText();
		System.out.println("You have " + friends + " friends");
		Thread.sleep(3000);
		driver.findElement(By.id("userNavigationLabel")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		logout.click();
		driver.quit();

	}

}
