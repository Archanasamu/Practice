package selenium_switchtofun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Aletrs {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// with ok button
		/* driver.findElementByXPath("//button[@class='btn btn-danger']").click();
		 * driver.switchTo().alert().accept(); Thread.sleep(3000);
		 * System.out.println("Accepted");
		 */
		// with cancel and ok button
		/*
		 * driver.findElementByXPath("//a[text()='Alert with OK & Cancel ']").click();
		 * driver.findElementByXPath("//button[@class='btn btn-primary']").click();
		 * driver.switchTo().alert().dismiss();
		 */
		
		// with input box
		
		driver.findElementByXPath("(//a[@class='analystic'])[3]").click();
		driver.findElementByXPath("//button[text()='click the button to demonstrate the prompt box ']").click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Archana");
		alert.accept();
		
		
		
	}
}
