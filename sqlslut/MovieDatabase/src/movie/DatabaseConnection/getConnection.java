
package movie.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class getConnection {
        public static Connection getConnection() {
        Connection con = null;
        String username="root";  //SQL user name
        String password="123"; //SQL password
        try {
            Class.forName("com.mysql.jdbc.Driver");  //register MySQL JDBC driver
            con = DriverManager.getConnection("jdbc::mysql://localhost:3306/movie", username, password);
        } catch (Exception ae) {
            System.out.println(ae);
        }
        return con;
    }
}

//jdbc:mysql://localhost:3306/movie?autoReconnect=true&useSSL=false    USE THIS TO GET RID OF SSL WARNING
