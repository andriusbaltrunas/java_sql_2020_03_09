import data.Student;
import jdbc.JDBCConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrius Baltrunas
 */
public class JavaConnector
{
	public static void main(String[] args)
	{
		/**
		 * 1. Suskurti connection
		 * 2. is connection sukurti statement
		 * 3. exexutinti statement
		 */

		List<Student> students = new ArrayList<>();

		try
		{
			//1
			JDBCConnector connector = new JDBCConnector();
			Connection connect = connector.connect();
			if(connect == null)
			{
				return;
			}
			//2
			Statement statement = connect.createStatement();
			//3
			ResultSet resultSet = statement.executeQuery("select * from students");

			while(resultSet.next())
			{
				Student student = new Student(
						resultSet.getInt("id"),
						resultSet.getString("name"),
						resultSet.getString("surname"),
						resultSet.getString("phone"),
						resultSet.getString("email"));

				students.add(student);
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception");
		}

		students.forEach(s -> {
			System.out.println(s.getId());
			System.out.println(s.getName());
		});
	}
}
