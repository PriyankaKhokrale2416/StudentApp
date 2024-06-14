package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student addStudent(Student st) {
		// TODO Auto-generated method stub
		
		return studentDao.save(st);
	}

	@Override
	public Optional<Student> getStudentDetails(int id) {
		// TODO Auto-generated method stub
		Optional<Student> st = studentDao.findById(id);
		return st;
	}

	@Override
	public List<Student> showStudents() {
		// TODO Auto-generated method stub
		List<Student> stuList = studentDao.findAll();
		return stuList;
	}

	@Override
	public void deleteStudent(Student st) {
		// TODO Auto-generated method stub
		studentDao.delete(st);
	}

	@Override
	public List<Student> updateStudent(Student st) {
		// TODO Auto-generated method stub
		studentDao.save(st);
		return studentDao.findAll();
	}

	@Override
	public List<Student> updateAllStudents(List<Student> students) {
		// TODO Auto-generated method stub
		List<Student> stuList = studentDao.saveAll(students);
		return stuList;
	}

	@Override
	public List<Student> getAllStudentsDetailsByIds(List<Integer> ids) {
		List<Student> studentsList = studentDao.findAllById(ids);
		return studentsList;
	}

}
