package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository("studentdao1")
public class StudentDao1 {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean addStudent(StudentBean studentBean) {

		boolean flag = false;
		int res = jdbcTemplate.update("insert into stu (sname,age)values(?,?)", studentBean.getsName(),
				studentBean.getsAge());
		if (res > 0) {

			flag = true;
		}

		return flag;
	}

//	public boolean delete(int id) {
//
//		boolean flag = false;
//
//		int res = jdbcTemplate.update("delete from stu where sid = ?", id);
//		if (res > 0) {
//
//			flag = true;
//		}
//
//		return flag;
//
//	}

	// 1
	// 0

	private final static class StduentMapper implements RowMapper<StudentBean> {

		@Override
		public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			StudentBean studentBean = new StudentBean();
			studentBean.setsId(rs.getInt("sid"));
			studentBean.setsName(rs.getString("sname"));
			studentBean.setsAge(rs.getInt("age"));
			return studentBean;
		}

	}

	public List<StudentBean> getAllStudents() {

		// StduentMapper stduentMapper = new StduentMapper();
		// List<StudentBean> list = new ArrayList<StudentBean>();
		List<StudentBean> studentlist = jdbcTemplate.query("select * from stu", new StduentMapper());

		return studentlist;
	}

	public int deleteStudent(int id) {

		return jdbcTemplate.update("delete from stu where sid = ?", id);
	}

}
