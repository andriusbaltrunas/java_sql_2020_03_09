package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping("/students")
public class StudentController
{
	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService)
	{
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents()
	{
		return studentService.getStudents();
	}

	@GetMapping("/{studentId}")
	public Student getStudents(@PathVariable("studentId") String studentId)
	{
		return studentService.getStudent(studentId);
	}

	@PostMapping("/save")
	public Student save(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}

	@DeleteMapping("/{studentId}/delete")
	public void deleteStudent(@PathVariable("studentId") String studentId)
	{
		studentService.deleteStudent(studentId);
	}

	@PutMapping("/{studentId}/update")
	public Student updateStudent(@PathVariable("studentId") String studentId, @RequestBody Student student)
	{
		student.setId(Integer.parseInt(studentId));
		return studentService.updateStudent(student);
	}
}
