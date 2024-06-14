package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Student;
import com.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService stuService;
	
	@GetMapping(value="/getStudents")
	public ResponseEntity<List<Student>> getStudents()
	{
		List<Student> stuList = stuService.showStudents();
		
		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getAllStudentsByIds")
	public ResponseEntity<List<Student>> getAllStudentsByIds(List<Integer> ids)
	{
		List<Student> stuList = stuService.getAllStudentsDetailsByIds(ids);		
		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student st)
	{
		Student stu = stuService.addStudent(st);
		
		return new ResponseEntity<Student>(stu, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getStudent/{id1}")
	public ResponseEntity<Optional<Student>> getSingleStudent(@PathVariable("id1") int id)
	{
		Optional<Student> stu = stuService.getStudentDetails(id);
		
		return new ResponseEntity<Optional<Student>>(stu, HttpStatus.OK);
		
	}
	
	
	@PutMapping(value="/updateStu")
	public ResponseEntity<List<Student>> updateStu(@RequestBody Student st)
	{
		
		stuService.updateStudent(st);
		List<Student> stuList = stuService.showStudents();

		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updateAllStudents")
	public ResponseEntity<List<Student>> updateAllStudents(@RequestBody List<Student> stuList)
	{
		
		stuService.updateAllStudents(stuList);
		List<Student> studentsList = stuService.showStudents();

		return new ResponseEntity<List<Student>>(studentsList, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/deleteStu")
	public ResponseEntity<List<Student>> deleteStu(@RequestBody Student st)
	{
		
		stuService.deleteStudent(st);
		List<Student> stuList = stuService.showStudents();

		return new ResponseEntity<List<Student>>(stuList, HttpStatus.OK);
		
	}
	
	
	
	

}
