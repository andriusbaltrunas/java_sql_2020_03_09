package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.StudentMark;
import com.kcs.springboot.example.service.StudentMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Andrius Baltrunas
 */
@RestController
@RequestMapping("/students/{studentId}/mark")
public class StudentMarkController
{
	private StudentMarkService studentMarkService;

	@Autowired
	public StudentMarkController(StudentMarkService studentMarkService)
	{
		this.studentMarkService = studentMarkService;
	}

	@GetMapping
	public List<StudentMark> getStudentMarks(@PathVariable("studentId") String studentId)
	{
		return studentMarkService.getStudentMarks(studentId);
	}

	@GetMapping("/{studentMarkId}")
	public StudentMark getStudentMark(@PathVariable("studentMarkId") String studentMarkId, @PathVariable("studentId") String studentId)
	{
		return studentMarkService.getStudentMark(studentMarkId, studentId);
	}
}
