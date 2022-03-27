package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//it will work as spring bean
@Repository("studentdao")
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addStudent() {
		// DML
		String name = "samir";
		int age = 20;
		int res = jdbcTemplate.update("insert into stu(sname,age)values(?,?)", name, age);
		System.out.println("rows affected " + res);
	}

	public void deleteStudent() {

		int id = 1;
		int res = jdbcTemplate.update("delete from stu where sid = ?", id);
		System.out.println(res + " rows deleted..");

	}

	public void updateStudent() {

		int res = jdbcTemplate.update("update stu set age = ? where sid = ?", 50, 2);
	}



}
