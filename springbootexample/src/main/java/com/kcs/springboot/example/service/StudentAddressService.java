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

	public StudentAddress createStudentAddress(StudentAddress studentAddress, String studentId)
	{
		try
		{
			studentAddress.setStudentId(Integer.parseInt(studentId));
			PreparedStatement prepareStatement = jdbcConnector
					.getPrepareStatement("insert into student_address(student_id, country, city, street, post_code) values(?, ?, ?, ?, ?)");
			prepareStatement.setInt(1, studentAddress.getStudentId());
			prepareStatement.setString(3, studentAddress.getCity());
			prepareStatement.setString(4, studentAddress.getStreet());
			prepareStatement.setString(5, studentAddress.getPostCode());
			prepareStatement.setString(2, studentAddress.getCountry());

			prepareStatement.execute();

			return getStudentAddresses(studentId).stream()
					.filter(a -> a.equals(studentAddress))
					.findFirst()
					.orElse(null);
		}
		catch(SQLException e)
		{

		}

		return null;
	}

	public StudentAddress updateStudentAddress(StudentAddress studentAddress)
	{
		try
		{
			PreparedStatement statement = jdbcConnector.getPrepareStatement("update student_address set country = ?, city = ?, street = ?, post_code = ? where id = ?");
			statement.setString(1, studentAddress.getCountry());
			statement.setString(2, studentAddress.getCity());
			statement.setString(3, studentAddress.getStreet());
			statement.setString(4, studentAddress.getPostCode());
			statement.setInt(5, studentAddress.getId());

			statement.executeUpdate();

			return studentAddress;

		}
		catch(SQLException e)
		{

		}

		return null;
	}

	public void deleteStudentAddress(String addressId, String studentId)
	{
		try
		{
			PreparedStatement prepareStatement = jdbcConnector.getPrepareStatement("delete from student_address where id = ? and student_id = ?");
			prepareStatement.setInt(1, Integer.parseInt(addressId));
			prepareStatement.setInt(2, Integer.parseInt(studentId));

			prepareStatement.execute();
		}
		catch(SQLException e)
		{

		}
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
