package selenium_switchtofun;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Popups {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		// https://username:password@URL
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		// pop-up disable
		
		options.addArguments("--disable-notifications");
		
	}

}
