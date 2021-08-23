package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {

	private static final String url = "jdbc:mysql://localhost:3306/trinadhgym";
	private static final String usName = "root";
	private static final String pswd = "Vamsi@123";

	public static Connection getConnection() {
		Connection con = null;
		{
			try {
				con = DriverManager.getConnection(url, usName, pswd);
				System.out.println("Connection established..");
			} catch (SQLException e) {

				System.out.println("connection not established..");
			}

		}

		return con;

	}
	public static void closeResource(Connection connection)
	{
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeResource(PreparedStatement preparedStmnt)
	{
		if(preparedStmnt!=null)
		{
			try {
				preparedStmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeResource(ResultSet rs)
	{
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
