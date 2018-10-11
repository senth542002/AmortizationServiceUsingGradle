package com.sen.AmortizationGradleService.service;

import java.util.ArrayList;
import java.util.List;

import com.sen.AmortizationGradleService.model.LoanBalanceData;

public class AmortizationService {
	
	public double calculateMonthlyInterest(Double annualInterest) {
		
		return (Math.exp((0.08333) * (Math.log(1+annualInterest)))-1);
	}

	public Double calculateMonthlyPaymentFor(Double principle, double monthlyInterest, int numberOfPayments) {
		return ((principle * monthlyInterest) / (1 - (Math.exp(-numberOfPayments * Math.log(1 + monthlyInterest)))));
	}

	public List<LoanBalanceData> calculateNewBalanceForEveryYear(Double principle, Double yearlyInterest, int numberOfPayments) {
		yearlyInterest = yearlyInterest/100;
		Double newPrinciple = principle;
		Double monthlyInterestRate = calculateMonthlyInterest(yearlyInterest);
		List<LoanBalanceData> loanBalancePerYear = new ArrayList<LoanBalanceData>();
		
		while(numberOfPayments > 0) {
			
			Double monthlyPayment = calculateMonthlyPaymentFor(newPrinciple, monthlyInterestRate, numberOfPayments);
			
			Double monthlyInterestPaid = calculateMonthlyInterestPaid(newPrinciple, monthlyInterestRate);
			
			Double monthlyPrinciplePaid = calculateMonthlyPrinciplePaid(monthlyPayment, monthlyInterestPaid);
			
			if(numberOfPayments <= 1) {
				monthlyPayment = monthlyInterestPaid + newPrinciple;
				monthlyPrinciplePaid = newPrinciple;
			}
			
			newPrinciple = newPrinciple - monthlyPrinciplePaid;
			
			
			numberOfPayments = numberOfPayments -1;
			
			LoanBalanceData loanBalance = new LoanBalanceData(this.roundOff(monthlyPayment), this.roundOff(monthlyInterestPaid), this.roundOff(monthlyPrinciplePaid), this.roundOff(newPrinciple), numberOfPayments);
			
				System.out.print(" Monthly Payment: "+ monthlyPayment);
				System.out.print(" Monthly Interest Paid: "+ monthlyInterestPaid);
				System.out.print(" Monthly Principle Paid: "+ monthlyPrinciplePaid);
				System.out.print(" Balance Principle: "+ newPrinciple);
				System.out.println(" Number of payments left: "+numberOfPayments);
				System.out.println();
				loanBalancePerYear.add(loanBalance);
		}
		return loanBalancePerYear;
	}
	
	private Double roundOff(Double value){
		return Math.round(value*100)/100D;
	}
	
	private Double calculateMonthlyPrinciplePaid(Double monthlyPayment, Double monthlyInterestPaid) {
		Double monthlyPrinciplePaid = monthlyPayment - monthlyInterestPaid;
		return monthlyPrinciplePaid;
	}

	private Double calculateMonthlyInterestPaid(Double principle, Double monthlyInterestRate) {
		Double monthlyInterestPaid = principle * monthlyInterestRate;
		return monthlyInterestPaid;
	}

}
