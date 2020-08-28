package com.javaspringdemo.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringdemo.SpringBootDemo.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
