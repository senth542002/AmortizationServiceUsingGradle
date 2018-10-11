package com.sen.AmortizationGradleService.model;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class LoanBalanceDataSpec {
	
	private LoanBalanceData loanBalancedata;


	@Test
	public void verifiesTheInterestValue() {
		loanBalancedata = new LoanBalanceData(40000.0, 9.5, 30000.0, 3000000.0, 113); 
		Assert.assertTrue(9.5==loanBalancedata.getMonthlyInterest());
	}

}
