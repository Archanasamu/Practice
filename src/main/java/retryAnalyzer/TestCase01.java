package retryAnalyzer;

import org.testng.annotations.Test;

public class TestCase01 {
	
	
	@Test (timeOut=200)
	public void createLead() throws InterruptedException {
		
		long randNum = (long) (Math.random() * 1000);
		System.out.println(randNum);
		Thread.sleep(randNum);
	}

}
