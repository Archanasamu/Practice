package retryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer {
	int maxtry=3;
	int count=0;
	public boolean retry(ITestResult result) {
		if(!result.isSuccess() && count<maxtry )
		{
			count++;
			return true;
		}
		
		return false;
	}

}
