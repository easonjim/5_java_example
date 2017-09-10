package com.jsoft.testspringmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class UserPDFView extends AbstractPdfView {

	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter pdfWriter,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> userData = (Map<String, String>) model.get("userData");

		Table table = new Table(2);
		table.addCell("Roll No");
		table.addCell("Name");

		for (Map.Entry<String, String> entry : userData.entrySet()) {
			table.addCell(entry.getKey());
			table.addCell(entry.getValue());
		}
		document.add(table);
	}
}