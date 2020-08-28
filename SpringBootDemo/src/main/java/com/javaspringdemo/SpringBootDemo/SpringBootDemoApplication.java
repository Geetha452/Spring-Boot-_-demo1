package com.javaspringdemo.SpringBootDemo;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringdemo.SpringBootDemo.Entity.Employee;
import com.javaspringdemo.SpringBootDemo.Service.ReportService;
import com.javaspringdemo.SpringBootDemo.repository.EmployeeRepository;
import com.javaspringdemo.SpringBootDemo.repository.UserRepository;

import net.sf.jasperreports.engine.JRException;

@SpringBootApplication
@RestController
public class SpringBootDemoApplication {

	
	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private ReportService service;
	
	@GetMapping("/getuserdetails")
	public List<Employee> getUserDetails(){
		
		for (Employee record : repository.findAll()) {
		  if(repository.findById(1) != null)
			  System.out.println("true" + repository.findById(1) );
		}
		
		return (List<Employee>) repository.findAll();
	}
	
	@GetMapping("/report/{format}")
	//mentioning format of the report through request url
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return service.exportReport(format);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
