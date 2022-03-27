package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.StudentBean;
import com.config.SpringConfig;
import com.dao.StudentDao;
import com.dao.StudentDao1;

public class StudentController1 {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		StudentDao1 studentDao1 = ctx.getBean("studentdao1", StudentDao1.class);

		int choice = 0;
		do {
			System.out.println("pls press 1 for insert data");
			System.out.println("pls press 2 for delete data");
			System.out.println("pls press 3 for update data");
			System.out.println("pls press 4 for view data");
			System.out.println("pls enter your choice ::: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				StudentBean studentBean = new StudentBean();
				studentBean.setsName("jay");
				studentBean.setsAge(28);

				if (studentDao1.addStudent(studentBean)) {

					System.out.println("record inserted...");
				} else {

					System.out.println("record not inserted...");
				}

				break;
			case 2:
				System.out.println("pls enter id");
				int id = sc.nextInt();
				int res = studentDao1.deleteStudent(id);
				if (res > 0) {
					System.out.println("record deleted");
				} else {

					System.out.println("record not not deleted,..");
				}
				break;
				
			case 3:
				
					//List<StudentBean> sti = new ArrayList<StudentBean>();
					List<StudentBean> list =  studentDao1.getAllStudents();
					for(StudentBean studentBean2 :list) {
						
						System.out.println(studentBean2.getsId()+"--"+studentBean2.getsName()+"--"+studentBean2.getsAge());
					}
				
				break;

			}// switch over....

		} while (choice != 5);

	}
}
