package selenium_switchtofun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
		/*
		 * driver.switchTo().frame("SingleFrame");
		 * driver.findElementByXPath("//input[@type='text']").sendKeys("SingleFrame");
		 */
	driver.findElementByXPath("//a[text()='Iframe with in an Iframe']").click();
	WebElement outeriFrame = driver.findElementByXPath("//iframe[@src='MultipleFrames.html']");
	driver.switchTo().frame(outeriFrame);
	WebElement innerFrame = driver.findElementByXPath("(//iframe[normalize-space()='<p>Your browser does not support iframes.</p>'])[1]");
	driver.switchTo().frame(innerFrame);
	driver.findElementByXPath("//input[@type='text']").sendKeys("Archana");
	driver.switchTo().parentFrame();
	}

}
