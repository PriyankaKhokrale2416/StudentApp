package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Student;

public interface StudentService {
	
	public Student addStudent(Student st);
	public Optional<Student> getStudentDetails(int id);
	public List<Student> showStudents();
	public void deleteStudent(Student st);
	public List<Student> updateStudent(Student st);
	public List<Student> updateAllStudents(List<Student> students);
	public List<Student> getAllStudentsDetailsByIds(List<Integer> ids);
	
	
	

}
