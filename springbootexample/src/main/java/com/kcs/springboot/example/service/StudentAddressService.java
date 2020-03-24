package com.kcs.springboot.example.service;

import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.jdbc.JDBCConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrius Baltrunas
 */
@Service
public class StudentAddressService
{
	private JDBCConnector jdbcConnector;

	@Autowired
	public StudentAddressService(JDBCConnector jdbcConnector)
	{
		this.jdbcConnector = jdbcConnector;
	}

	public List<StudentAddress> getStudentAddresses(String studentId)
	{
		List<StudentAddress> studentAddresses = new ArrayList<>();

		try
		{
			PreparedStatement preparedStatement = jdbcConnector.getPrepareStatement("select * from student_address where student_id = ?");
			preparedStatement.setInt(1, Integer.parseInt(studentId));

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				studentAddresses.add(convertToStudentAddress(resultSet));
			}
		}
		catch(SQLException e)
		{

		}

		return studentAddresses;
	}

	public StudentAddress getStudentAddress(String studentId, String addressId)
	{
		try
		{
			PreparedStatement preparedStatement = jdbcConnector.getPrepareStatement("select * from student_address where student_id = ? and id = ?");
			preparedStatement.setInt(1, Integer.parseInt(studentId));
			preparedStatement.setInt(2, Integer.parseInt(addressId));
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			return convertToStudentAddress(resultSet);
		}
		catch(SQLException e)
		{

		}
		return null;
	}

	private StudentAddress convertToStudentAddress(ResultSet resultSet) throws SQLException
	{
		return new StudentAddress(resultSet.getInt("id"),
								  resultSet.getInt("student_id"),
								  resultSet.getString("country"),
								  resultSet.getString("city"),
								  resultSet.getString("street"),
								  resultSet.getString("post_code"));
	}
}
