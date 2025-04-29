package com.nt.views;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("pdf_view")
public class MyPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//get Model Attribute
		Iterable<Employee> itEmps=(Iterable<Employee>) map.get("empsData");
		
		//add Heading Paragraph to PDF document
		Paragraph  para=new Paragraph("Employee Report", new Font(Font.BOLDITALIC));
		doc.add(para);
		
		Table  table=new Table(5, ((ArrayList)itEmps).size());
		for(Employee emp:itEmps){
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		
		doc.add(table);

	}

}
