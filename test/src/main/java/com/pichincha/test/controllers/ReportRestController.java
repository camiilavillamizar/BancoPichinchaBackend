package com.pichincha.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.test.models.Dtos.services.ReportService;

@RestController()
@RequestMapping("reports")
public class ReportRestController {

	@Autowired
	ReportService reportService; 
	
	@GetMapping("")
	public ResponseEntity getReport(@RequestParam String startDate, @RequestParam String endDate, @RequestParam int clientId) {
		try {
			return ResponseEntity.status(200).body(reportService.getReporByClientBtwnDates(startDate, endDate, clientId)); 
		} catch(Exception e) {
			return ResponseEntity.status(400).body("Bad Request " + e.getMessage()); 
		}
	}
}
