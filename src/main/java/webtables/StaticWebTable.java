package webtables;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTable {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.dezlearn.com/webtable-example/");
		
		//TakesScreenshot ts = driver; 
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/scrsh1.png");
		FileUtils.copyFile(src, dest);
		
		
		//To get the number for rows in a webtable
		
		int rows = driver.findElementsByXPath("//table[@class='tg']/tbody/tr").size();
		System.out.println("Number of rows: "+rows);
		
		//To get the number of columns in a table
		int cols = driver.findElementsByXPath("//table[@class='tg']/tbody/tr/th").size();
		System.out.println("Number of columns: "+ cols);
		
		//specific row data
		
		/*String value = driver.findElementByXPath("//table[@class='tg']/tbody/tr[4]/td[2]").getText();
		System.out.println(value);
		*/
		// To get all datas in the table
		for(int r=2;r<=rows;r++) {
			for(int c=1;c<=cols;c++) {
				
				String data = driver.findElementByXPath("//table[@class='tg']/tbody/tr["+r+"]/td["+c+"]").getText();
				System.out.println(data+"   ");
			}
			System.out.println();
		}
		
		// To get condition data
		
		for(int r=2;r<=rows;r++) {
			String name = driver.findElementByXPath("//table[@class='tg']/tbody/tr["+r+"]/td[1]").getText();
			if(name.equals("Monica Singh")) {
				String email = driver.findElementByXPath("//table[@class='tg']/tbody/tr["+r+"]/td[2]").getText();
				System.out.println(email);
			}
		}
		
		
		
		driver.close();
		
	}

}
