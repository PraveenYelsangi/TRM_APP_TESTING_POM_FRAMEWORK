package com.tvd.trm.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


//RetryAnalyzer for to retry failed testcase given upto retrylimit
public class RetryAnalyzer implements IRetryAnalyzer{

	
	int counter = 0;
	int retryLimit = 2;
	
	public boolean retry(ITestResult result){
		if(counter < retryLimit){
			System.out.println("Retrying " + result.getName() + " with status " +getResultStatus(result.getStatus()) +   " again and the count is " + (retryLimit+1));
			counter++;
			return true;
		}
		return false;
	}
	
	public String getResultStatus(int status){
		String resultname= null;
		if(status == 1)
			resultname ="SUCCESS";
		if(status == 2)
			resultname ="FAILURE";
		if(status == 3)
			resultname ="SKIP";
		return resultname;
		
	}
	
	
	
}