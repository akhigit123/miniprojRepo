package org.proj.export;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.proj.bindings.response.InsurancePlanResponse;

public class ExcelGenerator {
	public void export(List<InsurancePlanResponse> plans, HttpServletResponse res) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet worksheet = workbook.createSheet();
		XSSFRow headerRow = worksheet.createRow(0);
		headerRow.createCell(0).setCellValue("plan_id");
		headerRow.createCell(1).setCellValue("plan_name");
		headerRow.createCell(0).setCellValue("plan_holderName");
		headerRow.createCell(0).setCellValue("plan_HolderSsn");
		headerRow.createCell(0).setCellValue("plan_Status");

		for (int i = 0; i < plans.size(); i++) {
			InsurancePlanResponse planres = plans.get(i);
			XSSFRow dataRow = worksheet.createRow(i + 1);
			dataRow.createCell(0).setCellValue(planres.getPlanId());
			dataRow.createCell(1).setCellValue(planres.getPlanName());
			dataRow.createCell(2).setCellValue(planres.getHolderName());
			dataRow.createCell(3).setCellValue(planres.getHolderSsn());
			dataRow.createCell(4).setCellValue(planres.getPlanStatus());
		}
		ServletOutputStream out = res.getOutputStream();
		workbook.write(out);
		workbook.close();
		out.close();
	}
}
