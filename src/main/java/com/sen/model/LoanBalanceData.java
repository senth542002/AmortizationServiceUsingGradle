package com.sen.model;

public class LoanBalanceData {
	private Double monthlyPayment;
	private Double monthlyInterest;
	private Double monthlyPrinciple;
	private Double outstandingPrinciple;
	private Integer numberOfTermsLeft;
	
	
	
	public LoanBalanceData(Double monthlyPayment, Double monthlyInterest, Double monthlyPrinciple,
			Double outstandingPrinciple, Integer numberOfTermsLeft) {
		this.monthlyPayment = monthlyPayment;
		this.monthlyInterest = monthlyInterest;
		this.monthlyPrinciple = monthlyPrinciple;
		this.outstandingPrinciple = outstandingPrinciple;
		this.numberOfTermsLeft = numberOfTermsLeft;
	}
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public Double getMonthlyInterest() {
		return monthlyInterest;
	}
	public void setMonthlyInterest(Double monthlyInterest) {
		this.monthlyInterest = monthlyInterest;
	}
	public Double getMonthlyPrinciple() {
		return monthlyPrinciple;
	}
	public void setMonthlyPrinciple(Double monthlyPrinciple) {
		this.monthlyPrinciple = monthlyPrinciple;
	}
	public Double getOutstandingPrinciple() {
		return outstandingPrinciple;
	}
	public void setOutstandingPrinciple(Double outstandingPrinciple) {
		this.outstandingPrinciple = outstandingPrinciple;
	}
	public Integer getNumberOfTermsLeft() {
		return numberOfTermsLeft;
	}
	public void setNumberOfTermsLeft(Integer numberOfTermsLeft) {
		this.numberOfTermsLeft = numberOfTermsLeft;
	}
	
}
