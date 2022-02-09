package org.proj.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.proj.bindings.request.InsuranceBindingRequest;
import org.proj.bindings.response.InsurancePlanResponse;
import org.proj.export.ExcelGenerator;
import org.proj.export.PdfGenerator;
import org.proj.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsurancePlansController {

	@Autowired
	private InsuranceService service;

	@GetMapping("/excel")
	public void generateExcelreport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		DateFormat datformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = datformat.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=plansExcel.xlsx";
		response.setHeader(headerKey, headerValue);
		List<InsurancePlanResponse> listres = service.searchplans(null);
		ExcelGenerator report = new ExcelGenerator();
		report.export(listres, response);
	}
	@GetMapping("/pdf")
	public void generateReportreport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		DateFormat datformat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = datformat.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=plansReport.pdf";
		response.setHeader(headerKey, headerValue);
		List<InsurancePlanResponse> listres = service.searchplans(null);
		PdfGenerator report = new PdfGenerator();
		report.pdfExport(listres, response);
	}

	@PostMapping("/searchdetails")
	public ResponseEntity<List<InsurancePlanResponse>> getDetailsByplans(@RequestBody InsuranceBindingRequest request) {
		List<InsurancePlanResponse> searchplans = service.searchplans(request);
		return new ResponseEntity<>(searchplans, HttpStatus.OK);
	}

	@GetMapping("/getplans")
	public ResponseEntity<List<String>> getPlanNames() {
		List<String> getuniquePlans = service.getuniquePlans();
		return new ResponseEntity<>(getuniquePlans, HttpStatus.OK);
	}

	@GetMapping("/getstatus")
	public ResponseEntity<List<String>> getPlanStatus() {
		List<String> getuniquePlanStatus = service.getuniquestatus();
		return new ResponseEntity<>(getuniquePlanStatus, HttpStatus.OK);
	}
}
