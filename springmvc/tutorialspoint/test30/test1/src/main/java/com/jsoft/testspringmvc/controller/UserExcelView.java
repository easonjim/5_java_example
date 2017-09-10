package com.jsoft.testspringmvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class UserExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> userData = (Map<String, String>) model.get("userData");
		// create a wordsheet
		HSSFSheet sheet = workbook.createSheet("User Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Roll No");
		header.createCell(1).setCellValue("Name");

		int rowNum = 1;
		for (Map.Entry<String, String> entry : userData.entrySet()) {
			// create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
		}
	}
}
