package com.javaspringdemo.SpringBootDemo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.javaspringdemo.SpringBootDemo.Entity.Employee;
import com.javaspringdemo.SpringBootDemo.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;

@Service
public class ReportService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		String path = "C:\\";
		List<Employee> employees = repository.findAll();
		//loading the file and compile it
		File file = ResourceUtils.getFile("classpath:users.jrxml");
		JasperDesign jasperDesign; 		
		System.out.println(file.getAbsolutePath());
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		//Get the data resource and map it to the object(Employee)
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
		Map<String,Object> parameters = new HashMap<String, Object>();
		parameters.put("CreatedBy", "Geetha");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		System.out.println("koo" + jasperReport.toString());
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "UserDetails.html");
		} 
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path +"UserDetails.pdf");
		}
		//Report format conditions
		return "Report generated in the path: "+ path;
				
				
				
	}

}
