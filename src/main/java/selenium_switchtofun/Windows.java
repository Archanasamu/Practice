package selenium_switchtofun;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.findElementByXPath("//a[text()='Open Seperate Multiple Windows']").click();
		driver.findElementByXPath("//button[@onclick='multiwindow()']").click();
		Set<String> allWindows = driver.getWindowHandles();
		
		List<String> windowList = new ArrayList(allWindows);
		String defaultWindow = windowList.get(0);
		String parentWindow = windowList.get(1);
		String childWindow = windowList.get(2);
		driver.switchTo().window(defaultWindow);
		System.out.println("DefaultTitle: " + driver.getTitle());
		
		driver.switchTo().window(parentWindow);
		System.out.println("ParentTitle: " + driver.getTitle());
		
		driver.switchTo().window(childWindow);
		System.out.println("ChildTitle: " + driver.getTitle());
	}
	

}
