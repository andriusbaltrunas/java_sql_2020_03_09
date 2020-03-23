package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.service.StudentAddressService;
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
@RequestMapping("/students/{studentId}/address")
public class StudentAddressController
{
	private StudentAddressService studentAddressService;

	@Autowired
	public StudentAddressController(StudentAddressService studentAddressService)
	{
		this.studentAddressService = studentAddressService;
	}

	@GetMapping
	public List<StudentAddress> getStudentAddresses(@PathVariable("studentId") String studentId)
	{
		return studentAddressService.getStudentAddresses(studentId);
	}

	@GetMapping("/{addressId}")
	public StudentAddress getStudentAddress(@PathVariable("studentId") String studentId, @PathVariable("addressId") String addressId)
	{
		return studentAddressService.getStudentAddress(studentId, addressId);
	}
}