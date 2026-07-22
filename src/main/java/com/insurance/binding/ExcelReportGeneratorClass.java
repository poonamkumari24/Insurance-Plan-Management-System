package com.insurance.binding;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelReportGeneratorClass {

	public void exportExcelSheet(List<PlanResponse> planResponses, HttpServletResponse httpServletResponse) throws IOException  {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Insurence Plans");
		
		XSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("Plan ID");
		headerRow.createCell(1).setCellValue("Holder name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Benefit Amount");
		
		for(int i=0; i<planResponses.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);
			
			row.createCell(0).setCellValue(planResponses.get(i).getPlanId());
			row.createCell(1).setCellValue(planResponses.get(i).getPlanHolderName());
			row.createCell(2).setCellValue(planResponses.get(i).getPlanName());
			row.createCell(3).setCellValue(planResponses.get(i).getPlanStatus());
			row.createCell(4).setCellValue(planResponses.get(i).getPlanBenefitAmount());
		}
		
		ServletOutputStream outputStream = httpServletResponse.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
