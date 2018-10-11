package com.sen.AmortizationGradleService.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sen.AmortizationGradleService.model.LoanBalanceData;
import com.sen.AmortizationGradleService.service.AmortizationService;

@RestController
public class AmortizationController {
	@CrossOrigin
	@RequestMapping(value="/loan/")
	public ResponseEntity<List<LoanBalanceData>> fetchAmortizationSchedule(@RequestParam(value="principle", required=true) Double principle, 
			@RequestParam(value="interest", required=true) Double interest,@RequestParam(value="term", required=true) Integer term){
		AmortizationService amortizatonService = new AmortizationService();
		List<LoanBalanceData> loanBalanceList = amortizatonService.calculateNewBalanceForEveryYear(principle, interest ,term);;
		return new ResponseEntity<List<LoanBalanceData>>(loanBalanceList , HttpStatus.OK);
	}
}
