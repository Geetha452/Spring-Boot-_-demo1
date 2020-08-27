package com.javaspringdemo.SpringBootDemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class UserRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	public List<String> getAllUsers() {
		// TODO Auto-generated method stub
		
		List<String> userList = new ArrayList<String>();
		userList.addAll(jdbcTemplate.queryForList("select empname from users_table;", String.class));
				return userList;
	}

}
