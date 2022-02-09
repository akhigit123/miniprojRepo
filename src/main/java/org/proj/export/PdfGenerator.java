package org.proj.export;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.proj.bindings.response.InsurancePlanResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {
	public void pdfExport(List<InsurancePlanResponse> plans, HttpServletResponse response) throws Exception {

		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();

		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(16);
		font.setColor(Color.green);

		Paragraph p = new Paragraph("PlanNamesList", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(150f);
		table.setWidths(new float[] { 1.5f, 2.0f, 3.0f, 2.5f, 2.5f });
		table.setSpacingBefore(10f);
		 
		PdfPCell cell=new PdfPCell();
		cell.setBackgroundColor(Color.cyan);
		cell.setPadding(5);
		Font font1=FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("plan_id",font1));
		 table.addCell(cell);
		
		 cell.setPhrase(new Phrase("plan_name",font1));
		 table.addCell(cell);
		 
		 cell.setPhrase(new Phrase("plan_holdername",font1));
		 table.addCell(cell);
		  
		 cell.setPhrase(new Phrase("plan_holderssn",font1));
		 table.addCell(cell);
		 
		 cell.setPhrase(new Phrase("plan_status",font1));
		 table.addCell(cell);
		for(InsurancePlanResponse plan:plans) {
			table.addCell(plan.getPlanId()+"");
			table.addCell(plan.getPlanName());
			table.addCell(plan.getHolderName());
			table.addCell(plan.getHolderSsn()+"");
			table.addCell(plan.getPlanStatus());
		}
		doc.add(cell);
		doc.close();
		
		
		
	}
}
