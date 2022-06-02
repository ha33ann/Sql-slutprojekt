package movie.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseHelper {
	public static String driver = "jdbc";
	public static String dbType = "mysql";
	public static String server = "localhost";
	public static int portNo = 3306;
	
	public static Connection DbConnect(String database) {
		String constr = driver + ":" + 
				dbType + "://" + 
				server +  ":" + portNo +
				 "/" + database;
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(constr, "root", "123");
		} catch (SQLException e) {
			System.out.println("Database can not be connected");
			e.printStackTrace();
		}

		return conn;
		
	}
}

/* om du får SSL varnings kod så skriv såhär istället:
try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie?autoReconnect=true&useSSL=false", "root", "123");
		} catch (SQLException e) {
			System.out.println("Database can not be connected");
			e.printStackTrace();
		}
		
root och 123 ska vara ditt användarnamn och ditt lösenord!
*/
