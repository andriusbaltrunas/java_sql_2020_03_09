package com.kcs.springboot.example.service;

import com.kcs.springboot.example.data.StudentMark;
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
public class StudentMarkService
{
	private JDBCConnector jdbcConnector;

	@Autowired
	public StudentMarkService(JDBCConnector jdbcConnector)
	{
		this.jdbcConnector = jdbcConnector;
	}

	public List<StudentMark> getStudentMarks(String studentId)
	{
		List<StudentMark> studentMarks = new ArrayList<>();
		try
		{
			PreparedStatement prepareStatement = jdbcConnector.getPrepareStatement("select * from student_marks where student_id = ?");
			prepareStatement.setInt(1, Integer.parseInt(studentId));

			ResultSet resultSet = prepareStatement.executeQuery();

			while(resultSet.next())
			{
				studentMarks.add(convertToStudentMark(resultSet));
			}
		}
		catch(SQLException e)
		{
		}

		return studentMarks;
	}

	public StudentMark getStudentMark(String studentMarkId, String studentId)
	{
		try
		{
			PreparedStatement prepareStatement = jdbcConnector.getPrepareStatement("select * from student_marks where id = ? and student_id = ?");
			prepareStatement.setInt(1, Integer.parseInt(studentMarkId));
			prepareStatement.setInt(2, Integer.parseInt(studentId));

			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();

			return convertToStudentMark(resultSet);
		}
		catch(SQLException e)
		{

		}

		return null;
	}

	private StudentMark convertToStudentMark(ResultSet resultSet) throws SQLException
	{
		return new StudentMark(resultSet.getInt("id"),
							   resultSet.getInt("student_id"),
							   resultSet.getString("title"),
							   resultSet.getInt("mark"),
							   resultSet.getDate("time_stamp"));
	}
}
