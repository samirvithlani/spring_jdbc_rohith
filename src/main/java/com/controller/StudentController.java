package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.SpringConfig;
import com.dao.StudentDao;

public class StudentController {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		StudentDao studentDao = ctx.getBean("studentdao", StudentDao.class);
		//studentDao.addStudent();
		//studentDao.deleteStudent();
		studentDao.updateStudent();

	}
}
