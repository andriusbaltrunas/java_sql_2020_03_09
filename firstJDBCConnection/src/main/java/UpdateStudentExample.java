import jdbc.JDBCConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Andrius Baltrunas
 */
public class UpdateStudentExample
{
	public static void main(String[] args)
	{
		/**
		 * 1. Sukurti connection object ir iskviesti connection metoda
		 * 2. sukurti statementa
		 * 3. exceutinti statement.execute
		 */

		JDBCConnector connector = new JDBCConnector();
		Connection connect = connector.connect();

		if(connect == null)
		{
			System.out.println("Cannot connect to DB");
		}

		try
		{
			Statement statement = connect.createStatement();
			statement.execute("update students set name='Andrius' where id=1");

		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
