package webtables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/index.php");
		WebElement username = driver.findElementById("input-username");
		username.clear();
		username.sendKeys("demo");
		WebElement password = driver.findElementById("input-password");
		password.clear();
		password.sendKeys("demo");
		driver.findElementByXPath("//button[@type='submit']").click();
		driver.findElementByXPath("//a[normalize-space()='Sales']").click();
		//Thread.sleep(3000);
		driver.findElementByXPath("/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[5]/ul[1]/li[1]/a[1]").click();
		
		// To get the total number of pages
		String text = driver.findElementByXPath("//div[@class='col-sm-6 text-right']").getText();
		System.out.println(text);
		Integer value = Integer.valueOf(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		System.out.println(value);
		
		// To get the total number of rows in each page
		
		for(int p=1; p<=3;p++) {
			
			WebElement activePage = driver.findElementByXPath("//ul[@class='pagination']/li/span");
			System.out.println("Active Page"+activePage.getText());
			
			int rows = driver.findElementsByXPath("//table[@class='table table-bordered table-hover']/tbody/tr").size();
			System.out.println(rows);
			
			for(int r=1;r<=rows;r++) {
				
				String orderID = driver.findElementByXPath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[2]").getText();
				String customer = driver.findElementByXPath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[3]").getText();
				String status = driver.findElementByXPath("//table[@class='table table-bordered table-hover']/tbody/tr["+r+"]/td[4]").getText();
				
				if(status.contentEquals("Pending")) {
				System.out.println(orderID+"    "+customer+"   "+status);
				}
			}
			
			String pageNo = Integer.toString(p+1);
			driver.findElementByXPath("//ul[@class='pagination']/li/a[text()='"+pageNo+"']").click();
			
		}
		

		
		
	}

}
